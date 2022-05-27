package com.example.registropelis.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.registropelis.OpenHelper.ConexionSQliteHelper;
import com.example.registropelis.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class Login extends Fragment {
TextView registrarse;
Ver_Registro_Ventas VerRegistrosVentas= new Ver_Registro_Ventas();


    public Login() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        BottomNavigationView bottomNavigationView;
        bottomNavigationView = getActivity().findViewById(R.id.botones_Navegacion);
        bottomNavigationView.setVisibility(View.GONE);


        ConexionSQliteHelper con = new ConexionSQliteHelper(getContext(),"Pelis.db",null,1);

        Button btnIniciar = view.findViewById(R.id.iniciarSesion);

        Registro registro = new Registro();
        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                bottomNavigationView.setVisibility(View.VISIBLE);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.MostrarFragmentos,VerRegistrosVentas).commit();


            }
        });

        registrarse = view.findViewById(R.id.Registrar_login);
        registrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.MostrarFragmentos,registro).commit();

            }
        });
    }
}