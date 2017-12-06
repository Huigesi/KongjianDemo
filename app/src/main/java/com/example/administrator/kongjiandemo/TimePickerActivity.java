package com.example.administrator.kongjiandemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Chronometer;
import android.widget.TextClock;
import android.widget.TimePicker;
import android.widget.Toast;

public class TimePickerActivity extends AppCompatActivity {
    private TimePicker timePicker;
    private TextClock textClock;
    private Chronometer chronometer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_picker);
        initView();
        initTime();
    }

    private void initTime() {
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                String time=hourOfDay+"时"+minute+"分";
                Toast.makeText(TimePickerActivity.this,time,Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initView() {
        timePicker=(TimePicker)findViewById(R.id.timePicker);

    }
}
