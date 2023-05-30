package com.example.misligas.Vista;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.misligas.Controlador.obtenerClasificacionDelUsuario;
import com.example.misligas.R;
import com.example.misligas.fragmentos.equipoFragmento;
import com.example.misligas.fragmentos.fragmentoEstadisticas;
import com.example.misligas.fragmentos.fragmentoJugadores;
import com.example.misligas.fragmentos.fragmentoLigas;
import com.example.misligas.fragmentos.fragmentoPartidos;

public class VisualizadorDatos extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        // Configura la Toolbar
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("MisLigas+");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        // Manejo de las opciones del menú
        if (id == R.id.opcionLiga) {
            cargarFragmentoLiga();
            Toast.makeText(this, "Liga", Toast.LENGTH_SHORT).show();
            // obtenerClasificacionLigasDelUsuario();
            return true;
        } else if (id == R.id.opcionEquipo) {
            cargarFragmentoEquipo();
            Toast.makeText(this, "Equipo", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.opcionEstadisticas) {
            cargarFragmentoEstadisticas();
            Toast.makeText(this, "Estadisticas", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.opcionJugadores) {
            cargarFragmentoJugadores();
            Toast.makeText(this, "Jugadores", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.opcionPartidos) {
            cargarFragmentoPartidos();
            Toast.makeText(this, "Partidos", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void cargarFragmentoPartidos() {
        fragmentoPartidos myFragment = new fragmentoPartidos();

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, myFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    private void cargarFragmentoJugadores() {
        fragmentoJugadores myFragment = new fragmentoJugadores();

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, myFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    private void cargarFragmentoEstadisticas() {
        fragmentoEstadisticas myFragment = new fragmentoEstadisticas();

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, myFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    private void cargarFragmentoEquipo() {
        equipoFragmento myFragment = new equipoFragmento();

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, myFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    private void cargarFragmentoLiga() {


        fragmentoLigas myFragment = new fragmentoLigas();

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, myFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }

    private void obtenerClasificacionLigasDelUsuario() {
        obtenerClasificacionDelUsuario o = new obtenerClasificacionDelUsuario(VisualizadorDatos.this);
        o.execute("saulfg");
    }
}
