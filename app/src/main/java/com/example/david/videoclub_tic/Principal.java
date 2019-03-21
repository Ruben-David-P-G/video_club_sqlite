package com.example.david.videoclub_tic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Principal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
    }
    public void IrMenuCajero(View z){

        Intent princi= new Intent(this, Colocar_Contra.class);
        startActivity(princi);
    }
    public void IrMenuAdministrador(View z){

        Intent princi= new Intent(this, Colocar_Contra.class);
        startActivity(princi);
    }
    public void Salir(View z){

       finish();
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
