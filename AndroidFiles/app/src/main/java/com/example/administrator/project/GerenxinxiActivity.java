package com.example.administrator.project;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Administrator on 2015/12/5.
 */
public class GerenxinxiActivity extends Activity {
    FileUtils fileUtils;
    // FileName fileName;
    //EditText fileName = (EditText)findViewById(R.id.fileName);

    AutoCompleteTextView careCity;
    AutoCompleteTextView love;
    AutoCompleteTextView fileName;
    AutoCompleteTextView fileContext;
    Button savefile;
    Button readFile;
    Button deleteFile ;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // requestWindowFeature(R.Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_gerenxinxi);
        fileUtils = new FileUtils();
        fileName = ( AutoCompleteTextView)findViewById(R.id.fileName);
        fileContext = (AutoCompleteTextView)findViewById(R.id.fileText);
        love = (AutoCompleteTextView)findViewById(R.id.love);
        careCity = (AutoCompleteTextView)findViewById(R.id.careCity);
        savefile = (Button)findViewById(R.id.saveFile);
        readFile = (Button)findViewById(R.id.readFile);
        deleteFile = (Button)findViewById(R.id.deleteFile);
        /*
        autoCompleteTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fileUtils.saveContent(EditFileActivity.this, autoCompleteTextView.getText().toString(), fileContext.getText().toString());
                autoCompleteTextView.setAdapter(new ArrayAdapter<String>(EditFileActivity.this, R.layout.activity_edit_file), EditFileActivity.this.fileList()))
                ;
            }

        });*/
        savefile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = getSharedPreferences("data", MODE_APPEND).edit();
                editor.putString("user_sheng", fileName.getText().toString());
                editor.putString("user_city", fileContext.getText().toString());
              //  editor.commit();
               // SharedPreferences.Editor editor2 = getSharedPreferences("care", MODE_APPEND).edit();
                editor.putString("careCity", careCity.getText().toString());
                editor.putString("love", love.getText().toString());
                editor.commit();
           //     fileUtils.saveContent( GerenxinxiActivity.this,fileName.getText().toString(),fileContext.getText().toString());
           //     fileName.setAdapter(new ArrayAdapter<String>( GerenxinxiActivity.this, android.R.layout.simple_dropdown_item_1line, GerenxinxiActivity.this.fileList()));
                Toast.makeText(GerenxinxiActivity.this,"保存个人信息成功", Toast.LENGTH_SHORT).show();
            }
        });
        readFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
           //     fileContext.setText(fileUtils.getContent( GerenxinxiActivity.this, fileName.getText().toString()));
           //     fileName.setAdapter(new ArrayAdapter<String>( GerenxinxiActivity.this, android.R.layout.simple_dropdown_item_1line,  GerenxinxiActivity.this.fileList()));
           //     Toast.makeText(GerenxinxiActivity.this,"保存个人信息成功", Toast.LENGTH_SHORT).show();
                SharedPreferences sharedPreferences = getSharedPreferences("data", MODE_APPEND);
                String sheng = sharedPreferences.getString("user_sheng", "");
                String city = sharedPreferences.getString("user_city", "");
                fileName.setText(sheng);
                fileContext.setText(city);

              //  SharedPreferences sharedPreferences2 = getSharedPreferences("care", MODE_APPEND);
                String cityCarea = sharedPreferences.getString("careCity", "");
                String lovea = sharedPreferences.getString("love", "");
                love.setText(lovea);
                careCity.setText(cityCarea);
                Toast.makeText(GerenxinxiActivity.this,"读取个人信息成功", Toast.LENGTH_SHORT).show();
            }
        });
        deleteFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             //   fileUtils.deleteFile( GerenxinxiActivity.this, fileName.getText().toString());
              //  fileName.setAdapter(new ArrayAdapter<String>( GerenxinxiActivity.this, android.R.layout.simple_dropdown_item_1line,  GerenxinxiActivity.this.fileList()));
               // fileContext.setText("");
                SharedPreferences.Editor editor = getSharedPreferences("data", MODE_APPEND).edit();
                editor.putString("user_sheng","");
                editor.putString("user_city", "");
               // editor.commit();
              //  SharedPreferences.Editor editor2 = getSharedPreferences("care", MODE_APPEND).edit();
                editor.putString("careCity","");
                editor.putString("love","");
                editor.commit();
                fileName.setText("");
                fileContext.setText("");
                love.setText("");
                careCity.setText("");
                Toast.makeText(GerenxinxiActivity.this,"删除个人信息成功", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
