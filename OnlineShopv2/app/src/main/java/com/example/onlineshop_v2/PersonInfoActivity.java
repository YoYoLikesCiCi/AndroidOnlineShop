package com.example.onlineshop_v2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class PersonInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_info);
        setTitle("个人信息");//设置标题
        //文本
        TextView txt_actPersonInfo_Uname_show = (TextView) findViewById(R.id.txt_actPersonInfo_Uname_show);
        TextView txt_actPersonInfo_Ucontact_show = (TextView) findViewById(R.id.txt_actPersonInfo_Ucontact_show);
        TextView txt_actPersonInfo_Uage_show = (TextView) findViewById(R.id.txt_actPersonInfo_Uage_show);
        TextView txt_actPersonInfo_Usex_show = (TextView) findViewById(R.id.txt_actPersonInfo_Usex_show);
        //若存在用户数据，则填写
        SharedPreferences prf_userData = getSharedPreferences("userData",MODE_PRIVATE);
        txt_actPersonInfo_Uname_show.setText(prf_userData.getString("uname","无名猎人"));
        txt_actPersonInfo_Ucontact_show.setText(prf_userData.getString("ucontact","88888888888"));
        txt_actPersonInfo_Uage_show.setText(prf_userData.getString("uage","与天同寿"));
        txt_actPersonInfo_Usex_show.setText(prf_userData.getString("usex","无"));
    }
}