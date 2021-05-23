package com.example.myapplication;


import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class SubItemView extends LinearLayout {
    TextView textView, textView2;


    public SubItemView(Context context){
        super(context);
        init(context);
    }

    public SubItemView(Context context, @Nullable AttributeSet attrs){
        super(context, attrs);
        init(context);
    }

    private void init(Context context){
        LayoutInflater inflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.sub_item,this,true);

        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);
    }

    public void setNum(String num){
        textView.setText(num);
    }

    public void setName(String name){
        textView2.setText(name);
    }
}

//Semeseter액티비티에 들어가는 데이터 클래스