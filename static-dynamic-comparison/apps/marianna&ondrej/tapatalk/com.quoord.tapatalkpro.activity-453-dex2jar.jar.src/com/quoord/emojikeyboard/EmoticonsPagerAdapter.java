package com.quoord.emojikeyboard;

import android.app.Activity;
import android.content.res.Resources;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridView;
import com.quoord.tapatalkpro.activity.forum.CreateTopicActivity;
import com.quoord.tapatalkpro.ics.slidingMenu.SettingsFragment;

import java.util.ArrayList;

public class EmoticonsPagerAdapter
        extends PagerAdapter
        implements IconPagerAdapter {
    protected static final int[] ICONS_SMS = {2130839362};
    protected static final int[] ICONS_WA = {2130839358, 2130839362, 2130839366, 2130839370, 2130839374, 2130839378};
    private String[] emosArray;
    private int emosPerPage;
    private int initialPosition;
    Activity mActivity;
    EmoticonsGridAdapter.KeyClickListener mListener;
    private int mService;

    public EmoticonsPagerAdapter(Activity paramActivity, EmoticonsGridAdapter.KeyClickListener paramKeyClickListener, int paramInt) {
        this.mActivity = paramActivity;
        this.mListener = paramKeyClickListener;
        this.mService = paramInt;
    }

    public void destroyItem(View paramView, int paramInt, Object paramObject) {
        ((ViewPager) paramView).removeView((View) paramObject);
    }

    public int getCount() {
        switch (this.mService) {
            default:
                return 0;
            case 1:
                return 1;
        }
        return 6;
    }

    public int getIconResId(int paramInt) {
        switch (this.mService) {
            case 1:
            default:
                return 0;
        }
        return ICONS_WA[(paramInt % ICONS_WA.length)];
    }

    public Object instantiateItem(View paramView, int paramInt) {
        View localView;
        label52:
        ArrayList localArrayList2;
        int i;
        if (SettingsFragment.isLightTheme(this.mActivity)) {
            localView = this.mActivity.getLayoutInflater().inflate(2130903132, null);
            switch (this.mService) {
                default:
                    localArrayList2 = new ArrayList();
                    i = this.initialPosition;
            }
        }
        for (; ; ) {
            if ((i >= this.initialPosition + this.emosPerPage) || (i >= this.emosArray.length)) {
                ArrayList localArrayList1 = localArrayList2;
                if (this.mService == 2) {
                    localArrayList1 = localArrayList2;
                    if (paramInt == 0) {
                        localArrayList1 = CreateTopicActivity.getRecentEmoticons();
                    }
                }
                ((GridView) localView.findViewById(2131230996)).setAdapter(new EmoticonsGridAdapter(this.mActivity.getApplicationContext(), localArrayList1, paramInt, this.mListener));
                ((ViewPager) paramView).addView(localView);
                return localView;
                localView = this.mActivity.getLayoutInflater().inflate(2130903133, null);
                break;
                this.initialPosition = 0;
                this.emosPerPage = 21;
                this.emosArray = this.mActivity.getResources().getStringArray(2131492890);
                break label52;
                switch (paramInt) {
                }
                for (; ; ) {
                    this.emosArray = this.mActivity.getResources().getStringArray(2131492889);
                    break;
                    this.initialPosition = 0;
                    this.emosPerPage = 32;
                    continue;
                    this.initialPosition = 0;
                    this.emosPerPage = 189;
                    continue;
                    this.initialPosition = 189;
                    this.emosPerPage = 116;
                    continue;
                    this.initialPosition = 305;
                    this.emosPerPage = 230;
                    continue;
                    this.initialPosition = 535;
                    this.emosPerPage = 101;
                    continue;
                    this.initialPosition = 636;
                    this.emosPerPage = 209;
                }
            }
            localArrayList2.add(this.emosArray[i]);
            i += 1;
        }
    }

    public boolean isViewFromObject(View paramView, Object paramObject) {
        return paramView == paramObject;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/emojikeyboard/EmoticonsPagerAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */