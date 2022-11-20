package com.example.tugas3;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;

public class homeFragment extends Fragment {
    RecyclerView recylerView;

    String s1[], s2[], s3[];
    int images[] =  {R.drawable.game,R.drawable.guardian,R.drawable.spidey,R.drawable.ironman};


    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public homeFragment() {
        // Required empty public constructor
    }

    public static homeFragment newInstance(String param1, String param2) {
        homeFragment fragment = new homeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recylerView = view.findViewById(R.id.recyclerView);
        s1 = getResources().getStringArray(R.array.film);
        s2 = getResources().getStringArray(R.array.genre);
        s3 = getResources().getStringArray(R.array.star);
        recylerView.setLayoutManager(new LinearLayoutManager(view.getContext(),LinearLayoutManager.HORIZONTAL,true));
        FilmAdapter appAdapter = new FilmAdapter(this,s1,s2,s3,images);
        recylerView.setAdapter(appAdapter);
        return view;
    }

}