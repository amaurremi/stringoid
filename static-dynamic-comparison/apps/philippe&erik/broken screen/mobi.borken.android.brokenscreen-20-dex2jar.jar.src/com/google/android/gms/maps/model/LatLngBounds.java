package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.hl;
import com.google.android.gms.internal.hl.a;
import com.google.android.gms.internal.hn;
import com.google.android.gms.maps.internal.v;

public final class LatLngBounds
  implements SafeParcelable
{
  public static final LatLngBoundsCreator CREATOR = new LatLngBoundsCreator();
  public final LatLng northeast;
  public final LatLng southwest;
  private final int xJ;
  
  LatLngBounds(int paramInt, LatLng paramLatLng1, LatLng paramLatLng2)
  {
    hn.b(paramLatLng1, "null southwest");
    hn.b(paramLatLng2, "null northeast");
    if (paramLatLng2.latitude >= paramLatLng1.latitude) {}
    for (boolean bool = true;; bool = false)
    {
      hn.b(bool, "southern latitude exceeds northern latitude (%s > %s)", new Object[] { Double.valueOf(paramLatLng1.latitude), Double.valueOf(paramLatLng2.latitude) });
      this.xJ = paramInt;
      this.southwest = paramLatLng1;
      this.northeast = paramLatLng2;
      return;
    }
  }
  
  public LatLngBounds(LatLng paramLatLng1, LatLng paramLatLng2)
  {
    this(1, paramLatLng1, paramLatLng2);
  }
  
  private static double b(double paramDouble1, double paramDouble2)
  {
    return (paramDouble1 - paramDouble2 + 360.0D) % 360.0D;
  }
  
  public static Builder builder()
  {
    return new Builder();
  }
  
  private static double c(double paramDouble1, double paramDouble2)
  {
    return (paramDouble2 - paramDouble1 + 360.0D) % 360.0D;
  }
  
  private boolean c(double paramDouble)
  {
    return (this.southwest.latitude <= paramDouble) && (paramDouble <= this.northeast.latitude);
  }
  
  private boolean d(double paramDouble)
  {
    boolean bool = false;
    if (this.southwest.longitude <= this.northeast.longitude) {
      return (this.southwest.longitude <= paramDouble) && (paramDouble <= this.northeast.longitude);
    }
    if ((this.southwest.longitude <= paramDouble) || (paramDouble <= this.northeast.longitude)) {
      bool = true;
    }
    return bool;
  }
  
  public boolean contains(LatLng paramLatLng)
  {
    return (c(paramLatLng.latitude)) && (d(paramLatLng.longitude));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof LatLngBounds)) {
        return false;
      }
      paramObject = (LatLngBounds)paramObject;
    } while ((this.southwest.equals(((LatLngBounds)paramObject).southwest)) && (this.northeast.equals(((LatLngBounds)paramObject).northeast)));
    return false;
  }
  
  public LatLng getCenter()
  {
    double d2 = (this.southwest.latitude + this.northeast.latitude) / 2.0D;
    double d1 = this.northeast.longitude;
    double d3 = this.southwest.longitude;
    if (d3 <= d1) {}
    for (d1 = (d1 + d3) / 2.0D;; d1 = (d1 + 360.0D + d3) / 2.0D) {
      return new LatLng(d2, d1);
    }
  }
  
  int getVersionCode()
  {
    return this.xJ;
  }
  
  public int hashCode()
  {
    return hl.hashCode(new Object[] { this.southwest, this.northeast });
  }
  
  public LatLngBounds including(LatLng paramLatLng)
  {
    double d4 = Math.min(this.southwest.latitude, paramLatLng.latitude);
    double d5 = Math.max(this.northeast.latitude, paramLatLng.latitude);
    double d2 = this.northeast.longitude;
    double d3 = this.southwest.longitude;
    double d1 = paramLatLng.longitude;
    if (!d(d1)) {
      if (b(d3, d1) >= c(d2, d1)) {}
    }
    for (;;)
    {
      return new LatLngBounds(new LatLng(d4, d1), new LatLng(d5, d2));
      d2 = d1;
      d1 = d3;
      continue;
      d1 = d3;
    }
  }
  
  public String toString()
  {
    return hl.e(this).a("southwest", this.southwest).a("northeast", this.northeast).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (v.jG())
    {
      d.a(this, paramParcel, paramInt);
      return;
    }
    LatLngBoundsCreator.a(this, paramParcel, paramInt);
  }
  
  public static final class Builder
  {
    private double aaH = Double.POSITIVE_INFINITY;
    private double aaI = Double.NEGATIVE_INFINITY;
    private double aaJ = NaN.0D;
    private double aaK = NaN.0D;
    
    private boolean d(double paramDouble)
    {
      boolean bool = false;
      if (this.aaJ <= this.aaK) {
        return (this.aaJ <= paramDouble) && (paramDouble <= this.aaK);
      }
      if ((this.aaJ <= paramDouble) || (paramDouble <= this.aaK)) {
        bool = true;
      }
      return bool;
    }
    
    public LatLngBounds build()
    {
      if (!Double.isNaN(this.aaJ)) {}
      for (boolean bool = true;; bool = false)
      {
        hn.a(bool, "no included points");
        return new LatLngBounds(new LatLng(this.aaH, this.aaJ), new LatLng(this.aaI, this.aaK));
      }
    }
    
    public Builder include(LatLng paramLatLng)
    {
      this.aaH = Math.min(this.aaH, paramLatLng.latitude);
      this.aaI = Math.max(this.aaI, paramLatLng.latitude);
      double d = paramLatLng.longitude;
      if (Double.isNaN(this.aaJ))
      {
        this.aaJ = d;
        this.aaK = d;
      }
      while (d(d)) {
        return this;
      }
      if (LatLngBounds.d(this.aaJ, d) < LatLngBounds.e(this.aaK, d))
      {
        this.aaJ = d;
        return this;
      }
      this.aaK = d;
      return this;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/maps/model/LatLngBounds.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */