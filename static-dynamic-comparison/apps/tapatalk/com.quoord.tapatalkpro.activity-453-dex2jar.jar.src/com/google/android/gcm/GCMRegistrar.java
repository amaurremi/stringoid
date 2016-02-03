package com.google.android.gcm;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.os.Build.VERSION;
import android.util.Log;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class GCMRegistrar {
    private static final String BACKOFF_MS = "backoff_ms";
    private static final int DEFAULT_BACKOFF_MS = 3000;
    private static final String GSF_PACKAGE = "com.google.android.gsf";
    private static final String PREFERENCES = "com.google.android.gcm";
    private static final String PROPERTY_APP_VERSION = "appVersion";
    private static final String PROPERTY_ON_SERVER = "onServer";
    private static final String PROPERTY_REG_ID = "regId";
    private static final String TAG = "GCMRegistrar";
    private static GCMBroadcastReceiver sRetryReceiver;

    private GCMRegistrar() {
        throw new UnsupportedOperationException();
    }

    public static void checkDevice(Context paramContext) {
        int i = Build.VERSION.SDK_INT;
        if (i < 8) {
            throw new UnsupportedOperationException("Device must be at least API Level 8 (instead of " + i + ")");
        }
        paramContext = paramContext.getPackageManager();
        try {
            paramContext.getPackageInfo("com.google.android.gsf", 0);
            return;
        } catch (PackageManager.NameNotFoundException paramContext) {
            throw new UnsupportedOperationException("Device does not have package com.google.android.gsf");
        }
    }

    /* Error */
    public static void checkManifest(Context paramContext) {
        // Byte code:
        //   0: aload_0
        //   1: invokevirtual 75	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
        //   4: astore 5
        //   6: aload_0
        //   7: invokevirtual 87	android/content/Context:getPackageName	()Ljava/lang/String;
        //   10: astore_3
        //   11: new 50	java/lang/StringBuilder
        //   14: dup
        //   15: aload_3
        //   16: invokestatic 93	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
        //   19: invokespecial 55	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   22: ldc 95
        //   24: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   27: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   30: astore 4
        //   32: aload 5
        //   34: aload 4
        //   36: sipush 4096
        //   39: invokevirtual 99	android/content/pm/PackageManager:getPermissionInfo	(Ljava/lang/String;I)Landroid/content/pm/PermissionInfo;
        //   42: pop
        //   43: aload 5
        //   45: aload_3
        //   46: iconst_2
        //   47: invokevirtual 81	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
        //   50: astore 4
        //   52: aload 4
        //   54: getfield 105	android/content/pm/PackageInfo:receivers	[Landroid/content/pm/ActivityInfo;
        //   57: astore 4
        //   59: aload 4
        //   61: ifnull +9 -> 70
        //   64: aload 4
        //   66: arraylength
        //   67: ifne +78 -> 145
        //   70: new 107	java/lang/IllegalStateException
        //   73: dup
        //   74: new 50	java/lang/StringBuilder
        //   77: dup
        //   78: ldc 109
        //   80: invokespecial 55	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   83: aload_3
        //   84: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   87: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   90: invokespecial 110	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
        //   93: athrow
        //   94: astore_0
        //   95: new 107	java/lang/IllegalStateException
        //   98: dup
        //   99: new 50	java/lang/StringBuilder
        //   102: dup
        //   103: ldc 112
        //   105: invokespecial 55	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   108: aload 4
        //   110: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   113: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   116: invokespecial 110	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
        //   119: athrow
        //   120: astore_0
        //   121: new 107	java/lang/IllegalStateException
        //   124: dup
        //   125: new 50	java/lang/StringBuilder
        //   128: dup
        //   129: ldc 114
        //   131: invokespecial 55	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   134: aload_3
        //   135: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   138: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   141: invokespecial 110	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
        //   144: athrow
        //   145: new 116	java/util/HashSet
        //   148: dup
        //   149: invokespecial 117	java/util/HashSet:<init>	()V
        //   152: astore_3
        //   153: aload 4
        //   155: arraylength
        //   156: istore_2
        //   157: iconst_0
        //   158: istore_1
        //   159: iload_1
        //   160: iload_2
        //   161: if_icmplt +22 -> 183
        //   164: aload_3
        //   165: invokeinterface 123 1 0
        //   170: ifeq +51 -> 221
        //   173: new 107	java/lang/IllegalStateException
        //   176: dup
        //   177: ldc 125
        //   179: invokespecial 110	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
        //   182: athrow
        //   183: aload 4
        //   185: iload_1
        //   186: aaload
        //   187: astore 5
        //   189: ldc 127
        //   191: aload 5
        //   193: getfield 132	android/content/pm/ActivityInfo:permission	Ljava/lang/String;
        //   196: invokevirtual 136	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   199: ifeq +15 -> 214
        //   202: aload_3
        //   203: aload 5
        //   205: getfield 139	android/content/pm/ActivityInfo:name	Ljava/lang/String;
        //   208: invokeinterface 142 2 0
        //   213: pop
        //   214: iload_1
        //   215: iconst_1
        //   216: iadd
        //   217: istore_1
        //   218: goto -59 -> 159
        //   221: aload_0
        //   222: aload_3
        //   223: ldc -112
        //   225: invokestatic 148	com/google/android/gcm/GCMRegistrar:checkReceiver	(Landroid/content/Context;Ljava/util/Set;Ljava/lang/String;)V
        //   228: aload_0
        //   229: aload_3
        //   230: ldc -106
        //   232: invokestatic 148	com/google/android/gcm/GCMRegistrar:checkReceiver	(Landroid/content/Context;Ljava/util/Set;Ljava/lang/String;)V
        //   235: return
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	236	0	paramContext	Context
        //   158	60	1	i	int
        //   156	6	2	j	int
        //   10	220	3	localObject1	Object
        //   30	154	4	localObject2	Object
        //   4	200	5	localPackageManager	PackageManager
        // Exception table:
        //   from	to	target	type
        //   32	43	94	android/content/pm/PackageManager$NameNotFoundException
        //   43	52	120	android/content/pm/PackageManager$NameNotFoundException
    }

    private static void checkReceiver(Context paramContext, Set<String> paramSet, String paramString) {
        PackageManager localPackageManager = paramContext.getPackageManager();
        paramContext = paramContext.getPackageName();
        Intent localIntent = new Intent(paramString);
        localIntent.setPackage(paramContext);
        paramContext = localPackageManager.queryBroadcastReceivers(localIntent, 32);
        if (paramContext.isEmpty()) {
            throw new IllegalStateException("No receivers for action " + paramString);
        }
        paramContext = paramContext.iterator();
        do {
            if (!paramContext.hasNext()) {
                return;
            }
            paramString = ((ResolveInfo) paramContext.next()).activityInfo.name;
        } while (paramSet.contains(paramString));
        throw new IllegalStateException("Receiver " + paramString + " is not set with permission " + "com.google.android.c2dm.permission.SEND");
    }

    static String clearRegistrationId(Context paramContext) {
        return setRegistrationId(paramContext, "");
    }

    public static void deleteRegistrationId(Context paramContext) {
        paramContext = getGCMPreferences(paramContext).edit();
        paramContext.remove("regId");
        paramContext.commit();
    }

    private static int getAppVersion(Context paramContext) {
        try {
            int i = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionCode;
            return i;
        } catch (PackageManager.NameNotFoundException paramContext) {
            throw new RuntimeException("Coult not get package name: " + paramContext);
        }
    }

    static int getBackoff(Context paramContext) {
        return getGCMPreferences(paramContext).getInt("backoff_ms", 3000);
    }

    private static SharedPreferences getGCMPreferences(Context paramContext) {
        return paramContext.getSharedPreferences("com.google.android.gcm", 0);
    }

    public static String getRegistrationId(Context paramContext) {
        Object localObject = getGCMPreferences(paramContext);
        String str = ((SharedPreferences) localObject).getString("regId", "");
        int i = ((SharedPreferences) localObject).getInt("appVersion", Integer.MIN_VALUE);
        int j = getAppVersion(paramContext);
        localObject = str;
        if (i != Integer.MIN_VALUE) {
            localObject = str;
            if (i != j) {
                clearRegistrationId(paramContext);
                localObject = "";
            }
        }
        return (String) localObject;
    }

    static void internalRegister(Context paramContext, String... paramVarArgs) {
        if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {
            throw new IllegalArgumentException("No senderIds");
        }
        Object localObject = new StringBuilder(paramVarArgs[0]);
        int i = 1;
        for (; ; ) {
            if (i >= paramVarArgs.length) {
                paramVarArgs = ((StringBuilder) localObject).toString();
                localObject = new Intent("com.google.android.c2dm.intent.REGISTER");
                ((Intent) localObject).setPackage("com.google.android.gsf");
                ((Intent) localObject).putExtra("app", PendingIntent.getBroadcast(paramContext, 0, new Intent(), 0));
                ((Intent) localObject).putExtra("sender", paramVarArgs);
                paramContext.startService((Intent) localObject);
                return;
            }
            ((StringBuilder) localObject).append(',').append(paramVarArgs[i]);
            i += 1;
        }
    }

    static void internalUnregister(Context paramContext) {
        Intent localIntent = new Intent("com.google.android.c2dm.intent.UNREGISTER");
        localIntent.setPackage("com.google.android.gsf");
        localIntent.putExtra("app", PendingIntent.getBroadcast(paramContext, 0, new Intent(), 0));
        paramContext.startService(localIntent);
    }

    public static boolean isRegistered(Context paramContext) {
        return getRegistrationId(paramContext).length() > 0;
    }

    public static boolean isRegisteredOnServer(Context paramContext) {
        return getGCMPreferences(paramContext).getBoolean("onServer", false);
    }

    /* Error */
    public static void onDestroy(Context paramContext) {
        // Byte code:
        //   0: ldc 2
        //   2: monitorenter
        //   3: getstatic 309	com/google/android/gcm/GCMRegistrar:sRetryReceiver	Lcom/google/android/gcm/GCMBroadcastReceiver;
        //   6: astore_1
        //   7: aload_1
        //   8: ifnull +14 -> 22
        //   11: aload_0
        //   12: getstatic 309	com/google/android/gcm/GCMRegistrar:sRetryReceiver	Lcom/google/android/gcm/GCMBroadcastReceiver;
        //   15: invokevirtual 313	android/content/Context:unregisterReceiver	(Landroid/content/BroadcastReceiver;)V
        //   18: aconst_null
        //   19: putstatic 309	com/google/android/gcm/GCMRegistrar:sRetryReceiver	Lcom/google/android/gcm/GCMBroadcastReceiver;
        //   22: ldc 2
        //   24: monitorexit
        //   25: return
        //   26: astore_0
        //   27: aload_0
        //   28: invokevirtual 316	java/lang/Exception:printStackTrace	()V
        //   31: goto -9 -> 22
        //   34: astore_0
        //   35: ldc 2
        //   37: monitorexit
        //   38: aload_0
        //   39: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	40	0	paramContext	Context
        //   6	2	1	localGCMBroadcastReceiver	GCMBroadcastReceiver
        // Exception table:
        //   from	to	target	type
        //   11	22	26	java/lang/Exception
        //   3	7	34	finally
        //   11	22	34	finally
        //   27	31	34	finally
    }

    public static void register(Context paramContext, String... paramVarArgs) {
        setRetryBroadcastReceiver(paramContext);
        resetBackoff(paramContext);
        internalRegister(paramContext, paramVarArgs);
    }

    static void resetBackoff(Context paramContext) {
        Log.d("GCMRegistrar", "resetting backoff for " + paramContext.getPackageName());
        setBackoff(paramContext, 3000);
    }

    static void setBackoff(Context paramContext, int paramInt) {
        paramContext = getGCMPreferences(paramContext).edit();
        paramContext.putInt("backoff_ms", paramInt);
        paramContext.commit();
    }

    public static void setRegisteredOnServer(Context paramContext, boolean paramBoolean) {
        paramContext = getGCMPreferences(paramContext).edit();
        paramContext.putBoolean("onServer", paramBoolean);
        paramContext.commit();
    }

    static String setRegistrationId(Context paramContext, String paramString) {
        SharedPreferences localSharedPreferences = getGCMPreferences(paramContext);
        String str = localSharedPreferences.getString("regId", "");
        int i = getAppVersion(paramContext);
        paramContext = localSharedPreferences.edit();
        paramContext.putString("regId", paramString);
        paramContext.putInt("appVersion", i);
        paramContext.commit();
        return str;
    }

    private static void setRetryBroadcastReceiver(Context paramContext) {
        try {
            if (sRetryReceiver == null) {
                sRetryReceiver = new GCMBroadcastReceiver();
                String str = paramContext.getPackageName();
                IntentFilter localIntentFilter = new IntentFilter("com.google.android.gcm.intent.RETRY");
                localIntentFilter.addCategory(str);
                str = str + ".permission.C2D_MESSAGE";
                paramContext.registerReceiver(sRetryReceiver, localIntentFilter, str, null);
            }
            return;
        } finally {
            paramContext =finally;
            throw paramContext;
        }
    }

    public static void unregister(Context paramContext) {
        setRetryBroadcastReceiver(paramContext);
        resetBackoff(paramContext);
        internalUnregister(paramContext);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gcm/GCMRegistrar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */