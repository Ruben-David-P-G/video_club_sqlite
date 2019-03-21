package com.example.david.videoclub_tic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class menu_cajero extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_cajero);
    }
    public void ver_peli(View z){

        Intent princi= new Intent(this, Ver_Peli.class);
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
