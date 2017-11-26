package com.example.newobjecthack.mibebe;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by rober on 11/25/2017.
 */

public class Notificaciones_Adapter extends ArrayAdapter {

    //Arreglo boleano para capturar el estado del checkbox

    boolean[] checkBoxState;


    //Referencia al activity
    private final Activity context;

    //Cargar la imagen de notificacion
    private final Integer[] imagen_notificacion;

    //Cargar la fecha de la notificacion
    private final String[] fecha_notificacion;

    //Cargar el titulo de la notificacion
    private final String[] titulo_notificacion;
    //Cargar la descripcion de la notificacion
    private final String[] descripcion_notificacion;

    public Notificaciones_Adapter(Activity context, String[] fecha, String[] titulo, String[] descripcion, Integer[] imagen){

        super(context,R.layout.layout_columnas_citas , fecha);

        this.context=context;
        this.imagen_notificacion = imagen;
        this.fecha_notificacion = fecha;
        this.titulo_notificacion = titulo;
        this.descripcion_notificacion = descripcion;

    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.layout_columnas_citas, null,true);

        //Instanciar los elementos de layour_columnas_citas.xml
        TextView fecha = (TextView) rowView.findViewById(R.id.txt_fecha);
        TextView titulo = (TextView) rowView.findViewById(R.id.txt_titulo);
        TextView descripcion = (TextView) rowView.findViewById(R.id.txt_descripcion);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.imageView);

        //Cargar en los controles la lista de arreglos(fecha,titulo y descripcion)
        fecha.setText(fecha_notificacion[position]);
        titulo.setText(titulo_notificacion[position]);
        descripcion.setText(descripcion_notificacion[position]);
        imageView.setImageResource(imagen_notificacion[position]);

        return rowView;

    };
}
