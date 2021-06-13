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
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    GridView gridView;
    Button btnLogout;
    int[] img = {R.drawable.calc,R.drawable.web,R.drawable.musicplayer,R.drawable.videoplayer};
    String activities[] = {"Calculator","WebView","MusicPlayer","VideoPlayer"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        String name = intent.getStringExtra("username");
        textView = findViewById(R.id.tvMain);
        gridView = findViewById(R.id.gv);
        btnLogout = findViewById(R.id.btnLogout);
        String[] n = name.split(" ");
        textView.setText("Hello "+n[0]+" !!");

        MyAdapter myAdapter = new MyAdapter(MainActivity.this, img, activities);
        gridView.setAdapter(myAdapter);
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

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                moveTaskToBack(true);
            }
        });
    }
}