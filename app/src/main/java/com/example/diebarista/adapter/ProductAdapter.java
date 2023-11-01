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

import com.example.diebarista.ProductDetails;
import com.example.diebarista.R;
import com.example.diebarista.model.Products;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    Context context;
    List<Products> productsList;

    public ProductAdapter(Context context, List<Products> productsList) {
        this.context = context;
        this.productsList = productsList;
    }

    public static final class ProductViewHolder extends RecyclerView.ViewHolder {
        ImageView prodImage;
        TextView prodName, prodDesc, prodPrice, prodCat;


        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);

            prodImage = itemView.findViewById(R.id.prodImage);
            prodName = itemView.findViewById(R.id.prodName);
//            prodDesc = itemView.findViewById(R.id.prodDesc);
            prodPrice = itemView.findViewById(R.id.prodPrice);
            prodCat = itemView.findViewById(R.id.textView17);
        }
    }

    @NonNull
    @Override
    public ProductAdapter.ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.product_card, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.ProductViewHolder holder, int position) {
        holder.prodImage.setImageResource(productsList.get(position).getImgUrl());
        holder.prodName.setText(productsList.get(position).getProductName());
//        holder.prodDesc.setText(productsList.get(position).getProductDesc());
        holder.prodPrice.setText(productsList.get(position).getProductPrice());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ProductDetails.class);

                Products clickedProduct = productsList.get(holder.getAdapterPosition());

                intent.putExtra("PRODUCT_ID", clickedProduct.getProductId());
                intent.putExtra("PRODUCT_NAME", clickedProduct.getProductName());
                intent.putExtra("PRODUCT_DESC", clickedProduct.getProductDesc());
                intent.putExtra("PRODUCT_IMAGE", clickedProduct.getImgUrl());
                intent.putExtra("PRODUCT_PRICE", clickedProduct.getProductPrice());

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
