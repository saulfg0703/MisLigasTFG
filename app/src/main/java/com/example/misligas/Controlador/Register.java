package com.example.misligas.Controlador;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class Register extends AsyncTask<String, Void, String> {
    private Context context;

    public Register(Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(String... params) {
        String response = "";
        try {
            String username = params[0];
            String nombre = params[1];
            String apellidos = params[2];
            String email = params[3];
            String password = params[4];
            String telefono = params[5];
            String genero = params[6];
            String ciudad = params[7];
            String pais = params[8];
            String fecha = params[9];
            String idLiga = params[10];

            URL url = new URL("http://192.168.1.37/misligas/registro.php");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);

            String data = "username=" + URLEncoder.encode(username, "UTF-8")
                    + "&nombre=" + URLEncoder.encode(nombre, "UTF-8")
                    + "&apellidos=" + URLEncoder.encode(apellidos, "UTF-8")
                    + "&email=" + URLEncoder.encode(email, "UTF-8")
                    + "&password=" + URLEncoder.encode(password, "UTF-8")
                    + "&telefono=" + URLEncoder.encode(telefono, "UTF-8")
                    + "&genero=" + URLEncoder.encode(genero, "UTF-8")
                    + "&ciudad=" + URLEncoder.encode(ciudad, "UTF-8")
                    + "&pais=" + URLEncoder.encode(pais, "UTF-8")
                    + "&fecha=" + URLEncoder.encode(fecha, "UTF-8")
                    + "&idLiga=" + URLEncoder.encode(idLiga, "UTF-8");

            System.out.println(data);

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
        } else if (response.equals("Registro exitoso")) {
            // Registro exitoso
            Toast.makeText(context, "Error en la insercion", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Registro exitoso", Toast.LENGTH_SHORT).show();
        }
    }
}
