package com.example.blogkita.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.blogkita.R;

public class AwalActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button register = findViewById(R.id.btnAkunRegister);
        Button login = findViewById(R.id.btnAkunLogin);
        register.setOnClickListener(this);
        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnAkunLogin:
                Intent moveIntent = new Intent(this, LoginActivity.class);
                startActivity(moveIntent);
                break;
            case R.id.btnAkunRegister:
                moveIntent = new Intent(this, RegisterActivity.class);
                startActivity(moveIntent);
                break;
        }

    }
}