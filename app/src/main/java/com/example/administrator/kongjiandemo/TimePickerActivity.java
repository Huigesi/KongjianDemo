package com.example.administrator.kongjiandemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Chronometer;
import android.widget.SeekBar;
import android.widget.TextClock;
import android.widget.TimePicker;
import android.widget.Toast;

public class TimePickerActivity extends AppCompatActivity {
    private TimePicker timePicker;
    private TextClock textClock;
    private Chronometer chronometer;
    private SeekBar seekBar;


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
        //设置刻度值
        seekBar.setMax(100);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //刻度改变时
                Toast.makeText(TimePickerActivity.this,progress+"",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //按下时
                //Toast.makeText(TimePickerActivity.this,seekBar+"",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //放开时
                //Toast.makeText(TimePickerActivity.this,seekBar+"",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initView() {
        timePicker=(TimePicker)findViewById(R.id.timePicker);
        seekBar=(SeekBar)findViewById(R.id.seekBar);

    }
}
