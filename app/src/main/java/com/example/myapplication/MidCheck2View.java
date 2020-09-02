package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MidCheck2View extends LinearLayout {
    TextView textView3;
    TextView textView4;
    public MidCheck2View(Context context) {
        super(context);
        inflation_init(context);
        textView3 = (TextView) findViewById(R.id.textView3);
        textView4 = (TextView) findViewById(R.id.textView4);
    }

    private void inflation_init(Context context){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.midcheck2_item,this,true);
    }

    public void setNumber(String number){textView3.setText(number);}
    public void setName(String name){textView4.setText(name);}
}
