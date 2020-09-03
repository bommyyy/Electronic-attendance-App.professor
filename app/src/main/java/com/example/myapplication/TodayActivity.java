package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class TodayActivity extends AppCompatActivity {
    ListView timetable;
    myAdapter adapter;
    String[] number = {"1","2","3","4","5","6"};
    String[] name={"종단형 PBL","종단형 PBL","데이터 베이스","시스템보안과 운영실습","전공진로탐색세미나","전공진로탐색세미나"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_today);

        timetable = (ListView) findViewById(R.id.timetable);
        adapter = new myAdapter();
        timetable.setAdapter(adapter);

        Button b = (Button)findViewById(R.id.btn_sub);
        b.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(
                        getApplicationContext(),
                        SemesterActivity.class);
                startActivity(intent);
            }
        });

        Button c = (Button)findViewById(R.id.btn_onair);
        c.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(
                        getApplicationContext(),
                        OnAirActivity.class);
                startActivity(intent);
            }
        });

        Button d = (Button)findViewById(R.id.btn_set);
        d.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(
                        getApplicationContext(),
                        SettingActivity.class);
                startActivity(intent);
            }
        });

        Button e = (Button)findViewById(R.id.btn_attend);
        e.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(
                        getApplicationContext(),
                        MidCheckActivity.class);
                startActivity(intent);
            }
        });
    }
    class myAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return number.length;
        }

        @Override
        public Object getItem(int position) {
            return number[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TodayView view = new TodayView(getApplicationContext());
            view.setNumber(number[position]);
            view.setName(name[position]);
            return view;
        }
    }
}

//지현 todayactivity