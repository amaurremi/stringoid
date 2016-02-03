package com.quoord.tapatalkpro.view;

import android.app.Activity;
import android.content.res.Resources;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.quoord.tapatalkpro.ics.slidingMenu.SettingsFragment;
import com.quoord.tapatalkpro.util.ThemeUtil;

public class CustomPagerIndicator {
    private View bottomLine;
    private int currentIndex = 0;
    private View indicator;
    private Activity mActivity;
    private int pageCount = -1;
    private int textColor = -1;
    private int textSelectedColor = -1;
    private ViewPager viewPager;

    public CustomPagerIndicator(Activity paramActivity) {
        this.mActivity = paramActivity;
    }

    private void checkColor() {
        this.textColor = this.mActivity.getResources().getColor(2131165283);
        this.textSelectedColor = this.mActivity.getResources().getColor(2131165213);
    }

    private void initPageCount() {
        this.pageCount = ((ViewGroup) this.indicator).getChildCount();
    }

    private void setIndicatorBack() {
        if (!SettingsFragment.isLightTheme(this.mActivity)) {
            this.indicator.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("favforum_item2_color", this.mActivity));
        }
    }

    public void changePageTo(int paramInt) {
        if (this.pageCount <= 0) {
            initPageCount();
        }
        checkColor();
        int i = 0;
        if (i >= this.pageCount) {
            return;
        }
        BottomDrawableTextView localBottomDrawableTextView = (BottomDrawableTextView) ((ViewGroup) this.indicator).getChildAt(i);
        if (i == paramInt) {
            localBottomDrawableTextView.changeTextColor(this.textSelectedColor);
        }
        for (; ; ) {
            i += 1;
            break;
            localBottomDrawableTextView.changeTextColor(this.textColor);
        }
    }

    public void diaplayIndicator() {
        if ((this.indicator != null) && (this.bottomLine != null)) {
            this.indicator.setVisibility(0);
            this.bottomLine.setVisibility(0);
            return;
        }
        hideIndicator();
    }

    public ImageView getSlidingImage() {
        return (ImageView) ((ViewGroup) this.bottomLine).getChildAt(0);
    }

    public void hideIndicator() {
        if (this.indicator != null) {
            this.indicator.setVisibility(8);
        }
        if (this.bottomLine != null) {
            this.bottomLine.setVisibility(8);
        }
    }

    public boolean isIndicatorNull() {
        return (this.indicator != null) || (this.bottomLine != null);
    }

    public void setIndicator(View paramView1, View paramView2) {
        this.indicator = paramView1;
        this.bottomLine = paramView2;
        initPageCount();
        setIndicatorBack();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/view/CustomPagerIndicator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */