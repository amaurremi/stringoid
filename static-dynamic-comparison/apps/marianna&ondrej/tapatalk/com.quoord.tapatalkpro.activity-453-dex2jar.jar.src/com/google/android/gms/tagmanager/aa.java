package com.google.android.gms.tagmanager;

import android.os.Build;
import com.google.android.gms.internal.a;
import com.google.android.gms.internal.d.a;

import java.util.Map;

class aa
        extends aj {
    private static final String ID = a.F.toString();

    public aa() {
        super(ID, new String[0]);
    }

    public boolean jX() {
        return true;
    }

    public d.a x(Map<String, d.a> paramMap) {
        String str2 = Build.MANUFACTURER;
        String str1 = Build.MODEL;
        paramMap = str1;
        if (!str1.startsWith(str2)) {
            paramMap = str1;
            if (!str2.equals("unknown")) {
                paramMap = str2 + " " + str1;
            }
        }
        return dh.r(paramMap);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/tagmanager/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */