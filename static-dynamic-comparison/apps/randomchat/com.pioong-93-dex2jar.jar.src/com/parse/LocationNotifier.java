package com.parse;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

class LocationNotifier
{
  private static Location fakeLocation = null;
  public static final String testProviderName = "Test";
  
  static Task<ParseGeoPoint> getCurrentLocationAsync(long paramLong, Criteria paramCriteria)
  {
    Parse.checkContext();
    final Task.TaskCompletionSource localTaskCompletionSource = Task.create();
    Capture localCapture = new Capture();
    final LocationManager localLocationManager = (LocationManager)Parse.applicationContext.getSystemService("location");
    final LocationListener local1 = new LocationListener()
    {
      public void onLocationChanged(Location paramAnonymousLocation)
      {
        ((ScheduledFuture)LocationNotifier.this.get()).cancel(true);
        ParseGeoPoint localParseGeoPoint = null;
        if (paramAnonymousLocation != null) {
          localParseGeoPoint = new ParseGeoPoint(paramAnonymousLocation.getLatitude(), paramAnonymousLocation.getLongitude());
        }
        localTaskCompletionSource.trySetResult(localParseGeoPoint);
        localLocationManager.removeUpdates(this);
      }
      
      public void onProviderDisabled(String paramAnonymousString) {}
      
      public void onProviderEnabled(String paramAnonymousString) {}
      
      public void onStatusChanged(String paramAnonymousString, int paramAnonymousInt, Bundle paramAnonymousBundle) {}
    };
    localCapture.set(ParseCommand.networkThreadPool.schedule(new Runnable()
    {
      public void run()
      {
        LocationNotifier.this.trySetError(new ParseException(124, "location fetch timed out"));
        localLocationManager.removeUpdates(local1);
      }
    }, paramLong, TimeUnit.MILLISECONDS));
    paramCriteria = localLocationManager.getBestProvider(paramCriteria, true);
    if (paramCriteria != null) {
      localLocationManager.requestLocationUpdates(paramCriteria, 0L, 0.0F, local1);
    }
    if (fakeLocation != null) {
      local1.onLocationChanged(fakeLocation);
    }
    return localTaskCompletionSource.getTask();
  }
  
  static void setFakeLocation(Location paramLocation)
  {
    fakeLocation = paramLocation;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/parse/LocationNotifier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */