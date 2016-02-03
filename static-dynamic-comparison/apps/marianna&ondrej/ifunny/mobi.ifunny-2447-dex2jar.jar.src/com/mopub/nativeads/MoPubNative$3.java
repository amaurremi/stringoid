package com.mopub.nativeads;

import android.content.Context;
import com.mopub.common.DownloadResponse;
import com.mopub.common.DownloadTask.DownloadTaskListener;

class MoPubNative$3
        implements DownloadTask.DownloadTaskListener {
    MoPubNative$3(MoPubNative paramMoPubNative) {
    }

    public void onComplete(String paramString, DownloadResponse paramDownloadResponse) {
        if (paramDownloadResponse == null) {
            MoPubNative.access$000(this.this$0).onNativeFail(NativeErrorCode.UNSPECIFIED);
        }
        Context localContext;
        do {
            return;
            if ((paramDownloadResponse.getStatusCode() >= 500) && (paramDownloadResponse.getStatusCode() < 600)) {
                MoPubNative.access$000(this.this$0).onNativeFail(NativeErrorCode.SERVER_ERROR_RESPONSE_CODE);
                return;
            }
            if (paramDownloadResponse.getStatusCode() != 200) {
                MoPubNative.access$000(this.this$0).onNativeFail(NativeErrorCode.UNEXPECTED_RESPONSE_CODE);
                return;
            }
            if (paramDownloadResponse.getContentLength() == 0L) {
                MoPubNative.access$000(this.this$0).onNativeFail(NativeErrorCode.EMPTY_AD_RESPONSE);
                return;
            }
            paramString = new MoPubNative .3 .1 (this, paramDownloadResponse);
            localContext = this.this$0.getContextOrDestroy();
        } while (localContext == null);
        CustomEventNativeAdapter.loadNativeAd(localContext, MoPubNative.access$300(this.this$0), paramDownloadResponse, paramString);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/nativeads/MoPubNative$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */