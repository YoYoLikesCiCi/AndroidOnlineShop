package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Person;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import data.*;

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
        //编辑栏
        EditText ett_account = (EditText) findViewById(R.id.edt_RAccount);
        EditText ett_password = (EditText) findViewById(R.id.edt_RPassword);
        EditText ett_confirmPassword = (EditText) findViewById(R.id.edt_RConfirmPassword);
        //下拉框
        Spinner spi_age = (Spinner) findViewById(R.id.spi_Age);
        Spinner spi_sex = (Spinner) findViewById(R.id.spi_Sex);
        //注册下拉框
        List<Integer> integers = new ArrayList<Integer>();
        for (int i = 10;i <= 30;i++){
            integers.add(i);
        }
//       AgeAdapter ageAdapter = new AgeAdapter(this,integers);
//       spi_age.setAdapter(ageAdapter);
        //按钮
        Button but_Register = (Button) findViewById(R.id.but_ConfirmRegister);
        //注册按钮
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
                    User.init(account,password);//初始化User
                    ReStartLogin(v.getContext(),account,password);//重新启动loginActivity并传递数据
                }
            }
        });
    }
}