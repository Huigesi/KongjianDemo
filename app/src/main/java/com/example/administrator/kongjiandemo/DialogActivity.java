package com.example.administrator.kongjiandemo;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DialogActivity extends AppCompatActivity {

    private AlertDialog.Builder builder_custom,builder_single,builder_multi;
    private Button singleButton,MultiButton,customButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        initView();
        initDialog();
        setListener();

    }

    private void initView() {
        customButton=(Button)findViewById(R.id.button4);
        singleButton=(Button)findViewById(R.id.button_single);
        MultiButton=(Button)findViewById(R.id.button_multi);
    }

    private void initDialog() {
        builder_custom = new AlertDialog.Builder(this);
        builder_custom.setTitle("提示框");
        //当对话框里有内容，setMessage要去掉
        //builder.setMessage("你好");

        //自定义对话框
        //能加载布局，但不方便做功能
        //builder.setView(R.layout.dialog_custom);
        final View view = LayoutInflater.from(DialogActivity.this).inflate(R.layout.dialog_custom, null);
        builder_custom.setView(view);
        final EditText editText1 = (EditText) view.findViewById(R.id.editText);
        final EditText editText2 = (EditText) view.findViewById(R.id.editText2);


        builder_custom.setIcon(R.drawable.longface);
        builder_custom.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String editText11 = editText1.getText().toString().trim();
                String editText22 = editText2.getText().toString().trim();
                Toast.makeText(DialogActivity.this, editText11 + "" + editText22, Toast.LENGTH_SHORT).show();

            }
        });
        builder_custom.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(DialogActivity.this, "确定", Toast.LENGTH_SHORT).show();
            }
        });
        builder_custom.setNeutralButton("忽略", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(DialogActivity.this, "忽略", Toast.LENGTH_SHORT).show();
            }
        });
        final String[] hobby = {"1", "2", "3"};
        //单选
        builder_single = new AlertDialog.Builder(this);
        builder_single.setTitle("单选");
        builder_single.setSingleChoiceItems(hobby,-1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        //多选
        builder_multi = new AlertDialog.Builder(this);
        builder_multi.setMultiChoiceItems(hobby, new boolean[]{true, true, true}, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {

            }
        });
        //列表
        /*builder.setItems(hobby, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), hobby[which], Toast.LENGTH_SHORT).show();
            }
        });*/
    }

    private void setListener() {
        customButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder_custom.show();
            }
        });
        singleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder_single.show();
            }
        });
        MultiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder_multi.show();
            }
        });


    }
}
