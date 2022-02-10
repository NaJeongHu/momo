package com.uhackathon.momo.ui.intro;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.uhackathon.momo.R;

public class WelcomeFragment extends Fragment {

    private LinearLayout ll_gonext;

    public WelcomeFragment() {}

    public static WelcomeFragment newInstance() {
        WelcomeFragment fragment = new WelcomeFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_welcome, container, false);

        ll_gonext = view.findViewById(R.id.ll_gonext);
        ll_gonext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((IntroActivity) requireActivity()).finishIntroActivity();
            }
        });

        return view;
    }
}