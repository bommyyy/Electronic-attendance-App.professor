package com.example.myapplication;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

public class MidCheck2Activity extends AppCompatActivity {
    ListView notable;
    myAdapter midcheckadapter;
    String[] midchecknumber = {"1","2","3","4"};
    String[] midcheckname={"김슬기","김정원","김지현","이보미"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_midcheck2);

        notable = (ListView) findViewById(R.id.notable);
        midcheckadapter = new myAdapter();
        notable.setAdapter(midcheckadapter);
    }
    class myAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return midchecknumber.length;
        }

        @Override
        public Object getItem(int position) {
            return midchecknumber[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            MidCheck2View view = new MidCheck2View(getApplicationContext());
            view.setNumber(midchecknumber[position]);
            view.setName(midcheckname[position]);
            return view;
        }
    }
}
