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

import com.example.diebarista.CategoryDetails;
import com.example.diebarista.ProductDetails;
import com.example.diebarista.R;
import com.example.diebarista.model.Category;
import com.example.diebarista.model.Products;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    Context context;
    List<Category> catList;

    public CategoryAdapter(Context context, List<Category> catList) {
        this.context = context;
        this.catList = catList;
    }

    public static final class CategoryViewHolder extends RecyclerView.ViewHolder {
        ImageView prodImage;
        TextView prodName, prodDesc, prodPrice, prodCat;


        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);

            prodImage = itemView.findViewById(R.id.imageView5);
            prodCat = itemView.findViewById(R.id.textView17);
        }
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.category_card, parent, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        holder.prodImage.setImageResource(catList.get(position).getImgUrl());
        holder.prodCat.setText(catList.get(position).getCategory());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ProductDetails.class);

                Category clickedProduct = catList.get(holder.getAdapterPosition());

                intent.putExtra("PRODUCT_NAME", clickedProduct.getCategory());
                intent.putExtra("PRODUCT_DESC", clickedProduct.getCategory());
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
        return catList.size();
    }
}
