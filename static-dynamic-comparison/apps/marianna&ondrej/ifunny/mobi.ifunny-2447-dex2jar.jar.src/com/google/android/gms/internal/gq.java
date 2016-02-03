package com.google.android.gms.internal;

import android.content.Intent;

@ii
public class gq {
    private final String a;

    public gq(String paramString) {
        this.a = paramString;
    }

    public String a() {
        return lw.e();
    }

    public boolean a(String paramString, int paramInt, Intent paramIntent) {
        if ((paramString == null) || (paramIntent == null)) {
        }
        String str;
        do {
            return false;
            str = gp.b(paramIntent);
            paramIntent = gp.c(paramIntent);
        } while ((str == null) || (paramIntent == null));
        if (!paramString.equals(gp.a(str))) {
            mx.e("Developer payload not match.");
            return false;
        }
        if ((this.a != null) && (!gr.a(this.a, str, paramIntent))) {
            mx.e("Fail to verify signature.");
            return false;
        }
        return true;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/gq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */