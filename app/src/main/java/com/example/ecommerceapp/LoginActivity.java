package com.example.ecommerceapp;

import android.os.Bundle;
import android.view.View;


import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity  {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        View backButton = findViewById(R.id.backButton);

        BackButtonHelper.setupBackButton(backButton, this);
    }
}
