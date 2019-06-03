package com.example.saar;

import android.graphics.Color;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

public class MySpannable extends ClickableSpan {

    /**
     * Constructor
     */
    public MySpannable(boolean isUnderline) {
    }

    @Override
    public void updateDrawState(TextPaint ds) {
        ds.setTypeface(Typeface.DEFAULT);
        ds.setTextSize(40);
        ds.setColor(Color.parseColor("#0068CB"));
    }

    @Override
    public void onClick(View widget) {


    }
}