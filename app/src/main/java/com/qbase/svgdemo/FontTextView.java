package com.qbase.svgdemo;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

public class FontTextView extends AppCompatTextView{

    public FontTextView(Context context) {
        super(context);
        initFont(context);
    }

    public FontTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initFont(context);
    }

    public FontTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initFont(context);
    }

    private void initFont(Context context){
        Typeface font = Typeface.createFromAsset(context.getAssets(), "iconfont.ttf");
        this.setTypeface(font);
    }
}
