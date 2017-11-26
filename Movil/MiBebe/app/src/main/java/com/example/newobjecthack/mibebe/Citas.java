package com.example.newobjecthack.mibebe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

/**
 * Created by rober on 11/25/2017.
 */

public class Citas extends AppCompatActivity {
    ListView listView;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Lammar la vista desde Menu_principal.xml
        setContentView(R.layout.layout_citas);

        Notificaciones_Adapter whatever = new Notificaciones_Adapter(this, fecha, titulo,descripcion, imagen);
        listView = (ListView) findViewById(R.id.lista_notificaciones);
        listView.setAdapter(whatever);



    }

    String[] fecha = {"11/25/2017", "11/26/2017", "11/27/2017", "11/28/2017",
            "11/29/2017", "11/30/2017"};


    String[] titulo = {
            "Consulta General",
            "Consulta General",
            "Pediatra",
            "Ginecologo",
            "Consulta General",
            "Examen de Orina"
    };

    String[] descripcion = {
            "Desc 1",
            "Desc 2",
            "Desc 3",
            "Desc 4",
            "Desc 5",
            "Desc 6"
    };
    Integer[] imagen = {
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,};

}


