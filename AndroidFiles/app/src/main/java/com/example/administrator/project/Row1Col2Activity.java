package com.example.administrator.project;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import org.apache.http.util.ByteArrayBuffer;
import org.apache.http.util.EncodingUtils;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by Administrator on 2015/12/5.
 */
public class Row1Col2Activity extends Activity{

    Button yeseterday;
    Button today;
    Button tomorrow;
    String url_city="http://114.215.122.142:8080/DinnerClick/getToday?";
    String url_city_yes="http://114.215.122.142:8080/DinnerClick/getYesterday?";
    String url_city_tom="http://114.215.122.142:8080/DinnerClick/getTomorrow?";
    public  String myString,myString2,myString3;
    String city,city_yes,city_tom;
    String sheng;
    String love;
    public  static  final  int UPDATE_CONTENT = 0;
    public int width;
    public int height;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acticity_qiyezhaoping);

        DisplayMetrics metric = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metric);
        width = metric.widthPixels;
        height = metric.heightPixels;
        yeseterday = (Button)findViewById(R.id.yesterday);
        today = (Button)findViewById(R.id.Today);
        tomorrow =(Button)findViewById(R.id.Tomorrow);

        SharedPreferences sharedPreferences = getSharedPreferences("data", MODE_APPEND);
        city = sharedPreferences.getString("user_city", "");
        sheng = sharedPreferences.getString("user_sheng", "");
        love = sharedPreferences.getString("love", "");
        city_yes = city_tom = city;
        sendRequestWithHttpURLConnection();
        sendRequestWithHttpURLConnection2();
        sendRequestWithHttpURLConnection3();

        yeseterday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("city", city);
                Intent intent = new Intent(Row1Col2Activity.this, FindCity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        today.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("city",city);
                Intent intent = new Intent(Row1Col2Activity.this,FindCity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        tomorrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("city",city);
                Intent intent = new Intent(Row1Col2Activity.this,FindCity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    public void choosePicture(Button button,String str)
    {
        if(str.contains("多云"))  button.setBackgroundDrawable(getResources().getDrawable(R.drawable.duoyun));
        else if(str.contains("晴"))  button.setBackgroundDrawable(getResources().getDrawable(R.drawable.qing));
        else if(str.contains("阴"))  button.setBackgroundDrawable(getResources().getDrawable(R.drawable.ying));
        else if(str.contains("雾"))  button.setBackgroundDrawable(getResources().getDrawable(R.drawable.wu));
        else if(str.contains("雨"))  button.setBackgroundDrawable(getResources().getDrawable(R.drawable.yu));
        else if(str.contains("小雪"))  button.setBackgroundDrawable(getResources().getDrawable(R.drawable.xiaoxue));
        else if(str.contains("雪"))  button.setBackgroundDrawable(getResources().getDrawable(R.drawable.xue));
        else button.setBackgroundDrawable(getResources().getDrawable(R.drawable.wu));
    }
    private Handler handler = new Handler(){
        public void handleMessage(Message msg){
            ViewGroup.LayoutParams para2;
            para2 = today.getLayoutParams();
            para2.height = height / 3;
            para2.width = width;
            today.setLayoutParams(para2);
            if(myString.contains(love))
            today.setText(sheng+city+"今天："+myString + " 是喜欢类型");
            else  today.setText(sheng+city+"今天："+myString);
            if(myString.length() > 3) {
                String subString =myString;
                Log.e("subString", subString);
                //      if (subString.equals("多云"))
                //          today.setBackgroundDrawable(getResources().getDrawable(R.drawable.sun));
                choosePicture(today,subString);
            }
        }
    };
    private void sendRequestWithHttpURLConnection(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection = null;
                try {
                    String city2 = city;
                    city2 = URLEncoder.encode(URLEncoder.encode(city2, "utf-8"), "utf-8");
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
            ViewGroup.LayoutParams para;
            para = yeseterday.getLayoutParams();
            para.height = height / 3;
            para.width = width;
            yeseterday.setLayoutParams(para);
            if(myString2.contains(love))
                yeseterday.setText(sheng+city+"昨天："+myString2+" 是喜欢类型");
            else   yeseterday.setText(sheng+city+"昨天："+myString2);
            if(myString2.length() > 3) {
                choosePicture(yeseterday,myString2);
            }
        }
    };
    private void sendRequestWithHttpURLConnection2(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection = null;
                try {
                    String city_yes2 = city_yes;
                    city_yes = URLEncoder.encode(URLEncoder.encode(city_yes2, "utf-8"),"utf-8");
                    url_city_yes = url_city_yes +"city="+city_yes;
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
            ViewGroup.LayoutParams para3;
            para3 = tomorrow.getLayoutParams();
            para3.height = height / 3;
            para3.width = width;
            tomorrow.setLayoutParams(para3);
            if(myString3.contains(love))
            tomorrow.setText(sheng+city+"明天："+myString3+" 是喜欢类型");
            else  tomorrow.setText(sheng+city+"明天："+myString3);
            if(myString3.length() > 3) {
                choosePicture(tomorrow,myString3);
            }
        }
    };
    private void sendRequestWithHttpURLConnection3(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection = null;
                try {
                    String city_tom2 = city_tom;
                    city_tom = URLEncoder.encode(URLEncoder.encode(city_tom2, "utf-8"),"utf-8");
                    url_city_tom = url_city_tom +"city="+city_tom;
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
                    Message message = new Message();
                    message.what = UPDATE_CONTENT;
                    message.obj =myString3;
                    handler3.sendMessage(message);
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
