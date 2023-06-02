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
import com.example.misligas.Controlador.obtenerEstadisticasEquipoDelUsuario;
import com.example.misligas.Modelo.Equipo;
import com.example.misligas.Modelo.Estadisticas_Equipo;
import com.example.misligas.R;

import java.util.ArrayList;


public class fragmentoEstadisticas extends Fragment {

    TableLayout tableLayout;
    private ArrayList<Estadisticas_Equipo> arrayList;


    public fragmentoEstadisticas(ArrayList<Estadisticas_Equipo> arrayEstadisticas) {
        this.arrayList = arrayEstadisticas;
    }
    public static fragmentoEstadisticas newInstance(ArrayList<Estadisticas_Equipo> arrayEstadisticas) {
        return new fragmentoEstadisticas(arrayEstadisticas);
    }




  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragmento_estadisticas, container, false);
        tableLayout = view.findViewById(R.id.tableEstadisticas);
        arrayList = obtenerEstadisticasEquipoDelUsuario.getEstadisticas();
        mostrarDatosEnTabla(arrayList);
        return view;
    }




    public void mostrarDatosEnTabla(ArrayList<Estadisticas_Equipo> estadisticas) {
        tableLayout.removeAllViews();
        TableRow encabezado = new TableRow(requireContext());

        TextView equipoLabel = new TextView(requireContext());
        equipoLabel.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1.2f));
        equipoLabel.setBackgroundColor(Color.parseColor("#F29F05"));
        equipoLabel.setTextColor(Color.BLACK);
        equipoLabel.setPadding(8, 8, 8, 8);
        equipoLabel.setText("Equipo");

        TextView puntosLabel = new TextView(requireContext());
        puntosLabel.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1.2f));
        puntosLabel.setBackgroundColor(Color.parseColor("#F29F05"));
        puntosLabel.setTextColor(Color.BLACK);
        puntosLabel.setPadding(8, 8, 8, 8);
        puntosLabel.setText("Puntos");

        TextView PJLabel = new TextView(requireContext());
        PJLabel.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 0.8f));
        PJLabel.setBackgroundColor(Color.parseColor("#F29F05"));
        PJLabel.setTextColor(Color.BLACK);
        PJLabel.setPadding(8, 8, 8, 8);
        PJLabel.setText("P.J");

        TextView PGLabel = new TextView(requireContext());
        PGLabel.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 0.8f));
        PGLabel.setBackgroundColor(Color.parseColor("#F29F05"));
        PGLabel.setTextColor(Color.BLACK);
        PGLabel.setPadding(8, 8, 8, 8);
        PGLabel.setText("P.G");

        TextView PPLabel = new TextView(requireContext());
        PPLabel.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 0.8f));
        PPLabel.setBackgroundColor(Color.parseColor("#F29F05"));
        PPLabel.setTextColor(Color.BLACK);
        PPLabel.setPadding(8, 8, 8, 8);
        PPLabel.setText("P.P");

        TextView PELabel = new TextView(requireContext());
        PELabel.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 0.8f));
        PELabel.setBackgroundColor(Color.parseColor("#F29F05"));
        PELabel.setTextColor(Color.BLACK);
        PELabel.setPadding(8, 8, 8, 8);
        PELabel.setText("P.E");

        TextView GAFLabel = new TextView(requireContext());
        GAFLabel.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 0.8f));
        GAFLabel.setBackgroundColor(Color.parseColor("#F29F05"));
        GAFLabel.setTextColor(Color.BLACK);
        GAFLabel.setPadding(8, 8, 8, 8);
        GAFLabel.setText("G.F");

        TextView GECLabel = new TextView(requireContext());
        GECLabel.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 0.8f));
        GECLabel.setBackgroundColor(Color.parseColor("#F29F05"));
        GECLabel.setTextColor(Color.BLACK);
        GECLabel.setPadding(8, 8, 8, 8);
        GECLabel.setText("G.C");

        TextView DGLabel = new TextView(requireContext());
        DGLabel.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 0.8f));
        DGLabel.setBackgroundColor(Color.parseColor("#F29F05"));
        DGLabel.setTextColor(Color.BLACK);
        DGLabel.setPadding(8, 8, 8, 8);
        DGLabel.setText("D.G");

        TextView TALabel = new TextView(requireContext());
        TALabel.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 0.8f));
        TALabel.setBackgroundColor(Color.parseColor("#F29F05"));
        TALabel.setTextColor(Color.BLACK);
        TALabel.setPadding(8, 8, 8, 8);
        TALabel.setText("T.A");

        TextView TRLabel = new TextView(requireContext());
        TRLabel.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 0.8f));
        TRLabel.setBackgroundColor(Color.parseColor("#F29F05"));
        TRLabel.setTextColor(Color.BLACK);
        TRLabel.setPadding(8, 8, 8, 8);
        TRLabel.setText("T.R");

        encabezado.addView(equipoLabel);
        encabezado.addView(puntosLabel);
        encabezado.addView(PJLabel);
        encabezado.addView(PGLabel);
        encabezado.addView(PPLabel);
        encabezado.addView(PELabel);
        encabezado.addView(GAFLabel);
        encabezado.addView(GECLabel);
        encabezado.addView(DGLabel);
        encabezado.addView(TALabel);
        encabezado.addView(TRLabel);


        tableLayout.addView(encabezado);

        for (Estadisticas_Equipo estadistica : estadisticas) {
            TableRow row = new TableRow(requireContext());

            TextView IDEquipo = new TextView(requireContext());
            IDEquipo.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1.2f));
            IDEquipo.setBackgroundColor(Color.parseColor("#528F66"));
            IDEquipo.setTextColor(Color.WHITE);
            IDEquipo.setPadding(8, 8, 8, 8);
            IDEquipo.setText(String.valueOf(estadistica.getID_Equipo()));

            TextView puntosEquipo = new TextView(requireContext());
            puntosEquipo.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1.2f));
            puntosEquipo.setBackgroundColor(Color.parseColor("#528F66"));
            puntosEquipo.setTextColor(Color.WHITE);
            puntosEquipo.setPadding(8, 8, 8, 8);
            puntosEquipo.setText(String.valueOf(estadistica.getPuntos()));

            TextView partidosJugados = new TextView(requireContext());
            partidosJugados.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 0.8f));
            partidosJugados.setBackgroundColor(Color.parseColor("#528F66"));
            partidosJugados.setTextColor(Color.WHITE);
            partidosJugados.setPadding(8, 8, 8, 8);
            partidosJugados.setText(String.valueOf(estadistica.getPartidosJugados()));

            TextView partidosGanados = new TextView(requireContext());
            partidosGanados.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 0.8f));
            partidosGanados.setBackgroundColor(Color.parseColor("#528F66"));
            partidosGanados.setTextColor(Color.WHITE);
            partidosGanados.setPadding(8, 8, 8, 8);
            partidosGanados.setText(String.valueOf(estadistica.getPartidosGanados()));

            TextView partidosPerdidos = new TextView(requireContext());
            partidosPerdidos.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 0.8f));
            partidosPerdidos.setBackgroundColor(Color.parseColor("#528F66"));
            partidosPerdidos.setTextColor(Color.WHITE);
            partidosPerdidos.setPadding(8, 8, 8, 8);
            partidosPerdidos.setText(String.valueOf(estadistica.getPartidosPerdidos()));

            TextView partidosEmpatados = new TextView(requireContext());
            partidosEmpatados.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 0.8f));
            partidosEmpatados.setBackgroundColor(Color.parseColor("#528F66"));
            partidosEmpatados.setTextColor(Color.WHITE);
            partidosEmpatados.setPadding(8, 8, 8, 8);
            partidosEmpatados.setText(String.valueOf(estadistica.getPartidosEmpatados()));

            TextView golesAFavor = new TextView(requireContext());
            golesAFavor.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 0.8f));
            golesAFavor.setBackgroundColor(Color.parseColor("#528F66"));
            golesAFavor.setTextColor(Color.WHITE);
            golesAFavor.setPadding(8, 8, 8, 8);
            golesAFavor.setText(String.valueOf(estadistica.getGolesAFavor()));

            TextView golesEnContra = new TextView(requireContext());
            golesEnContra.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 0.8f));
            golesEnContra.setBackgroundColor(Color.parseColor("#528F66"));
            golesEnContra.setTextColor(Color.WHITE);
            golesEnContra.setPadding(8, 8, 8, 8);
            golesEnContra.setText(String.valueOf(estadistica.getGolesEnContra()));

            TextView diferenciaGoles = new TextView(requireContext());
            diferenciaGoles.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 0.8f));
            diferenciaGoles.setBackgroundColor(Color.parseColor("#528F66"));
            diferenciaGoles.setTextColor(Color.WHITE);
            diferenciaGoles.setPadding(8, 8, 8, 8);
            diferenciaGoles.setText(String.valueOf(estadistica.getDiferenciaGoles()));

            TextView tarjetasAmarillas = new TextView(requireContext());
            tarjetasAmarillas.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 0.8f));
            tarjetasAmarillas.setBackgroundColor(Color.parseColor("#528F66"));
            tarjetasAmarillas.setTextColor(Color.WHITE);
            tarjetasAmarillas.setPadding(8, 8, 8, 8);
            tarjetasAmarillas.setText(String.valueOf(estadistica.getTarjetasAmarillas()));

            TextView tarjetasRojas = new TextView(requireContext());
            tarjetasRojas.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 0.8f));
            tarjetasRojas.setBackgroundColor(Color.parseColor("#528F66"));
            tarjetasRojas.setTextColor(Color.WHITE);
            tarjetasRojas.setPadding(8, 8, 8, 8);
            tarjetasRojas.setText(String.valueOf(estadistica.getTarjetasRojas()));

            row.addView(IDEquipo);
            row.addView(puntosEquipo);
            row.addView(partidosJugados);
            row.addView(partidosGanados);
            row.addView(partidosPerdidos);
            row.addView(partidosEmpatados);
            row.addView(golesAFavor);
            row.addView(golesEnContra);
            row.addView(diferenciaGoles);
            row.addView(tarjetasAmarillas);
            row.addView(tarjetasRojas);


            tableLayout.addView(row);
        }
        }
    }
