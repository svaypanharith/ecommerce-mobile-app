package com.example.mobileapp;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import android.view.MenuItem;
import android.content.Intent;

public class HomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.navigation_home) {
                    return true;
                } else if (id == R.id.cart) {
                    Intent intent = new Intent(HomeActivity.this , CartActivity.class);
                    startActivity(intent);
                    return true;
                } else if (id == R.id.profile) {
                    Intent intent = new Intent( HomeActivity.this , ProfileActivity.class);
                    startActivity(intent);
                    return true;
                } else if (id == R.id.settings) {
               Intent intent = new Intent(HomeActivity.this , SettingActivity.class);
                    startActivity(intent);
                    return true;
                }
                return false;
            }
        });
    }
}
