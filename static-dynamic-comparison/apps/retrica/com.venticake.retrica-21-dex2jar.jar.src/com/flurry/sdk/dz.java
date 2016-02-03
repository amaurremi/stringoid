package com.flurry.sdk;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Looper;
import android.text.TextUtils;

public class dz
  implements dq.a, fb.a
{
  private static final String c = dz.class.getSimpleName();
  private static dz q;
  boolean a = false;
  boolean b;
  private final int d = 3;
  private final long e = 10000L;
  private final long f = 90000L;
  private final long g = 0L;
  private long h = 0L;
  private LocationManager i;
  private Criteria j;
  private Location k;
  private dz.a l = new dz.a(this);
  private String m;
  private int n = 0;
  private int o = 0;
  private volatile Location p;
  
  private dz()
  {
    dq localdq = dp.a();
    this.j = ((Criteria)localdq.a("LocationCriteria"));
    localdq.a("LocationCriteria", this);
    eo.a(4, c, "initSettings, LocationCriteria = " + this.j);
    this.b = ((Boolean)localdq.a("ReportLocation")).booleanValue();
    localdq.a("ReportLocation", this);
    eo.a(4, c, "initSettings, ReportLocation = " + this.b);
  }
  
  public static dz a()
  {
    try
    {
      if (q == null) {
        q = new dz();
      }
      dz localdz = q;
      return localdz;
    }
    finally {}
  }
  
  private void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.i.requestLocationUpdates(paramString, 10000L, 0.0F, this.l, Looper.getMainLooper());
    }
  }
  
  private Location b(String paramString)
  {
    Location localLocation = null;
    if (!TextUtils.isEmpty(paramString)) {
      localLocation = this.i.getLastKnownLocation(paramString);
    }
    return localLocation;
  }
  
  private void i()
  {
    this.i.removeUpdates(this.l);
    this.a = false;
    this.o = 0;
    this.h = 0L;
    m();
    eo.a(4, c, "LocationProvider stopped");
  }
  
  private void j()
  {
    if (!this.b) {}
    do
    {
      do
      {
        return;
      } while (this.p != null);
      localObject = do.a().b();
    } while ((((Context)localObject).checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0) && (((Context)localObject).checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") != 0));
    i();
    Object localObject = k();
    a((String)localObject);
    this.k = b((String)localObject);
    this.h = (System.currentTimeMillis() + 90000L);
    l();
    this.a = true;
    eo.a(4, c, "LocationProvider started");
  }
  
  private String k()
  {
    Criteria localCriteria = this.j;
    Object localObject = localCriteria;
    if (localCriteria == null) {
      localObject = new Criteria();
    }
    if (TextUtils.isEmpty(this.m)) {}
    for (localObject = this.i.getBestProvider((Criteria)localObject, true);; localObject = this.m)
    {
      eo.a(4, c, "provider = " + (String)localObject);
      return (String)localObject;
    }
  }
  
  private void l()
  {
    eo.a(4, c, "Register location timer");
    fa.a().a(this);
  }
  
  private void m()
  {
    eo.a(4, c, "Unregister location timer");
    fa.a().b(this);
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    this.p = new Location("Explicit");
    this.p.setLatitude(paramFloat1);
    this.p.setLongitude(paramFloat2);
  }
  
  public void a(fb paramfb)
  {
    if ((this.h > 0L) && (this.h < System.currentTimeMillis()))
    {
      eo.a(4, c, "No location received in 90 seconds , stopping LocationManager");
      i();
    }
  }
  
  public void a(String paramString, Object paramObject)
  {
    if (paramString.equals("LocationCriteria"))
    {
      this.j = ((Criteria)paramObject);
      eo.a(4, c, "onSettingUpdate, LocationCriteria = " + this.j);
      if (this.a) {
        j();
      }
    }
    do
    {
      return;
      if (!paramString.equals("ReportLocation")) {
        break label140;
      }
      this.b = ((Boolean)paramObject).booleanValue();
      eo.a(4, c, "onSettingUpdate, ReportLocation = " + this.b);
      if (!this.b) {
        break;
      }
    } while ((this.a) || (this.n <= 0));
    j();
    return;
    i();
    return;
    label140:
    eo.a(6, c, "LocationProvider internal error! Had to be LocationCriteria or ReportLocation key.");
  }
  
  /* Error */
  public void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 146	com/flurry/sdk/dz:i	Landroid/location/LocationManager;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: invokestatic 179	com/flurry/sdk/do:a	()Lcom/flurry/sdk/do;
    //   18: invokevirtual 182	com/flurry/sdk/do:b	()Landroid/content/Context;
    //   21: ldc_w 266
    //   24: invokevirtual 269	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   27: checkcast 154	android/location/LocationManager
    //   30: putfield 146	com/flurry/sdk/dz:i	Landroid/location/LocationManager;
    //   33: goto -22 -> 11
    //   36: astore_1
    //   37: aload_0
    //   38: monitorexit
    //   39: aload_1
    //   40: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	41	0	this	dz
    //   6	2	1	localLocationManager	LocationManager
    //   36	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	36	finally
    //   14	33	36	finally
  }
  
  public void c()
  {
    try
    {
      eo.a(4, c, "Location provider subscribed");
      this.n += 1;
      if ((!this.a) && (this.o < 3)) {
        j();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public void d()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iconst_4
    //   3: getstatic 44	com/flurry/sdk/dz:c	Ljava/lang/String;
    //   6: ldc_w 273
    //   9: invokestatic 114	com/flurry/sdk/eo:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   12: aload_0
    //   13: getfield 66	com/flurry/sdk/dz:n	I
    //   16: ifgt +17 -> 33
    //   19: bipush 6
    //   21: getstatic 44	com/flurry/sdk/dz:c	Ljava/lang/String;
    //   24: ldc_w 275
    //   27: invokestatic 114	com/flurry/sdk/eo:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   30: aload_0
    //   31: monitorexit
    //   32: return
    //   33: aload_0
    //   34: aload_0
    //   35: getfield 66	com/flurry/sdk/dz:n	I
    //   38: iconst_1
    //   39: isub
    //   40: putfield 66	com/flurry/sdk/dz:n	I
    //   43: aload_0
    //   44: getfield 66	com/flurry/sdk/dz:n	I
    //   47: ifne -17 -> 30
    //   50: aload_0
    //   51: invokespecial 164	com/flurry/sdk/dz:i	()V
    //   54: goto -24 -> 30
    //   57: astore_1
    //   58: aload_0
    //   59: monitorexit
    //   60: aload_1
    //   61: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	this	dz
    //   57	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	30	57	finally
    //   33	54	57	finally
  }
  
  public void e()
  {
    this.p = null;
  }
  
  public Location f()
  {
    Location localLocation = null;
    if (this.p != null) {
      return this.p;
    }
    if (this.b)
    {
      localLocation = b(k());
      if (localLocation != null) {
        this.k = localLocation;
      }
      localLocation = this.k;
    }
    eo.a(4, c, "getLocation() = " + localLocation);
    return localLocation;
  }
  
  public void g()
  {
    this.n = 0;
    i();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/flurry/sdk/dz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */