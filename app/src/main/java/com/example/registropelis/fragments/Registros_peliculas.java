package com.example.registropelis.fragments;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.registropelis.OpenHelper.ConexionSQliteHelper;
import com.example.registropelis.OpenHelper.Utilidades;
import com.example.registropelis.R;


public class Registros_peliculas extends Fragment {
    EditText codigo ;
    EditText nombrePelicula ;
    EditText precioPelicula ;
    EditText existenciaPelicula ;


    public Registros_peliculas() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_registros_peliculas, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        codigo =  (EditText) view.findViewById(R.id.txtRegistro_peliculas_codigo);
        nombrePelicula =  (EditText) view.findViewById(R.id.txtRegistro_peliculas_nombre);
        precioPelicula =  (EditText) view.findViewById(R.id.txtRegistro_peliculas_precio);
        existenciaPelicula =  (EditText) view.findViewById(R.id.txtRegistro_peliculas_cantidadexistente);

        Button btnRegistroVentas = view.findViewById(R.id.btnRegisto_peliculas_guardar);
        btnRegistroVentas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ConexionSQliteHelper con = new ConexionSQliteHelper(getContext(),"Pelis.db",null,1);
                SQLiteDatabase db = con.getWritableDatabase();

                ContentValues values = new ContentValues();
                values.put(Utilidades.COLUMN_CODIGO_REGISTROPELIS,codigo.getText().toString());
                values.put(Utilidades.COLUMN_NOMBRE_REGISTROPELIS,nombrePelicula.getText().toString());
                values.put(Utilidades.COLUMN_PRECIO_REGISTROPELIS,precioPelicula.getText().toString());
                values.put(Utilidades.COLUMN_EXISTENCIA_REGISTROPELIS,existenciaPelicula.getText().toString());

                long idResultado  = db.insert(Utilidades.TABLE_NAME_REGISTROPELIS, Utilidades.COLUMN_ID_REGISTROPELIS,values);
                //long idResultado  = db.insert(Utilidades.TABLE_NAME_USUARIO,null,values);

                Toast toast = Toast.makeText(getContext(),"Id es: "+idResultado,Toast.LENGTH_LONG);
                toast.show();
                db.close();


                codigo.setText("");
                nombrePelicula.setText("");
                precioPelicula.setText("");
                existenciaPelicula.setText("");

            }

        });
    }
}