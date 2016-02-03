package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.a.y;

public final class LatLng
  implements SafeParcelable
{
  public static final g Vo = new g();
  public final double Vp;
  public final double Vq;
  private final int qh;
  
  public LatLng(double paramDouble1, double paramDouble2)
  {
    this(1, paramDouble1, paramDouble2);
  }
  
  LatLng(int paramInt, double paramDouble1, double paramDouble2)
  {
    this.qh = paramInt;
    if ((-180.0D <= paramDouble2) && (paramDouble2 < 180.0D)) {}
    for (this.Vq = paramDouble2;; this.Vq = (((paramDouble2 - 180.0D) % 360.0D + 360.0D) % 360.0D - 180.0D))
    {
      this.Vp = Math.max(-90.0D, Math.min(90.0D, paramDouble1));
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
      if (!(paramObject instanceof LatLng)) {
        return false;
      }
      paramObject = (LatLng)paramObject;
    } while ((Double.doubleToLongBits(this.Vp) == Double.doubleToLongBits(((LatLng)paramObject).Vp)) && (Double.doubleToLongBits(this.Vq) == Double.doubleToLongBits(((LatLng)paramObject).Vq)));
    return false;
  }
  
  public int hashCode()
  {
    long l = Double.doubleToLongBits(this.Vp);
    int i = (int)(l ^ l >>> 32);
    l = Double.doubleToLongBits(this.Vq);
    return (i + 31) * 31 + (int)(l ^ l >>> 32);
  }
  
  int lX()
  {
    return this.qh;
  }
  
  public String toString()
  {
    return "lat/lng: (" + this.Vp + "," + this.Vq + ")";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (y.uL())
    {
      s.a(this, paramParcel, paramInt);
      return;
    }
    g.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/maps/model/LatLng.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */