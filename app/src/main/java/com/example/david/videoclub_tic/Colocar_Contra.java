package com.example.david.videoclub_tic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Colocar_Contra extends AppCompatActivity {
    TextView usuario;
    TextView contraseña;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colocar__contra);

        usuario = (TextView) findViewById(R.id.editText2);
        contraseña = (TextView) findViewById(R.id.editText);

    }
    public void Ingresar(View f) {


        if (usuario.getText().toString().equals("") || contraseña.getText().toString().equals("")) {

            Toast.makeText(this, "Ingresa usuario o contraseña", Toast.LENGTH_SHORT).show();
        } else if (usuario.getText().toString().replace(" ", "").equals("admin") && contraseña.getText().toString().replace(" ", "").equals("123")) {
            //ingresar al usuario
            Intent usu = new Intent(this, menu_administrador.class);
            startActivity(usu);
        } else if (usuario.getText().toString().replace(" ", "").equals("cajero") && contraseña.getText().toString().replace(" ", "").equals("123")) {
            //ingresar al usuario
            Intent usu = new Intent(this, menu_cajero.class);
            startActivity(usu);
        } else {
            Toast.makeText(this, "El usuario o contraseña incorrecto", Toast.LENGTH_SHORT).show();
        }


    }
}
