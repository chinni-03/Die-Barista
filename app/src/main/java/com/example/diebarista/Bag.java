package com.example.diebarista;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.diebarista.adapter.ProductAdapter;
import com.example.diebarista.model.Products;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Bag extends AppCompatActivity {

    ImageView back, bag, home, category;
    RecyclerView prodItemRecycler;
    Button checkout;
    ProductAdapter productAdapter;

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        setContentView(R.layout.bag);

        category = findViewById(R.id.imageView8);
        bag = findViewById(R.id.imageView9);
        home = findViewById(R.id.imageView6);
        back = findViewById(R.id.back_btn);
        checkout = findViewById(R.id.button7);

        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(Bag.this, PayActivity.class);
                startActivity(in);
            }
        });

        Intent intent = getIntent();
        String name = intent.getStringExtra("COFFEE");
        String price = intent.getStringExtra("COFFEE");


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Bag.this, MainActivity.class);
                startActivity(intent);
            }
        });

        category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Bag.this, CategoryDetails.class);
                startActivity(intent);
            }
        });

        bag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Bag.this, Bag.class);
                startActivity(intent);
            }
        });
    }
}
