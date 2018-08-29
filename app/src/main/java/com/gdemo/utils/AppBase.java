package com.gdemo.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.gdemo.R;

/**
 * Created by CategoryFragment on 8/22/2018.
 */
public class AppBase {

    public static void callFragment(Fragment fragment, String tag, FragmentManager manager  ){

        if(manager.getBackStackEntryCount() != 0) {
            String tag1 = manager.getBackStackEntryAt(manager.getBackStackEntryCount() - 1).getName();
            if (tag1.equals(tag)) {

            } else {

//            Toast.makeText(context, (manager.findFragmentByTag(tag) + ""), Toast.LENGTH_SHORT).show();
                if (manager.findFragmentByTag(tag) == null) { //fragment not in back stack, create it.
                    manager.beginTransaction().replace(R.id.app_bar_fragment_container, fragment).addToBackStack(tag).commit();

//                manager.executePendingTransactions();
                } else {
                    manager.beginTransaction().replace(R.id.app_bar_fragment_container, fragment).commit();
                    //              manager.executePendingTransactions();
                }
            }
        } else{
            manager.beginTransaction().replace(R.id.app_bar_fragment_container, fragment).addToBackStack(tag).commit();
        }
    }
}
