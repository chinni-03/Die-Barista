package com.example.diebarista;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.diebarista.adapter.CategoryAdapter;
import com.example.diebarista.adapter.ProductAdapter;
import com.example.diebarista.model.Category;
import com.example.diebarista.model.Products;

import java.util.ArrayList;
import java.util.List;

public class CategoryDetails extends AppCompatActivity {

    RecyclerView prodItemRecycler;
    ProductAdapter productAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category);

        Intent intent = getIntent();


        List<Products> hotList = new ArrayList<>();
        hotList.add(new Products(1, "       Espresso", "Hot espresso from the coffee maker", R.drawable.ic_espresso));
        hotList.add(new Products(2, "            Latte", "Hot latte with extra milk and cream", R.drawable.ic_latte));
        hotList.add(new Products(3, "      Cappuccino", "Hot Cappuccino with extra cream", R.drawable.ic_latte));
        hotList.add(new Products(1, "              Iced\n        Americano", "Hot espresso from the coffee maker",  R.drawable.ic_americano));
        hotList.add(new Products(2, "        Iced Coffee", "Hot latte with extra milk and cream", R.drawable.ic_latte_cold));
        hotList.add(new Products(1, "        Flat White", "Flat while with extra cream",  R.drawable.ic_flat_white));
        hotList.add(new Products(2, "            Frappe", "Cool Frappe with extra chocolate", R.drawable.ic_frappe));
        hotList.add(new Products(1, "        Irish Coffee", "Irish Coffee with the true essence of Iran",  R.drawable.ic_irish_coffee));
        hotList.add(new Products(2, "            Mocha", "Flat white with heavy cream", R.drawable.ic_mocha));

        setCategoryRecycler(hotList);

    }

    private void setCategoryRecycler(List<Products> catsList) {
        prodItemRecycler = findViewById(R.id.categoryRecycler);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
        prodItemRecycler.setLayoutManager(layoutManager);
        productAdapter = new ProductAdapter(this, catsList);
        prodItemRecycler.setAdapter(productAdapter);
    }
}
