package com.mopub.mobileads;

import android.util.Log;
import com.millennialmedia.android.MMAd;
import com.millennialmedia.android.MMException;
import com.millennialmedia.android.RequestListener;

class MillennialBanner$MillennialBannerRequestListener
        implements RequestListener {
    MillennialBanner$MillennialBannerRequestListener(MillennialBanner paramMillennialBanner) {
    }

    public void MMAdOverlayClosed(MMAd paramMMAd) {
        Log.d("MoPub", "Millennial banner ad closed.");
        MillennialBanner.access$000(this.this$0).onBannerCollapsed();
    }

    public void MMAdOverlayLaunched(MMAd paramMMAd) {
        Log.d("MoPub", "Millennial banner ad Launched.");
        MillennialBanner.access$000(this.this$0).onBannerExpanded();
    }

    public void MMAdRequestIsCaching(MMAd paramMMAd) {
    }

    public void onSingleTap(MMAd paramMMAd) {
        MillennialBanner.access$000(this.this$0).onBannerClicked();
    }

    public void requestCompleted(MMAd paramMMAd) {
        Log.d("MoPub", "Millennial banner ad loaded successfully. Showing ad...");
        MillennialBanner.access$000(this.this$0).onBannerLoaded(MillennialBanner.access$100(this.this$0));
    }

    public void requestFailed(MMAd paramMMAd, MMException paramMMException) {
        Log.d("MoPub", "Millennial banner ad failed to load.");
        MillennialBanner.access$000(this.this$0).onBannerFailed(MoPubErrorCode.NETWORK_NO_FILL);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/MillennialBanner$MillennialBannerRequestListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */