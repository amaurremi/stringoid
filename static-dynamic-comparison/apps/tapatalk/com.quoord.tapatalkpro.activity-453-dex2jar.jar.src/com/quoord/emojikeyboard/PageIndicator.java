package com.quoord.emojikeyboard;

import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;

public abstract interface PageIndicator
        extends ViewPager.OnPageChangeListener {
    public abstract void notifyDataSetChanged();

    public abstract void setCurrentItem(int paramInt);

    public abstract void setOnPageChangeListener(ViewPager.OnPageChangeListener paramOnPageChangeListener);

    public abstract void setViewPager(ViewPager paramViewPager);

    public abstract void setViewPager(ViewPager paramViewPager, int paramInt);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/emojikeyboard/PageIndicator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */