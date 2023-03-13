package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    private TextView resultTextViwe;
    private EditText number_field1, number_field2;
    private Button add_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) //запускается при старте программы
    {
        super.onCreate(savedInstanceState);//проект
        setContentView(R.layout.activity_main);

        resultTextViwe = findViewById(R.id.resultTextView);
        number_field1 = findViewById(R.id.number_field1);
        number_field2 = findViewById(R.id.number_field2);
        add_button = findViewById(R.id.add_button);
        add_button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                float num1 = Float.parseFloat(number_field1.getText().toString());
                float num2 = Float.parseFloat(number_field2.getText().toString());
                float res = num1 + num2;
                resultTextViwe.setText(String.valueOf(res));
            }
        });

    }

}