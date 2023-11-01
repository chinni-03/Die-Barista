package com.example.diebarista;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.example.diebarista.adapter.ProductAdapter;
import com.example.diebarista.model.Products;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView prodItemRecycler;
    ProductAdapter productAdapter;
    ImageView category, bag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        category = findViewById(R.id.imageView8);

        category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start the Category activity
                Intent intent = new Intent(MainActivity.this, CategoryDetails.class);
                startActivity(intent);
            }
        });

        bag = findViewById(R.id.imageView9);

        bag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Bag.class);
                startActivity(intent);
            }
        });

        List<Products> hotList = new ArrayList<>();
        hotList.add(new Products(1, "Espresso", "Hot espresso from the coffee maker", "₹35", R.drawable.ic_espresso));
        hotList.add(new Products(2, "Latte", "Hot latte with extra milk and cream", "₹55", R.drawable.ic_latte));
        hotList.add(new Products(3, "Cappuccino", "Hot Cappuccino with extra cream", "₹75", R.drawable.ic_latte));

        setHotItemRecycler(hotList);

        List<Products> coldList = new ArrayList<>();
        coldList.add(new Products(1, "Iced Americano", "Iced Americano with extra ice", "₹75", R.drawable.ic_americano));
        coldList.add(new Products(2, "Iced Latte", "Iced latte with extra ice and cream", "₹85", R.drawable.ic_latte_cold));

        setColdItemRecycler(coldList);

    }

    private void setHotItemRecycler(List<Products> productsList) {
        prodItemRecycler = findViewById(R.id.productRecycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        prodItemRecycler.setLayoutManager(layoutManager);
        productAdapter = new ProductAdapter(this, productsList);
        prodItemRecycler.setAdapter(productAdapter);
    }

    private void setColdItemRecycler(List<Products> productsList) {
        prodItemRecycler = findViewById(R.id.productRecycler2);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        prodItemRecycler.setLayoutManager(layoutManager);
        productAdapter = new ProductAdapter(this, productsList);
        prodItemRecycler.setAdapter(productAdapter);
    }

}