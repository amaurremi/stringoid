package com.google.android.gms.auth;

import android.accounts.AccountManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.R.string;
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
  public static final String KEY_CLIENT_PACKAGE_NAME = "clientPackageName";
  public static final String KEY_REQUEST_ACTIONS = "request_visible_actions";
  @Deprecated
  public static final String KEY_REQUEST_VISIBLE_ACTIVITIES = "request_visible_actions";
  public static final String KEY_SUPPRESS_PROGRESS_SCREEN = "suppressProgressScreen";
  public static final String OEM_ONLY_KEY_TARGET_ANDROID_ID = "oauth2_target_device_id";
  public static final String OEM_ONLY_KEY_VERIFIER = "oauth2_authcode_verifier";
  public static final String OEM_ONLY_SCOPE_ACCOUNT_BOOTSTRAP = "_account_setup";
  private static final ComponentName kb;
  private static final ComponentName kc;
  private static final Intent kd;
  private static final Intent ke;
  
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
      kb = new ComponentName("com.google.android.gms", "com.google.android.gms.auth.GetToken");
      kc = new ComponentName("com.google.android.gms", "com.google.android.gms.recovery.RecoveryService");
      kd = new Intent().setPackage("com.google.android.gms").setComponent(kb);
      ke = new Intent().setPackage("com.google.android.gms").setComponent(kc);
      return;
      break;
    }
  }
  
  private static String a(Context paramContext, String paramString1, String paramString2, Bundle paramBundle)
    throws IOException, UserRecoverableNotifiedException, GoogleAuthException
  {
    Object localObject = paramBundle;
    if (paramBundle == null) {
      localObject = new Bundle();
    }
    try
    {
      paramString1 = getToken(paramContext, paramString1, paramString2, (Bundle)localObject);
      return paramString1;
    }
    catch (GooglePlayServicesAvailabilityException paramBundle)
    {
      localObject = GooglePlayServicesUtil.getErrorPendingIntent(paramBundle.getConnectionStatusCode(), paramContext, 0);
      Resources localResources = paramContext.getResources();
      Notification localNotification = new Notification(17301642, localResources.getString(R.string.auth_client_play_services_err_notification_msg), System.currentTimeMillis());
      localNotification.flags |= 0x10;
      paramString2 = paramContext.getApplicationInfo().name;
      paramString1 = paramString2;
      PackageManager localPackageManager;
      if (TextUtils.isEmpty(paramString2))
      {
        paramString1 = paramContext.getPackageName();
        localPackageManager = paramContext.getApplicationContext().getPackageManager();
      }
      try
      {
        paramString2 = localPackageManager.getApplicationInfo(paramContext.getPackageName(), 0);
        if (paramString2 != null) {
          paramString1 = localPackageManager.getApplicationLabel(paramString2).toString();
        }
        paramString1 = localResources.getString(R.string.auth_client_requested_by_msg, new Object[] { paramString1 });
        switch (paramBundle.getConnectionStatusCode())
        {
        default: 
          i = R.string.auth_client_using_bad_version_title;
          localNotification.setLatestEventInfo(paramContext, localResources.getString(i), paramString1, (PendingIntent)localObject);
          ((NotificationManager)paramContext.getSystemService("notification")).notify(39789, localNotification);
          throw new UserRecoverableNotifiedException("User intervention required. Notification has been pushed.");
        }
      }
      catch (PackageManager.NameNotFoundException paramString2)
      {
        for (;;)
        {
          paramString2 = null;
          continue;
          int i = R.string.auth_client_needs_installation_title;
          continue;
          i = R.string.auth_client_needs_update_title;
          continue;
          i = R.string.auth_client_needs_enabling_title;
        }
      }
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
    //   1: invokevirtual 171	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   4: astore 5
    //   6: ldc -3
    //   8: invokestatic 258	com/google/android/gms/internal/eg:O	(Ljava/lang/String;)V
    //   11: aload 5
    //   13: invokestatic 262	com/google/android/gms/auth/GoogleAuthUtil:m	(Landroid/content/Context;)V
    //   16: aload_3
    //   17: ifnonnull +108 -> 125
    //   20: new 102	android/os/Bundle
    //   23: dup
    //   24: invokespecial 103	android/os/Bundle:<init>	()V
    //   27: astore_3
    //   28: aload_0
    //   29: invokevirtual 152	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   32: getfield 265	android/content/pm/ApplicationInfo:packageName	Ljava/lang/String;
    //   35: astore_0
    //   36: aload_3
    //   37: ldc 13
    //   39: aload_0
    //   40: invokevirtual 268	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   43: aload_3
    //   44: getstatic 52	com/google/android/gms/auth/GoogleAuthUtil:KEY_ANDROID_PACKAGE_NAME	Ljava/lang/String;
    //   47: invokevirtual 272	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   50: ifne +11 -> 61
    //   53: aload_3
    //   54: getstatic 52	com/google/android/gms/auth/GoogleAuthUtil:KEY_ANDROID_PACKAGE_NAME	Ljava/lang/String;
    //   57: aload_0
    //   58: invokevirtual 268	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   61: new 274	com/google/android/gms/common/a
    //   64: dup
    //   65: invokespecial 275	com/google/android/gms/common/a:<init>	()V
    //   68: astore_0
    //   69: aload 5
    //   71: getstatic 82	com/google/android/gms/auth/GoogleAuthUtil:kd	Landroid/content/Intent;
    //   74: aload_0
    //   75: iconst_1
    //   76: invokevirtual 279	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   79: ifeq +163 -> 242
    //   82: aload_0
    //   83: invokevirtual 283	com/google/android/gms/common/a:bg	()Landroid/os/IBinder;
    //   86: invokestatic 288	com/google/android/gms/internal/o$a:a	(Landroid/os/IBinder;)Lcom/google/android/gms/internal/o;
    //   89: aload_1
    //   90: aload_2
    //   91: aload_3
    //   92: invokeinterface 293 4 0
    //   97: astore_1
    //   98: aload_1
    //   99: ldc_w 295
    //   102: invokevirtual 298	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   105: astore_2
    //   106: aload_2
    //   107: invokestatic 163	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   110: istore 4
    //   112: iload 4
    //   114: ifne +23 -> 137
    //   117: aload 5
    //   119: aload_0
    //   120: invokevirtual 302	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   123: aload_2
    //   124: areturn
    //   125: new 102	android/os/Bundle
    //   128: dup
    //   129: aload_3
    //   130: invokespecial 305	android/os/Bundle:<init>	(Landroid/os/Bundle;)V
    //   133: astore_3
    //   134: goto -106 -> 28
    //   137: aload_1
    //   138: ldc_w 307
    //   141: invokevirtual 298	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   144: astore_2
    //   145: aload_1
    //   146: ldc_w 309
    //   149: invokevirtual 313	android/os/Bundle:getParcelable	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   152: checkcast 70	android/content/Intent
    //   155: astore_1
    //   156: aload_2
    //   157: invokestatic 316	com/google/android/gms/auth/GoogleAuthUtil:x	(Ljava/lang/String;)Z
    //   160: ifeq +45 -> 205
    //   163: new 98	com/google/android/gms/auth/UserRecoverableAuthException
    //   166: dup
    //   167: aload_2
    //   168: aload_1
    //   169: invokespecial 319	com/google/android/gms/auth/UserRecoverableAuthException:<init>	(Ljava/lang/String;Landroid/content/Intent;)V
    //   172: athrow
    //   173: astore_1
    //   174: ldc_w 321
    //   177: ldc_w 323
    //   180: aload_1
    //   181: invokestatic 329	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   184: pop
    //   185: new 90	java/io/IOException
    //   188: dup
    //   189: ldc_w 331
    //   192: invokespecial 332	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   195: athrow
    //   196: astore_1
    //   197: aload 5
    //   199: aload_0
    //   200: invokevirtual 302	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   203: aload_1
    //   204: athrow
    //   205: aload_2
    //   206: invokestatic 335	com/google/android/gms/auth/GoogleAuthUtil:w	(Ljava/lang/String;)Z
    //   209: ifeq +24 -> 233
    //   212: new 90	java/io/IOException
    //   215: dup
    //   216: aload_2
    //   217: invokespecial 332	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   220: athrow
    //   221: astore_1
    //   222: new 94	com/google/android/gms/auth/GoogleAuthException
    //   225: dup
    //   226: ldc_w 337
    //   229: invokespecial 338	com/google/android/gms/auth/GoogleAuthException:<init>	(Ljava/lang/String;)V
    //   232: athrow
    //   233: new 94	com/google/android/gms/auth/GoogleAuthException
    //   236: dup
    //   237: aload_2
    //   238: invokespecial 338	com/google/android/gms/auth/GoogleAuthException:<init>	(Ljava/lang/String;)V
    //   241: athrow
    //   242: new 90	java/io/IOException
    //   245: dup
    //   246: ldc_w 340
    //   249: invokespecial 332	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   252: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	253	0	paramContext	Context
    //   0	253	1	paramString1	String
    //   0	253	2	paramString2	String
    //   0	253	3	paramBundle	Bundle
    //   110	3	4	bool	boolean
    //   4	194	5	localContext	Context
    // Exception table:
    //   from	to	target	type
    //   82	112	173	android/os/RemoteException
    //   137	173	173	android/os/RemoteException
    //   205	221	173	android/os/RemoteException
    //   233	242	173	android/os/RemoteException
    //   82	112	196	finally
    //   137	173	196	finally
    //   174	196	196	finally
    //   205	221	196	finally
    //   222	233	196	finally
    //   233	242	196	finally
    //   82	112	221	java/lang/InterruptedException
    //   137	173	221	java/lang/InterruptedException
    //   205	221	221	java/lang/InterruptedException
    //   233	242	221	java/lang/InterruptedException
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
  
  public static void invalidateToken(Context paramContext, String paramString)
  {
    AccountManager.get(paramContext).invalidateAuthToken("com.google", paramString);
  }
  
  private static void m(Context paramContext)
    throws GooglePlayServicesAvailabilityException, GoogleAuthException
  {
    try
    {
      GooglePlayServicesUtil.m(paramContext);
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
  
  private static boolean w(String paramString)
  {
    return ("NetworkError".equals(paramString)) || ("ServiceUnavailable".equals(paramString)) || ("Timeout".equals(paramString));
  }
  
  private static boolean x(String paramString)
  {
    return ("BadAuthentication".equals(paramString)) || ("CaptchaRequired".equals(paramString)) || ("DeviceManagementRequiredOrSyncDisabled".equals(paramString)) || ("NeedPermission".equals(paramString)) || ("NeedsBrowser".equals(paramString)) || ("UserCancel".equals(paramString)) || ("AppDownloadRequired".equals(paramString));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/auth/GoogleAuthUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */