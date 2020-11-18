package com.example.onlineshop_v2;

import android.os.Bundle;
import android.os.Handler;

import com.bumptech.glide.Glide;
import com.example.onlineshop_v2.ui.ConnectToServer;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);   //这是activity_main里的底部导航栏
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(R.id.navigation_homepage,R.id.navigation_shoppingcart,
                R.id.navigation_labelbook,R.id.navigation_specialfunctions,R.id.navigation_personprofile)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment); //这是activity_main里的fragemengt部分
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);


    }


}