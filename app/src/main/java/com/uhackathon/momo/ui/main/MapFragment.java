package com.uhackathon.momo.ui.main;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.uhackathon.momo.R;
import com.uhackathon.momo.utility.BottomSheetDialogForHelpee_1;

public class MapFragment extends Fragment implements View.OnClickListener {

    private LinearLayout ll_helpme;

    public MapFragment() {}

    public static MapFragment newInstance() {
        MapFragment fragment = new MapFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_map,container,false);

        ll_helpme = view.findViewById(R.id.ll_helpme);
        ll_helpme.setOnClickListener(this);

        FragmentManager fm = getActivity().getSupportFragmentManager();
        MapFragment mapFragment = (MapFragment)fm.findFragmentById(R.id.map);
        if (mapFragment == null) {
            mapFragment = MapFragment.newInstance();
            fm.beginTransaction().add(R.id.map, mapFragment).commit();
        }

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_helpme:
                BottomSheetDialogForHelpee_1 bottomSheetDialog = new BottomSheetDialogForHelpee_1("");
                bottomSheetDialog.show(getActivity().getSupportFragmentManager(), "bottomsheet");
                break;
        }
    }
}