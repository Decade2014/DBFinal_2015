package com.example.administrator.project;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Administrator on 2015/12/5.
 */
public class Row2Col1Activity extends Activity{
    ImageView imageView;
    TextView textView;
    TextView time3;
    TextView biaoti3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tuijianzhiwei);


        imageView = (ImageView)findViewById(R.id.imageView4);
        textView =(TextView)findViewById(R.id.textView13);

        time3 = (TextView)findViewById(R.id.riqi3);
        biaoti3 = (TextView)findViewById(R.id.biaoti3);

        ViewGroup.LayoutParams para;
        para = imageView.getLayoutParams();
        para.height = MainActivity.height * 1/3;
        para.width = MainActivity.width;
        imageView.setLayoutParams(para);

        textView.setMovementMethod(ScrollingMovementMethod.getInstance());

        Cursor c = MainActivity.myDatabaseHelper.query();
        //     while (c.moveToNext()){
        c.moveToNext();
        c.getString(c.getColumnIndex("tel"));
        time3.setText(c.getString(c.getColumnIndex("no")));
        biaoti3.setText(c.getString(c.getColumnIndex("name")));
        textView.setText(c.getString(c.getColumnIndex("tel")));
    }
}
