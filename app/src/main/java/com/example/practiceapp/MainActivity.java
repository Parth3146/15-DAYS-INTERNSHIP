package com.example.practiceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    GridView gridView;
    String activities[] = {"Calculator","WebView","MusicPlayer","VideoPlayer"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.gv);
        ArrayAdapter arrayAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,activities);
        gridView.setAdapter(arrayAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent;
                switch (position){
                    case 0:
                        intent = new Intent(MainActivity.this, CalculatorActivity.class);
                        startActivity(intent);
                        break;

                    case 1:
                        intent = new Intent(MainActivity.this, WebActivity.class);
                        startActivity(intent);
                        break;

                    default:
                        Toast.makeText(MainActivity.this, "You selected "+activities[position], Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}