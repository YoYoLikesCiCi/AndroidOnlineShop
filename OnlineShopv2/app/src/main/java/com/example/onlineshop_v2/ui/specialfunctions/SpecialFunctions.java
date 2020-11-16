package com.example.onlineshop_v2.ui.specialfunctions;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.onlineshop_v2.R;
import com.example.onlineshop_v2.ui.ConnectToServer;

import org.json.JSONObject;

public class SpecialFunctions extends Fragment {

    private SpecialFunctionsViewModel mViewModel;

    public static SpecialFunctions newInstance() {
        return new SpecialFunctions();
    }

    @Override
    //传递至 onCreateView() 的 container 参数是您的片段布局将插入到的父级 ViewGroup（来自 Activity 的布局）。savedInstanceState 参数是在恢复片段时，提供上一片段实例相关数据的 Bundle
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_special_functions, container, false);
    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(SpecialFunctionsViewModel.class);
        // TODO: Use the ViewModel

        //处理test 按钮的点击事件
        Button testButton = (Button)getActivity().findViewById(R.id.test_button);
        testButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JSONObject jsonObject = new JSONObject();
                ConnectToServer connectToServer = new ConnectToServer();
                connectToServer.sendRequestWithHttpURLConnection(jsonObject,"jfal");
            }
        });
    }


}