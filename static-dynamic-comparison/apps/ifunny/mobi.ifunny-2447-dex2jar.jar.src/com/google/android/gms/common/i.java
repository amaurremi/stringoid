package com.google.android.gms.common;

import android.content.Intent;

public class i
        extends Exception {
    private final Intent a;

    public i(String paramString, Intent paramIntent) {
        super(paramString);
        this.a = paramIntent;
    }

    public Intent b() {
        return new Intent(this.a);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/common/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */