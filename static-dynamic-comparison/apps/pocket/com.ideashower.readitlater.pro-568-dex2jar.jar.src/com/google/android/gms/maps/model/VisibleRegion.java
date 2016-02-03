package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.al;
import com.google.android.gms.internal.am;
import com.google.android.gms.maps.a.b;

public final class VisibleRegion
  implements SafeParcelable
{
  public static final m CREATOR = new m();
  public final LatLng a;
  public final LatLng b;
  public final LatLng c;
  public final LatLng d;
  public final LatLngBounds e;
  private final int f;
  
  VisibleRegion(int paramInt, LatLng paramLatLng1, LatLng paramLatLng2, LatLng paramLatLng3, LatLng paramLatLng4, LatLngBounds paramLatLngBounds)
  {
    this.f = paramInt;
    this.a = paramLatLng1;
    this.b = paramLatLng2;
    this.c = paramLatLng3;
    this.d = paramLatLng4;
    this.e = paramLatLngBounds;
  }
  
  int a()
  {
    return this.f;
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
      if (!(paramObject instanceof VisibleRegion)) {
        return false;
      }
      paramObject = (VisibleRegion)paramObject;
    } while ((this.a.equals(((VisibleRegion)paramObject).a)) && (this.b.equals(((VisibleRegion)paramObject).b)) && (this.c.equals(((VisibleRegion)paramObject).c)) && (this.d.equals(((VisibleRegion)paramObject).d)) && (this.e.equals(((VisibleRegion)paramObject).e)));
    return false;
  }
  
  public int hashCode()
  {
    return al.a(new Object[] { this.a, this.b, this.c, this.d, this.e });
  }
  
  public String toString()
  {
    return al.a(this).a("nearLeft", this.a).a("nearRight", this.b).a("farLeft", this.c).a("farRight", this.d).a("latLngBounds", this.e).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (b.a())
    {
      x.a(this, paramParcel, paramInt);
      return;
    }
    m.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/maps/model/VisibleRegion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */