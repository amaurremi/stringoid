package com.inmobi.androidsdk;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import com.inmobi.re.container.IMWebView;

class IMBrowserActivity$g
        implements View.OnKeyListener {
    IMBrowserActivity$g(IMBrowserActivity paramIMBrowserActivity) {
    }

    public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent) {
        if ((4 == paramKeyEvent.getKeyCode()) && (paramKeyEvent.getAction() == 0)) {
            if (IMBrowserActivity.a() != null) {
                IMBrowserActivity.a().close();
            }
            this.a.finish();
            return true;
        }
        return false;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/androidsdk/IMBrowserActivity$g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */