package com.example.david.videoclub_tic;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by David on 08/04/2016.
 */
public class BaseDeDatos extends SQLiteOpenHelper {
    public BaseDeDatos(Context context, String nombre, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, nombre, factory, version);
    }


    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE pelicula(id_pelicula integer primary key,nombre text,nom_director text, genero text,idioma varchar(30))");
        db.execSQL("CREATE TABLE venta(id_venta integer primary key,id_pelicula integer,costo float)");
        db.execSQL("CREATE TABLE renta(id_renta integer primary key,id_pelicula integer,fecha_entrega date, fecha_devolucion date)");


    }

    public void onUpgrade(SQLiteDatabase db, int version1, int version2) {
        db.execSQL("drop table if exists cliente");
        db.execSQL("create table cliente(clave_cliente integer primary key,nombre_cli text,telefono int, email text,domicilio varchar(40))");
        db.execSQL("drop table if exists proveedor");
        db.execSQL("create table proveedor(clave_proveedor integer primary key,nombre_pro text,nombre_empresa text, telefono int, email text,domicilio varchar(40))");

    }
}