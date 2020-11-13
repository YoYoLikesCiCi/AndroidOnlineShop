package com.example.jindong;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class homeActivity extends AppCompatActivity {

    private RadioGroup rg_main;
    @Override


    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        rg_main = findViewById(R.id.rg_main);
        rg_main.check(R.id.rb_home);

        Button button_label = (Button) findViewById(R.id.rb_type);

        button_label.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(homeActivity.this,LableActivity.class));
                finish();
            }
        });


    }
}