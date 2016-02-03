package com.greystripe.sdk;

import android.content.Context;
import android.location.Location;
import android.webkit.CookieManager;
import android.webkit.WebViewDatabase;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Timer;

abstract class c
  implements DeviceInfo.LocationListener, GSAd
{
  protected boolean a = false;
  protected boolean b = false;
  private final long c = 30000L;
  private Context d;
  private aa e;
  private v f = new v(this, (byte)0);
  private r g = new r(this, (byte)0);
  private ArrayList h;
  private Timer i;
  private a j;
  private WeakReference k;
  private boolean l = false;
  private boolean m = false;
  private boolean n = false;
  private boolean o = false;
  private boolean p = false;
  private boolean q = false;
  private s r;
  private boolean s = false;
  private boolean t = false;
  private boolean u = false;
  private int v = -1;
  
  c(Context paramContext)
  {
    bm.a();
    this.v = -1;
    this.d = paramContext.getApplicationContext();
    bj.a(paramContext);
    paramContext = DeviceInfo.getDeviceInfoController(paramContext).b();
    if (paramContext != null) {
      bj.a(paramContext);
    }
    a("guid", bj.b());
    if (!bj.b(bk.AD_SERVER_URL)) {
      bj.b("http://adsx.greystripe.com/openx/www/delivery/ia.php");
    }
    bd.b("adServerUrl: " + bj.c(), new Object[0]);
    this.e = new aa(this.d, new p(this, (byte)0));
    paramContext = DeviceInfo.getDeviceInfoController(this.d);
    this.e.addJavascriptInterface(new m(this, (byte)0), "AdState");
    this.r = new s(this, (byte)0);
    this.e.addJavascriptInterface(this.r, "MraidController");
    this.e.addJavascriptInterface(paramContext, "DeviceInfo");
    this.e.addJavascriptInterface(bh.a(this.d), "NetworkStatus");
    this.j = new a(this.d, this.e);
    this.e.addJavascriptInterface(this.j, "Accelerometer");
    a("hid", paramContext.getHashedAndroidId("SHA-1"));
    a("mhid", paramContext.getHashedAndroidId("MD5"));
    this.g.add("port");
    this.g.add("land");
    this.g.add("asdk-" + GSSdkInfo.getVersion());
    this.g.add(paramContext.getAndroidVersion());
    if (paramContext.hasTelephony()) {
      this.g.add("phone");
    }
    if (paramContext.isTablet()) {
      this.g.add("tablet");
    }
    if (this.d.checkCallingOrSelfPermission("android.permission.CAMERA") == 0) {
      this.g.add("camera");
    }
    if (this.d.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
      this.g.add("saveimage");
    }
    if (this.d.checkCallingOrSelfPermission("android.permission.WRITE_CONTACTS") == 0) {
      this.g.add("contacts");
    }
    if (this.d.checkCallingOrSelfPermission("android.permission.WRITE_CALENDAR") == 0) {
      this.g.add("calendar");
    }
    a("lang", paramContext.getLanguage());
    a("screen_size", paramContext.getWidthPixels() + "x" + paramContext.getHeightPixels());
    a("res", Float.toString(paramContext.getDensity()));
    DeviceInfo.addLocationListener(this);
  }
  
  private void k()
  {
    this.n = false;
    this.m = false;
    this.l = false;
    this.o = false;
    this.b = false;
  }
  
  private void l()
  {
    bm.a(new d(this));
  }
  
  private GSAd m()
  {
    Object localObject = this;
    if (this.k != null)
    {
      localObject = this;
      if (this.k.get() != null) {
        localObject = (GSAd)this.k.get();
      }
    }
    return (GSAd)localObject;
  }
  
  private void n()
  {
    if (this.t) {}
    do
    {
      return;
      i();
    } while (this.h == null);
    bm.a(new f(this, m()));
  }
  
  /* Error */
  private void o()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 370
    //   5: iconst_0
    //   6: anewarray 4	java/lang/Object
    //   9: invokestatic 154	com/greystripe/sdk/bd:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   12: aload_0
    //   13: iconst_1
    //   14: putfield 71	com/greystripe/sdk/c:o	Z
    //   17: aload_0
    //   18: getfield 65	com/greystripe/sdk/c:l	Z
    //   21: ifeq +16 -> 37
    //   24: ldc_w 372
    //   27: iconst_0
    //   28: anewarray 4	java/lang/Object
    //   31: invokestatic 154	com/greystripe/sdk/bd:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   34: aload_0
    //   35: monitorexit
    //   36: return
    //   37: aload_0
    //   38: getfield 69	com/greystripe/sdk/c:n	Z
    //   41: ifeq -7 -> 34
    //   44: aload_0
    //   45: iconst_1
    //   46: putfield 73	com/greystripe/sdk/c:p	Z
    //   49: ldc_w 374
    //   52: iconst_0
    //   53: anewarray 4	java/lang/Object
    //   56: invokestatic 154	com/greystripe/sdk/bd:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   59: aload_0
    //   60: invokespecial 304	com/greystripe/sdk/c:k	()V
    //   63: aload_0
    //   64: getfield 164	com/greystripe/sdk/c:e	Lcom/greystripe/sdk/aa;
    //   67: ldc_w 376
    //   70: invokevirtual 377	com/greystripe/sdk/aa:b	(Ljava/lang/String;)V
    //   73: goto -39 -> 34
    //   76: astore_1
    //   77: aload_0
    //   78: monitorexit
    //   79: aload_1
    //   80: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	81	0	this	c
    //   76	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	34	76	finally
    //   37	73	76	finally
  }
  
  private void p()
  {
    try
    {
      if (this.i != null)
      {
        bd.b("STOPPING READY timer.", new Object[0]);
        this.i.cancel();
        this.i = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  abstract void a();
  
  protected final void a(GSAdErrorCode paramGSAdErrorCode)
  {
    if (this.h == null) {
      return;
    }
    bm.a(new g(this, m(), paramGSAdErrorCode));
  }
  
  final void a(am paramam)
  {
    this.k = new WeakReference(paramam);
  }
  
  protected final void a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return;
    }
    this.f.put(paramString1, paramString2);
  }
  
  public void addListener(GSAdListener paramGSAdListener)
  {
    if (this.h == null) {
      this.h = new ArrayList();
    }
    this.h.add(paramGSAdListener);
  }
  
  abstract void b();
  
  abstract void c();
  
  final void d()
  {
    this.j.stop();
  }
  
  final boolean e()
  {
    return this.p;
  }
  
  final void f()
  {
    this.e.b("EventHandler.broadcastEvent('imagedidsave');");
  }
  
  protected final void g()
  {
    bd.d("An ad is cached and ready to display. Cannot request another ad at this time.", new Object[0]);
    n();
  }
  
  public int getId()
  {
    return this.v;
  }
  
  protected void h()
  {
    int i1 = 0;
    for (;;)
    {
      try
      {
        bd.b("requestAd", new Object[0]);
        if (bj.g())
        {
          if (i1 == 0)
          {
            bd.e("Please de-integrate the Greystripe SDK from your app. Its ad requests are no longer being honored.", new Object[0]);
            a(GSAdErrorCode.UNEXPECTED_ERROR);
          }
        }
        else
        {
          String str = CookieManager.getInstance().getCookie(bj.c() + '?' + this.f.a());
          if (str == null)
          {
            i1 = 1;
            continue;
          }
          if (str.indexOf("SNOOKI") == -1)
          {
            i1 = 1;
            continue;
          }
          bj.f();
          continue;
        }
        if (bj.b(bk.GUID)) {
          break label147;
        }
      }
      finally {}
      bd.e("Missing application identifier GUID.", new Object[0]);
      a(GSAdErrorCode.INVALID_APPLICATION_IDENTIFIER);
      continue;
      label147:
      if (this.n)
      {
        g();
      }
      else if (this.l)
      {
        bd.d("Currently fetching an ad. Cannot request another ad at this time.", new Object[0]);
      }
      else
      {
        p();
        this.v = -1;
        k();
        l();
        Object localObject2 = bh.a(this.d);
        if (!((bh)localObject2).a())
        {
          a(GSAdErrorCode.NO_NETWORK);
        }
        else
        {
          this.l = true;
          this.p = false;
          this.q = false;
          this.t = false;
          this.u = false;
          if (((bh)localObject2).b()) {
            this.g.add("wifi");
          }
          for (;;)
          {
            localObject2 = DeviceInfo.a();
            bd.e("last location: " + localObject2, new Object[0]);
            if (localObject2 != null)
            {
              a("lat", Double.toString(((Location)localObject2).getLatitude()));
              a("long", Double.toString(((Location)localObject2).getLongitude()));
              a("alt", Double.toString(((Location)localObject2).getAltitude()));
              a("gpsacy", Float.toString(((Location)localObject2).getAccuracy()));
              a("gpstime", Long.toString(((Location)localObject2).getTime()));
            }
            a("source", this.g.a());
            this.e.stopLoading();
            if (WebViewDatabase.getInstance(this.d) != null) {
              break label436;
            }
            a(GSAdErrorCode.UNEXPECTED_ERROR);
            break;
            if (this.g.contains("wifi")) {
              this.g.remove("wifi");
            }
          }
          label436:
          this.e.a(bj.c() + '?' + this.f.a());
        }
      }
    }
  }
  
  protected final void i()
  {
    bm.a(new e(this));
  }
  
  public boolean isAdReady()
  {
    if (!bh.a(this.d).a()) {
      bd.b("Network status: not connected", new Object[0]);
    }
    while ((!this.m) || (!this.n)) {
      return false;
    }
    return true;
  }
  
  protected final aa j()
  {
    return this.e;
  }
  
  public void onLocationUpdated(Location paramLocation)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LocationHandler.updateLocation(");
    localStringBuilder.append(paramLocation.getLatitude());
    localStringBuilder.append(", ");
    localStringBuilder.append(paramLocation.getLongitude());
    localStringBuilder.append(", ");
    localStringBuilder.append(paramLocation.getAltitude());
    localStringBuilder.append(", ");
    localStringBuilder.append(paramLocation.getAccuracy());
    localStringBuilder.append(", ");
    localStringBuilder.append(paramLocation.getTime());
    localStringBuilder.append(");");
    this.e.b(localStringBuilder.toString());
  }
  
  public void removeListener(GSAdListener paramGSAdListener)
  {
    if (this.h != null) {
      this.h.remove(paramGSAdListener);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/greystripe/sdk/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */