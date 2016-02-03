package com.google.android.gms.maps;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.a;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

public final class StreetViewPanoramaOptions
  implements SafeParcelable
{
  public static final StreetViewPanoramaOptionsCreator CREATOR = new StreetViewPanoramaOptionsCreator();
  private StreetViewPanoramaCamera ZV;
  private String ZW;
  private LatLng ZX;
  private Integer ZY;
  private Boolean ZZ = Boolean.valueOf(true);
  private Boolean Zt;
  private Boolean Zz = Boolean.valueOf(true);
  private Boolean aaa = Boolean.valueOf(true);
  private Boolean aab = Boolean.valueOf(true);
  private final int xM;
  
  public StreetViewPanoramaOptions()
  {
    this.xM = 1;
  }
  
  StreetViewPanoramaOptions(int paramInt, StreetViewPanoramaCamera paramStreetViewPanoramaCamera, String paramString, LatLng paramLatLng, Integer paramInteger, byte paramByte1, byte paramByte2, byte paramByte3, byte paramByte4, byte paramByte5)
  {
    this.xM = paramInt;
    this.ZV = paramStreetViewPanoramaCamera;
    this.ZX = paramLatLng;
    this.ZY = paramInteger;
    this.ZW = paramString;
    this.ZZ = a.a(paramByte1);
    this.Zz = a.a(paramByte2);
    this.aaa = a.a(paramByte3);
    this.aab = a.a(paramByte4);
    this.Zt = a.a(paramByte5);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Boolean getPanningGesturesEnabled()
  {
    return this.aaa;
  }
  
  public String getPanoramaId()
  {
    return this.ZW;
  }
  
  public LatLng getPosition()
  {
    return this.ZX;
  }
  
  public Integer getRadius()
  {
    return this.ZY;
  }
  
  public Boolean getStreetNamesEnabled()
  {
    return this.aab;
  }
  
  public StreetViewPanoramaCamera getStreetViewPanoramaCamera()
  {
    return this.ZV;
  }
  
  public Boolean getUseViewLifecycleInFragment()
  {
    return this.Zt;
  }
  
  public Boolean getUserNavigationEnabled()
  {
    return this.ZZ;
  }
  
  int getVersionCode()
  {
    return this.xM;
  }
  
  public Boolean getZoomGesturesEnabled()
  {
    return this.Zz;
  }
  
  byte jD()
  {
    return a.c(this.ZZ);
  }
  
  byte jE()
  {
    return a.c(this.aaa);
  }
  
  byte jF()
  {
    return a.c(this.aab);
  }
  
  byte jr()
  {
    return a.c(this.Zt);
  }
  
  byte jv()
  {
    return a.c(this.Zz);
  }
  
  public StreetViewPanoramaOptions panningGesturesEnabled(boolean paramBoolean)
  {
    this.aaa = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public StreetViewPanoramaOptions panoramaCamera(StreetViewPanoramaCamera paramStreetViewPanoramaCamera)
  {
    this.ZV = paramStreetViewPanoramaCamera;
    return this;
  }
  
  public StreetViewPanoramaOptions panoramaId(String paramString)
  {
    this.ZW = paramString;
    return this;
  }
  
  public StreetViewPanoramaOptions position(LatLng paramLatLng)
  {
    this.ZX = paramLatLng;
    return this;
  }
  
  public StreetViewPanoramaOptions position(LatLng paramLatLng, Integer paramInteger)
  {
    this.ZX = paramLatLng;
    this.ZY = paramInteger;
    return this;
  }
  
  public StreetViewPanoramaOptions streetNamesEnabled(boolean paramBoolean)
  {
    this.aab = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public StreetViewPanoramaOptions useViewLifecycleInFragment(boolean paramBoolean)
  {
    this.Zt = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public StreetViewPanoramaOptions userNavigationEnabled(boolean paramBoolean)
  {
    this.ZZ = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    StreetViewPanoramaOptionsCreator.a(this, paramParcel, paramInt);
  }
  
  public StreetViewPanoramaOptions zoomGesturesEnabled(boolean paramBoolean)
  {
    this.Zz = Boolean.valueOf(paramBoolean);
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/maps/StreetViewPanoramaOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */