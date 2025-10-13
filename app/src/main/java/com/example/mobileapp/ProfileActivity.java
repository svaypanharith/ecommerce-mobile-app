package com.example.mobileapp;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_activity);
        TextView title = findViewById(R.id.header_title);
        title.setText("Profile");
        View backButton = findViewById(R.id.backButton);
        BackButtonHelper.setupBackButton(backButton, this, HomeActivity.class, R.id.navigation_home);
    }
}
