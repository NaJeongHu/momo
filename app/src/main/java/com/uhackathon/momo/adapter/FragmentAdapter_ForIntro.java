package com.uhackathon.momo.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.uhackathon.momo.ui.intro.AgeFragment;
import com.uhackathon.momo.ui.intro.DisabledDetailFragment;
import com.uhackathon.momo.ui.intro.DisabledFragment;
import com.uhackathon.momo.ui.intro.NicnameFragment;
import com.uhackathon.momo.ui.intro.SexFragment;
import com.uhackathon.momo.ui.intro.WelcomeFragment;
import com.uhackathon.momo.ui.main.CommunityFragment;
import com.uhackathon.momo.ui.main.MapFragment;
import com.uhackathon.momo.ui.main.RewardFragment;
import com.uhackathon.momo.ui.main.SettingsFragment;

public class FragmentAdapter_ForIntro extends FragmentPagerAdapter {

    public static int PAGE_POSITION = 6;

    public FragmentAdapter_ForIntro(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return NicnameFragment.newInstance();
            case 1:
                return SexFragment.newInstance();
            case 2:
                return AgeFragment.newInstance();
            case 3:
                return DisabledFragment.newInstance();
            case 4:
                return DisabledDetailFragment.newInstance();
            case 5:
                return WelcomeFragment.newInstance();
            default:
                return null;
        }
    }

    @Override
    public int getCount() { return 6; }
}
