package com.inneractive.api.ads.sdk;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

final class IAmraidWebView$1
        implements View.OnTouchListener {
    IAmraidWebView$1(IAmraidWebView paramIAmraidWebView) {
    }

    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent) {
        IAmraidWebView.access$000(this.this$0).a(paramMotionEvent);
        switch (paramMotionEvent.getAction()) {
        }
        for (; ; ) {
            return false;
            if ((paramView != null) && (!paramView.hasFocus())) {
                paramView.requestFocus();
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inneractive/api/ads/sdk/IAmraidWebView$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */