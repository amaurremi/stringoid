package com.inmobi.monetization.internal;

import java.util.Map;

public abstract interface IMAdListener {
    public abstract void onAdInteraction(Map<String, String> paramMap);

    public abstract void onAdRequestFailed(AdErrorCode paramAdErrorCode);

    public abstract void onAdRequestSucceeded();

    public abstract void onDismissAdScreen();

    public abstract void onIncentCompleted(Map<Object, Object> paramMap);

    public abstract void onLeaveApplication();

    public abstract void onShowAdScreen();
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/monetization/internal/IMAdListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */