package com.example.misligas.Vista;

import static com.example.misligas.Controlador.Configuracion.IPAdress;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.misligas.Controlador.dataBaseManager;
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
import com.example.misligas.fragmentos.mensajes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class VisualizadorDatos extends AppCompatActivity {

    private Toolbar toolbar;
    private Usuario usuario;
    private ArrayList<modeloLigaUsuario> arrayClasificacion;
    private ArrayList<Equipo> arrayEquipos;
    private ArrayList<Estadisticas_Equipo> arrayEstadisticas;
    private ArrayList<Jugador> arrayJugadores;
    private ArrayList<Partido> arrayPartidos;
    private dataBaseManager databaseManager;



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
            //  obtenerTodasLasClasificaciones.hacerConsulta(VisualizadorDatos.this);
            cargarFragmentoLiga(arrayClasificacion);
            return true;
        } else if (id == R.id.opcionEquipo) {
            cargarFragmentoEquipo(arrayEquipos);
            return true;
        } else if (id == R.id.opcionEstadisticas) {
            cargarFragmentoEstadisticas(arrayEstadisticas);
            return true;
        } else if (id == R.id.opcionJugadores) {
            cargarFragmentoJugadores(arrayJugadores);
            return true;
        } else if (id == R.id.opcionPartidos) {
            cargarFragmentoPartidos(arrayPartidos);
            return true;
        }else if (id == R.id.contactarAdmin){
            cargarFragmentoAdmin();
        }

        return super.onOptionsItemSelected(item);
    }

    private void cargarFragmentoAdmin() {
        mensajes myFragment = mensajes.newInstance(usuario.getUsuario(),"");
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, myFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
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
