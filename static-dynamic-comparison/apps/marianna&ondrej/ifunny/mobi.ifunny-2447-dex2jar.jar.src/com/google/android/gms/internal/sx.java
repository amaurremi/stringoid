package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.IInterface;
import com.google.android.gms.auth.AccountChangeEventsRequest;
import com.google.android.gms.auth.AccountChangeEventsResponse;

public abstract interface sx
        extends IInterface {
    public abstract Bundle a(String paramString, Bundle paramBundle);

    public abstract Bundle a(String paramString1, String paramString2, Bundle paramBundle);

    public abstract AccountChangeEventsResponse a(AccountChangeEventsRequest paramAccountChangeEventsRequest);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/sx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */