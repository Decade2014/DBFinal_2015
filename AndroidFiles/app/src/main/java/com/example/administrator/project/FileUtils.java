package com.example.administrator.project;

import android.content.Context;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Administrator on 2015/12/5.
 */
public class FileUtils {
    public void saveContent(Context context,String filename,String filetext){
        try {
            FileOutputStream fos = context.openFileOutput(filename,Context.MODE_PRIVATE);
            fos.write(filetext.getBytes());
            fos.close();
            Toast.makeText(context, "Save Context Success", Toast.LENGTH_SHORT).show();
        }
        catch (IOException e){
            Toast.makeText(context,"Save Context Failed",Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }
    public String getContent(Context context,String filename){
        try {
            FileInputStream fis = context.openFileInput(filename);
            byte[] contents = new byte[fis.available()];
            fis.read(contents);
            fis.close();
            Toast.makeText(context,"Read Context Success",Toast.LENGTH_SHORT).show();
            return  new String(contents);
        }
        catch (IOException e){
            Toast.makeText(context,"Read Context Failed",Toast.LENGTH_SHORT).show();
            e.printStackTrace();

            return new String("");
        }
    }
    public void deleteFile(Context context,String filename){
        context.deleteFile(filename);
        Toast.makeText(context,"Delete File Success",Toast.LENGTH_SHORT).show();
    }
}

