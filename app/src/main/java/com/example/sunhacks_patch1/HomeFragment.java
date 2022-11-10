package com.example.sunhacks_patch1;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }

    AppCompatButton proceed_to_gateway, proceed_to_taj, proceed_to_red_fort, proceed_to_chittorgarh;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        proceed_to_gateway = view.findViewById(R.id.proceed_gateway);
        proceed_to_taj = view.findViewById(R.id.proceed_taj);
        proceed_to_red_fort = view.findViewById(R.id.proceed_red_fort);
        proceed_to_chittorgarh = view.findViewById(R.id.proceed_chittorgarh);

        proceed_to_gateway.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), Monuments1.class));
            }
        });

        proceed_to_taj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), Monuments2.class));
            }
        });

        proceed_to_red_fort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), fort_1.class));
            }
        });

        proceed_to_chittorgarh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), Forts2.class));
            }
        });

        return view;
    }
}