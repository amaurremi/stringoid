package com.mapbar.android.location;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

public final class CellLocationProvider
{
  public static final int AVAILABLE = 2;
  public static final int OUT_OF_SERVICE = 0;
  public static final int TEMPORARILY_UNAVAILABLE = 1;
  private static CellLocationProvider a;
  private b b;
  
  public CellLocationProvider(Context paramContext)
  {
    this.b = b.a(paramContext);
  }
  
  public static CellLocationProvider getInstance(Context paramContext)
  {
    if (a == null) {
      a = new CellLocationProvider(paramContext);
    }
    return a;
  }
  
  public final String addLocationListener(LocationListener paramLocationListener)
  {
    return this.b.a(paramLocationListener);
  }
  
  public final void clearLocationListener()
  {
    this.b.o();
  }
  
  protected final Object clone()
    throws CloneNotSupportedException
  {
    return super.clone();
  }
  
  public final void disableLocation()
  {
    this.b.n();
  }
  
  public final void enableLocation()
  {
    this.b.m();
  }
  
  protected final void finalize()
    throws Throwable
  {
    super.finalize();
  }
  
  public final int getAccuracy()
  {
    b localb = this.b;
    return b.a();
  }
  
  public final String getName()
  {
    b localb = this.b;
    return b.b();
  }
  
  public final int getPowerRequirement()
  {
    b localb = this.b;
    return b.c();
  }
  
  public final int getStatus(Bundle paramBundle)
  {
    return this.b.k();
  }
  
  public final long getStatusUpdateTime()
  {
    return this.b.l();
  }
  
  public final boolean hasMonetaryCost()
  {
    b localb = this.b;
    return b.d();
  }
  
  public final boolean meetsCriteria(Criteria paramCriteria)
  {
    return this.b.a(paramCriteria);
  }
  
  public final boolean removeLocationListener(String paramString)
  {
    return this.b.a(paramString);
  }
  
  public final boolean requiresCell()
  {
    b localb = this.b;
    return b.e();
  }
  
  public final boolean requiresNetwork()
  {
    b localb = this.b;
    return b.f();
  }
  
  public final boolean requiresSatellite()
  {
    b localb = this.b;
    return b.g();
  }
  
  public final boolean supportsAltitude()
  {
    b localb = this.b;
    return b.h();
  }
  
  public final boolean supportsBearing()
  {
    b localb = this.b;
    return b.i();
  }
  
  public final boolean supportsSpeed()
  {
    b localb = this.b;
    return b.j();
  }
  
  public final void updateLocation(Location paramLocation)
  {
    this.b.a(paramLocation);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/mapbar/android/location/CellLocationProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */