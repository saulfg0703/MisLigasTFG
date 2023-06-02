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
import com.example.misligas.Controlador.obtenerPartidosDelUsuario;
import com.example.misligas.Modelo.Equipo;
import com.example.misligas.Modelo.Estadisticas_Equipo;
import com.example.misligas.Modelo.Partido;
import com.example.misligas.R;

import java.util.ArrayList;

public class fragmentoPartidos extends Fragment {

    TableLayout tableLayout;
    private ArrayList<Partido> arrayList;

    public fragmentoPartidos(ArrayList<Partido> arrayPartidos) {
        this.arrayList = arrayPartidos;
    }

    public static fragmentoPartidos newInstance(ArrayList<Partido> arrayPartidos) {
        return new fragmentoPartidos(arrayPartidos);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragmento_partidos, container, false);
        tableLayout = view.findViewById(R.id.tablePartidos);
        arrayList = obtenerPartidosDelUsuario.getPartidos();
        mostrarDatosEnTabla(arrayList);
        return view;
    }

    public void mostrarDatosEnTabla(ArrayList<Partido> partidos) {
        tableLayout.removeAllViews();
        TableRow encabezado = new TableRow(requireContext());

        TextView equipoLocal = new TextView(requireContext());
        equipoLocal.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 0.7f));
        equipoLocal.setBackgroundColor(Color.parseColor("#F29F05"));
        equipoLocal.setTextColor(Color.BLACK);
        equipoLocal.setPadding(8, 8, 8, 8);
        equipoLocal.setText("Local");

        TextView equipoVisitante = new TextView(requireContext());
        equipoVisitante.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1.2f));
        equipoVisitante.setBackgroundColor(Color.parseColor("#F29F05"));
        equipoVisitante.setTextColor(Color.BLACK);
        equipoVisitante.setPadding(8, 8, 8, 8);
        equipoVisitante.setText("Visitante");

        TextView resultadoLabel = new TextView(requireContext());
        resultadoLabel.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1.2f));
        resultadoLabel.setBackgroundColor(Color.parseColor("#F29F05"));
        resultadoLabel.setTextColor(Color.BLACK);
        resultadoLabel.setPadding(8, 8, 8, 8);
        resultadoLabel.setText("Resultado");

        TextView lugarLabel = new TextView(requireContext());
        lugarLabel.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 0.7f));
        lugarLabel.setBackgroundColor(Color.parseColor("#F29F05"));
        lugarLabel.setTextColor(Color.BLACK);
        lugarLabel.setPadding(8, 8, 8, 8);
        lugarLabel.setText("Lugar");

        TextView fechaLabel = new TextView(requireContext());
        fechaLabel.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1.2f));
        fechaLabel.setBackgroundColor(Color.parseColor("#F29F05"));
        fechaLabel.setTextColor(Color.BLACK);
        fechaLabel.setPadding(8, 8, 8, 8);
        fechaLabel.setText("Fecha");

        TextView incidenciasLabel = new TextView(requireContext());
        incidenciasLabel.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1.3f));
        incidenciasLabel.setBackgroundColor(Color.parseColor("#F29F05"));
        incidenciasLabel.setTextColor(Color.BLACK);
        incidenciasLabel.setPadding(8, 8, 8, 8);
        incidenciasLabel.setText("Incidencias");

        TextView idLiga = new TextView(requireContext());
        idLiga.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 0.7f));
        idLiga.setBackgroundColor(Color.parseColor("#F29F05"));
        idLiga.setTextColor(Color.BLACK);
        idLiga.setPadding(8, 8, 8, 8);
        idLiga.setText("Liga");

        encabezado.addView(equipoLocal);
        encabezado.addView(equipoVisitante);
        encabezado.addView(resultadoLabel);
        encabezado.addView(lugarLabel);
        encabezado.addView(fechaLabel);
        encabezado.addView(incidenciasLabel);
        encabezado.addView(idLiga);

        tableLayout.addView(encabezado);

        for  (Partido partido : partidos) {
            TableRow row = new TableRow(requireContext());

            TextView local = new TextView(requireContext());
            local.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 0.7f));
            local.setBackgroundColor(Color.parseColor("#528F66"));
            local.setTextColor(Color.WHITE);
            local.setPadding(8, 8, 8, 8);
            local.setText(String.valueOf(partido.getID_EquipoLocal()));

            TextView visitante = new TextView(requireContext());
            visitante.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 0.7f));
            visitante.setBackgroundColor(Color.parseColor("#528F66"));
            visitante.setTextColor(Color.WHITE);
            visitante.setPadding(8, 8, 8, 8);
            visitante.setText(String.valueOf(partido.getID_EquipoVisitante()));

            TextView resultadoPartido = new TextView(requireContext());
            resultadoPartido.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 0.7f));
            resultadoPartido.setBackgroundColor(Color.parseColor("#528F66"));
            resultadoPartido.setTextColor(Color.WHITE);
            resultadoPartido.setPadding(8, 8, 8, 8);
            resultadoPartido.setText(String.valueOf(partido.getResultadoEncuentro()));

            TextView lugarPartido = new TextView(requireContext());
            lugarPartido.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1f));
            lugarPartido.setBackgroundColor(Color.parseColor("#528F66"));
            lugarPartido.setTextColor(Color.WHITE);
            lugarPartido.setPadding(8, 8, 8, 8);
            lugarPartido.setText(String.valueOf(partido.getLugarEncuentro()));

            TextView fechaPartido = new TextView(requireContext());
            fechaPartido.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1.2f));
            fechaPartido.setBackgroundColor(Color.parseColor("#528F66"));
            fechaPartido.setTextColor(Color.WHITE);
            fechaPartido.setPadding(8, 8, 8, 8);
            fechaPartido.setText(String.valueOf(partido.getFechaEncuentro()));

            TextView incidenciasPartido = new TextView(requireContext());
            incidenciasPartido.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1f));
            incidenciasPartido.setBackgroundColor(Color.parseColor("#528F66"));
            incidenciasPartido.setTextColor(Color.WHITE);
            incidenciasPartido.setPadding(8, 8, 8, 8);
            incidenciasPartido.setText(String.valueOf(partido.getIncidencias()));

            TextView idLigaPartido = new TextView(requireContext());
            idLigaPartido.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 0.7f));
            idLigaPartido.setBackgroundColor(Color.parseColor("#528F66"));
            idLigaPartido.setTextColor(Color.WHITE);
            idLigaPartido.setPadding(8, 8, 8, 8);
            idLigaPartido.setText(String.valueOf(partido.getID_Liga()));

            row.addView(local);
            row.addView(visitante);
            row.addView(resultadoPartido);
            row.addView(lugarPartido);
            row.addView(fechaPartido);
            row.addView(incidenciasPartido);
            row.addView(idLigaPartido);

            tableLayout.addView(row);
        }

        }

    }

