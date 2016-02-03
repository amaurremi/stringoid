package com.quoord.tapatalkpro.util;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TabHost;
import android.widget.TabHost.TabContentFactory;
import android.widget.TabHost.TabSpec;
import android.widget.TabWidget;
import com.quoord.tapatalkpro.ics.slidingMenu.SettingsFragment;

public class TabsUtil4 {
    public static int getTabCount(TabHost paramTabHost) {
        return paramTabHost.getTabWidget().getTabCount();
    }

    public static void initialTab(TabHost paramTabHost, Activity paramActivity, int paramInt, Intent paramIntent) {
        TabHost.TabSpec localTabSpec = paramTabHost.newTabSpec(paramActivity.getResources().getString(paramInt));
        setTabIndicator(localTabSpec, Util.prepareTabView(paramActivity.getResources().getString(paramInt), paramActivity, SettingsFragment.isLightTheme(paramActivity)));
        localTabSpec.setContent(paramIntent);
        paramTabHost.addTab(localTabSpec);
    }

    public static void initialTab(TabHost paramTabHost, Activity paramActivity, int paramInt, RelativeLayout paramRelativeLayout) {
        TabHost.TabSpec localTabSpec = paramTabHost.newTabSpec(paramActivity.getResources().getString(paramInt));
        setTabIndicator(localTabSpec, Util.prepareTabView(paramActivity.getResources().getString(paramInt), paramActivity, SettingsFragment.isLightTheme(paramActivity)));
        localTabSpec.setContent(new TabHost.TabContentFactory() {
            public View createTabContent(String paramAnonymousString) {
                return TabsUtil4.this;
            }
        });
        paramTabHost.addTab(localTabSpec);
    }

    public static void setTabIndicator(TabHost.TabSpec paramTabSpec, View paramView) {
        paramTabSpec.setIndicator(paramView);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/util/TabsUtil4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */