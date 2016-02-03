package com.etsy.android.grid;

import android.widget.OverScroller;

class g
        implements Runnable {
    private final OverScroller b;
    private int c;

    g(ExtendableListView paramExtendableListView) {
        this.b = new OverScroller(paramExtendableListView.getContext());
    }

    private void a() {
        this.c = 0;
        ExtendableListView.a(this.a, 0);
        this.a.j(0);
        this.a.removeCallbacks(this);
        this.b.forceFinished(true);
    }

    void a(int paramInt) {
        if (paramInt < 0) {
        }
        for (int i = Integer.MAX_VALUE; ; i = 0) {
            this.c = i;
            this.b.forceFinished(true);
            this.b.fling(0, i, 0, paramInt, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
            ExtendableListView.a(this.a, 2);
            ExtendableListView.a(this.a, this);
            return;
        }
    }

    void a(int paramInt1, int paramInt2) {
        if (paramInt1 < 0) {
        }
        for (int i = Integer.MAX_VALUE; ; i = 0) {
            this.c = i;
            this.b.startScroll(0, i, 0, paramInt1, paramInt2);
            ExtendableListView.a(this.a, 2);
            ExtendableListView.a(this.a, this);
            return;
        }
    }

    public void run() {
        switch (ExtendableListView.c(this.a)) {
            default:
                return;
        }
        if ((ExtendableListView.e(this.a) == 0) || (this.a.getChildCount() == 0)) {
            a();
            return;
        }
        OverScroller localOverScroller = this.b;
        boolean bool1 = localOverScroller.computeScrollOffset();
        int j = localOverScroller.getCurrY();
        int i = this.c - j;
        if (i > 0) {
            ExtendableListView.c(this.a, this.a.b);
        }
        for (i = Math.min(this.a.getHeight() - this.a.getPaddingBottom() - this.a.getPaddingTop() - 1, i); ; i = Math.max(-(this.a.getHeight() - this.a.getPaddingBottom() - this.a.getPaddingTop() - 1), i)) {
            boolean bool2 = ExtendableListView.a(this.a, i, i);
            if ((!bool1) || (bool2)) {
                break;
            }
            this.a.invalidate();
            this.c = j;
            ExtendableListView.a(this.a, this);
            return;
            int k = this.a.getChildCount();
            ExtendableListView.c(this.a, k - 1 + this.a.b);
        }
        a();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/etsy/android/grid/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */