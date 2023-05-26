package com.example.misligas.Vista;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.misligas.R;

public class VisualizadorDatos extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.visualizador_menu);

        // Configura la Toolbar
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("MisLigas+");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        // Manejo de las opciones del menú
        if (id == R.id.opcionLiga) {
            Toast.makeText(this, "Opción 1 seleccionada", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.opcionEquipo) {
            Toast.makeText(this, "Opción 2 seleccionada", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.opcionEstadisticas) {
            Toast.makeText(this, "Opción 3 seleccionada", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.opcionJugadores) {
            Toast.makeText(this, "Opción 3 seleccionada", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.opcionPartidos) {
            Toast.makeText(this, "Opción 3 seleccionada", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
