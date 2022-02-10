package com.uhackathon.momo.ui.intro;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.uhackathon.momo.R;

public class NicnameFragment extends Fragment {

    private EditText edit_intro_nicname;
    private LinearLayout ll_gonext;

    public NicnameFragment() {}

    public static NicnameFragment newInstance() {
        NicnameFragment fragment = new NicnameFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_nicname, container, false);

        edit_intro_nicname = view.findViewById(R.id.edit_intro_nicname);
        ll_gonext = view.findViewById(R.id.ll_gonext);

        ll_gonext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String et = edit_intro_nicname.getText().toString();
                if(et.equals("")) {
                    Toast.makeText(getActivity(),"닉네임을 입력해주세요",Toast.LENGTH_SHORT).show();
                } else {
                    ((IntroActivity) requireActivity()).goNext(et, 1);
                }
            }
        });

        return view;
    }
}