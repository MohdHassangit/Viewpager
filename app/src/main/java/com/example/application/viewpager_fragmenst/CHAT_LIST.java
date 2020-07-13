package com.example.application.viewpager_fragmenst;

import java.util.ArrayList;

class CHAT_LIST {
    public int url;
    public String pic_name;

    public CHAT_LIST (int url, String pic_name) {
        this.url = url;
        this.pic_name = pic_name;
    }

    public int getUrl () {
        return url;
    }

    public String getPic_name () {
        return pic_name;
    }


    public static ArrayList<CHAT_LIST> createContactsList() {
        ArrayList<CHAT_LIST> contacts = new ArrayList<CHAT_LIST>();
        return contacts;
    }
}
