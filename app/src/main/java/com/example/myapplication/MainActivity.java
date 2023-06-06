package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button butSecond = findViewById(R.id.butSecond);
        TextView mainText = findViewById(R.id.mainText);
        butSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                ShowInfo(mainText.getText().toString(),butSecond);
                ShowInfoAlert("Ты чо хочешь закрыть приложение?");
            }
        });

    }
    public void butClick(View v)
    {
        ShowInfo(((Button)v).getText().toString(),((Button)v));
    }

    private void ShowInfoAlert(String text){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Огромная подсказка для тебя, чел!")
                        .setMessage(text)
                        .setCancelable(false)
                        .setPositiveButton("Стопудово", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                            }
                        })
                        .setNegativeButton("Блин, нет конечно", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void ShowInfo(String text, Button btnOut){
        btnOut.setText("Чел, ты уже нажал");
        btnOut.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }

}