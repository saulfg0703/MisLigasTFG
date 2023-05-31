package com.example.misligas.Controlador;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class obtenerEstadisticasEquipoDelUsuario  extends AsyncTask<String, List<String>, List<String>> implements Configuracion{

    Context context;

    public obtenerEstadisticasEquipoDelUsuario(Context context) {
        this.context = context;
    }

    @Override
    protected List<String> doInBackground(String... strings) {
        StringBuilder response = new StringBuilder();
        List<String> estadisticas = new ArrayList<>();
        try {
            String username = strings[0];

            URL url = new URL("http://" + IPAdress + "/misligas/obtenerEstadisticas.php");
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
                estadisticas.add(liga);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return estadisticas;
    }

    @Override
    protected void onPostExecute(List<String> strings) {
        if (strings != null && !strings.isEmpty()) {
            Toast.makeText(context, strings.get(0).toString(), Toast.LENGTH_SHORT).show();
        } else {
            // No se encontraron ligas
            Toast.makeText(context, "No se encontraron ligas", Toast.LENGTH_SHORT).show();
        }
    }
}
