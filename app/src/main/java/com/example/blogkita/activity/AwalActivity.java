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
        Button pengunjung = findViewById(R.id.btn_pengunjung)
        Button register = findViewById(R.id.btn_daftar);
        Button login = findViewById(R.id.btn_login);
        pengunjung.setOnClickListener(this);
        register.setOnClickListener(this);
        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_pengunjung:
                Intent moveIntent = new Intent(this, MainActivity.class);
                startActivity(moveIntent);
                break;
            case R.id.btn_masuk:
                moveIntent = new Intent(this, LoginActivity.class);
                startActivity(moveIntent);
                break;
            case R.id.btn_daftar:
                moveIntent = new Intent(this, RegisterActivity.class);
                startActivity(moveIntent);
                break;
        }

    }
}