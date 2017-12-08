package com.example.administrator.kongjiandemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {
    private ListView listView;
    private ArrayList<String> mList;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        initView();
        initData();
        initAdapter();

    }


    private void initAdapter() {
        adapter=new ArrayAdapter(ListViewActivity.this,android.R.layout.simple_list_item_1,mList);
        listView.setAdapter(adapter);
    }

    private void initData() {
        mList=new ArrayList<String>();
        for(int i=0;i<=30;i++){
            mList.add("数"+i);
        }
    }

    private void initView() {
        listView=(ListView)findViewById(R.id.listView1);
    }

}
