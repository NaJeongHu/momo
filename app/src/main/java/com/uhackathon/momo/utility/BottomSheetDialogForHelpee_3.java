package com.uhackathon.momo.utility;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.uhackathon.momo.R;
import com.uhackathon.momo.ui.main.MainActivity;

public class BottomSheetDialogForHelpee_3 extends BottomSheetDialogFragment implements View.OnClickListener{

    private View view;
    private String temp;

    public BottomSheetDialogForHelpee_3(String temp) {
        this.temp = temp;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(BottomSheetDialogForHelpee_3.STYLE_NORMAL, R.style.BottomSheet_forHelpee_1);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.bottom_sheet_layout_forhelpee_3, container, false);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // main에 트리거 줘야 함
                dismiss();
                ((MainActivity)requireActivity()).matchHelpeeStart();
            }
        }, 4000);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){ }
    }
}
