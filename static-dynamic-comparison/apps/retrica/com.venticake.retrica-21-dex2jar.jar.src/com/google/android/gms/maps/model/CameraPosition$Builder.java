package com.google.android.gms.maps.model;

public final class CameraPosition$Builder
{
  private LatLng aan;
  private float aao;
  private float aap;
  private float aaq;
  
  public CameraPosition$Builder() {}
  
  public CameraPosition$Builder(CameraPosition paramCameraPosition)
  {
    this.aan = paramCameraPosition.target;
    this.aao = paramCameraPosition.zoom;
    this.aap = paramCameraPosition.tilt;
    this.aaq = paramCameraPosition.bearing;
  }
  
  public Builder bearing(float paramFloat)
  {
    this.aaq = paramFloat;
    return this;
  }
  
  public CameraPosition build()
  {
    return new CameraPosition(this.aan, this.aao, this.aap, this.aaq);
  }
  
  public Builder target(LatLng paramLatLng)
  {
    this.aan = paramLatLng;
    return this;
  }
  
  public Builder tilt(float paramFloat)
  {
    this.aap = paramFloat;
    return this;
  }
  
  public Builder zoom(float paramFloat)
  {
    this.aao = paramFloat;
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/maps/model/CameraPosition$Builder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */