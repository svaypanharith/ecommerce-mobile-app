package com.example.mobileapp;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BackButtonHelper {

    /**
     * Setup global back button behavior
     * @param backButton The view for back button
     * @param activity Current activity
     * @param targetActivity Optional: activity to navigate to (if null, just finish)
     * @param selectedTabId Optional: bottom nav tab id to set (if any)
     */
    public static void setupBackButton(View backButton, Activity activity, Class<?> targetActivity, Integer selectedTabId) {
        if (backButton == null) return;
        backButton.setOnClickListener(v -> {
            if (targetActivity != null) {
                Intent intent = new Intent(activity, targetActivity);
                if (selectedTabId != null) {
                    intent.putExtra("active_tab", selectedTabId);
                }
                activity.startActivity(intent);
            }
            activity.onBackPressed();
        });
    }

    public static void setupBackButton(View backButton, Activity activity) {
        setupBackButton(backButton, activity, null, null);
    }
}
