package com.uhackathon.momo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.uhackathon.momo.R;
import com.uhackathon.momo.ui.main.CommunityFragment;
import com.uhackathon.momo.ui.main.MainActivity;
import com.uhackathon.momo.ui.main.MapFragment;
import com.uhackathon.momo.ui.main.RewardFragment;
import com.uhackathon.momo.ui.main.SettingsFragment;
import com.uhackathon.momo.ui.main.ShopFragment;

public class FragmentAdapter_ForMain extends FragmentPagerAdapter {

    public static int PAGE_POSITION = 4;
    private Context context;

    private String tabTitles[] = new String[] { "지도", "빛", "소금", "마이" };
    private int[] imageResId = { R.drawable.icon_map, R.drawable.icon_light, R.drawable.icon_salt, R.drawable.icon_my };

    public FragmentAdapter_ForMain(@NonNull FragmentManager fm, int behavior, Context c) {
        super(fm, behavior);
        context = c;

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            //1번째 탭
            case 0:
                return MapFragment.newInstance();
            //2번째 탭
            case 1:
                return CommunityFragment.newInstance();
            //3번째 탭
            case 2:
                return RewardFragment.newInstance();
            //4번째 탭
            case 3:
                return SettingsFragment.newInstance();
            default:
                return null;
        }
    }

    @Override
    public int getCount() { return 4; }

    public View getTabView(int position) {
        // Given you have a custom layout in `res/layout/custom_tab.xml` with a TextView and ImageView
        View v = LayoutInflater.from(context).inflate(R.layout.item_custom_tab, null);
        TextView tv = (TextView) v.findViewById(R.id.textView);
        tv.setText(tabTitles[position]);
        ImageView img = (ImageView) v.findViewById(R.id.imgView);
        img.setImageResource(imageResId[position]);
        return v;
    }
}
