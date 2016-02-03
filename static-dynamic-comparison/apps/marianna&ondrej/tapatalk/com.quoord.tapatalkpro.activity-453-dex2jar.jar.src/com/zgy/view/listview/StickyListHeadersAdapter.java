package com.zgy.view.listview;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;

public abstract interface StickyListHeadersAdapter
        extends ListAdapter {
    public abstract long getHeaderId(int paramInt);

    public abstract View getHeaderView(int paramInt, View paramView, ViewGroup paramViewGroup);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/zgy/view/listview/StickyListHeadersAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */