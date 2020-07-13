package com.example.application.viewpager_fragmenst;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ablanco.zoomy.DoubleTapListener;
import com.ablanco.zoomy.LongPressListener;
import com.ablanco.zoomy.TapListener;
import com.ablanco.zoomy.ZoomListener;
import com.ablanco.zoomy.Zoomy;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ViewHolder> {
    private List<CHAT_LIST> mcontact;
    Activity activity;
    public ContactsAdapter (List<CHAT_LIST> contacts,Activity activity) {
        this.mcontact = contacts;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ContactsAdapter.ViewHolder onCreateViewHolder (@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View contactView = inflater.inflate(R.layout.custom_card_view,parent,false);
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder (@NonNull ContactsAdapter.ViewHolder holder, int position) {
        CHAT_LIST contact = mcontact.get(position);


        //TextView name = holder.name;
        // name.setText(contact.getPic_name());



        holder.image.setImageResource(contact.getUrl());
        Zoomy.Builder builder = new Zoomy.Builder(activity).target(holder.image).enableImmersiveMode(false)
                .animateZooming(true);
        builder.register();
    }

    @Override
    public int getItemCount () {
        return mcontact.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public RoundedImageView image;
        public ViewHolder (@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.imageview);
            //  name= itemView.findViewById(R.id.text);

        }
    }
}
