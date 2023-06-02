package com.example.misligas.Controlador;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.example.misligas.Modelo.Equipo;
import com.example.misligas.Modelo.Jugador;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class obtenerJugadoresUsuario  extends AsyncTask<String, List<String>, List<String>> implements Configuracion   {
    Context context;

    public static ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public static void setJugadores(ArrayList<Jugador> jugadores) {
        obtenerJugadoresUsuario.jugadores = jugadores;
    }

    public static ArrayList<Jugador> jugadores = new ArrayList<>();

    public obtenerJugadoresUsuario(Context context) {
        this.context = context;
    }


    @Override
    protected List<String> doInBackground(String... strings) {
        StringBuilder response = new StringBuilder();
        List<String> jugadoresString = new ArrayList<>();
        try {
            String username = strings[0];

            URL url = new URL("http://" + IPAdress + "/misligas/obtenerJugadores.php");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);

            String data = "username=" + URLEncoder.encode(username, "UTF-8");

            // Escribir los datos en el flujo de salida
            OutputStream outputStream = conn.getOutputStream();
            outputStream.write(data.getBytes("UTF-8"));
            outputStream.flush();
            outputStream.close();

            // Leer la respuesta del servidor
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            reader.close();
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            JSONArray jsonArray = new JSONArray(response.toString());
            for (int i = 0; i < jsonArray.length(); i++) {
                String liga = jsonArray.getString(i);
                jugadoresString.add(liga);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return jugadoresString;
    }

    @Override
    protected void onPostExecute(List<String> strings) {
        jugadores.clear(); // Limpiar la lista antes de agregar nuevos elementos
        if (strings != null && !strings.isEmpty()) {
            for (String li: strings){
                try {
                    JSONObject jsonObject1 = new JSONObject(li);
                    jugadores.add(new Jugador(jsonObject1.getInt("ID_Jugador"),jsonObject1.getString("Posicion_Jugador"),
                            jsonObject1.getString("Nombre_Jugador"),jsonObject1.getString("Apellido_Jugador"),
                            jsonObject1.getInt("Lesionado"),jsonObject1.getString("nombre_usuario"),jsonObject1.getInt("ID_Equipo")));
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
