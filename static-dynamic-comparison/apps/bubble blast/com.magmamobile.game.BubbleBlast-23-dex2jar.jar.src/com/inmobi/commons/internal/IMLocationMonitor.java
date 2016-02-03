package com.inmobi.commons.internal;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

public class IMLocationMonitor
  implements LocationListener
{
  private static IMLocationMonitor a = null;
  private static LocationManager b = null;
  private static final int c = 0;
  private static final int d = 0;
  private static String e = null;
  private static Location f = null;
  private static boolean g;
  
  public static IMLocationMonitor getInstance()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new IMLocationMonitor();
      }
      return a;
    }
    finally {}
  }
  
  public Location getCurrentLocation()
  {
    return f;
  }
  
  public void onLocationChanged(Location paramLocation)
  {
    try
    {
      f = paramLocation;
      return;
    }
    finally
    {
      paramLocation = finally;
      throw paramLocation;
    }
  }
  
  public void onProviderDisabled(String paramString) {}
  
  public void onProviderEnabled(String paramString) {}
  
  public void onStatusChanged(String paramString, int paramInt, Bundle paramBundle) {}
  
  /* Error */
  public void startListening(android.content.Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 50	com/inmobi/commons/internal/IMLocationMonitor:g	Z
    //   5: istore_2
    //   6: iload_2
    //   7: ifeq +6 -> 13
    //   10: aload_0
    //   11: monitorexit
    //   12: return
    //   13: aload_1
    //   14: ldc 52
    //   16: invokevirtual 58	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   19: checkcast 60	android/location/LocationManager
    //   22: putstatic 26	com/inmobi/commons/internal/IMLocationMonitor:b	Landroid/location/LocationManager;
    //   25: getstatic 26	com/inmobi/commons/internal/IMLocationMonitor:b	Landroid/location/LocationManager;
    //   28: ifnull -18 -> 10
    //   31: new 62	android/location/Criteria
    //   34: dup
    //   35: invokespecial 63	android/location/Criteria:<init>	()V
    //   38: astore_1
    //   39: getstatic 26	com/inmobi/commons/internal/IMLocationMonitor:b	Landroid/location/LocationManager;
    //   42: aload_1
    //   43: iconst_1
    //   44: invokevirtual 67	android/location/LocationManager:getBestProvider	(Landroid/location/Criteria;Z)Ljava/lang/String;
    //   47: putstatic 28	com/inmobi/commons/internal/IMLocationMonitor:e	Ljava/lang/String;
    //   50: getstatic 28	com/inmobi/commons/internal/IMLocationMonitor:e	Ljava/lang/String;
    //   53: ifnull -43 -> 10
    //   56: iconst_1
    //   57: putstatic 50	com/inmobi/commons/internal/IMLocationMonitor:g	Z
    //   60: getstatic 26	com/inmobi/commons/internal/IMLocationMonitor:b	Landroid/location/LocationManager;
    //   63: getstatic 28	com/inmobi/commons/internal/IMLocationMonitor:e	Ljava/lang/String;
    //   66: lconst_0
    //   67: fconst_0
    //   68: aload_0
    //   69: invokevirtual 71	android/location/LocationManager:requestLocationUpdates	(Ljava/lang/String;JFLandroid/location/LocationListener;)V
    //   72: goto -62 -> 10
    //   75: astore_1
    //   76: aload_0
    //   77: monitorexit
    //   78: aload_1
    //   79: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	this	IMLocationMonitor
    //   0	80	1	paramContext	android.content.Context
    //   5	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	6	75	finally
    //   13	72	75	finally
  }
  
  public void stopListening()
  {
    try
    {
      if ((b != null) && (g))
      {
        b.removeUpdates(this);
        g = false;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/inmobi/commons/internal/IMLocationMonitor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */