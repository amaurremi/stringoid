package com.etsy.android.grid;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView.LayoutParams;

public class h
        extends AbsListView.LayoutParams {
    boolean a;
    int b;
    long c = -1L;
    int d;

    public h(int paramInt1, int paramInt2) {
        super(paramInt1, paramInt2);
    }

    public h(int paramInt1, int paramInt2, int paramInt3) {
        super(paramInt1, paramInt2);
        this.d = paramInt3;
    }

    public h(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
    }

    public h(ViewGroup.LayoutParams paramLayoutParams) {
        super(paramLayoutParams);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/etsy/android/grid/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */