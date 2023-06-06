package com.example.misligas.fragmentos;

import static com.example.misligas.Controlador.Configuracion.IPAdress;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.misligas.R;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link mensajes#newInstance} factory method to
 * create an instance of this fragment.
 */
public class mensajes extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private EditText asunto;
    private EditText mensaje;
    private Button enviarM;


    public mensajes() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment mensajes.
     */
    // TODO: Rename and change types and number of parameters
    public static mensajes newInstance(String param1, String param2) {
        mensajes fragment = new mensajes();
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
        View view = inflater.inflate(R.layout.fragment_mensajes, container, false);
        asunto = view.findViewById(R.id.asuntoEditText);
        mensaje = view.findViewById(R.id.mensajeEditText);
        enviarM = view.findViewById(R.id.enviarMensajeBoton);

        enviarM.setOnClickListener(new View.OnClickListener() {
            @Override
            @RequiresApi(api = Build.VERSION_CODES.O)
            public void onClick(View v) {
                String asuntoS = asunto.getText().toString();
                String mensajeS = mensaje.getText().toString();
                String Nusuario = mParam1;
                String fecha = String.valueOf(LocalDate.now());
                if (!asuntoS.equals("") && !mensajeS.equals("")) {
                    if (enviarMensajeFuncional(asuntoS, mensajeS, Nusuario, fecha)) {
                        Toast.makeText(getContext(), "Mensaje enviado con éxito", Toast.LENGTH_SHORT).show();
                        asunto.setText("");
                        mensaje.setText("");
                    }else{
                        Toast.makeText(getContext(), "Hubo un error en el envio del mensaje", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getContext(), "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show();
                }

            }
        });
        return view;
    }


    private boolean enviarMensajeFuncional(String asuntoS, String mensajeS, String nusuario, String fecha) {

        // Crear una solicitud HTTP POST usando Volley
        final String url = "http://"+IPAdress+"/misligas/mensajes.php";
        StringRequest request = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // La solicitud se completó exitosamente
                        Log.d("INSERTAR_MENSAJE", "Mensaje insertado correctamente.");
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Error al realizar la solicitud
                        Log.e("INSERTAR_MENSAJE", "Error al insertar el mensaje: " + error.getMessage());
                    }
                }) {
            @Override
            protected Map<String, String> getParams() {
                // Parámetros para enviar al archivo PHP
                Map<String, String> params = new HashMap<>();
                params.put("asunto", asuntoS);
                params.put("nombre_usuario", nusuario);
                params.put("mensaje", mensajeS);
                params.put("fecha", fecha);
                return params;
            }
        };

// Agregar la solicitud a la cola de solicitudes de Volley
        RequestQueue queue = Volley.newRequestQueue(getContext());
        queue.add(request);

        return true;
    }
}