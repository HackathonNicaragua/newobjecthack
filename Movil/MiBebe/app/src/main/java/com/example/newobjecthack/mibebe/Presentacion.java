package com.example.newobjecthack.mibebe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by rober on 11/26/2017.
 */

public class Presentacion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_presentacion);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager_Presentacion);
        viewPager.setAdapter(new CustomPagerAdapter(this));

    }
}
