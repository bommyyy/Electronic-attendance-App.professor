package com.example.myapplication;

import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class SemesterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semester);

        ListView listview = findViewById(R.id.subtable);

        semAdapter adapter = new semAdapter();

        adapter.addItem(new Sub_item("1","데이터베이스"));
        adapter.addItem(new Sub_item("2","종단형 PBL"));
        adapter.addItem(new Sub_item("3","JAVA"));
        adapter.addItem(new Sub_item("4","C언어"));
        adapter.addItem(new Sub_item("5","악성코드"));
        listview.setAdapter(adapter);
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
