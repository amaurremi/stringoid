package com.amazon.device.ads;

class RegistrationInfo {
    private static final String ADID_ORIGIN_PREF_NAME = "amzn-ad-id-origin";
    private static final String ADID_PREF_NAME = "amzn-ad-id";
    private static final String NEW_SIS_DID_REQUESTED_SETTING = "newSISDIDRequested";
    private static final String NON_ADVERTISING_IDENTIFIER_ORIGIN = "non-advertising-identifier";
    private static final String THIRD_PARTY_APP_NAME = "app";
    private String appKey;
    private String appName = "app";

    public static boolean isAdIdCurrent(AdvertisingIdentifier.Info paramInfo) {
        boolean bool2 = isAdIdOriginatedFromNonAdvertisingIdentifier();
        boolean bool1 = bool2;
        if (paramInfo.hasAdvertisingIdentifier()) {
            if (bool2) {
                bool1 = false;
            }
        } else {
            return bool1;
        }
        String str = Settings.getInstance().getString("amzn-ad-id-origin", null);
        return paramInfo.getAdvertisingIdentifier().equals(str);
    }

    public static boolean isAdIdOriginatedFromNonAdvertisingIdentifier() {
        String str = Settings.getInstance().getString("amzn-ad-id-origin", null);
        return (str == null) || ("non-advertising-identifier".equals(str));
    }

    protected static void setOrigin(AdvertisingIdentifier.Info paramInfo) {
        if (paramInfo.hasAdvertisingIdentifier()) {
            Settings.getInstance().putStringWithNoFlush("amzn-ad-id-origin", paramInfo.getAdvertisingIdentifier());
            return;
        }
        Settings.getInstance().putStringWithNoFlush("amzn-ad-id-origin", "non-advertising-identifier");
    }

    public String getAdId() {
        return DebugProperties.getDebugPropertyAsString("debug.adid", Settings.getInstance().getString("amzn-ad-id", null));
    }

    public String getAppKey() {
        return DebugProperties.getDebugPropertyAsString("debug.appid", this.appKey);
    }

    public String getAppName() {
        return this.appName;
    }

    public boolean hasAdId() {
        return getAdId() != null;
    }

    public boolean isRegisteredWithSIS() {
        return !Utils.isNullOrEmpty(getAdId());
    }

    public void putAdId(String paramString, AdvertisingIdentifier.Info paramInfo) {
        Settings localSettings = Settings.getInstance();
        localSettings.putStringWithNoFlush("amzn-ad-id", paramString);
        setOrigin(paramInfo);
        localSettings.putBooleanWithNoFlush("newSISDIDRequested", false);
        localSettings.flush();
    }

    public void putAppKey(String paramString) {
        if ((paramString == null) || (paramString.length() == 0)) {
            throw new IllegalArgumentException("Application Key must not be null or empty.");
        }
        this.appKey = Utils.getURLEncodedString(paramString);
    }

    public void putAppName(String paramString) {
        this.appName = Utils.getURLEncodedString(paramString);
    }

    public void requestNewSISDeviceIdentifier() {
        Settings.getInstance().putBoolean("newSISDIDRequested", true);
    }

    public boolean shouldGetNewSISDeviceIdentifer() {
        return Settings.getInstance().getBoolean("newSISDIDRequested", false);
    }

    public boolean shouldGetNewSISRegistration() {
        return !isRegisteredWithSIS();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/amazon/device/ads/RegistrationInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */