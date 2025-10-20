package com.example.ecommerceapp;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;

public class SettingActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_activity);
        TextView title = findViewById(R.id.header_title);
        title.setText("Settings");
        View backButton = findViewById(R.id.backButton);
        BackButtonHelper.setupBackButton(backButton, this, HomeActivity.class, R.id.navigation_home);
    }
}
