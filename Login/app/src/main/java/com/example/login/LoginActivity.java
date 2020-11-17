package com.example.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private String account;
    private String password;
    //监听编辑文本
    private EditText ett_account;
    private EditText ett_password;
    private Button but_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //隐藏标题栏
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.hide();
        }
        //编辑栏
        ett_account = (EditText) findViewById(R.id.edt_Account);
        ett_password = (EditText) findViewById(R.id.edt_Password);
        //按钮
        but_login = (Button) findViewById(R.id.but_login);
        //登陆按钮
        but_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(this,HomeActivity.class);
                //v.getContext().startActivity(intent);
            }
        });
    }

    //获取传递信息
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        //如果有传递信息，则编辑栏填写内容
        if (getIntent().hasExtra("RAccount")){
            this.account = getIntent().getStringExtra("RAccount");
            ett_account.setText(account);
        }
        if (getIntent().hasExtra("RPassword")){
            this.password = getIntent().getStringExtra("RPassword");
            ett_password.setText(password);
        }
    }

    //来自启动此活动的 页面 传递信息的 方法
    public static void ReStartLogin(Context context,String account,String password){
        Intent intent = new Intent(context,LoginActivity.class);
        intent.putExtra("RAccount",account);
        intent.putExtra("RPassword",password);
        context.startActivity(intent);
    }

}