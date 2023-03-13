package com.example.miauto.adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.miauto.R;
import com.example.miauto.entidades.Autos;

import java.util.ArrayList;

public class ListaAutosAdapter extends RecyclerView.Adapter<ListaAutosAdapter.AutosViewHolder> {

    ArrayList<Autos>listaAutos;

    public ListaAutosAdapter(ArrayList<Autos>listaAutos){
        this.listaAutos = listaAutos;
    }

    @NonNull
    @Override
    public AutosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_item_auto,null,false);
        return new AutosViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AutosViewHolder holder, int position){
        holder.viewPlaca.setText(listaAutos.get(position).getPlaca());
        holder.viewMarca.setText(listaAutos.get(position).getMarca());
        holder.viewModelo.setText(listaAutos.get(position).getModelo());
        holder.viewCilindraje.setText(listaAutos.get(position).getCilindraje());
        holder.viewColor.setText(listaAutos.get(position).getColor());
    }

    @Override
    public int getItemCount() {
        return listaAutos.size();
    }

    public class AutosViewHolder extends RecyclerView.ViewHolder {

        TextView viewPlaca, viewMarca, viewModelo, viewCilindraje, viewColor;
        public AutosViewHolder(@NonNull View itemView) {
            super(itemView);

            viewPlaca = itemView.findViewById(R.id.viewPlaca);
            viewMarca = itemView.findViewById(R.id.viewMarca);
            viewModelo = itemView.findViewById(R.id.viewModelo);
            viewCilindraje = itemView.findViewById(R.id.viewCilindraje);
            viewColor = itemView.findViewById(R.id.viewColor);
        }
    }
}
