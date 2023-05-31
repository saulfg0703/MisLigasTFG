package com.example.misligas.fragmentos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.misligas.Controlador.obtenerClasificacionUsuario;
import com.example.misligas.Modelo.modeloLigaUsuario;
import com.example.misligas.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragmentoLigas#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragmentoLigas extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    TableLayout tableLayout;

    public fragmentoLigas() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragmentoJugadores.
     */
    // TODO: Rename and change types and number of parameters
    public static fragmentoLigas newInstance(String param1, String param2) {
        fragmentoLigas fragment = new fragmentoLigas();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmentoligas, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tableLayout = view.findViewById(R.id.tabla);
        mostrarDatosEnTabla(obtenerClasificacionUsuario.clasificacion);
    }


    public void mostrarDatosEnTabla(ArrayList<modeloLigaUsuario> ligas) {
        for (modeloLigaUsuario liga : ligas) {
            TableRow row = new TableRow(requireContext());

            TextView puntosTextView = new TextView(requireContext());
            puntosTextView.setText(String.valueOf(liga.getPuntos()));
            row.addView(puntosTextView);

            TextView nombreEquipoTextView = new TextView(requireContext());
            nombreEquipoTextView.setText(liga.getNombreEquipo());
            row.addView(nombreEquipoTextView);

            tableLayout.addView(row);
        }
    }
}