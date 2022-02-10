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

public class DisabledDetailFragment extends Fragment implements View.OnClickListener {

    private LinearLayout ll_disabled_datail_see, ll_disabled_datail_hear, ll_gonext;
    private TextView tv_disabled_datail_see, tv_disabled_datail_hear;
    private String disabled_detail;

    public DisabledDetailFragment() {}

    public static DisabledDetailFragment newInstance() {
        DisabledDetailFragment fragment = new DisabledDetailFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_disabled_detail, container, false);

        ll_disabled_datail_see = view.findViewById(R.id.ll_disabled_datail_see);
        ll_disabled_datail_hear = view.findViewById(R.id.ll_disabled_datail_hear);
        tv_disabled_datail_see = view.findViewById(R.id.tv_disabled_datail_see);
        tv_disabled_datail_hear = view.findViewById(R.id.tv_disabled_datail_hear);
        ll_gonext = view.findViewById(R.id.ll_gonext);

        disabled_detail = "";

        ll_disabled_datail_see.setOnClickListener(this);
        ll_disabled_datail_hear.setOnClickListener(this);
        ll_gonext.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_disabled_datail_see:
                disabled_detail = "시각";
                ll_disabled_datail_see.setBackgroundResource(R.drawable.custom_cardview_shape_fill);
                tv_disabled_datail_see.setTextColor(getResources().getColor(R.color.white));
                ll_disabled_datail_hear.setBackgroundResource(R.drawable.custom_cardview_shape_nofill_gray);
                tv_disabled_datail_hear.setTextColor(getResources().getColor(R.color.gray_color));
                break;
            case R.id.ll_disabled_datail_hear:
                disabled_detail = "청각";
                ll_disabled_datail_hear.setBackgroundResource(R.drawable.custom_cardview_shape_fill);
                tv_disabled_datail_hear.setTextColor(getResources().getColor(R.color.white));
                ll_disabled_datail_see.setBackgroundResource(R.drawable.custom_cardview_shape_nofill_gray);
                tv_disabled_datail_see.setTextColor(getResources().getColor(R.color.gray_color));
                break;
            case R.id.ll_gonext:
                if(disabled_detail.equals("")) {
                    Toast.makeText(getActivity(),"장애 유형을 선택해주세요",Toast.LENGTH_SHORT).show();
                } else {
                    ((IntroActivity) requireActivity()).goNext(disabled_detail, 5);
                }
                break;
        }
    }
}