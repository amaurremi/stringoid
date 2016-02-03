package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.v;

public final class CircleOptions
  implements SafeParcelable
{
  public static final CircleOptionsCreator CREATOR = new CircleOptionsCreator();
  private LatLng aap = null;
  private double aaq = 0.0D;
  private float aar = 10.0F;
  private int aas = -16777216;
  private int aat = 0;
  private float aau = 0.0F;
  private boolean aav = true;
  private final int xJ;
  
  public CircleOptions()
  {
    this.xJ = 1;
  }
  
  CircleOptions(int paramInt1, LatLng paramLatLng, double paramDouble, float paramFloat1, int paramInt2, int paramInt3, float paramFloat2, boolean paramBoolean)
  {
    this.xJ = paramInt1;
    this.aap = paramLatLng;
    this.aaq = paramDouble;
    this.aar = paramFloat1;
    this.aas = paramInt2;
    this.aat = paramInt3;
    this.aau = paramFloat2;
    this.aav = paramBoolean;
  }
  
  public CircleOptions center(LatLng paramLatLng)
  {
    this.aap = paramLatLng;
    return this;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public CircleOptions fillColor(int paramInt)
  {
    this.aat = paramInt;
    return this;
  }
  
  public LatLng getCenter()
  {
    return this.aap;
  }
  
  public int getFillColor()
  {
    return this.aat;
  }
  
  public double getRadius()
  {
    return this.aaq;
  }
  
  public int getStrokeColor()
  {
    return this.aas;
  }
  
  public float getStrokeWidth()
  {
    return this.aar;
  }
  
  int getVersionCode()
  {
    return this.xJ;
  }
  
  public float getZIndex()
  {
    return this.aau;
  }
  
  public boolean isVisible()
  {
    return this.aav;
  }
  
  public CircleOptions radius(double paramDouble)
  {
    this.aaq = paramDouble;
    return this;
  }
  
  public CircleOptions strokeColor(int paramInt)
  {
    this.aas = paramInt;
    return this;
  }
  
  public CircleOptions strokeWidth(float paramFloat)
  {
    this.aar = paramFloat;
    return this;
  }
  
  public CircleOptions visible(boolean paramBoolean)
  {
    this.aav = paramBoolean;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (v.jG())
    {
      b.a(this, paramParcel, paramInt);
      return;
    }
    CircleOptionsCreator.a(this, paramParcel, paramInt);
  }
  
  public CircleOptions zIndex(float paramFloat)
  {
    this.aau = paramFloat;
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/maps/model/CircleOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */