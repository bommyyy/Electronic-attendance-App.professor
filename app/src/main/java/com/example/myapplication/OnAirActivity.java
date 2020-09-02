package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class OnAirActivity extends AppCompatActivity {

    ListView studenttable2;
    String[] stuNo ={"1","2","3"};
    String[] stuName = {"김슈니","이슈니","박슈니"};
    int[] butO ={R.drawable.o,R.drawable.o,R.drawable.o};
    int[] butA ={R.drawable.a,R.drawable.a,R.drawable.a};
    int[] butX ={R.drawable.x,R.drawable.x,R.drawable.x};
    //추가

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onair);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        studenttable2=findViewById(R.id.studenttable2);
        OnAirAdapter OnAirAdapter=new OnAirAdapter(this, stuNo,stuName,butO,butA,butX);
        studenttable2.setAdapter(OnAirAdapter);
        //추가

//        Button b = (Button)findViewById(R.id.btn_change);
//        b.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view){
//                Intent intent = new Intent(
//                        getApplicationContext(),
//                        MainActivity.class);
//                startActivity(intent);
//            }
//        });
//        Button fab = findViewById(R.id.btn_save);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
