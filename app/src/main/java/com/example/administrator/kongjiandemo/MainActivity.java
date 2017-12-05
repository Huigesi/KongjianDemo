package com.example.administrator.kongjiandemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    private ToggleButton toggleButton;
    private Switch aSwitch;
    private RadioButton radioButton1, radioButton2;
    private Button button1;
    private EditText editTextpsw, editTextname, editTextemail;
    private String name, email, psw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setListener();
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
                    // Send the user message
                    handled = true;
                }
                return handled;
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

    public void updateTB(View view) {
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
        editTextemail = (EditText) findViewById(R.id.et_email);
        editTextname = (EditText) findViewById(R.id.et_name);
        editTextpsw = (EditText) findViewById(R.id.et_psw);


    }

}
