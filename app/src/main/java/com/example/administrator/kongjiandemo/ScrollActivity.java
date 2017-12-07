package com.example.administrator.kongjiandemo;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class ScrollActivity extends AppCompatActivity {
    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll);
        initView();
        initData();
    }

    private void initData() {
        int i=0;
        while (i<=5) {
            ImageView imageView = new ImageView(this);
            Drawable drawable = getResources().getDrawable(R.drawable.a);
            imageView.setImageDrawable(drawable);
            //以此消除边距
            imageView.setAdjustViewBounds(true);
            linearLayout.addView(imageView,i);
            i++;
        }

    }

    private void initView() {
        linearLayout=(LinearLayout)findViewById(R.id.linear1);

    }
}
