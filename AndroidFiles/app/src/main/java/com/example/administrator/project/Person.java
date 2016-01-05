package com.example.administrator.project;

import android.util.Log;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Created by Administrator on 2015/12/5.
 */
public class Person {
    private  String tianqi;
    private  int imageId;
    public  Person(String tianqi,int imageId){
        this.tianqi=  tianqi;
        this.imageId = imageId;
    }
    public int getImageId(){
        return  imageId;
    }
    public String getTianqi(){
        return tianqi;
    }

    public String trans(String str) {
        //    String str = "测试字符转换 hello word"; //默认环境，已是UTF-8编码
        try {
            String strGBK = URLEncoder.encode(str, "GBK");
            String unicode = URLEncoder.encode(str, "Unicode");
            Log.d("yuanlai",str);
            Log.d("unicode",unicode);
            String strUTF8 = URLDecoder.decode(str, "UTF-8");
            //    System.out.println(strUTF8);
            return strUTF8;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
