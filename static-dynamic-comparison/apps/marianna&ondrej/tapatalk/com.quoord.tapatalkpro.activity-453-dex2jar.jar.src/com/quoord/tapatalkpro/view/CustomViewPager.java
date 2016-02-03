package com.quoord.tapatalkpro.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;

public class CustomViewPager
        extends ViewPager {
    private float last = -1.0F;
    private int lastPage = -1;
    private onScrollListener scrollListener;

    public CustomViewPager(Context paramContext) {
        super(paramContext);
    }

    public CustomViewPager(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
    }

    protected void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {
        super.onPageScrolled(paramInt1, paramFloat, paramInt2);
        if (this.scrollListener == null) {
        }
        do {
            return;
            if (this.lastPage < 0) {
                this.lastPage = paramInt1;
            }
            this.scrollListener.onPageScrolled(paramInt1, paramFloat, paramInt2);
            if (this.last < 0.0F) {
                this.last = paramFloat;
            }
            if (paramFloat == 0.0F) {
                break;
            }
            if (this.last < paramFloat) {
                this.scrollListener.onScrollToNext(paramInt1, paramFloat, paramInt2);
            }
        } while (this.last <= paramFloat);
        this.scrollListener.onScrollToPrevious(paramInt1, paramFloat, paramInt2);
        return;
        if (this.lastPage != paramInt1) {
            this.scrollListener.onPageChanged(this.lastPage, paramInt1);
        }
        this.lastPage = -1;
    }

    public void setOnScrollListener(onScrollListener paramonScrollListener) {
        this.scrollListener = paramonScrollListener;
    }

    public static abstract interface onScrollListener {
        public abstract void onPageChanged(int paramInt1, int paramInt2);

        public abstract void onPageScrolled(int paramInt1, float paramFloat, int paramInt2);

        public abstract void onScrollToNext(int paramInt1, float paramFloat, int paramInt2);

        public abstract void onScrollToPrevious(int paramInt1, float paramFloat, int paramInt2);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/view/CustomViewPager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */