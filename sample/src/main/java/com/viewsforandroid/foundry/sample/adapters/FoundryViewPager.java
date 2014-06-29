package com.viewsforandroid.foundry.sample.adapters;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;

public class FoundryViewPager extends ViewPager {

    public FoundryViewPager(Context context) {
        super(context);
    }

    public FoundryViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        setPageTransformer(true, new FoundryPageTransformer());
    }

    public static class FoundryPageTransformer implements ViewPager.PageTransformer {

        private final float scalingStart = 0.3f;

        public FoundryPageTransformer() {
            super();
        }

        @Override
        public void transformPage(View page, float position) {
            if (position >= 0) {
                final int w = page.getWidth();
                float scaleFactor = 1 - scalingStart * position;

                page.setAlpha(1 - position);
                page.setScaleX(scaleFactor);
                page.setScaleY(scaleFactor);
                page.setTranslationX(w * (1 - position) - w);
            }
        }

    }

}
