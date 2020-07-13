package com.example.application.viewpager_fragmenst;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import java.util.List;

public class Fragment_Chat extends Fragment {
    List<CHAT_LIST> contacts;
    Activity activity;

    public Fragment_Chat(Activity activity) {
        this.activity = activity;
    }

    @Nullable
    @Override
    public View onCreateView (@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_chat,container,false);
        ViewPager2 viewPager2 = view.findViewById(R.id.viewPager_2);

        contacts = CHAT_LIST.createContactsList();
        contacts.add( new CHAT_LIST(R.drawable.fish_1, "0"));
        contacts.add( new CHAT_LIST(R.drawable.jelly_fish, "1"));
        contacts.add( new CHAT_LIST(R.drawable.totorries_1, "0"));
        contacts.add( new CHAT_LIST(R.drawable.tortries_2, "1"));
        contacts.add( new CHAT_LIST(R.drawable.tortries_3, "0"));
        contacts.add( new CHAT_LIST(R.drawable.tortries_4, "1"));
        contacts.add( new CHAT_LIST(R.drawable.fish_1, "0"));
        contacts.add( new CHAT_LIST(R.drawable.jelly_fish, "1"));



        final ContactsAdapter adapter = new ContactsAdapter(contacts,activity);
        viewPager2.setAdapter(adapter);

        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);
        //   viewPager2.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        viewPager2.setOffscreenPageLimit(3);
        viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        final float pageMargin= getResources().getDimensionPixelOffset(R.dimen.pageMargin);
        final float pageOffset = getResources().getDimensionPixelOffset(R.dimen.offset);

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(10));

        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage (@NonNull View page, float position) {
                float myOffset = position * -(2 * pageOffset + pageMargin);
                page.setTranslationX(myOffset);
                float r =1 - Math.abs(position);
                page.setScaleY(0.85f + r * 0.15f);
            }
        });
        viewPager2.setPageTransformer(compositePageTransformer);
        return view;
        //return inflater.inflate(R.layout.fragment_chat, container, false);

    }
}