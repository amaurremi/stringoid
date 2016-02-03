package com.quoord.tapatalkpro.favunread;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.quoord.tapatalkpro.activity.directory.ics.ExploreFragment;
import com.quoord.tapatalkpro.ui.ics.QuoordFragment;

import java.util.ArrayList;

public class FavUnreadFragment
        extends Fragment {
    private ArrayList<QuoordFragment> frags;
    private ViewPager mViewPager;
    private ForumUnreadManager unreadManager;

    private void initFragData() {
        if (this.frags == null) {
            this.frags = new ArrayList();
        }
        this.frags.clear();
        this.frags.add(new ExploreFragment());
    }

    public void onActivityCreated(Bundle paramBundle) {
        super.onActivityCreated(paramBundle);
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        paramLayoutInflater = paramLayoutInflater.inflate(2130903141, null);
        this.mViewPager = ((ViewPager) paramLayoutInflater.findViewById(2131231008));
        initFragData();
        return paramLayoutInflater;
    }

    public class SectionsPagerAdapter
            extends FragmentPagerAdapter {
        private ArrayList<QuoordFragment> fragsData;

        public SectionsPagerAdapter(ArrayList<QuoordFragment> paramArrayList) {
            super();
            ArrayList localArrayList;
            this.fragsData = localArrayList;
        }

        public int getCount() {
            return this.fragsData.size();
        }

        public Fragment getItem(int paramInt) {
            return (Fragment) this.fragsData.get(paramInt);
        }

        public CharSequence getPageTitle(int paramInt) {
            return paramInt;
        }

        public Object instantiateItem(ViewGroup paramViewGroup, int paramInt) {
            paramViewGroup = (QuoordFragment) super.instantiateItem(paramViewGroup, paramInt);
            if (!this.fragsData.contains(paramViewGroup)) {
                this.fragsData.add(paramInt, paramViewGroup);
            }
            return paramViewGroup;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/favunread/FavUnreadFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */