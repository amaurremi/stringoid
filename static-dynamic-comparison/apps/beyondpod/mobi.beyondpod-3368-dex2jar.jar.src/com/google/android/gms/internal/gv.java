package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.LocationRequest;

public final class gv
  implements SafeParcelable
{
  public static final gw CREATOR = new gw();
  final int kg;
  private final LocationRequest yl;
  private final gt ym;
  
  public gv(int paramInt, LocationRequest paramLocationRequest, gt paramgt)
  {
    this.kg = paramInt;
    this.yl = paramLocationRequest;
    this.ym = paramgt;
  }
  
  public LocationRequest dS()
  {
    return this.yl;
  }
  
  public gt dT()
  {
    return this.ym;
  }
  
  public int describeContents()
  {
    gw localgw = CREATOR;
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof gv)) {
        return false;
      }
      paramObject = (gv)paramObject;
    } while ((this.yl.equals(((gv)paramObject).yl)) && (this.ym.equals(((gv)paramObject).ym)));
    return false;
  }
  
  public int hashCode()
  {
    return ee.hashCode(new Object[] { this.yl, this.ym });
  }
  
  public String toString()
  {
    return ee.e(this).a("locationRequest", this.yl).a("filter", this.ym).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    gw localgw = CREATOR;
    gw.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/gv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */