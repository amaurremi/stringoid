package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.d.a;
import com.google.android.gms.maps.internal.v;

public final class MarkerOptions
  implements SafeParcelable
{
  public static final k CREATOR = new k();
  private final int BR;
  private String No;
  private boolean ajB = true;
  private float ajJ = 0.5F;
  private float ajK = 1.0F;
  private String ajS;
  private BitmapDescriptor ajT;
  private boolean ajU;
  private boolean ajV = false;
  private float ajW = 0.0F;
  private float ajX = 0.5F;
  private float ajY = 0.0F;
  private LatLng aja;
  private float mAlpha = 1.0F;
  
  public MarkerOptions()
  {
    this.BR = 1;
  }
  
  MarkerOptions(int paramInt, LatLng paramLatLng, String paramString1, String paramString2, IBinder paramIBinder, float paramFloat1, float paramFloat2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    this.BR = paramInt;
    this.aja = paramLatLng;
    this.No = paramString1;
    this.ajS = paramString2;
    if (paramIBinder == null) {}
    for (paramLatLng = null;; paramLatLng = new BitmapDescriptor(d.a.am(paramIBinder)))
    {
      this.ajT = paramLatLng;
      this.ajJ = paramFloat1;
      this.ajK = paramFloat2;
      this.ajU = paramBoolean1;
      this.ajB = paramBoolean2;
      this.ajV = paramBoolean3;
      this.ajW = paramFloat3;
      this.ajX = paramFloat4;
      this.ajY = paramFloat5;
      this.mAlpha = paramFloat6;
      return;
    }
  }
  
  public MarkerOptions alpha(float paramFloat)
  {
    this.mAlpha = paramFloat;
    return this;
  }
  
  public MarkerOptions anchor(float paramFloat1, float paramFloat2)
  {
    this.ajJ = paramFloat1;
    this.ajK = paramFloat2;
    return this;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public MarkerOptions draggable(boolean paramBoolean)
  {
    this.ajU = paramBoolean;
    return this;
  }
  
  public MarkerOptions flat(boolean paramBoolean)
  {
    this.ajV = paramBoolean;
    return this;
  }
  
  public float getAlpha()
  {
    return this.mAlpha;
  }
  
  public float getAnchorU()
  {
    return this.ajJ;
  }
  
  public float getAnchorV()
  {
    return this.ajK;
  }
  
  public BitmapDescriptor getIcon()
  {
    return this.ajT;
  }
  
  public float getInfoWindowAnchorU()
  {
    return this.ajX;
  }
  
  public float getInfoWindowAnchorV()
  {
    return this.ajY;
  }
  
  public LatLng getPosition()
  {
    return this.aja;
  }
  
  public float getRotation()
  {
    return this.ajW;
  }
  
  public String getSnippet()
  {
    return this.ajS;
  }
  
  public String getTitle()
  {
    return this.No;
  }
  
  int getVersionCode()
  {
    return this.BR;
  }
  
  public MarkerOptions icon(BitmapDescriptor paramBitmapDescriptor)
  {
    this.ajT = paramBitmapDescriptor;
    return this;
  }
  
  public MarkerOptions infoWindowAnchor(float paramFloat1, float paramFloat2)
  {
    this.ajX = paramFloat1;
    this.ajY = paramFloat2;
    return this;
  }
  
  public boolean isDraggable()
  {
    return this.ajU;
  }
  
  public boolean isFlat()
  {
    return this.ajV;
  }
  
  public boolean isVisible()
  {
    return this.ajB;
  }
  
  IBinder mN()
  {
    if (this.ajT == null) {
      return null;
    }
    return this.ajT.mm().asBinder();
  }
  
  public MarkerOptions position(LatLng paramLatLng)
  {
    this.aja = paramLatLng;
    return this;
  }
  
  public MarkerOptions rotation(float paramFloat)
  {
    this.ajW = paramFloat;
    return this;
  }
  
  public MarkerOptions snippet(String paramString)
  {
    this.ajS = paramString;
    return this;
  }
  
  public MarkerOptions title(String paramString)
  {
    this.No = paramString;
    return this;
  }
  
  public MarkerOptions visible(boolean paramBoolean)
  {
    this.ajB = paramBoolean;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (v.mK())
    {
      l.a(this, paramParcel, paramInt);
      return;
    }
    k.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/maps/model/MarkerOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */