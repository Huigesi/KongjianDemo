package com.example.administrator.kongjiandemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import java.util.ArrayList;

public class ButtonActivity extends AppCompatActivity {
    private ListView listView;
    private Button popup_btn;
    private ArrayList<String> list;
    private ArrayAdapter<String> arrayAdapter;
    //短按菜单显示
    private ActionMode mActionMode;
    private ActionMode.Callback mActionModeCallback=new ActionMode.Callback() {
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.context_menu, menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            switch (item.getItemId()){
                case R.id.edit:
                    //获取当前选中的id
                   // String items=arrayAdapter.getItem(item.getItemId());
                    Toast.makeText(ButtonActivity.this,"编辑",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.share:
                    Toast.makeText(ButtonActivity.this,"分享",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.delete:
                    Toast.makeText(ButtonActivity.this,"删除",Toast.LENGTH_SHORT).show();
                    break;
            }
            return false;
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            mActionMode=null;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);
        initView();
        initdata();
        //长按浮动菜单点击事件必用
        //registerForContextMenu(listView);
        //短按
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (mActionMode != null) {
                    //return false;
                }
                mActionMode = startActionMode(mActionModeCallback);
                view.setSelected(true);
                //return true;
            }
        });

    }
    //popup菜单
    public void showPopup(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.context_menu, popup.getMenu());
        popup.show();
    }

    private void initdata() {
        list=new ArrayList<String>();
        for (int i=0;i<20;i++) {
            list.add("item"+i);
        }
        arrayAdapter=new ArrayAdapter<String>(ButtonActivity.this,android.R.layout.simple_list_item_1,list);
        listView.setAdapter(arrayAdapter);
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
        inflater.inflate(R.menu.context_menu,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }
    //长按浮动菜单点击事件
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info=(AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
        switch (item.getItemId()){
            case R.id.edit:
                //获取当前选中的id
                String items=arrayAdapter.getItem(info.position);
                Toast.makeText(ButtonActivity.this,"编辑"+items,Toast.LENGTH_SHORT).show();
                break;
            case R.id.share:
                Toast.makeText(ButtonActivity.this,"分享",Toast.LENGTH_SHORT).show();
                break;
            case R.id.delete:
                Toast.makeText(ButtonActivity.this,"删除",Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onContextItemSelected(item);
    }

    private void initView() {
        listView=(ListView)findViewById(R.id.listview);

    }
}
