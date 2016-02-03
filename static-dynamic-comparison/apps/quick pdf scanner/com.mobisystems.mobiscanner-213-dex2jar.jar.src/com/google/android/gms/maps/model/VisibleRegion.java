package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.cz;
import com.google.android.gms.internal.cz.a;

public final class VisibleRegion
  implements SafeParcelable
{
  public static final n VR = new n();
  public final LatLng VS;
  public final LatLng VT;
  public final LatLng VU;
  public final LatLng VV;
  public final LatLngBounds VW;
  private final int qh;
  
  VisibleRegion(int paramInt, LatLng paramLatLng1, LatLng paramLatLng2, LatLng paramLatLng3, LatLng paramLatLng4, LatLngBounds paramLatLngBounds)
  {
    this.qh = paramInt;
    this.VS = paramLatLng1;
    this.VT = paramLatLng2;
    this.VU = paramLatLng3;
    this.VV = paramLatLng4;
    this.VW = paramLatLngBounds;
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
    } while ((this.VS.equals(((VisibleRegion)paramObject).VS)) && (this.VT.equals(((VisibleRegion)paramObject).VT)) && (this.VU.equals(((VisibleRegion)paramObject).VU)) && (this.VV.equals(((VisibleRegion)paramObject).VV)) && (this.VW.equals(((VisibleRegion)paramObject).VW)));
    return false;
  }
  
  public int hashCode()
  {
    return cz.hashCode(new Object[] { this.VS, this.VT, this.VU, this.VV, this.VW });
  }
  
  int lX()
  {
    return this.qh;
  }
  
  public String toString()
  {
    return cz.M(this).a("nearLeft", this.VS).a("nearRight", this.VT).a("farLeft", this.VU).a("farRight", this.VV).a("latLngBounds", this.VW).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (com.google.android.gms.maps.a.y.uL())
    {
      y.a(this, paramParcel, paramInt);
      return;
    }
    n.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/maps/model/VisibleRegion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */