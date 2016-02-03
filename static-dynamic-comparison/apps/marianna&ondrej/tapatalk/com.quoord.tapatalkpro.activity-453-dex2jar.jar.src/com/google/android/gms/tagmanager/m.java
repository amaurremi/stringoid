package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.a;
import com.google.android.gms.internal.b;
import com.google.android.gms.internal.d.a;

import java.util.Map;

class m
        extends aj {
    private static final String ID = a.A.toString();
    private static final String VALUE = b.ew.toString();

    public m() {
        super(ID, new String[]{VALUE});
    }

    public static String ka() {
        return ID;
    }

    public static String kb() {
        return VALUE;
    }

    public boolean jX() {
        return true;
    }

    public d.a x(Map<String, d.a> paramMap) {
        return (d.a) paramMap.get(VALUE);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/tagmanager/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */