package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity2 extends AppCompatActivity {

    private RadioGroup rg_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        RadioButton button1 = (RadioButton) findViewById(R.id.rb_cart);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this,shoppingcartActivity.class);
                startActivity(intent);
            }
        });

        rg_main = findViewById(R.id.rg_main);
        rg_main.check(R.id.rb_home);
    }
}