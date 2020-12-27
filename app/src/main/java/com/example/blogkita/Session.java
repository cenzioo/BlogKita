package com.example.blogkita;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.preference.PreferenceManager;

public class Session {
    private SharedPreferences prefs;

    public Session(Context context) {
        prefs = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public void setEmail(String email) {
        prefs.edit().putString("email", email).apply();
    }

    public String getEmail() {
        String Email = prefs.getString("email","");
        return Email;
    }

    public void setPassword(String password) {
        prefs.edit().putString("password", password).apply();
    }

    public String getPassword() {
        String Password = prefs.getString("password","");
        return Password;
    }

}
