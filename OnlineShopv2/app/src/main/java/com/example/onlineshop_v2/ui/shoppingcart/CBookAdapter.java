package com.example.onlineshop_v2.ui.shoppingcart;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.onlineshop_v2.R;

import java.util.List;

public class CBookAdapter extends ArrayAdapter<CBook> {
    private int resourceId;
    public CBookAdapter(Context context, int textViewResourceId, List<CBook> objects){
        super(context,textViewResourceId,objects);
        resourceId = textViewResourceId;


        }
    @Override
    public View getView(int position,View convertView, ViewGroup parent){
        CBook cbook = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId, parent,false);
        ImageView bookImage = (ImageView)view.findViewById(R.id.cart_photo);
        TextView bookName = (TextView)view.findViewById(R.id.cart_name);
        TextView bookPrice = (TextView)view.findViewById(R.id.cart_price);
        bookImage.setImageResource(cbook.getImageid());
        bookName.setText(cbook.getName());
        bookPrice.setText(cbook.getPrice());
        return view;
    }
}
