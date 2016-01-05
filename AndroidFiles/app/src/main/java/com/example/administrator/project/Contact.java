package com.example.administrator.project;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2015/11/25.
 */
public class Contact extends Activity{

    public String no;
    public String name;
    public String tel;
    public Contact(String xuehao,String name,String tel)
    {
        this.no = xuehao;
        this.name = name;
        this.tel = tel;
    }
    public String getNo()
    {
        return no;
    }
    public String getName()
    {
        return  name;
    }
    public String getTel()
    {
        return tel;
    }
}
