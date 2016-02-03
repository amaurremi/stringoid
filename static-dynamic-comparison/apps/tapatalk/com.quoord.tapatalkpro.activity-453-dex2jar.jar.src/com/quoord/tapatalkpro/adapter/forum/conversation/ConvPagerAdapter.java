package com.quoord.tapatalkpro.adapter.forum.conversation;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;
import com.quoord.tapatalkpro.activity.forum.conversation.TabConvDetailFragment;

import java.util.HashMap;

public class ConvPagerAdapter
        extends FragmentStatePagerAdapter {
    private ConvController convController;
    public HashMap<Integer, TabConvDetailFragment> mPageReferenceConvMap = new HashMap();

    public ConvPagerAdapter(FragmentManager paramFragmentManager, ConvController paramConvController) {
        super(paramFragmentManager);
        this.convController = paramConvController;
    }

    public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject) {
        super.destroyItem(paramViewGroup, paramInt, paramObject);
    }

    public int getCount() {
        if (this.convController != null) {
            return this.convController.getPageNum();
        }
        return 0;
    }

    public Fragment getItem(int paramInt) {
        if (this.mPageReferenceConvMap.containsKey(Integer.valueOf(paramInt))) {
            return (Fragment) this.mPageReferenceConvMap.get(Integer.valueOf(paramInt));
        }
        TabConvDetailFragment localTabConvDetailFragment = TabConvDetailFragment.newInstance(paramInt, false);
        this.mPageReferenceConvMap.put(Integer.valueOf(paramInt), localTabConvDetailFragment);
        return localTabConvDetailFragment;
    }

    public ConvController getTopicController() {
        return this.convController;
    }

    public void setTopicController(ConvController paramConvController) {
        this.convController = paramConvController;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/adapter/forum/conversation/ConvPagerAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */