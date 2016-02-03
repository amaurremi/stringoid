package com.google.android.gms.internal;

import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;

@ii
final class fo {
    public final int a;
    public final ViewGroup.LayoutParams b;
    public final ViewGroup c;

    public fo(mz parammz) {
        this.b = parammz.getLayoutParams();
        ViewParent localViewParent = parammz.getParent();
        if ((localViewParent instanceof ViewGroup)) {
            this.c = ((ViewGroup) localViewParent);
            this.a = this.c.indexOfChild(parammz);
            this.c.removeView(parammz);
            parammz.a(true);
            return;
        }
        throw new fm("Could not get the parent of the WebView for an overlay.");
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/fo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */