package com.example.misligas.Controlador;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.example.misligas.Modelo.modeloLigaUsuario;
import com.example.misligas.fragmentos.fragmentoLigas;

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

public class obtenerClasificacionUsuario extends AsyncTask<String, List<String>, List<String>> implements Configuracion {
    private Context context;
   public static ArrayList<modeloLigaUsuario> clasificacion = new ArrayList<>();



    public obtenerClasificacionUsuario(Context context) {
        this.context = context;

    }
    public obtenerClasificacionUsuario() {

    }

    public static  ArrayList<modeloLigaUsuario> getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(ArrayList<modeloLigaUsuario> clasificacion) {
        this.clasificacion = clasificacion;
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
            clasificacion.clear(); // Limpiar la lista antes de agregar nuevos elementos
        if (ligas != null && !ligas.isEmpty()) {
            Toast.makeText(context, ligas.get(0), Toast.LENGTH_SHORT).show();
            for (String li: ligas){
                try {
                    JSONObject jsonObject1 = new JSONObject(li);
                    clasificacion.add(new modeloLigaUsuario(jsonObject1.getInt("Puntos"), jsonObject1.getString("Nombre_Equipo")));
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        } else {
            Toast.makeText(context, "No se encontraron ligas", Toast.LENGTH_SHORT).show();
        }
    }



}