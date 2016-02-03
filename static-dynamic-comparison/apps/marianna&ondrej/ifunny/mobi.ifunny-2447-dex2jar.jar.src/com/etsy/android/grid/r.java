package com.etsy.android.grid;

import android.view.ViewGroup.LayoutParams;

public class r
        extends h {
    int e;

    public r(int paramInt1, int paramInt2) {
        super(paramInt1, paramInt2);
        a();
    }

    public r(ViewGroup.LayoutParams paramLayoutParams) {
        super(paramLayoutParams);
        a();
    }

    private void a() {
        if (this.width != -1) {
            this.width = -1;
        }
        if (this.height == -1) {
            this.height = -2;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/etsy/android/grid/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */