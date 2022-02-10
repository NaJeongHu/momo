package com.uhackathon.momo.ui.matchhelpee;

import androidx.appcompat.app.AppCompatActivity;

import com.uhackathon.momo.R;
import com.uhackathon.momo.utility.BottomSheetDialogForHelpee_4;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MatchHelpeeActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout ll_gonext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_helpee);

        ll_gonext = findViewById(R.id.ll_gonext);
        ll_gonext.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_gonext:
                BottomSheetDialogForHelpee_4 bottomSheetDialog = new BottomSheetDialogForHelpee_4("");
                bottomSheetDialog.show(getSupportFragmentManager(), "bottomsheet");
                break;
        }
    }
}