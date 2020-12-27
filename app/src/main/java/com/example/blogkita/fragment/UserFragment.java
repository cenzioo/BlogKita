package com.example.blogkita.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.blogkita.R;
import com.example.blogkita.activity.LoginActivity;
import com.example.blogkita.activity.MainActivity;
import com.example.blogkita.activity.RegisterActivity;


public class UserFragment extends Fragment implements View.OnClickListener {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_user, container, false);

        Button register = v.findViewById(R.id.btnAkunRegister);
        Button login = v.findViewById(R.id.btnAkunLogin);
        register.setOnClickListener(this);
        login.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnAkunLogin:
                Intent moveIntent = new Intent(getActivity(), LoginActivity.class);
                startActivity(moveIntent);
                break;
            case R.id.btnAkunRegister:
                moveIntent = new Intent(getActivity(), RegisterActivity.class);
                startActivity(moveIntent);
                break;
        }

    }
}

