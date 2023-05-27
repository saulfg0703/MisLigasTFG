package com.example.misligas.Controlador;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import com.example.misligas.Modelo.Usuario;
import com.example.misligas.Vista.VisualizadorDatos;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;


public class Login extends AsyncTask<String, Void, String> implements Configuracion{
    private Context context;

    public Login(Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(String... params) {
        String response = "";
        try {
            String username = params[0];
            String password = params[1];


            URL url = new URL("http://"+IPAdress+"/misligas/login.php");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);

            String data = "username=" + URLEncoder.encode(username, "UTF-8")
                    + "&password=" + URLEncoder.encode(password, "UTF-8");

            // Escribir los datos en el flujo de salida
            OutputStream outputStream = conn.getOutputStream();
            outputStream.write(data.getBytes("UTF-8"));
            outputStream.flush();
            outputStream.close();

            // Leer la respuesta del servidor
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                response += line;
            }
            reader.close();
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }

    @Override
    protected void onPostExecute(String response) {
        if (response.isEmpty()) {
            // La respuesta del servidor está vacía
            Toast.makeText(context, "No se encontraron datos", Toast.LENGTH_SHORT).show();
        } else {
            Gson gson = new Gson();
            try {
                Usuario usuario = gson.fromJson(response, Usuario.class);
                Intent intent = new Intent(context, VisualizadorDatos.class);
                intent.putExtra("usuario", usuario);
                context.startActivity(intent);
            } catch (JsonSyntaxException e) {
                // Error al analizar la respuesta JSON
                Toast.makeText(context, "Credenciales de inicio de sesion incorrectas", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
