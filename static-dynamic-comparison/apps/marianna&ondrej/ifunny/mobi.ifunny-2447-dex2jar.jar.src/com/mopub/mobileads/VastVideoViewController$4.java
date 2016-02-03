package com.mopub.mobileads;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class VastVideoViewController$4
        implements View.OnTouchListener {
    VastVideoViewController$4(VastVideoViewController paramVastVideoViewController) {
    }

    public boolean onTouch(View paramView, MotionEvent paramMotionEvent) {
        if (paramMotionEvent.getAction() == 1) {
            this.this$0.getBaseVideoViewControllerListener().onFinish();
        }
        return true;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/VastVideoViewController$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */