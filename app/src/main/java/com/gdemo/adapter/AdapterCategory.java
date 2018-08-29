package com.gdemo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gdemo.R;

/**
 * Created by RAkhi.
 * Contact Number : +91 9958187463
 */
public class AdapterCategory extends RecyclerView.Adapter<AdapterCategory.MyViewHolder> {

    public AdapterCategory() {
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        public MyViewHolder(View view) {
            super(view);
        }
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_category, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

    }

    @Override
    public int getItemCount() {
        return 20;
    }



}