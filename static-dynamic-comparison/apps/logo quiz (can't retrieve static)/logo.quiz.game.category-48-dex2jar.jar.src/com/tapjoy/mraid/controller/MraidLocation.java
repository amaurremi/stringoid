package com.tapjoy.mraid.controller;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import com.tapjoy.TapjoyLog;
import com.tapjoy.mraid.listener.Loc;
import com.tapjoy.mraid.view.MraidView;
import java.util.Iterator;
import java.util.List;

public class MraidLocation
  extends Abstract
{
  private static final String TAG = "MRAID Location";
  final int INTERVAL = 1000;
  private boolean allowLocationServices = false;
  private boolean hasPermission = false;
  private Loc mGps;
  private int mLocListenerCount;
  private LocationManager mLocationManager;
  private Loc mNetwork;
  
  public MraidLocation(MraidView paramMraidView, Context paramContext)
  {
    super(paramMraidView, paramContext);
    try
    {
      this.mLocationManager = ((LocationManager)paramContext.getSystemService("location"));
      if (this.mLocationManager.getProvider("gps") != null) {
        this.mGps = new Loc(paramContext, 1000, this, "gps");
      }
      if (this.mLocationManager.getProvider("network") != null) {
        this.mNetwork = new Loc(paramContext, 1000, this, "network");
      }
      this.hasPermission = true;
      return;
    }
    catch (SecurityException paramMraidView) {}
  }
  
  private static String formatLocation(Location paramLocation)
  {
    return "{ lat: " + paramLocation.getLatitude() + ", lon: " + paramLocation.getLongitude() + ", acc: " + paramLocation.getAccuracy() + "}";
  }
  
  public void allowLocationServices(boolean paramBoolean)
  {
    this.allowLocationServices = paramBoolean;
  }
  
  public boolean allowLocationServices()
  {
    return this.allowLocationServices;
  }
  
  public void fail()
  {
    TapjoyLog.e("MRAID Location", "Location can't be determined");
    this.mMraidView.injectMraidJavaScript("window.mraidview.fireErrorEvent(\"Location cannot be identified\", \"OrmmaLocationController\")");
  }
  
  public String getLocation()
  {
    TapjoyLog.d("MRAID Location", "getLocation: hasPermission: " + this.hasPermission);
    if (!this.hasPermission) {
      return null;
    }
    Iterator localIterator = this.mLocationManager.getProviders(true).iterator();
    Object localObject = null;
    while (localIterator.hasNext())
    {
      Location localLocation = this.mLocationManager.getLastKnownLocation((String)localIterator.next());
      localObject = localLocation;
      if (localLocation != null) {
        localObject = localLocation;
      }
    }
    TapjoyLog.d("MRAID Location", "getLocation: " + localObject);
    if (localObject != null) {
      return formatLocation((Location)localObject);
    }
    return null;
  }
  
  public void startLocationListener()
  {
    if (this.mLocListenerCount == 0)
    {
      if (this.mNetwork != null) {
        this.mNetwork.start();
      }
      if (this.mGps != null) {
        this.mGps.start();
      }
    }
    this.mLocListenerCount += 1;
  }
  
  public void stopAllListeners()
  {
    this.mLocListenerCount = 0;
    try
    {
      this.mGps.stop();
      try
      {
        this.mNetwork.stop();
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
    this.mLocListenerCount -= 1;
    if (this.mLocListenerCount == 0)
    {
      if (this.mNetwork != null) {
        this.mNetwork.stop();
      }
      if (this.mGps != null) {
        this.mGps.stop();
      }
    }
  }
  
  public void success(Location paramLocation)
  {
    paramLocation = "window.mraidview.fireChangeEvent({ location: " + formatLocation(paramLocation) + "})";
    TapjoyLog.d("MRAID Location", paramLocation);
    this.mMraidView.injectMraidJavaScript(paramLocation);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/tapjoy/mraid/controller/MraidLocation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */