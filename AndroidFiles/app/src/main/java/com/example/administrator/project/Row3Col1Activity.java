package com.example.administrator.project;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2015/12/5.
 */
public class Row3Col1Activity extends Activity{
    EditText sousuoneirong;
    Button sosuo;
    WebView webView;
    String neirong;
    String first;
    String second;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sousuo);
        sousuoneirong = (EditText) findViewById(R.id.sousuoneirong);
        sosuo = (Button) findViewById(R.id.sosuo);
        sosuo.setOnClickListener(new View.OnClickListener() {
                                     @Override
         public void onClick(View v) {
                                         neirong = sousuoneirong.getText().toString();
                                         if(neirong.length()>3) {
                                             first = neirong.substring(0, 2);
                                             second = neirong.substring(3);
                                             MainActivity.myDatabaseHelper.insert2(first, second);
                                         }
                                         init();
         }
     }
        );

    }
    private void init(){
        webView = (WebView) findViewById(R.id.webView);
        //WebView加载web资源
        Map<String,String> map=new HashMap<String, String>();
        map.put("User-Agent", "Android");
        webView.loadUrl("http://www.baidu.com/s?wd="+sousuoneirong.getText().toString()+"&rsv_bp=0&ch=&tn=baidu&bar=&rsv_spt=3&ie=utf-8&rsv_sug3=3&rsv_sug=0&rsv_sug4=95&rsv_sug1=1&inputT=1001",map);
    //    webView.loadDataWithBaseURL("我","http://baidu.com","","","");
     //   webView.loadUrl("www.baidu/s?wd=" + sosuo.getText().toString()+"&rsv_bp");
        //覆盖WebView默认使用第三方或系统默认浏览器打开网页的行为，使网页用WebView打开
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                // TODO Auto-generated method stub
                //返回值是true的时候控制去WebView打开，为false调用系统浏览器或第三方浏览器
                view.loadUrl(url);
                return true;
            }
        });
    }
}
