package com.example.threeway;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;

import com.example.threeway.controller.Common;
import com.google.android.material.card.MaterialCardView;

public class HomeTTT extends AppCompatActivity {
    private MaterialCardView clickX, clickO, singlePlayerButton, duoPlayerButton;
    private String playerChoose;
    private Context context;
    private void init(){
        clickX = findViewById(R.id.click_x);
        clickO = findViewById(R.id.click_o);
        singlePlayerButton = findViewById(R.id.single_player_button);
        duoPlayerButton = findViewById(R.id.duo_player_button);
        context = HomeTTT.this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_ttt);
        init();

        Window window = getWindow();
        window.setStatusBarColor(ContextCompat.getColor(context, R.color.home_bg));

        clickX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerChoose = "x";
                clickX.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(context, R.color.light_white_text)));
                clickO.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(context, R.color.home_bg)));
            }
        });

        clickO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerChoose = "o";
                clickO.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(context, R.color.light_white_text)));
                clickX.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(context, R.color.home_bg)));
            }
        });

        singlePlayerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("single", "clicked");
                if(playerChoose == null || playerChoose.equals("")){
                    Common.showToast("Please choose 'X' OR 'O'", HomeTTT.this);
                }
                else{
                    Intent intent = new Intent(HomeTTT.this, Tictacteo.class);
                    intent.putExtra("SingleOrDuo", "single");
                    intent.putExtra("playerChoose", playerChoose);
                    startActivity(intent);
                }
            }
        });
        duoPlayerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("duo", "clicked");
                Log.d("duo", "clicked");
                if(playerChoose == null || playerChoose.equals("")){
                    Common.showToast("Please choose 'X' OR 'O'", HomeTTT.this);
                }
                else{
                    Intent intent = new Intent(HomeTTT.this, Tictacteo.class);
                    intent.putExtra("SingleOrDuo", "duo");
                    intent.putExtra("playerChoose", playerChoose);
                    startActivity(intent);
                }
            }
        });
    }

}