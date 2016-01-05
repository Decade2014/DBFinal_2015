package com.example.administrator.project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2015/12/5.
 */
public class PersonAdapter extends ArrayAdapter<Person> {
    private  int resourceId;
    public PersonAdapter(Context context,int textViewResourceId,List<Person> objects)
    {
        super(context,textViewResourceId,objects);
        resourceId = textViewResourceId;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        Person person = getItem(position); // ��ȡ��ǰ���Fruitʵ��
        View view = LayoutInflater.from(getContext()).inflate(resourceId, null);
        ImageView fruitImage = (ImageView) view.findViewById(R.id.image);
        TextView tianqileixing = (TextView) view.findViewById(R.id.TianQi);
        fruitImage.setImageResource(person.getImageId());
        tianqileixing.setText(person.getTianqi());
        return view;
    }
}
