package com.mopub.mobileads;

import android.content.Context;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.ResponseHeader;
import com.mopub.mobileads.factories.CustomEventInterstitialAdapterFactory;

import java.util.Map;

public class MoPubInterstitial$MoPubInterstitialView
        extends MoPubView {
    public MoPubInterstitial$MoPubInterstitialView(MoPubInterstitial paramMoPubInterstitial, Context paramContext) {
        super(paramContext);
        setAutorefreshEnabled(false);
    }

    protected void adFailed(MoPubErrorCode paramMoPubErrorCode) {
        if (MoPubInterstitial.access$100(this.this$0) != null) {
            MoPubInterstitial.access$100(this.this$0).onInterstitialFailed(this.this$0, paramMoPubErrorCode);
        }
    }

    protected void loadCustomEvent(Map<String, String> paramMap) {
        if (paramMap == null) {
            MoPubLog.d("Couldn't invoke custom event because the server did not specify one.");
            loadFailUrl(MoPubErrorCode.ADAPTER_NOT_FOUND);
            return;
        }
        if (MoPubInterstitial.access$000(this.this$0) != null) {
            MoPubInterstitial.access$000(this.this$0).invalidate();
        }
        MoPubLog.d("Loading custom event interstitial adapter.");
        MoPubInterstitial.access$002(this.this$0, CustomEventInterstitialAdapterFactory.create(this.this$0, (String) paramMap.get(ResponseHeader.CUSTOM_EVENT_NAME.getKey()), (String) paramMap.get(ResponseHeader.CUSTOM_EVENT_DATA.getKey())));
        MoPubInterstitial.access$000(this.this$0).setAdapterListener(this.this$0);
        MoPubInterstitial.access$000(this.this$0).loadInterstitial();
    }

    protected void trackImpression() {
        MoPubLog.d("Tracking impression for interstitial.");
        if (this.mAdViewController != null) {
            this.mAdViewController.trackImpression();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/MoPubInterstitial$MoPubInterstitialView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */