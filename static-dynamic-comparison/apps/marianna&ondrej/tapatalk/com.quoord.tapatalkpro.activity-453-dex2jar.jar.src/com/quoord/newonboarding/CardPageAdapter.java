package com.quoord.newonboarding;

import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class CardPageAdapter
        extends FragmentStatePagerAdapter
        implements ViewPager.OnPageChangeListener, View.OnTouchListener {
    private ArrayList<Fragment> cardFragments = new ArrayList();
    private Handler changeBghandler = new Handler();
    public int currentPosition = 0;
    private boolean isTouch = false;
    private Field mField;
    private FixedSpeedScroller mScroller;
    private ObWelcomeFragment obWelcomeFragment;
    private int[] pointImageIdArray = {2130839193, 2130839194, 2130839195, 2130839196};
    private ImageView pointView;
    int position = 0;
    private Runnable runnable = new Runnable() {
        public void run() {
            if (CardPageAdapter.this.viewPager != null) {
                CardPageAdapter.this.viewPager.setCurrentItem(CardPageAdapter.this.currentPosition);
            }
        }
    };
    private ViewPager viewPager;

    public CardPageAdapter(ObWelcomeFragment paramObWelcomeFragment, FragmentActivity paramFragmentActivity, ViewPager paramViewPager, ImageView paramImageView, ArrayList<Fragment> paramArrayList) {
        super(paramFragmentActivity.getSupportFragmentManager());
        this.viewPager = paramViewPager;
        this.pointView = paramImageView;
        this.obWelcomeFragment = paramObWelcomeFragment;
        this.cardFragments = paramArrayList;
        paramViewPager.setAdapter(this);
        paramViewPager.setOffscreenPageLimit(4);
        paramViewPager.setOnTouchListener(this);
        paramViewPager.setOnPageChangeListener(this);
        this.currentPosition = 0;
        try {
            this.mField = ViewPager.class.getDeclaredField("mScroller");
            this.mField.setAccessible(true);
            this.mScroller = new FixedSpeedScroller(paramObWelcomeFragment.getActivity(), new AccelerateInterpolator());
            this.mField.set(paramViewPager, this.mScroller);
            startTimer();
            return;
        } catch (Exception paramObWelcomeFragment) {
            for (; ; ) {
                paramObWelcomeFragment.printStackTrace();
            }
        }
    }

    public int getCount() {
        return this.cardFragments.size();
    }

    public Fragment getItem(int paramInt) {
        return (Fragment) this.cardFragments.get(paramInt);
    }

    public Object instantiateItem(ViewGroup paramViewGroup, int paramInt) {
        paramViewGroup = (Fragment) super.instantiateItem(paramViewGroup, paramInt);
        if ((paramViewGroup != null) && (!this.cardFragments.contains(paramViewGroup)) && (paramInt < this.cardFragments.size())) {
            this.cardFragments.remove(paramInt);
            this.cardFragments.add(paramInt, paramViewGroup);
        }
        return paramViewGroup;
    }

    public void onPageScrollStateChanged(int paramInt) {
        if (paramInt == 1) {
            stopTimer();
        }
    }

    public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {
        if ((paramInt1 == 0) && (this.obWelcomeFragment != null)) {
            this.obWelcomeFragment.obWelcomebg3.setVisibility(8);
            this.obWelcomeFragment.obWelcomebg4.setVisibility(8);
            this.obWelcomeFragment.obWelcomebg1.setVisibility(0);
            this.obWelcomeFragment.obWelcomebg2.setVisibility(0);
            this.obWelcomeFragment.obWelcomebg1.setAlpha(1.0F - paramFloat);
        }
        if ((paramInt1 == 1) && (this.obWelcomeFragment != null)) {
            this.obWelcomeFragment.obWelcomebg2.setVisibility(0);
            this.obWelcomeFragment.obWelcomebg3.setVisibility(0);
            this.obWelcomeFragment.obWelcomebg1.setVisibility(8);
            this.obWelcomeFragment.obWelcomebg4.setVisibility(8);
            this.obWelcomeFragment.obWelcomebg2.setAlpha(1.0F - paramFloat);
        }
        if ((paramInt1 == 2) && (this.obWelcomeFragment != null)) {
            this.obWelcomeFragment.obWelcomebg3.setVisibility(0);
            this.obWelcomeFragment.obWelcomebg4.setVisibility(0);
            this.obWelcomeFragment.obWelcomebg1.setVisibility(8);
            this.obWelcomeFragment.obWelcomebg2.setVisibility(8);
            this.obWelcomeFragment.obWelcomebg3.setAlpha(1.0F - paramFloat);
        }
        if (paramInt1 == 3) {
            this.viewPager.setCurrentItem(3);
        }
    }

    public void onPageSelected(int paramInt) {
        stopTimer();
        this.position = paramInt;
        if (this.position == 4) {
            this.viewPager.setCurrentItem(3);
            this.position = 3;
        }
        new Handler().postDelayed(new Runnable() {
            public void run() {
                CardPageAdapter.this.pointView.setBackgroundResource(CardPageAdapter.this.pointImageIdArray[CardPageAdapter.this.position]);
            }
        }, 200L);
        this.currentPosition = paramInt;
        if (!this.isTouch) {
            startTimer();
        }
    }

    public boolean onTouch(View paramView, MotionEvent paramMotionEvent) {
        this.mField.setAccessible(false);
        this.isTouch = true;
        return false;
    }

    public void startTimer() {
        this.mScroller.setmDuration(300);
        this.currentPosition += 1;
        if (this.currentPosition == 4) {
            this.currentPosition = 0;
        }
        this.changeBghandler.postDelayed(this.runnable, 3500L);
    }

    public void stopTimer() {
        this.changeBghandler.removeCallbacks(this.runnable);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/newonboarding/CardPageAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */