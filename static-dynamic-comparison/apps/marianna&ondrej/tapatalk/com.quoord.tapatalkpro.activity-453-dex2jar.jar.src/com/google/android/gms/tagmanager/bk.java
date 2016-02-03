package com.google.android.gms.tagmanager;

import android.content.Context;
import android.provider.Settings.Secure;
import com.google.android.gms.internal.a;
import com.google.android.gms.internal.d.a;

import java.util.Map;

class bk
        extends aj {
    private static final String ID = a.ad.toString();
    private final Context mContext;

    public bk(Context paramContext) {
        super(ID, new String[0]);
        this.mContext = paramContext;
    }

    protected String G(Context paramContext) {
        return Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
    }

    public boolean jX() {
        return true;
    }

    public d.a x(Map<String, d.a> paramMap) {
        paramMap = G(this.mContext);
        if (paramMap == null) {
            return dh.lT();
        }
        return dh.r(paramMap);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/tagmanager/bk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */