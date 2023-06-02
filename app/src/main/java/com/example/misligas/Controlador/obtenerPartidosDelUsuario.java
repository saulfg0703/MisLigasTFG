package com.example.misligas.Controlador;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Parcel;
import android.widget.Toast;

import com.example.misligas.Modelo.Jugador;
import com.example.misligas.Modelo.Partido;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class obtenerPartidosDelUsuario extends AsyncTask<String, List<String>, List<String>> implements Configuracion {


    Context context;

    public static ArrayList<Partido> getPartidos() {
        return partidos;
    }

    public static void setPartidos(ArrayList<Partido> partidos) {
        obtenerPartidosDelUsuario.partidos = partidos;
    }

    public static ArrayList<Partido> partidos = new ArrayList<>();

    public obtenerPartidosDelUsuario(Context context) {
        this.context = context;
    }

    @Override
    protected List<String> doInBackground(String... strings) {
        String username = null;
        List<String> partidoString = new ArrayList<>();

        try {
            username = strings[0];

            // Obtener partidos de local
            URL urlLocal = new URL("http://" + IPAdress + "/misligas/obtenerPartidosDeLocal.php");
            HttpURLConnection connLocal = (HttpURLConnection) urlLocal.openConnection();
            connLocal.setRequestMethod("POST");
            connLocal.setDoOutput(true);

            String dataLocal = "username=" + URLEncoder.encode(username, "UTF-8");

            // Escribir los datos en el flujo de salida
            OutputStream outputStreamLocal = connLocal.getOutputStream();
            outputStreamLocal.write(dataLocal.getBytes("UTF-8"));
            outputStreamLocal.flush();
            outputStreamLocal.close();

            // Leer la respuesta del servidor
            BufferedReader readerLocal = new BufferedReader(new InputStreamReader(connLocal.getInputStream()));
            StringBuilder responseLocal = new StringBuilder();
            String lineLocal;
            while ((lineLocal = readerLocal.readLine()) != null) {
                responseLocal.append(lineLocal);
            }
            readerLocal.close();
            connLocal.disconnect();

            // Obtener partidos de visitante
            URL urlVisitante = new URL("http://" + IPAdress + "/misligas/obtenerPartidosDeVisitante.php");
            HttpURLConnection connVisitante = (HttpURLConnection) urlVisitante.openConnection();
            connVisitante.setRequestMethod("POST");
            connVisitante.setDoOutput(true);

            String dataVisitante = "username=" + URLEncoder.encode(username, "UTF-8");

            // Escribir los datos en el flujo de salida
            OutputStream outputStreamVisitante = connVisitante.getOutputStream();
            outputStreamVisitante.write(dataVisitante.getBytes("UTF-8"));
            outputStreamVisitante.flush();
            outputStreamVisitante.close();

            // Leer la respuesta del servidor
            BufferedReader readerVisitante = new BufferedReader(new InputStreamReader(connVisitante.getInputStream()));
            StringBuilder responseVisitante = new StringBuilder();
            String lineVisitante;
            while ((lineVisitante = readerVisitante.readLine()) != null) {
                responseVisitante.append(lineVisitante);
            }
            readerVisitante.close();
            connVisitante.disconnect();

            // Procesar la respuesta de los partidos de local
            JSONArray jsonArrayLocal = new JSONArray(responseLocal.toString());
            for (int i = 0; i < jsonArrayLocal.length(); i++) {
                String partido = jsonArrayLocal.getString(i);
                partidoString.add(partido);
            }

            // Procesar la respuesta de los partidos de visitante
            JSONArray jsonArrayVisitante = new JSONArray(responseVisitante.toString());
            for (int i = 0; i < jsonArrayVisitante.length(); i++) {
                String partido = jsonArrayVisitante.getString(i);
                partidoString.add(partido);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return partidoString;
    }


    @Override
    protected void onPostExecute(List<String> strings) {
        partidos.clear(); // Limpiar la lista antes de agregar nuevos elementos

        if (strings != null && !strings.isEmpty()) {
            for (String li : strings) {
                try {
                    JSONObject jsonObject1 = new JSONObject(li);
                    partidos.add(new Partido(jsonObject1.getInt("ID_Partido"), jsonObject1.getString("Fecha_Encuentro"),
                            jsonObject1.getString("Lugar_Encuentro"), jsonObject1.getString("Resultado_Encuentro"),
                            jsonObject1.getString("Incidencias"), jsonObject1.getInt("ID_Liga"), jsonObject1.getInt("ID_EquipoLocal"),jsonObject1.getInt("ID_EquipoVisitante")));
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        } else {
            // No se encontraron ligas
            Toast.makeText(context, "No se encontraron ligas", Toast.LENGTH_SHORT).show();
        }
    }
}

