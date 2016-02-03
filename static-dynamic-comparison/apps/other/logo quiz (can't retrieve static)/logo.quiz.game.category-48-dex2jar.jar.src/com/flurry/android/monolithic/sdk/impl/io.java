package com.flurry.android.monolithic.sdk.impl;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

class io
  implements LocationListener
{
  public io(in paramin) {}
  
  public void onLocationChanged(Location paramLocation)
  {
    if (paramLocation != null) {
      in.a(this.a, paramLocation);
    }
  }
  
  public void onProviderDisabled(String paramString) {}
  
  public void onProviderEnabled(String paramString) {}
  
  public void onStatusChanged(String paramString, int paramInt, Bundle paramBundle) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/io.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */