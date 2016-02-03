package com.google.android.gms.tagmanager;

import android.os.Build.VERSION;
import com.google.android.gms.internal.a;
import com.google.android.gms.internal.d.a;

import java.util.Map;

class cu
        extends aj {
    private static final String ID = a.S.toString();

    public cu() {
        super(ID, new String[0]);
    }

    public boolean jX() {
        return true;
    }

    public d.a x(Map<String, d.a> paramMap) {
        return dh.r(Integer.valueOf(Build.VERSION.SDK_INT));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/tagmanager/cu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */