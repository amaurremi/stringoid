package com.inmobi.commons.analytics.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.GregorianCalendar;
import java.util.UUID;

public class SessionInfo
{
  private static String a;
  private static long b;
  private static String c;
  private static int d;
  
  public static String getAppId(Context paramContext)
  {
    if (c != null) {
      return c;
    }
    paramContext = paramContext.getSharedPreferences("inmobiAppAnalyticsAppId", 0).getString("APP_ID", null);
    c = paramContext;
    return paramContext;
  }
  
  public static int getFirstTime()
  {
    try
    {
      int i = d;
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public static String getSessionId(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 43	com/inmobi/commons/analytics/util/SessionInfo:a	Ljava/lang/String;
    //   6: ifnull +12 -> 18
    //   9: getstatic 43	com/inmobi/commons/analytics/util/SessionInfo:a	Ljava/lang/String;
    //   12: astore_0
    //   13: ldc 2
    //   15: monitorexit
    //   16: aload_0
    //   17: areturn
    //   18: aload_0
    //   19: ldc 45
    //   21: iconst_0
    //   22: invokevirtual 28	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   25: ldc 47
    //   27: aconst_null
    //   28: invokeinterface 36 3 0
    //   33: astore_0
    //   34: aload_0
    //   35: putstatic 43	com/inmobi/commons/analytics/util/SessionInfo:a	Ljava/lang/String;
    //   38: goto -25 -> 13
    //   41: astore_0
    //   42: ldc 2
    //   44: monitorexit
    //   45: aload_0
    //   46: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	47	0	paramContext	Context
    // Exception table:
    //   from	to	target	type
    //   3	13	41	finally
    //   18	38	41	finally
  }
  
  /* Error */
  public static long getSessionTime(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 51	com/inmobi/commons/analytics/util/SessionInfo:b	J
    //   6: lconst_0
    //   7: lcmp
    //   8: ifeq +12 -> 20
    //   11: getstatic 51	com/inmobi/commons/analytics/util/SessionInfo:b	J
    //   14: lstore_1
    //   15: ldc 2
    //   17: monitorexit
    //   18: lload_1
    //   19: lreturn
    //   20: aload_0
    //   21: ldc 45
    //   23: iconst_0
    //   24: invokevirtual 28	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   27: ldc 53
    //   29: lconst_0
    //   30: invokeinterface 57 4 0
    //   35: lstore_1
    //   36: lload_1
    //   37: putstatic 51	com/inmobi/commons/analytics/util/SessionInfo:b	J
    //   40: goto -25 -> 15
    //   43: astore_0
    //   44: ldc 2
    //   46: monitorexit
    //   47: aload_0
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	paramContext	Context
    //   14	23	1	l	long
    // Exception table:
    //   from	to	target	type
    //   3	15	43	finally
    //   20	40	43	finally
  }
  
  public static boolean isUpdatedFromOldSDK(Context paramContext)
  {
    try
    {
      boolean bool = paramContext.getSharedPreferences("inmobiAppAnalyticsSession", 0).getBoolean("UPDATED_FROM_OLD_SDK", false);
      return bool;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static void removeSessionId(Context paramContext)
  {
    try
    {
      a = null;
      b = 0L;
      paramContext = paramContext.getSharedPreferences("inmobiAppAnalyticsSession", 0).edit();
      paramContext.putString("SESSION_ID", null);
      paramContext.putString("SESSION_TIME", null);
      paramContext.commit();
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static void resetFirstTime()
  {
    try
    {
      d = 0;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static void storeAppId(Context paramContext, String paramString)
  {
    c = paramString;
    paramContext = paramContext.getSharedPreferences("inmobiAppAnalyticsAppId", 0).edit();
    paramContext.putString("APP_ID", paramString);
    paramContext.commit();
  }
  
  public static void storeFirstTime(Context paramContext)
  {
    int j = 0;
    label197:
    for (;;)
    {
      try
      {
        Object localObject = paramContext.getSharedPreferences("inmobiAppAnalyticsSession", 0);
        paramContext = ((SharedPreferences)localObject).edit();
        long l = ((SharedPreferences)localObject).getLong("SESSION_TIMEM", -1L);
        if (l != -1L)
        {
          localObject = new GregorianCalendar();
          ((GregorianCalendar)localObject).setTimeInMillis(l);
          ((GregorianCalendar)localObject).setFirstDayOfWeek(2);
          GregorianCalendar localGregorianCalendar = new GregorianCalendar();
          l = localGregorianCalendar.getTimeInMillis();
          localGregorianCalendar.setFirstDayOfWeek(2);
          if (((GregorianCalendar)localObject).get(6) != localGregorianCalendar.get(6)) {
            j = 1;
          }
          i = j;
          if (((GregorianCalendar)localObject).get(3) != localGregorianCalendar.get(3)) {
            i = j | 0x2;
          }
          j = i;
          if (((GregorianCalendar)localObject).get(2) != localGregorianCalendar.get(2))
          {
            j = i | 0x4;
            break label197;
            paramContext.putLong("SESSION_TIMEM", l);
            paramContext.commit();
            d = i;
          }
        }
        else
        {
          l = new GregorianCalendar().getTimeInMillis();
          i = 15;
          continue;
        }
        int i = j;
      }
      finally {}
    }
  }
  
  public static void storeSessionId(Context paramContext)
  {
    try
    {
      a = UUID.randomUUID().toString();
      b = System.currentTimeMillis() / 1000L;
      paramContext = paramContext.getSharedPreferences("inmobiAppAnalyticsSession", 0).edit();
      paramContext.putString("SESSION_ID", a);
      paramContext.putLong("SESSION_TIME", b);
      paramContext.commit();
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static void updatedFromOldSDK(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getSharedPreferences("inmobiAppAnalyticsSession", 0).edit();
      paramContext.putBoolean("UPDATED_FROM_OLD_SDK", true);
      paramContext.commit();
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/commons/analytics/util/SessionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */