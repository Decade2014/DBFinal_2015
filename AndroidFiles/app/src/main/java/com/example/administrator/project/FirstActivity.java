package com.example.administrator.project;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class FirstActivity extends Activity {
    Button skip;
    boolean if_skip = false;
 //  static public Context instance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
       // instance = this;
      //  this.equals(FirstActivity.this);
        skip = (Button)findViewById(R.id.skip);
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this, MainActivity.class);
                startActivity(intent);
                FirstActivity.this.finish();
                if_skip = true;
            }
        });

        Handler handler = new Handler();
         Runnable runnable = new Runnable() {
            @Override
            public void run() {
            //    Log.d("show","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
                if (!if_skip) {
             //       Log.d("show","bbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
                    Intent intent = new Intent(FirstActivity.this, MainActivity.class);
                        startActivity(intent);
                        FirstActivity.this.finish();
                }
            }
        };
        handler.postDelayed(runnable,5000);
    }
}
