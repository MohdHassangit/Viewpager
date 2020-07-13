package com.example.application.viewpager_fragmenst;

import android.app.Activity;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

class PagerViewAdapter extends FragmentStateAdapter {
    Activity activity;


    public PagerViewAdapter (@NonNull FragmentActivity  fragment, Activity activity) {
        super(fragment);
        this.activity = activity;
    }

    @NonNull
    @Override
    public Fragment createFragment (int position) {
        Fragment fragment = null;
        switch (position){
            case 0:
                fragment = new Fragment_Call();
                break;
            case 1:
                fragment = new Fragment_Camera();
                break;
            case 2:
                fragment = new Fragment_Chat(activity);
                break;
        }
        return fragment;
    }

    @Override
    public int getItemCount () {
        return 3;
    }
}
