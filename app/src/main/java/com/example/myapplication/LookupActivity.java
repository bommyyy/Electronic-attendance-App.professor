package com.example.myapplication;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class LookupActivity extends AppCompatActivity {

    String myJSON;
    private static final String TAG_RESULTS = "result";
    private static final String TAG_NO = "SUBno";
    private static final String TAG_NAME = "SUBname";

    JSONArray peoples = null;
    ArrayList<HashMap<String, String>> personList;
    ListView list;
    ////jihyeon
//    ListView studenttable;
//    String[] stuNo ={"1","2","3"};
//    String[] stuName = {"김슈니","이슈니","박슈니"};
//    int[] butO ={R.drawable.o,R.drawable.o,R.drawable.o};
//    int[] butA ={R.drawable.a,R.drawable.a,R.drawable.a};
//    int[] butX ={R.drawable.x,R.drawable.x,R.drawable.x};
//    //추가


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lookup);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        list = (ListView) findViewById(R.id.studenttable);
        personList = new ArrayList<HashMap<String, String>>();
        getData("http://192.168.219.199/profonair.php"); //ip주소변경
    }

        @Override
        public boolean onCreateOptionsMenu (Menu menu){
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_main, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected (MenuItem item){
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

        protected void showList () {
            try {
                JSONObject jsonObj = new JSONObject(myJSON);
                peoples = jsonObj.getJSONArray(TAG_RESULTS);

                for (int i = 0; i < peoples.length(); i++) {
                    JSONObject c = peoples.getJSONObject(i);
                    String SUBno = c.getString(TAG_NO);
                    String SUBname = c.getString(TAG_NAME);

                    HashMap<String, String> persons = new HashMap<String, String>();

                    persons.put(TAG_NO, SUBno);
                    persons.put(TAG_NAME, SUBname);


                    personList.add(persons);
                }

                ListAdapter adapter = new SimpleAdapter(
                        LookupActivity.this, personList, R.layout.lookuplist,
                        new String[]{TAG_NO, TAG_NAME},
                        new int[]{R.id.textView1, R.id.txt_ox}
                );

                list.setAdapter(adapter);
                list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView parent, View v, int position, long id) {
                        Intent intent = new Intent(getApplicationContext(), ColorActivity.class);
                        startActivity(intent);
                    }
                });

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        private void getData (String url){
            class GetDataJSON extends AsyncTask<String, Void, String> {

                @Override
                protected String doInBackground(String... params) {

                    String uri = params[0];

                    BufferedReader bufferedReader = null;
                    try {
                        URL url = new URL(uri);
                        HttpURLConnection con = (HttpURLConnection) url.openConnection();
                        StringBuilder sb = new StringBuilder();

                        bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));

                        String json;
                        while ((json = bufferedReader.readLine()) != null) {
                            sb.append(json + "\n");
                        }

                        return sb.toString().trim();

                    } catch (Exception e) {
                        return null;
                    }


                }


                @Override
                protected void onPostExecute(String result) {
                    myJSON = result;
                    showList();
                }
            }
            GetDataJSON g = new GetDataJSON();
            g.execute(url);
        }
    }

