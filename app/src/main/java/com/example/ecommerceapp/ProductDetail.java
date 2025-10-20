package com.example.ecommerceapp;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

public class ProductDetail extends AppCompatActivity {

    private ViewPager2 viewPager;
    private TabLayout dotsIndicator;
    private ImageDetailAdapter imageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.productdetail_activity);

        View header = findViewById(R.id.headerInclude);
        TextView title = header.findViewById(R.id.header_title);
        View backButton = header.findViewById(R.id.backButton);
        title.setText("Product Detail");
        BackButtonHelper.setupBackButton(backButton, this);

        viewPager = findViewById(R.id.productImageCarousel);
        dotsIndicator = findViewById(R.id.dotsIndicator);

        List<Integer> images = new ArrayList<>();
        images.add(R.drawable.iphone_17_pro_max_cosmic_orange);
        images.add(R.drawable.iphone_17_pro_max_cosmic_orange);
        images.add(R.drawable.iphone_17_pro_max_cosmic_orange);

        imageAdapter = new ImageDetailAdapter(images);
        viewPager.setAdapter(imageAdapter);

        new TabLayoutMediator(dotsIndicator, viewPager,
                (tab, position) -> { /* no text needed */ }).attach();

        for (int i = 0; i < dotsIndicator.getTabCount(); i++) {
            View tab = ((ViewGroup) dotsIndicator.getChildAt(0)).getChildAt(i);
            ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) tab.getLayoutParams();
            params.setMargins(16    , 0, 16, 0);
            tab.setLayoutParams(params);
        }
        findViewById(R.id.btnAddToCart).setOnClickListener(v -> {
        });
    }
}
