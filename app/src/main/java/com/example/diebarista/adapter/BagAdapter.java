package com.example.diebarista.adapter;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.diebarista.Bag;
import com.example.diebarista.CategoryDetails;
import com.example.diebarista.ProductDetails;
import com.example.diebarista.R;
import com.example.diebarista.model.Category;
import com.example.diebarista.model.Products;

import java.util.List;

public class BagAdapter extends RecyclerView.Adapter<BagAdapter.BagViewHolder> {

    Context context;
    List<Products> productsList;

    public BagAdapter(Context context, List<Products> productsList) {
        this.context = context;
        this.productsList = productsList;
    }

    public static final class BagViewHolder extends RecyclerView.ViewHolder {
        ImageView prodImage;


        public BagViewHolder(@NonNull View itemView) {
            super(itemView);

            prodImage = itemView.findViewById(R.id.imageView7);
        }
    }

    @NonNull
    @Override
    public BagViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.category_card, parent, false);
        return new BagViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BagViewHolder holder, int position) {
        holder.prodImage.setImageResource(productsList.get(position).getImgUrl());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Bag.class);

                Products clickedProduct = productsList.get(holder.getAdapterPosition());

                intent.putExtra("PRODUCT_IMAGE", clickedProduct.getImgUrl());

                context.startActivity(intent);

                Pair[] pairs = new Pair[1];
                pairs[0] = new Pair<View, String>(holder.prodImage, "image");
                ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation((Activity) context, pairs);
                context.startActivity(intent, activityOptions.toBundle());
            }
        });

    }

    @Override
    public int getItemCount() {
        return productsList.size();
    }
}
