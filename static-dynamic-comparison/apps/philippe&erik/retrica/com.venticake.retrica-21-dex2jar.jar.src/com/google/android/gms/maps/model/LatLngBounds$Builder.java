package com.google.android.gms.maps.model;

import com.google.android.gms.internal.hm;

public final class LatLngBounds$Builder
{
  private double aaK = Double.POSITIVE_INFINITY;
  private double aaL = Double.NEGATIVE_INFINITY;
  private double aaM = NaN.0D;
  private double aaN = NaN.0D;
  
  private boolean d(double paramDouble)
  {
    boolean bool = false;
    if (this.aaM <= this.aaN) {
      return (this.aaM <= paramDouble) && (paramDouble <= this.aaN);
    }
    if ((this.aaM <= paramDouble) || (paramDouble <= this.aaN)) {
      bool = true;
    }
    return bool;
  }
  
  public LatLngBounds build()
  {
    if (!Double.isNaN(this.aaM)) {}
    for (boolean bool = true;; bool = false)
    {
      hm.a(bool, "no included points");
      return new LatLngBounds(new LatLng(this.aaK, this.aaM), new LatLng(this.aaL, this.aaN));
    }
  }
  
  public Builder include(LatLng paramLatLng)
  {
    this.aaK = Math.min(this.aaK, paramLatLng.latitude);
    this.aaL = Math.max(this.aaL, paramLatLng.latitude);
    double d = paramLatLng.longitude;
    if (Double.isNaN(this.aaM))
    {
      this.aaM = d;
      this.aaN = d;
    }
    while (d(d)) {
      return this;
    }
    if (LatLngBounds.d(this.aaM, d) < LatLngBounds.e(this.aaN, d))
    {
      this.aaM = d;
      return this;
    }
    this.aaN = d;
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/maps/model/LatLngBounds$Builder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */