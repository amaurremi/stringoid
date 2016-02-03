package com.quoord.tapatalkpro.activity.forum;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.ViewGroup;
import com.quoord.tapatalkpro.bean.TopicController;

import java.util.HashMap;

public class ThreadPagerAdapter
        extends FragmentStatePagerAdapter {
    private Activity mContext;
    public HashMap<Integer, ThreadFragment> mPageReferenceMap = new HashMap();
    private TopicController topicController;

    public ThreadPagerAdapter(FragmentManager paramFragmentManager, TopicController paramTopicController) {
        super(paramFragmentManager);
        this.topicController = paramTopicController;
    }

    public void destroyFragment(ViewPager paramViewPager, int paramInt) {
        destroyItem(paramViewPager, paramInt, this.mPageReferenceMap.get(Integer.valueOf(paramInt)));
        notifyDataSetChanged();
    }

    public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject) {
        if ((paramInt < getCount()) && (paramInt != 0) && (paramInt != 1)) {
            this.mPageReferenceMap.remove(Integer.valueOf(paramInt));
            super.destroyItem(paramViewGroup, paramInt, paramObject);
        }
    }

    public int getCount() {
        if (this.topicController != null) {
            return this.topicController.getPageNum();
        }
        return 0;
    }

    public ThreadFragment getFragment(int paramInt) {
        return (ThreadFragment) this.mPageReferenceMap.get(Integer.valueOf(paramInt));
    }

    public Fragment getItem(int paramInt) {
        if (this.mPageReferenceMap.containsKey(Integer.valueOf(paramInt))) {
            return (Fragment) this.mPageReferenceMap.get(Integer.valueOf(paramInt));
        }
        ThreadFragment localThreadFragment = ThreadFragment.newInstance(paramInt, false);
        this.mPageReferenceMap.put(Integer.valueOf(paramInt), localThreadFragment);
        return localThreadFragment;
    }

    public TopicController getTopicController() {
        return this.topicController;
    }

    public void setTopicController(TopicController paramTopicController) {
        this.topicController = paramTopicController;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/activity/forum/ThreadPagerAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */