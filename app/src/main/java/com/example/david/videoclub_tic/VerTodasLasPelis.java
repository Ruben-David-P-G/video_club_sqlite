package com.example.david.videoclub_tic;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class VerTodasLasPelis extends AppCompatActivity implements View.OnClickListener {

    TextView textView;
    Button consultar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_todas_las_pelis);

        consultar = (Button)findViewById(R.id.consultar);
        textView = (TextView)findViewById(R.id.resultado);
        consultar.setOnClickListener(this);

    }
    BaseDeDatos admin = new BaseDeDatos(this, "administracion", null, 1);

    SQLiteDatabase bd = admin.getWritableDatabase();

    public void onClick(View v) {
        switch (v.getId()){
            case R.id.consultar:
        Cursor c = bd.rawQuery(" SELECT * FROM pelicula", null);

        if (c.moveToFirst()) {
            textView.setText(""); // Vacio el textview
            //Recorremos el cursor hasta que no haya más registros
            do {
                Integer codigo= c.getInt(0);
                String nombre = c.getString(1);
                String nombredirector = c.getString(2);
                String genero = c.getString(3);
                String idioma = c.getString(4);

                textView.append("Codigo: " +codigo+ " Nombre: " +nombre+ " Director: " +nombredirector+" Genero: "+genero+" Idioma: "+idioma+ "\n");

            } while(c.moveToNext());
        }

                break;

            default:

                break;
        }
    }
}
