package com.example.mobileapp;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.imageview.ShapeableImageView;

public class HomeFragment extends Fragment {
    private static final String PREFS_FILE = "MyPrefs";
    private static final String PREF_KEY_EYE_STATUS = "status";

    private boolean isEyeOpen = false;

    private ShapeableImageView addWalletButton;
    private ImageView eyeToggleButton;
    private TextView walletBalanceText;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view,
                              @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        addWalletButton = view.findViewById(R.id.addWalltes);
        eyeToggleButton = view.findViewById(R.id.closeeye);
        walletBalanceText = view.findViewById(R.id.walletBalance);

        loadPreferences();

        updateEyeState();

        if (addWalletButton != null) {
            addWalletButton.setOnClickListener(v -> showWalletTransferBottomSheet());
        }

        if (eyeToggleButton != null) {
            eyeToggleButton.setOnClickListener(v -> toggleEyeState());
        }
    }
    private void toggleEyeState() {
        isEyeOpen = !isEyeOpen;
        updateEyeState();
        savePreferences(isEyeOpen);
    }
    private void updateEyeState() {
        if (walletBalanceText == null || eyeToggleButton == null) return;

        if (isEyeOpen) {
            walletBalanceText.setText("$190.00");
            eyeToggleButton.setImageResource(R.drawable.eye_off);
        } else {
            walletBalanceText.setText("*********");
            eyeToggleButton.setImageResource(R.drawable.eye);
        }
    }
    private void showWalletTransferBottomSheet() {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View contentView = inflater.inflate(R.layout.wallet_transfer_content, null);

        GlobalBottomSheet bottomSheet = new GlobalBottomSheet("Wallet Transfer", contentView);
        bottomSheet.show(getParentFragmentManager(), "walletTransferSheet");
    }
    private void savePreferences(boolean status) {
        Context context = getContext();
        if (context == null) return;
        SharedPreferences prefs = context.getSharedPreferences(PREFS_FILE, Context.MODE_PRIVATE);
        prefs.edit().putBoolean(PREF_KEY_EYE_STATUS, status).apply();
    }
    private void loadPreferences() {
        Context context = getContext();
        if (context == null) return;
        SharedPreferences prefs = context.getSharedPreferences(PREFS_FILE, Context.MODE_PRIVATE);
        isEyeOpen = prefs.getBoolean(PREF_KEY_EYE_STATUS, false);
    }
}
