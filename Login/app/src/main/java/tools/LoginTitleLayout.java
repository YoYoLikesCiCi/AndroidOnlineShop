package tools;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.login.*;

public class LoginTitleLayout extends LinearLayout {
    public LoginTitleLayout(Context context, AttributeSet attr) {
        super(context,attr);
        //自定义控件
        LayoutInflater.from(context).inflate(R.layout.login_title,this);
        //监听按钮
        Button but_Register = (Button) findViewById(R.id.but_Register);
        //注册
        but_Register.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),RegisterActivity.class);
                v.getContext().startActivity(intent);
            }
        });
    }
}
