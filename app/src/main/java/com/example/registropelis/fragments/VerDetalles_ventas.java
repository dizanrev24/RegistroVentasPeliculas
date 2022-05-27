package com.example.registropelis.fragments;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.registropelis.OpenHelper.ConexionSQliteHelper;
import com.example.registropelis.OpenHelper.Utilidades;
import com.example.registropelis.R;


public class VerDetalles_ventas extends Fragment {

    String id;
    String correo;
    String nombre;
    String apellido;
    String direccion;
    String telefono;
    String pelicula;
    String cantidad;
    String precio;

    TextView campocorreo,camponombre, campoapellido,campodireccion,campotelefono,campopelicula,campocantidad,campoprecio;

    public VerDetalles_ventas(String id, String correo, String nombre, String apellido, String direccion, String telefono, String pelicula, String cantidad, String precio) {
        this.id = id;
        this.correo = correo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.pelicula = pelicula;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public VerDetalles_ventas() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ver_detalles_ventas, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Button btnActualizar = view.findViewById(R.id.VerDetalles_peliculas_btnActualizar);
        Button btnEliminar = view.findViewById(R.id.VerDetalles_ventas_btnEliminar);
        Button btnVolver = view.findViewById(R.id.VerDetalles_ventas_btnVolver);

        campocorreo = view.findViewById(R.id.VerDetalles_venta_correo);
        camponombre = view.findViewById(R.id.VerDetalles_venta_nombre);
        campoapellido = view.findViewById(R.id.VerDetalles_venta_apellido);
        campodireccion = view.findViewById(R.id.VerDetalles_venta_direccion);
        campotelefono = view.findViewById(R.id.VerDetalles_venta_telefono);
        campopelicula = view.findViewById(R.id.VerDetalles_venta_pelicula);
        campocantidad = view.findViewById(R.id.VerDetalles_venta_cantidadpelicula);
        campoprecio = view.findViewById(R.id.VerDetalles_venta_preciopelicula);

        nombrarCampos();



       /* btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                actualizar();
            }
        });*/

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                eliminar();

            }
        });

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.MostrarFragmentos,new Ver_Registro_Ventas()).commit();
            }
        });

    }

    private void eliminar(){
        ConexionSQliteHelper conn = new ConexionSQliteHelper(getActivity(),"Pelis.db",null,1);
        SQLiteDatabase db = conn.getWritableDatabase();
        String [] parametros = {""+id};
        db.delete(Utilidades.TABLE_NAME_VENTAS,Utilidades.COLUMN_ID_VENTAS+" =? ",parametros);
        Toast.makeText(getContext(),"Informacion Eliminada ",Toast.LENGTH_LONG).show();
        db.close();

        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.MostrarFragmentos,new Ver_Registro_Ventas()).commit();


    }
    /*private void actualizar(){

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

     */
    private void nombrarCampos() {
        campocorreo.setText(this.correo);
        camponombre.setText(this.nombre);
        campoapellido.setText(this.apellido);
        campodireccion.setText(this.direccion);
        campotelefono.setText(this.telefono);
        campopelicula.setText(this.pelicula);
        campocantidad.setText(this.cantidad);
        campoprecio.setText(this.precio);


    }
}