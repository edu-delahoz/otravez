package com.example.appfinalunisinu.ui.campus;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.appfinalunisinu.R;
import java.util.List;

public class AmigosAdapter extends RecyclerView.Adapter<AmigosAdapter.AmigoViewHolder> {
    private List<Amigos> listaAmigos;

    public AmigosAdapter(List<Amigos> listaAmigos) {
        this.listaAmigos = listaAmigos;
    }

    @NonNull
    @Override
    public AmigoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflar el diseño de cada elemento de la lista
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_amigo, parent, false);
        return new AmigoViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AmigoViewHolder holder, int position) {
        // Vincular los datos del amigo en la posición especificada
        Amigos amigo = listaAmigos.get(position);
        holder.bind(amigo);
    }

    @Override
    public int getItemCount() {
        return listaAmigos.size();
    }

    // Clase ViewHolder para mantener las referencias de las vistas de cada elemento de la lista
    public static class AmigoViewHolder extends RecyclerView.ViewHolder {
        private TextView nombreTextView;

        public AmigoViewHolder(@NonNull View itemView) {
            super(itemView);
            nombreTextView = itemView.findViewById(R.id.nombreTextView);
        }

        public void bind(Amigos amigo) {
            // Establecer el nombre del amigo en el TextView correspondiente
            nombreTextView.setText(amigo.getNombre());
        }
    }
}
