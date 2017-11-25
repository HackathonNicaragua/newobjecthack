package com.example.newobjecthack.mibebe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by rober on 11/23/2017.
 */

public class CustomGridViewAdapter extends BaseAdapter {

    private Context mContext;
    private final String[] string;
    private final int[] Imageid;

    public CustomGridViewAdapter(Context c,String[] string, int[] imageid) {

        mContext = c;
        this.Imageid = imageid;
        this.string= string;
    }

    @Override
    public int getCount() {
        return string.length;
    }

    @Override
    public Object getItem(int p) {
        return null;
    }

    @Override
    public long getItemId(int p) {
        return 0;
    }

    @Override
    public View getView(int p, View convertView, ViewGroup parent) {
        View grid;

        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null)
        {
            grid = new View(mContext);
            grid= inflater.inflate(R.layout.activity_grid_personalizado,null);
            TextView textView= (TextView) grid.findViewById(R.id.gridview_text);
            ImageView imageView= (ImageView) grid.findViewById(R.id.gridview_image);
            textView.setText(string[p]);
            imageView.setImageResource(Imageid[p]);

        }

        else {

            grid = (View) convertView;
        }

        return grid;
    }
}
