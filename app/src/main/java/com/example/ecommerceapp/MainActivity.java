package com.example.ecommerceapp;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.welcome_activity);

        // Buttons
        Button btnRegister = findViewById(R.id.btnRegister);
        Button btnLogin = findViewById(R.id.btnLogin);

        btnRegister.setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, RegisterActivity.class))
        );

        btnLogin.setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, LoginActivity.class))
        );

        // Handle notification click
        handleNotificationIntent(getIntent());
    }


    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        handleNotificationIntent(intent);
    }

    private void handleNotificationIntent(Intent intent) {
        if (intent != null && intent.hasExtra("destination")) {
            Toast.makeText(this, "Notification received", Toast.LENGTH_SHORT).show();
            String destination = intent.getStringExtra("destination");
            if ("cart".equals(destination)) {
                Intent cartIntent = new Intent(this, CartActivity.class);
                cartIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(cartIntent);
            }
        }
    }
}
