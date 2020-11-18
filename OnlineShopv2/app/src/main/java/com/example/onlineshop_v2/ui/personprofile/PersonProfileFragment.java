package com.example.onlineshop_v2.ui.personprofile;

import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.onlineshop_v2.MainActivity;
import com.example.onlineshop_v2.R;
import com.example.onlineshop_v2.ui.ConnectToServer;
import org.json.JSONObject;

public class PersonProfileFragment extends Fragment {
    private static final String TAG = "PersonProfileFragment";
    private PersonProfileViewModel mViewModel;

//    private Handler handlerPersonProfile;
    public static PersonProfileFragment newInstance() {
        return new PersonProfileFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_person_profile, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(PersonProfileViewModel.class);
        Handler handlerPersonProfile = new Handler(Looper.getMainLooper()){
            public void handleMessage(Message msg){
                switch (msg.what){
                    case 1:
                        Log.d(TAG, "handleMessage: receive success 1 ");
                        JSONObject ReceiveJsonData = new JSONObject();
                        ReceiveJsonData = (JSONObject) msg.obj;
                        Log.d(TAG, "handleMessage: receive success");
                        Log.d(TAG, "handleMessage: "+ ReceiveJsonData);
                        System.out.println("二次转换成功");
                        break;
                }
            }
        };
        // TODO: Use the ViewModel
        Button testButton  = (Button)getActivity().findViewById(R.id.test_button);
        testButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JSONObject sendJsonData = new JSONObject();
                ConnectToServer threadPersonProfile = new ConnectToServer(handlerPersonProfile,sendJsonData, "getbookdata");
                threadPersonProfile.start();
//                System.out.println(jsonObject);
            }
        });

    }



}