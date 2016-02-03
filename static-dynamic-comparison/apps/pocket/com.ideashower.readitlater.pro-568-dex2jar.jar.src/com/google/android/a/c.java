package com.google.android.a;

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
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class c
{
  private static b a;
  private static String b;
  
  static String a(Context paramContext, String paramString)
  {
    SharedPreferences localSharedPreferences = l(paramContext);
    String str = localSharedPreferences.getString("regId", "");
    int i = k(paramContext);
    Log.v("GCMRegistrar", "Saving regId on app version " + i);
    paramContext = localSharedPreferences.edit();
    paramContext.putString("regId", paramString);
    paramContext.putInt("appVersion", i);
    paramContext.commit();
    return str;
  }
  
  static String a(String... paramVarArgs)
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
  
  public static void a(Context paramContext)
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
  
  static void a(Context paramContext, int paramInt)
  {
    paramContext = l(paramContext).edit();
    paramContext.putInt("backoff_ms", paramInt);
    paramContext.commit();
  }
  
  private static void a(Context paramContext, Set paramSet, String paramString)
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
  
  public static void a(Context paramContext, String... paramVarArgs)
  {
    i(paramContext);
    b(paramContext, paramVarArgs);
  }
  
  static void a(String paramString)
  {
    Log.v("GCMRegistrar", "Setting the name of retry receiver class to " + paramString);
    b = paramString;
  }
  
  public static void b(Context paramContext)
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
    a(paramContext, (Set)localObject1, "com.google.android.c2dm.intent.REGISTRATION");
    a(paramContext, (Set)localObject1, "com.google.android.c2dm.intent.RECEIVE");
  }
  
  static void b(Context paramContext, String... paramVarArgs)
  {
    paramVarArgs = a(paramVarArgs);
    Log.v("GCMRegistrar", "Registering app " + paramContext.getPackageName() + " of senders " + paramVarArgs);
    Intent localIntent = new Intent("com.google.android.c2dm.intent.REGISTER");
    localIntent.setPackage("com.google.android.gsf");
    localIntent.putExtra("app", PendingIntent.getBroadcast(paramContext, 0, new Intent(), 0));
    localIntent.putExtra("sender", paramVarArgs);
    paramContext.startService(localIntent);
  }
  
  public static void c(Context paramContext)
  {
    i(paramContext);
    d(paramContext);
  }
  
  static void d(Context paramContext)
  {
    Log.v("GCMRegistrar", "Unregistering app " + paramContext.getPackageName());
    Intent localIntent = new Intent("com.google.android.c2dm.intent.UNREGISTER");
    localIntent.setPackage("com.google.android.gsf");
    localIntent.putExtra("app", PendingIntent.getBroadcast(paramContext, 0, new Intent(), 0));
    paramContext.startService(localIntent);
  }
  
  /* Error */
  static void e(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 293	com/google/android/a/c:a	Lcom/google/android/a/b;
    //   6: ifnonnull +89 -> 95
    //   9: getstatic 205	com/google/android/a/c:b	Ljava/lang/String;
    //   12: ifnonnull +87 -> 99
    //   15: ldc 29
    //   17: ldc_w 295
    //   20: invokestatic 297	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   23: pop
    //   24: new 299	com/google/android/a/b
    //   27: dup
    //   28: invokespecial 300	com/google/android/a/b:<init>	()V
    //   31: putstatic 293	com/google/android/a/c:a	Lcom/google/android/a/b;
    //   34: aload_0
    //   35: invokevirtual 126	android/content/Context:getPackageName	()Ljava/lang/String;
    //   38: astore_2
    //   39: new 302	android/content/IntentFilter
    //   42: dup
    //   43: ldc_w 304
    //   46: invokespecial 305	android/content/IntentFilter:<init>	(Ljava/lang/String;)V
    //   49: astore_1
    //   50: aload_1
    //   51: aload_2
    //   52: invokevirtual 308	android/content/IntentFilter:addCategory	(Ljava/lang/String;)V
    //   55: new 31	java/lang/StringBuilder
    //   58: dup
    //   59: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   62: aload_2
    //   63: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: ldc -49
    //   68: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: astore_2
    //   75: ldc 29
    //   77: ldc_w 310
    //   80: invokestatic 54	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   83: pop
    //   84: aload_0
    //   85: getstatic 293	com/google/android/a/c:a	Lcom/google/android/a/b;
    //   88: aload_1
    //   89: aload_2
    //   90: aconst_null
    //   91: invokevirtual 314	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;Ljava/lang/String;Landroid/os/Handler;)Landroid/content/Intent;
    //   94: pop
    //   95: ldc 2
    //   97: monitorexit
    //   98: return
    //   99: getstatic 205	com/google/android/a/c:b	Ljava/lang/String;
    //   102: invokestatic 320	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   105: invokevirtual 323	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   108: checkcast 299	com/google/android/a/b
    //   111: putstatic 293	com/google/android/a/c:a	Lcom/google/android/a/b;
    //   114: goto -80 -> 34
    //   117: astore_1
    //   118: ldc 29
    //   120: new 31	java/lang/StringBuilder
    //   123: dup
    //   124: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   127: ldc_w 325
    //   130: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: getstatic 205	com/google/android/a/c:b	Ljava/lang/String;
    //   136: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: ldc_w 327
    //   142: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: ldc_w 299
    //   148: invokevirtual 330	java/lang/Class:getName	()Ljava/lang/String;
    //   151: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: ldc_w 332
    //   157: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: invokestatic 297	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   166: pop
    //   167: new 299	com/google/android/a/b
    //   170: dup
    //   171: invokespecial 300	com/google/android/a/b:<init>	()V
    //   174: putstatic 293	com/google/android/a/c:a	Lcom/google/android/a/b;
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
  
  public static String f(Context paramContext)
  {
    Object localObject = l(paramContext);
    String str = ((SharedPreferences)localObject).getString("regId", "");
    int i = ((SharedPreferences)localObject).getInt("appVersion", Integer.MIN_VALUE);
    int j = k(paramContext);
    localObject = str;
    if (i != Integer.MIN_VALUE)
    {
      localObject = str;
      if (i != j)
      {
        Log.v("GCMRegistrar", "App version changed from " + i + " to " + j + "; resetting registration id");
        h(paramContext);
        localObject = "";
      }
    }
    return (String)localObject;
  }
  
  public static boolean g(Context paramContext)
  {
    return f(paramContext).length() > 0;
  }
  
  static String h(Context paramContext)
  {
    return a(paramContext, "");
  }
  
  static void i(Context paramContext)
  {
    Log.d("GCMRegistrar", "resetting backoff for " + paramContext.getPackageName());
    a(paramContext, 3000);
  }
  
  static int j(Context paramContext)
  {
    return l(paramContext).getInt("backoff_ms", 3000);
  }
  
  private static int k(Context paramContext)
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
  
  private static SharedPreferences l(Context paramContext)
  {
    return paramContext.getSharedPreferences("com.google.android.gcm", 0);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */