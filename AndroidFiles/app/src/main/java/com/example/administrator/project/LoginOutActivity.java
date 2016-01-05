package com.example.administrator.project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.*;

/**
 * Created by Administrator on 2015/12/8.
 */
public class LoginOutActivity extends Activity {
    Button logout;
    Intent to;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_out);
        logout = (Button)findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
      @Override
          public void onClick(View v) {
          MainActivity.if_login = 0;
          to = new Intent(LoginOutActivity.this,LoginActivity.class);
          startActivity(to);
        }
      });

}}
