package com.qbase.svgdemo;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.TextView;

public class TypefaceUtil {
    public static void setTypeface(TextView textView) {
        setTypeface(textView, "iconfont.ttf");
    }

    public static void setTypeface(TextView textView, String ttfAssets) {
        if (textView == null) {
            return;
        }
        if (textView.getContext() == null) {
            return;
        }
        Typeface iconTypeface = Typeface.createFromAsset(textView.getContext().getAssets(), ttfAssets);
        textView.setTypeface(iconTypeface);
    }

    public static Typeface getTypeface(Context context) {
        return getTypeface(context, "iconfont.ttf");
    }

    public static Typeface getTypeface(Context context, String ttfAssets) {
        return Typeface.createFromAsset(context.getAssets(), ttfAssets);
    }
}
