package com.example.berg.doublety.entidades;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Berg on 22/03/16.
 */
public class FentonRegular extends TextView {
    public FentonRegular(Context context) {
        super(context);
        setTypefaceFat(context);
    }

    public FentonRegular(Context context, AttributeSet attrs) {
        super(context, attrs);
        setTypefaceFat(context);
    }

    public FentonRegular(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setTypefaceFat(context);
    }

    public FentonRegular(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        setTypefaceFat(context);
    }
    private void setTypefaceFat(Context context){
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), "fonts/fenton_regular.otf");
        setTypeface(typeface);
    }

}
