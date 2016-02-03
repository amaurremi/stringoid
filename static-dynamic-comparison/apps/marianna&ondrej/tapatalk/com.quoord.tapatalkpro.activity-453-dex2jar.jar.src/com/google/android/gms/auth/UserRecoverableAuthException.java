package com.google.android.gms.auth;

import android.content.Intent;

public class UserRecoverableAuthException
        extends GoogleAuthException {
    private final Intent mIntent;

    public UserRecoverableAuthException(String paramString, Intent paramIntent) {
        super(paramString);
        this.mIntent = paramIntent;
    }

    public Intent getIntent() {
        if (this.mIntent == null) {
            return null;
        }
        return new Intent(this.mIntent);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/auth/UserRecoverableAuthException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */