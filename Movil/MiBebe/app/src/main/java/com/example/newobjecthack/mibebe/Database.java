package com.example.newobjecthack.mibebe;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by rober on 11/25/2017.
 */

public class Database extends SQLiteOpenHelper {

        //Sentencia SQL para crear la tabla de contacto
        String sqlmensajes = "CREATE TABLE message (IDchat INTEGER PRIMARY KEY,Numero TEXT, Cuerpo TEXT, idpaciente INTEGER, iddoctor INTEGER)";
        String sqlCreateCitas = "CREATE TABLE Citas (Id_Cite INTEGER PRIMARY KEY,Descripcion TEXT, Fecha TEXT, EdadGestacional INTEGER," +
                " Id_paciente INTEGER, PA TEXT, AlturaUterina TEXT, Presentacion TEXT )";


    public Database(Context contexto, String nombre,
                CursorFactory factory, int version) {
            super(contexto, nombre, factory, version);

    }

        @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL(sqlCreateCitas);
        db.execSQL(sqlmensajes);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {

            //Se elimina la versión anterior de la tabla
            db.execSQL("DROP TABLE IF EXISTS Citas");
            db.execSQL("DROP TABLE IF EXISTS message");

            //Se crea la nueva versión de la tabla
            db.execSQL(sqlCreateCitas);
            db.execSQL(sqlmensajes);


    }
}
