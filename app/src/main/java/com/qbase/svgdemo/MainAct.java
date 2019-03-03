package com.qbase.svgdemo;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);


        TextView textView01 = findViewById(R.id.text01);
        TextView textView02 = findViewById(R.id.text02);
        TextView textView03 = findViewById(R.id.text03);

        Typeface iconfont = Typeface.createFromAsset(getAssets(), "iconfont.ttf");
        TypefaceUtil.setTypeface(textView01);
        TypefaceUtil.setTypeface(textView02);
//        textView01.setTypeface(iconfont);
//        textView02.setTypeface(iconfont);
        textView03.setTypeface(iconfont);

        textView03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isSelected = v.isSelected();
                v.setSelected(!isSelected);
            }
        });




//        if (Build.VERSION.SDK_INT>Build.VERSION_CODES.LOLLIPOP){
//            //5.0
//            Drawable vectorDrawable = context.getDrawable(R.id.img_vector);
//            bitmap = Bitmap.createBitmap(vectorDrawable.getIntrinsicWidth(), vectorDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
//            Canvas canvas = new Canvas(bitmap);
//            vectorDrawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
//            vectorDrawable.draw(canvas);
//        }else {
//            Drawable drawable = AppCompatDrawableManager.get().getDrawable(context, R.id.img_vector);
//            bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
//            Canvas canvas = new Canvas(bitmap);
//            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
//            drawable.draw(canvas);
//        }
    }
}
