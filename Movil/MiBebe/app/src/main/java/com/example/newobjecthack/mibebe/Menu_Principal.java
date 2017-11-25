package com.example.newobjecthack.mibebe;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.support.v7.widget.Toolbar;
import android.widget.TableRow;

import java.util.ArrayList;

public class Menu_Principal extends AppCompatActivity{

    Button btn_citas;


    Toolbar toolbar;
    CollapsingToolbarLayout collapsingToolbarLayout;
    CoordinatorLayout rootlayoutAndroid;
    TableRow gridView;
    Context context;
    ArrayList arrayList;

    public static String[] gridViewSettings =
            {
                 "","","","",""
            };

    public static int[] gridViewImages =
            {
                    R.mipmap.mibebe_logo, R.mipmap.mibebe_logo,
                    R.mipmap.mibebe_logo, R.mipmap.mibebe_logo,R.mipmap.mibebe_logo
            };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu__principal);
        btn_citas=(Button) findViewById(R.id.btn_citas);

        btn_citas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Iniciar Activity Citas

                Intent MyIntent= new Intent(Menu_Principal.this, Citas.class);
                startActivity(MyIntent);
            }
        });

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        gridView = (TableRow) findViewById(R.id.grid);
        /*gridView.setAdapter(new CustomGridViewAdapter(this, gridViewSettings,gridViewImages));*/

        initinstances();
    }


    private void initinstances(){

        rootlayoutAndroid= (CoordinatorLayout) findViewById(R.id.android_coordinator_layout);
        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar_android_layout);
        collapsingToolbarLayout.setTitle("MiBebe");
    }


}
