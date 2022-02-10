package com.uhackathon.momo.ui.intro;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.uhackathon.momo.R;

public class SexFragment extends Fragment implements View.OnClickListener {

    private LinearLayout ll_sex_female, ll_sex_male, ll_gonext;
    private TextView tv_sex_female, tv_sex_male;
    private String sex;

    public SexFragment() {}

    public static SexFragment newInstance() {
        SexFragment fragment = new SexFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_sex, container, false);

        ll_sex_female = view.findViewById(R.id.ll_sex_female);
        ll_sex_male = view.findViewById(R.id.ll_sex_male);
        ll_gonext = view.findViewById(R.id.ll_gonext);
        tv_sex_female = view.findViewById(R.id.tv_sex_female);
        tv_sex_male = view.findViewById(R.id.tv_sex_male);

        sex = "";

        ll_sex_female.setOnClickListener(this);
        ll_sex_male.setOnClickListener(this);
        ll_gonext.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_sex_female:
                sex = "여성";
                ll_sex_female.setBackgroundResource(R.drawable.custom_cardview_shape_fill);
                tv_sex_female.setTextColor(getResources().getColor(R.color.white));
                ll_sex_male.setBackgroundResource(R.drawable.custom_cardview_shape_nofill_gray);
                tv_sex_male.setTextColor(getResources().getColor(R.color.gray_color));
                break;
            case R.id.ll_sex_male:
                sex = "남성";
                ll_sex_male.setBackgroundResource(R.drawable.custom_cardview_shape_fill);
                tv_sex_male.setTextColor(getResources().getColor(R.color.white));
                ll_sex_female.setBackgroundResource(R.drawable.custom_cardview_shape_nofill_gray);
                tv_sex_female.setTextColor(getResources().getColor(R.color.gray_color));
                break;
            case R.id.ll_gonext:
                if(sex.equals("")) {
                    Toast.makeText(getActivity(),"성별을 선택해주세요",Toast.LENGTH_SHORT).show();
                } else {
                    ((IntroActivity) requireActivity()).goNext(sex, 2);
                }
                break;
        }
    }
}