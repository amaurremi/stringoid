package com.flurry.sdk;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

class dz$a
  implements LocationListener
{
  public dz$a(dz paramdz) {}
  
  public void onLocationChanged(Location paramLocation)
  {
    if (paramLocation != null) {
      dz.a(this.a, paramLocation);
    }
    eo.a(4, dz.h(), "Location received");
    if (dz.a(this.a) >= 3)
    {
      eo.a(4, dz.h(), "Max location reports reached, stopping");
      dz.b(this.a);
    }
  }
  
  public void onProviderDisabled(String paramString) {}
  
  public void onProviderEnabled(String paramString) {}
  
  public void onStatusChanged(String paramString, int paramInt, Bundle paramBundle) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/flurry/sdk/dz$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */