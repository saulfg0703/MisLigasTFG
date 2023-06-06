package com.example.misligas.Controlador;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.misligas.Modelo.modeloLigaUsuario;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class dataBaseManager implements Configuracion {
    public static final String TAG = "dataBaseManager";
    private static final String PHP_URL = "http://"+IPAdress+"/misligas/buscarLiga.php";
    private ExecutorService executor = Executors.newSingleThreadExecutor();

    public LiveData<List<modeloLigaUsuario>> makeDatabaseRequest(final String data) {
        final MutableLiveData<List<modeloLigaUsuario>> resultLiveData = new MutableLiveData<>();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL(PHP_URL);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("POST");
                    connection.setDoOutput(true);

                    // Aquí se puede enviar cualquier dato adicional necesario para la petición
                    String postData = "username=" + data;

                    byte[] postDataBytes = postData.getBytes(StandardCharsets.UTF_8);
                    connection.getOutputStream().write(postDataBytes);

                    int responseCode = connection.getResponseCode();
                    if (responseCode == HttpURLConnection.HTTP_OK) {
                        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                        StringBuilder response = new StringBuilder();
                        String line;
                        while ((line = reader.readLine()) != null) {
                            response.append(line);
                        }
                        reader.close();
                        final String result = response.toString();

                        // Actualizar el LiveData con el resultado obtenido
                        // Parsear el resultado JSON a una lista de objetos Equipo
                        Gson gson = new Gson();
                        List<modeloLigaUsuario> equipos = gson.fromJson(result, new TypeToken<List<modeloLigaUsuario>>() {}.getType());
                        resultLiveData.postValue(equipos);
                    } else {
                        Log.e(TAG, "Error en la petición HTTP: " + responseCode);
                    }
                    connection.disconnect();
                } catch (Exception e) {
                    Log.e(TAG, "Excepción durante la petición HTTP: " + e.getMessage());
                }
            }
        };

        Future<?> future = executor.submit(runnable);
        try {
            future.get(); // Espera hasta que la tarea se complete (puede lanzar excepciones)
        } catch (Exception e) {
            Log.e(TAG, "Excepción durante la ejecución de la tarea: " + e.getMessage());
        }
        return resultLiveData;
    }
}
