package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;

import java.math.BigInteger;
import java.util.Locale;

public final class dn {
    private static final Object px = new Object();
    private static String qX;

    public static String b(Context paramContext, String paramString1, String paramString2) {
        synchronized (px) {
            if ((qX == null) && (!TextUtils.isEmpty(paramString1))) {
                c(paramContext, paramString1, paramString2);
            }
            paramContext = qX;
            return paramContext;
        }
    }

    public static String bx() {
        synchronized (px) {
            String str = qX;
            return str;
        }
    }

    private static void c(Context paramContext, String paramString1, String paramString2) {
        try {
            paramString2 = paramContext.createPackageContext(paramString2, 3).getClassLoader();
            Class localClass = Class.forName("com.google.ads.mediation.MediationAdapter", false, paramString2);
            paramContext = new BigInteger(new byte[1]);
            String[] arrayOfString = paramString1.split(",");
            int i = 0;
            while (i < arrayOfString.length) {
                paramString1 = paramContext;
                if (dq.a(paramString2, localClass, arrayOfString[i])) {
                    paramString1 = paramContext.setBit(i);
                }
                i += 1;
                paramContext = paramString1;
            }
        } catch (Throwable paramContext) {
            qX = "err";
            return;
        }
        tmp93_90[0] = paramContext;
        qX = String.format(Locale.US, "%X", tmp93_90);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/dn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */