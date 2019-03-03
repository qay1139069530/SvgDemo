package com.qbase.svgdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class MapView extends View {

    private Context context;
    private int[] colorArray = new int[]{0xf44336, 0xFFef9a9a, 0xE91E63, 0xf48fb1
            , 0x9C27B0, 0xce93d8
            , 0x673AB7, 0xb39ddb
            , 0x3F51B5, 0x9fa8da
            , 0x00BCD4, 0x80deea
            , 0x4CAF50, 0xa5d6a7
            , 0xFF9800, 0xffcc80};

    private List<ProviceItem> itemList;

    private float scale = 1.0f;

    private Paint paint;

    public MapView(Context context) {
        super(context);
    }

    public MapView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public MapView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MapView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    private void init(Context context) {
        this.context = context;
        paint = new Paint();
        myThread.start();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (itemList != null) {
            canvas.save();
            //原始值 为像素
            canvas.scale(scale, scale);//缩放
            for (ProviceItem item : itemList) {
                item.drawItem(canvas, paint, false);
            }
        }
    }

    private Thread myThread = new Thread() {
        @Override
        public void run() {
            super.run();
            InputStream inputStream = context.getResources().openRawResource(R.raw.china);
            List<ProviceItem> list = new ArrayList<>();
            try {
                //document 解析  很耗性能
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = null;
                builder = factory.newDocumentBuilder();
                Document document = builder.parse(inputStream);

                Element rootElement = document.getDocumentElement();
                NodeList items = rootElement.getElementsByTagName("path");
                for (int i = 0; i < items.getLength(); i++) {
                    Element element = (Element) items.item(i);
                    //得到android:pathData中数据
                    String pathData = element.getAttribute("android:pathData");
                    //解析android:pathData中数据
                    Path path = PathParser.createPathFromPathData(pathData);
                    ProviceItem proviceItem = new ProviceItem(path);
                    list.add(proviceItem);
                }
                itemList = list;
                handler.sendEmptyMessage(1);
            } catch (ParserConfigurationException e) {
                e.printStackTrace();
            } catch (SAXException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    };


    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (itemList == null) {
                return;
            }
            //赋值颜色
            int totalNumber = itemList.size();
            for (int i = 0; i < totalNumber; i++) {
                int color = Color.GREEN;
                int flag = i % 15;
                color = colorArray[flag];
                itemList.get(i).setDrawColor(color);
            }
            postInvalidate();
        }
    };

}
