package com.example.administrator.project;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.util.ByteArrayBuffer;
import org.apache.http.util.EncodingUtils;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by Administrator on 2015/12/8.
 */
public class ALiConnect extends Activity{
    TextView tv;
    Button appendBtn;
    Button clearBtn;
    View.OnClickListener btnClick;
    public static String myString = null;
    public  static  final  int UPDATE_CONTENT = 0;
    public static final  String url = "http://www.baidu.com";
    String urlStr="http://114.215.122.142:8080/DinnerClick/LoginServlet?";
    //114.125.122.142  172.16.82.93        10.0.2.2
    public EditText content;
    EditText username;
    EditText password;
    static  String temp;


    public void showDialog(String msg){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(msg).setCancelable(false).setPositiveButton("ȷ��",
                new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // TODO Auto-generated method stub

                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }
    public static Handler handler = new Handler(){
        public void handleMessage(Message msg){
            Person person1 = new Person(temp+""+msg.obj.toString(),Row1Col1Activity.select_pic(msg.obj.toString()));
            Row1Col1Activity.fruitList.add(person1);

        }
    };
    public static  void sendRequestWithHttpURLConnection(final  String url,final  String city){
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection = null;
                try {
                    String ctemp = city;
                    temp = city;
                    String city= ctemp;
                    city = URLEncoder.encode(URLEncoder.encode(ctemp, "utf-8"), "utf-8");
                    String url_city = url +"city=" +city;
                    connection = (HttpURLConnection) ((new URL(url_city).openConnection()));
                    InputStream in = connection.getInputStream();
                    BufferedInputStream bis = new BufferedInputStream(in);
                    ByteArrayBuffer baf = new ByteArrayBuffer(1024);
                    int current = 0;
                    while((current=bis.read())!=-1){
                        baf.append((byte)current);
                    }
                    myString = EncodingUtils.getString(baf.toByteArray(), "UTF-8");
                    Log.d("mystring3",myString);
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

}