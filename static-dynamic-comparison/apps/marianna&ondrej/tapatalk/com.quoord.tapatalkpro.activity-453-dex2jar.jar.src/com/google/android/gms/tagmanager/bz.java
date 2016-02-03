package com.google.android.gms.tagmanager;

import android.os.Build.VERSION;
import com.google.android.gms.internal.a;
import com.google.android.gms.internal.d.a;

import java.util.Map;

class bz
        extends aj {
    private static final String ID = a.M.toString();

    public bz() {
        super(ID, new String[0]);
    }

    public boolean jX() {
        return true;
    }

    public d.a x(Map<String, d.a> paramMap) {
        return dh.r(Build.VERSION.RELEASE);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/tagmanager/bz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */