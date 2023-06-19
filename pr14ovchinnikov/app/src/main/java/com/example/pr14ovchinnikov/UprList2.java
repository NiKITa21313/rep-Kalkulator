package com.example.pr14ovchinnikov;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class UprList2 extends AppCompatActivity implements View.OnClickListener{
ImageView imageView1, imageView2, imageView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.upr_list2);
        imageView1 = findViewById(R.id.imageView28);
        imageView2 = findViewById(R.id.imageView39);
        imageView3 = findViewById(R.id.imageView40);
        imageView1.setOnClickListener(this);
        imageView2.setOnClickListener(this);
        imageView3.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.imageView40:
                startActivity(new Intent(this, Menu.class));
                break;
            case R.id.imageView39:
                startActivity(new Intent(this, UprList.class));
                break;
            case R.id.imageView28:
                startActivity(new Intent(this, Planka.class));
                break;
        }
    }
}