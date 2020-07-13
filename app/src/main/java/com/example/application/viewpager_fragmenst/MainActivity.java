package com.example.application.viewpager_fragmenst;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    //PagerViewAdapter pagerViewAdapter;
   // private FragmentStateAdapter pagerAdapter;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Activity activity = this;
        //creatting Fragments_chat adapter
        Fragment_Chat fragment_chat = new Fragment_Chat(activity);

        final ViewPager2 viewPager2 =findViewById(R.id.viewpager);
        PagerViewAdapter pagerAdapter = new PagerViewAdapter(this,activity);

        viewPager2.setAdapter(pagerAdapter);
        viewPager2.setUserInputEnabled(false);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected (@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.call :
                        viewPager2.setCurrentItem(0);
                        return true;
                    case R.id.camera:
                        viewPager2.setCurrentItem(1);
                        return true;
                    case R.id.chat:
                        viewPager2.setCurrentItem(2);
                        return true;

                }
                return false;
            }
        });
    }




}
