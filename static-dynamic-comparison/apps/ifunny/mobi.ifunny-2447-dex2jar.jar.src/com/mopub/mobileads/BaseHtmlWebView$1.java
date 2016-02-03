package com.mopub.mobileads;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class BaseHtmlWebView$1
        implements View.OnTouchListener {
    BaseHtmlWebView$1(BaseHtmlWebView paramBaseHtmlWebView, boolean paramBoolean) {
    }

    public boolean onTouch(View paramView, MotionEvent paramMotionEvent) {
        BaseHtmlWebView.access$000(this.this$0).sendTouchEvent(paramMotionEvent);
        return (paramMotionEvent.getAction() == 2) && (!this.val$isScrollable);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/BaseHtmlWebView$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */