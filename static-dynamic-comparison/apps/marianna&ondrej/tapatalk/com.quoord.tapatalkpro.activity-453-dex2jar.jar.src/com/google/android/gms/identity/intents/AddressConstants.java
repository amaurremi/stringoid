package com.google.android.gms.identity.intents;

public abstract interface AddressConstants {
    public static abstract interface ErrorCodes {
        public static final int ERROR_CODE_NO_APPLICABLE_ADDRESSES = 555;
    }

    public static abstract interface Extras {
        public static final String EXTRA_ADDRESS = "com.google.android.gms.identity.intents.EXTRA_ADDRESS";
        public static final String EXTRA_ERROR_CODE = "com.google.android.gms.identity.intents.EXTRA_ERROR_CODE";
    }

    public static abstract interface ResultCodes {
        public static final int RESULT_ERROR = 1;
    }

    public static abstract interface Themes {
        public static final int THEME_HOLO_DARK = 0;
        public static final int THEME_HOLO_LIGHT = 1;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/identity/intents/AddressConstants.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */