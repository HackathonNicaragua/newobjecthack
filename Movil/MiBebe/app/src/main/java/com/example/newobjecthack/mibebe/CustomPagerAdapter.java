package com.example.newobjecthack.mibebe;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by rober on 11/26/2017.
 */

public class CustomPagerAdapter extends PagerAdapter {

    private Context mContext;

    public CustomPagerAdapter(Context context) {
        mContext = context;
    }

    public Object instantiateItem(ViewGroup collection, int position) {
        ModelObject_Presentacion modelObject = ModelObject_Presentacion.values()[position];
        LayoutInflater inflater = LayoutInflater.from(mContext);
        ViewGroup layout = (ViewGroup) inflater.inflate(modelObject.getLayoutResId(), collection, false);
        collection.addView(layout);
        return layout;
    }

    @Override
    public void destroyItem(ViewGroup collection, int position, Object view) {
        collection.removeView((View) view);
    }

        @Override
    public int getCount() {
        return ModelObject_Presentacion.values().length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view== object;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        ModelObject_Presentacion customPagerEnum = ModelObject_Presentacion.values()[position];

        return mContext.getString(customPagerEnum.getTitleResId());
    }
}
