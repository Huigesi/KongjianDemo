package com.example.administrator.kongjiandemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;

public class ButtonActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);
        initView();
    }
    //——————左上角菜单——————
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.game_menu, menu);

        return true;
    }
    //左上角菜单点击事件
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){


            case R.id.help:
                Intent intent2 = new Intent(ButtonActivity.this, MainActivity.class);
                startActivity(intent2);
                finish();
                break;
            //为子菜单添加点击事件直接用
            case R.id.create_new:
                Intent intent1 = new Intent(ButtonActivity.this, MainActivity.class);
                startActivity(intent1);
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    //————浮动菜单————
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.game_menu,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }
    //浮动菜单点击事件
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info=(AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
        switch (item.getItemId()){
            case R.id.create_new:
                Intent intent = new Intent(ButtonActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.help:
                break;
        }
        return super.onContextItemSelected(item);
    }

    private void initView() {
    }
}
