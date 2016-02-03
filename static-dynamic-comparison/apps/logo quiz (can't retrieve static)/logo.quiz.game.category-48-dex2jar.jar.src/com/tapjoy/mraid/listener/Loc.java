package com.tapjoy.mraid.listener;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import com.tapjoy.mraid.controller.MraidLocation;

public class Loc
  implements LocationListener
{
  private LocationManager mLocMan;
  MraidLocation mOrmmaLocationController;
  private String mProvider;
  
  public Loc(Context paramContext, int paramInt, MraidLocation paramMraidLocation, String paramString)
  {
    this.mOrmmaLocationController = paramMraidLocation;
    this.mLocMan = ((LocationManager)paramContext.getSystemService("location"));
    this.mProvider = paramString;
  }
  
  public void onLocationChanged(Location paramLocation)
  {
    this.mOrmmaLocationController.success(paramLocation);
  }
  
  public void onProviderDisabled(String paramString)
  {
    this.mOrmmaLocationController.fail();
  }
  
  public void onProviderEnabled(String paramString) {}
  
  public void onStatusChanged(String paramString, int paramInt, Bundle paramBundle)
  {
    if (paramInt == 0) {
      this.mOrmmaLocationController.fail();
    }
  }
  
  public void start()
  {
    this.mLocMan.requestLocationUpdates(this.mProvider, 0L, 0.0F, this);
  }
  
  public void stop()
  {
    this.mLocMan.removeUpdates(this);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/tapjoy/mraid/listener/Loc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */