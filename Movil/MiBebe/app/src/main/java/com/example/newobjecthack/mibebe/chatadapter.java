package com.example.newobjecthack.mibebe;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by DTI34 on 25/11/2017.
 */

public class chatadapter extends ArrayAdapter<chat> {

    //protected Activity activity;
    //protected ArrayList<chat> chat;

    public chatadapter(Context context, ArrayList<chat> chat) {
        super(context, 0, chat);
    }

    /*@Override
    public int getCount() {
        return chat.size();
    }

    @Override
    public Object getItem(int position) {
        return chat.get(position);
    }

    @Override
    public long getItemId(int position) {
        return chat.get(position).Id_chat();
    }*/

    @Override
    public View getView(int position, View contentView, ViewGroup parent) {
        //View vi=contentView;
        //chat c = getItem(position);

        if(contentView == null) {
            /*LayoutInflater inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            vi = inflater.inflate(R.layout.row_lvmensajes, null);*/
            contentView = LayoutInflater.from(getContext()).inflate(R.layout.row_lvmensajes, parent, false);
        }

        chat item = getItem(position);

        TextView numero = (TextView) contentView.findViewById(R.id.from);
        numero.setText(item.Numero());

        TextView cuerpo = (TextView) contentView.findViewById(R.id.descripcion);
        cuerpo.setText(item.Cuerpo());

        /*TextView id_chat = (TextView) contentView.findViewById(R.id.id_chat);
        id_chat.setText(item.Id_chat());*/

        return contentView;
    }

}
