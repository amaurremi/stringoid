package com.amazon.device.ads;

import android.content.Context;

import java.io.File;

abstract interface IInternalAdRegistration {
    public abstract void contextReceived(Context paramContext);

    public abstract AppInfo getAppInfo();

    public abstract Context getApplicationContext();

    public abstract DeviceInfo getDeviceInfo();

    public abstract File getFilesDir();

    public abstract boolean getIsAppDisabled();

    public abstract int getNoRetryTtlRemainingMillis();

    public abstract RegistrationInfo getRegistrationInfo();

    public abstract boolean isRegistered();

    public abstract void register();

    public abstract void setIsAppDisabled(boolean paramBoolean);

    public abstract void setNoRetryTtl(int paramInt);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/amazon/device/ads/IInternalAdRegistration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */