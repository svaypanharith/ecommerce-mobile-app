package com.example.ecommerceapp;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Button;

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

    private Integer countQuantity = 0 ;

    String[] colors = {"#F77E2D", "#32374A", "#F5F5F5"};

    String[] storages = {"512GB", "1T", "2T"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.productdetail_activity);



        View header = findViewById(R.id.headerInclude);
        TextView title = header.findViewById(R.id.header_title);
        TextView tvQuantity = findViewById(R.id.tvQuantity);
        View backButton = header.findViewById(R.id.backButton);
        LinearLayout colorContainer = findViewById(R.id.colorContainer);
        LinearLayout storageContainer = findViewById(R.id.storageContainer);
        Button btnincrteaseqty = findViewById(R.id.btnIncreaseQty);
        Button btnDecreaseQty = findViewById(R.id.btnDecreaseQty);
        title.setText("Product Detail");
        BackButtonHelper.setupBackButton(backButton, this);

        tvQuantity.setText(String.valueOf(countQuantity));

        btnincrteaseqty.setOnClickListener(v -> {
            countQuantity++;
            tvQuantity.setText(String.valueOf(countQuantity));
        });

        btnDecreaseQty.setOnClickListener( v -> {
                 if(countQuantity == 0){
                     return;
                 }
                countQuantity--;
                tvQuantity.setText(String.valueOf(countQuantity));
        });

        viewPager = findViewById(R.id.productImageCarousel);
        dotsIndicator = findViewById(R.id.dotsIndicator);

        List<Integer> images = new ArrayList<>();
        images.add(R.drawable.apple_iphone_17_pro_256gb_cosmic_orange_fb0bc_reference);
        images.add(R.drawable.iphone_17_pro_max_deep_blue_);
        images.add(R.drawable.wqzw9_sq1_0000000035_silver_slf);

        imageAdapter = new ImageDetailAdapter(images);
        viewPager.setAdapter(imageAdapter);

        new TabLayoutMediator(dotsIndicator, viewPager,
                (tab, position) -> { /* no text needed */ }).attach();

        for (String color : colors) {
            View colorView = new View(this);

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    (int) getResources().getDimension(R.dimen.color_circle_size),
                    (int) getResources().getDimension(R.dimen.color_circle_size)
            );
            params.setMargins(0, 0, 24 , 0);
            colorView.setLayoutParams(params);

            colorView.setBackgroundResource(R.drawable.color_circle);
            colorView.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(color)));
            colorContainer.addView(colorView);
        }

        for (String storage : storages) {
            TextView storageView = new TextView(this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            params.setMargins(0, 0, 24, 0);
            storageView.setLayoutParams(params);
            storageView.setText(storage);
            storageView.setPadding(24, 12, 24, 12); // pill shape
            storageView.setTextColor(Color.BLACK);
            storageView.setBackgroundResource(R.drawable.rectanglestyle); // rounded rectangle
            storageView.setGravity(Gravity.CENTER);

            storageContainer.addView(storageView);
        }


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
