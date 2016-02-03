package com.jtpgodorncrqoeurl;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
import java.util.Iterator;
import java.util.List;

public class AdLocationController
  extends AdController
{
  private LocationManager c;
  private boolean d = false;
  private K e;
  private K f;
  private int g;
  private boolean h = false;
  
  public AdLocationController(AdView paramAdView, Context paramContext)
  {
    super(paramAdView, paramContext);
    try
    {
      this.c = ((LocationManager)paramContext.getSystemService("location"));
      if (this.c.getProvider("gps") != null) {
        this.e = new K(this, paramContext, this, "gps");
      }
      if (this.c.getProvider("network") != null) {
        this.f = new K(this, paramContext, this, "network");
      }
      this.d = true;
      return;
    }
    catch (SecurityException paramAdView) {}
  }
  
  private static String a(Location paramLocation)
  {
    return "{ lat: " + paramLocation.getLatitude() + ", lon: " + paramLocation.getLongitude() + ", acc: " + paramLocation.getAccuracy() + "}";
  }
  
  public void allowLocationServices(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public boolean allowLocationServices()
  {
    return this.h;
  }
  
  public void fail()
  {
    Log.e("AdLocationController", "Location can't be determined");
    this.b.injectJavaScript("window.ormmaview.fireErrorEvent(\"Location cannot be identified\", \"AdOrmmaLocationController\")");
  }
  
  public String getLocation()
  {
    Log.d("AdLocationController", "getLocation: hasPermission: " + this.d);
    if (!this.d) {}
    Object localObject;
    do
    {
      return null;
      Iterator localIterator = this.c.getProviders(true).iterator();
      localObject = null;
      while (localIterator.hasNext())
      {
        Location localLocation = this.c.getLastKnownLocation((String)localIterator.next());
        localObject = localLocation;
        if (localLocation != null) {
          localObject = localLocation;
        }
      }
      Log.d("AdLocationController", "getLocation: " + localObject);
    } while (localObject == null);
    return a((Location)localObject);
  }
  
  public void startLocationListener()
  {
    if (this.g == 0)
    {
      if (this.f != null) {
        this.f.a();
      }
      if (this.e != null) {
        this.e.a();
      }
    }
    this.g += 1;
  }
  
  public void stopAllListeners()
  {
    this.g = 0;
    try
    {
      this.e.b();
      try
      {
        this.f.b();
        return;
      }
      catch (Exception localException1) {}
    }
    catch (Exception localException2)
    {
      for (;;) {}
    }
  }
  
  public void stopLocationListener()
  {
    this.g -= 1;
    if (this.g == 0)
    {
      if (this.f != null) {
        this.f.b();
      }
      if (this.e != null) {
        this.e.b();
      }
    }
  }
  
  public void success(Location paramLocation)
  {
    paramLocation = "window.ormmaview.fireChangeEvent({ location: " + a(paramLocation) + "})";
    Log.d("AdLocationController", paramLocation);
    this.b.injectJavaScript(paramLocation);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/rage meme camera free/com.troll.face-25-dex2jar.jar!/com/jtpgodorncrqoeurl/AdLocationController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */