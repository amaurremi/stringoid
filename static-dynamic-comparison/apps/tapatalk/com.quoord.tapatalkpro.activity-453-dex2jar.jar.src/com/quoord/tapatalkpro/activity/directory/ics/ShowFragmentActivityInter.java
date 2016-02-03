package com.quoord.tapatalkpro.activity.directory.ics;

import android.support.v4.app.Fragment;
import com.quoord.tapatalkpro.ui.ics.QuoordFragment;

public abstract interface ShowFragmentActivityInter {
    public static final int MenuStyle_category = 3;
    public static final int MenuStyle_fav = 4;
    public static final int MenuStyle_favIndex = 5;
    public static final int MenuStyle_feed = 7;
    public static final int MenuStyle_searchResult = 6;
    public static final int MenuStyle_subcategry = 1;
    public static final int MenuStyle_welcome = 2;
    public static final String defaultTitleString = "defaultTitleString";

    public abstract void actionBar4Display();

    public abstract void actionBar4Hide();

    public abstract void actionBar4ShowTitle(String paramString);

    public abstract void addFragmentToStack(Fragment paramFragment);

    public abstract void addFragmentToStack(QuoordFragment paramQuoordFragment);

    public abstract void reDrawActionBar(int paramInt);

    public abstract void showToFront(Fragment paramFragment);

    public abstract void showToFront(QuoordFragment paramQuoordFragment);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/activity/directory/ics/ShowFragmentActivityInter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */