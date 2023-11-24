package com.example.elsol;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class SolarImageAdapter extends RecyclerView.Adapter<SolarImageAdapter.ViewHolder> {

    private List<SolarImageItem> solarImageList;

    // Constructor
    public SolarImageAdapter(List<SolarImageItem> solarImageList) {
        this.solarImageList = solarImageList;
    }

    // Crear nuevos views (invocado por el layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.imagenes_solares, parent, false);
        return new ViewHolder(itemView);
    }

    // Reemplazar el contenido de un view (invocado por el layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        SolarImageItem item = solarImageList.get(position);
        holder.bind(item);
    }

    // Retornar el tamaño de tu dataset (invocado por el layout manager)
    @Override
    public int getItemCount() {
        return solarImageList.size();
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        SolarImageItem item = solarImageList.get(position);
        holder.bind(item);

        // Configurar Toolbar para cada ítem
        holder.toolbar.getMenu().clear(); // Limpia el menú para evitar duplicados
        holder.toolbar.inflateMenu(R.menu.toolbar_menu); // Infla tu menú aquí

        // Configurar eventos de clic en el menú
        holder.toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.action_copy:
                        // Manejar la acción de copiar
                        copyItem(position);
                        return true;
                    case R.id.action_delete:
                        // Manejar la acción de eliminar
                        deleteItem(position);
                        return true;
                    default:
                        return false;
                }
            }
        });
    }

    // Método para copiar un ítem
    private void copyItem(int position) {
        SolarImageItem item = new SolarImageItem(solarImageList.get(position).getTitle(), solarImageList.get(position).getImageUrl());
        solarImageList.add(position, item);
        notifyItemInserted(position);
    }

    // Método para eliminar un ítem
    private void deleteItem(int position) {
        solarImageList.remove(position);
        notifyItemRemoved(position);
    }


    // Clase ViewHolder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private Toolbar toolbar;

        public ViewHolder(View view) {
            super(view);
            imageView = view.findViewById(R.id.imageView);
            toolbar = view.findViewById(R.id.toolbar);
        }

        public void bind(SolarImageItem item) {
            // Aquí configuras los elementos del item, como cargar la imagen en imageView
            // y establecer el título en el Toolbar.
            toolbar.setTitle(item.getTitle());
            toolbar.inflateMenu(R.menu.toolbar_menu); // Asegúrate de tener tu menu.xml definido

            // Configurar eventos de clic en el menú
            toolbar.setOnMenuItemClickListener(menuItem -> {
                switch (menuItem.getItemId()) {
                    case R.id.action_copy:
                        // Manejar la acción de copiar
                        Toast.makeText(itemView.getContext(), "Copiado: " + item.getTitle(), Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.action_delete:
                        // Manejar la acción de eliminar
                        Toast.makeText(itemView.getContext(), "Eliminado: " + item.getTitle(), Toast.LENGTH_SHORT).show();
                        return true;
                }
                return false;
            });
        }
    }
}

