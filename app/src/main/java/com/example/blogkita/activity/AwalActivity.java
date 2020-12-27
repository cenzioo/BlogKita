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
        setContentView(R.layout.activity_awal);

        Button pengunjung = (Button)findViewById(R.id.btn_pengunjung);
        Button register = (Button)findViewById(R.id.btn_daftar);
        Button login = (Button)findViewById(R.id.btn_login);

        pengunjung.setOnClickListener(AwalActivity.this);
        register.setOnClickListener(AwalActivity.this);
        login.setOnClickListener(AwalActivity.this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_pengunjung:
                Intent moveIntent = new Intent(AwalActivity.this, MainActivity.class);
                startActivity(moveIntent);
                break;
            case R.id.btn_masuk:
                moveIntent = new Intent(AwalActivity.this, LoginActivity.class);
                startActivity(moveIntent);
                break;
            case R.id.btn_daftar:
                moveIntent = new Intent(AwalActivity.this, RegisterActivity.class);
                startActivity(moveIntent);
                break;
        }

    }
}