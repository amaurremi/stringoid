package com.quoord.tapatalkpro.adapter.forum;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import com.quoord.tapatalkpro.activity.GalleryActivity;
import com.quoord.tapatalkpro.util.NewFragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class GalleryPagerAdaper
        extends NewFragmentStatePagerAdapter {
    private GalleryActivity activity;
    HashMap<Integer, GalleryItemFragment> mPageReferenceMap = new HashMap();

    public GalleryPagerAdaper(FragmentManager paramFragmentManager, GalleryActivity paramGalleryActivity) {
        super(paramFragmentManager, paramGalleryActivity);
        this.activity = paramGalleryActivity;
    }

    public int getCount() {
        if ((this.activity == null) || (this.activity.pData == null) || (this.activity.pData.size() == 0)) {
            return 0;
        }
        return this.activity.pData.size();
    }

    public Fragment getItem(int paramInt) {
        GalleryItemFragment localGalleryItemFragment = GalleryItemFragment.newInstance(paramInt, (String) this.activity.pData.get(paramInt));
        this.mPageReferenceMap.put(Integer.valueOf(paramInt), localGalleryItemFragment);
        return localGalleryItemFragment;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/adapter/forum/GalleryPagerAdaper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */