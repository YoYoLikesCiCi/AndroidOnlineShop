package com.example.onlineshop_v2.ui.personprofile;

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

public class PersonProfileFragment extends Fragment {

    private PersonProfileViewModel mViewModel;

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
        // TODO: Use the ViewModel
        Button testButton  = (Button)getActivity().findViewById(R.id.test_button);
        testButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConnectToServer connectToServer = new ConnectToServer();
                JSONObject jsonObject = new JSONObject();
                connectToServer.sendRequestWithHttpURLConnection(jsonObject,"getbookdata");
//        jsonObject = connectToServer.TempJsonObject;
//        System.out.println(jsonObject);
            }
        });

    }

}