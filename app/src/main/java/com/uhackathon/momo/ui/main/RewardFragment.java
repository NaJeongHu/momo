package com.uhackathon.momo.ui.main;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.uhackathon.momo.R;

public class RewardFragment extends Fragment implements View.OnClickListener {

    private RelativeLayout rela_shop;

    public RewardFragment() { }

    public static RewardFragment newInstance() {
        RewardFragment fragment = new RewardFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_reward,container,false);

        rela_shop = view.findViewById(R.id.rela_shop);
        rela_shop.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.rela_shop:
                ((MainActivity) requireActivity()).replaceBottomTab(ShopFragment.newInstance());
                break;
        }
    }
}