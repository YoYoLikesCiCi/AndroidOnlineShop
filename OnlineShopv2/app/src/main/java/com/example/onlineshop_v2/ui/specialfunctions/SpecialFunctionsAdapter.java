package com.example.onlineshop_v2.ui.specialfunctions;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

import java.net.MalformedURLException;
import java.net.URL;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.onlineshop_v2.R;

import java.util.ArrayList;

import okhttp3.OkHttp;
import okhttp3.OkHttpClient;
import okhttp3.Request;


public class SpecialFunctionsAdapter extends RecyclerView.Adapter<SpecialFunctionsAdapter.myViewHodler> {

    private Context context;
    private ArrayList<GoodsEntity> goodsEntityList;

    //构建 构造函数
    public SpecialFunctionsAdapter(Context context, ArrayList<GoodsEntity> goodsEntityList){
        this.context = context;
        this.goodsEntityList = goodsEntityList;
    }

    @Override
    public myViewHodler onCreateViewHolder(ViewGroup parent, int viewType){
        //建立自定义布局
        View itemView = View.inflate(context, R.layout.special_functions_item,null);
        return new myViewHodler(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHodler holder, int position) {
        GoodsEntity data = goodsEntityList.get(position);

        holder.mItemGoodsName.setText(data.goodsName);
        holder.mItemGoodsPrice.setText(data.goodPrice);
    }

    @Override
    public int getItemCount(){
        return goodsEntityList.size();
    }

    class myViewHodler extends RecyclerView.ViewHolder{
        private ImageView mItemGoodsImg;
        private TextView mItemGoodsName;
        private TextView mItemGoodsPrice;

        public myViewHodler(View itemView){
            super(itemView);
            mItemGoodsImg = (ImageView)itemView.findViewById(R.id.item_goods_img);
            mItemGoodsName = (TextView) itemView.findViewById(R.id.item_goods_name);
            mItemGoodsPrice = (TextView) itemView.findViewById(R.id.item_goods_price);

            //点选事件
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context,"點選了xxx", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    //设置item的监听事件
    public interface OnItemCilckListener{
        public void OnItemClick(View view , GoodsEntity data);
    }
    //需要外部訪問，所以需要設定set方法，方便呼叫
    private OnItemCilckListener onItemCilckListener;

    public void setOnItemCilckListener(OnItemCilckListener onItemCilckListener){
        this.onItemCilckListener = onItemCilckListener;
    }


}
