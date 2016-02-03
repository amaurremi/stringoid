package com.flurry.sdk;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;

import java.util.Iterator;
import java.util.List;

public final class bi
        implements bf {
    private static final String a = bi.class.getSimpleName();

    private boolean a(String paramString1, PackageManager paramPackageManager, String paramString2, String paramString3) {
        if ((TextUtils.isEmpty(paramString1)) || (paramPackageManager == null) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3))) {
            return false;
        }
        if (-1 == paramPackageManager.checkPermission(paramString3, paramString2)) {
            eo.b(a, paramString1 + ": package=\"" + paramString2 + "\": AndroidManifest.xml should include uses-permission node with " + "android:name=\"" + paramString3 + "\"");
            return false;
        }
        eo.a(3, a, paramString1 + ": package=\"" + paramString2 + "\": AndroidManifest.xml has uses-permission node with " + "android:name=\"" + paramString3 + "\"");
        return true;
    }

    public boolean a(Context paramContext, bj parambj) {
        if (parambj == null) {
        }
        String str;
        do {
            do {
                return false;
                str = parambj.a();
            } while (TextUtils.isEmpty(str));
            localObject = parambj.d();
        } while (localObject == null);
        parambj = paramContext.getPackageManager();
        paramContext = paramContext.getPackageName();
        Object localObject = ((List) localObject).iterator();
        boolean bool = true;
        if (((Iterator) localObject).hasNext()) {
            if (a(str, parambj, paramContext, (String) ((Iterator) localObject).next())) {
                break label90;
            }
            bool = false;
        }
        label90:
        for (; ; ) {
            break;
            return bool;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/bi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */