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


public class VerDetalles_peliculas extends Fragment {

    String id;
    String codigo;
    String nombre;
    String precio;
    String existencia;

    EditText campocodigo,camponombre, campoprecio,campoexistencia;

    public VerDetalles_peliculas(String id, String codigo, String nombre, String precio, String existencia) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.existencia = existencia;
    }

    public VerDetalles_peliculas() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ver_detalles_peliculas, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button btnActualizar = view.findViewById(R.id.VerDetalles_peliculas_btnActualizar);
        Button btnEliminar = view.findViewById(R.id.VerDetalles_peliculas_btnEliminar);
        Button btnVolver = view.findViewById(R.id.VerDetalles_peliculas_btnVolver);

        campocodigo = view.findViewById(R.id.VerDetalles_peliculas_codigo);
        camponombre = view.findViewById(R.id.VerDetalles_peliculas_nombre);
        campoprecio = view.findViewById(R.id.VerDetalles_peliculas_precio);
        campoexistencia = view.findViewById(R.id.VerDetalles_peliculas_existencia);

        nombrarCampos();



        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                actualizar();
            }
        });

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                eliminar();

            }
        });

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.MostrarFragmentos,new Ver_Registro_Peliculas()).commit();
            }
        });

    }

    private void eliminar(){
        ConexionSQliteHelper conn = new ConexionSQliteHelper(getActivity(),"Pelis.db",null,1);
        SQLiteDatabase db = conn.getWritableDatabase();
        String [] parametros = {""+id};
        db.delete(Utilidades.TABLE_NAME_REGISTROPELIS,Utilidades.COLUMN_ID_REGISTROPELIS+" =? ",parametros);
        Toast.makeText(getContext(),"Informacion Eliminada ",Toast.LENGTH_LONG).show();
        db.close();

        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.MostrarFragmentos,new Ver_Registro_Peliculas()).commit();


    }
    private void actualizar(){

        ConexionSQliteHelper conn = new ConexionSQliteHelper(getActivity(),"Pelis.db",null,1);
        SQLiteDatabase db = conn.getWritableDatabase();
        String [] parametros = {""+id};
        ContentValues values = new ContentValues();



        values.put(Utilidades.COLUMN_CODIGO_REGISTROPELIS,campocodigo.getText().toString());
        values.put(Utilidades.COLUMN_NOMBRE_REGISTROPELIS,camponombre.getText().toString());
        values.put(Utilidades.COLUMN_PRECIO_REGISTROPELIS,campoprecio.getText().toString());
        values.put(Utilidades.COLUMN_EXISTENCIA_REGISTROPELIS,campoexistencia.getText().toString());


        //Toast.makeText(getContext(),"Informacion Actualizada "+id,Toast.LENGTH_LONG).show();
        db.update(Utilidades.TABLE_NAME_REGISTROPELIS,values,Utilidades.COLUMN_ID_REGISTROPELIS+" = ?",parametros);
        Toast.makeText(getContext(),"Informacion Actualizada ",Toast.LENGTH_LONG).show();
        db.close();
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.MostrarFragmentos,new Ver_Registro_Peliculas()).commit();

    }
    private void nombrarCampos() {
        campocodigo.setText(this.codigo);
        camponombre.setText(this.nombre);
        campoprecio.setText(this.precio);
        campoexistencia.setText(this.existencia);

    }
}