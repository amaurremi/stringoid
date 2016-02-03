package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.r;

public final class CircleOptions
  implements SafeParcelable
{
  public static final CircleOptionsCreator CREATOR = new CircleOptionsCreator();
  private LatLng Cr = null;
  private double Cs = 0.0D;
  private float Ct = 10.0F;
  private int Cu = -16777216;
  private int Cv = 0;
  private float Cw = 0.0F;
  private boolean Cx = true;
  private final int kg;
  
  public CircleOptions()
  {
    this.kg = 1;
  }
  
  CircleOptions(int paramInt1, LatLng paramLatLng, double paramDouble, float paramFloat1, int paramInt2, int paramInt3, float paramFloat2, boolean paramBoolean)
  {
    this.kg = paramInt1;
    this.Cr = paramLatLng;
    this.Cs = paramDouble;
    this.Ct = paramFloat1;
    this.Cu = paramInt2;
    this.Cv = paramInt3;
    this.Cw = paramFloat2;
    this.Cx = paramBoolean;
  }
  
  public CircleOptions center(LatLng paramLatLng)
  {
    this.Cr = paramLatLng;
    return this;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public CircleOptions fillColor(int paramInt)
  {
    this.Cv = paramInt;
    return this;
  }
  
  public LatLng getCenter()
  {
    return this.Cr;
  }
  
  public int getFillColor()
  {
    return this.Cv;
  }
  
  public double getRadius()
  {
    return this.Cs;
  }
  
  public int getStrokeColor()
  {
    return this.Cu;
  }
  
  public float getStrokeWidth()
  {
    return this.Ct;
  }
  
  int getVersionCode()
  {
    return this.kg;
  }
  
  public float getZIndex()
  {
    return this.Cw;
  }
  
  public boolean isVisible()
  {
    return this.Cx;
  }
  
  public CircleOptions radius(double paramDouble)
  {
    this.Cs = paramDouble;
    return this;
  }
  
  public CircleOptions strokeColor(int paramInt)
  {
    this.Cu = paramInt;
    return this;
  }
  
  public CircleOptions strokeWidth(float paramFloat)
  {
    this.Ct = paramFloat;
    return this;
  }
  
  public CircleOptions visible(boolean paramBoolean)
  {
    this.Cx = paramBoolean;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (r.eD())
    {
      b.a(this, paramParcel, paramInt);
      return;
    }
    CircleOptionsCreator.a(this, paramParcel, paramInt);
  }
  
  public CircleOptions zIndex(float paramFloat)
  {
    this.Cw = paramFloat;
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/maps/model/CircleOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */