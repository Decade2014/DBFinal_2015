package com.example.administrator.project;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.ByteArrayBuffer;
import org.apache.http.util.EncodingUtils;
import org.apache.http.util.EntityUtils;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/12/5.
 */
public class Row1Col1Activity extends Activity{
    public  static  final  int UPDATE_CONTENT = 0;
    public String send;
    public EditText content;
    public String myString,myString2,myString3;
    Button connect;
    Button button;
    public int count;
    String temp1,temp2,temp3;
    String city,city_yes,city_tom;
    TextView textView;
    private String[]data = {"apple","banana","cherry","coco","kiwi","orange","pear","strawberry","watermelon"};
    String url_city="http://114.215.122.142:8080/DinnerClick/getToday?";
    String url_city_yes="http://114.215.122.142:8080/DinnerClick/getToday?";
    String url_city_tom="http://114.215.122.142:8080/DinnerClick/getToday?";
    public static List<Person> fruitList = new ArrayList<Person>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiaoyuanzhaoping);
        count = 0;
        initPerons(); //  初始化水果数据
        final PersonAdapter adapter = new PersonAdapter(Row1Col1Activity.this, R.layout.activity_person_item, fruitList);
        final ListView listView = (ListView) findViewById(R.id.listView5);
        listView.setAdapter(adapter);
     //   content = (EditText)findViewById(R.id.editText3);
        connect = (Button)findViewById(R.id.connect);
        textView = (TextView)findViewById(R.id.textView10);

        fruitList = new ArrayList<Person>();
        connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count == 0) {

                    SharedPreferences sharedPreferences = getSharedPreferences("data", MODE_APPEND);
                    String cityCare = sharedPreferences.getString("careCity", "");
                    Log.e("cityCare", cityCare);
                 //   temp1 = sharedPreferences.getString("user_city", "");
                    if(cityCare.length() >1) city = cityCare.substring(0, 2);
                //    temp2 = sharedPreferences.getString("user_city", "");
                    if(cityCare.length() >3) city_yes = cityCare.substring(3, 5);
                //    temp3 = sharedPreferences.getString("user_city", "");
                    if(cityCare.length() >5) city_tom = cityCare.substring(6,8);
                    // SharedPreferences sharedPreferences2 = getSharedPreferences("care", MODE_APPEND);
                    textView.setText(cityCare);
                    if(cityCare.length()>1) sendRequestWithHttpURLConnection();
                    if(cityCare.length()>3) sendRequestWithHttpURLConnection2();
                    if(cityCare.length()>5) sendRequestWithHttpURLConnection3();
                //    ALiConnect.sendRequestWithHttpURLConnection(url_city,city);
                }
                count++;
            }
        });

        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = (EditText)findViewById(R.id.editText3);
                String show = editText.getText().toString();
                String url_city_new = "http://114.215.122.142:8080/DinnerClick/getToday?";
                ALiConnect.sendRequestWithHttpURLConnection(url_city_new,show);
            //    final PersonAdapter adapter = new PersonAdapter(Row1Col1Activity.this, R.layout.activity_person_item, fruitList);
             //   listView.setAdapter(adapter);
                Message message = new Message();
                message.what = UPDATE_CONTENT;
                message.obj = "ww";
                handler4.sendMessage(message);
            }
        });
    }
    private void initPerons() {
        String str1 = "阿里巴巴";
        /*
      //  String tempstr = new String(str1.getBytes(),"UTF-8");
        String str2 = "网页前端";
        Person person1 = new Person(str1,"10K-15K",str2, R.drawable.company_alibaba);
        Log.d("ali", str1);
        fruitList.add(person1);
        Person person2 = new Person("腾讯","4K-9K","架构师", R.drawable.company_tencent);
        fruitList.add(person2);
        */
    }
    private Handler handler4 = new Handler(){
        public void handleMessage(Message msg){
          //  Person person1 = new Person(city+":"+msg.obj.toString(),select_pic(msg.obj.toString()));
           // fruitList.add(person1);
            final PersonAdapter adapter = new PersonAdapter(Row1Col1Activity.this, R.layout.activity_person_item, fruitList);
            final ListView listView = (ListView) findViewById(R.id.listView5);
            listView.setAdapter(adapter);
        }
    };
    private Handler handler = new Handler(){
        public void handleMessage(Message msg){
            Person person1 = new Person(city+":"+msg.obj.toString(),select_pic(msg.obj.toString()));
            fruitList.add(person1);
            final PersonAdapter adapter = new PersonAdapter(Row1Col1Activity.this, R.layout.activity_person_item, fruitList);
            final ListView listView = (ListView) findViewById(R.id.listView5);
            listView.setAdapter(adapter);
        }
    };
    private void sendRequestWithHttpURLConnection(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection = null;
                try {
                    String city2 = city;

                    city2 = URLEncoder.encode(URLEncoder.encode(city2, "utf-8"),"utf-8");
                    url_city = url_city +"city="+city2;
                    connection = (HttpURLConnection) ((new URL(url_city).openConnection()));
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
    private Handler handler2 = new Handler(){
        public void handleMessage(Message msg){
            Person person2 = new Person(city_yes+":"+msg.obj.toString(),select_pic(msg.obj.toString()));
            fruitList.add(person2);
            final PersonAdapter adapter = new PersonAdapter(Row1Col1Activity.this, R.layout.activity_person_item, fruitList);
            final ListView listView = (ListView) findViewById(R.id.listView5);
            listView.setAdapter(adapter);
        }
    };
    private void sendRequestWithHttpURLConnection2(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection = null;
                try {
                    String city_yes2 = city_yes;
                    city_yes2 = URLEncoder.encode(URLEncoder.encode(city_yes2, "utf-8"),"utf-8");
                    url_city_yes = url_city_yes +"city="+city_yes2;
                    connection = (HttpURLConnection) ((new URL(url_city_yes).openConnection()));
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

    private Handler handler3 = new Handler(){
        public void handleMessage(Message msg){
            Person person3 = new Person(city_tom+":"+msg.obj.toString(),select_pic(msg.obj.toString()));
            Log.e("person3",msg.obj.toString());
            fruitList.add(person3);
            final PersonAdapter adapter = new PersonAdapter(Row1Col1Activity.this, R.layout.activity_person_item, fruitList);
            final ListView listView = (ListView) findViewById(R.id.listView5);
            listView.setAdapter(adapter);
        }
    };
    private void sendRequestWithHttpURLConnection3(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection = null;
                try {
                    String city_tom2 = city_tom;
                    city_tom2 = URLEncoder.encode(URLEncoder.encode(city_tom2, "utf-8"),"utf-8");
                    url_city_tom = url_city_tom +"city="+city_tom2;
                    connection = (HttpURLConnection) ((new URL(url_city_tom).openConnection()));
                    InputStream in = connection.getInputStream();
                    BufferedInputStream bis = new BufferedInputStream(in);
                    ByteArrayBuffer baf = new ByteArrayBuffer(1024);
                    int current = 0;
                    while((current=bis.read())!=-1){
                        baf.append((byte)current);
                    }
                    myString3 = EncodingUtils.getString(baf.toByteArray(), "UTF-8");
                    Log.d("mystring3",myString3);
                    Message message3 = new Message();
                    message3.what = UPDATE_CONTENT;
                    message3.obj =myString3;
                    handler3.sendMessage(message3);
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
    public static int  select_pic(String str)
    {
        if( str.contains("晴")) return  R.drawable.sun;
        else if(str.contains("云")) return R.drawable.clouds;
        else if(str.contains("雨")) return  R.drawable.xiayu;
        else if(str.contains("雪")) return R.drawable.xiaxue;
        else return R.drawable.sun_cloud;
    }
}
