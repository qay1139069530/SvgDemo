package com.qbase.svgdemo;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;

public class ProviceItem {

    private Path path;

    private int drawColor;

    public ProviceItem(Path path) {
        this.path = path;
    }

    /**在此绘制*/
    public void drawItem(Canvas canvas, Paint paint,boolean isSelected){
        //边界
        paint.setStrokeWidth(2);
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.FILL);
        paint.setShadowLayer(8,0,0,0xffffffff);
        canvas.drawPath(path,paint);

        //填充
        paint.clearShadowLayer();
        paint.setColor(drawColor);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(2);
        canvas.drawPath(path,paint);
    }


    public void setDrawColor(int drawColor) {
        this.drawColor = drawColor;
    }
}
