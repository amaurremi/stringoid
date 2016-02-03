package com.google.android.gms.auth;

import android.content.Intent;

public class GooglePlayServicesAvailabilityException
        extends UserRecoverableAuthException {
    private final int wQ;

    GooglePlayServicesAvailabilityException(int paramInt, String paramString, Intent paramIntent) {
        super(paramString, paramIntent);
        this.wQ = paramInt;
    }

    public int getConnectionStatusCode() {
        return this.wQ;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/auth/GooglePlayServicesAvailabilityException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */