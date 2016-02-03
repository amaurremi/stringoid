package com.mopub.nativeads;

final class MoPubNative$1
        implements MoPubNative.MoPubNativeNetworkListener {
    public void onNativeFail(NativeErrorCode paramNativeErrorCode) {
    }

    public void onNativeLoad(NativeResponse paramNativeResponse) {
        paramNativeResponse.destroy();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/nativeads/MoPubNative$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */