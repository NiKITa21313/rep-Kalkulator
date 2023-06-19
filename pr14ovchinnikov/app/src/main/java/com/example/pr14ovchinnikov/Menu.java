package com.example.pr14ovchinnikov;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Menu extends AppCompatActivity implements View.OnClickListener{
ImageView iv1, iv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        iv1 = findViewById(R.id.imageView5);
        iv2 = findViewById(R.id.imageView7);
        iv1.setOnClickListener(this);
        iv2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.imageView5:
                startActivity(new Intent(this, UprList.class));
                break;
            case R.id.imageView7:
                startActivity(new Intent(this, Statistic.class));
                break;
        }
    }
}