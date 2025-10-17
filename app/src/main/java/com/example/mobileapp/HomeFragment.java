package com.example.mobileapp;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import com.google.android.material.imageview.ShapeableImageView;

public class HomeFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_home, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ShapeableImageView addWallets = view.findViewById(R.id.addWalltes);
        ShapeableImageView openeye = view.findViewById(R.id.closeeye);
        TextView moneyTextView = view.findViewById(R.id.walletBalance);

        if (addWallets != null) {
            addWallets.setOnClickListener(v -> showBottomSheet());
        }
        if(openeye != null){
            isEyeOpen = true;
            openeye.setOnClickListener(v -> openEye(openeye , moneyTextView, "$190.00"));
        }
    }

    private void showIncreaseWalletDialog() {
        if (getContext() == null) return;
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        View dialogView = getLayoutInflater().inflate(R.layout.dialog_increase_wallet, null);
        builder.setView(dialogView);

        AlertDialog dialog = builder.create();

        EditText amountInput = dialogView.findViewById(R.id.etAmount);
        Button confirmButton = dialogView.findViewById(R.id.confirm_button  );
        Button cancelButton = dialogView.findViewById(R.id.cancel_button);

        confirmButton.setOnClickListener(v -> {
            String amount = amountInput.getText().toString().trim();
            if (amount.isEmpty()) {
                amountInput.setError("Please enter an amount");
            } else {
                Toast.makeText(getContext(), "Wallet increased by $" + amount, Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        cancelButton.setOnClickListener(v -> dialog.dismiss());
        dialog.show();

        if (dialog.getWindow() != null) {

            dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        }
    }
    private void showBottomSheet() {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View wallettransfercontent = inflater.inflate(R.layout.wallet_transfer_content, null);
        GlobalBottomSheet bottomSheet = new GlobalBottomSheet("Wallet Transfer", wallettransfercontent);
        bottomSheet.show(getParentFragmentManager(), "bottomSheet");

    }
    private boolean isEyeOpen = false;
    private void openEye(ImageView eyeImageView, TextView moneyTextView, String actualMoney) {
        if (isEyeOpen) {
            moneyTextView.setText("*********");
            eyeImageView.setImageResource(R.drawable.eye);
            isEyeOpen = false;
        } else {
            moneyTextView.setText(actualMoney);
            eyeImageView.setImageResource(R.drawable.eye_off);
            isEyeOpen = true;
        }
    }



}
