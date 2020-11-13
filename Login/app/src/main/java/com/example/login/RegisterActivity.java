package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.login.LoginActivity.ReStartLogin;

public class RegisterActivity extends AppCompatActivity {

    private String account;
    private String password;
    private String confirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        setTitle("注册");//设置标题
        //监听编辑文本
        EditText ett_account = (EditText) findViewById(R.id.edt_RAccount);
        EditText ett_password = (EditText) findViewById(R.id.edt_RPassword);
        EditText ett_confirmPassword = (EditText) findViewById(R.id.edt_RConfirmPassword);
        //监听按钮
        Button but_Register = (Button) findViewById(R.id.but_ConfirmRegister);
        //确认注册
        but_Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                account = ett_account.getText().toString();
                password = ett_password.getText().toString();
                confirmPassword = ett_confirmPassword.getText().toString();
                if (!(password.equals(confirmPassword))){
                    Toast.makeText(v.getContext(),"两次输入的密码不匹配",Toast.LENGTH_SHORT).show();
                    return;
                }else {
                    ReStartLogin(v.getContext(),account,password);
                }
            }
        });
    }
}