package com.gdemo.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.gdemo.R;
import com.gdemo.activities.HomeActivity;
import com.gdemo.adapter.AdapterPager;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


public class HomeFragment extends Fragment {
    private ViewPager viewPager;
    private int currentPage = 0;
    private Timer timer;
    final long DELAY_MS = 1000;//delay in milliseconds before task is to be executed
    final long PERIOD_MS = 3000; // time in milliseconds between successive task executions.
    private ArrayList<String> imageList =new ArrayList<>();

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        LinearLayout toolbar_left = getView().findViewById(R.id.toolbar_left);
        toolbar_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((HomeActivity) getActivity()).drawerLayout1.openDrawer(GravityCompat.START);
            }
        });

        init();
    }

    private void init(){
        viewPager = getView().findViewById(R.id.fragment_home_viewpager);
        imageList.add("https://images-eu.ssl-images-amazon.com/images/G/31/img16/Grocery/BreakfastStore/kmande_2018-06-15T12-00_f010a5_1121973_grocery_750x375.jpg");
        imageList.add("https://www.wegmans.com/content/dam/wegmans/images/departments/18/summer/beverage-1.jpg");
        imageList.add("https://www.aldi.com.au/fileadmin/_processed_/9/f/csm_ALC6158_KVB_Groceries_1896x720_f90648edde.jpg");
        imageList.add("https://www.icicibank.com/managed-assets/images/offer-zone/credit-debit-card/cashback-offer-d.jpg");

        AdapterPager adapterPager  = new AdapterPager(getContext(), imageList);
        viewPager.setAdapter(adapterPager);
        TabLayout tabLayout = (TabLayout) getView().findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager, true);
        /*After setting the adapter use the timer */
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == imageList.size()-1) {
                    currentPage = 0;
                }
                viewPager.setCurrentItem(currentPage++, true);
            }
        };

        timer = new Timer(); // This will create a new Thread
        timer .schedule(new TimerTask() { // task to be scheduled

            @Override
            public void run() {
                handler.post(Update);
            }
        }, DELAY_MS, PERIOD_MS);

    }

    @Override
    public void onResume() {
        super.onResume();
        ((HomeActivity) getActivity()).setBottomColor();
        ((HomeActivity) getActivity()).tv_home.setTextColor(getResources().getColor(R.color.theme_color));
        ((HomeActivity) getActivity()).iv_home.setImageResource(R.drawable.ic_home_1);



    }
}
