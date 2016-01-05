package com.example.administrator.project;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Administrator on 2015/12/5.
 */
public class Row2Col2Activity extends Activity{
    ImageView imageView;
    protected static TextView textView2;
    protected static TextView time2;
    protected static TextView biaoti2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jiuyezhidao);



        imageView = (ImageView)findViewById(R.id.imageView2);
        textView2 =(TextView)findViewById(R.id.textView11);

        time2 = (TextView)findViewById(R.id.riqi2);
        biaoti2 = (TextView)findViewById(R.id.biaoti2);

        ViewGroup.LayoutParams para;
        para = imageView.getLayoutParams();
        para.height = MainActivity.height * 2/5;
        para.width = MainActivity.width;
        imageView.setLayoutParams(para);

        textView2.setMovementMethod(ScrollingMovementMethod.getInstance());


        Cursor ca = MainActivity.myDatabaseHelper.query();
        //     while (c.moveToNext()){
        ca.moveToPrevious();
        ca.moveToNext();
        ca.moveToNext();
       // time2.setText("jini");
        time2.setText(ca.getString(ca.getColumnIndex("no")));
        biaoti2.setText(ca.getString(ca.getColumnIndex("name")));
        textView2.setText(ca.getString(ca.getColumnIndex("tel")));
        ca.close();
        //     }
    }
}
