package com.example.newobjecthack.mibebe;

import android.content.Context;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

public class Menu_Principal extends AppCompatActivity {
    Toolbar toolbar;
    CollapsingToolbarLayout collapsingToolbarLayout;
    CoordinatorLayout rootlayoutAndroid;
    GridView gridView;
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

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        gridView = (GridView) findViewById(R.id.grid);
        gridView.setAdapter(new CustomGridViewAdapter(this, gridViewSettings,gridViewImages));

        initinstances();
    }

    private void initinstances(){

        rootlayoutAndroid= (CoordinatorLayout) findViewById(R.id.android_coordinator_layout);
        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar_android_layout);
        collapsingToolbarLayout.setTitle("MiBebe");
    }
}
