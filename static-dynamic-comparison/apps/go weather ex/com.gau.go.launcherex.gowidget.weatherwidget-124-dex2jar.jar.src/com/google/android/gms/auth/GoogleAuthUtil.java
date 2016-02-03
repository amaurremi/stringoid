package com.google.android.gms.auth;

import android.accounts.AccountManager;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import java.io.IOException;
import java.net.URISyntaxException;

public final class GoogleAuthUtil
{
  public static final String GOOGLE_ACCOUNT_TYPE = "com.google";
  public static final String KEY_ANDROID_PACKAGE_NAME;
  public static final String KEY_CALLER_UID;
  public static final String KEY_REQUEST_ACTIONS = "request_visible_actions";
  @Deprecated
  public static final String KEY_REQUEST_VISIBLE_ACTIVITIES = "request_visible_actions";
  public static final String KEY_SUPPRESS_PROGRESS_SCREEN = "suppressProgressScreen";
  private static final ComponentName wM;
  private static final ComponentName wN;
  private static final Intent wO;
  private static final Intent wP;
  
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
      wM = new ComponentName("com.google.android.gms", "com.google.android.gms.auth.GetToken");
      wN = new ComponentName("com.google.android.gms", "com.google.android.gms.recovery.RecoveryService");
      wO = new Intent().setPackage("com.google.android.gms").setComponent(wM);
      wP = new Intent().setPackage("com.google.android.gms").setComponent(wN);
      return;
      break;
    }
  }
  
  private static boolean P(String paramString)
  {
    return ("NetworkError".equals(paramString)) || ("ServiceUnavailable".equals(paramString)) || ("Timeout".equals(paramString));
  }
  
  private static boolean Q(String paramString)
  {
    return ("BadAuthentication".equals(paramString)) || ("CaptchaRequired".equals(paramString)) || ("DeviceManagementRequiredOrSyncDisabled".equals(paramString)) || ("NeedPermission".equals(paramString)) || ("NeedsBrowser".equals(paramString)) || ("UserCancel".equals(paramString)) || ("AppDownloadRequired".equals(paramString));
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
      GooglePlayServicesUtil.showErrorNotification(paramString1.getConnectionStatusCode(), paramContext);
      throw new UserRecoverableNotifiedException("User intervention required. Notification has been pushed.");
    }
    catch (UserRecoverableAuthException paramContext)
    {
      throw new UserRecoverableNotifiedException("User intervention required. Notification has been pushed.");
    }
  }
  
  private static void b(Intent paramIntent)
  {
    if (paramIntent == null) {
      throw new IllegalArgumentException("Callack cannot be null.");
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
  
  /* Error */
  public static void clearToken(Context paramContext, String paramString)
    throws GooglePlayServicesAvailabilityException, GoogleAuthException, IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 168	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   4: astore_2
    //   5: ldc -86
    //   7: invokestatic 175	com/google/android/gms/internal/fq:ak	(Ljava/lang/String;)V
    //   10: aload_2
    //   11: invokestatic 179	com/google/android/gms/auth/GoogleAuthUtil:s	(Landroid/content/Context;)V
    //   14: new 117	android/os/Bundle
    //   17: dup
    //   18: invokespecial 118	android/os/Bundle:<init>	()V
    //   21: astore_3
    //   22: aload_0
    //   23: invokevirtual 183	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   26: getfield 188	android/content/pm/ApplicationInfo:packageName	Ljava/lang/String;
    //   29: astore_0
    //   30: aload_3
    //   31: ldc -66
    //   33: aload_0
    //   34: invokevirtual 193	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   37: aload_3
    //   38: getstatic 40	com/google/android/gms/auth/GoogleAuthUtil:KEY_ANDROID_PACKAGE_NAME	Ljava/lang/String;
    //   41: invokevirtual 196	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   44: ifne +11 -> 55
    //   47: aload_3
    //   48: getstatic 40	com/google/android/gms/auth/GoogleAuthUtil:KEY_ANDROID_PACKAGE_NAME	Ljava/lang/String;
    //   51: aload_0
    //   52: invokevirtual 193	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   55: new 198	com/google/android/gms/common/a
    //   58: dup
    //   59: invokespecial 199	com/google/android/gms/common/a:<init>	()V
    //   62: astore_0
    //   63: aload_2
    //   64: getstatic 70	com/google/android/gms/auth/GoogleAuthUtil:wO	Landroid/content/Intent;
    //   67: aload_0
    //   68: iconst_1
    //   69: invokevirtual 203	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   72: ifeq +89 -> 161
    //   75: aload_0
    //   76: invokevirtual 207	com/google/android/gms/common/a:dV	()Landroid/os/IBinder;
    //   79: invokestatic 212	com/google/android/gms/internal/s$a:a	(Landroid/os/IBinder;)Lcom/google/android/gms/internal/s;
    //   82: aload_1
    //   83: aload_3
    //   84: invokeinterface 217 3 0
    //   89: astore_1
    //   90: aload_1
    //   91: getstatic 222	com/google/android/gms/internal/el:xD	Ljava/lang/String;
    //   94: invokevirtual 226	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   97: astore_3
    //   98: aload_1
    //   99: ldc -28
    //   101: invokevirtual 231	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   104: ifne +40 -> 144
    //   107: new 111	com/google/android/gms/auth/GoogleAuthException
    //   110: dup
    //   111: aload_3
    //   112: invokespecial 232	com/google/android/gms/auth/GoogleAuthException:<init>	(Ljava/lang/String;)V
    //   115: athrow
    //   116: astore_1
    //   117: ldc -22
    //   119: ldc -20
    //   121: aload_1
    //   122: invokestatic 242	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   125: pop
    //   126: new 107	java/io/IOException
    //   129: dup
    //   130: ldc -12
    //   132: invokespecial 245	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   135: athrow
    //   136: astore_1
    //   137: aload_2
    //   138: aload_0
    //   139: invokevirtual 249	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   142: aload_1
    //   143: athrow
    //   144: aload_2
    //   145: aload_0
    //   146: invokevirtual 249	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   149: return
    //   150: astore_1
    //   151: new 111	com/google/android/gms/auth/GoogleAuthException
    //   154: dup
    //   155: ldc -5
    //   157: invokespecial 232	com/google/android/gms/auth/GoogleAuthException:<init>	(Ljava/lang/String;)V
    //   160: athrow
    //   161: new 107	java/io/IOException
    //   164: dup
    //   165: ldc -3
    //   167: invokespecial 245	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   170: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	171	0	paramContext	Context
    //   0	171	1	paramString	String
    //   4	141	2	localContext	Context
    //   21	91	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   75	116	116	android/os/RemoteException
    //   75	116	136	finally
    //   117	136	136	finally
    //   151	161	136	finally
    //   75	116	150	java/lang/InterruptedException
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
    //   1: invokevirtual 168	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   4: astore 5
    //   6: ldc -86
    //   8: invokestatic 175	com/google/android/gms/internal/fq:ak	(Ljava/lang/String;)V
    //   11: aload 5
    //   13: invokestatic 179	com/google/android/gms/auth/GoogleAuthUtil:s	(Landroid/content/Context;)V
    //   16: aload_3
    //   17: ifnonnull +108 -> 125
    //   20: new 117	android/os/Bundle
    //   23: dup
    //   24: invokespecial 118	android/os/Bundle:<init>	()V
    //   27: astore_3
    //   28: aload_0
    //   29: invokevirtual 183	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   32: getfield 188	android/content/pm/ApplicationInfo:packageName	Ljava/lang/String;
    //   35: astore_0
    //   36: aload_3
    //   37: ldc -66
    //   39: aload_0
    //   40: invokevirtual 193	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   43: aload_3
    //   44: getstatic 40	com/google/android/gms/auth/GoogleAuthUtil:KEY_ANDROID_PACKAGE_NAME	Ljava/lang/String;
    //   47: invokevirtual 196	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   50: ifne +11 -> 61
    //   53: aload_3
    //   54: getstatic 40	com/google/android/gms/auth/GoogleAuthUtil:KEY_ANDROID_PACKAGE_NAME	Ljava/lang/String;
    //   57: aload_0
    //   58: invokevirtual 193	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   61: new 198	com/google/android/gms/common/a
    //   64: dup
    //   65: invokespecial 199	com/google/android/gms/common/a:<init>	()V
    //   68: astore_0
    //   69: aload 5
    //   71: getstatic 70	com/google/android/gms/auth/GoogleAuthUtil:wO	Landroid/content/Intent;
    //   74: aload_0
    //   75: iconst_1
    //   76: invokevirtual 203	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   79: ifeq +159 -> 238
    //   82: aload_0
    //   83: invokevirtual 207	com/google/android/gms/common/a:dV	()Landroid/os/IBinder;
    //   86: invokestatic 212	com/google/android/gms/internal/s$a:a	(Landroid/os/IBinder;)Lcom/google/android/gms/internal/s;
    //   89: aload_1
    //   90: aload_2
    //   91: aload_3
    //   92: invokeinterface 257 4 0
    //   97: astore_1
    //   98: aload_1
    //   99: ldc_w 259
    //   102: invokevirtual 226	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   105: astore_2
    //   106: aload_2
    //   107: invokestatic 265	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   110: istore 4
    //   112: iload 4
    //   114: ifne +23 -> 137
    //   117: aload 5
    //   119: aload_0
    //   120: invokevirtual 249	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   123: aload_2
    //   124: areturn
    //   125: new 117	android/os/Bundle
    //   128: dup
    //   129: aload_3
    //   130: invokespecial 268	android/os/Bundle:<init>	(Landroid/os/Bundle;)V
    //   133: astore_3
    //   134: goto -106 -> 28
    //   137: aload_1
    //   138: ldc_w 270
    //   141: invokevirtual 226	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   144: astore_2
    //   145: aload_1
    //   146: ldc_w 272
    //   149: invokevirtual 276	android/os/Bundle:getParcelable	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   152: checkcast 58	android/content/Intent
    //   155: astore_1
    //   156: aload_2
    //   157: invokestatic 278	com/google/android/gms/auth/GoogleAuthUtil:Q	(Ljava/lang/String;)Z
    //   160: ifeq +42 -> 202
    //   163: new 115	com/google/android/gms/auth/UserRecoverableAuthException
    //   166: dup
    //   167: aload_2
    //   168: aload_1
    //   169: invokespecial 281	com/google/android/gms/auth/UserRecoverableAuthException:<init>	(Ljava/lang/String;Landroid/content/Intent;)V
    //   172: athrow
    //   173: astore_1
    //   174: ldc -22
    //   176: ldc -20
    //   178: aload_1
    //   179: invokestatic 242	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   182: pop
    //   183: new 107	java/io/IOException
    //   186: dup
    //   187: ldc -12
    //   189: invokespecial 245	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   192: athrow
    //   193: astore_1
    //   194: aload 5
    //   196: aload_0
    //   197: invokevirtual 249	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   200: aload_1
    //   201: athrow
    //   202: aload_2
    //   203: invokestatic 283	com/google/android/gms/auth/GoogleAuthUtil:P	(Ljava/lang/String;)Z
    //   206: ifeq +23 -> 229
    //   209: new 107	java/io/IOException
    //   212: dup
    //   213: aload_2
    //   214: invokespecial 245	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   217: athrow
    //   218: astore_1
    //   219: new 111	com/google/android/gms/auth/GoogleAuthException
    //   222: dup
    //   223: ldc -5
    //   225: invokespecial 232	com/google/android/gms/auth/GoogleAuthException:<init>	(Ljava/lang/String;)V
    //   228: athrow
    //   229: new 111	com/google/android/gms/auth/GoogleAuthException
    //   232: dup
    //   233: aload_2
    //   234: invokespecial 232	com/google/android/gms/auth/GoogleAuthException:<init>	(Ljava/lang/String;)V
    //   237: athrow
    //   238: new 107	java/io/IOException
    //   241: dup
    //   242: ldc -3
    //   244: invokespecial 245	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   247: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	248	0	paramContext	Context
    //   0	248	1	paramString1	String
    //   0	248	2	paramString2	String
    //   0	248	3	paramBundle	Bundle
    //   110	3	4	bool	boolean
    //   4	191	5	localContext	Context
    // Exception table:
    //   from	to	target	type
    //   82	112	173	android/os/RemoteException
    //   137	173	173	android/os/RemoteException
    //   202	218	173	android/os/RemoteException
    //   229	238	173	android/os/RemoteException
    //   82	112	193	finally
    //   137	173	193	finally
    //   174	193	193	finally
    //   202	218	193	finally
    //   219	229	193	finally
    //   229	238	193	finally
    //   82	112	218	java/lang/InterruptedException
    //   137	173	218	java/lang/InterruptedException
    //   202	218	218	java/lang/InterruptedException
    //   229	238	218	java/lang/InterruptedException
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
    b(paramIntent);
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
  
  @Deprecated
  public static void invalidateToken(Context paramContext, String paramString)
  {
    AccountManager.get(paramContext).invalidateAuthToken("com.google", paramString);
  }
  
  private static void s(Context paramContext)
    throws GooglePlayServicesAvailabilityException, GoogleAuthException
  {
    try
    {
      GooglePlayServicesUtil.s(paramContext);
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
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/auth/GoogleAuthUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */