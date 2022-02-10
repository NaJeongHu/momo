package com.uhackathon.momo.ui.main;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.uhackathon.momo.R;

public class ShopFragment extends Fragment {

    private LinearLayout ll_goback;

    public ShopFragment() {}

    public static ShopFragment newInstance() {
        ShopFragment fragment = new ShopFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shop, container, false);

        ll_goback = view.findViewById(R.id.ll_goback);
        ll_goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // back to salt
                ((MainActivity) requireActivity()).replaceBottomTab(RewardFragment.newInstance());
                ((MainActivity) requireActivity()).setVisibility();
            }
        });

        return view;
    }
}