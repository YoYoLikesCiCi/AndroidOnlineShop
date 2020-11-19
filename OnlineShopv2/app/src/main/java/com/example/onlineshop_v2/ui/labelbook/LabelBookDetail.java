package com.example.onlineshop_v2.ui.labelbook;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.onlineshop_v2.R;
import com.example.onlineshop_v2.ui.shoppingcart.ShoppingCartFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class LabelBookDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.label_book_detail);

        ImageView imageView = (ImageView) findViewById(R.id.detail_image);
        TextView bookname = (TextView) findViewById(R.id.detail_name);
        TextView bookprice = (TextView) findViewById(R.id.detail_price);


        TextView bookauthor = (TextView) findViewById(R.id.detail_author);
        TextView bookintroduction = (TextView) findViewById(R.id.detail_introduction);
        TextView bookpublisher = (TextView) findViewById(R.id.detail_publisher);
        TextView bookisbn = (TextView) findViewById(R.id.detail_isbn);


        Intent intent = getIntent();
//        String name_data = intent.getStringExtra("book_name");
//        int imageid_data = intent.getIntExtra("book_image");
//
//        imageView.setImageResource(intent.getIntExtra("book_image",R.drawable.label_book_bainiangudu));
        imageView.setImageResource(R.drawable.label_book_bainiangudu);
        bookname.setText(intent.getStringExtra("book_name"));
        bookprice.setText(intent.getStringExtra("book_price"));


        bookauthor.setText(intent.getStringExtra("book_author"));
        bookpublisher.setText(intent.getStringExtra("book_publisher"));
        bookintroduction.setText(intent.getStringExtra("book_introduction"));

        //按钮加入购物车
//        Button button_add = (Button) findViewById(R.id.add);
//        button_add.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent addcart = new Intent(LabelBookDetail.this,ShoppingCartFragment.class);
//                Bundle bundle = new Bundle();
//                bundle.putInt("imageid",R.drawable.label_book_bainiangudu);
//                bundle.putString("name",intent.getStringExtra("book_name"));
//                bundle.putString("price",intent.getStringExtra("book_price"));
//                addcart.putExtras(bundle);
//                startActivity(addcart);
//
//                Toast.makeText(LabelBookDetail.this, "已加入购物车", Toast.LENGTH_SHORT).show();
//            }
//        });

    }

}