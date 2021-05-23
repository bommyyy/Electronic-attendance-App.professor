package com.example.myapplication;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Setting2Activity extends AppCompatActivity {

    HttpClient httpclient;
    HttpPost httppost;
    List<NameValuePair> nameValuePairs;
    HttpResponse response;

    String rest;
    String late;
    String absent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.group1);
        radioGroup.setOnCheckedChangeListener(radioGroupButtonChangeListener);
        RadioGroup radioGroup2 = (RadioGroup) findViewById(R.id.group2);
        radioGroup2.setOnCheckedChangeListener(radioGroupButtonChangeListener);
        RadioGroup radioGroup3 = (RadioGroup) findViewById(R.id.group3);
        radioGroup3.setOnCheckedChangeListener(radioGroupButtonChangeListener);

        Button b = (Button) findViewById(R.id.btn_save2);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new Thread(new Runnable() {
                    public void run() {
                        login();
                    }
                }).start();
            }
        });
    }

    RadioGroup.OnCheckedChangeListener radioGroupButtonChangeListener = new RadioGroup.OnCheckedChangeListener(){

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if(checkedId == R.id.r1_10){
                Toast.makeText(Setting2Activity.this, "쉬는시간을 10분으로 설정하였습니다.",Toast.LENGTH_SHORT).show();
                rest = "10";
            }
            else if(checkedId == R.id.r1_15){
                Toast.makeText(Setting2Activity.this, "쉬는시간을 15분으로 설정하였습니다.",Toast.LENGTH_SHORT).show();
                rest = "15";
            }
            else if(checkedId == R.id.r1_20){
                Toast.makeText(Setting2Activity.this, "쉬는시간을 20분으로 설정하였습니다.",Toast.LENGTH_SHORT).show();
                rest = "20";
            }
            else if(checkedId == R.id.r2_5){
                Toast.makeText(Setting2Activity.this, "지각시간 기준을 5분으로 설정하였습니다.",Toast.LENGTH_SHORT).show();
                late = "5";
            }
            else if(checkedId == R.id.r2_10){
                Toast.makeText(Setting2Activity.this, "지각시간 기준을 10분으로 설정하였습니다.",Toast.LENGTH_SHORT).show();
                late = "10";
            }
            else if(checkedId == R.id.r2_15){
                Toast.makeText(Setting2Activity.this, "지각시간 기준을 15분으로 설정하였습니다.",Toast.LENGTH_SHORT).show();
                late = "15";
            }
            else if(checkedId == R.id.r3_30){
                Toast.makeText(Setting2Activity.this, "결석 기준을 수업 끝나기 전 30분으로 설정하였습니다.",Toast.LENGTH_SHORT).show();
                absent = "30";
            }
            else if(checkedId == R.id.r3_60){
                Toast.makeText(Setting2Activity.this, "결석 기준을 수업 끝나기 전 60분으로 설정하였습니다.",Toast.LENGTH_SHORT).show();
                absent = "60";
            }
            else if(checkedId == R.id.r3_90){
                Toast.makeText(Setting2Activity.this, "결석 기준을 수업 끝나기 전 1시간 30분으로 설정하였습니다.",Toast.LENGTH_SHORT).show();
                absent = "90";
            }
        }
    };
    void login() {
        try {
            EditText editText = (EditText)findViewById(R.id.group4_edit);
            String another = editText.getText().toString();
            httpclient = new DefaultHttpClient();
            httppost = new HttpPost("http://192.168.219.199/profsetting2.php");//ip주소변경

            nameValuePairs = new ArrayList<NameValuePair>(4);
            nameValuePairs.add(new BasicNameValuePair("rest", rest));
            nameValuePairs.add(new BasicNameValuePair("late", late));
            nameValuePairs.add(new BasicNameValuePair("absent", absent));
            nameValuePairs.add(new BasicNameValuePair("another", another));
            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs, HTTP.UTF_8));
            response = httpclient.execute(httppost);
            ResponseHandler<String> responseHandler = new BasicResponseHandler();
            final String response = httpclient.execute(httppost, responseHandler);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                    }
                });
                Intent intent = new Intent(
                        getApplicationContext(),
                        SettingActivity.class);
                startActivity(intent);

        }catch (IOException e) {
            System.out.println("Exception : " + e.getMessage());
        }

    }
}
