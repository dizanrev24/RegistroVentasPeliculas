package com.example.registropelis.fragments;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.registropelis.Entidades.VerPeliculas;
import com.example.registropelis.OpenHelper.ConexionSQliteHelper;
import com.example.registropelis.OpenHelper.Utilidades;
import com.example.registropelis.R;
import com.example.registropelis.adaptores.Adaptador_VerPelicula;

import java.util.ArrayList;


public class Ver_Registro_Peliculas extends Fragment {

    ArrayList<VerPeliculas> listaDatos ;
    RecyclerView recyclerView;

    ConexionSQliteHelper conn;
    public Ver_Registro_Peliculas() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ver__registro__peliculas, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        conn = new ConexionSQliteHelper(getContext(),"Pelis.db",null,1);
        //listaDatos = new ArrayList<Contacto>();

        recyclerView= (RecyclerView) getActivity().findViewById(R.id.Recycler_verPeliculas);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));

        consultarListaPersonas();

        Adaptador_VerPelicula adapter = new Adaptador_VerPelicula(listaDatos);

        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView id;
                id = (TextView) view.findViewById(R.id.VerPelicula_posicion);
                String textoID = id.getText().toString();
                int pos = Integer.parseInt(textoID);
                String ID;
                String nombre ;
                String codigo;
                String precio;
                String existencia;


                //listaDatos.get(get)

                ID= listaDatos.get(pos).getId().toString();
                codigo= listaDatos.get(pos).getCodigo();
                nombre= listaDatos.get(pos).getNombre();
                precio= listaDatos.get(pos).getPrecio();
                existencia= listaDatos.get(pos).getExistencia();


                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.MostrarFragmentos,new VerDetalles_peliculas(ID,codigo,nombre,precio,existencia)).commit();

            }
        });
        recyclerView.setAdapter(adapter);

    }

    private void consultarListaPersonas() {
        SQLiteDatabase db = conn.getReadableDatabase();

        listaDatos= new ArrayList<VerPeliculas>();
        VerPeliculas verPeliculas;

        Cursor cursor = db.rawQuery("SELECT * FROM "+ Utilidades.TABLE_NAME_REGISTROPELIS,null);

        while (cursor.moveToNext()){
            verPeliculas = new VerPeliculas();

            verPeliculas.setId(cursor.getInt(0));
            verPeliculas.setCodigo(cursor.getString(1));
            verPeliculas.setNombre(cursor.getString(2));
            verPeliculas.setPrecio(cursor.getString(3));
            verPeliculas.setExistencia(cursor.getString(4));

            listaDatos.add(verPeliculas);

        }

    }
 }



