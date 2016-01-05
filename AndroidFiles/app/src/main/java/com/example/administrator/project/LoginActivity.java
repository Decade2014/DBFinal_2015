package com.example.administrator.project;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import org.apache.http.util.ByteArrayBuffer;
import org.apache.http.util.EncodingUtils;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Administrator on 2015/12/5.
 */
public class LoginActivity extends Activity{
    //设定访问模式
    // AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView)findViewById(R.id.name);
    AutoCompleteTextView user;
    AutoCompleteTextView psw;
    Button register;
    String user_name;
    String user_password;
    Button login;
    CheckBox isChecked;
    public  static  final  int UPDATE_CONTENT = 0;
    String url_login="http://114.215.122.142:8080/DinnerClick/LoginServlet?";
    String url_register="http://114.215.122.142:8080/DinnerClick/SignServlet?";
    public  String myString;
    public  String myString2;
    public static int MODE = Context.MODE_WORLD_READABLE +Context.MODE_WORLD_WRITEABLE;
    public static final String PREFERENCE_NAME = "SaveSetting";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login);
            user = (AutoCompleteTextView) findViewById(R.id.tianqileixing);
            psw = (AutoCompleteTextView) findViewById(R.id.psw);
            register = (Button) findViewById(R.id.register);
            login = (Button) findViewById(R.id.login);
            isChecked = (CheckBox) findViewById(R.id.checkBox);

            register.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    user_name = user.getText().toString();
                    user_password = psw.getText().toString();
                    url_register = url_register+  "username=" + user_name + "&password=" + user_password;
                    sendRequestWithHttpURLConnection2();
                }
            });

            isChecked.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                }
            });
            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                       user_name = user.getText().toString();
                       user_password = psw.getText().toString();
                       url_login = url_login +  "username=" + user_name + "&password=" + user_password;
                       sendRequestWithHttpURLConnection();
                }
            });

    }
    public  Handler handler = new Handler(){
        public void handleMessage(Message message){
            switch (message.what){
                case UPDATE_CONTENT:
                {
                    Log.d("messageoooo", message.obj.toString());
                    if(message.obj.toString().equals("true")) {
                        Toast.makeText(LoginActivity.this, "Login Success", Toast.LENGTH_SHORT).show();
                        MainActivity.if_login = 1;
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                    else
                    {
                        Toast.makeText(LoginActivity.this, "Login Error", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        }
    };
    public  Handler handler2 = new Handler(){
        public void handleMessage(Message message){
            switch (message.what){
                case UPDATE_CONTENT:
                {
                    Log.d("messagexxxxxx", message.obj.toString());
                    if(message.obj.toString().equals("true")) {
                        Toast.makeText(LoginActivity.this, "Register Success", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginActivity.this,Welcome.class);
                        startActivity(intent);
                    }
                    else
                    {
                        Toast.makeText(LoginActivity.this, "Register Failure", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        }
    };
    private void sendRequestWithHttpURLConnection(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection = null;
                try {
                 //   Log.d("url:: ",url_login);
                    connection = (HttpURLConnection) ((new URL(url_login.toString()).openConnection()));
                    InputStream in = connection.getInputStream();
                    BufferedInputStream bis = new BufferedInputStream(in);
                    ByteArrayBuffer baf = new ByteArrayBuffer(1024);
                    int current = 0;
                    while((current=bis.read())!=-1){
                        baf.append((byte)current);
                    }
                    myString = EncodingUtils.getString(baf.toByteArray(), "UTF-8");
                    Log.d("mystring",myString);
                    Message message = new Message();
                    message.what = UPDATE_CONTENT;
                    message.obj =myString;
                    handler.sendMessage(message);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                finally {
                    if(connection != null){
                        connection.disconnect();
                    }
                }
            }

        }).start();
    }
    private void sendRequestWithHttpURLConnection2(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection = null;
                try {
                    //   Log.d("url:: ",url_login);
                    connection = (HttpURLConnection) ((new URL(url_register.toString()).openConnection()));
                    InputStream in = connection.getInputStream();
                    BufferedInputStream bis = new BufferedInputStream(in);
                    ByteArrayBuffer baf = new ByteArrayBuffer(1024);
                    int current = 0;
                    while((current=bis.read())!=-1){
                        baf.append((byte)current);
                    }
                    myString2 = EncodingUtils.getString(baf.toByteArray(), "UTF-8");
                    Log.d("mystring2",myString2);

                    Message message = new Message();
                    message.what = UPDATE_CONTENT;
                    message.obj =myString2;
                    handler2.sendMessage(message);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                finally {
                    if(connection != null){
                        connection.disconnect();
                    }
                }
            }
        }).start();
    }

}
