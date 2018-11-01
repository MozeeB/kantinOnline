package com.example.mozeeb.kantinonline.adapter;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mozeeb.kantinonline.R;
import com.example.mozeeb.kantinonline.user.DetailsActivity;
import com.example.mozeeb.kantinonline.model.Barang;

import java.util.List;

public class BarangAdapter extends RecyclerView.Adapter<BarangAdapter.ProductViewHolder> {


    //this context we will use to inflate the layout
    private Context mCtx;

    //we are storing all the products in a list
    private List<Barang> productList;

    //getting the context and product list with constructor
    public BarangAdapter(Context mCtx, List<Barang> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.design_list, null);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        //getting the product of the specified position
        final Barang product = productList.get(position);

        //binding the data with the viewholder views
        holder.textViewTitle.setText(product.getTitle());
        holder.textViewRating.setText(String.valueOf(product.getRating()));
        holder.textViewPrice.setText(String.valueOf(product.getPrice()));

        holder.imageView.setImageDrawable(mCtx.getResources().getDrawable(product.getImage()));
        holder.beli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mCtx, DetailsActivity.class);
                intent.putExtra("gambar", product.getImage());
                intent.putExtra("judul", product.getTitle());
                intent.putExtra("harga",  product.getPrice());
                mCtx.startActivity(intent);


            }
        });




    }


    @Override
    public int getItemCount() {
        return productList.size();
    }


    class ProductViewHolder extends RecyclerView.ViewHolder {

        TextView textViewTitle, textViewRating, textViewPrice;
        ImageView imageView;
        Button beli;

        public ProductViewHolder(View itemView) {
            super(itemView);

            textViewTitle = itemView.findViewById(R.id.nama_barang);
            textViewRating = itemView.findViewById(R.id.rating_barang);
            textViewPrice = itemView.findViewById(R.id.harga_barang);
            imageView = itemView.findViewById(R.id.gambar_barang);
            beli = itemView.findViewById(R.id.beli_barang);
        }
    }
}
