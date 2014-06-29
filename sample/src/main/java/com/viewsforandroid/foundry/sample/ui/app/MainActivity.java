package com.viewsforandroid.foundry.sample.ui.app;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.viewsforandroid.foundry.sample.R;
import com.viewsforandroid.foundry.sample.adapters.FoundryViewPager;
import com.viewsforandroid.foundry.sample.adapters.MainFragmentPagerAdapter;
import com.viewsforandroid.foundry.sample.indicators.NumericPageIndicator;

public class MainActivity extends ActionBarActivity {

    @InjectView(R.id.view_pager)
    FoundryViewPager mFragmentViewPager;

    @InjectView(R.id.view_pager_indicator)
    NumericPageIndicator mPagerIndicator;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.inject(this);

        initViewPager();
    }

    public void initViewPager() {
        MainFragmentPagerAdapter adapter = new MainFragmentPagerAdapter(getSupportFragmentManager());
        mFragmentViewPager.setAdapter(adapter);

        mPagerIndicator.setViewPager(mFragmentViewPager);
    }

}
