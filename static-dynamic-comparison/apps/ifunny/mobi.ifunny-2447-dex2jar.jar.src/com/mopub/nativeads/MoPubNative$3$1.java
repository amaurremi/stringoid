package com.mopub.nativeads;

import android.content.Context;
import com.mopub.common.DownloadResponse;
import com.mopub.common.util.ResponseHeader;

class MoPubNative$3$1
        implements CustomEventNative.CustomEventNativeListener {
    MoPubNative$3$1(MoPubNative.3param3, DownloadResponse paramDownloadResponse) {
    }

    public void onNativeAdFailed(NativeErrorCode paramNativeErrorCode) {
        this.this$1.this$0.requestNativeAd(this.val$downloadResponse.getFirstHeader(ResponseHeader.FAIL_URL));
    }

    public void onNativeAdLoaded(NativeAdInterface paramNativeAdInterface) {
        Context localContext = this.this$1.this$0.getContextOrDestroy();
        if (localContext == null) {
            return;
        }
        MoPubNative.access$000(this.this$1.this$0).onNativeLoad(new NativeResponse(localContext, this.val$downloadResponse, MoPubNative.access$100(this.this$1.this$0), paramNativeAdInterface, MoPubNative.access$200(this.this$1.this$0)));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/nativeads/MoPubNative$3$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */