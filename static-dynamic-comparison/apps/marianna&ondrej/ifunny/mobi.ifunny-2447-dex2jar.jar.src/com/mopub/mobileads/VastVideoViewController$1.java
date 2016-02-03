package com.mopub.mobileads;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.mopub.mobileads.util.vast.VastVideoConfiguration;

class VastVideoViewController$1
        implements View.OnTouchListener {
    VastVideoViewController$1(VastVideoViewController paramVastVideoViewController) {
    }

    public boolean onTouch(View paramView, MotionEvent paramMotionEvent) {
        if ((paramMotionEvent.getAction() == 1) && (VastVideoViewController.access$000(this.this$0))) {
            VastVideoViewController.access$200(this.this$0, VastVideoViewController.access$100(this.this$0).getClickTrackers(), VastVideoViewController.access$100(this.this$0).getClickThroughUrl());
        }
        return true;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/VastVideoViewController$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */