package com.google.android.gms.maps;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.a;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

public final class StreetViewPanoramaOptions
  implements SafeParcelable
{
  public static final c CREATOR = new c();
  private final int BR;
  private Boolean aiC = Boolean.valueOf(true);
  private StreetViewPanoramaCamera aiY;
  private String aiZ;
  private Boolean aiw;
  private LatLng aja;
  private Integer ajb;
  private Boolean ajc = Boolean.valueOf(true);
  private Boolean ajd = Boolean.valueOf(true);
  private Boolean aje = Boolean.valueOf(true);
  
  public StreetViewPanoramaOptions()
  {
    this.BR = 1;
  }
  
  StreetViewPanoramaOptions(int paramInt, StreetViewPanoramaCamera paramStreetViewPanoramaCamera, String paramString, LatLng paramLatLng, Integer paramInteger, byte paramByte1, byte paramByte2, byte paramByte3, byte paramByte4, byte paramByte5)
  {
    this.BR = paramInt;
    this.aiY = paramStreetViewPanoramaCamera;
    this.aja = paramLatLng;
    this.ajb = paramInteger;
    this.aiZ = paramString;
    this.ajc = a.a(paramByte1);
    this.aiC = a.a(paramByte2);
    this.ajd = a.a(paramByte3);
    this.aje = a.a(paramByte4);
    this.aiw = a.a(paramByte5);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Boolean getPanningGesturesEnabled()
  {
    return this.ajd;
  }
  
  public String getPanoramaId()
  {
    return this.aiZ;
  }
  
  public LatLng getPosition()
  {
    return this.aja;
  }
  
  public Integer getRadius()
  {
    return this.ajb;
  }
  
  public Boolean getStreetNamesEnabled()
  {
    return this.aje;
  }
  
  public StreetViewPanoramaCamera getStreetViewPanoramaCamera()
  {
    return this.aiY;
  }
  
  public Boolean getUseViewLifecycleInFragment()
  {
    return this.aiw;
  }
  
  public Boolean getUserNavigationEnabled()
  {
    return this.ajc;
  }
  
  int getVersionCode()
  {
    return this.BR;
  }
  
  public Boolean getZoomGesturesEnabled()
  {
    return this.aiC;
  }
  
  byte mC()
  {
    return a.c(this.ajc);
  }
  
  byte mD()
  {
    return a.c(this.ajd);
  }
  
  byte mE()
  {
    return a.c(this.aje);
  }
  
  byte mq()
  {
    return a.c(this.aiw);
  }
  
  byte mu()
  {
    return a.c(this.aiC);
  }
  
  public StreetViewPanoramaOptions panningGesturesEnabled(boolean paramBoolean)
  {
    this.ajd = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public StreetViewPanoramaOptions panoramaCamera(StreetViewPanoramaCamera paramStreetViewPanoramaCamera)
  {
    this.aiY = paramStreetViewPanoramaCamera;
    return this;
  }
  
  public StreetViewPanoramaOptions panoramaId(String paramString)
  {
    this.aiZ = paramString;
    return this;
  }
  
  public StreetViewPanoramaOptions position(LatLng paramLatLng)
  {
    this.aja = paramLatLng;
    return this;
  }
  
  public StreetViewPanoramaOptions position(LatLng paramLatLng, Integer paramInteger)
  {
    this.aja = paramLatLng;
    this.ajb = paramInteger;
    return this;
  }
  
  public StreetViewPanoramaOptions streetNamesEnabled(boolean paramBoolean)
  {
    this.aje = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public StreetViewPanoramaOptions useViewLifecycleInFragment(boolean paramBoolean)
  {
    this.aiw = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public StreetViewPanoramaOptions userNavigationEnabled(boolean paramBoolean)
  {
    this.ajc = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    c.a(this, paramParcel, paramInt);
  }
  
  public StreetViewPanoramaOptions zoomGesturesEnabled(boolean paramBoolean)
  {
    this.aiC = Boolean.valueOf(paramBoolean);
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/maps/StreetViewPanoramaOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */