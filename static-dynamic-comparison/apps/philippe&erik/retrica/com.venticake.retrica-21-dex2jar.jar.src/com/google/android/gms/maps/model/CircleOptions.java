package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.v;

public final class CircleOptions
  implements SafeParcelable
{
  public static final CircleOptionsCreator CREATOR = new CircleOptionsCreator();
  private LatLng aas = null;
  private double aat = 0.0D;
  private float aau = 10.0F;
  private int aav = -16777216;
  private int aaw = 0;
  private float aax = 0.0F;
  private boolean aay = true;
  private final int xM;
  
  public CircleOptions()
  {
    this.xM = 1;
  }
  
  CircleOptions(int paramInt1, LatLng paramLatLng, double paramDouble, float paramFloat1, int paramInt2, int paramInt3, float paramFloat2, boolean paramBoolean)
  {
    this.xM = paramInt1;
    this.aas = paramLatLng;
    this.aat = paramDouble;
    this.aau = paramFloat1;
    this.aav = paramInt2;
    this.aaw = paramInt3;
    this.aax = paramFloat2;
    this.aay = paramBoolean;
  }
  
  public CircleOptions center(LatLng paramLatLng)
  {
    this.aas = paramLatLng;
    return this;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public CircleOptions fillColor(int paramInt)
  {
    this.aaw = paramInt;
    return this;
  }
  
  public LatLng getCenter()
  {
    return this.aas;
  }
  
  public int getFillColor()
  {
    return this.aaw;
  }
  
  public double getRadius()
  {
    return this.aat;
  }
  
  public int getStrokeColor()
  {
    return this.aav;
  }
  
  public float getStrokeWidth()
  {
    return this.aau;
  }
  
  int getVersionCode()
  {
    return this.xM;
  }
  
  public float getZIndex()
  {
    return this.aax;
  }
  
  public boolean isVisible()
  {
    return this.aay;
  }
  
  public CircleOptions radius(double paramDouble)
  {
    this.aat = paramDouble;
    return this;
  }
  
  public CircleOptions strokeColor(int paramInt)
  {
    this.aav = paramInt;
    return this;
  }
  
  public CircleOptions strokeWidth(float paramFloat)
  {
    this.aau = paramFloat;
    return this;
  }
  
  public CircleOptions visible(boolean paramBoolean)
  {
    this.aay = paramBoolean;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (v.jL())
    {
      b.a(this, paramParcel, paramInt);
      return;
    }
    CircleOptionsCreator.a(this, paramParcel, paramInt);
  }
  
  public CircleOptions zIndex(float paramFloat)
  {
    this.aax = paramFloat;
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/maps/model/CircleOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */