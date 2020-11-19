package com.example.login;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Person;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import data.*;

import static com.example.login.LoginActivity.ReStartLogin;

public class RegisterActivity extends AppCompatActivity {

    private String account;
    private String password;
    private String confirmPassword;
    private String contact;
    private String name;
    private String age;
    private String sex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //隐藏标题栏
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.hide();
        }
        //编辑栏
        EditText ett_account = (EditText) findViewById(R.id.edt_RAccount);
        EditText ett_password = (EditText) findViewById(R.id.edt_RPassword);
        EditText ett_confirmPassword = (EditText) findViewById(R.id.edt_RConfirmPassword);
        EditText ett_name = (EditText) findViewById(R.id.edt_RName);
        EditText ett_contact = (EditText) findViewById(R.id.edt_RContact);
        //下拉框
        Spinner spi_age = (Spinner) findViewById(R.id.spi_RAge);
        Spinner spi_sex = (Spinner) findViewById(R.id.spi_RSex);
        //注册下拉框
        String[] integers = new String[21];
        for (int i = 10;i <= 30;i++){
            integers[i-10] = String.valueOf(i);
        }
        ArrayAdapter<String> ageAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1);
        ageAdapter.addAll(integers);
        spi_age.setAdapter(ageAdapter);
        ArrayAdapter<String> sexAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1);
        sexAdapter.add("男");
        sexAdapter.add("女");
        spi_sex.setAdapter(sexAdapter);
        //按钮
        Button but_Register = (Button) findViewById(R.id.but_ConfirmRegister);
        //注册按钮
        but_Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String accountPattern = "^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$";
                String passwordPattern = "^\\w{6,18}$";
                String namePattern = "^\\S{1,}$";
                String contactPattern = "^1[3|4|5|7|8][0-9]{9}$";
                account = ett_account.getText().toString();
                password = ett_password.getText().toString();
                confirmPassword = ett_confirmPassword.getText().toString();
                name = ett_name.getText().toString();
                contact = ett_contact.getText().toString();
                age = (String) spi_age.getSelectedItem();
                sex = (String) spi_sex.getSelectedItem();
                //校验输入合法性
                if (!Pattern.matches(accountPattern,account)){
                    Toast.makeText(v.getContext(),"身份证号的格式不正确",Toast.LENGTH_SHORT).show();
                } else if (!Pattern.matches(passwordPattern,password)) {
                    Toast.makeText(v.getContext(),"密码必须是在6~18位之间的数字、字母、下划线",Toast.LENGTH_SHORT).show();
                } else if (!(password.equals(confirmPassword))) {
                    Toast.makeText(v.getContext(), "两次输入的密码不匹配", Toast.LENGTH_SHORT).show();
                } else if (!Pattern.matches(namePattern,name)) {
                    Toast.makeText(v.getContext(), "姓名的格式不正确", Toast.LENGTH_SHORT).show();
                } else if (!Pattern.matches(contactPattern,contact)){
                    Toast.makeText(v.getContext(),"联系方式的格式不正确",Toast.LENGTH_SHORT).show();
                }  else {
                    //保存用户信息
                    SharedPreferences.Editor editor = getSharedPreferences("userData",MODE_PRIVATE).edit();
                    //风险信息，应加密
                    User.setUname(account);
                    editor.putString("uid",account);
                    User.setUname(confirmPassword);
                    editor.putString("upassword",confirmPassword);
                    //普通信息
                    User.setUname(name);
                    editor.putString("uname",name);
                    User.setUcontact(contact);
                    editor.putString("ucontact",contact);
                    User.setUage(age);
                    editor.putString("uage",age);
                    User.setUage(sex);
                    editor.putString("usex",sex);
                    editor.apply();
                    User.init(account, password);//初始化User
                    ReStartLogin(v.getContext(), account, password);//重新启动loginActivity并传递部分数据
                    //发送状态：成功
                }
            }
        });
    }
}