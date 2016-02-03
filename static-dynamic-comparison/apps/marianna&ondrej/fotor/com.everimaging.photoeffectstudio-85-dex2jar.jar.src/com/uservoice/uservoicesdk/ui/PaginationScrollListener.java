package com.uservoice.uservoicesdk.ui;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

public class PaginationScrollListener
        implements AbsListView.OnScrollListener {
    private final PaginatedAdapter<?> adapter;

    public PaginationScrollListener(PaginatedAdapter<?> paramPaginatedAdapter) {
        this.adapter = paramPaginatedAdapter;
    }

    public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {
        if (paramInt1 + paramInt2 >= paramInt3) {
            this.adapter.loadMore();
        }
    }

    public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/uservoice/uservoicesdk/ui/PaginationScrollListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */