package com.example.misligas.Vista;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


import com.example.misligas.Controlador.obtenerClasificacionUsuario;
import com.example.misligas.Controlador.obtenerEquiposDelUsuario;
import com.example.misligas.Controlador.obtenerEstadisticasEquipoDelUsuario;
import com.example.misligas.Controlador.obtenerJugadoresUsuario;
import com.example.misligas.Controlador.obtenerPartidosDelUsuario;
import com.example.misligas.Modelo.Equipo;
import com.example.misligas.Modelo.Estadisticas_Equipo;
import com.example.misligas.Modelo.Jugador;
import com.example.misligas.Modelo.Partido;
import com.example.misligas.Modelo.Usuario;
import com.example.misligas.Modelo.modeloLigaUsuario;
import com.example.misligas.R;
import com.example.misligas.fragmentos.equipoFragmento;
import com.example.misligas.fragmentos.fragmentoEstadisticas;
import com.example.misligas.fragmentos.fragmentoJugadores;
import com.example.misligas.fragmentos.fragmentoLigas;
import com.example.misligas.fragmentos.fragmentoPartidos;

import java.util.ArrayList;

public class VisualizadorDatos extends AppCompatActivity {

    private Toolbar toolbar;
    private Usuario usuario;
    private ArrayList<modeloLigaUsuario> arrayClasificacion;
    private ArrayList<Equipo> arrayEquipos;
    private ArrayList<Estadisticas_Equipo> arrayEstadisticas;
    private ArrayList<Jugador> arrayJugadores;
    private ArrayList<Partido> arrayPartidos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Intent intent = getIntent();
        usuario = (Usuario) intent.getSerializableExtra("usuario");

        // Configura la Toolbar
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("MisLigas+");

        obtenerClasificacionLigasDelUsuario(usuario.getUsuario());
        obtenerEquiposDelUsuario(usuario.getUsuario());
        obtenerJugadores(usuario.getUsuario());
        obtenerEstadisticasUsuario(usuario.getUsuario());
        obtenerPartidos(usuario.getUsuario());
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
            cargarFragmentoLiga(arrayClasificacion);
            return true;
        } else if (id == R.id.opcionEquipo) {
            cargarFragmentoEquipo(arrayEquipos);
            Toast.makeText(this, "Equipo", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.opcionEstadisticas) {
            cargarFragmentoEstadisticas(arrayEstadisticas);
            Toast.makeText(this, "Estadisticas", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.opcionJugadores) {
            cargarFragmentoJugadores(arrayJugadores);
            Toast.makeText(this, "Jugadores", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.opcionPartidos) {
            cargarFragmentoPartidos(arrayPartidos);
            Toast.makeText(this, "Partidos", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void obtenerPartidos(String nombre_usuario) {
        obtenerPartidosDelUsuario e = new obtenerPartidosDelUsuario(VisualizadorDatos.this);
        e.execute(nombre_usuario);
    }

    private void obtenerJugadores(String nombre_usuario) {
        obtenerJugadoresUsuario e = new obtenerJugadoresUsuario(VisualizadorDatos.this);
        e.execute(nombre_usuario);
    }

    private void obtenerEstadisticasUsuario(String nombre_usuario) {
        obtenerEstadisticasEquipoDelUsuario e = new obtenerEstadisticasEquipoDelUsuario(VisualizadorDatos.this);
        e.execute(nombre_usuario);
    }

    private void obtenerEquiposDelUsuario(String nombre_usuario) {
        obtenerEquiposDelUsuario o = new obtenerEquiposDelUsuario(VisualizadorDatos.this);
        o.execute(nombre_usuario);
    }
    private void obtenerClasificacionLigasDelUsuario(String nombre_usuario) {
        obtenerClasificacionUsuario o = new obtenerClasificacionUsuario(VisualizadorDatos.this);
        o.execute(nombre_usuario);

    }
    private void cargarFragmentoPartidos(ArrayList<Partido> arrayPartidos) {
        fragmentoPartidos myFragment = fragmentoPartidos.newInstance(arrayPartidos);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, myFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    private void cargarFragmentoJugadores(ArrayList<Jugador> arrayJugadores) {
        fragmentoJugadores myFragment = fragmentoJugadores.newInstance(arrayJugadores);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, myFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    private void cargarFragmentoEstadisticas(ArrayList<Estadisticas_Equipo> arrayEstadisticas) {
        fragmentoEstadisticas myFragment = fragmentoEstadisticas.newInstance(arrayEstadisticas);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, myFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    private void cargarFragmentoEquipo(ArrayList<Equipo> arrayEquipos) {
        equipoFragmento myFragment = equipoFragmento.newInstance(arrayEquipos);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, myFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    private void cargarFragmentoLiga(ArrayList<modeloLigaUsuario> arrayClasificacion) {
        fragmentoLigas myFragment = fragmentoLigas.newInstance(arrayClasificacion);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, myFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }


}
