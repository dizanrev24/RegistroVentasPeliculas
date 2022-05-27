package com.example.registropelis.fragments;

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
import android.widget.TextView;

import com.example.registropelis.Entidades.VerPeliculas;
import com.example.registropelis.Entidades.VerRegistros;
import com.example.registropelis.OpenHelper.ConexionSQliteHelper;
import com.example.registropelis.OpenHelper.Utilidades;
import com.example.registropelis.R;
import com.example.registropelis.adaptores.Adaptador_VerPelicula;
import com.example.registropelis.adaptores.Adaptador_VerRegistros;

import java.util.ArrayList;


public class Ver_Registro_Ventas extends Fragment {

    ArrayList<VerRegistros> listaDatos = new ArrayList<VerRegistros>();
    RecyclerView recyclerView;
    ConexionSQliteHelper conn;

    public Ver_Registro_Ventas() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ver__registro__ventas, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        conn = new ConexionSQliteHelper(getContext(),"Pelis.db",null,1);
        //listaDatos = new ArrayList<Contacto>();

        recyclerView= (RecyclerView) getActivity().findViewById(R.id.Recycler_verVentas);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));

        consultarListaPersonas();

        Adaptador_VerRegistros adapter = new Adaptador_VerRegistros(listaDatos);

        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView id;
                id = (TextView) view.findViewById(R.id.VerRegistros_posicion);
                String textoID = id.getText().toString();
                int pos = Integer.parseInt(textoID);
                String ID;
                String correo;
                String nombre ;
                String apellido;
                String direccion;
                String telefono;
                String pelicula;
                String cantidad;
                String precio;

                //listaDatos.get(get)

                ID= listaDatos.get(pos).getId().toString();
                correo= listaDatos.get(pos).getCorreor_R();
                nombre= listaDatos.get(pos).getNombrer_R();
                apellido= listaDatos.get(pos).getApellidor_R();
                direccion= listaDatos.get(pos).getDireccion_R();
                telefono= listaDatos.get(pos).getTelefono_R();
                pelicula= listaDatos.get(pos).getNombrepelicula_R();
                cantidad= listaDatos.get(pos).getCantidadvendida_R();
                precio= listaDatos.get(pos).getPrecio_R();


                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.MostrarFragmentos,new VerDetalles_ventas(ID,correo,nombre,apellido,direccion, telefono, pelicula, cantidad, precio)).commit();

            }
        });
        recyclerView.setAdapter(adapter);

    }

    private void consultarListaPersonas() {
        SQLiteDatabase db = conn.getReadableDatabase();

        listaDatos= new ArrayList<VerRegistros>();
        VerRegistros verRegistro;

        Cursor cursor = db.rawQuery("SELECT * FROM "+ Utilidades.TABLE_NAME_VENTAS,null);

        while (cursor.moveToNext()){
            verRegistro = new VerRegistros();

            verRegistro.setId(cursor.getInt(0));
            verRegistro.setCorreor_R(cursor.getString(1));
            verRegistro.setNombrer_R(cursor.getString(2));
            verRegistro.setApellidor_R(cursor.getString(3));
            verRegistro.setDireccion_R(cursor.getString(4));
            verRegistro.setTelefono_R(cursor.getString(5));
            verRegistro.setNombrepelicula_R(cursor.getString(6));
            verRegistro.setCantidadvendida_R(cursor.getString(7));
            verRegistro.setPrecio_R(cursor.getString(8));

            listaDatos.add(verRegistro);

        }

    }

}