package com.example.administrator.kongjiandemo;

import android.content.DialogInterface;
import android.content.Intent;
import android.preference.DialogPreference;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
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

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ToggleButton toggleButton;
    private Switch aSwitch;
    private RadioButton radioButton1, radioButton2;
    private Button button1, button2, button3, button4, button5;
    private EditText editTextpsw, editTextname, editTextemail;
    private String name, email, psw;
    private AlertDialog.Builder builder;
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
        setDialog();
    }

    private void setDialog() {
        builder = new AlertDialog.Builder(this);
        builder.setTitle("提示框");
        //当对话框里有内容，setMessage要去掉
        //builder.setMessage("你好");

        //自定义对话框
        //能加载布局，但不方便做功能
        //builder.setView(R.layout.dialog_custom);
        View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.dialog_custom, null);
        builder.setView(view);
        final EditText editText1 = (EditText) view.findViewById(R.id.editText);
        final EditText editText2 = (EditText) view.findViewById(R.id.editText2);


        builder.setIcon(R.drawable.longface);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String editText11 = editText1.getText().toString().trim();
                String editText22 = editText2.getText().toString().trim();
                Toast.makeText(MainActivity.this, editText11 + "" + editText22, Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "确定", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNeutralButton("忽略", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "忽略", Toast.LENGTH_SHORT).show();
            }
        });
        final String[] hobby = {"1", "2", "3"};
        //单选
       /*  builder.setSingleChoiceItems(hobby,-1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });*/
        //多选
        /*builder.setMultiChoiceItems(hobby, new boolean[]{true, true, true}, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {

            }
        });*/
        //列表
        /*builder.setItems(hobby, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), hobby[which], Toast.LENGTH_SHORT).show();
            }
        });*/


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
                builder.show();
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


        editTextemail = (EditText) findViewById(R.id.et_email);
        editTextname = (EditText) findViewById(R.id.et_name);
        editTextpsw = (EditText) findViewById(R.id.et_psw);
        autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);


    }

}
