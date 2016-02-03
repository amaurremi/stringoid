package com.google.android.gms.auth;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.g;
import com.google.android.gms.internal.ol;

public final class e {
    public static final String a;
    public static final String b;
    private static final ComponentName c;
    private static final ComponentName d;
    private static final Intent e;
    private static final Intent f;

    static {
        if (Build.VERSION.SDK_INT >= 11) {
            a = "callerUid";
            if (Build.VERSION.SDK_INT < 14) {
                break label100;
            }
        }
        label100:
        for (; ; ) {
            b = "androidPackageName";
            c = new ComponentName("com.google.android.gms", "com.google.android.gms.auth.GetToken");
            d = new ComponentName("com.google.android.gms", "com.google.android.gms.recovery.RecoveryService");
            e = new Intent().setPackage("com.google.android.gms").setComponent(c);
            f = new Intent().setPackage("com.google.android.gms").setComponent(d);
            return;
            break;
        }
    }

    /* Error */
    public static String a(Context paramContext, String paramString1, String paramString2, android.os.Bundle paramBundle) {
        // Byte code:
        //   0: aload_0
        //   1: invokevirtual 73	android/content/Context:getApplicationContext	()Landroid/content/Context;
        //   4: astore 5
        //   6: ldc 75
        //   8: invokestatic 80	com/google/android/gms/common/internal/ag:c	(Ljava/lang/String;)V
        //   11: aload 5
        //   13: invokestatic 83	com/google/android/gms/auth/e:a	(Landroid/content/Context;)V
        //   16: aload_3
        //   17: ifnonnull +107 -> 124
        //   20: new 85	android/os/Bundle
        //   23: dup
        //   24: invokespecial 86	android/os/Bundle:<init>	()V
        //   27: astore_3
        //   28: aload_0
        //   29: invokevirtual 90	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
        //   32: getfield 95	android/content/pm/ApplicationInfo:packageName	Ljava/lang/String;
        //   35: astore_0
        //   36: aload_3
        //   37: ldc 97
        //   39: aload_0
        //   40: invokevirtual 100	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
        //   43: aload_3
        //   44: getstatic 29	com/google/android/gms/auth/e:b	Ljava/lang/String;
        //   47: invokevirtual 104	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
        //   50: ifne +11 -> 61
        //   53: aload_3
        //   54: getstatic 29	com/google/android/gms/auth/e:b	Ljava/lang/String;
        //   57: aload_0
        //   58: invokevirtual 100	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
        //   61: new 106	com/google/android/gms/common/j
        //   64: dup
        //   65: invokespecial 107	com/google/android/gms/common/j:<init>	()V
        //   68: astore_0
        //   69: aload 5
        //   71: getstatic 59	com/google/android/gms/auth/e:e	Landroid/content/Intent;
        //   74: aload_0
        //   75: iconst_1
        //   76: invokevirtual 111	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
        //   79: ifeq +156 -> 235
        //   82: aload_0
        //   83: invokevirtual 114	com/google/android/gms/common/j:a	()Landroid/os/IBinder;
        //   86: invokestatic 119	com/google/android/gms/internal/sy:a	(Landroid/os/IBinder;)Lcom/google/android/gms/internal/sx;
        //   89: aload_1
        //   90: aload_2
        //   91: aload_3
        //   92: invokeinterface 124 4 0
        //   97: astore_1
        //   98: aload_1
        //   99: ldc 126
        //   101: invokevirtual 130	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
        //   104: astore_2
        //   105: aload_2
        //   106: invokestatic 136	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
        //   109: istore 4
        //   111: iload 4
        //   113: ifne +23 -> 136
        //   116: aload 5
        //   118: aload_0
        //   119: invokevirtual 140	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
        //   122: aload_2
        //   123: areturn
        //   124: new 85	android/os/Bundle
        //   127: dup
        //   128: aload_3
        //   129: invokespecial 143	android/os/Bundle:<init>	(Landroid/os/Bundle;)V
        //   132: astore_3
        //   133: goto -105 -> 28
        //   136: aload_1
        //   137: ldc -111
        //   139: invokevirtual 130	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
        //   142: astore_2
        //   143: aload_1
        //   144: ldc -109
        //   146: invokevirtual 151	android/os/Bundle:getParcelable	(Ljava/lang/String;)Landroid/os/Parcelable;
        //   149: checkcast 47	android/content/Intent
        //   152: astore_1
        //   153: aload_2
        //   154: invokestatic 153	com/google/android/gms/auth/e:b	(Ljava/lang/String;)Z
        //   157: ifeq +42 -> 199
        //   160: new 155	com/google/android/gms/auth/g
        //   163: dup
        //   164: aload_2
        //   165: aload_1
        //   166: invokespecial 158	com/google/android/gms/auth/g:<init>	(Ljava/lang/String;Landroid/content/Intent;)V
        //   169: athrow
        //   170: astore_1
        //   171: ldc -96
        //   173: ldc -94
        //   175: aload_1
        //   176: invokestatic 168	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //   179: pop
        //   180: new 170	java/io/IOException
        //   183: dup
        //   184: ldc -84
        //   186: invokespecial 174	java/io/IOException:<init>	(Ljava/lang/String;)V
        //   189: athrow
        //   190: astore_1
        //   191: aload 5
        //   193: aload_0
        //   194: invokevirtual 140	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
        //   197: aload_1
        //   198: athrow
        //   199: aload_2
        //   200: invokestatic 176	com/google/android/gms/auth/e:a	(Ljava/lang/String;)Z
        //   203: ifeq +23 -> 226
        //   206: new 170	java/io/IOException
        //   209: dup
        //   210: aload_2
        //   211: invokespecial 174	java/io/IOException:<init>	(Ljava/lang/String;)V
        //   214: athrow
        //   215: astore_1
        //   216: new 178	com/google/android/gms/auth/d
        //   219: dup
        //   220: ldc -76
        //   222: invokespecial 181	com/google/android/gms/auth/d:<init>	(Ljava/lang/String;)V
        //   225: athrow
        //   226: new 178	com/google/android/gms/auth/d
        //   229: dup
        //   230: aload_2
        //   231: invokespecial 181	com/google/android/gms/auth/d:<init>	(Ljava/lang/String;)V
        //   234: athrow
        //   235: new 170	java/io/IOException
        //   238: dup
        //   239: ldc -73
        //   241: invokespecial 174	java/io/IOException:<init>	(Ljava/lang/String;)V
        //   244: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	245	0	paramContext	Context
        //   0	245	1	paramString1	String
        //   0	245	2	paramString2	String
        //   0	245	3	paramBundle	android.os.Bundle
        //   109	3	4	bool	boolean
        //   4	188	5	localContext	Context
        // Exception table:
        //   from	to	target	type
        //   82	111	170	android/os/RemoteException
        //   136	170	170	android/os/RemoteException
        //   199	215	170	android/os/RemoteException
        //   226	235	170	android/os/RemoteException
        //   82	111	190	finally
        //   136	170	190	finally
        //   171	190	190	finally
        //   199	215	190	finally
        //   216	226	190	finally
        //   226	235	190	finally
        //   82	111	215	java/lang/InterruptedException
        //   136	170	215	java/lang/InterruptedException
        //   199	215	215	java/lang/InterruptedException
        //   226	235	215	java/lang/InterruptedException
    }

    private static void a(Context paramContext) {
        try {
            GooglePlayServicesUtil.D(paramContext);
            return;
        } catch (g paramContext) {
            throw new f(paramContext.a(), paramContext.getMessage(), paramContext.b());
        } catch (com.google.android.gms.common.f paramContext) {
            throw new d(paramContext.getMessage());
        }
    }

    private static boolean a(String paramString) {
        return ("NetworkError".equals(paramString)) || ("ServiceUnavailable".equals(paramString)) || ("Timeout".equals(paramString));
    }

    private static boolean b(String paramString) {
        return ("BadAuthentication".equals(paramString)) || ("CaptchaRequired".equals(paramString)) || ("DeviceManagementRequiredOrSyncDisabled".equals(paramString)) || ("NeedPermission".equals(paramString)) || ("NeedsBrowser".equals(paramString)) || ("UserCancel".equals(paramString)) || ("AppDownloadRequired".equals(paramString)) || (ol.r.a().equals(paramString)) || (ol.s.a().equals(paramString)) || (ol.t.a().equals(paramString)) || (ol.u.a().equals(paramString)) || (ol.v.a().equals(paramString)) || (ol.w.a().equals(paramString));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/auth/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */