package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.v;

public final class CircleOptions
  implements SafeParcelable
{
  public static final CircleOptionsCreator CREATOR = new CircleOptionsCreator();
  private LatLng SI = null;
  private double SJ = 0.0D;
  private float SK = 10.0F;
  private int SL = -16777216;
  private int SM = 0;
  private float SN = 0.0F;
  private boolean SO = true;
  private final int xH;
  
  public CircleOptions()
  {
    this.xH = 1;
  }
  
  CircleOptions(int paramInt1, LatLng paramLatLng, double paramDouble, float paramFloat1, int paramInt2, int paramInt3, float paramFloat2, boolean paramBoolean)
  {
    this.xH = paramInt1;
    this.SI = paramLatLng;
    this.SJ = paramDouble;
    this.SK = paramFloat1;
    this.SL = paramInt2;
    this.SM = paramInt3;
    this.SN = paramFloat2;
    this.SO = paramBoolean;
  }
  
  public CircleOptions center(LatLng paramLatLng)
  {
    this.SI = paramLatLng;
    return this;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public CircleOptions fillColor(int paramInt)
  {
    this.SM = paramInt;
    return this;
  }
  
  public LatLng getCenter()
  {
    return this.SI;
  }
  
  public int getFillColor()
  {
    return this.SM;
  }
  
  public double getRadius()
  {
    return this.SJ;
  }
  
  public int getStrokeColor()
  {
    return this.SL;
  }
  
  public float getStrokeWidth()
  {
    return this.SK;
  }
  
  int getVersionCode()
  {
    return this.xH;
  }
  
  public float getZIndex()
  {
    return this.SN;
  }
  
  public boolean isVisible()
  {
    return this.SO;
  }
  
  public CircleOptions radius(double paramDouble)
  {
    this.SJ = paramDouble;
    return this;
  }
  
  public CircleOptions strokeColor(int paramInt)
  {
    this.SL = paramInt;
    return this;
  }
  
  public CircleOptions strokeWidth(float paramFloat)
  {
    this.SK = paramFloat;
    return this;
  }
  
  public CircleOptions visible(boolean paramBoolean)
  {
    this.SO = paramBoolean;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (v.iB())
    {
      b.a(this, paramParcel, paramInt);
      return;
    }
    CircleOptionsCreator.a(this, paramParcel, paramInt);
  }
  
  public CircleOptions zIndex(float paramFloat)
  {
    this.SN = paramFloat;
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/maps/model/CircleOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */