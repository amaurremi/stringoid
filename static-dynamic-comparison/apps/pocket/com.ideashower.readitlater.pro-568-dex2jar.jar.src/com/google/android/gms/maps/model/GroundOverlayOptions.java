package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class GroundOverlayOptions
  implements SafeParcelable
{
  public static final d CREATOR = new d();
  private final int a;
  private a b;
  private LatLng c;
  private float d;
  private float e;
  private LatLngBounds f;
  private float g;
  private float h;
  private boolean i = true;
  private float j = 0.0F;
  private float k = 0.5F;
  private float l = 0.5F;
  
  public GroundOverlayOptions()
  {
    this.a = 1;
  }
  
  GroundOverlayOptions(int paramInt, IBinder paramIBinder, LatLng paramLatLng, float paramFloat1, float paramFloat2, LatLngBounds paramLatLngBounds, float paramFloat3, float paramFloat4, boolean paramBoolean, float paramFloat5, float paramFloat6, float paramFloat7)
  {
    this.a = paramInt;
    this.b = new a(com.google.android.gms.a.b.a(paramIBinder));
    this.c = paramLatLng;
    this.d = paramFloat1;
    this.e = paramFloat2;
    this.f = paramLatLngBounds;
    this.g = paramFloat3;
    this.h = paramFloat4;
    this.i = paramBoolean;
    this.j = paramFloat5;
    this.k = paramFloat6;
    this.l = paramFloat7;
  }
  
  IBinder a()
  {
    return this.b.a().asBinder();
  }
  
  int b()
  {
    return this.a;
  }
  
  public LatLng c()
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
  
  public float e()
  {
    return this.e;
  }
  
  public LatLngBounds f()
  {
    return this.f;
  }
  
  public float g()
  {
    return this.g;
  }
  
  public float h()
  {
    return this.h;
  }
  
  public float i()
  {
    return this.j;
  }
  
  public float j()
  {
    return this.k;
  }
  
  public float k()
  {
    return this.l;
  }
  
  public boolean l()
  {
    return this.i;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (com.google.android.gms.maps.a.b.a())
    {
      p.a(this, paramParcel, paramInt);
      return;
    }
    d.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/maps/model/GroundOverlayOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */