package com.example.pr14ovchinnikov;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Planka extends AppCompatActivity implements View.OnClickListener{
ImageView imv1, imv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.planka);
        imv1 = findViewById(R.id.imageView42);
        imv2 = findViewById(R.id.imageView41);
        imv1.setOnClickListener(this);
        imv2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.imageView42:
                startActivity(new Intent(this, Menu.class));
                break;
            case R.id.imageView41:
                startActivity(new Intent(this, UprList2.class));
                break;
        }

    }
}