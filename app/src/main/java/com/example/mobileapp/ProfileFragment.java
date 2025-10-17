package com.example.mobileapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ProfileFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.profile_activity, container, false);

        Button editProfileButton = view.findViewById(R.id.editProfileButton);
        editProfileButton.setOnClickListener(v -> showEditProfileDialog());

        return view;
    }

    private void showEditProfileDialog() {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View editProfileContent = inflater.inflate(R.layout.edit_profile_content, null);

        // Create your custom dialog
        GlobalDialogActivity editDialog = new GlobalDialogActivity(
                "Edit Profile",
                editProfileContent,
                "Please enter your new information"
        );

        // Show dialog
        editDialog.show(getParentFragmentManager(), "editDialog");
    }
}

