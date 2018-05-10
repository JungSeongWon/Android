package com.example.user.Prototype;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class FragementComment extends Fragment{

    View view;
    String url="http://cug.accessict.co.kr/addon/99999999/FR-0008.asp?strLoginID=jyk7141&strGroup=G001&intPage=1";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view =  inflater.inflate(R.layout.fragment_comment, container, false);

        ListView listView = (ListView)view.findViewById(R.id.friendList);

        ArrayList<FriendListViewItem> data = new ArrayList<>();
        FriendListViewItem ex1 = new FriendListViewItem(R.drawable.ic_account_circle_gray_24dp,"홍길동");
        FriendListViewItem ex2 = new FriendListViewItem(R.drawable.ic_account_circle_gray_24dp,"김철수 운전기사");
        FriendListViewItem ex3 = new FriendListViewItem(R.drawable.ic_account_circle_gray_24dp,"의전업체");
        FriendListViewItem ex4 = new FriendListViewItem(R.drawable.ic_account_circle_gray_24dp,"의전매니저");

        data.add(ex1);
        data.add(ex2);
        data.add(ex3);
        data.add(ex4);

        FriendListViewAdapter adapter = new FriendListViewAdapter(getContext(), data, R.layout.row_friend_list);
        listView.setAdapter(adapter);



        return view;
    }
}
