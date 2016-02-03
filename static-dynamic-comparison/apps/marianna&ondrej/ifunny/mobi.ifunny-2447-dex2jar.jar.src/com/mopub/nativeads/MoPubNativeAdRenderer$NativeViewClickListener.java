package com.mopub.nativeads;

import android.view.View;
import android.view.View.OnClickListener;
import com.mopub.common.VisibleForTesting;

@VisibleForTesting
class MoPubNativeAdRenderer$NativeViewClickListener
        implements View.OnClickListener {
    private final NativeResponse mNativeResponse;

    MoPubNativeAdRenderer$NativeViewClickListener(NativeResponse paramNativeResponse) {
        this.mNativeResponse = paramNativeResponse;
    }

    public void onClick(View paramView) {
        this.mNativeResponse.handleClick(paramView);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/nativeads/MoPubNativeAdRenderer$NativeViewClickListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */