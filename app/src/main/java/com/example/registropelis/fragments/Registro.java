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

import android.view.View.OnClickListener;

public class Registro extends Fragment {
    Login login = new Login();
    EditText correo_Registro ;
    EditText contrasenia_Registro ;
    EditText contraseniaConfirmacion_Registro ;

    public Registro() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_registro, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
       // BottomNavigationView bottomNavigationView = view.findViewById(R.id.botones_Navegacion);
        //bottomNavigationView.setVisibility(view.GONE);

        correo_Registro = (EditText) view.findViewById(R.id.txtcorreo_Registro);
        contrasenia_Registro = (EditText) view.findViewById(R.id.txtcontrasenia_Registro);
        contraseniaConfirmacion_Registro = (EditText) view.findViewById(R.id.txtcontraseniaConfirmacion_Registro);


        Button btnRegistro = view.findViewById(R.id.btnRegistroUsuario_Registro);
        btnRegistro.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                ConexionSQliteHelper con = new ConexionSQliteHelper(getContext(),"Pelis.db",null,1);
                SQLiteDatabase db = con.getWritableDatabase();

               if (contrasenia_Registro.getText().toString().equals(contraseniaConfirmacion_Registro.getText().toString())){
                    ContentValues values = new ContentValues();
                    values.put(Utilidades.COLUMN_CORREO_USUARIO,correo_Registro.getText().toString());
                    values.put(Utilidades.COLUMN_CONTRA_USUARIO,contrasenia_Registro.getText().toString());
                    long idResultado  = db.insert(Utilidades.TABLE_NAME_USUARIO, Utilidades.COLUMN_ID_USUARIO,values);
                    //long idResultado  = db.insert(Utilidades.TABLE_NAME_USUARIO,null,values);

                   Toast toast = Toast.makeText(getContext(),"Id es: "+idResultado,Toast.LENGTH_LONG);
                   toast.show();
                    db.close();

                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.MostrarFragmentos,login).commit();

                }

            }

        });

    }
}