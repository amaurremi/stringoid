package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.cz;
import com.google.android.gms.internal.cz.a;
import com.google.android.gms.internal.dc;
import com.google.android.gms.maps.a.y;

public final class LatLngBounds
  implements SafeParcelable
{
  public static final f Vr = new f();
  public final LatLng Vs;
  public final LatLng Vt;
  private final int qh;
  
  LatLngBounds(int paramInt, LatLng paramLatLng1, LatLng paramLatLng2)
  {
    dc.e(paramLatLng1, "null southwest");
    dc.e(paramLatLng2, "null northeast");
    if (paramLatLng2.Vp >= paramLatLng1.Vp) {}
    for (boolean bool = true;; bool = false)
    {
      dc.a(bool, "southern latitude exceeds northern latitude (%s > %s)", new Object[] { Double.valueOf(paramLatLng1.Vp), Double.valueOf(paramLatLng2.Vp) });
      this.qh = paramInt;
      this.Vs = paramLatLng1;
      this.Vt = paramLatLng2;
      return;
    }
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
    } while ((this.Vs.equals(((LatLngBounds)paramObject).Vs)) && (this.Vt.equals(((LatLngBounds)paramObject).Vt)));
    return false;
  }
  
  public int hashCode()
  {
    return cz.hashCode(new Object[] { this.Vs, this.Vt });
  }
  
  int lX()
  {
    return this.qh;
  }
  
  public String toString()
  {
    return cz.M(this).a("southwest", this.Vs).a("northeast", this.Vt).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (y.uL())
    {
      r.a(this, paramParcel, paramInt);
      return;
    }
    f.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/maps/model/LatLngBounds.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */