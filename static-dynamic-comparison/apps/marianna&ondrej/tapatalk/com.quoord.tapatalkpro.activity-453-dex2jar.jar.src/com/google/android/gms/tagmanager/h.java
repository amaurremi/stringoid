package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.internal.a;
import com.google.android.gms.internal.d.a;

import java.util.Map;

class h
        extends aj {
    private static final String ID = a.y.toString();
    private final Context mContext;

    public h(Context paramContext) {
        super(ID, new String[0]);
        this.mContext = paramContext;
    }

    public boolean jX() {
        return true;
    }

    public d.a x(Map<String, d.a> paramMap) {
        try {
            paramMap = dh.r(Integer.valueOf(this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 0).versionCode));
            return paramMap;
        } catch (PackageManager.NameNotFoundException paramMap) {
            bh.w("Package name " + this.mContext.getPackageName() + " not found. " + paramMap.getMessage());
        }
        return dh.lT();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/tagmanager/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */