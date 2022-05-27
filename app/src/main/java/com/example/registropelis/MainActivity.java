package com.example.registropelis;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.registropelis.fragments.Login;
import com.example.registropelis.fragments.Registro;
import com.example.registropelis.fragments.Registros_peliculas;
import com.example.registropelis.fragments.Registros_ventas;
import com.example.registropelis.fragments.Ver_Registro_Peliculas;
import com.example.registropelis.fragments.Ver_Registro_Ventas;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    Login login = new Login();
    Ver_Registro_Ventas verRegistroVentas = new Ver_Registro_Ventas();
    Registros_ventas registrosVentas = new Registros_ventas();
    Ver_Registro_Peliculas verRegistroPeliculas = new Ver_Registro_Peliculas();
    Registros_peliculas registrosPeliculas = new Registros_peliculas();






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.botones_Navegacion);

        getSupportFragmentManager().beginTransaction().replace(R.id.MostrarFragmentos,login).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.Ver_Venta:
                        getSupportFragmentManager().beginTransaction().replace(R.id.MostrarFragmentos,verRegistroVentas).commit();
                        return true;

                    case R.id.Registros:
                        getSupportFragmentManager().beginTransaction().replace(R.id.MostrarFragmentos,registrosVentas).commit();
                        return true;

                    case R.id.Ver_Peliculas_Registrados:
                        getSupportFragmentManager().beginTransaction().replace(R.id.MostrarFragmentos,verRegistroPeliculas).commit();
                        return true;

                    case R.id.Agregar_Peliculas:
                        getSupportFragmentManager().beginTransaction().replace(R.id.MostrarFragmentos,registrosPeliculas).commit();
                        return true;

                }
                return false;
            }
        });

    }
}