package com.example.misligas.Vista;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.misligas.Controlador.ObtenerIDLigas;
import com.example.misligas.Controlador.Register;
import com.example.misligas.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Registro extends Activity {
    //Registro
    private EditText registroUsuario;
    private EditText registroNombre;
    private EditText registroApellido;
    private EditText registroEmail;
    private EditText registroPassword;
    private EditText registroTelefono;
    private EditText registroGenero;
    private EditText registroCiudad;
    private EditText registroPais;
    private EditText registroFecha;
    private Spinner registroIdLiga;
    private Button btnRegistro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        registroUsuario = findViewById(R.id.et_usuario);
        registroNombre = findViewById(R.id.et_nombre);
        registroApellido = findViewById(R.id.et_apellido);
        registroEmail = findViewById(R.id.et_email);
        registroPassword = findViewById(R.id.et_contraseña);
        registroTelefono = findViewById(R.id.et_telefono);
        registroGenero = findViewById(R.id.et_genero);
        registroCiudad = findViewById(R.id.et_ciudad);
        registroPais = findViewById(R.id.et_pais);
        registroFecha = findViewById(R.id.et_fecha);
        registroIdLiga = findViewById(R.id.spinner_liga);
        btnRegistro = findViewById(R.id.btn_registro);

        ObtenerIDLigas obtenerLigasTask = new ObtenerIDLigas(Registro.this,registroIdLiga);
        obtenerLigasTask.execute();

        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registro();
                limpiarCampos();
            }
        });




    }
    private void registro() {
        try {
            String username = registroUsuario.getText().toString();
            String nombre = registroNombre.getText().toString();
            String apellidos = registroApellido.getText().toString();
            String email = registroEmail.getText().toString();
            String password = registroPassword.getText().toString();
            String telefono = registroTelefono.getText().toString();
            String genero = registroGenero.getText().toString();
            String ciudad = registroCiudad.getText().toString();
            String pais = registroPais.getText().toString();


            String fechaString = registroFecha.getText().toString();
            String idLiga = registroIdLiga.getSelectedItem().toString();
            SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MM-yyyy");
            SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
            if (fechaString.matches("\\d{4}-\\d{2}-\\d{2}")) {
                Register registerTask = new Register(Registro.this);
                registerTask.execute(username, nombre, apellidos, email, password, telefono, genero, ciudad, pais, fechaString, idLiga);
            } else {
                // Verificar que todos los campos obligatorios estén llenos
                if (username.isEmpty() || password.isEmpty() || nombre.isEmpty() || apellidos.isEmpty() ||
                        email.isEmpty() || telefono.isEmpty() || genero.isEmpty() || ciudad.isEmpty() ||
                        pais.isEmpty() || fechaString.isEmpty() || idLiga.isEmpty()) {
                    Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show();
                } else {
                    Date fecha = null;
                    try {
                        fecha = inputFormat.parse(fechaString);
                    } catch (ParseException e) {
                        Toast.makeText(this, "Error: Fecha incorrecta", Toast.LENGTH_SHORT).show();
                    }

                    // Formatea la fecha al formato deseado
                    String fechaFormateada = outputFormat.format(fecha);

                    // Crea una instancia de Register y llámala para ejecutarla
                    Register registerTask = new Register(Registro.this);
                    registerTask.execute(username, nombre, apellidos, email, password, telefono, genero, ciudad, pais, fechaFormateada, idLiga);
                }
                }
            } catch(NullPointerException e){
                Toast.makeText(this, "Error: Algunos campos son nulos", Toast.LENGTH_SHORT).show();
            }
        }

    private void limpiarCampos(){
        registroUsuario.setText("");
        registroNombre.setText("");
        registroApellido.setText("");
        registroEmail.setText("");
        registroPassword.setText("");
        registroTelefono.setText("");
        registroGenero.setText("");
        registroCiudad.setText("");
        registroPais.setText("");
        registroFecha.setText("");
    }



}