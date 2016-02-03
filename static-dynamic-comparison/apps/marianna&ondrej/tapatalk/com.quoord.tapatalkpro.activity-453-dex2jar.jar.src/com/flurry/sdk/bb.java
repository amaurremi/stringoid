package com.flurry.sdk;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.SparseArray;

import java.util.Iterator;
import java.util.List;

public final class bb
        implements bf {
    private static final String a = bb.class.getSimpleName();
    private static final SparseArray<String> b = a();

    @TargetApi(13)
    private static SparseArray<String> a() {
        SparseArray localSparseArray = new SparseArray();
        localSparseArray.append(1, "mcc");
        localSparseArray.append(2, "mnc");
        localSparseArray.append(4, "locale");
        localSparseArray.append(8, "touchscreen");
        localSparseArray.append(16, "keyboard");
        localSparseArray.append(32, "keyboardHidden");
        localSparseArray.append(64, "navigation");
        localSparseArray.append(128, "orientation");
        localSparseArray.append(256, "screenLayout");
        localSparseArray.append(512, "uiMode");
        localSparseArray.append(1024, "screenSize");
        localSparseArray.append(2048, "smallestScreenSize");
        return localSparseArray;
    }

    private boolean a(String paramString1, PackageManager paramPackageManager, String paramString2, ActivityInfo paramActivityInfo) {
        if ((TextUtils.isEmpty(paramString1)) || (paramPackageManager == null) || (TextUtils.isEmpty(paramString2)) || (paramActivityInfo == null) || (TextUtils.isEmpty(paramActivityInfo.name))) {
            return false;
        }
        paramPackageManager = cb.a(paramPackageManager, new ComponentName(paramString2, paramActivityInfo.name));
        if (paramPackageManager == null) {
            eo.b(a, paramString1 + ": package=\"" + paramString2 + "\": AndroidManifest.xml should include activity node with android:name=\"" + paramActivityInfo.name + "\"");
            return false;
        }
        eo.a(3, a, paramString1 + ": package=\"" + paramString2 + "\": AndroidManifest.xml has activity node with android:name=\"" + paramActivityInfo.name + "\"");
        int j = paramActivityInfo.configChanges;
        boolean bool2;
        if (j != 0) {
            int k = cb.a(paramPackageManager);
            paramPackageManager = b();
            int i = 0;
            boolean bool1 = true;
            bool2 = bool1;
            if (i < paramPackageManager.size()) {
                int m = paramPackageManager.keyAt(i);
                bool2 = bool1;
                if ((m & j) != 0) {
                    if ((m & k) != 0) {
                        break label304;
                    }
                    eo.b(a, paramString1 + ": package=\"" + paramString2 + "\": AndroidManifest.xml activity node with android:name=\"" + paramActivityInfo.name + "\" should include android:configChanges value=\"" + (String) paramPackageManager.valueAt(i) + "\"");
                }
                for (bool2 = false; ; bool2 = bool1) {
                    i += 1;
                    bool1 = bool2;
                    break;
                    label304:
                    eo.a(3, a, paramString1 + ": package=\"" + paramString2 + "\": AndroidManifest.xml activity node with " + "android:name=\"" + paramActivityInfo.name + "\" has android:configChanges value=\"" + (String) paramPackageManager.valueAt(i) + "\"");
                }
            }
        } else {
            bool2 = true;
        }
        return bool2;
    }

    private static SparseArray<String> b() {
        return b;
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
            localObject = parambj.e();
        } while (localObject == null);
        parambj = paramContext.getPackageManager();
        paramContext = paramContext.getPackageName();
        Object localObject = ((List) localObject).iterator();
        boolean bool = true;
        if (((Iterator) localObject).hasNext()) {
            if (a(str, parambj, paramContext, (ActivityInfo) ((Iterator) localObject).next())) {
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


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/bb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */