package com.example.misligas.Controlador;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

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

public class obtenerClasificacionDelUsuario extends AsyncTask<String, List<String>, List<String>> implements Configuracion {
    private Context context;

    public obtenerClasificacionDelUsuario(Context context) {
        this.context = context;
    }


    @Override
    protected List<String> doInBackground(String... params) {
        StringBuilder response = new StringBuilder();
        List<String> ligas = new ArrayList<>();
        try {
            String username = params[0];

            URL url = new URL("http://" + IPAdress + "/misligas/obtenerLigasDelUsuario.php");
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
                ligas.add(liga);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return ligas;
    }

    @Override
    protected void onPostExecute(List<String> ligas) {
        // Verificar si se obtuvieron ligas
        if (ligas != null && !ligas.isEmpty()) {
            Toast.makeText(context, ligas.get(0).toString(), Toast.LENGTH_SHORT).show();
        } else {
            // No se encontraron ligas
            Toast.makeText(context, "No se encontraron ligas", Toast.LENGTH_SHORT).show();
        }
    }
}