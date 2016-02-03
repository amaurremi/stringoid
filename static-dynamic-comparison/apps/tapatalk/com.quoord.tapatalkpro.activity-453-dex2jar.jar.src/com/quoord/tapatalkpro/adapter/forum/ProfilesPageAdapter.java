package com.quoord.tapatalkpro.adapter.forum;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabContentFactory;
import android.widget.TabHost.TabSpec;
import android.widget.TabWidget;
import com.quoord.tapatalkpro.activity.forum.ProfilesFragment;
import com.quoord.tapatalkpro.activity.forum.RepliesFragment;
import com.quoord.tapatalkpro.activity.forum.StartPostFragment;
import com.quoord.tapatalkpro.ics.slidingMenu.SettingsFragment;
import com.quoord.tapatalkpro.util.TabsUtil4;
import com.quoord.tapatalkpro.util.Util;

import java.util.ArrayList;

public class ProfilesPageAdapter
        extends FragmentStatePagerAdapter
        implements TabHost.OnTabChangeListener, ViewPager.OnPageChangeListener {
    private int bmpW;
    private int currIndex = 0;
    ImageView imageView;
    private final Context mContext;
    private final TabHost mTabHost;
    private final ArrayList<TabInfo> mTabs = new ArrayList();
    private final ViewPager mViewPager;
    private int offset = 0;
    public ProfilesFragment profilesFragment;
    public RepliesFragment repliesFragment;
    public StartPostFragment startPostFragment;
    private String userId;
    private String username;

    public ProfilesPageAdapter(FragmentActivity paramFragmentActivity, TabHost paramTabHost, ViewPager paramViewPager, String paramString1, String paramString2) {
        super(paramFragmentActivity.getSupportFragmentManager());
        this.mContext = paramFragmentActivity;
        this.mTabHost = paramTabHost;
        this.mViewPager = paramViewPager;
        this.username = paramString1;
        this.userId = paramString2;
        this.mTabHost.setOnTabChangedListener(this);
        this.mViewPager.setAdapter(this);
        this.mViewPager.setOnPageChangeListener(this);
    }

    private void InitImageView() {
        this.bmpW = BitmapFactory.decodeResource(this.mContext.getResources(), 2130839382).getWidth();
        Object localObject = new DisplayMetrics();
        ((Activity) this.mContext).getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics) localObject);
        this.offset = ((((DisplayMetrics) localObject).widthPixels / 3 - this.bmpW) / 2);
        localObject = new Matrix();
        ((Matrix) localObject).postTranslate(this.offset, 0.0F);
        this.imageView.setImageMatrix((Matrix) localObject);
    }

    public void addTab(TabHost.TabSpec paramTabSpec, Fragment paramFragment, Bundle paramBundle) {
        paramTabSpec.setContent(new DummyTabFactory(this.mContext));
        View localView = Util.prepareTabView(paramTabSpec.getTag(), (Activity) this.mContext, SettingsFragment.isLightTheme(this.mContext));
        TabsUtil4.setTabIndicator(paramTabSpec, localView);
        this.imageView = ((ImageView) localView.findViewById(2131231713));
        InitImageView();
        paramFragment = new TabInfo(paramTabSpec.getTag(), paramFragment, paramBundle);
        this.mTabs.add(paramFragment);
        this.mTabHost.addTab(paramTabSpec);
        notifyDataSetChanged();
    }

    public int getCount() {
        return this.mTabs.size();
    }

    public Fragment getItem(int paramInt) {
        TabInfo localTabInfo = (TabInfo) this.mTabs.get(paramInt);
        switch (paramInt) {
            default:
                return null;
            case 0:
                this.profilesFragment = ((ProfilesFragment) localTabInfo.clss);
                if (this.profilesFragment == null) {
                    this.profilesFragment = ProfilesFragment.newInstance(this.username, this.userId);
                }
                return this.profilesFragment;
            case 1:
                this.startPostFragment = ((StartPostFragment) localTabInfo.clss);
                if (this.startPostFragment == null) {
                    this.startPostFragment = StartPostFragment.newInstance();
                }
                return this.startPostFragment;
        }
        this.repliesFragment = ((RepliesFragment) localTabInfo.clss);
        if (this.repliesFragment == null) {
            this.repliesFragment = RepliesFragment.newInstance();
        }
        return this.repliesFragment;
    }

    public void onPageScrollStateChanged(int paramInt) {
    }

    public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {
    }

    public void onPageSelected(int paramInt) {
        try {
            TabWidget localTabWidget = this.mTabHost.getTabWidget();
            int i = localTabWidget.getDescendantFocusability();
            localTabWidget.setDescendantFocusability(393216);
            this.mTabHost.setCurrentTab(paramInt);
            this.mViewPager.setOffscreenPageLimit(2);
            localTabWidget.setDescendantFocusability(i);
            if ((paramInt == 1) && (this.startPostFragment != null) && (this.startPostFragment.startPostAdapter == null)) {
                this.startPostFragment.refresh();
            }
            return;
        } catch (Exception localException) {
            localException.printStackTrace();
        }
    }

    public void onTabChanged(String paramString) {
        int i = this.mTabHost.getCurrentTab();
        this.mViewPager.setCurrentItem(i);
    }

    static class DummyTabFactory
            implements TabHost.TabContentFactory {
        private final Context mContext;

        public DummyTabFactory(Context paramContext) {
            this.mContext = paramContext;
        }

        public View createTabContent(String paramString) {
            paramString = new View(this.mContext);
            paramString.setMinimumWidth(0);
            paramString.setMinimumHeight(0);
            return paramString;
        }
    }

    static final class TabInfo {
        private final Bundle args;
        private final Fragment clss;
        private final String tag;

        TabInfo(String paramString, Fragment paramFragment, Bundle paramBundle) {
            this.tag = paramString;
            this.clss = paramFragment;
            this.args = paramBundle;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/adapter/forum/ProfilesPageAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */