package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.a.b;

public final class CircleOptions
  implements SafeParcelable
{
  public static final c CREATOR = new c();
  private final int a;
  private LatLng b = null;
  private double c = 0.0D;
  private float d = 10.0F;
  private int e = -16777216;
  private int f = 0;
  private float g = 0.0F;
  private boolean h = true;
  
  public CircleOptions()
  {
    this.a = 1;
  }
  
  CircleOptions(int paramInt1, LatLng paramLatLng, double paramDouble, float paramFloat1, int paramInt2, int paramInt3, float paramFloat2, boolean paramBoolean)
  {
    this.a = paramInt1;
    this.b = paramLatLng;
    this.c = paramDouble;
    this.d = paramFloat1;
    this.e = paramInt2;
    this.f = paramInt3;
    this.g = paramFloat2;
    this.h = paramBoolean;
  }
  
  int a()
  {
    return this.a;
  }
  
  public LatLng b()
  {
    return this.b;
  }
  
  public double c()
  {
    return this.c;
  }
  
  public float d()
  {
    return this.d;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int e()
  {
    return this.e;
  }
  
  public int f()
  {
    return this.f;
  }
  
  public float g()
  {
    return this.g;
  }
  
  public boolean h()
  {
    return this.h;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (b.a())
    {
      o.a(this, paramParcel, paramInt);
      return;
    }
    c.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/maps/model/CircleOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */