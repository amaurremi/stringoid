package com.amazon.device.ads;

class AdvertisingIdentifier {
    private static final String GPS_ADVERTISING_IDENTIFIER_SETTING = "gpsAdId";
    private static final String LOG_TAG = AdvertisingIdentifier.class.getSimpleName();
    private static final String TRANSITION_MIGRATE = "migrate";
    private static final String TRANSITION_RESET = "reset";
    private static final String TRANSITION_REVERT = "revert";
    private static final String TRANSITION_SETTING = "adIdTransistion";
    private GooglePlayServices.AdvertisingInfo gpsAdvertisingInfo;
    private boolean shouldSetCurrentAdvertisingIdentifier = true;

    private void determineTransition() {
        String str = null;
        if (isTransitionMigrated()) {
            str = "migrate";
        }
        while (str != null) {
            setTransition(str);
            return;
            if (isTransitionReset()) {
                str = "reset";
            } else if (isTransitionReverted()) {
                str = "revert";
            }
        }
        Log.d(LOG_TAG, "No transition detected.");
    }

    static String getAndClearTransition() {
        Settings localSettings = Settings.getInstance();
        String str = localSettings.getString("adIdTransistion", null);
        localSettings.remove("adIdTransistion");
        return str;
    }

    private static String getCurrentGPSAID() {
        return Settings.getInstance().getString("gpsAdId", "");
    }

    private boolean hasCurrentGPSAID() {
        return !Utils.isNullOrEmpty(getCurrentGPSAID());
    }

    private boolean isTransitionMigrated() {
        return (InternalAdRegistration.getInstance().getRegistrationInfo().hasAdId()) && (RegistrationInfo.isAdIdOriginatedFromNonAdvertisingIdentifier()) && (!hasCurrentGPSAID()) && (getGPSAdvertisingInfo().hasAdvertisingIdentifier());
    }

    private boolean isTransitionReset() {
        return (hasCurrentGPSAID()) && (getGPSAdvertisingInfo().hasAdvertisingIdentifier()) && (!getCurrentGPSAID().equals(getGPSAdvertisingInfo().getAdvertisingIdentifier()));
    }

    private boolean isTransitionReverted() {
        return (hasCurrentGPSAID()) && (!getGPSAdvertisingInfo().hasAdvertisingIdentifier());
    }

    private static void setCurrentGPSAID(String paramString) {
        Settings.getInstance().putString("gpsAdId", paramString);
    }

    private static void setTransition(String paramString) {
        Log.d(LOG_TAG, "Transition: %s", new Object[]{paramString});
        Settings.getInstance().putString("adIdTransistion", paramString);
    }

    protected void fetchGooglePlayServicesAdvertisingIdentifierInfo() {
        this.gpsAdvertisingInfo = new GooglePlayServices().getAdvertisingIdentifierInfo();
    }

    Info getAdvertisingIdentifierInfo() {
        if (ThreadUtils.isOnMainThread()) {
            Log.e(LOG_TAG, "You must obtain the advertising indentifier information on a background thread.");
            return new Info().setCanDo(false);
        }
        fetchGooglePlayServicesAdvertisingIdentifierInfo();
        if (this.shouldSetCurrentAdvertisingIdentifier) {
            determineTransition();
        }
        Info localInfo = new Info();
        if (getGPSAdvertisingInfo().hasAdvertisingIdentifier()) {
            localInfo.setAdvertisingIdentifier(getGPSAdvertisingInfo().getAdvertisingIdentifier());
            localInfo.setLimitAdTrackingEnabled(getGPSAdvertisingInfo().isLimitAdTrackingEnabled());
            if (this.shouldSetCurrentAdvertisingIdentifier) {
                setCurrentGPSAID(getGPSAdvertisingInfo().getAdvertisingIdentifier());
            }
        }
        RegistrationInfo localRegistrationInfo = InternalAdRegistration.getInstance().getRegistrationInfo();
        if (RegistrationInfo.isAdIdCurrent(localInfo)) {
            localInfo.setSISDeviceIdentifier(localRegistrationInfo.getAdId());
            return localInfo;
        }
        localRegistrationInfo.requestNewSISDeviceIdentifier();
        return localInfo;
    }

    protected GooglePlayServices.AdvertisingInfo getGPSAdvertisingInfo() {
        return this.gpsAdvertisingInfo;
    }

    AdvertisingIdentifier setShouldSetCurrentAdvertisingIdentifier(boolean paramBoolean) {
        this.shouldSetCurrentAdvertisingIdentifier = paramBoolean;
        return this;
    }

    static class Info {
        private String advertisingIdentifier;
        private boolean canDo = true;
        private boolean limitAdTrackingEnabled;
        private String sisDeviceIdentifier;

        private Info setAdvertisingIdentifier(String paramString) {
            this.advertisingIdentifier = paramString;
            return this;
        }

        private Info setCanDo(boolean paramBoolean) {
            this.canDo = paramBoolean;
            return this;
        }

        private Info setLimitAdTrackingEnabled(boolean paramBoolean) {
            this.limitAdTrackingEnabled = paramBoolean;
            return this;
        }

        private Info setSISDeviceIdentifier(String paramString) {
            this.sisDeviceIdentifier = paramString;
            return this;
        }

        boolean canDo() {
            return this.canDo;
        }

        String getAdvertisingIdentifier() {
            return DebugProperties.getDebugPropertyAsString("debug.idfa", this.advertisingIdentifier);
        }

        String getSISDeviceIdentifier() {
            return DebugProperties.getDebugPropertyAsString("debug.adid", this.sisDeviceIdentifier);
        }

        boolean hasAdvertisingIdentifier() {
            return !Utils.isNullOrEmpty(getAdvertisingIdentifier());
        }

        boolean hasSISDeviceIdentifier() {
            return getSISDeviceIdentifier() != null;
        }

        boolean isLimitAdTrackingEnabled() {
            return DebugProperties.getDebugPropertyAsBoolean("debug.optOut", this.limitAdTrackingEnabled);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/amazon/device/ads/AdvertisingIdentifier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */