package com.example.onlineshop_v2.ui.specialfunctions;

import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.onlineshop_v2.R;
import com.example.onlineshop_v2.ui.ConnectToServer;
import com.google.gson.JsonObject;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class SpecialFunctions extends Fragment {
    private View view ;

    public RecyclerView mSpecialFunctionsRecyclerView;
    //定義以goodsentity實體類為物件的資料集合
    private ArrayList<GoodsEntity>  goodsEntityList  = new ArrayList<GoodsEntity>();
    //自定義recyclerveiw的介面卡
    private  SpecialFunctionsAdapter mSpecialFunctionsRecyclerAdapeter;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        view = inflater.inflate(R.layout.fragment_special_functions, container,false);

        //對recycleview進行配置
        initRecyclerView();
        initData();
        return view;
    }

    //模拟内容，就是我的书们
    private void initData(){
        for (int i=0;i<10;i++){
            GoodsEntity goodsEntity = new GoodsEntity();
            goodsEntity.setGoodsName("模拟场景"+i);
            goodsEntity.setGoodPrice("100"+ i);
            goodsEntityList.add(goodsEntity);
        }
    }

    //对recyclerView进行配置
    private void initRecyclerView(){

        //获取recyclerView
        mSpecialFunctionsRecyclerView = (RecyclerView) view.findViewById(R.id.special_functions_recyclerView);

        //建立 adapter
        mSpecialFunctionsRecyclerAdapeter = new SpecialFunctionsAdapter(getActivity(),goodsEntityList);

        //给recyclerView设定adapter
        mSpecialFunctionsRecyclerView.setAdapter(mSpecialFunctionsRecyclerAdapeter);
        // 设定layoutManager， 可以设置显示效果
        //参数：上下文，列表方向，是否倒叙
        mSpecialFunctionsRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));

        //设定item的分割线
        mSpecialFunctionsRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));

        //设置RecyclerView的监听事件，点击后干什么
//        mSpecialFunctionsRecyclerAdapeter.setOnItemClickListener
    }
}