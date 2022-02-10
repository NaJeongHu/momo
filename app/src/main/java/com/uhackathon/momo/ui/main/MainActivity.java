package com.uhackathon.momo.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.uhackathon.momo.adapter.FragmentAdapter_ForMain;
import com.uhackathon.momo.R;
import com.uhackathon.momo.ui.matchhelpee.MatchHelpeeActivity;
import com.uhackathon.momo.utility.NonSwipeViewPager;

import static com.uhackathon.momo.adapter.FragmentAdapter_ForMain.PAGE_POSITION;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";

    private TabLayout tabLayout;
    private NonSwipeViewPager viewPager;

    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    private TextView tv_1, tv_2, tv_3, tv_4;
    private ImageView iv_1, iv_2, iv_3, iv_4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferences = getSharedPreferences("data", MODE_PRIVATE);
        editor= preferences.edit();

        Log.d(TAG, "preferences test : " + preferences.getString("nicname",""));
        Log.d(TAG, "preferences test : " + preferences.getString("sex",""));
        Log.d(TAG, "preferences test : " + preferences.getString("disabled",""));
        Log.d(TAG, "preferences test : " + preferences.getString("disabled_type",""));

        setTabLayout();
        setViewPager();

    }

    @TargetApi(Build.VERSION_CODES.N)
    private void setTabLayout(){
        FragmentAdapter_ForMain adapter = new FragmentAdapter_ForMain(getSupportFragmentManager(), PAGE_POSITION, MainActivity.this);
        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tab);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            tab.setCustomView(adapter.getTabView(i));
        }

        tv_1 = tabLayout.getTabAt(0).getCustomView().findViewById(R.id.textView);
        tv_2 = tabLayout.getTabAt(1).getCustomView().findViewById(R.id.textView);
        tv_3 = tabLayout.getTabAt(2).getCustomView().findViewById(R.id.textView);
        tv_4 = tabLayout.getTabAt(3).getCustomView().findViewById(R.id.textView);

        iv_1 = tabLayout.getTabAt(0).getCustomView().findViewById(R.id.imgView);
        iv_2 = tabLayout.getTabAt(1).getCustomView().findViewById(R.id.imgView);
        iv_3 = tabLayout.getTabAt(2).getCustomView().findViewById(R.id.imgView);
        iv_4 = tabLayout.getTabAt(3).getCustomView().findViewById(R.id.imgView);

        iv_1.setColorFilter(Color.parseColor("#FB8F6F"), PorterDuff.Mode.SRC_IN);
        tv_1.setVisibility(View.VISIBLE);
        iv_2.setColorFilter(Color.parseColor("#FFFFFF"), PorterDuff.Mode.SRC_IN);
        iv_3.setColorFilter(Color.parseColor("#FFFFFF"), PorterDuff.Mode.SRC_IN);
        iv_4.setColorFilter(Color.parseColor("#FFFFFF"), PorterDuff.Mode.SRC_IN);
    }

    private void setViewPager() {
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition(),true);
                //tab.getIcon().setColorFilter(Color.BLACK, PorterDuff.Mode.SRC_IN);
                ImageView iv = tab.getCustomView().findViewById(R.id.imgView);
                iv.setColorFilter(Color.parseColor("#FB8F6F"), PorterDuff.Mode.SRC_IN);
                tab.getCustomView().findViewById(R.id.textView).setVisibility(View.VISIBLE);
                setStatusBarColor(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                //tab.getIcon().setColorFilter(Color.parseColor("#808080"), PorterDuff.Mode.SRC_IN);
                ImageView iv = tab.getCustomView().findViewById(R.id.imgView);
                iv.setColorFilter(Color.parseColor("#FFFFFF"), PorterDuff.Mode.SRC_IN);
                tab.getCustomView().findViewById(R.id.textView).setVisibility(View.GONE);
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) { }
        });
    }

    public void matchHelpeeStart() {
        Intent intent = new Intent(MainActivity.this, MatchHelpeeActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }

    private void setStatusBarColor(int position) {

        Window window = getWindow();

        switch (position) {
            case 0:
                window.setStatusBarColor(getResources().getColor(R.color.main_color));
                break;
            case 1:
                window.setStatusBarColor(getResources().getColor(R.color.community_status_color));
                break;
            case 2:
                window.setStatusBarColor(getResources().getColor(R.color.salt_status_color));
                break;
            case 3:
                window.setStatusBarColor(getResources().getColor(R.color.community_status_color));
                break;
        }
    }

    public void replaceBottomTab(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.child_frag_container, fragment).commit();
    }

    public void setVisibility() {
        FrameLayout frameLayout = findViewById(R.id.child_frag_container);
        frameLayout.setVisibility(View.GONE);
    }
}