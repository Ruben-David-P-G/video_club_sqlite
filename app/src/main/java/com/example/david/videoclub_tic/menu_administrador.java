package com.example.david.videoclub_tic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class menu_administrador extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_administrador);
    }
    public void Irincer_peli(View z){

        Intent princi= new Intent(this, Incertar_Pelicula.class);
        startActivity(princi);
    }
    public void Irincer_venta(View z){

        Intent princi= new Intent(this, incertar_venta.class);
        startActivity(princi);
    }
    public void Irincer_renta(View z){

        Intent princi= new Intent(this, Incertar_renta.class);
        startActivity(princi);
    }
    public void irinicio(View z){

        Intent princi= new Intent(this, Principal.class);
        startActivity(princi);
    }
}
