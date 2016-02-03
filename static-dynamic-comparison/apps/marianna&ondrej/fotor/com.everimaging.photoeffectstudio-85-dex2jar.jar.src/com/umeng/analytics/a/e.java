package com.umeng.analytics.a;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.umeng.common.b;

public class e
        extends a {
    private static final String a = "imei";
    private Context b;

    public e(Context paramContext) {
        super("imei");
        this.b = paramContext;
    }

    public String f() {
        Object localObject = (TelephonyManager) this.b.getSystemService("phone");
        if (localObject == null) {
        }
        try {
            if (b.a(this.b, "android.permission.READ_PHONE_STATE")) {
                localObject = ((TelephonyManager) localObject).getDeviceId();
                return (String) localObject;
            }
        } catch (Exception localException) {
            return null;
        }
        return null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/umeng/analytics/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */