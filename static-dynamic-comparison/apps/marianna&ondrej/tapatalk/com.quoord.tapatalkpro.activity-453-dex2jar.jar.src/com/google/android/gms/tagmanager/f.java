package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.a;
import com.google.android.gms.internal.d.a;

import java.util.Map;

class f
        extends aj {
    private static final String ID = a.w.toString();
    private final Context mContext;

    public f(Context paramContext) {
        super(ID, new String[0]);
        this.mContext = paramContext;
    }

    public boolean jX() {
        return true;
    }

    public d.a x(Map<String, d.a> paramMap) {
        return dh.r(this.mContext.getPackageName());
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/tagmanager/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */