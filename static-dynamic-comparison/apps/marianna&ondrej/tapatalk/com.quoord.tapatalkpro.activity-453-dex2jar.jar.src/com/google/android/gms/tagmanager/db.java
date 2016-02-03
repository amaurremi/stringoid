package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.a;
import com.google.android.gms.internal.d.a;

import java.util.Map;

class db
        extends dc {
    private static final String ID = a.ah.toString();

    public db() {
        super(ID);
    }

    protected boolean a(String paramString1, String paramString2, Map<String, d.a> paramMap) {
        return paramString1.startsWith(paramString2);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/tagmanager/db.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */