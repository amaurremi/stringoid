package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.al;
import com.google.android.gms.internal.am;
import com.google.android.gms.internal.an;
import com.google.android.gms.maps.a.b;

public final class LatLngBounds
  implements SafeParcelable
{
  public static final e CREATOR = new e();
  public final LatLng a;
  public final LatLng b;
  private final int c;
  
  LatLngBounds(int paramInt, LatLng paramLatLng1, LatLng paramLatLng2)
  {
    an.a(paramLatLng1, "null southwest");
    an.a(paramLatLng2, "null northeast");
    if (paramLatLng2.a >= paramLatLng1.a) {}
    for (boolean bool = true;; bool = false)
    {
      an.a(bool, "southern latitude exceeds northern latitude (%s > %s)", new Object[] { Double.valueOf(paramLatLng1.a), Double.valueOf(paramLatLng2.a) });
      this.c = paramInt;
      this.a = paramLatLng1;
      this.b = paramLatLng2;
      return;
    }
  }
  
  int a()
  {
    return this.c;
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
    } while ((this.a.equals(((LatLngBounds)paramObject).a)) && (this.b.equals(((LatLngBounds)paramObject).b)));
    return false;
  }
  
  public int hashCode()
  {
    return al.a(new Object[] { this.a, this.b });
  }
  
  public String toString()
  {
    return al.a(this).a("southwest", this.a).a("northeast", this.b).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (b.a())
    {
      q.a(this, paramParcel, paramInt);
      return;
    }
    e.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/maps/model/LatLngBounds.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */