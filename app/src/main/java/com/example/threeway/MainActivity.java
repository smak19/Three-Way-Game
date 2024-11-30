package com.example.threeway;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    CardView card1, card2, card3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        card1 = findViewById(R.id.TTT_game);
        card2 = findViewById(R.id.Snake_game);
        card3 = findViewById(R.id.third_game);


        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent1=new Intent(MainActivity.this, HomeTTT.class);
                startActivity(intent1);
            }
        });
        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent2=new Intent(MainActivity.this, SnakeActivity.class);
                startActivity(intent2);
            }
        });
        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent1=new Intent(MainActivity.this, ThirdActivity.class);
                startActivity(intent1);
            }
        });
    }
}