package com.example.ecommerceapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;

public class RegisterActivity extends AppCompatActivity {

    private static final String TAG = "RegisterActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);

        View backButton = findViewById(R.id.backButton);
        View loginRedirect = findViewById(R.id.loginRedirect);

        Button btnRegister = findViewById(R.id.btnRegister);

        loginRedirect.setOnClickListener(v -> {
                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(intent);
                });

        btnRegister.setOnClickListener(v -> {
                    Intent intent = new Intent(RegisterActivity.this, HomeActivity.class);
                    startActivity(intent);
                });

        BackButtonHelper.setupBackButton(backButton, this);
    }

}