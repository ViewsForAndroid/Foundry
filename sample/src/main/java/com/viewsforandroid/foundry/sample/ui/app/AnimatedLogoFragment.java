package com.viewsforandroid.foundry.sample.ui.app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.viewsforandroid.foundry.sample.R;
import com.viewsforandroid.foundry.sample.ui.widget.AnimatedLogoView;

public class AnimatedLogoFragment extends Fragment {

    private View mRootView;
    private Runnable mOnFillStartedCallback;
    private View mSubtitleView;
    private AnimatedLogoView mLogoView;
    private float mInitialLogoOffset;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mInitialLogoOffset = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 16, getResources().getDisplayMetrics());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_animated_logo, container, false);
        //mSubtitleView = mRootView.findViewById(R.id.logo_subtitle);

        mLogoView = (AnimatedLogoView) mRootView.findViewById(R.id.animated_logo);
        mLogoView.setOnStateChangeListener(new AnimatedLogoView.OnStateChangeListener() {
            @Override
            public void onStateChange(int state) {
                if (state == AnimatedLogoView.STATE_FILL_STARTED) {
//                    mSubtitleView.setAlpha(0);
//                    mSubtitleView.setVisibility(View.VISIBLE);
//                    mSubtitleView.setTranslationY(-mSubtitleView.getHeight());
//
//                    // Bug in older versions where set.setInterpolator didn't work
//                    AnimatorSet set = new AnimatorSet();
//                    Interpolator interpolator = new OvershootInterpolator();
//                    ObjectAnimator a1 = ObjectAnimator.ofFloat(mLogoView, View.TRANSLATION_Y, 0);
//                    ObjectAnimator a2 = ObjectAnimator.ofFloat(mSubtitleView, View.TRANSLATION_Y, 0);
//                    ObjectAnimator a3 = ObjectAnimator.ofFloat(mSubtitleView, View.ALPHA, 1);
//                    a1.setInterpolator(interpolator);
//                    a2.setInterpolator(interpolator);
//                    set.setDuration(500).playTogether(a1, a2, a3);
//                    set.start();
//
                    if (mOnFillStartedCallback != null) {
                        mOnFillStartedCallback.run();
                    }
                }
            }
        });
        reset();
        return mRootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        start();
    }

    public void start() {
        mLogoView.start();
    }

    public void setOnFillStartedCallback(Runnable fillStartedCallback) {
        mOnFillStartedCallback = fillStartedCallback;
    }

    public void reset() {
        mLogoView.reset();
        mLogoView.setTranslationY(mInitialLogoOffset);
        //mSubtitleView.setVisibility(View.INVISIBLE);
    }

}
