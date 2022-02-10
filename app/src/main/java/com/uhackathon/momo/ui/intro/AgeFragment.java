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

public class AgeFragment extends Fragment {

    private EditText edit_intro_age;
    private LinearLayout ll_gonext;

    public AgeFragment() {}

    public static AgeFragment newInstance() {
        AgeFragment fragment = new AgeFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_age, container, false);

        edit_intro_age = view.findViewById(R.id.edit_intro_age);
        ll_gonext = view.findViewById(R.id.ll_gonext);

        ll_gonext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String et = edit_intro_age.getText().toString();
                if(et.equals("")) {
                    Toast.makeText(getActivity(),"나이를 작성해주세요",Toast.LENGTH_SHORT).show();
                } else {
                    ((IntroActivity) requireActivity()).goNext(et, 3);
                }
            }
        });
        return view;
    }
}