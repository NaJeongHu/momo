package com.uhackathon.momo.utility;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.uhackathon.momo.R;

public class BottomSheetDialogForHelpee_2 extends BottomSheetDialogFragment implements View.OnClickListener{

    private View view;
    private String temp;
    private ImageView iv_forhelpee_1, iv_forhelpee_2;
    private LinearLayout ll_gonext;

    public BottomSheetDialogForHelpee_2(String temp) {
        this.temp = temp;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(BottomSheetDialogForHelpee_2.STYLE_NORMAL, R.style.BottomSheet_forHelpee_1);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.bottom_sheet_layout_forhelpee_2, container, false);

        iv_forhelpee_1 = view.findViewById(R.id.iv_forhelpee_1);
        iv_forhelpee_2 = view.findViewById(R.id.iv_forhelpee_2);
        ll_gonext = view.findViewById(R.id.ll_gonext);

        iv_forhelpee_1.setOnClickListener(this);
        iv_forhelpee_2.setOnClickListener(this);
        ll_gonext.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_forhelpee_1:
                iv_forhelpee_1.setColorFilter(Color.parseColor("#6952F6"), PorterDuff.Mode.SRC_IN);
                break;
            case R.id.iv_forhelpee_2:
                iv_forhelpee_2.setColorFilter(Color.parseColor("#6952F6"), PorterDuff.Mode.SRC_IN);
                break;
            case R.id.ll_gonext:
                dismiss();
                BottomSheetDialogForHelpee_3 bottomSheetDialog = new BottomSheetDialogForHelpee_3("");
                bottomSheetDialog.show(getActivity().getSupportFragmentManager(), "bottomsheet");
                break;
        }
    }
}
