package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.internal.a;
import com.google.android.gms.internal.d.a;

import java.util.Map;

class g
        extends aj {
    private static final String ID = a.x.toString();
    private final Context mContext;

    public g(Context paramContext) {
        super(ID, new String[0]);
        this.mContext = paramContext;
    }

    public boolean jX() {
        return true;
    }

    public d.a x(Map<String, d.a> paramMap) {
        try {
            paramMap = this.mContext.getPackageManager();
            paramMap = dh.r(paramMap.getApplicationLabel(paramMap.getApplicationInfo(this.mContext.getPackageName(), 0)).toString());
            return paramMap;
        } catch (PackageManager.NameNotFoundException paramMap) {
            bh.b("App name is not found.", paramMap);
        }
        return dh.lT();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/tagmanager/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */