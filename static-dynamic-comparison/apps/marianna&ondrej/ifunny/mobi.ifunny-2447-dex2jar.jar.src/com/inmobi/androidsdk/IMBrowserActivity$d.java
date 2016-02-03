package com.inmobi.androidsdk;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;

class IMBrowserActivity$d
        implements View.OnKeyListener {
    IMBrowserActivity$d(IMBrowserActivity paramIMBrowserActivity) {
    }

    public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent) {
        if ((4 == paramKeyEvent.getKeyCode()) && (paramKeyEvent.getAction() == 0)) {
            this.a.finish();
        }
        return false;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/androidsdk/IMBrowserActivity$d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */