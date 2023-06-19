package com.example.pr11ovchinnikov;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextClock;
import android.widget.TextView;

import kotlinx.coroutines.MainCoroutineDispatcher;

public class Start extends AppCompatActivity {
    public boolean Started = false, Finished = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}
        setContentView(R.layout.activity_start);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    public void Start(View view){
        Button button = findViewById(R.id.button2);
        if(!Finished){
            if(!Started){
                button.setBackgroundColor(Color.RED);
                button.setText("Пауза");
                Started = true;
            }
            else if(Started){
                button.setBackgroundColor(Color.GREEN);
                button.setText("Старт");
                Started = false;
            }
        }
        else {
            startActivity(new Intent(this, Start.class));
        }
    }
    public void Drive1(View view){//первая машина
        Button button = findViewById(R.id.button3);
        View Car = findViewById(R.id.imageView2);
        TextView result = findViewById(R.id.textView);
        if(Started && !Finished){
            ViewGroup.MarginLayoutParams margin = (ViewGroup.MarginLayoutParams)Car.getLayoutParams();
            margin.leftMargin +=40;
            margin.rightMargin -=40;
            Car.requestLayout();
            if(margin.rightMargin <= -1700){
                result.setText("Победа первого игрока");
                button.setText("Заново");
                result.setTextColor(0xffe91E63);
                Finished = true;
            }
        }
    }
    public void Drive2(View view){//вторая машина
        Button button = findViewById(R.id.button);
        View Car = findViewById(R.id.imageView3);
        TextView result = findViewById(R.id.textView);
        if(Started && !Finished){
            ViewGroup.MarginLayoutParams margin = (ViewGroup.MarginLayoutParams)Car.getLayoutParams();
            margin.leftMargin +=50;
            margin.rightMargin -=50;
            Car.requestLayout();
            if(margin.rightMargin <= -1700){
                result.setText("Победа второго игрока");
                button.setText("Заново");
                result.setTextColor(0xffe91E63);
                Finished = true;
            }
        }
    }
}