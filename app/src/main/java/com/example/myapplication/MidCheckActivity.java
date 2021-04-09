package com.example.myapplication;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.ProgressDialog;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.StrictMode;
import android.view.View;
import android.widget.Button;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class MidCheckActivity extends AppCompatActivity {
    HttpClient httpclient;
    HttpPost httppost;
    HttpResponse response;
    List<NameValuePair> nameValuePairs;
    ProgressDialog dialog = null;
    public static Context context_main;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mid_check);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button b = (Button) findViewById(R.id.btn_join);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(
                        getApplicationContext(),
                        MidCheck2Activity.class);
                startActivity(intent);
            }
        });//by지현


        //--------------------중간 출석버튼 클릭시 push_notification.php 실행--------------------
        context_main = this;
        Button c = (Button) findViewById(R.id.button2);
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dialog = ProgressDialog.show(MidCheckActivity.this, "",
                        "Send Push alarm", true);
                new Thread(new Runnable() {
                    public void run() {
                        middlecheck();
                    }
                }).start();
            }
        });
    }

    void middlecheck() {
        try {
           // String token = FirebaseInstanceId.getInstance().getToken(); //(?)
            httpclient = new DefaultHttpClient();
            httppost = new HttpPost("http://192.168.219.199/push_notification2.php"); //ip주소변경
            //nameValuePairs = new ArrayList<NameValuePair>(1);
            //nameValuePairs.add(new BasicNameValuePair("Token", token));
            //httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
            response = httpclient.execute(httppost);
            ResponseHandler<String> responseHandler = new BasicResponseHandler();
            final String response = httpclient.execute(httppost, responseHandler);

        } catch (Exception e)
        {
            System.out.println("Exception : " + e.getMessage());
        }
    }
}
