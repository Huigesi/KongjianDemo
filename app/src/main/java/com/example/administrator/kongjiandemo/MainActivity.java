package com.example.administrator.kongjiandemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.administrator.kongjiandemo.ListView.ListViewActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ToggleButton toggleButton;
    private Switch aSwitch;
    private RadioButton radioButton1, radioButton2;
    private Button button1, button2, button3, button4, button5,button_lv,button_db;;
    private EditText editTextpsw, editTextname, editTextemail;
    private String name, email, psw;
    private AutoCompleteTextView autoCompleteTextView;
    //用arrayadapter做搜索内容
    private ArrayAdapter<String> arrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        setListener();
        initAdapter();
    }


    private void initAdapter() {
        //用资源数组做搜索内容
        String[] countries = getResources().getStringArray(R.array.countries_array);
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, countries);
        //arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,initData());
        autoCompleteTextView.setAdapter(arrayAdapter);
    }

    //输入两个字母后开始提示
    private List<String> initData() {
        List<String> list = new ArrayList<String>();
        list.add("Afghanistan");
        list.add("Albania");
        list.add("Algeria");
        list.add("American Samoa");
        list.add("Andorra");
        list.add("Angola");
        list.add("bmerican Samoa");
        list.add("Bndorra");
        list.add("bngola");


        return list;
    }

    private void setListener() {
        name = editTextname.getText().toString().trim();
        email = editTextemail.getText().toString().trim();
        psw = editTextpsw.getText().toString().trim();

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this, name, Toast.LENGTH_SHORT).show();
                //setError方法
                if (name == null || name.equals("")) {
                    editTextname.setError("请输入用户名");
                }
                if (email == null || email.equals("")) {
                    editTextemail.setError("请输入邮箱");
                }
                if (psw == null || psw.equals("")) {
                    editTextpsw.setError("请输入密码");
                }
            }
        });
        //通过keyboard事件监听验证
        editTextname.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_BACK) {
                    if (name == null || name.equals("")) {
                        editTextname.setError("请输入用户名");
                    }
                    if (email == null || email.equals("")) {
                        editTextemail.setError("请输入邮箱");
                    }
                    if (psw == null || psw.equals("")) {
                        editTextpsw.setError("请输入密码");
                    }
                }

                return false;
            }
        });
        EditText editText = (EditText) findViewById(R.id.search);
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean handled = false;
                if (actionId == EditorInfo.IME_ACTION_SEND) {
                    handled = true;
                }
                return handled;
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DatePickerActivity.class);
                startActivity(intent);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TimePickerActivity.class);
                startActivity(intent);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ScrollActivity.class);
                startActivity(intent);
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DialogActivity.class);
                startActivity(intent);
            }
        });
        button_lv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListViewActivity.class);
                startActivity(intent);
            }
        });
        button_db.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ButtonActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            if (name == null || name.equals("")) {
                editTextname.setError("请输入用户名");
            }
            if (email == null || email.equals("")) {
                editTextemail.setError("请输入邮箱");
            }
            if (psw == null || psw.equals("")) {
                editTextpsw.setError("请输入密码");
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    //
    public void onCheckboxClicked(View view) {
        //用onclick:onCheckboxClicked的方法做checkbox,可以不用一个一个去findviewid
        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()) {
            case R.id.checkBox:
                if (checked) {

                } else {

                }
            case R.id.checkBox2:
                if (checked) {

                } else {

                }
            case R.id.checkBox3:
                if (checked) {

                } else {

                }
        }
    }

    public void updateTB(View view) {
        //把view强转成ToggleButton
        boolean on = ((ToggleButton) view).isChecked();
        if (on) {
            Toast.makeText(this, "打开", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "关闭", Toast.LENGTH_SHORT).show();
        }
    }

    public void updateSH(View view) {
        boolean on = ((Switch) view).isChecked();
        if (on) {
            Toast.makeText(this, "打开", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "关闭", Toast.LENGTH_SHORT).show();
        }
    }

    public void updateRB(View view) {
        boolean on = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.radioButton:
                if (on) {
                    Toast.makeText(this, "女", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.radioButton2:
                if (on) {
                    Toast.makeText(this, "男", Toast.LENGTH_SHORT).show();
                }
        }

    }


    private void initView() {
        toggleButton = (ToggleButton) findViewById(R.id.toggleButton);
        aSwitch = (Switch) findViewById(R.id.switch1);
        radioButton1 = (RadioButton) findViewById(R.id.radioButton);
        radioButton1 = (RadioButton) findViewById(R.id.radioButton2);
        button1 = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button_lv=(Button)findViewById(R.id.button_lv);
        button_db=(Button)findViewById(R.id.button_change);


        editTextemail = (EditText) findViewById(R.id.et_email);
        editTextname = (EditText) findViewById(R.id.et_name);
        editTextpsw = (EditText) findViewById(R.id.et_psw);
        autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);


    }

}
