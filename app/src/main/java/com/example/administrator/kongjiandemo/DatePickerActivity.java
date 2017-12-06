package com.example.administrator.kongjiandemo;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.Toast;

import java.util.Calendar;


public class DatePickerActivity extends AppCompatActivity {
    private DatePicker datePicker;
    private int year,month,day;
    private RatingBar ratingBar;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datepicker);
        initView();
        initDate();
        initRating();
        new MyTask().execute();
    }

    private void initRating() {
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(DatePickerActivity.this,rating+"",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initDate() {
        Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);

        datePicker.init(year, month, day, new DatePicker.OnDateChangedListener() {

            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                String date = year + "年" + (monthOfYear + 1) + "月" + dayOfMonth + "日";
                Toast.makeText(DatePickerActivity.this, date, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initView() {
        datePicker=(DatePicker)findViewById(R.id.datePicker);
        ratingBar=(RatingBar)findViewById(R.id.ratingBar);
        progressBar=(ProgressBar)findViewById(R.id.progressBar);

    }
    class MyTask extends AsyncTask<Void,Integer,Void>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params) {
            int i=1;
            while (i<=100){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                publishProgress(i);
                i++;
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progressBar.setProgress(values[0]);
        }
    }
}
