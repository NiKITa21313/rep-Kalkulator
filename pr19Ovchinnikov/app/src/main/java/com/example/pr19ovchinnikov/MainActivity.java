package com.example.pr19ovchinnikov;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
TextView timePick;
Button btnTime, btnData, btnNext;
Calendar dateAndTime = Calendar.getInstance();
    public void showDialog(View v) {
        CustomDialogFragment2 dialog = new CustomDialogFragment2();
        dialog.show(getSupportFragmentManager(), "custom");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timePick = findViewById(R.id.timePick);
        btnTime = findViewById(R.id.buttonTime);
        btnData = findViewById(R.id.buttonData);
        btnNext = findViewById(R.id.btnNext);
        btnData.setOnClickListener(this);
        btnTime.setOnClickListener(this);
        btnNext.setOnClickListener(this);
    }

    private void setInitialDateTime(){
        timePick.setText(DateUtils.formatDateTime(this, dateAndTime.getTimeInMillis(),
                DateUtils.FORMAT_SHOW_DATE|DateUtils.FORMAT_SHOW_YEAR
                        |DateUtils.FORMAT_SHOW_TIME));
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.buttonData){
            new DatePickerDialog(MainActivity.this, d,
                    dateAndTime.get(Calendar.YEAR),
                    dateAndTime.get(Calendar.MONTH),
                    dateAndTime.get(Calendar.DAY_OF_MONTH)).show();
        }
        else if(view.getId() == R.id.buttonTime){
            new TimePickerDialog(MainActivity.this, t,
                    dateAndTime.get(Calendar.HOUR_OF_DAY),
                    dateAndTime.get(Calendar.MINUTE), true).show();
        }
        else if(view.getId() == R.id.btnNext){
            startActivity(new Intent(this, MainActivity2.class));
        }
    }

    TimePickerDialog.OnTimeSetListener t = new TimePickerDialog.OnTimeSetListener(){
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
           dateAndTime.set(Calendar.HOUR_OF_DAY, hourOfDay);
           dateAndTime.set(Calendar.MINUTE, minute);
           setInitialDateTime();
        }
    };

    DatePickerDialog.OnDateSetListener d = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOFMounth) {
            dateAndTime.set(Calendar.YEAR, year);
            dateAndTime.set(Calendar.MONTH, monthOfYear);
            dateAndTime.set(Calendar.DAY_OF_MONTH, dayOFMounth);
            setInitialDateTime();
        }
    };

}