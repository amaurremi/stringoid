package com.google.android.gcm;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.os.Build.VERSION;
import android.util.Log;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class GCMRegistrar
{
  private static final String BACKOFF_MS = "backoff_ms";
  private static final int DEFAULT_BACKOFF_MS = 3000;
  public static final long DEFAULT_ON_SERVER_LIFESPAN_MS = 604800000L;
  private static final String GSF_PACKAGE = "com.google.android.gsf";
  private static final String PREFERENCES = "com.google.android.gcm";
  private static final String PROPERTY_APP_VERSION = "appVersion";
  private static final String PROPERTY_ON_SERVER = "onServer";
  private static final String PROPERTY_ON_SERVER_EXPIRATION_TIME = "onServerExpirationTime";
  private static final String PROPERTY_ON_SERVER_LIFESPAN = "onServerLifeSpan";
  private static final String PROPERTY_REG_ID = "regId";
  private static final String TAG = "GCMRegistrar";
  private static GCMBroadcastReceiver sRetryReceiver;
  private static String sRetryReceiverClassName;
  
  private GCMRegistrar()
  {
    throw new UnsupportedOperationException();
  }
  
  public static void checkDevice(Context paramContext)
  {
    int i = Build.VERSION.SDK_INT;
    if (i < 8) {
      throw new UnsupportedOperationException("Device must be at least API Level 8 (instead of " + i + ")");
    }
    paramContext = paramContext.getPackageManager();
    try
    {
      paramContext.getPackageInfo("com.google.android.gsf", 0);
      return;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      throw new UnsupportedOperationException("Device does not have package com.google.android.gsf");
    }
  }
  
  public static void checkManifest(Context paramContext)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    Object localObject1 = paramContext.getPackageName();
    Object localObject2 = (String)localObject1 + ".permission.C2D_MESSAGE";
    try
    {
      localPackageManager.getPermissionInfo((String)localObject2, 4096);
      if (!Log.isLoggable("GCMRegistrar", 2)) {
        break label199;
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      try
      {
        localObject2 = localPackageManager.getPackageInfo((String)localObject1, 2);
        localObject2 = ((PackageInfo)localObject2).receivers;
        if ((localObject2 != null) && (localObject2.length != 0)) {
          break label154;
        }
        throw new IllegalStateException("No receiver for package " + (String)localObject1);
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        throw new IllegalStateException("Could not get receivers for package " + (String)localObject1);
      }
      paramContext = paramContext;
      throw new IllegalStateException("Application does not define permission " + (String)localObject2);
    }
    label154:
    Log.v("GCMRegistrar", "number of receivers for " + (String)localObject1 + ": " + localObject2.length);
    label199:
    localObject1 = new HashSet();
    int j = localObject2.length;
    int i = 0;
    while (i < j)
    {
      localPackageManager = localObject2[i];
      if ("com.google.android.c2dm.permission.SEND".equals(localPackageManager.permission)) {
        ((Set)localObject1).add(localPackageManager.name);
      }
      i += 1;
    }
    if (((Set)localObject1).isEmpty()) {
      throw new IllegalStateException("No receiver allowed to receive com.google.android.c2dm.permission.SEND");
    }
    checkReceiver(paramContext, (Set)localObject1, "com.google.android.c2dm.intent.REGISTRATION");
    checkReceiver(paramContext, (Set)localObject1, "com.google.android.c2dm.intent.RECEIVE");
  }
  
  private static void checkReceiver(Context paramContext, Set<String> paramSet, String paramString)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    paramContext = paramContext.getPackageName();
    Intent localIntent = new Intent(paramString);
    localIntent.setPackage(paramContext);
    paramContext = localPackageManager.queryBroadcastReceivers(localIntent, 32);
    if (paramContext.isEmpty()) {
      throw new IllegalStateException("No receivers for action " + paramString);
    }
    if (Log.isLoggable("GCMRegistrar", 2)) {
      Log.v("GCMRegistrar", "Found " + paramContext.size() + " receivers for action " + paramString);
    }
    paramContext = paramContext.iterator();
    while (paramContext.hasNext())
    {
      paramString = ((ResolveInfo)paramContext.next()).activityInfo.name;
      if (!paramSet.contains(paramString)) {
        throw new IllegalStateException("Receiver " + paramString + " is not set with permission " + "com.google.android.c2dm.permission.SEND");
      }
    }
  }
  
  static String clearRegistrationId(Context paramContext)
  {
    return setRegistrationId(paramContext, "");
  }
  
  private static int getAppVersion(Context paramContext)
  {
    try
    {
      int i = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionCode;
      return i;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      throw new RuntimeException("Coult not get package name: " + paramContext);
    }
  }
  
  static int getBackoff(Context paramContext)
  {
    return getGCMPreferences(paramContext).getInt("backoff_ms", 3000);
  }
  
  static String getFlatSenderIds(String... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {
      throw new IllegalArgumentException("No senderIds");
    }
    StringBuilder localStringBuilder = new StringBuilder(paramVarArgs[0]);
    int i = 1;
    while (i < paramVarArgs.length)
    {
      localStringBuilder.append(',').append(paramVarArgs[i]);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  private static SharedPreferences getGCMPreferences(Context paramContext)
  {
    return paramContext.getSharedPreferences("com.google.android.gcm", 0);
  }
  
  public static long getRegisterOnServerLifespan(Context paramContext)
  {
    return getGCMPreferences(paramContext).getLong("onServerLifeSpan", 604800000L);
  }
  
  public static String getRegistrationId(Context paramContext)
  {
    Object localObject = getGCMPreferences(paramContext);
    String str = ((SharedPreferences)localObject).getString("regId", "");
    int i = ((SharedPreferences)localObject).getInt("appVersion", Integer.MIN_VALUE);
    int j = getAppVersion(paramContext);
    localObject = str;
    if (i != Integer.MIN_VALUE)
    {
      localObject = str;
      if (i != j)
      {
        Log.v("GCMRegistrar", "App version changed from " + i + " to " + j + "; resetting registration id");
        clearRegistrationId(paramContext);
        localObject = "";
      }
    }
    return (String)localObject;
  }
  
  static void internalRegister(Context paramContext, String... paramVarArgs)
  {
    paramVarArgs = getFlatSenderIds(paramVarArgs);
    Log.v("GCMRegistrar", "Registering app " + paramContext.getPackageName() + " of senders " + paramVarArgs);
    Intent localIntent = new Intent("com.google.android.c2dm.intent.REGISTER");
    localIntent.setPackage("com.google.android.gsf");
    localIntent.putExtra("app", PendingIntent.getBroadcast(paramContext, 0, new Intent(), 0));
    localIntent.putExtra("sender", paramVarArgs);
    paramContext.startService(localIntent);
  }
  
  static void internalUnregister(Context paramContext)
  {
    Log.v("GCMRegistrar", "Unregistering app " + paramContext.getPackageName());
    Intent localIntent = new Intent("com.google.android.c2dm.intent.UNREGISTER");
    localIntent.setPackage("com.google.android.gsf");
    localIntent.putExtra("app", PendingIntent.getBroadcast(paramContext, 0, new Intent(), 0));
    paramContext.startService(localIntent);
  }
  
  public static boolean isRegistered(Context paramContext)
  {
    return getRegistrationId(paramContext).length() > 0;
  }
  
  public static boolean isRegisteredOnServer(Context paramContext)
  {
    paramContext = getGCMPreferences(paramContext);
    boolean bool2 = paramContext.getBoolean("onServer", false);
    Log.v("GCMRegistrar", "Is registered on server: " + bool2);
    boolean bool1 = bool2;
    if (bool2)
    {
      long l = paramContext.getLong("onServerExpirationTime", -1L);
      bool1 = bool2;
      if (System.currentTimeMillis() > l)
      {
        Log.v("GCMRegistrar", "flag expired on: " + new Timestamp(l));
        bool1 = false;
      }
    }
    return bool1;
  }
  
  public static void onDestroy(Context paramContext)
  {
    try
    {
      if (sRetryReceiver != null)
      {
        Log.v("GCMRegistrar", "Unregistering receiver");
        paramContext.unregisterReceiver(sRetryReceiver);
        sRetryReceiver = null;
      }
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static void register(Context paramContext, String... paramVarArgs)
  {
    resetBackoff(paramContext);
    internalRegister(paramContext, paramVarArgs);
  }
  
  static void resetBackoff(Context paramContext)
  {
    Log.d("GCMRegistrar", "resetting backoff for " + paramContext.getPackageName());
    setBackoff(paramContext, 3000);
  }
  
  static void setBackoff(Context paramContext, int paramInt)
  {
    paramContext = getGCMPreferences(paramContext).edit();
    paramContext.putInt("backoff_ms", paramInt);
    paramContext.commit();
  }
  
  public static void setRegisterOnServerLifespan(Context paramContext, long paramLong)
  {
    paramContext = getGCMPreferences(paramContext).edit();
    paramContext.putLong("onServerLifeSpan", paramLong);
    paramContext.commit();
  }
  
  public static void setRegisteredOnServer(Context paramContext, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = getGCMPreferences(paramContext).edit();
    localEditor.putBoolean("onServer", paramBoolean);
    long l = getRegisterOnServerLifespan(paramContext);
    l = System.currentTimeMillis() + l;
    Log.v("GCMRegistrar", "Setting registeredOnServer status as " + paramBoolean + " until " + new Timestamp(l));
    localEditor.putLong("onServerExpirationTime", l);
    localEditor.commit();
  }
  
  static String setRegistrationId(Context paramContext, String paramString)
  {
    SharedPreferences localSharedPreferences = getGCMPreferences(paramContext);
    String str = localSharedPreferences.getString("regId", "");
    int i = getAppVersion(paramContext);
    Log.v("GCMRegistrar", "Saving regId on app version " + i);
    paramContext = localSharedPreferences.edit();
    paramContext.putString("regId", paramString);
    paramContext.putInt("appVersion", i);
    paramContext.commit();
    return str;
  }
  
  /* Error */
  static void setRetryBroadcastReceiver(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 364	com/google/android/gcm/GCMRegistrar:sRetryReceiver	Lcom/google/android/gcm/GCMBroadcastReceiver;
    //   6: ifnonnull +89 -> 95
    //   9: getstatic 427	com/google/android/gcm/GCMRegistrar:sRetryReceiverClassName	Ljava/lang/String;
    //   12: ifnonnull +87 -> 99
    //   15: ldc 39
    //   17: ldc_w 429
    //   20: invokestatic 432	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   23: pop
    //   24: new 434	com/google/android/gcm/GCMBroadcastReceiver
    //   27: dup
    //   28: invokespecial 435	com/google/android/gcm/GCMBroadcastReceiver:<init>	()V
    //   31: putstatic 364	com/google/android/gcm/GCMRegistrar:sRetryReceiver	Lcom/google/android/gcm/GCMBroadcastReceiver;
    //   34: aload_0
    //   35: invokevirtual 98	android/content/Context:getPackageName	()Ljava/lang/String;
    //   38: astore_2
    //   39: new 437	android/content/IntentFilter
    //   42: dup
    //   43: ldc_w 439
    //   46: invokespecial 440	android/content/IntentFilter:<init>	(Ljava/lang/String;)V
    //   49: astore_1
    //   50: aload_1
    //   51: aload_2
    //   52: invokevirtual 443	android/content/IntentFilter:addCategory	(Ljava/lang/String;)V
    //   55: new 61	java/lang/StringBuilder
    //   58: dup
    //   59: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   62: aload_2
    //   63: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: ldc 100
    //   68: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: astore_2
    //   75: ldc 39
    //   77: ldc_w 445
    //   80: invokestatic 133	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   83: pop
    //   84: aload_0
    //   85: getstatic 364	com/google/android/gcm/GCMRegistrar:sRetryReceiver	Lcom/google/android/gcm/GCMBroadcastReceiver;
    //   88: aload_1
    //   89: aload_2
    //   90: aconst_null
    //   91: invokevirtual 449	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;Ljava/lang/String;Landroid/os/Handler;)Landroid/content/Intent;
    //   94: pop
    //   95: ldc 2
    //   97: monitorexit
    //   98: return
    //   99: getstatic 427	com/google/android/gcm/GCMRegistrar:sRetryReceiverClassName	Ljava/lang/String;
    //   102: invokestatic 455	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   105: invokevirtual 458	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   108: checkcast 434	com/google/android/gcm/GCMBroadcastReceiver
    //   111: putstatic 364	com/google/android/gcm/GCMRegistrar:sRetryReceiver	Lcom/google/android/gcm/GCMBroadcastReceiver;
    //   114: goto -80 -> 34
    //   117: astore_1
    //   118: ldc 39
    //   120: new 61	java/lang/StringBuilder
    //   123: dup
    //   124: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   127: ldc_w 460
    //   130: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: getstatic 427	com/google/android/gcm/GCMRegistrar:sRetryReceiverClassName	Ljava/lang/String;
    //   136: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: ldc_w 462
    //   142: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: ldc_w 434
    //   148: invokevirtual 465	java/lang/Class:getName	()Ljava/lang/String;
    //   151: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: ldc_w 467
    //   157: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: invokestatic 432	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   166: pop
    //   167: new 434	com/google/android/gcm/GCMBroadcastReceiver
    //   170: dup
    //   171: invokespecial 435	com/google/android/gcm/GCMBroadcastReceiver:<init>	()V
    //   174: putstatic 364	com/google/android/gcm/GCMRegistrar:sRetryReceiver	Lcom/google/android/gcm/GCMBroadcastReceiver;
    //   177: goto -143 -> 34
    //   180: astore_0
    //   181: ldc 2
    //   183: monitorexit
    //   184: aload_0
    //   185: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	186	0	paramContext	Context
    //   49	40	1	localIntentFilter	android.content.IntentFilter
    //   117	1	1	localException	Exception
    //   38	52	2	str	String
    // Exception table:
    //   from	to	target	type
    //   99	114	117	java/lang/Exception
    //   3	34	180	finally
    //   34	95	180	finally
    //   99	114	180	finally
    //   118	177	180	finally
  }
  
  static void setRetryReceiverClassName(String paramString)
  {
    Log.v("GCMRegistrar", "Setting the name of retry receiver class to " + paramString);
    sRetryReceiverClassName = paramString;
  }
  
  public static void unregister(Context paramContext)
  {
    resetBackoff(paramContext);
    internalUnregister(paramContext);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gcm/GCMRegistrar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */