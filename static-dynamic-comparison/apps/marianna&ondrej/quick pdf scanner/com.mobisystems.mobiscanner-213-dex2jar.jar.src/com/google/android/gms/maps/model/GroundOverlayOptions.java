package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.c;
import com.google.android.gms.dynamic.c.a;
import com.google.android.gms.maps.a.y;

public final class GroundOverlayOptions
  implements SafeParcelable
{
  public static final e Vf = new e();
  private float UW;
  private float Vd;
  private boolean Ve = true;
  private a Vg;
  private LatLng Vh;
  private float Vi;
  private float Vj;
  private LatLngBounds Vk;
  private float Vl = 0.0F;
  private float Vm = 0.5F;
  private float Vn = 0.5F;
  private final int qh;
  
  public GroundOverlayOptions()
  {
    this.qh = 1;
  }
  
  GroundOverlayOptions(int paramInt, IBinder paramIBinder, LatLng paramLatLng, float paramFloat1, float paramFloat2, LatLngBounds paramLatLngBounds, float paramFloat3, float paramFloat4, boolean paramBoolean, float paramFloat5, float paramFloat6, float paramFloat7)
  {
    this.qh = paramInt;
    this.Vg = new a(c.a.h(paramIBinder));
    this.Vh = paramLatLng;
    this.Vi = paramFloat1;
    this.Vj = paramFloat2;
    this.Vk = paramLatLngBounds;
    this.UW = paramFloat3;
    this.Vd = paramFloat4;
    this.Ve = paramBoolean;
    this.Vl = paramFloat5;
    this.Vm = paramFloat6;
    this.Vn = paramFloat7;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public float getBearing()
  {
    return this.UW;
  }
  
  public float getHeight()
  {
    return this.Vj;
  }
  
  public float getWidth()
  {
    return this.Vi;
  }
  
  public boolean isVisible()
  {
    return this.Ve;
  }
  
  int lX()
  {
    return this.qh;
  }
  
  public float uS()
  {
    return this.Vd;
  }
  
  IBinder uT()
  {
    return this.Vg.uM().asBinder();
  }
  
  public LatLng uU()
  {
    return this.Vh;
  }
  
  public LatLngBounds uV()
  {
    return this.Vk;
  }
  
  public float uW()
  {
    return this.Vl;
  }
  
  public float uX()
  {
    return this.Vm;
  }
  
  public float uY()
  {
    return this.Vn;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (y.uL())
    {
      q.a(this, paramParcel, paramInt);
      return;
    }
    e.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/maps/model/GroundOverlayOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */