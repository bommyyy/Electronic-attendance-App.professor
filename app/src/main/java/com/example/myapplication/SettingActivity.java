package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;


import java.util.ArrayList;

public class SettingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        ListView listview = findViewById(R.id.subtable);

        semAdapter adapter = new semAdapter();

        adapter.addItem(new Sub_item("1","데이터베이스"));
        adapter.addItem(new Sub_item("2","종단형 PBL"));
        adapter.addItem(new Sub_item("3","JAVA"));
        adapter.addItem(new Sub_item("4","C언어"));
        adapter.addItem(new Sub_item("5","악성코드"));
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                Intent intent = new Intent(getApplicationContext(),Setting2Activity.class);
                startActivity(intent);
            }
        });
    }


    class semAdapter extends BaseAdapter{
        private ArrayList<Sub_item> items = new ArrayList<>();

        public void addItem(Sub_item item){
            items.add(item);
        }
        @Override
        public int getCount() {
            return items.size();
        }

        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            SubItemView view = new SubItemView(getApplicationContext());
            Sub_item item = items.get(position);
            view.setNum(item.getNum());
            view.setName(item.getName());

            return view;
        }
    }

}
