package com.example.misligas.Controlador;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.example.misligas.Modelo.Equipo;
import com.example.misligas.Modelo.modeloLigaUsuario;

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

public class obtenerEquiposDelUsuario extends AsyncTask<String, List<String>, List<String>> implements Configuracion{
    private Context context;

    public static ArrayList<Equipo> getEquipos() {
        return equipos;
    }

    public static void setEquipos(ArrayList<Equipo> equipos) {
        obtenerEquiposDelUsuario.equipos = equipos;
    }

    public static ArrayList<Equipo> equipos = new ArrayList<>();

    public obtenerEquiposDelUsuario(Context context) {
        this.context = context;
    }




    @Override
    protected List<String> doInBackground(String... strings) {
        StringBuilder response = new StringBuilder();
        List<String> equipos = new ArrayList<>();
        try {
            String username = strings[0];

            URL url = new URL("http://" + IPAdress + "/misligas/obtenerEquiposDelUsuario.php");
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
                equipos.add(liga);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return equipos;
    }

    @Override
    protected void onPostExecute(List<String> strings) {
        equipos.clear(); // Limpiar la lista antes de agregar nuevos elementos
        if (strings != null && !strings.isEmpty()) {
            for (String li: strings){
                try {
                    JSONObject jsonObject1 = new JSONObject(li);
                    equipos.add(new Equipo(jsonObject1.getInt("ID_Equipo"),jsonObject1.getString("Nombre_Equipo"),
                            jsonObject1.getString("Entrenador_Equipo"),jsonObject1.getString("Presidente_Equipo"),
                            jsonObject1.getString("Ciudad_Equipo"),jsonObject1.getInt("ID_Liga")));
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
