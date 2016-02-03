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
  private static final ComponentName yR;
  private static final ComponentName yS;
  private static final Intent yT;
  private static final Intent yU;
  
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
      yR = new ComponentName("com.google.android.gms", "com.google.android.gms.auth.GetToken");
      yS = new ComponentName("com.google.android.gms", "com.google.android.gms.recovery.RecoveryService");
      yT = new Intent().setPackage("com.google.android.gms").setComponent(yR);
      yU = new Intent().setPackage("com.google.android.gms").setComponent(yS);
      return;
      break;
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
  
  private static boolean ac(String paramString)
  {
    return ("NetworkError".equals(paramString)) || ("ServiceUnavailable".equals(paramString)) || ("Timeout".equals(paramString));
  }
  
  private static boolean ad(String paramString)
  {
    return ("BadAuthentication".equals(paramString)) || ("CaptchaRequired".equals(paramString)) || ("DeviceManagementRequiredOrSyncDisabled".equals(paramString)) || ("NeedPermission".equals(paramString)) || ("NeedsBrowser".equals(paramString)) || ("UserCancel".equals(paramString)) || ("AppDownloadRequired".equals(paramString));
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
    //   1: invokevirtual 108	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   4: astore_2
    //   5: ldc -66
    //   7: invokestatic 195	com/google/android/gms/internal/hn:az	(Ljava/lang/String;)V
    //   10: aload_2
    //   11: invokestatic 198	com/google/android/gms/auth/GoogleAuthUtil:w	(Landroid/content/Context;)V
    //   14: new 90	android/os/Bundle
    //   17: dup
    //   18: invokespecial 91	android/os/Bundle:<init>	()V
    //   21: astore_3
    //   22: aload_0
    //   23: invokevirtual 201	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   26: getfield 204	android/content/pm/ApplicationInfo:packageName	Ljava/lang/String;
    //   29: astore_0
    //   30: aload_3
    //   31: ldc -50
    //   33: aload_0
    //   34: invokevirtual 209	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   37: aload_3
    //   38: getstatic 43	com/google/android/gms/auth/GoogleAuthUtil:KEY_ANDROID_PACKAGE_NAME	Ljava/lang/String;
    //   41: invokevirtual 212	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   44: ifne +11 -> 55
    //   47: aload_3
    //   48: getstatic 43	com/google/android/gms/auth/GoogleAuthUtil:KEY_ANDROID_PACKAGE_NAME	Ljava/lang/String;
    //   51: aload_0
    //   52: invokevirtual 209	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   55: new 214	com/google/android/gms/common/a
    //   58: dup
    //   59: invokespecial 215	com/google/android/gms/common/a:<init>	()V
    //   62: astore_0
    //   63: aload_2
    //   64: getstatic 73	com/google/android/gms/auth/GoogleAuthUtil:yT	Landroid/content/Intent;
    //   67: aload_0
    //   68: iconst_1
    //   69: invokevirtual 219	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   72: ifeq +91 -> 163
    //   75: aload_0
    //   76: invokevirtual 223	com/google/android/gms/common/a:er	()Landroid/os/IBinder;
    //   79: invokestatic 228	com/google/android/gms/internal/s$a:a	(Landroid/os/IBinder;)Lcom/google/android/gms/internal/s;
    //   82: aload_1
    //   83: aload_3
    //   84: invokeinterface 233 3 0
    //   89: astore_1
    //   90: aload_1
    //   91: getstatic 238	com/google/android/gms/internal/ge:zI	Ljava/lang/String;
    //   94: invokevirtual 242	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   97: astore_3
    //   98: aload_1
    //   99: ldc -12
    //   101: invokevirtual 247	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   104: ifne +41 -> 145
    //   107: new 84	com/google/android/gms/auth/GoogleAuthException
    //   110: dup
    //   111: aload_3
    //   112: invokespecial 248	com/google/android/gms/auth/GoogleAuthException:<init>	(Ljava/lang/String;)V
    //   115: athrow
    //   116: astore_1
    //   117: ldc -6
    //   119: ldc -4
    //   121: aload_1
    //   122: invokestatic 258	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   125: pop
    //   126: new 80	java/io/IOException
    //   129: dup
    //   130: ldc_w 260
    //   133: invokespecial 261	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   136: athrow
    //   137: astore_1
    //   138: aload_2
    //   139: aload_0
    //   140: invokevirtual 265	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   143: aload_1
    //   144: athrow
    //   145: aload_2
    //   146: aload_0
    //   147: invokevirtual 265	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   150: return
    //   151: astore_1
    //   152: new 84	com/google/android/gms/auth/GoogleAuthException
    //   155: dup
    //   156: ldc_w 267
    //   159: invokespecial 248	com/google/android/gms/auth/GoogleAuthException:<init>	(Ljava/lang/String;)V
    //   162: athrow
    //   163: new 80	java/io/IOException
    //   166: dup
    //   167: ldc_w 269
    //   170: invokespecial 261	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   173: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	174	0	paramContext	Context
    //   0	174	1	paramString	String
    //   4	142	2	localContext	Context
    //   21	91	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   75	116	116	android/os/RemoteException
    //   75	116	137	finally
    //   117	137	137	finally
    //   152	163	137	finally
    //   75	116	151	java/lang/InterruptedException
  }
  
  private static void g(Intent paramIntent)
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
    //   1: invokevirtual 108	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   4: astore 5
    //   6: ldc -66
    //   8: invokestatic 195	com/google/android/gms/internal/hn:az	(Ljava/lang/String;)V
    //   11: aload 5
    //   13: invokestatic 198	com/google/android/gms/auth/GoogleAuthUtil:w	(Landroid/content/Context;)V
    //   16: aload_3
    //   17: ifnonnull +108 -> 125
    //   20: new 90	android/os/Bundle
    //   23: dup
    //   24: invokespecial 91	android/os/Bundle:<init>	()V
    //   27: astore_3
    //   28: aload_0
    //   29: invokevirtual 201	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   32: getfield 204	android/content/pm/ApplicationInfo:packageName	Ljava/lang/String;
    //   35: astore_0
    //   36: aload_3
    //   37: ldc -50
    //   39: aload_0
    //   40: invokevirtual 209	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   43: aload_3
    //   44: getstatic 43	com/google/android/gms/auth/GoogleAuthUtil:KEY_ANDROID_PACKAGE_NAME	Ljava/lang/String;
    //   47: invokevirtual 212	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   50: ifne +11 -> 61
    //   53: aload_3
    //   54: getstatic 43	com/google/android/gms/auth/GoogleAuthUtil:KEY_ANDROID_PACKAGE_NAME	Ljava/lang/String;
    //   57: aload_0
    //   58: invokevirtual 209	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   61: new 214	com/google/android/gms/common/a
    //   64: dup
    //   65: invokespecial 215	com/google/android/gms/common/a:<init>	()V
    //   68: astore_0
    //   69: aload 5
    //   71: getstatic 73	com/google/android/gms/auth/GoogleAuthUtil:yT	Landroid/content/Intent;
    //   74: aload_0
    //   75: iconst_1
    //   76: invokevirtual 219	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   79: ifeq +161 -> 240
    //   82: aload_0
    //   83: invokevirtual 223	com/google/android/gms/common/a:er	()Landroid/os/IBinder;
    //   86: invokestatic 228	com/google/android/gms/internal/s$a:a	(Landroid/os/IBinder;)Lcom/google/android/gms/internal/s;
    //   89: aload_1
    //   90: aload_2
    //   91: aload_3
    //   92: invokeinterface 292 4 0
    //   97: astore_1
    //   98: aload_1
    //   99: ldc_w 294
    //   102: invokevirtual 242	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   105: astore_2
    //   106: aload_2
    //   107: invokestatic 300	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   110: istore 4
    //   112: iload 4
    //   114: ifne +23 -> 137
    //   117: aload 5
    //   119: aload_0
    //   120: invokevirtual 265	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   123: aload_2
    //   124: areturn
    //   125: new 90	android/os/Bundle
    //   128: dup
    //   129: aload_3
    //   130: invokespecial 303	android/os/Bundle:<init>	(Landroid/os/Bundle;)V
    //   133: astore_3
    //   134: goto -106 -> 28
    //   137: aload_1
    //   138: ldc_w 305
    //   141: invokevirtual 242	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   144: astore_2
    //   145: aload_1
    //   146: ldc_w 307
    //   149: invokevirtual 311	android/os/Bundle:getParcelable	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   152: checkcast 61	android/content/Intent
    //   155: astore_1
    //   156: aload_2
    //   157: invokestatic 313	com/google/android/gms/auth/GoogleAuthUtil:ad	(Ljava/lang/String;)Z
    //   160: ifeq +43 -> 203
    //   163: new 88	com/google/android/gms/auth/UserRecoverableAuthException
    //   166: dup
    //   167: aload_2
    //   168: aload_1
    //   169: invokespecial 316	com/google/android/gms/auth/UserRecoverableAuthException:<init>	(Ljava/lang/String;Landroid/content/Intent;)V
    //   172: athrow
    //   173: astore_1
    //   174: ldc -6
    //   176: ldc -4
    //   178: aload_1
    //   179: invokestatic 258	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   182: pop
    //   183: new 80	java/io/IOException
    //   186: dup
    //   187: ldc_w 260
    //   190: invokespecial 261	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   193: athrow
    //   194: astore_1
    //   195: aload 5
    //   197: aload_0
    //   198: invokevirtual 265	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   201: aload_1
    //   202: athrow
    //   203: aload_2
    //   204: invokestatic 318	com/google/android/gms/auth/GoogleAuthUtil:ac	(Ljava/lang/String;)Z
    //   207: ifeq +24 -> 231
    //   210: new 80	java/io/IOException
    //   213: dup
    //   214: aload_2
    //   215: invokespecial 261	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   218: athrow
    //   219: astore_1
    //   220: new 84	com/google/android/gms/auth/GoogleAuthException
    //   223: dup
    //   224: ldc_w 267
    //   227: invokespecial 248	com/google/android/gms/auth/GoogleAuthException:<init>	(Ljava/lang/String;)V
    //   230: athrow
    //   231: new 84	com/google/android/gms/auth/GoogleAuthException
    //   234: dup
    //   235: aload_2
    //   236: invokespecial 248	com/google/android/gms/auth/GoogleAuthException:<init>	(Ljava/lang/String;)V
    //   239: athrow
    //   240: new 80	java/io/IOException
    //   243: dup
    //   244: ldc_w 269
    //   247: invokespecial 261	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   250: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	251	0	paramContext	Context
    //   0	251	1	paramString1	String
    //   0	251	2	paramString2	String
    //   0	251	3	paramBundle	Bundle
    //   110	3	4	bool	boolean
    //   4	192	5	localContext	Context
    // Exception table:
    //   from	to	target	type
    //   82	112	173	android/os/RemoteException
    //   137	173	173	android/os/RemoteException
    //   203	219	173	android/os/RemoteException
    //   231	240	173	android/os/RemoteException
    //   82	112	194	finally
    //   137	173	194	finally
    //   174	194	194	finally
    //   203	219	194	finally
    //   220	231	194	finally
    //   231	240	194	finally
    //   82	112	219	java/lang/InterruptedException
    //   137	173	219	java/lang/InterruptedException
    //   203	219	219	java/lang/InterruptedException
    //   231	240	219	java/lang/InterruptedException
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
    g(paramIntent);
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
  
  private static void w(Context paramContext)
    throws GoogleAuthException
  {
    try
    {
      GooglePlayServicesUtil.w(paramContext);
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
  
  private static class a
    extends Handler
  {
    private final Context lx;
    
    a(Context paramContext) {}
    
    public void handleMessage(Message paramMessage)
    {
      if (paramMessage.what == 1)
      {
        int i = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.lx);
        if (GooglePlayServicesUtil.isUserRecoverableError(i)) {
          GooglePlayServicesUtil.showErrorNotification(i, this.lx);
        }
        return;
      }
      Log.wtf("GoogleAuthUtil", "Don't know how to handle this message: " + paramMessage.what);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/auth/GoogleAuthUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */