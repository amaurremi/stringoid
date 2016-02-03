package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.v;

public final class CircleOptions
  implements SafeParcelable
{
  public static final c CREATOR = new c();
  private final int BR;
  private float ajA = 0.0F;
  private boolean ajB = true;
  private LatLng ajv = null;
  private double ajw = 0.0D;
  private float ajx = 10.0F;
  private int ajy = -16777216;
  private int ajz = 0;
  
  public CircleOptions()
  {
    this.BR = 1;
  }
  
  CircleOptions(int paramInt1, LatLng paramLatLng, double paramDouble, float paramFloat1, int paramInt2, int paramInt3, float paramFloat2, boolean paramBoolean)
  {
    this.BR = paramInt1;
    this.ajv = paramLatLng;
    this.ajw = paramDouble;
    this.ajx = paramFloat1;
    this.ajy = paramInt2;
    this.ajz = paramInt3;
    this.ajA = paramFloat2;
    this.ajB = paramBoolean;
  }
  
  public CircleOptions center(LatLng paramLatLng)
  {
    this.ajv = paramLatLng;
    return this;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public CircleOptions fillColor(int paramInt)
  {
    this.ajz = paramInt;
    return this;
  }
  
  public LatLng getCenter()
  {
    return this.ajv;
  }
  
  public int getFillColor()
  {
    return this.ajz;
  }
  
  public double getRadius()
  {
    return this.ajw;
  }
  
  public int getStrokeColor()
  {
    return this.ajy;
  }
  
  public float getStrokeWidth()
  {
    return this.ajx;
  }
  
  int getVersionCode()
  {
    return this.BR;
  }
  
  public float getZIndex()
  {
    return this.ajA;
  }
  
  public boolean isVisible()
  {
    return this.ajB;
  }
  
  public CircleOptions radius(double paramDouble)
  {
    this.ajw = paramDouble;
    return this;
  }
  
  public CircleOptions strokeColor(int paramInt)
  {
    this.ajy = paramInt;
    return this;
  }
  
  public CircleOptions strokeWidth(float paramFloat)
  {
    this.ajx = paramFloat;
    return this;
  }
  
  public CircleOptions visible(boolean paramBoolean)
  {
    this.ajB = paramBoolean;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (v.mK())
    {
      d.a(this, paramParcel, paramInt);
      return;
    }
    c.a(this, paramParcel, paramInt);
  }
  
  public CircleOptions zIndex(float paramFloat)
  {
    this.ajA = paramFloat;
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/maps/model/CircleOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */