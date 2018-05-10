package com.example.user.Prototype;

/**
 * Created by USER on 2018-05-02.
 */

public class FriendListViewItem {
    private int profile;
    private String name;

    public FriendListViewItem(int profile, String name) {
        this.profile = profile;
        this.name = name;
    }

    public int getProfile() {
        return profile;
    }

    public String getName() {
        return name;
    }
}
