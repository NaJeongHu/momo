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

public class DisabledFragment extends Fragment implements View.OnClickListener {

    private LinearLayout ll_disabled_disabled, ll_disabled_abled, ll_gonext;
    private TextView tv_disabled_disabled, tv_disabled_abled;
    private String type;

    public DisabledFragment() {}

    public static DisabledFragment newInstance() {
        DisabledFragment fragment = new DisabledFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_disabled, container, false);

        ll_disabled_disabled = view.findViewById(R.id.ll_disabled_disabled);
        ll_disabled_abled = view.findViewById(R.id.ll_disabled_abled);
        ll_gonext = view.findViewById(R.id.ll_gonext);
        tv_disabled_disabled = view.findViewById(R.id.tv_disabled_disabled);
        tv_disabled_abled = view.findViewById(R.id.tv_disabled_abled);

        type = "";

        ll_disabled_disabled.setOnClickListener(this);
        ll_disabled_abled.setOnClickListener(this);
        ll_gonext.setOnClickListener(this);
        // todo : 비장애인인 경우 sp에 is intro over 정보 저장, 장애인의 경우 datail에서 정보 저장

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_disabled_disabled:
                type = "장애인";
                ll_disabled_disabled.setBackgroundResource(R.drawable.custom_cardview_shape_fill);
                tv_disabled_disabled.setTextColor(getResources().getColor(R.color.white));
                ll_disabled_abled.setBackgroundResource(R.drawable.custom_cardview_shape_nofill_gray);
                tv_disabled_abled.setTextColor(getResources().getColor(R.color.gray_color));
                break;
            case R.id.ll_disabled_abled:
                type = "비장애인";
                ll_disabled_abled.setBackgroundResource(R.drawable.custom_cardview_shape_fill);
                tv_disabled_abled.setTextColor(getResources().getColor(R.color.white));
                ll_disabled_disabled.setBackgroundResource(R.drawable.custom_cardview_shape_nofill_gray);
                tv_disabled_disabled.setTextColor(getResources().getColor(R.color.gray_color));
                break;
            case R.id.ll_gonext:
                if(type.equals("")) {
                    Toast.makeText(getActivity(),"장애 여부를 선택해주세요",Toast.LENGTH_SHORT).show();
                } else {
                    ((IntroActivity) requireActivity()).goNext(type, 4);
                }
                break;
        }
    }
}