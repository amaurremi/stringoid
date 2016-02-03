package com.inmobi.monetization;

public abstract interface IMNativeListener {
    public abstract void onNativeRequestFailed(IMErrorCode paramIMErrorCode);

    public abstract void onNativeRequestSucceeded(IMNative paramIMNative);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/monetization/IMNativeListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */