package com.example.misligas.fragmentos;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.misligas.Controlador.obtenerEquiposDelUsuario;
import com.example.misligas.Controlador.obtenerJugadoresUsuario;
import com.example.misligas.Modelo.Equipo;
import com.example.misligas.Modelo.Jugador;
import com.example.misligas.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragmentoLigas#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragmentoJugadores extends Fragment {

    TableLayout tableLayout;
    private ArrayList<Jugador> arrayList;


    public fragmentoJugadores(ArrayList<Jugador> arrayJugadores) {
        this.arrayList = arrayJugadores;
    }

    public static fragmentoJugadores newInstance(ArrayList<Jugador> arrayJugadores) {
        return new fragmentoJugadores(arrayJugadores);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragmento_jugadores, container, false);
        tableLayout = view.findViewById(R.id.tableJugadores);
        arrayList = obtenerJugadoresUsuario.getJugadores();
        mostrarDatosEnTabla(arrayList);
        return view;
    }



    public void mostrarDatosEnTabla(ArrayList<Jugador> jugadores){
        tableLayout.removeAllViews();
        String campoTablaLesionado = "SIN LESIÓN";
        TableRow encabezado = new TableRow(requireContext());

        TextView equipoLabel = new TextView(requireContext());
        equipoLabel.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1.8f));
        equipoLabel.setBackgroundColor(Color.parseColor("#F29F05"));
        equipoLabel.setTextColor(Color.BLACK);
        equipoLabel.setPadding(8, 8, 8, 8);
        equipoLabel.setText("Equipo");

        TextView nombreJugadorLabel = new TextView(requireContext());
        nombreJugadorLabel.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1.8f));
        nombreJugadorLabel.setBackgroundColor(Color.parseColor("#F29F05"));
        nombreJugadorLabel.setTextColor(Color.BLACK);
        nombreJugadorLabel.setPadding(8, 8, 8, 8);
        nombreJugadorLabel.setText("Nombre");

        TextView apellidoJugadorLabel = new TextView(requireContext());
        apellidoJugadorLabel.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1.8f));
        apellidoJugadorLabel.setBackgroundColor(Color.parseColor("#F29F05"));
        apellidoJugadorLabel.setTextColor(Color.BLACK);
        apellidoJugadorLabel.setPadding(8, 8, 8, 8);
        apellidoJugadorLabel.setText("Apellido");

        TextView posicionJugadorLabel = new TextView(requireContext());
        posicionJugadorLabel.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1.8f));
        posicionJugadorLabel.setBackgroundColor(Color.parseColor("#F29F05"));
        posicionJugadorLabel.setTextColor(Color.BLACK);
        posicionJugadorLabel.setPadding(8, 8, 8, 8);
        posicionJugadorLabel.setText("Posicion");

        TextView lesionadoLabel = new TextView(requireContext());
        lesionadoLabel.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1.8f));
        lesionadoLabel.setBackgroundColor(Color.parseColor("#F29F05"));
        lesionadoLabel.setTextColor(Color.BLACK);
        lesionadoLabel.setPadding(8, 8, 8, 8);
        lesionadoLabel.setText("Estado");

        TextView usuarioLabel = new TextView(requireContext());
        usuarioLabel.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1.8f));
        usuarioLabel.setBackgroundColor(Color.parseColor("#F29F05"));
        usuarioLabel.setTextColor(Color.BLACK);
        usuarioLabel.setPadding(8, 8, 8, 8);
        usuarioLabel.setText("Usuario");


        encabezado.addView(equipoLabel);
        encabezado.addView(nombreJugadorLabel);
        encabezado.addView(apellidoJugadorLabel);
        encabezado.addView(posicionJugadorLabel);
        encabezado.addView(lesionadoLabel);
        encabezado.addView(usuarioLabel);


        tableLayout.addView(encabezado);

        for (Jugador jugador : jugadores) {
            TableRow row = new TableRow(requireContext());

            TextView equipoJugador = new TextView(requireContext());
            equipoJugador.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 0.7f));
            equipoJugador.setBackgroundColor(Color.parseColor("#528F66"));
            equipoJugador.setTextColor(Color.WHITE);
            equipoJugador.setPadding(8, 8, 8, 8);
            equipoJugador.setText(String.valueOf(jugador.getID_Equipo()));

            TextView nombreJugador = new TextView(requireContext());
            nombreJugador.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1f));
            nombreJugador.setBackgroundColor(Color.parseColor("#528F66"));
            nombreJugador.setTextColor(Color.WHITE);
            nombreJugador.setPadding(8, 8, 8, 8);
            nombreJugador.setText(String.valueOf(jugador.getNombreJugador()));

            TextView apellidoJugador = new TextView(requireContext());
            apellidoJugador.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1f));
            apellidoJugador.setBackgroundColor(Color.parseColor("#528F66"));
            apellidoJugador.setTextColor(Color.WHITE);
            apellidoJugador.setPadding(8, 8, 8, 8);
            apellidoJugador.setText(String.valueOf(jugador.getApellidoJugador()));

            TextView posicionJugador = new TextView(requireContext());
            posicionJugador.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1f));
            posicionJugador.setBackgroundColor(Color.parseColor("#528F66"));
            posicionJugador.setTextColor(Color.WHITE);
            posicionJugador.setPadding(8, 8, 8, 8);
            posicionJugador.setText(String.valueOf(jugador.getPosicionJugador()));

            TextView lesionadoJugador = new TextView(requireContext());
            lesionadoJugador.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1f));
            lesionadoJugador.setBackgroundColor(Color.parseColor("#528F66"));
            lesionadoJugador.setTextColor(Color.WHITE);
            lesionadoJugador.setPadding(8, 8, 8, 8);
            if(jugador.getLesionado() == 1) {
                campoTablaLesionado = "Lesionado";
            }lesionadoJugador.setText(campoTablaLesionado);

            TextView usuarioJugador = new TextView(requireContext());
            usuarioJugador.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 0.7f));
            usuarioJugador.setBackgroundColor(Color.parseColor("#528F66"));
            usuarioJugador.setTextColor(Color.WHITE);
            usuarioJugador.setPadding(8, 8, 8, 8);
            usuarioJugador.setText(String.valueOf(jugador.getNombreUsuario()));



            row.addView(equipoJugador);
            row.addView(nombreJugador);
            row.addView(apellidoJugador);
            row.addView(posicionJugador);
            row.addView(lesionadoJugador);
            row.addView(usuarioJugador);

            tableLayout.addView(row);
        }



        }
    }

