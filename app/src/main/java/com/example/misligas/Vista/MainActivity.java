package com.example.misligas.Vista;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.misligas.Controlador.Login;
import com.example.misligas.Controlador.Register;
import com.example.misligas.R;

public class MainActivity extends Activity {

    private Button btnRegister;
    //Login
    private EditText nombreUsuario;
    private EditText contrasenaUsuario;
    private Button btnIniciar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View rootView = getWindow().getDecorView();
        rootView.setBackgroundColor(getResources().getColor(R.color.colorPrimary));

        //Registro
        btnRegister = findViewById(R.id.btn_registro);

        //Login
        btnIniciar = findViewById(R.id.btn_login);
        nombreUsuario = findViewById(R.id.et_usuario);
        contrasenaUsuario = findViewById(R.id.et_contraseña);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Registro.class);
                startActivity(intent);
            }
        });

        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = nombreUsuario.getText().toString();
                String password = contrasenaUsuario.getText().toString();
                login(username, password);
            }
        });
    }

    private void login(String username, String password) {
        // Crea una instancia de DatabaseTask y llámala para ejecutarla
        Login databaseTask = new Login(MainActivity.this);
        databaseTask.execute(username, password);
    }


}
