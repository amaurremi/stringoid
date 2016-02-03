package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.a.y;

public final class CircleOptions
  implements SafeParcelable
{
  public static final d UX = new d();
  private LatLng UY = null;
  private double UZ = 0.0D;
  private float Va = 10.0F;
  private int Vb = -16777216;
  private int Vc = 0;
  private float Vd = 0.0F;
  private boolean Ve = true;
  private final int qh;
  
  public CircleOptions()
  {
    this.qh = 1;
  }
  
  CircleOptions(int paramInt1, LatLng paramLatLng, double paramDouble, float paramFloat1, int paramInt2, int paramInt3, float paramFloat2, boolean paramBoolean)
  {
    this.qh = paramInt1;
    this.UY = paramLatLng;
    this.UZ = paramDouble;
    this.Va = paramFloat1;
    this.Vb = paramInt2;
    this.Vc = paramInt3;
    this.Vd = paramFloat2;
    this.Ve = paramBoolean;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public double getRadius()
  {
    return this.UZ;
  }
  
  public float getStrokeWidth()
  {
    return this.Va;
  }
  
  public boolean isVisible()
  {
    return this.Ve;
  }
  
  int lX()
  {
    return this.qh;
  }
  
  public LatLng uP()
  {
    return this.UY;
  }
  
  public int uQ()
  {
    return this.Vb;
  }
  
  public int uR()
  {
    return this.Vc;
  }
  
  public float uS()
  {
    return this.Vd;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (y.uL())
    {
      p.a(this, paramParcel, paramInt);
      return;
    }
    d.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/maps/model/CircleOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */