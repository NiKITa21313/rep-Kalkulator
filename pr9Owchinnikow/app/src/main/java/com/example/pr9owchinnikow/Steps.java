package com.example.pr9owchinnikow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Steps extends AppCompatActivity implements View.OnClickListener {
Button btnMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_steps);
        btnMap = findViewById(R.id.button8);
        btnMap.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("geo: 55.043998, 82.917408")));
    }
}