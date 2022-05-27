package com.example.registropelis.adaptores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.registropelis.Entidades.VerPeliculas;
import com.example.registropelis.R;

import java.util.ArrayList;

public class Adaptador_VerPelicula extends RecyclerView.Adapter<Adaptador_VerPelicula.ViewHolderDatos> implements View.OnClickListener{


    ArrayList<VerPeliculas> listaDatos;

    private  View.OnClickListener listener;

    public Adaptador_VerPelicula(ArrayList<VerPeliculas> listaDatos) {
        this.listaDatos = listaDatos;
    }

    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.verpelicula_item_list,null,false);


        view.setOnClickListener(this);

        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adaptador_VerPelicula.ViewHolderDatos holder, int position) {


        holder.nombre(listaDatos.get(position).getNombre().toString());
        holder.ID(""+position);
        holder.codigo(listaDatos.get(position).getCodigo());
        holder.existencia(listaDatos.get(position).getExistencia());


    }

    @Override
    public int getItemCount() {
        return listaDatos.size();
    }

    public  void setOnClickListener (View.OnClickListener listener){
        this.listener = listener;

    }

    @Override
    public void onClick(View view) {

        if (listener !=null){
            listener.onClick(view);
        }
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {
        TextView Nombre;
        TextView Codigo;
        TextView Existencia;
        TextView id;

        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);

            Nombre = itemView.findViewById(R.id.VerPelicula_Nombre);
            Codigo = itemView.findViewById(R.id.VerPelicula_codigo);
            Existencia = itemView.findViewById(R.id.VerPelicula_existencias);
            id = itemView.findViewById(R.id.VerPelicula_posicion);

        }


        public void ID(String pos) {
            id.setText(pos);
        }
        public void nombre(String nombre) {
            Nombre.setText(nombre);
        }

        public void existencia(String existencia) {
            Existencia.setText(existencia);
        }

        public void codigo(String codigo) {
            Codigo.setText(codigo);
        }

    }
}
