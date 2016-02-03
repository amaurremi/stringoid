package com.google.android.gms.auth;

import android.accounts.AccountManager;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.internal.if;
import java.io.IOException;
import java.net.URISyntaxException;

public final class GoogleAuthUtil
{
  public static final int CHANGE_TYPE_ACCOUNT_ADDED = 1;
  public static final int CHANGE_TYPE_ACCOUNT_REMOVED = 2;
  public static final int CHANGE_TYPE_ACCOUNT_RENAMED_FROM = 3;
  public static final int CHANGE_TYPE_ACCOUNT_RENAMED_TO = 4;
  private static final ComponentName Dn;
  private static final ComponentName Do;
  private static final Intent Dp;
  private static final Intent Dq;
  public static final String GOOGLE_ACCOUNT_TYPE = "com.google";
  public static final String KEY_ANDROID_PACKAGE_NAME;
  public static final String KEY_CALLER_UID;
  public static final String KEY_REQUEST_ACTIONS = "request_visible_actions";
  @Deprecated
  public static final String KEY_REQUEST_VISIBLE_ACTIVITIES = "request_visible_actions";
  public static final String KEY_SUPPRESS_PROGRESS_SCREEN = "suppressProgressScreen";
  
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
      Dn = new ComponentName("com.google.android.gms", "com.google.android.gms.auth.GetToken");
      Do = new ComponentName("com.google.android.gms", "com.google.android.gms.recovery.RecoveryService");
      Dp = new Intent().setPackage("com.google.android.gms").setComponent(Dn);
      Dq = new Intent().setPackage("com.google.android.gms").setComponent(Do);
      return;
      break;
    }
  }
  
  private static void D(Context paramContext)
    throws GoogleAuthException
  {
    try
    {
      GooglePlayServicesUtil.D(paramContext);
      return;
    }
    catch (GooglePlayServicesRepairableException paramContext)
    {
      throw new GooglePlayServicesAvailabilityException(paramContext.getConnectionStatusCode(), paramContext.getMessage(), paramContext.getIntent());
    }
    catch (GooglePlayServicesNotAvailableException paramContext)
    {
      throw new GoogleAuthException(paramContext.getMessage());
    }
  }
  
  private static String a(Context paramContext, String paramString1, String paramString2, Bundle paramBundle)
    throws IOException, UserRecoverableNotifiedException, GoogleAuthException
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    try
    {
      paramString1 = getToken(paramContext, paramString1, paramString2, localBundle);
      return paramString1;
    }
    catch (GooglePlayServicesAvailabilityException paramString1)
    {
      int i = paramString1.getConnectionStatusCode();
      if (b(paramContext, i))
      {
        paramContext = new a(paramContext.getApplicationContext());
        paramContext.sendMessageDelayed(paramContext.obtainMessage(1), 30000L);
      }
      for (;;)
      {
        throw new UserRecoverableNotifiedException("User intervention required. Notification has been pushed.");
        GooglePlayServicesUtil.showErrorNotification(i, paramContext);
      }
    }
    catch (UserRecoverableAuthException paramContext)
    {
      throw new UserRecoverableNotifiedException("User intervention required. Notification has been pushed.");
    }
  }
  
  private static boolean aw(String paramString)
  {
    return ("NetworkError".equals(paramString)) || ("ServiceUnavailable".equals(paramString)) || ("Timeout".equals(paramString));
  }
  
  private static boolean ax(String paramString)
  {
    return ("BadAuthentication".equals(paramString)) || ("CaptchaRequired".equals(paramString)) || ("DeviceManagementRequiredOrSyncDisabled".equals(paramString)) || ("NeedPermission".equals(paramString)) || ("NeedsBrowser".equals(paramString)) || ("UserCancel".equals(paramString)) || ("AppDownloadRequired".equals(paramString)) || (if.DT.fu().equals(paramString)) || (if.DU.fu().equals(paramString)) || (if.DV.fu().equals(paramString)) || (if.DW.fu().equals(paramString)) || (if.DX.fu().equals(paramString)) || (if.DY.fu().equals(paramString));
  }
  
  private static boolean b(Context paramContext, int paramInt)
  {
    if (paramInt == 1)
    {
      paramContext = paramContext.getPackageManager();
      try
      {
        boolean bool = paramContext.getApplicationInfo("com.google.android.gms", 8192).enabled;
        if (bool) {
          return true;
        }
      }
      catch (PackageManager.NameNotFoundException paramContext) {}
    }
    return false;
  }
  
  /* Error */
  public static void clearToken(Context paramContext, String paramString)
    throws GooglePlayServicesAvailabilityException, GoogleAuthException, IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 143	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   4: astore_2
    //   5: ldc -13
    //   7: invokestatic 248	com/google/android/gms/common/internal/n:aU	(Ljava/lang/String;)V
    //   10: aload_2
    //   11: invokestatic 249	com/google/android/gms/auth/GoogleAuthUtil:D	(Landroid/content/Context;)V
    //   14: new 128	android/os/Bundle
    //   17: dup
    //   18: invokespecial 129	android/os/Bundle:<init>	()V
    //   21: astore_3
    //   22: aload_0
    //   23: invokevirtual 252	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   26: getfield 255	android/content/pm/ApplicationInfo:packageName	Ljava/lang/String;
    //   29: astore_0
    //   30: aload_3
    //   31: ldc_w 257
    //   34: aload_0
    //   35: invokevirtual 260	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   38: aload_3
    //   39: getstatic 51	com/google/android/gms/auth/GoogleAuthUtil:KEY_ANDROID_PACKAGE_NAME	Ljava/lang/String;
    //   42: invokevirtual 263	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   45: ifne +11 -> 56
    //   48: aload_3
    //   49: getstatic 51	com/google/android/gms/auth/GoogleAuthUtil:KEY_ANDROID_PACKAGE_NAME	Ljava/lang/String;
    //   52: aload_0
    //   53: invokevirtual 260	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   56: new 265	com/google/android/gms/common/a
    //   59: dup
    //   60: invokespecial 266	com/google/android/gms/common/a:<init>	()V
    //   63: astore_0
    //   64: aload_2
    //   65: getstatic 81	com/google/android/gms/auth/GoogleAuthUtil:Dp	Landroid/content/Intent;
    //   68: aload_0
    //   69: iconst_1
    //   70: invokevirtual 270	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   73: ifeq +94 -> 167
    //   76: aload_0
    //   77: invokevirtual 274	com/google/android/gms/common/a:fX	()Landroid/os/IBinder;
    //   80: invokestatic 279	com/google/android/gms/internal/r$a:a	(Landroid/os/IBinder;)Lcom/google/android/gms/internal/r;
    //   83: aload_1
    //   84: aload_3
    //   85: invokeinterface 284 3 0
    //   90: astore_1
    //   91: aload_1
    //   92: getstatic 287	com/google/android/gms/internal/if:Ev	Ljava/lang/String;
    //   95: invokevirtual 291	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   98: astore_3
    //   99: aload_1
    //   100: ldc_w 293
    //   103: invokevirtual 296	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   106: ifne +43 -> 149
    //   109: new 89	com/google/android/gms/auth/GoogleAuthException
    //   112: dup
    //   113: aload_3
    //   114: invokespecial 118	com/google/android/gms/auth/GoogleAuthException:<init>	(Ljava/lang/String;)V
    //   117: athrow
    //   118: astore_1
    //   119: ldc_w 298
    //   122: ldc_w 300
    //   125: aload_1
    //   126: invokestatic 306	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   129: pop
    //   130: new 122	java/io/IOException
    //   133: dup
    //   134: ldc_w 308
    //   137: invokespecial 309	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   140: athrow
    //   141: astore_1
    //   142: aload_2
    //   143: aload_0
    //   144: invokevirtual 313	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   147: aload_1
    //   148: athrow
    //   149: aload_2
    //   150: aload_0
    //   151: invokevirtual 313	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   154: return
    //   155: astore_1
    //   156: new 89	com/google/android/gms/auth/GoogleAuthException
    //   159: dup
    //   160: ldc_w 315
    //   163: invokespecial 118	com/google/android/gms/auth/GoogleAuthException:<init>	(Ljava/lang/String;)V
    //   166: athrow
    //   167: new 122	java/io/IOException
    //   170: dup
    //   171: ldc_w 317
    //   174: invokespecial 309	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   177: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	178	0	paramContext	Context
    //   0	178	1	paramString	String
    //   4	146	2	localContext	Context
    //   21	93	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   76	118	118	android/os/RemoteException
    //   76	118	141	finally
    //   119	141	141	finally
    //   156	167	141	finally
    //   76	118	155	java/lang/InterruptedException
  }
  
  /* Error */
  public static java.util.List<AccountChangeEvent> getAccountChangeEvents(Context paramContext, int paramInt, String paramString)
    throws GoogleAuthException, IOException
  {
    // Byte code:
    //   0: aload_2
    //   1: ldc_w 321
    //   4: invokestatic 324	com/google/android/gms/common/internal/n:b	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   7: pop
    //   8: ldc -13
    //   10: invokestatic 248	com/google/android/gms/common/internal/n:aU	(Ljava/lang/String;)V
    //   13: aload_0
    //   14: invokevirtual 143	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   17: astore_0
    //   18: aload_0
    //   19: invokestatic 249	com/google/android/gms/auth/GoogleAuthUtil:D	(Landroid/content/Context;)V
    //   22: new 265	com/google/android/gms/common/a
    //   25: dup
    //   26: invokespecial 266	com/google/android/gms/common/a:<init>	()V
    //   29: astore_3
    //   30: aload_0
    //   31: getstatic 81	com/google/android/gms/auth/GoogleAuthUtil:Dp	Landroid/content/Intent;
    //   34: aload_3
    //   35: iconst_1
    //   36: invokevirtual 270	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   39: ifeq +84 -> 123
    //   42: aload_3
    //   43: invokevirtual 274	com/google/android/gms/common/a:fX	()Landroid/os/IBinder;
    //   46: invokestatic 279	com/google/android/gms/internal/r$a:a	(Landroid/os/IBinder;)Lcom/google/android/gms/internal/r;
    //   49: new 326	com/google/android/gms/auth/AccountChangeEventsRequest
    //   52: dup
    //   53: invokespecial 327	com/google/android/gms/auth/AccountChangeEventsRequest:<init>	()V
    //   56: aload_2
    //   57: invokevirtual 331	com/google/android/gms/auth/AccountChangeEventsRequest:setAccountName	(Ljava/lang/String;)Lcom/google/android/gms/auth/AccountChangeEventsRequest;
    //   60: iload_1
    //   61: invokevirtual 335	com/google/android/gms/auth/AccountChangeEventsRequest:setEventIndex	(I)Lcom/google/android/gms/auth/AccountChangeEventsRequest;
    //   64: invokeinterface 338 2 0
    //   69: invokevirtual 344	com/google/android/gms/auth/AccountChangeEventsResponse:getEvents	()Ljava/util/List;
    //   72: astore_2
    //   73: aload_0
    //   74: aload_3
    //   75: invokevirtual 313	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   78: aload_2
    //   79: areturn
    //   80: astore_2
    //   81: ldc_w 298
    //   84: ldc_w 300
    //   87: aload_2
    //   88: invokestatic 306	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   91: pop
    //   92: new 122	java/io/IOException
    //   95: dup
    //   96: ldc_w 308
    //   99: invokespecial 309	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   102: athrow
    //   103: astore_2
    //   104: aload_0
    //   105: aload_3
    //   106: invokevirtual 313	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   109: aload_2
    //   110: athrow
    //   111: astore_2
    //   112: new 89	com/google/android/gms/auth/GoogleAuthException
    //   115: dup
    //   116: ldc_w 315
    //   119: invokespecial 118	com/google/android/gms/auth/GoogleAuthException:<init>	(Ljava/lang/String;)V
    //   122: athrow
    //   123: new 122	java/io/IOException
    //   126: dup
    //   127: ldc_w 317
    //   130: invokespecial 309	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   133: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	paramContext	Context
    //   0	134	1	paramInt	int
    //   0	134	2	paramString	String
    //   29	77	3	locala	com.google.android.gms.common.a
    // Exception table:
    //   from	to	target	type
    //   42	73	80	android/os/RemoteException
    //   42	73	103	finally
    //   81	103	103	finally
    //   112	123	103	finally
    //   42	73	111	java/lang/InterruptedException
  }
  
  public static String getAccountId(Context paramContext, String paramString)
    throws GoogleAuthException, IOException
  {
    n.b(paramString, "accountName must be provided");
    n.aU("Calling this from your main thread can lead to deadlock");
    D(paramContext.getApplicationContext());
    return getToken(paramContext, paramString, "^^_account_id_^^", new Bundle());
  }
  
  public static String getAppCert(Context paramContext, String paramString)
  {
    return "spatula";
  }
  
  public static String getToken(Context paramContext, String paramString1, String paramString2)
    throws IOException, UserRecoverableAuthException, GoogleAuthException
  {
    return getToken(paramContext, paramString1, paramString2, new Bundle());
  }
  
  /* Error */
  public static String getToken(Context paramContext, String paramString1, String paramString2, Bundle paramBundle)
    throws IOException, UserRecoverableAuthException, GoogleAuthException
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 143	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   4: astore 5
    //   6: ldc -13
    //   8: invokestatic 248	com/google/android/gms/common/internal/n:aU	(Ljava/lang/String;)V
    //   11: aload 5
    //   13: invokestatic 249	com/google/android/gms/auth/GoogleAuthUtil:D	(Landroid/content/Context;)V
    //   16: aload_3
    //   17: ifnonnull +109 -> 126
    //   20: new 128	android/os/Bundle
    //   23: dup
    //   24: invokespecial 129	android/os/Bundle:<init>	()V
    //   27: astore_3
    //   28: aload_0
    //   29: invokevirtual 252	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   32: getfield 255	android/content/pm/ApplicationInfo:packageName	Ljava/lang/String;
    //   35: astore_0
    //   36: aload_3
    //   37: ldc_w 257
    //   40: aload_0
    //   41: invokevirtual 260	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   44: aload_3
    //   45: getstatic 51	com/google/android/gms/auth/GoogleAuthUtil:KEY_ANDROID_PACKAGE_NAME	Ljava/lang/String;
    //   48: invokevirtual 263	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   51: ifne +11 -> 62
    //   54: aload_3
    //   55: getstatic 51	com/google/android/gms/auth/GoogleAuthUtil:KEY_ANDROID_PACKAGE_NAME	Ljava/lang/String;
    //   58: aload_0
    //   59: invokevirtual 260	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   62: new 265	com/google/android/gms/common/a
    //   65: dup
    //   66: invokespecial 266	com/google/android/gms/common/a:<init>	()V
    //   69: astore_0
    //   70: aload 5
    //   72: getstatic 81	com/google/android/gms/auth/GoogleAuthUtil:Dp	Landroid/content/Intent;
    //   75: aload_0
    //   76: iconst_1
    //   77: invokevirtual 270	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   80: ifeq +163 -> 243
    //   83: aload_0
    //   84: invokevirtual 274	com/google/android/gms/common/a:fX	()Landroid/os/IBinder;
    //   87: invokestatic 279	com/google/android/gms/internal/r$a:a	(Landroid/os/IBinder;)Lcom/google/android/gms/internal/r;
    //   90: aload_1
    //   91: aload_2
    //   92: aload_3
    //   93: invokeinterface 357 4 0
    //   98: astore_1
    //   99: aload_1
    //   100: ldc_w 359
    //   103: invokevirtual 291	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   106: astore_2
    //   107: aload_2
    //   108: invokestatic 365	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   111: istore 4
    //   113: iload 4
    //   115: ifne +23 -> 138
    //   118: aload 5
    //   120: aload_0
    //   121: invokevirtual 313	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   124: aload_2
    //   125: areturn
    //   126: new 128	android/os/Bundle
    //   129: dup
    //   130: aload_3
    //   131: invokespecial 368	android/os/Bundle:<init>	(Landroid/os/Bundle;)V
    //   134: astore_3
    //   135: goto -107 -> 28
    //   138: aload_1
    //   139: ldc_w 370
    //   142: invokevirtual 291	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   145: astore_2
    //   146: aload_1
    //   147: ldc_w 372
    //   150: invokevirtual 376	android/os/Bundle:getParcelable	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   153: checkcast 69	android/content/Intent
    //   156: astore_1
    //   157: aload_2
    //   158: invokestatic 378	com/google/android/gms/auth/GoogleAuthUtil:ax	(Ljava/lang/String;)Z
    //   161: ifeq +45 -> 206
    //   164: new 126	com/google/android/gms/auth/UserRecoverableAuthException
    //   167: dup
    //   168: aload_2
    //   169: aload_1
    //   170: invokespecial 381	com/google/android/gms/auth/UserRecoverableAuthException:<init>	(Ljava/lang/String;Landroid/content/Intent;)V
    //   173: athrow
    //   174: astore_1
    //   175: ldc_w 298
    //   178: ldc_w 300
    //   181: aload_1
    //   182: invokestatic 306	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   185: pop
    //   186: new 122	java/io/IOException
    //   189: dup
    //   190: ldc_w 308
    //   193: invokespecial 309	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   196: athrow
    //   197: astore_1
    //   198: aload 5
    //   200: aload_0
    //   201: invokevirtual 313	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   204: aload_1
    //   205: athrow
    //   206: aload_2
    //   207: invokestatic 383	com/google/android/gms/auth/GoogleAuthUtil:aw	(Ljava/lang/String;)Z
    //   210: ifeq +24 -> 234
    //   213: new 122	java/io/IOException
    //   216: dup
    //   217: aload_2
    //   218: invokespecial 309	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   221: athrow
    //   222: astore_1
    //   223: new 89	com/google/android/gms/auth/GoogleAuthException
    //   226: dup
    //   227: ldc_w 315
    //   230: invokespecial 118	com/google/android/gms/auth/GoogleAuthException:<init>	(Ljava/lang/String;)V
    //   233: athrow
    //   234: new 89	com/google/android/gms/auth/GoogleAuthException
    //   237: dup
    //   238: aload_2
    //   239: invokespecial 118	com/google/android/gms/auth/GoogleAuthException:<init>	(Ljava/lang/String;)V
    //   242: athrow
    //   243: new 122	java/io/IOException
    //   246: dup
    //   247: ldc_w 317
    //   250: invokespecial 309	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   253: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	254	0	paramContext	Context
    //   0	254	1	paramString1	String
    //   0	254	2	paramString2	String
    //   0	254	3	paramBundle	Bundle
    //   111	3	4	bool	boolean
    //   4	195	5	localContext	Context
    // Exception table:
    //   from	to	target	type
    //   83	113	174	android/os/RemoteException
    //   138	174	174	android/os/RemoteException
    //   206	222	174	android/os/RemoteException
    //   234	243	174	android/os/RemoteException
    //   83	113	197	finally
    //   138	174	197	finally
    //   175	197	197	finally
    //   206	222	197	finally
    //   223	234	197	finally
    //   234	243	197	finally
    //   83	113	222	java/lang/InterruptedException
    //   138	174	222	java/lang/InterruptedException
    //   206	222	222	java/lang/InterruptedException
    //   234	243	222	java/lang/InterruptedException
  }
  
  public static String getTokenWithNotification(Context paramContext, String paramString1, String paramString2, Bundle paramBundle)
    throws IOException, UserRecoverableNotifiedException, GoogleAuthException
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putBoolean("handle_notification", true);
    return a(paramContext, paramString1, paramString2, localBundle);
  }
  
  public static String getTokenWithNotification(Context paramContext, String paramString1, String paramString2, Bundle paramBundle, Intent paramIntent)
    throws IOException, UserRecoverableNotifiedException, GoogleAuthException
  {
    h(paramIntent);
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putParcelable("callback_intent", paramIntent);
    localBundle.putBoolean("handle_notification", true);
    return a(paramContext, paramString1, paramString2, localBundle);
  }
  
  public static String getTokenWithNotification(Context paramContext, String paramString1, String paramString2, Bundle paramBundle1, String paramString3, Bundle paramBundle2)
    throws IOException, UserRecoverableNotifiedException, GoogleAuthException
  {
    if (TextUtils.isEmpty(paramString3)) {
      throw new IllegalArgumentException("Authority cannot be empty or null.");
    }
    Bundle localBundle = paramBundle1;
    if (paramBundle1 == null) {
      localBundle = new Bundle();
    }
    paramBundle1 = paramBundle2;
    if (paramBundle2 == null) {
      paramBundle1 = new Bundle();
    }
    ContentResolver.validateSyncExtrasBundle(paramBundle1);
    localBundle.putString("authority", paramString3);
    localBundle.putBundle("sync_extras", paramBundle1);
    localBundle.putBoolean("handle_notification", true);
    return a(paramContext, paramString1, paramString2, localBundle);
  }
  
  private static void h(Intent paramIntent)
  {
    if (paramIntent == null) {
      throw new IllegalArgumentException("Callback cannot be null.");
    }
    paramIntent = paramIntent.toUri(1);
    try
    {
      Intent.parseUri(paramIntent, 1);
      return;
    }
    catch (URISyntaxException paramIntent)
    {
      throw new IllegalArgumentException("Parameter callback contains invalid data. It must be serializable using toUri() and parseUri().");
    }
  }
  
  @Deprecated
  public static void invalidateToken(Context paramContext, String paramString)
  {
    AccountManager.get(paramContext).invalidateAuthToken("com.google", paramString);
  }
  
  private static class a
    extends Handler
  {
    private final Context mD;
    
    a(Context paramContext) {}
    
    public void handleMessage(Message paramMessage)
    {
      if (paramMessage.what == 1)
      {
        int i = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.mD);
        if (GooglePlayServicesUtil.isUserRecoverableError(i)) {
          GooglePlayServicesUtil.showErrorNotification(i, this.mD);
        }
        return;
      }
      Log.wtf("GoogleAuthUtil", "Don't know how to handle this message: " + paramMessage.what);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/auth/GoogleAuthUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */