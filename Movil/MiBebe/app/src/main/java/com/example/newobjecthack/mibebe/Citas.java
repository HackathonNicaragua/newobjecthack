package com.example.newobjecthack.mibebe;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by rober on 11/25/2017.
 */

public class Citas extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Lammar la vista desde Menu_principal.xml
        setContentView(R.layout.layout_citas);
    }
}
