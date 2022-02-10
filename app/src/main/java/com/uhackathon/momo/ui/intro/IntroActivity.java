package com.uhackathon.momo.ui.intro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.uhackathon.momo.R;
import com.uhackathon.momo.adapter.FragmentAdapter_ForIntro;
import com.uhackathon.momo.model.UserInfo;
import com.uhackathon.momo.ui.login.LoginActivity;
import com.uhackathon.momo.ui.main.MainActivity;
import com.uhackathon.momo.utility.NonSwipeViewPager;

import me.relex.circleindicator.CircleIndicator;

import static com.uhackathon.momo.adapter.FragmentAdapter_ForIntro.PAGE_POSITION;

public class IntroActivity extends AppCompatActivity {

    private UserInfo userInfo;
    private NonSwipeViewPager viewPager;
    private CircleIndicator circle_indicator;
    private FragmentAdapter_ForIntro adapter;

    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        preferences = getSharedPreferences("data", MODE_PRIVATE);
        editor= preferences.edit();

        adapter = new FragmentAdapter_ForIntro(getSupportFragmentManager(), PAGE_POSITION);
        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);
        circle_indicator = findViewById(R.id.circle_indicator);
        circle_indicator.setViewPager(viewPager);

        userInfo = new UserInfo();
    }

    public void goNext(String value, int position) {

        if (position == 4 && value.equals("비장애인")) {
            userInfo.setDisabled(value);
            viewPager.setCurrentItem(5,true);
            adapter.notifyDataSetChanged();
            return;
        }

        viewPager.setCurrentItem(position,true);
        adapter.notifyDataSetChanged();

        if (position == 1) userInfo.setNicname(value);
        if (position == 2) userInfo.setSex(value);
        if (position == 3) userInfo.setAge(Integer.parseInt(value));
        if (position == 4) userInfo.setDisabled(value);
        if (position == 5) userInfo.setDisabledType(value);
    }

    public void finishIntroActivity() {

        if (userInfo.getDisabled().equals("장애인")) {
            editor.putString("nicname",userInfo.getNicname());
            editor.putString("sex",userInfo.getSex());
            editor.putInt("age",userInfo.getAge());
            editor.putString("disabled",userInfo.getDisabled());
            editor.putString("disabled_type",userInfo.getDisabledType());
        } else {
            editor.putString("nicname",userInfo.getNicname());
            editor.putString("sex",userInfo.getSex());
            editor.putInt("age",userInfo.getAge());
            editor.putString("disabled",userInfo.getDisabled());
            editor.putString("disabled_type","비장애인");
        }
        editor.putBoolean("isPreSettingOver",true);
        editor.commit();

        Intent intent = new Intent(IntroActivity.this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }
}