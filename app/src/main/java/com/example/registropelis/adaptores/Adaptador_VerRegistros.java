package com.example.registropelis.adaptores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.registropelis.Entidades.VerRegistros;
import com.example.registropelis.R;

import java.util.ArrayList;

public class Adaptador_VerRegistros extends RecyclerView.Adapter<Adaptador_VerRegistros.ViewHolderDatos> implements View.OnClickListener {


        ArrayList<VerRegistros> listaDatos;

        private View.OnClickListener listener;

    public Adaptador_VerRegistros(ArrayList <VerRegistros> listaDatos) {
        this.listaDatos = listaDatos;
    }

        @NonNull
        @Override
        public Adaptador_VerRegistros.ViewHolderDatos onCreateViewHolder (@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.verregistros_item_list, null, false);


        view.setOnClickListener(this);

        return new ViewHolderDatos(view);
    }

        @Override
        public void onBindViewHolder (@NonNull Adaptador_VerRegistros.ViewHolderDatos holder, int position){


        holder.nombre(listaDatos.get(position).getNombrer_R().toString());
        holder.ID("" + position);
        holder.nombrepelicula(listaDatos.get(position).getNombrepelicula_R());
        holder.precio(listaDatos.get(position).getPrecio_R());


    }

        @Override
        public int getItemCount () {
        return listaDatos.size();
    }

        public void setOnClickListener (View.OnClickListener listener){
        this.listener = listener;

    }

        @Override
        public void onClick (View view){

        if (listener != null) {
            listener.onClick(view);
        }
    }

        public class ViewHolderDatos extends RecyclerView.ViewHolder {
            TextView Nombre;
            TextView NombrePelicula;
            TextView Precio;
            TextView id;

            public ViewHolderDatos(@NonNull View itemView) {
                super(itemView);

                Nombre = itemView.findViewById(R.id.VerRegistros_Nombre);
                NombrePelicula = itemView.findViewById(R.id.VerRegistros_Nombrepelicula);
                Precio = itemView.findViewById(R.id.VerRegistros_Precio);
                id = itemView.findViewById(R.id.VerRegistros_posicion);

            }


            public void ID(String pos) {
                id.setText(pos);
            }

            public void nombre(String nombre) {
                Nombre.setText(nombre);
            }

            public void nombrepelicula(String nombrepelicula) {
                NombrePelicula.setText(nombrepelicula);
            }

            public void precio(String precio) {
                Precio.setText(precio);
            }

        }
    }



