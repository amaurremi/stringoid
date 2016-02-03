package com.google.android.gms.maps.model;

public final class StreetViewPanoramaOrientation$Builder
{
  public float bearing;
  public float tilt;
  
  public StreetViewPanoramaOrientation$Builder() {}
  
  public StreetViewPanoramaOrientation$Builder(StreetViewPanoramaOrientation paramStreetViewPanoramaOrientation)
  {
    this.bearing = paramStreetViewPanoramaOrientation.bearing;
    this.tilt = paramStreetViewPanoramaOrientation.tilt;
  }
  
  public Builder bearing(float paramFloat)
  {
    this.bearing = paramFloat;
    return this;
  }
  
  public StreetViewPanoramaOrientation build()
  {
    return new StreetViewPanoramaOrientation(this.tilt, this.bearing);
  }
  
  public Builder tilt(float paramFloat)
  {
    this.tilt = paramFloat;
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/maps/model/StreetViewPanoramaOrientation$Builder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */