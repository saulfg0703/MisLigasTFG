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

import com.example.misligas.Controlador.obtenerClasificacionUsuario;
import com.example.misligas.Controlador.obtenerEquiposDelUsuario;
import com.example.misligas.Modelo.Equipo;
import com.example.misligas.Modelo.modeloLigaUsuario;
import com.example.misligas.R;

import java.util.ArrayList;

public class equipoFragmento extends Fragment {



    private TableLayout tableLayout;
    private ArrayList<Equipo> arrayList;

    public equipoFragmento(ArrayList<Equipo> arrayEquipos) {
        this.arrayList = arrayEquipos;
    }


    public static equipoFragmento newInstance(ArrayList<Equipo> arrayEquipos) {
        return new equipoFragmento(arrayEquipos);
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_equipo_fragmento, container, false);
        tableLayout = view.findViewById(R.id.tableEquipos);
        arrayList = obtenerEquiposDelUsuario.getEquipos();
        mostrarDatosEnTabla(arrayList);
        return view;
    }

    public void mostrarDatosEnTabla(ArrayList<Equipo> equipos) {
        tableLayout.removeAllViews();
        TableRow encabezado = new TableRow(requireContext());

        TextView nombreLabel = new TextView(requireContext());
        nombreLabel.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1.8f));
        nombreLabel.setBackgroundColor(Color.parseColor("#F29F05"));
        nombreLabel.setTextColor(Color.BLACK);
        nombreLabel.setPadding(8, 8, 8, 8);
        nombreLabel.setText("Equipo");

        TextView entrenadorLabel = new TextView(requireContext());
        entrenadorLabel.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1f));
        entrenadorLabel.setBackgroundColor(Color.parseColor("#F29F05"));
        entrenadorLabel.setTextColor(Color.BLACK);
        entrenadorLabel.setPadding(8, 8, 8, 8);
        entrenadorLabel.setText("Entrenador");

        TextView presidenteLabel = new TextView(requireContext());
        presidenteLabel.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1f));
        presidenteLabel.setBackgroundColor(Color.parseColor("#F29F05"));
        presidenteLabel.setTextColor(Color.BLACK);
        presidenteLabel.setPadding(8, 8, 8, 8);
        presidenteLabel.setText("Presidente");

        TextView ciudadLabel = new TextView(requireContext());
        ciudadLabel.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1f));
        ciudadLabel.setBackgroundColor(Color.parseColor("#F29F05"));
        ciudadLabel.setTextColor(Color.BLACK);
        ciudadLabel.setPadding(8, 8, 8, 8);
        ciudadLabel.setText("Ciudad");

        TextView idLigaLabel = new TextView(requireContext());
        idLigaLabel.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 0.7f));
        idLigaLabel.setBackgroundColor(Color.parseColor("#F29F05"));
        idLigaLabel.setTextColor(Color.BLACK);
        idLigaLabel.setPadding(8, 8, 8, 8);
        idLigaLabel.setText("Liga");

        encabezado.addView(nombreLabel);
        encabezado.addView(entrenadorLabel);
        encabezado.addView(presidenteLabel);
        encabezado.addView(ciudadLabel);
        encabezado.addView(idLigaLabel);

        tableLayout.addView(encabezado);

        for (Equipo equipo : equipos) {
            TableRow row = new TableRow(requireContext());

            TextView nombreEquipo = new TextView(requireContext());
            nombreEquipo.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1.8f));
            nombreEquipo.setBackgroundColor(Color.parseColor("#528F66"));
            nombreEquipo.setTextColor(Color.WHITE);
            nombreEquipo.setPadding(8, 8, 8, 8);
            nombreEquipo.setText(String.valueOf(equipo.getNombre_Equipo()));

            TextView entrenadorEquipo = new TextView(requireContext());
            entrenadorEquipo.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1f));
            entrenadorEquipo.setBackgroundColor(Color.parseColor("#528F66"));
            entrenadorEquipo.setTextColor(Color.WHITE);
            entrenadorEquipo.setPadding(8, 8, 8, 8);
            entrenadorEquipo.setText(String.valueOf(equipo.getEntrenador_Equipo()));

            TextView presidenteEquipo = new TextView(requireContext());
            presidenteEquipo.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1f));
            presidenteEquipo.setBackgroundColor(Color.parseColor("#528F66"));
            presidenteEquipo.setTextColor(Color.WHITE);
            presidenteEquipo.setPadding(8, 8, 8, 8);
            presidenteEquipo.setText(String.valueOf(equipo.getPresidente_Equipo()));

            TextView ciudadEquipo = new TextView(requireContext());
            ciudadEquipo.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1f));
            ciudadEquipo.setBackgroundColor(Color.parseColor("#528F66"));
            ciudadEquipo.setTextColor(Color.WHITE);
            ciudadEquipo.setPadding(8, 8, 8, 8);
            ciudadEquipo.setText(String.valueOf(equipo.getCiudad_Equipo()));

            TextView idLigaEquipo = new TextView(requireContext());
            idLigaEquipo.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 0.7f));
            idLigaEquipo.setBackgroundColor(Color.parseColor("#528F66"));
            idLigaEquipo.setTextColor(Color.WHITE);
            idLigaEquipo.setPadding(8, 8, 8, 8);
            idLigaEquipo.setText(String.valueOf(equipo.getIDLiga()));

            row.addView(nombreEquipo);
            row.addView(entrenadorEquipo);
            row.addView(presidenteEquipo);
            row.addView(ciudadEquipo);
            row.addView(idLigaEquipo);

            tableLayout.addView(row);
        }
    }

}