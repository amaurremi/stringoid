package com.flurry.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

public class eb {
    private static final String a = eb.class.getSimpleName();
    private static String b;
    private static String c;

    /* Error */
    public static String a() {
        // Byte code:
        //   0: ldc 2
        //   2: monitorenter
        //   3: getstatic 24	com/flurry/sdk/eb:b	Ljava/lang/String;
        //   6: invokestatic 30	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
        //   9: ifne +12 -> 21
        //   12: getstatic 24	com/flurry/sdk/eb:b	Ljava/lang/String;
        //   15: astore_0
        //   16: ldc 2
        //   18: monitorexit
        //   19: aload_0
        //   20: areturn
        //   21: getstatic 32	com/flurry/sdk/eb:c	Ljava/lang/String;
        //   24: invokestatic 30	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
        //   27: ifne +10 -> 37
        //   30: getstatic 32	com/flurry/sdk/eb:c	Ljava/lang/String;
        //   33: astore_0
        //   34: goto -18 -> 16
        //   37: invokestatic 34	com/flurry/sdk/eb:b	()Ljava/lang/String;
        //   40: putstatic 32	com/flurry/sdk/eb:c	Ljava/lang/String;
        //   43: getstatic 32	com/flurry/sdk/eb:c	Ljava/lang/String;
        //   46: astore_0
        //   47: goto -31 -> 16
        //   50: astore_0
        //   51: ldc 2
        //   53: monitorexit
        //   54: aload_0
        //   55: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   15	32	0	str	String
        //   50	5	0	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   3	16	50	finally
        //   21	34	50	finally
        //   37	47	50	finally
    }

    public static void a(String paramString) {
        b = paramString;
    }

    private static String b() {
        try {
            Object localObject = do.a().b();
            localObject = ((Context) localObject).getPackageManager().getPackageInfo(((Context) localObject).getPackageName(), 0);
            if (((PackageInfo) localObject).versionName != null) {
                return ((PackageInfo) localObject).versionName;
            }
            if (((PackageInfo) localObject).versionCode != 0) {
                localObject = Integer.toString(((PackageInfo) localObject).versionCode);
                return (String) localObject;
            }
        } catch (Throwable localThrowable) {
            eo.a(6, a, "", localThrowable);
        }
        return "Unknown";
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/flurry/sdk/eb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */