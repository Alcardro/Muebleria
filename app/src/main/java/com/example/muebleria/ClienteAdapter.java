package com.example.muebleria;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

// Adaptador para RecyclerView
public class ClienteAdapter extends RecyclerView.Adapter<ClienteAdapter.ClienteViewHolder> {

    private ArrayList<Cliente> clientes;

    public ClienteAdapter(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    @NonNull
    @Override
    public ClienteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cliente, parent, false);
        return new ClienteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClienteViewHolder holder, int position) {
        Cliente cliente = clientes.get(position);
        holder.textNombre.setText(cliente.nombre);
        holder.textCorreo.setText(cliente.correo);
        holder.textTelefono.setText(cliente.telefono);
        holder.textEdad.setText(cliente.edad);
    }

    @Override
    public int getItemCount() {
        return clientes.size();
    }

    public static class ClienteViewHolder extends RecyclerView.ViewHolder {
        TextView textNombre, textCorreo, textTelefono, textEdad;

        public ClienteViewHolder(@NonNull View itemView) {
            super(itemView);
            textNombre = itemView.findViewById(R.id.textNombre);
            textCorreo = itemView.findViewById(R.id.textCorreo);
            textTelefono = itemView.findViewById(R.id.textTelefono);
            textEdad = itemView.findViewById(R.id.textEdad);
        }
    }
}
