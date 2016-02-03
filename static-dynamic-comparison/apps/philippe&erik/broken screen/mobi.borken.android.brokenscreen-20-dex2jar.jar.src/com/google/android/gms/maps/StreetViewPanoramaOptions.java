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
  private StreetViewPanoramaCamera ZS;
  private String ZT;
  private LatLng ZU;
  private Integer ZV;
  private Boolean ZW = Boolean.valueOf(true);
  private Boolean ZX = Boolean.valueOf(true);
  private Boolean ZY = Boolean.valueOf(true);
  private Boolean Zq;
  private Boolean Zw = Boolean.valueOf(true);
  private final int xJ;
  
  public StreetViewPanoramaOptions()
  {
    this.xJ = 1;
  }
  
  StreetViewPanoramaOptions(int paramInt, StreetViewPanoramaCamera paramStreetViewPanoramaCamera, String paramString, LatLng paramLatLng, Integer paramInteger, byte paramByte1, byte paramByte2, byte paramByte3, byte paramByte4, byte paramByte5)
  {
    this.xJ = paramInt;
    this.ZS = paramStreetViewPanoramaCamera;
    this.ZU = paramLatLng;
    this.ZV = paramInteger;
    this.ZT = paramString;
    this.ZW = a.a(paramByte1);
    this.Zw = a.a(paramByte2);
    this.ZX = a.a(paramByte3);
    this.ZY = a.a(paramByte4);
    this.Zq = a.a(paramByte5);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Boolean getPanningGesturesEnabled()
  {
    return this.ZX;
  }
  
  public String getPanoramaId()
  {
    return this.ZT;
  }
  
  public LatLng getPosition()
  {
    return this.ZU;
  }
  
  public Integer getRadius()
  {
    return this.ZV;
  }
  
  public Boolean getStreetNamesEnabled()
  {
    return this.ZY;
  }
  
  public StreetViewPanoramaCamera getStreetViewPanoramaCamera()
  {
    return this.ZS;
  }
  
  public Boolean getUseViewLifecycleInFragment()
  {
    return this.Zq;
  }
  
  public Boolean getUserNavigationEnabled()
  {
    return this.ZW;
  }
  
  int getVersionCode()
  {
    return this.xJ;
  }
  
  public Boolean getZoomGesturesEnabled()
  {
    return this.Zw;
  }
  
  byte jA()
  {
    return a.c(this.ZY);
  }
  
  byte jm()
  {
    return a.c(this.Zq);
  }
  
  byte jq()
  {
    return a.c(this.Zw);
  }
  
  byte jy()
  {
    return a.c(this.ZW);
  }
  
  byte jz()
  {
    return a.c(this.ZX);
  }
  
  public StreetViewPanoramaOptions panningGesturesEnabled(boolean paramBoolean)
  {
    this.ZX = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public StreetViewPanoramaOptions panoramaCamera(StreetViewPanoramaCamera paramStreetViewPanoramaCamera)
  {
    this.ZS = paramStreetViewPanoramaCamera;
    return this;
  }
  
  public StreetViewPanoramaOptions panoramaId(String paramString)
  {
    this.ZT = paramString;
    return this;
  }
  
  public StreetViewPanoramaOptions position(LatLng paramLatLng)
  {
    this.ZU = paramLatLng;
    return this;
  }
  
  public StreetViewPanoramaOptions position(LatLng paramLatLng, Integer paramInteger)
  {
    this.ZU = paramLatLng;
    this.ZV = paramInteger;
    return this;
  }
  
  public StreetViewPanoramaOptions streetNamesEnabled(boolean paramBoolean)
  {
    this.ZY = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public StreetViewPanoramaOptions useViewLifecycleInFragment(boolean paramBoolean)
  {
    this.Zq = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public StreetViewPanoramaOptions userNavigationEnabled(boolean paramBoolean)
  {
    this.ZW = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    StreetViewPanoramaOptionsCreator.a(this, paramParcel, paramInt);
  }
  
  public StreetViewPanoramaOptions zoomGesturesEnabled(boolean paramBoolean)
  {
    this.Zw = Boolean.valueOf(paramBoolean);
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/maps/StreetViewPanoramaOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */