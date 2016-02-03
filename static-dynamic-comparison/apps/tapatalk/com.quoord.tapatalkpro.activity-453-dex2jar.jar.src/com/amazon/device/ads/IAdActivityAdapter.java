package com.amazon.device.ads;

import android.app.Activity;

abstract interface IAdActivityAdapter {
    public abstract void onCreate();

    public abstract void onPause();

    public abstract void onResume();

    public abstract void onStop();

    public abstract void preOnCreate();

    public abstract void setActivity(Activity paramActivity);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/amazon/device/ads/IAdActivityAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */