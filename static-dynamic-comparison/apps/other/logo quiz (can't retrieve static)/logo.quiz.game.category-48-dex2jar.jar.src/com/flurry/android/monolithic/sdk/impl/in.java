package com.flurry.android.monolithic.sdk.impl;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Looper;
import android.text.TextUtils;

public class in
  implements id
{
  private static final String c = in.class.getSimpleName();
  private static in l;
  boolean a = false;
  boolean b;
  private final long d = 1800000L;
  private final long e = 0L;
  private LocationManager f;
  private Criteria g;
  private Location h;
  private io i = new io(this);
  private String j;
  private int k = 0;
  
  private in()
  {
    ic localic = ib.a();
    this.g = ((Criteria)localic.a("LocationCriteria"));
    localic.a("LocationCriteria", this);
    ja.a(4, c, "initSettings, LocationCriteria = " + this.g);
    this.b = ((Boolean)localic.a("ReportLocation")).booleanValue();
    localic.a("ReportLocation", this);
    ja.a(4, c, "initSettings, ReportLocation = " + this.b);
  }
  
  public static in a()
  {
    try
    {
      if (l == null) {
        l = new in();
      }
      in localin = l;
      return localin;
    }
    finally {}
  }
  
  private void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.f.requestLocationUpdates(paramString, 1800000L, 0.0F, this.i, Looper.getMainLooper());
    }
  }
  
  private Location b(String paramString)
  {
    Location localLocation = null;
    if (!TextUtils.isEmpty(paramString)) {
      localLocation = this.f.getLastKnownLocation(paramString);
    }
    return localLocation;
  }
  
  private void g()
  {
    this.f.removeUpdates(this.i);
    this.a = false;
    ja.a(4, c, "LocationProvider stoped");
  }
  
  private void h()
  {
    if (!this.b) {}
    do
    {
      return;
      localObject = ia.a().b();
    } while ((((Context)localObject).checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0) && (((Context)localObject).checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") != 0));
    g();
    Object localObject = i();
    a((String)localObject);
    this.h = b((String)localObject);
    this.a = true;
    ja.a(4, c, "LocationProvider started");
  }
  
  private String i()
  {
    Criteria localCriteria = this.g;
    Object localObject = localCriteria;
    if (localCriteria == null) {
      localObject = new Criteria();
    }
    if (TextUtils.isEmpty(this.j)) {}
    for (localObject = this.f.getBestProvider((Criteria)localObject, true);; localObject = this.j)
    {
      ja.a(4, c, "provider = " + (String)localObject);
      return (String)localObject;
    }
  }
  
  public void a(String paramString, Object paramObject)
  {
    if (paramString.equals("LocationCriteria"))
    {
      this.g = ((Criteria)paramObject);
      ja.a(4, c, "onSettingUpdate, LocationCriteria = " + this.g);
      if (this.a) {
        h();
      }
    }
    do
    {
      return;
      if (!paramString.equals("ReportLocation")) {
        break label138;
      }
      this.b = ((Boolean)paramObject).booleanValue();
      ja.a(4, c, "onSettingUpdate, ReportLocation = " + this.b);
      if (!this.b) {
        break;
      }
    } while ((this.a) || (this.k <= 0));
    h();
    return;
    g();
    return;
    label138:
    ja.a(6, c, "LocationProvider internal error! Had to be LocationCriteria or ReportLocation key.");
  }
  
  /* Error */
  public void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 128	com/flurry/android/monolithic/sdk/impl/in:f	Landroid/location/LocationManager;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: invokestatic 155	com/flurry/android/monolithic/sdk/impl/ia:a	()Lcom/flurry/android/monolithic/sdk/impl/ia;
    //   18: invokevirtual 158	com/flurry/android/monolithic/sdk/impl/ia:b	()Landroid/content/Context;
    //   21: ldc -52
    //   23: invokevirtual 207	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   26: checkcast 136	android/location/LocationManager
    //   29: putfield 128	com/flurry/android/monolithic/sdk/impl/in:f	Landroid/location/LocationManager;
    //   32: goto -21 -> 11
    //   35: astore_1
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_1
    //   39: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	40	0	this	in
    //   6	2	1	localLocationManager	LocationManager
    //   35	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	35	finally
    //   14	32	35	finally
  }
  
  public void c()
  {
    try
    {
      ja.a(4, c, "Location provider subscribed");
      this.k += 1;
      if (!this.a) {
        h();
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
    //   3: getstatic 37	com/flurry/android/monolithic/sdk/impl/in:c	Ljava/lang/String;
    //   6: ldc -45
    //   8: invokestatic 97	com/flurry/android/monolithic/sdk/impl/ja:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   11: aload_0
    //   12: getfield 51	com/flurry/android/monolithic/sdk/impl/in:k	I
    //   15: ifgt +20 -> 35
    //   18: bipush 6
    //   20: getstatic 37	com/flurry/android/monolithic/sdk/impl/in:c	Ljava/lang/String;
    //   23: ldc -43
    //   25: invokestatic 97	com/flurry/android/monolithic/sdk/impl/ja:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   28: aload_0
    //   29: invokespecial 170	com/flurry/android/monolithic/sdk/impl/in:g	()V
    //   32: aload_0
    //   33: monitorexit
    //   34: return
    //   35: aload_0
    //   36: aload_0
    //   37: getfield 51	com/flurry/android/monolithic/sdk/impl/in:k	I
    //   40: iconst_1
    //   41: isub
    //   42: putfield 51	com/flurry/android/monolithic/sdk/impl/in:k	I
    //   45: aload_0
    //   46: getfield 51	com/flurry/android/monolithic/sdk/impl/in:k	I
    //   49: ifne -17 -> 32
    //   52: aload_0
    //   53: invokespecial 170	com/flurry/android/monolithic/sdk/impl/in:g	()V
    //   56: goto -24 -> 32
    //   59: astore_1
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_1
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	this	in
    //   59	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	32	59	finally
    //   35	56	59	finally
  }
  
  public Location e()
  {
    Location localLocation = null;
    if (this.b)
    {
      localLocation = b(i());
      if (localLocation != null) {
        this.h = localLocation;
      }
      localLocation = this.h;
    }
    ja.a(4, c, "getLocation() = " + localLocation);
    return localLocation;
  }
  
  public void f()
  {
    this.k = 0;
    g();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/in.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */