package com.mapbar.android.location;

import android.content.Context;
import android.location.GpsStatus.Listener;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

final class k
  implements GpsStatus.Listener, LocationListener
{
  private static k f = null;
  private LocationManager a;
  private boolean b = false;
  private boolean c = false;
  private volatile Location d = null;
  private Context e;
  
  private k(Context paramContext)
  {
    try
    {
      this.a = ((LocationManager)paramContext.getSystemService("location"));
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public static k a(Context paramContext)
  {
    try
    {
      if (f == null) {
        f = new k(paramContext);
      }
      f.e = paramContext;
      paramContext = f;
      return paramContext;
    }
    finally {}
  }
  
  public final void a()
  {
    this.a.addGpsStatusListener(this);
  }
  
  final boolean b()
  {
    return this.b;
  }
  
  final boolean c()
  {
    if ((!this.c) && (this.b)) {}
    try
    {
      if (this.a.isProviderEnabled("gps"))
      {
        this.c = true;
        this.a.requestLocationUpdates("gps", 0L, 0.0F, this);
      }
      return this.c;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public final void d()
  {
    this.a.removeGpsStatusListener(this);
    this.c = false;
    this.b = false;
    this.a.removeUpdates(this);
  }
  
  public final void onGpsStatusChanged(int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    default: 
      return;
    case 2: 
      this.b = false;
      return;
    }
    this.b = true;
  }
  
  /* Error */
  public final void onLocationChanged(Location paramLocation)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +142 -> 145
    //   6: aload_0
    //   7: getfield 36	com/mapbar/android/location/k:d	Landroid/location/Location;
    //   10: ifnonnull +156 -> 166
    //   13: aload_0
    //   14: new 82	android/location/Location
    //   17: dup
    //   18: aload_1
    //   19: invokespecial 84	android/location/Location:<init>	(Landroid/location/Location;)V
    //   22: putfield 36	com/mapbar/android/location/k:d	Landroid/location/Location;
    //   25: aload_0
    //   26: getfield 36	com/mapbar/android/location/k:d	Landroid/location/Location;
    //   29: invokevirtual 88	android/location/Location:getLongitude	()D
    //   32: ldc2_w 89
    //   35: dmul
    //   36: d2i
    //   37: putstatic 95	com/mapbar/android/location/l:c	I
    //   40: aload_0
    //   41: getfield 36	com/mapbar/android/location/k:d	Landroid/location/Location;
    //   44: invokevirtual 98	android/location/Location:getLatitude	()D
    //   47: ldc2_w 89
    //   50: dmul
    //   51: d2i
    //   52: putstatic 100	com/mapbar/android/location/l:d	I
    //   55: aload_0
    //   56: getfield 36	com/mapbar/android/location/k:d	Landroid/location/Location;
    //   59: invokevirtual 104	android/location/Location:getAccuracy	()F
    //   62: f2i
    //   63: putstatic 106	com/mapbar/android/location/l:e	I
    //   66: invokestatic 112	android/os/SystemClock:elapsedRealtime	()J
    //   69: putstatic 116	com/mapbar/android/location/l:g	J
    //   72: aload_0
    //   73: getfield 36	com/mapbar/android/location/k:d	Landroid/location/Location;
    //   76: invokevirtual 119	android/location/Location:getBearing	()F
    //   79: f2i
    //   80: putstatic 122	com/mapbar/android/location/l:h	I
    //   83: aload_0
    //   84: getfield 36	com/mapbar/android/location/k:d	Landroid/location/Location;
    //   87: invokevirtual 125	android/location/Location:getSpeed	()F
    //   90: f2i
    //   91: putstatic 128	com/mapbar/android/location/l:i	I
    //   94: aload_0
    //   95: getfield 36	com/mapbar/android/location/k:d	Landroid/location/Location;
    //   98: invokevirtual 131	android/location/Location:getAltitude	()D
    //   101: d2i
    //   102: putstatic 134	com/mapbar/android/location/l:j	I
    //   105: ldc 60
    //   107: aload_0
    //   108: getfield 36	com/mapbar/android/location/k:d	Landroid/location/Location;
    //   111: invokevirtual 138	android/location/Location:getProvider	()Ljava/lang/String;
    //   114: invokevirtual 143	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   117: ifeq +65 -> 182
    //   120: ldc -111
    //   122: putstatic 148	com/mapbar/android/location/l:f	Ljava/lang/String;
    //   125: aload_0
    //   126: getfield 34	com/mapbar/android/location/k:c	Z
    //   129: ifeq +16 -> 145
    //   132: aload_0
    //   133: iconst_0
    //   134: putfield 34	com/mapbar/android/location/k:c	Z
    //   137: aload_0
    //   138: getfield 48	com/mapbar/android/location/k:a	Landroid/location/LocationManager;
    //   141: aload_0
    //   142: invokevirtual 76	android/location/LocationManager:removeUpdates	(Landroid/location/LocationListener;)V
    //   145: aload_0
    //   146: monitorenter
    //   147: aload_0
    //   148: invokevirtual 151	java/lang/Object:notifyAll	()V
    //   151: aload_0
    //   152: monitorexit
    //   153: aload_0
    //   154: getfield 53	com/mapbar/android/location/k:e	Landroid/content/Context;
    //   157: invokestatic 153	com/mapbar/android/location/l:a	()Ljava/lang/String;
    //   160: invokestatic 156	com/mapbar/android/location/l:a	(Landroid/content/Context;Ljava/lang/String;)V
    //   163: aload_0
    //   164: monitorexit
    //   165: return
    //   166: aload_0
    //   167: getfield 36	com/mapbar/android/location/k:d	Landroid/location/Location;
    //   170: aload_1
    //   171: invokevirtual 159	android/location/Location:set	(Landroid/location/Location;)V
    //   174: goto -149 -> 25
    //   177: astore_1
    //   178: aload_0
    //   179: monitorexit
    //   180: aload_1
    //   181: athrow
    //   182: ldc -95
    //   184: putstatic 148	com/mapbar/android/location/l:f	Ljava/lang/String;
    //   187: goto -42 -> 145
    //   190: astore_1
    //   191: ldc -93
    //   193: new 165	java/lang/StringBuilder
    //   196: dup
    //   197: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   200: ldc -88
    //   202: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: aload_1
    //   206: invokevirtual 175	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   209: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   215: invokestatic 183	com/mapbar/android/location/i:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   218: goto -67 -> 151
    //   221: astore_1
    //   222: aload_0
    //   223: monitorexit
    //   224: aload_1
    //   225: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	226	0	this	k
    //   0	226	1	paramLocation	Location
    // Exception table:
    //   from	to	target	type
    //   6	25	177	finally
    //   25	145	177	finally
    //   145	147	177	finally
    //   153	163	177	finally
    //   166	174	177	finally
    //   182	187	177	finally
    //   222	226	177	finally
    //   147	151	190	java/lang/Exception
    //   147	151	221	finally
    //   151	153	221	finally
    //   191	218	221	finally
  }
  
  public final void onProviderDisabled(String paramString) {}
  
  public final void onProviderEnabled(String paramString) {}
  
  public final void onStatusChanged(String paramString, int paramInt, Bundle paramBundle) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/mapbar/android/location/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */