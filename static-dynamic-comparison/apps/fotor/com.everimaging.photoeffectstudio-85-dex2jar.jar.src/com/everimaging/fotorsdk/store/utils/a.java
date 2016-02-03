package com.everimaging.fotorsdk.store.utils;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

public abstract class a
        implements AbsListView.OnScrollListener {
    private int a = 0;
    private int b = 0;
    private int c = 0;
    private boolean d = true;
    private int e = 0;
    private int f = 8;

    public a(int paramInt1, int paramInt2) {
        this.a = paramInt1;
        this.f = paramInt2;
    }

    public void a() {
        this.d = false;
    }

    public abstract void a(int paramInt1, int paramInt2);

    public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {
        if (paramInt3 < this.c) {
            this.b = this.e;
            this.c = 0;
            this.d = true;
        }
        if ((this.d) && (paramInt3 > this.c)) {
            this.d = false;
            this.c = paramInt3;
            this.b += 1;
        }
        if ((!this.d) && (paramInt3 - paramInt2 <= this.a + paramInt1) && (paramInt3 >= this.f)) {
            a(this.b + 1, paramInt3);
            this.d = true;
        }
    }

    public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/store/utils/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */