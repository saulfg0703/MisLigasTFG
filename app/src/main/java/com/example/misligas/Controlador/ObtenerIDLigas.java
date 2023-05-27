package com.example.misligas.Controlador;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class ObtenerIDLigas extends AsyncTask<Void, Void, List<String>> implements Configuracion{
    private Context context;
    private Spinner spinner;

    public ObtenerIDLigas(Context context, Spinner spinner) {
        this.context = context;
        this.spinner = spinner;
    }

    @Override
    protected List<String> doInBackground(Void... params) {
        List<String> ligas = null;
        try {
            URL url = new URL("http://"+IPAdress+"/misligas/obtenerIDLigas.php");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            // Leer la respuesta del servidor
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();
            conn.disconnect();

            // Analizar la respuesta JSON y obtener la lista de IDs de las ligas
            Gson gson = new Gson();
            ligas = gson.fromJson(response.toString(), new TypeToken<List<String>>() {}.getType());

        } catch (Exception e) {
            e.printStackTrace();
        }

        return ligas;
    }

    @Override
    protected void onPostExecute(List<String> ligas) {
        // Verificar si se obtuvieron ligas
        if (ligas != null && !ligas.isEmpty()) {
            // Crear un array de String con los IDs de las ligas
            String[] idsLigas = new String[ligas.size()];
            for (int i = 0; i < ligas.size(); i++) {
                idsLigas[i] = ligas.get(i); // Utiliza el valor directamente ya que es el ID de la liga
            }

            // Crear un nuevo ArrayAdapter y establecerlo en el Spinner
            ArrayAdapter<String> adapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_item, idsLigas);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        } else {
            // No se encontraron ligas
            Toast.makeText(context, "No se encontraron ligas", Toast.LENGTH_SHORT).show();
        }
    }
}
