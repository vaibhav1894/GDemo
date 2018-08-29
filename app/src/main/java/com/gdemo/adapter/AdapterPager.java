package com.gdemo.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.gdemo.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdapterPager extends PagerAdapter {

    LayoutInflater mLayoutInflater;
    Context context;
    ArrayList<String>arrayList ;

    public AdapterPager(Context context, ArrayList<String> arr_) {
        this.context = context;
        this.arrayList = arr_;
        mLayoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    private ImageView iv_prod;

    @SuppressLint("SetTextI18n")
    @Override
    public Object instantiateItem(ViewGroup container, final int position) {

        View view = mLayoutInflater.inflate(R.layout.item_pager, container, false);

        iv_prod = view.findViewById(R.id.home_image);

        Picasso.with(context).load(arrayList.get(position)).into(iv_prod);

        ((ViewPager)container).addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((View) object);
    }

    @Override
    public int getItemPosition(Object object) {
//        return super.getItemPosition(object);
        return POSITION_NONE;
    }

}