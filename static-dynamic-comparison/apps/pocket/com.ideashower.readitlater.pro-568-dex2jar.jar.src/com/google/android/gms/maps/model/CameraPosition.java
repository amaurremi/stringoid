package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.al;
import com.google.android.gms.internal.am;
import com.google.android.gms.internal.an;

public final class CameraPosition
  implements SafeParcelable
{
  public static final b CREATOR = new b();
  public final LatLng a;
  public final float b;
  public final float c;
  public final float d;
  private final int e;
  
  CameraPosition(int paramInt, LatLng paramLatLng, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    an.a(paramLatLng, "null camera target");
    if ((0.0F <= paramFloat2) && (paramFloat2 <= 90.0F)) {}
    for (boolean bool = true;; bool = false)
    {
      an.b(bool, "Tilt needs to be between 0 and 90 inclusive");
      this.e = paramInt;
      this.a = paramLatLng;
      this.b = paramFloat1;
      this.c = (paramFloat2 + 0.0F);
      paramFloat1 = paramFloat3;
      if (paramFloat3 <= 0.0D) {
        paramFloat1 = paramFloat3 % 360.0F + 360.0F;
      }
      this.d = (paramFloat1 % 360.0F);
      return;
    }
  }
  
  int a()
  {
    return this.e;
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
      if (!(paramObject instanceof CameraPosition)) {
        return false;
      }
      paramObject = (CameraPosition)paramObject;
    } while ((this.a.equals(((CameraPosition)paramObject).a)) && (Float.floatToIntBits(this.b) == Float.floatToIntBits(((CameraPosition)paramObject).b)) && (Float.floatToIntBits(this.c) == Float.floatToIntBits(((CameraPosition)paramObject).c)) && (Float.floatToIntBits(this.d) == Float.floatToIntBits(((CameraPosition)paramObject).d)));
    return false;
  }
  
  public int hashCode()
  {
    return al.a(new Object[] { this.a, Float.valueOf(this.b), Float.valueOf(this.c), Float.valueOf(this.d) });
  }
  
  public String toString()
  {
    return al.a(this).a("target", this.a).a("zoom", Float.valueOf(this.b)).a("tilt", Float.valueOf(this.c)).a("bearing", Float.valueOf(this.d)).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (com.google.android.gms.maps.a.b.a())
    {
      n.a(this, paramParcel, paramInt);
      return;
    }
    b.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/maps/model/CameraPosition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */