package com.example.user.Prototype;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by USER on 2018-05-02.
 */

public class FriendListViewAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private ArrayList<FriendListViewItem> data;
    private  int layout;

    public FriendListViewAdapter(Context context, ArrayList<FriendListViewItem> data, int layout) {
        this.inflater=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        this.data = data;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public String getItem(int i) {
        return data.get(i).getName();
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if(view == null){
            view=inflater.inflate(layout,viewGroup,false);
        }

        FriendListViewItem listViewItem = data.get(i);

        ImageView profile = (ImageView)view.findViewById(R.id.friendImg);
        profile.setImageResource(listViewItem.getProfile());

        TextView name = (TextView)view.findViewById(R.id.name);
        name.setText(listViewItem.getName());

        return view;
    }
}
