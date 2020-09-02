package com.example.myapplication;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class OnAir2Data {
    TextView stu_no;
    TextView stu_name;
    ImageView btn_o;
    ImageView btn_a;
    ImageView btn_x;
    OnAir2Data(View v)
    {
        stu_no = v.findViewById(R.id.txt_no3);
        stu_name = v.findViewById(R.id.txt_name3);
        btn_o=v.findViewById(R.id.btn_O3);
        btn_a=v.findViewById(R.id.btn_A3);
        btn_x=v.findViewById(R.id.btn_X3);


    }
}
