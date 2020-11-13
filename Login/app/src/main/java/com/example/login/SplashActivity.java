package com.example.login;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import tools.TimeCD;

public class SplashActivity extends AppCompatActivity {

    private int endtime = 2000;//显示时间2000毫秒
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        //隐藏标题栏
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.hide();
        }
        //计时销毁
        TimeCD timer = new TimeCD(endtime,1000){
            @Override
            public void onFinish() {
                this.setTimeCondition(TimeCondition.stop);
                Activity activity = SplashActivity.this;//获取当前活动
                Intent intent = new Intent(activity,LoginActivity.class);
                startActivity(intent);
                activity.finish();
            }
        };
        timer.start();
    }
}