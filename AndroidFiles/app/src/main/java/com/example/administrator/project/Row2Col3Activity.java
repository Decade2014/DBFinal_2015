package com.example.administrator.project;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;

/**
 * Created by Administrator on 2015/12/5.
 */
public class Row2Col3Activity extends Activity {
    TextView textView;
    ImageView imageView;
    TextView time;
    TextView biaoti;
    Cursor c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qiyexinxi);

        textView =(TextView)findViewById(R.id.textView12);
        imageView = (ImageView)findViewById(R.id.imageView3);
        textView =(TextView)findViewById(R.id.textView12);
        time = (TextView)findViewById(R.id.riqia);
        biaoti = (TextView)findViewById(R.id.biaotia);

        ViewGroup.LayoutParams para;
        para = imageView.getLayoutParams();
        para.height = MainActivity.height * 2/5;
        para.width = MainActivity.width;
        imageView.setLayoutParams(para);

        textView.setMovementMethod(ScrollingMovementMethod.getInstance());


            c = MainActivity.myDatabaseHelper.query();
   //     while (c.moveToNext()){
            c.moveToNext();
            c.moveToNext();
            c.moveToNext();
            time.setText(c.getString(c.getColumnIndex("no")));
            biaoti.setText(c.getString(c.getColumnIndex("name")));
            textView.setText(c.getString(c.getColumnIndex("tel")));
            c.close();
   //     }

    }
}
