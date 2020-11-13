package com.example.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private String account;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //隐藏标题栏
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.hide();
        }
        //监听按钮
    }

    //获取传递信息
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        //监听编辑文本
        EditText ett_account = (EditText) findViewById(R.id.edt_Account);
        EditText ett_password = (EditText) findViewById(R.id.edt_Password);
        //如果有传递信息，则初始化属性
        if (getIntent().hasExtra("RAccount")){
            this.account = getIntent().getStringExtra("RAccount");
            ett_account.setText(account);
        }
        if (getIntent().hasExtra("RPassword")){
            this.password = getIntent().getStringExtra("RPassword");
            ett_password.setText(password);
        }
    }

    //put来自启动此活动的页面传递的信息
    public static void ReStartLogin(Context context,String account,String password){
        Intent intent = new Intent(context,LoginActivity.class);
        intent.putExtra("RAccount",account);
        intent.putExtra("RPassword",password);
        context.startActivity(intent);
    }

}