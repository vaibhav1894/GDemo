package com.gdemo.activities;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gdemo.R;
import com.gdemo.fragments.BasketFragment;
import com.gdemo.fragments.HomeFragment;
import com.gdemo.fragments.OffersFragment;
import com.gdemo.fragments.CategoryFragment;
import com.gdemo.fragments.SearchFragment;
import com.gdemo.utils.AppBase;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    public static DrawerLayout drawerLayout1;
    public NavigationView navigationView;
    private LinearLayout frame_view;
    private float lastTranslate = 0.0f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        drawerLayout1 = findViewById(R.id.drawer_layout);
        frame_view = (LinearLayout) findViewById(R.id.frame_view);

        navigationView = (NavigationView) findViewById(R.id.nav_view);

        navigationView.setNavigationItemSelectedListener(this);
        final NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        View headerLayout = navigationView.getHeaderView(0);

        final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                float moveFactor = (navigationView.getWidth() * slideOffset);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
                    frame_view.setTranslationX(moveFactor);
                } else {
                    TranslateAnimation anim = new TranslateAnimation(lastTranslate, moveFactor, 0.0f, 0.0f);
                    anim.setDuration(0);
                    anim.setFillAfter(true);
                    frame_view.startAnimation(anim);

                    lastTranslate = moveFactor;
                }
            }
        };

        drawer.addDrawerListener(toggle);
        init();
    }


    private void init() {

//        tinyDB = new TinyDB(getApplicationContext());

        iv_home = findViewById(R.id.bottom_home_image);
        iv_category = findViewById(R.id.bottom_category_image);
        iv_search = findViewById(R.id.bottom_search_image);
        iv_offer = findViewById(R.id.bottom_offers_image);
        iv_basket = findViewById(R.id.bottom_basket_image);
        tv_home = findViewById(R.id.bottom_home_text);
        tv_category = findViewById(R.id.bottom_category_text);
        tv_search = findViewById(R.id.bottom_search_text);
        tv_offer = findViewById(R.id.bottom_offers_text);
        tv_basket = findViewById(R.id.bottom_basket_text);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.app_bar_fragment_container, new HomeFragment())
                .addToBackStack(HomeFragment.class.getName()).commit();
    }



    public void bottom_click(View view) {

        int id = view.getId();
        setBottomColor();

        if (id == R.id.bottom_home_layout){
            tv_home.setTextColor(getResources().getColor(R.color.theme_color));
            iv_home.setImageResource(R.drawable.ic_home_1);
            AppBase.callFragment(new HomeFragment(), HomeFragment.class.getName(),
                    getSupportFragmentManager());
        } else if (id == R.id.bottom_category_layout){
            tv_category.setTextColor(getResources().getColor(R.color.theme_color));
            iv_category.setImageResource(R.drawable.ic_menu_1);
            AppBase.callFragment(new CategoryFragment(), CategoryFragment.class.getName(),
                    getSupportFragmentManager());
        } else if (id == R.id.bottom_search_layout){
            tv_search.setTextColor(getResources().getColor(R.color.theme_color));
            iv_search.setImageResource(R.drawable.ic_magnifying_glass_1);
            AppBase.callFragment(new SearchFragment(), SearchFragment.class.getName(),
                    getSupportFragmentManager());

        } else if (id == R.id.bottom_offers_layout){
            tv_offer.setTextColor(getResources().getColor(R.color.theme_color));
            iv_offer.setImageResource(R.drawable.ic_offer_1);
            AppBase.callFragment(new OffersFragment(), OffersFragment.class.getName(),
                    getSupportFragmentManager());

        } else if (id == R.id.bottom_basket_layout){
            tv_basket.setTextColor(getResources().getColor(R.color.theme_color));
            iv_basket.setImageResource(R.drawable.ic_shopping_basket_button_1);
            AppBase.callFragment(new BasketFragment(), BasketFragment.class.getName(),
                    getSupportFragmentManager());
        }else{

        }
    }

    @SuppressLint("StaticFieldLeak")
    public static ImageView iv_home, iv_category, iv_search, iv_offer, iv_basket;
    @SuppressLint("StaticFieldLeak")
    public static TextView tv_home, tv_category, tv_search, tv_offer, tv_basket;

    public void setBottomColor(){
        tv_home.setTextColor(getResources().getColor(R.color.text_color_10));
        iv_home.setImageResource(R.drawable.ic_home);

        tv_category.setTextColor(getResources().getColor(R.color.text_color_10));
        iv_category.setImageResource(R.drawable.ic_menu);

        tv_search.setTextColor(getResources().getColor(R.color.text_color_10));
        iv_search.setImageResource(R.drawable.ic_magnifying_glass);

        tv_offer.setTextColor(getResources().getColor(R.color.text_color_10));
        iv_offer.setImageResource(R.drawable.ic_offer);
        tv_basket.setTextColor(getResources().getColor(R.color.text_color_10));
        iv_basket.setImageResource(R.drawable.ic_shopping_basket_button);

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }
}
