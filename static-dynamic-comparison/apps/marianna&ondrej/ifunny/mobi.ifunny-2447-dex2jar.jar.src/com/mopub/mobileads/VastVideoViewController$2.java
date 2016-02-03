package com.mopub.mobileads;

import android.view.View;
import android.view.View.OnClickListener;
import com.mopub.mobileads.util.vast.VastCompanionAd;

class VastVideoViewController$2
        implements View.OnClickListener {
    VastVideoViewController$2(VastVideoViewController paramVastVideoViewController) {
    }

    public void onClick(View paramView) {
        if (VastVideoViewController.access$300(this.this$0) != null) {
            VastVideoViewController.access$200(this.this$0, VastVideoViewController.access$300(this.this$0).getClickTrackers(), VastVideoViewController.access$300(this.this$0).getClickThroughUrl());
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/VastVideoViewController$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */