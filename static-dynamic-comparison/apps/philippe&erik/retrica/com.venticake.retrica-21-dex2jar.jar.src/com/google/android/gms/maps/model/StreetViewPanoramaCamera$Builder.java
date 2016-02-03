package com.google.android.gms.maps.model;

public final class StreetViewPanoramaCamera$Builder
{
  public float bearing;
  public float tilt;
  public float zoom;
  
  public StreetViewPanoramaCamera$Builder() {}
  
  public StreetViewPanoramaCamera$Builder(StreetViewPanoramaCamera paramStreetViewPanoramaCamera)
  {
    this.zoom = paramStreetViewPanoramaCamera.zoom;
    this.bearing = paramStreetViewPanoramaCamera.bearing;
    this.tilt = paramStreetViewPanoramaCamera.tilt;
  }
  
  public Builder bearing(float paramFloat)
  {
    this.bearing = paramFloat;
    return this;
  }
  
  public StreetViewPanoramaCamera build()
  {
    return new StreetViewPanoramaCamera(this.zoom, this.tilt, this.bearing);
  }
  
  public Builder orientation(StreetViewPanoramaOrientation paramStreetViewPanoramaOrientation)
  {
    this.tilt = paramStreetViewPanoramaOrientation.tilt;
    this.bearing = paramStreetViewPanoramaOrientation.bearing;
    return this;
  }
  
  public Builder tilt(float paramFloat)
  {
    this.tilt = paramFloat;
    return this;
  }
  
  public Builder zoom(float paramFloat)
  {
    this.zoom = paramFloat;
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/maps/model/StreetViewPanoramaCamera$Builder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */