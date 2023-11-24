package com.example.elsol;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private SolarImageAdapter adapter;
    private List<SolarImageItem> solarImageList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializar la lista de imágenes solares
        solarImageList = new ArrayList<>();
        // Agrega datos de prueba a la lista
        loadData();

        // Configurar RecyclerView
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new SolarImageAdapter(solarImageList);
        recyclerView.setAdapter(adapter);
    }

    private void loadData() {
        // Aquí deberías cargar tus datos, por ahora agregamos algunos de prueba
        solarImageList.add(new SolarImageItem("Imagen Solar 1", "corona_solar"));
        solarImageList.add(new SolarImageItem("Imagen Solar 2", "url2"));
        solarImageList.add(new SolarImageItem("Imagen Solar 3", "url3"));

    }
}



