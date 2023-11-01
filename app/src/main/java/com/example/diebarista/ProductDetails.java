package com.example.diebarista;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.diebarista.adapter.ProductAdapter;
import com.example.diebarista.model.Products;

import java.util.ArrayList;
import java.util.List;

public class ProductDetails extends AppCompatActivity {

    RecyclerView prodItemRecycler;
    ProductAdapter productAdapter;
    TextView name, desc, quan, price;
    Spinner spinner;
    int counter = 1;
    Button plus, minus, toBuy, toBag;
    String[] quantity = {"50 mL", "100 mL", "150 mL", "200 mL", "250 mL", "300 mL", "350 mL"};
    ImageView image, back, home, cat, bag;

    String liquid = 1 +"";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_details);

        Intent intent = getIntent();
        String productName = intent.getStringExtra("PRODUCT_NAME");
        String productDesc = intent.getStringExtra("PRODUCT_DESC");
        int productImage = intent.getIntExtra("PRODUCT_IMAGE", -1);
        String productPrice = intent.getStringExtra("PRODUCT_PRICE");

        name = findViewById(R.id.textView5);
        name.setText(productName);
        desc = findViewById(R.id.textView6);
        desc.setText(productDesc);
        image = findViewById(R.id.image);
        image.setImageResource(productImage);
        price = findViewById(R.id.textView13);

        back = findViewById(R.id.back_btn);

        home = findViewById(R.id.imageView6);
        cat = findViewById(R.id.imageView8);
        bag = findViewById(R.id.imageView9);

        plus = findViewById(R.id.button2);
        minus = findViewById(R.id.button);
        quan = findViewById(R.id.textView15);

        spinner = findViewById(R.id.spinner);
        toBuy = findViewById(R.id.button3);
        toBag = findViewById(R.id.button4);

        toBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProductDetails.this, Bag.class);
                startActivity(intent);
            }
        });

        toBag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProductDetails.this, Bag.class);
                startActivity(intent);
            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                liquid = parent.getItemAtPosition(position).toString();
                switch(liquid) {
                    case "50 mL":
                        price.setText("");
                    price.setText("Price: " +liquid);
                    break;
                    case "100 mL": price.setText("");
                        price.setText("Price: " +liquid);
                        break;
                    case "150 mL": price.setText("");
                        price.setText("Price: " +liquid);
                        break;
                    case "200 mL": price.setText("");
                        price.setText("Price: " +liquid);
                        break;
                    case "250 mL": price.setText("");
                        price.setText("Price: " +liquid);
                        break;
                    case "300 mL": price.setText("");
                        price.setText("Price: " +liquid);
                        break;
                    case "350 mL": price.setText("");
                        price.setText("Price: " +liquid);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProductDetails.this, MainActivity.class);
                startActivity(intent);
            }
        });

        cat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProductDetails.this, CategoryDetails.class);
                startActivity(intent);
            }
        });

        bag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProductDetails.this, Bag.class);
                startActivity(intent);
            }
        });

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter = Integer.parseInt(quan.getText().toString());
                counter++;
                quan.setText(counter + "");
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter = Integer.parseInt(quan.getText().toString());
                if(counter == 1) {
                    Toast.makeText(ProductDetails.this, "Minimum quantity of 1 required", Toast.LENGTH_SHORT).show();
                } else {
                    counter--;
                }
                quan.setText(counter + "");
            }
        });

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, quantity);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
        spinner.setAdapter(adapter);

        List<Products> hotList = new ArrayList<>();
        hotList.add(new Products(1, "       Espresso", "Hot espresso from the coffee maker", R.drawable.ic_espresso));
        hotList.add(new Products(2, "            Latte", "Hot latte with extra milk and cream", R.drawable.ic_latte));
        hotList.add(new Products(3, "      Cappuccino", "Hot Cappuccino with extra cream", R.drawable.ic_latte));
        hotList.add(new Products(1, "              Iced\n        Americano", "Cold Americano from the coffee maker",  R.drawable.ic_americano));
        hotList.add(new Products(2, "        Iced Coffee", "Hot latte with extra milk and cream", R.drawable.ic_latte_cold));
        hotList.add(new Products(1, "        Flat White", "Flat while with extra cream",  R.drawable.ic_flat_white));
        hotList.add(new Products(2, "            Frappe", "Cool Frappe with extra chocolate", R.drawable.ic_frappe));
        hotList.add(new Products(1, "        Irish Coffee", "Irish Coffee with the true essence of Iran",  R.drawable.ic_irish_coffee));
        hotList.add(new Products(2, "            Mocha", "Flat white with heavy cream", R.drawable.ic_mocha));

        setPaneItemRecycler(hotList);
    }

    private void setPaneItemRecycler(List<Products> productsList) {
        prodItemRecycler = findViewById(R.id.leftPaneRecycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        prodItemRecycler.setLayoutManager(layoutManager);
        productAdapter = new ProductAdapter(this, productsList);
        prodItemRecycler.setAdapter(productAdapter);
    }
}