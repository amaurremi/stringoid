package com.mopub.mobileads;

import android.os.Handler;
import android.widget.VideoView;
import com.mopub.common.HttpClient;
import com.mopub.mobileads.util.vast.VastVideoConfiguration;

class VastVideoViewController$3
        implements Runnable {
    VastVideoViewController$3(VastVideoViewController paramVastVideoViewController) {
    }

    public void run() {
        float f2 = VastVideoViewController.access$400(this.this$0).getDuration();
        float f1 = VastVideoViewController.access$400(this.this$0).getCurrentPosition();
        if (f2 > 0.0F) {
            f2 = f1 / f2;
            if ((!VastVideoViewController.access$500(this.this$0)) && (f1 >= 1000.0F)) {
                VastVideoViewController.access$502(this.this$0, true);
                HttpClient.makeTrackingHttpRequest(VastVideoViewController.access$100(this.this$0).getStartTrackers(), this.this$0.getContext());
            }
            if ((!VastVideoViewController.access$600(this.this$0)) && (f2 > 0.25F)) {
                VastVideoViewController.access$602(this.this$0, true);
                HttpClient.makeTrackingHttpRequest(VastVideoViewController.access$100(this.this$0).getFirstQuartileTrackers(), this.this$0.getContext());
            }
            if ((!VastVideoViewController.access$700(this.this$0)) && (f2 > 0.5F)) {
                VastVideoViewController.access$702(this.this$0, true);
                HttpClient.makeTrackingHttpRequest(VastVideoViewController.access$100(this.this$0).getMidpointTrackers(), this.this$0.getContext());
            }
            if ((!VastVideoViewController.access$800(this.this$0)) && (f2 > 0.75F)) {
                VastVideoViewController.access$802(this.this$0, true);
                HttpClient.makeTrackingHttpRequest(VastVideoViewController.access$100(this.this$0).getThirdQuartileTrackers(), this.this$0.getContext());
            }
            if (VastVideoViewController.access$900(this.this$0, VastVideoViewController.access$400(this.this$0).getDuration())) {
                VastVideoViewController.access$1100(this.this$0).updateCountdownWidget(VastVideoViewController.access$1000(this.this$0) - VastVideoViewController.access$400(this.this$0).getCurrentPosition());
            }
            if (VastVideoViewController.access$1200(this.this$0)) {
                VastVideoViewController.access$1300(this.this$0);
            }
        }
        VastVideoViewController.access$1100(this.this$0).updateDurationWidget(VastVideoViewController.access$400(this.this$0).getDuration() - VastVideoViewController.access$400(this.this$0).getCurrentPosition());
        if (VastVideoViewController.access$1400(this.this$0)) {
            VastVideoViewController.access$1600(this.this$0).postDelayed(VastVideoViewController.access$1500(this.this$0), 50L);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/VastVideoViewController$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */