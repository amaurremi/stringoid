package com.amazon.device.ads;

import android.content.Context;

public final class AdRegistration {
    private static final String LOG_TAG = "AdRegistration";

    public static final void enableLogging(boolean paramBoolean) {
        Log.enableLoggingWithSetterNotification("AdRegistration", paramBoolean);
    }

    public static final void enableTesting(boolean paramBoolean) {
        Settings.getInstance().putTransientBoolean("testingEnabled", paramBoolean);
        Log.logSetterNotification("AdRegistration", "Test mode", Boolean.valueOf(paramBoolean));
    }

    public static final String getVersion() {
        return Version.getSDKVersion();
    }

    public static final void registerApp(Context paramContext) {
        if (!PermissionChecker.getInstance().passesInternetPermissionCheck(paramContext, "AdRegistration")) {
            return;
        }
        InternalAdRegistration.getInstance().contextReceived(paramContext);
        InternalAdRegistration.getInstance().register();
    }

    public static final void setAppKey(String paramString)
            throws IllegalArgumentException {
        InternalAdRegistration.getInstance().getRegistrationInfo().putAppKey(paramString);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/amazon/device/ads/AdRegistration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */