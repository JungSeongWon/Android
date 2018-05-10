package com.example.user.Prototype;

import android.content.ContentValues;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by USER on 2018-04-04.
 */

public class FragmentMemo extends Fragment{

    View view;
    String url = "http://cug.accessict.co.kr/addon/99999999/FR-0004.asp?strLoginID=jyk7141";
    TextView menoText;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.fragment_memo, null, false);

        menoText = (TextView)view.findViewById(R.id.menoText);




        return view;
    }



}
