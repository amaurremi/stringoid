package com.millennialmedia.android;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.pm.PackageManager;
import android.os.Vibrator;

import java.lang.ref.WeakReference;
import java.util.Map;

class BridgeMMNotification
        extends MMJSObject
        implements DialogInterface.OnClickListener {
    private String a = "alert";
    private String d = "vibrate";
    private int e;

    MMJSResponse a(String paramString, Map<String, String> paramMap) {
        MMJSResponse localMMJSResponse = null;
        if (this.a.equals(paramString)) {
            localMMJSResponse = alert(paramMap);
        }
        while (!this.d.equals(paramString)) {
            return localMMJSResponse;
        }
        return vibrate(paramMap);
    }

    public MMJSResponse alert(Map<String, String> paramMap) {
        try {
            paramMap = a(new BridgeMMNotification .1 (this, paramMap));
            return paramMap;
        } finally {
            paramMap =finally;
            throw paramMap;
        }
    }

    public void onClick(DialogInterface paramDialogInterface, int paramInt) {
        if (paramInt == -2) {
        }
        try {
            this.e = 0;
            if (paramInt == -3) {
                this.e = 1;
            }
            if (paramInt == -1) {
                this.e = 2;
            }
            paramDialogInterface.cancel();
            notify();
            return;
        } finally {
        }
    }

    public MMJSResponse vibrate(Map<String, String> paramMap) {
        Context localContext = (Context) this.b.get();
        if (paramMap.containsKey("duration")) {
        }
        for (long l = (Float.parseFloat((String) paramMap.get("duration")) * 1000.0D); ; l = 0L) {
            if ((localContext != null) && (l > 0L)) {
                if (localContext.getPackageManager().checkPermission("android.permission.VIBRATE", localContext.getPackageName()) == 0) {
                    ((Vibrator) localContext.getSystemService("vibrator")).vibrate(l);
                    return MMJSResponse.a("Vibrating for " + l);
                }
                return MMJSResponse.b("The required permissions to vibrate are not set.");
            }
            return null;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/BridgeMMNotification.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */