package org.osmdroid.util;

import org.osmdroid.api.IPosition;

public class Position
  implements IPosition
{
  private float mBearing;
  private boolean mHasBearing;
  private boolean mHasZoomLevel;
  private final double mLatitude;
  private final double mLongitude;
  private float mZoomLevel;
  
  public Position(double paramDouble1, double paramDouble2)
  {
    this.mLatitude = paramDouble1;
    this.mLongitude = paramDouble2;
  }
  
  public float getBearing()
  {
    return this.mBearing;
  }
  
  public double getLatitude()
  {
    return this.mLatitude;
  }
  
  public double getLongitude()
  {
    return this.mLongitude;
  }
  
  public float getZoomLevel()
  {
    return this.mZoomLevel;
  }
  
  public boolean hasBearing()
  {
    return this.mHasBearing;
  }
  
  public boolean hasZoomLevel()
  {
    return this.mHasZoomLevel;
  }
  
  public void setBearing(float paramFloat)
  {
    this.mHasBearing = true;
    this.mBearing = paramFloat;
  }
  
  public void setZoomLevel(float paramFloat)
  {
    this.mHasZoomLevel = true;
    this.mZoomLevel = paramFloat;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/util/Position.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */