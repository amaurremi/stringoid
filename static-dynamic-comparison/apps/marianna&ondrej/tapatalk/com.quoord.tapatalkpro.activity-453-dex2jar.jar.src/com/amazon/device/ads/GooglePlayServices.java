package com.amazon.device.ads;

class GooglePlayServices {
    private static final String GPS_AVAILABLE_SETTING = "gps-available";
    private static final String LOG_TAG = GooglePlayServices.class.getSimpleName();

    private boolean isGPSAvailable() {
        return Settings.getInstance().getBoolean("gps-available", true);
    }

    private boolean isGPSAvailableSet() {
        return Settings.getInstance().containsKey("gps-available");
    }

    private void setGooglePlayServicesAvailable(boolean paramBoolean) {
        Settings.getInstance().putTransientBoolean("gps-available", paramBoolean);
    }

    protected GooglePlayServicesAdapter createGooglePlayServicesAdapter() {
        return new GooglePlayServicesAdapter();
    }

    public AdvertisingInfo getAdvertisingIdentifierInfo() {
        if (!isGPSAvailable()) {
            Log.v(LOG_TAG, "The Google Play Services Advertising Identifier feature is not available.");
            return AdvertisingInfo.createNotAvailable();
        }
        if ((!isGPSAvailableSet()) && (!ReflectionUtils.isClassAvailable("com.google.android.gms.ads.identifier.AdvertisingIdClient"))) {
            Log.v(LOG_TAG, "The Google Play Services Advertising Identifier feature is not available.");
            setGooglePlayServicesAvailable(false);
            return AdvertisingInfo.createNotAvailable();
        }
        AdvertisingInfo localAdvertisingInfo = createGooglePlayServicesAdapter().getAdvertisingIdentifierInfo();
        setGooglePlayServicesAvailable(localAdvertisingInfo.isGPSAvailable());
        return localAdvertisingInfo;
    }

    static class AdvertisingInfo {
        private String advertisingIdentifier;
        private boolean gpsAvailable = true;
        private boolean limitAdTrackingEnabled;

        static AdvertisingInfo createNotAvailable() {
            return new AdvertisingInfo().setGPSAvailable(false);
        }

        private AdvertisingInfo setGPSAvailable(boolean paramBoolean) {
            this.gpsAvailable = paramBoolean;
            return this;
        }

        String getAdvertisingIdentifier() {
            return this.advertisingIdentifier;
        }

        boolean hasAdvertisingIdentifier() {
            return getAdvertisingIdentifier() != null;
        }

        boolean isGPSAvailable() {
            return this.gpsAvailable;
        }

        boolean isLimitAdTrackingEnabled() {
            return this.limitAdTrackingEnabled;
        }

        AdvertisingInfo setAdvertisingIdentifier(String paramString) {
            this.advertisingIdentifier = paramString;
            return this;
        }

        AdvertisingInfo setLimitAdTrackingEnabled(boolean paramBoolean) {
            this.limitAdTrackingEnabled = paramBoolean;
            return this;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/amazon/device/ads/GooglePlayServices.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */