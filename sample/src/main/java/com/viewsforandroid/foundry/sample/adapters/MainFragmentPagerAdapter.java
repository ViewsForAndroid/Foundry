package com.viewsforandroid.foundry.sample.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import com.viewsforandroid.foundry.sample.ui.app.AnimatedLogoFragment;
import com.viewsforandroid.foundry.sample.ui.app.FoundryFragment;

public class MainFragmentPagerAdapter extends FragmentStatePagerAdapter {

    public MainFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new AnimatedLogoFragment();
            default:
                return new FoundryFragment();
        }
    }

    @Override
    public int getCount() {
        return 10;
    }

}