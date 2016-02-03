package com.google.android.gms.internal;

import java.util.HashMap;
import java.util.Map;

class w
        implements y {
    private dz kU;

    public w(dz paramdz) {
        this.kU = paramdz;
    }

    public void a(ab paramab, boolean paramBoolean) {
        HashMap localHashMap = new HashMap();
        if (paramBoolean) {
        }
        for (paramab = "1"; ; paramab = "0") {
            localHashMap.put("isVisible", paramab);
            this.kU.a("onAdVisibilityChanged", localHashMap);
            return;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */