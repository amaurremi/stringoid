package com.google.android.gms.auth;

import android.accounts.AccountManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.d;

public final class a
{
  public static final String KEY_ANDROID_PACKAGE_NAME;
  public static final String KEY_CALLER_UID;
  private static final ComponentName qd;
  private static final ComponentName qe;
  private static final Intent qf;
  private static final Intent qg;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      KEY_CALLER_UID = "callerUid";
      if (Build.VERSION.SDK_INT < 14) {
        break label100;
      }
    }
    label100:
    for (;;)
    {
      KEY_ANDROID_PACKAGE_NAME = "androidPackageName";
      qd = new ComponentName("com.google.android.gms", "com.google.android.gms.auth.GetToken");
      qe = new ComponentName("com.google.android.gms", "com.google.android.gms.recovery.RecoveryService");
      qf = new Intent().setPackage("com.google.android.gms").setComponent(qd);
      qg = new Intent().setPackage("com.google.android.gms").setComponent(qe);
      return;
      break;
    }
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2)
  {
    return a(paramContext, paramString1, paramString2, new Bundle());
  }
  
  /* Error */
  public static String a(Context paramContext, String paramString1, String paramString2, Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 80	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   4: astore 5
    //   6: ldc 82
    //   8: invokestatic 88	com/google/android/gms/internal/dc:aI	(Ljava/lang/String;)V
    //   11: aload 5
    //   13: invokestatic 92	com/google/android/gms/auth/a:v	(Landroid/content/Context;)V
    //   16: aload_3
    //   17: ifnonnull +107 -> 124
    //   20: new 66	android/os/Bundle
    //   23: dup
    //   24: invokespecial 67	android/os/Bundle:<init>	()V
    //   27: astore_3
    //   28: aload_0
    //   29: invokevirtual 96	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   32: getfield 101	android/content/pm/ApplicationInfo:packageName	Ljava/lang/String;
    //   35: astore_0
    //   36: aload_3
    //   37: ldc 103
    //   39: aload_0
    //   40: invokevirtual 106	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   43: aload_3
    //   44: getstatic 29	com/google/android/gms/auth/a:KEY_ANDROID_PACKAGE_NAME	Ljava/lang/String;
    //   47: invokevirtual 110	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   50: ifne +11 -> 61
    //   53: aload_3
    //   54: getstatic 29	com/google/android/gms/auth/a:KEY_ANDROID_PACKAGE_NAME	Ljava/lang/String;
    //   57: aload_0
    //   58: invokevirtual 106	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   61: new 112	com/google/android/gms/common/e
    //   64: dup
    //   65: invokespecial 113	com/google/android/gms/common/e:<init>	()V
    //   68: astore_0
    //   69: aload 5
    //   71: getstatic 59	com/google/android/gms/auth/a:qf	Landroid/content/Intent;
    //   74: aload_0
    //   75: iconst_1
    //   76: invokevirtual 117	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   79: ifeq +156 -> 235
    //   82: aload_0
    //   83: invokevirtual 121	com/google/android/gms/common/e:ml	()Landroid/os/IBinder;
    //   86: invokestatic 127	com/google/android/gms/internal/gs$a:F	(Landroid/os/IBinder;)Lcom/google/android/gms/internal/gs;
    //   89: aload_1
    //   90: aload_2
    //   91: aload_3
    //   92: invokeinterface 132 4 0
    //   97: astore_1
    //   98: aload_1
    //   99: ldc -122
    //   101: invokevirtual 138	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   104: astore_2
    //   105: aload_2
    //   106: invokestatic 144	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   109: istore 4
    //   111: iload 4
    //   113: ifne +23 -> 136
    //   116: aload 5
    //   118: aload_0
    //   119: invokevirtual 148	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   122: aload_2
    //   123: areturn
    //   124: new 66	android/os/Bundle
    //   127: dup
    //   128: aload_3
    //   129: invokespecial 151	android/os/Bundle:<init>	(Landroid/os/Bundle;)V
    //   132: astore_3
    //   133: goto -105 -> 28
    //   136: aload_1
    //   137: ldc -103
    //   139: invokevirtual 138	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   142: astore_2
    //   143: aload_1
    //   144: ldc -101
    //   146: invokevirtual 159	android/os/Bundle:getParcelable	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   149: checkcast 47	android/content/Intent
    //   152: astore_1
    //   153: aload_2
    //   154: invokestatic 162	com/google/android/gms/auth/a:am	(Ljava/lang/String;)Z
    //   157: ifeq +42 -> 199
    //   160: new 164	com/google/android/gms/auth/UserRecoverableAuthException
    //   163: dup
    //   164: aload_2
    //   165: aload_1
    //   166: invokespecial 167	com/google/android/gms/auth/UserRecoverableAuthException:<init>	(Ljava/lang/String;Landroid/content/Intent;)V
    //   169: athrow
    //   170: astore_1
    //   171: ldc -87
    //   173: ldc -85
    //   175: aload_1
    //   176: invokestatic 177	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   179: pop
    //   180: new 179	java/io/IOException
    //   183: dup
    //   184: ldc -75
    //   186: invokespecial 183	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   189: athrow
    //   190: astore_1
    //   191: aload 5
    //   193: aload_0
    //   194: invokevirtual 148	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   197: aload_1
    //   198: athrow
    //   199: aload_2
    //   200: invokestatic 186	com/google/android/gms/auth/a:al	(Ljava/lang/String;)Z
    //   203: ifeq +23 -> 226
    //   206: new 179	java/io/IOException
    //   209: dup
    //   210: aload_2
    //   211: invokespecial 183	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   214: athrow
    //   215: astore_1
    //   216: new 188	com/google/android/gms/auth/GoogleAuthException
    //   219: dup
    //   220: ldc -66
    //   222: invokespecial 191	com/google/android/gms/auth/GoogleAuthException:<init>	(Ljava/lang/String;)V
    //   225: athrow
    //   226: new 188	com/google/android/gms/auth/GoogleAuthException
    //   229: dup
    //   230: aload_2
    //   231: invokespecial 191	com/google/android/gms/auth/GoogleAuthException:<init>	(Ljava/lang/String;)V
    //   234: athrow
    //   235: new 179	java/io/IOException
    //   238: dup
    //   239: ldc -63
    //   241: invokespecial 183	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   244: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	245	0	paramContext	Context
    //   0	245	1	paramString1	String
    //   0	245	2	paramString2	String
    //   0	245	3	paramBundle	Bundle
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
  
  private static boolean al(String paramString)
  {
    return ("NetworkError".equals(paramString)) || ("ServiceUnavailable".equals(paramString)) || ("Timeout".equals(paramString));
  }
  
  private static boolean am(String paramString)
  {
    return ("BadAuthentication".equals(paramString)) || ("CaptchaRequired".equals(paramString)) || ("DeviceManagementRequiredOrSyncDisabled".equals(paramString)) || ("NeedPermission".equals(paramString)) || ("NeedsBrowser".equals(paramString)) || ("UserCancel".equals(paramString)) || ("AppDownloadRequired".equals(paramString));
  }
  
  @Deprecated
  public static void d(Context paramContext, String paramString)
  {
    AccountManager.get(paramContext).invalidateAuthToken("com.google", paramString);
  }
  
  private static void v(Context paramContext)
  {
    try
    {
      d.v(paramContext);
      return;
    }
    catch (GooglePlayServicesRepairableException paramContext)
    {
      throw new GooglePlayServicesAvailabilityException(paramContext.mj(), paramContext.getMessage(), paramContext.getIntent());
    }
    catch (GooglePlayServicesNotAvailableException paramContext)
    {
      throw new GoogleAuthException(paramContext.getMessage());
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/auth/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */