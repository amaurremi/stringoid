package com.amazon.device.ads;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import org.json.JSONObject;

class cm {
    private String a;
    private String b;
    private String c;
    private String d;
    private JSONObject e;

    protected cm() {
    }

    public cm(Context paramContext) {
        this.a = paramContext.getPackageName();
        Object localObject = paramContext.getPackageManager();
        this.b = ((String) ((PackageManager) localObject).getApplicationLabel(paramContext.getApplicationInfo()));
        try {
            paramContext = ((PackageManager) localObject).getPackageInfo(this.a, 0);
            if (paramContext != null) {
                localObject = paramContext.versionName;
                this.d = ((String) localObject);
                if (paramContext == null) {
                    break label149;
                }
                paramContext = Integer.toString(paramContext.versionCode);
                this.c = paramContext;
                this.e = new JSONObject();
                du.b(this.e, "lbl", this.b);
                du.b(this.e, "pn", this.a);
                du.b(this.e, "v", this.c);
                du.b(this.e, "vn", this.d);
            }
        } catch (PackageManager.NameNotFoundException paramContext) {
            for (; ; ) {
                paramContext = null;
                continue;
                localObject = "";
                continue;
                label149:
                paramContext = "";
            }
        }
    }

    public JSONObject a() {
        return this.e;
    }

    public String b() {
        if (this.e != null) {
            return this.e.toString();
        }
        return null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/amazon/device/ads/cm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */