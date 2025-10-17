package com.example.mobileapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import android.widget.FrameLayout;
import android.widget.TextView;


public class GlobalBottomSheet extends BottomSheetDialogFragment {

    private String title;
    private View contentView;

    public GlobalBottomSheet(String title, View contentView) {
        this.title = title;
        this.contentView = contentView;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.layout_bottom_sheet, container, false);

        TextView tvTitle = root.findViewById(R.id.bottomSheetTitle);
        FrameLayout contentContainer = root.findViewById(R.id.bottomSheetContent);

        if (title != null) {
            tvTitle.setText(title);
        }
        if (contentView != null) {
            contentContainer.addView(contentView);
        }

        return root;
    }

}

