package com.uhackathon.momo.utility;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.media.Image;
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

public class BottomSheetDialogForHelpee_1 extends BottomSheetDialogFragment implements View.OnClickListener{

    private View view;
    private String temp;
    private ImageView iv_forhelpee_1;
    private LinearLayout ll_gonext;

    public BottomSheetDialogForHelpee_1(String temp) {
        this.temp = temp;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(BottomSheetDialogForHelpee_1.STYLE_NORMAL, R.style.BottomSheet_forHelpee_1);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.bottom_sheet_layout_forhelpee_1, container, false);

        iv_forhelpee_1 = view.findViewById(R.id.iv_forhelpee_1);
        ll_gonext = view.findViewById(R.id.ll_gonext);

        iv_forhelpee_1.setOnClickListener(this);
        ll_gonext.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_forhelpee_1:
                iv_forhelpee_1.setColorFilter(Color.parseColor("#6952F6"), PorterDuff.Mode.SRC_IN);
                break;
            case R.id.ll_gonext:
                dismiss();
                BottomSheetDialogForHelpee_2 bottomSheetDialog = new BottomSheetDialogForHelpee_2("");
                bottomSheetDialog.show(getActivity().getSupportFragmentManager(), "bottomsheet");
                break;
        }
    }
}
