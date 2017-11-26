package com.example.newobjecthack.mibebe;

/**
 * Created by rober on 11/26/2017.
 */

public enum ModelObject_Presentacion {

    Slide1(R.string.slide1, R.layout.layout_slide1),
    Slide2(R.string.slide2, R.layout.layout_slide2),
    Slide3(R.string.slide3, R.layout.layout_slide3),
    Slide4(R.string.slide4, R.layout.layout_slide4),
    Slide5(R.string.slide5, R.layout.layout_slide5),
    Slide6(R.string.slide6, R.layout.layout_slide6),
    Slide7(R.string.slide7, R.layout.layout_slide7),
    Slide8(R.string.slide8, R.layout.layout_slide8),
    Slide9(R.string.slide9, R.layout.layout_slide9),
    Slide10(R.string.slide10, R.layout.layout_slide10),
    Slide11(R.string.slide11, R.layout.layout_slide11),
    Slide12(R.string.slide12, R.layout.layout_slide12),
    Slide13(R.string.slide13, R.layout.layout_slide13),
   // Slide14(R.string.slide14, R.layout.layout_slide14),
    //Slide15(R.string.slide15, R.layout.layout_slide15);
    Slide16(R.string.slide16, R.layout.layout_slide16);


    private  int  mTituloId;
    private int mLayoutId;


    ModelObject_Presentacion(int Titulo, int mlayout)
    {

        mTituloId= Titulo;
        mLayoutId= mlayout;

    }

    public int getTitleResId() {
        return mTituloId;
    }

    public int getLayoutResId() {
        return mLayoutId;
    }


}
