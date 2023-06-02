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
import com.example.misligas.Modelo.Liga;
import com.example.misligas.Modelo.modeloLigaUsuario;
import com.example.misligas.R;

import java.util.ArrayList;

public class fragmentoLigas extends Fragment {

    private TableLayout tableLayout;
    private ArrayList<modeloLigaUsuario> arrayList;

    public fragmentoLigas(ArrayList<modeloLigaUsuario> arrayEquipos) {
        this.arrayList = arrayEquipos;
    }

    public static fragmentoLigas newInstance(ArrayList<modeloLigaUsuario> arrayEquipos) {
        return new fragmentoLigas(arrayEquipos);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmentoligas, container, false);
        tableLayout = view.findViewById(R.id.tabla);
        arrayList = obtenerClasificacionUsuario.getClasificacion();
        mostrarDatosEnTabla(arrayList);
        return view;
    }



    public void mostrarDatosEnTabla(ArrayList<modeloLigaUsuario> ligas) {
        tableLayout.removeAllViews();
        TableRow encabezado = new TableRow(requireContext());

        TextView equipoLabel = new TextView(requireContext());
        equipoLabel.setLayoutParams(new TableRow.LayoutParams(
                0,
                TableRow.LayoutParams.WRAP_CONTENT,
                1f
        ));
        equipoLabel.setBackgroundColor(Color.parseColor("#F29F05"));
        equipoLabel.setTextColor(Color.BLACK);
        equipoLabel.setPadding(8, 8, 8, 8);
        equipoLabel.setText("Equipo");

        TextView puntosLabel = new TextView(requireContext());
        puntosLabel.setLayoutParams(new TableRow.LayoutParams(
                0,
                TableRow.LayoutParams.WRAP_CONTENT,
                1f
        ));
        puntosLabel.setBackgroundColor(Color.parseColor("#F29F05"));
        puntosLabel.setTextColor(Color.BLACK);
        puntosLabel.setPadding(8, 8, 8, 8);
        puntosLabel.setText("Puntos");



        encabezado.addView(equipoLabel);
        encabezado.addView(puntosLabel);


        tableLayout.addView(encabezado);

        for (modeloLigaUsuario liga : ligas) {
            TableRow row = new TableRow(requireContext());

            TextView nombreEquipoTextView = new TextView(requireContext());
            nombreEquipoTextView.setLayoutParams(new TableRow.LayoutParams(
                    0,
                    TableRow.LayoutParams.WRAP_CONTENT,
                    1f
            ));
            nombreEquipoTextView.setBackgroundColor(Color.parseColor("#24613B"));
            nombreEquipoTextView.setTextColor(Color.WHITE);
            nombreEquipoTextView.setPadding(8, 8, 8, 8);
            nombreEquipoTextView.setText(liga.getNombreEquipo());

            TextView puntosTextView = new TextView(requireContext());
            puntosTextView.setLayoutParams(new TableRow.LayoutParams(
                    0,
                    TableRow.LayoutParams.WRAP_CONTENT,
                    1f
            ));
            puntosTextView.setBackgroundColor(Color.parseColor("#528F66"));
            puntosTextView.setTextColor(Color.WHITE);
            puntosTextView.setPadding(8, 8, 8, 8);
            puntosTextView.setText(String.valueOf(liga.getPuntos()));



            row.addView(nombreEquipoTextView);
            row.addView(puntosTextView);


            tableLayout.addView(row);
        }
    }

}
