package com.example.mobileapp;

import android.animation.Animator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class GlobalDialogActivity extends DialogFragment {

    private String title;

    private String Description;

    private View ViewContent;

    public GlobalDialogActivity(String title, View contentView , String Description) {
        this.title = title;
        this.Description = Description;
        this.ViewContent = contentView;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.layout_dialog, container, false);
        TextView tvTitle = root.findViewById(R.id.dialogTitle);
        Button Cancelbtn = root.findViewById(R.id.btncancel);
        TextView tvDescription = root.findViewById(R.id.dialogDescription);
        FrameLayout contentContainer = root.findViewById(R.id.dialogContent);
        if (title != null) {
            tvTitle.setText(title);
        }
        if (Description != null) {
            tvDescription.setText(Description);
        }
        if (ViewContent != null) {
            contentContainer.addView(ViewContent);
        }
        if(Cancelbtn != null){
            Cancelbtn.setOnClickListener(v -> dismiss());
        }

        return root;
    }
    @Override
    public void onStart() {
        super.onStart();
        if (getDialog() != null && getDialog().getWindow() != null) {
            getDialog().getWindow().setLayout(
                    (int) (getResources().getDisplayMetrics().widthPixels * 0.9),
                    ViewGroup.LayoutParams.WRAP_CONTENT
            );
            getDialog().getWindow().setBackgroundDrawableResource(android.R.color.transparent);
            getDialog().getWindow().getAttributes().windowAnimations = R.style.BottomSheetCustomAnimation;
        }
    }
}
