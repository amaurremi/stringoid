package com.flurry.sdk;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;

import java.util.Iterator;
import java.util.List;

public final class bh
        implements bf {
    private static final String a = bh.class.getSimpleName();

    private boolean a(String paramString1, String paramString2, Bundle paramBundle, String paramString3) {
        if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (paramBundle == null) || (TextUtils.isEmpty(paramString3))) {
            return false;
        }
        paramBundle = paramBundle.getString(paramString3);
        if (TextUtils.isEmpty(paramBundle)) {
            eo.b(a, paramString1 + ": package=\"" + paramString2 + "\": AndroidManifest.xml should include meta-data node with android:name=\"" + paramString3 + "\" and not empty value for android:value");
            return false;
        }
        eo.a(3, a, paramString1 + ": package=\"" + paramString2 + "\": AndroidManifest.xml has meta-data node with android:name=\"" + paramString3 + "\" and android:value=\"" + paramBundle + "\"");
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
            localObject = parambj.c();
        } while (localObject == null);
        parambj = dx.d(paramContext);
        paramContext = paramContext.getPackageName();
        Object localObject = ((List) localObject).iterator();
        boolean bool = true;
        if (((Iterator) localObject).hasNext()) {
            if (a(str, paramContext, parambj, (String) ((Iterator) localObject).next())) {
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


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/bh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */