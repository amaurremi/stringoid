package com.google.android.gms.plus;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

public abstract interface Account {
    public abstract void clearDefaultAccount(GoogleApiClient paramGoogleApiClient);

    public abstract String getAccountName(GoogleApiClient paramGoogleApiClient);

    public abstract PendingResult<Status> revokeAccessAndDisconnect(GoogleApiClient paramGoogleApiClient);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/plus/Account.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */