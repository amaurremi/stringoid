package com.everimaging.fotor.discovery;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.LayoutParams;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.everimaging.fotor.b;
import com.everimaging.fotor.log.LoggerFactory;
import com.everimaging.fotor.log.LoggerFactory.LoggerType;
import com.everimaging.fotor.log.LoggerFactory.c;
import com.everimaging.fotorsdk.widget.FotorTitleBackButton;
import com.everimaging.fotorsdk.widget.lib.viewpagerindicator.TabPageIndicator;

import java.util.ArrayList;
import java.util.List;

public class DiscoveryActivity
        extends b {
    private static final String a = DiscoveryActivity.class.getSimpleName();
    private static final LoggerFactory.c b = LoggerFactory.a(a, LoggerFactory.LoggerType.CONSOLE);
    private TabPageIndicator c;
    private ViewPager d;
    private a e;
    private DiscoveryInspirationFragment f;
    private DiscoveryNewsFragment g;
    private DiscoverySuggestionFragment h;
    private int i = 0;

    private Fragment a(Bundle paramBundle, int paramInt) {
        if (paramBundle == null) {
            return this.e.getItem(paramInt);
        }
        return getSupportFragmentManager().findFragmentByTag(a(paramInt));
    }

    private String a(int paramInt) {
        return "android:switcher:2131558573:" + paramInt;
    }

    private void a(Intent paramIntent) {
        if (paramIntent != null) {
            this.i = paramIntent.getIntExtra("extra_init_index", 0);
        }
    }

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        a(getIntent());
        setContentView(2130903093);
        final ActionBar localActionBar = getSupportActionBar();
        localActionBar.setNavigationMode(0);
        localActionBar.setDisplayShowCustomEnabled(true);
        localActionBar.setDisplayShowHomeEnabled(false);
        localActionBar.setDisplayShowTitleEnabled(false);
        Object localObject = new FotorTitleBackButton(this);
        ((FotorTitleBackButton) localObject).setText(getString(2131296538));
        LinearLayout localLinearLayout = new LinearLayout(this);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
        localLayoutParams.leftMargin = getResources().getDimensionPixelOffset(2131165196);
        localLinearLayout.addView((View) localObject, localLayoutParams);
        localActionBar.setCustomView(localLinearLayout, new ActionBar.LayoutParams(-2, -2, 19));
        ((FotorTitleBackButton) localObject).setOnClickListener(new View.OnClickListener() {
            public void onClick(View paramAnonymousView) {
                DiscoveryActivity.this.finish();
            }
        });
        this.c = ((TabPageIndicator) findViewById(2131558572));
        this.d = ((ViewPager) findViewById(2131558573));
        localObject = new ArrayList();
        b.c(new Object[]{"savedInstanceState:" + paramBundle});
        if (paramBundle == null) {
            this.f = new DiscoveryInspirationFragment();
            ((List) localObject).add(this.f);
            this.g = new DiscoveryNewsFragment();
            ((List) localObject).add(this.g);
            this.h = new DiscoverySuggestionFragment();
            ((List) localObject).add(this.h);
        }
        for (; ; ) {
            this.e = new a(getSupportFragmentManager(), (List) localObject);
            this.d.setAdapter(this.e);
            this.d.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
                public void onPageSelected(int paramAnonymousInt) {
                    localActionBar.setSelectedNavigationItem(paramAnonymousInt);
                }
            });
            this.c.setViewPager(this.d);
            this.d.setCurrentItem(this.i);
            return;
            this.f = ((DiscoveryInspirationFragment) a(paramBundle, 0));
            if (this.f == null) {
                this.f = new DiscoveryInspirationFragment();
            }
            ((List) localObject).add(this.f);
            this.g = ((DiscoveryNewsFragment) a(paramBundle, 1));
            if (this.g == null) {
                this.g = new DiscoveryNewsFragment();
            }
            ((List) localObject).add(this.g);
            this.h = ((DiscoverySuggestionFragment) a(paramBundle, 2));
            if (this.h == null) {
                this.h = new DiscoverySuggestionFragment();
            }
            ((List) localObject).add(this.h);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected void onStart() {
        super.onStart();
    }

    protected void onStop() {
        super.onStop();
    }

    public class a
            extends FragmentPagerAdapter {
        private List<Fragment> b;

        public a(List<Fragment> paramList) {
            super();
            List localList;
            this.b = localList;
        }

        public int getCount() {
            return this.b.size();
        }

        public Fragment getItem(int paramInt) {
            return (Fragment) this.b.get(paramInt);
        }

        public CharSequence getPageTitle(int paramInt) {
            switch (paramInt) {
                default:
                    return null;
                case 0:
                    return DiscoveryActivity.this.getString(2131296539);
                case 1:
                    return DiscoveryActivity.this.getString(2131296540);
            }
            return DiscoveryActivity.this.getString(2131296541);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotor/discovery/DiscoveryActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */