package com.example.registropelis.fragments;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.registropelis.Entidades.Usuarios;
import com.example.registropelis.OpenHelper.ConexionSQliteHelper;
import com.example.registropelis.OpenHelper.Utilidades;
import com.example.registropelis.R;

import java.util.ArrayList;


public class Registros_ventas extends Fragment {
    ArrayList<String> listaPrecios;
    ArrayList<String> listaDatos ;

    EditText correo ;
    EditText nombre ;
    EditText apellido ;
    EditText direccion ;
    EditText telefono ;
    Spinner nombrepelicula ;
    EditText cantidadVendida ;
    TextView precio ;

    public Registros_ventas() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_registros_ventas, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        correo =  (EditText) view.findViewById(R.id.txtRegistro_venta_correo);
        nombre =  (EditText) view.findViewById(R.id.txtRegistro_venta_nombre);
        apellido =  (EditText) view.findViewById(R.id.txtRegistro_venta_apellido);
        direccion =  (EditText) view.findViewById(R.id.txtRegistro_venta_direccion);
        telefono =  (EditText) view.findViewById(R.id.txtRegistro_venta_telefono);
        nombrepelicula =  (Spinner) view.findViewById(R.id.txtRegistro_venta_pelicula);
        cantidadVendida =  (EditText) view.findViewById(R.id.txtRegistro_venta_cantidadpelicula);
        precio =  (TextView) view.findViewById(R.id.txtRegistro_venta_preciopelicula);


        cargarDatosSpinner();

        nombrepelicula.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedItem = adapterView.getItemAtPosition(i).toString();

                String contenido = cantidadVendida.getText().toString();


                if (contenido.isEmpty()){
                    contenido="1";
                    cantidadVendida.setText(contenido);
                }
                if (contenido !="" && contenido != null && !contenido.isEmpty()){

                    double precioTotal = Double.parseDouble(cantidadVendida.getText().toString()) * Double.parseDouble(listaPrecios.get(i));
                    precio.setText(""+precioTotal);
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



        Button btnRegistroPeliculas = view.findViewById(R.id.btnRegisto_venta_guardar);
        btnRegistroPeliculas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ConexionSQliteHelper con = new ConexionSQliteHelper(getContext(),"Pelis.db",null,1);
                SQLiteDatabase db = con.getWritableDatabase();

                ContentValues values = new ContentValues();
                values.put(Utilidades.COLUMN_CORREO_VENTAS,correo.getText().toString());
                values.put(Utilidades.COLUMN_NOMBRE_VENTAS,nombre.getText().toString());
                values.put(Utilidades.COLUMN_APELLIDO_VENTAS,apellido.getText().toString());
                values.put(Utilidades.COLUMN_DIRECCION_VENTAS,direccion.getText().toString());
                values.put(Utilidades.COLUMN_TELEFONO_VENTAS,telefono.getText().toString());
                values.put(Utilidades.COLUMN_NOMBREPELI_VENTAS,nombrepelicula.getSelectedItem().toString());
                values.put(Utilidades.COLUMN_CANTIDADVENDIDA_VENTAS,cantidadVendida.getText().toString());
                values.put(Utilidades.COLUMN_PRECIOPELI_VENTAS,precio.getText().toString());

                long idResultado  = db.insert(Utilidades.TABLE_NAME_VENTAS, Utilidades.COLUMN_ID_VENTAS,values);
                //long idResultado  = db.insert(Utilidades.TABLE_NAME_USUARIO,null,values);

                Toast toast = Toast.makeText(getContext(),"Id es: "+idResultado,Toast.LENGTH_LONG);
                toast.show();
                db.close();


                correo.setText("");
                nombre.setText("");
                apellido.setText("");
                direccion.setText("");
                telefono.setText("");
                cantidadVendida.setText("");
                precio.setText("");

            }

        });
    }

    private void cargarDatosSpinner() {

        listaPrecios = new ArrayList<String>();
        listaDatos= new ArrayList<String>();


        ConexionSQliteHelper con = new ConexionSQliteHelper(getContext(),"Pelis.db",null,1);
        SQLiteDatabase db = con.getReadableDatabase();

        //Usuarios usuarios;

        Cursor cursor = db.rawQuery("SELECT * FROM "+ Utilidades.TABLE_NAME_REGISTROPELIS,null);



        while (cursor.moveToNext()){
            //usuarios = new Usuarios();

            listaDatos.add(cursor.getString(2));
            listaPrecios.add(cursor.getString(3));

        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_spinner_item, listaDatos);

        nombrepelicula.setAdapter(adapter);

    }
}