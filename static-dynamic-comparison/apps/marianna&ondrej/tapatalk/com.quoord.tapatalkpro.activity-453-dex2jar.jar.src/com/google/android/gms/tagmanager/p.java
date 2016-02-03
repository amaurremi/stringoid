package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.a;
import com.google.android.gms.internal.d.a;

import java.util.Map;

class p
        extends aj {
    private static final String ID = a.D.toString();
    private final String Xl;

    public p(String paramString) {
        super(ID, new String[0]);
        this.Xl = paramString;
    }

    public boolean jX() {
        return true;
    }

    public d.a x(Map<String, d.a> paramMap) {
        if (this.Xl == null) {
            return dh.lT();
        }
        return dh.r(this.Xl);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/tagmanager/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */