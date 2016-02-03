package com.millennialmedia.android;

import android.content.Context;
import android.widget.RelativeLayout.LayoutParams;

class MMLayout$MMLayoutMMAdImpl
        extends MMAdImpl {
    public MMLayout$MMLayoutMMAdImpl(MMLayout paramMMLayout, Context paramContext) {
        super(paramContext);
    }

    public void addView(MMWebView paramMMWebView, RelativeLayout.LayoutParams paramLayoutParams) {
        MMLog.d("MMLayout", "MMLayout adding view (" + paramMMWebView + ") to " + this);
        this.o.addView(paramMMWebView, paramLayoutParams);
    }

    int e() {
        return this.o.getId();
    }

    MMLayout r() {
        return this.o;
    }

    public void removeView(MMWebView paramMMWebView) {
        this.o.removeView(paramMMWebView);
    }

    public void setClickable(boolean paramBoolean) {
        this.o.setClickable(paramBoolean);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/MMLayout$MMLayoutMMAdImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */