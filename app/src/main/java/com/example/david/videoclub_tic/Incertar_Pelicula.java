package com.example.david.videoclub_tic;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Incertar_Pelicula extends AppCompatActivity {

    private EditText e1, e2, e3, e4,e5;
    String num_peli, nomb, nom_direc, gene,idiom;
    Toast t1, t2, t3, t4, t5, t6, t7, t8;
    boolean x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incertar__pelicula);

        e1 = (EditText) findViewById(R.id.editText1);
        e2 = (EditText) findViewById(R.id.editText2);
        e3 = (EditText) findViewById(R.id.editText3);
        e4 = (EditText) findViewById(R.id.editText4);
        e5 = (EditText) findViewById(R.id.editText5);

    }
    public void Limpiar(View l){

        e1.setText("");
        e2.setText("");
        e3.setText("");
        e4.setText("");
        e5.setText("");
    }
    public boolean ValidarCampos(View vc){

        if(e1.getText().toString().equals("") || e2.getText().toString().equals("") || e3.getText().toString().equals("") || e4.getText().toString().equals("")|| e5.getText().toString().equals("")){

            t7 = Toast.makeText(this, R.string.msj1, Toast.LENGTH_SHORT);
            t7.setGravity(Gravity.CENTER, 0, 0);
            t7.show();
            return false;

        }
        else {

            return true;

        }
    }

    public boolean ValidarMatricula(View vm){

        if(e1.getText().toString().equals("")){
            t8= Toast.makeText(this,R.string.msj2, Toast.LENGTH_SHORT);
            t8.setGravity(Gravity.CENTER, 0, 0);
            t8.show();
            return false;
        }
        else{

            return true;
        }

    }

    public void Alta(View a){


        x = ValidarCampos(a);

        if (x) {

            BaseDeDatos admin = new BaseDeDatos(this, "administracion", null, 1);

            SQLiteDatabase bd = admin.getWritableDatabase();

            num_peli = e1.getText().toString();
            nomb = e2.getText().toString();
            nom_direc = e3.getText().toString();
            gene = e4.getText().toString();
            idiom = e5.getText().toString();

            ContentValues registro = new ContentValues();

            registro.put("id_pelicula", num_peli);
            registro.put("nombre", nomb);
            registro.put("nom_director", nom_direc);
            registro.put("genero", gene);
            registro.put("idioma", idiom);


            bd.insert("pelicula", null, registro);  //Registrando al alumno

            bd.close(); //Cerrando al BD

            Limpiar(a);
            t1 = Toast.makeText(this, R.string.msj3, Toast.LENGTH_SHORT);
            t1.setGravity(Gravity.CENTER, 0, 0);
            t1.show();
        }

    }

    public void Buscar(View bb){


        x = ValidarMatricula(bb);

        if (x) {
            BaseDeDatos admin = new BaseDeDatos(this, "administracion", null, 1);

            SQLiteDatabase bd = admin.getWritableDatabase();

            num_peli = e1.getText().toString();

            Cursor fila = bd.rawQuery("select nombre, nom_director, genero, idioma from pelicula where id_pelicula=" + num_peli, null); //Consulta de búsqueda

            if (fila.moveToFirst()) {

                e2.setText(fila.getString(0));
                e3.setText(fila.getString(1));
                e4.setText(fila.getString(2));
                e5.setText(fila.getString(3));

            } else {
                t2 = Toast.makeText(this, R.string.msj4, Toast.LENGTH_SHORT);
                t2.setGravity(Gravity.CENTER, 0, 0);
                t2.show();
            }

            bd.close();
        }

    }
    public void Baja(View b){


        x = ValidarMatricula(b);

        if (x) {
            BaseDeDatos admin = new BaseDeDatos(this, "administracion", null, 1);

            SQLiteDatabase bd = admin.getWritableDatabase();

            num_peli = e1.getText().toString();

            int cant = bd.delete("pelicula", "id_pelicula=" + num_peli, null); //Eliminando alumno

            bd.close();

            Limpiar(b);

            if (cant == 1) {

                t3 = Toast.makeText(this, R.string.msj5, Toast.LENGTH_SHORT);
                t3.setGravity(Gravity.CENTER, 0, 0);
                t3.show();

            } else {

                t4 = Toast.makeText(this, R.string.msj4, Toast.LENGTH_SHORT);
                t4.setGravity(Gravity.CENTER, 0, 0);
                t4.show();


            }
        }

    }
    public void Actual(View aa){

        x = ValidarMatricula(aa);

        if (x) {

            BaseDeDatos admin = new BaseDeDatos(this, "administracion", null, 1);

            SQLiteDatabase bd = admin.getWritableDatabase();

            num_peli = e1.getText().toString();
            nomb = e2.getText().toString();
            nom_direc = e3.getText().toString();
            gene = e4.getText().toString();
            idiom = e5.getText().toString();

            ContentValues registro = new ContentValues();

            registro.put("nombre", nomb);  //Actualizando los registros
            registro.put("nom_director", nom_direc);
            registro.put("genero", gene);
            registro.put("idioma", idiom);

            int cant = bd.update("pelicula", registro, "id_pelicula=" + num_peli, null);

            bd.close();

            if (cant == 1) {

                t5 = Toast.makeText(this, R.string.msj6 , Toast.LENGTH_SHORT);
                t5.setGravity(Gravity.CENTER, 0, 0);
                t5.show();


            } else {

                t6 = Toast.makeText(this, R.string.msj4, Toast.LENGTH_SHORT);
                t6.setGravity(Gravity.CENTER, 0, 0);
                t6.show();

            }

        }
    }
    public void irinicio(View z){

        Intent princi= new Intent(this, Principal.class);
        startActivity(princi);
    }

}
