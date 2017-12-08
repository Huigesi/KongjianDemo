package com.example.administrator.kongjiandemo.ListView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.administrator.kongjiandemo.R;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {
    private ListView listView;
    private ArrayList<String> mList;
    private Boolean is_divpage;
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
        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                if (is_divpage&&scrollState== AbsListView.OnScrollListener.SCROLL_STATE_IDLE){
                    //SCROLL_STATE_TOUCH_SCROLL手指没放开，到底就刷
                    //SCROLL_STATE_IDLE手指放开就刷
                    Toast.makeText(ListViewActivity.this,"gb",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                is_divpage=(firstVisibleItem+visibleItemCount==totalItemCount);

            }
        });
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
