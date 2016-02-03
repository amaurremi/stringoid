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
  public static final MarkerOptionsCreator CREATOR = new MarkerOptionsCreator();
  private String HY;
  private LatLng ZX;
  private float aaG = 0.5F;
  private float aaH = 1.0F;
  private String aaP;
  private BitmapDescriptor aaQ;
  private boolean aaR;
  private boolean aaS = false;
  private float aaT = 0.0F;
  private float aaU = 0.5F;
  private float aaV = 0.0F;
  private boolean aay = true;
  private float mAlpha = 1.0F;
  private final int xM;
  
  public MarkerOptions()
  {
    this.xM = 1;
  }
  
  MarkerOptions(int paramInt, LatLng paramLatLng, String paramString1, String paramString2, IBinder paramIBinder, float paramFloat1, float paramFloat2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    this.xM = paramInt;
    this.ZX = paramLatLng;
    this.HY = paramString1;
    this.aaP = paramString2;
    if (paramIBinder == null) {}
    for (paramLatLng = null;; paramLatLng = new BitmapDescriptor(d.a.ag(paramIBinder)))
    {
      this.aaQ = paramLatLng;
      this.aaG = paramFloat1;
      this.aaH = paramFloat2;
      this.aaR = paramBoolean1;
      this.aay = paramBoolean2;
      this.aaS = paramBoolean3;
      this.aaT = paramFloat3;
      this.aaU = paramFloat4;
      this.aaV = paramFloat5;
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
    this.aaG = paramFloat1;
    this.aaH = paramFloat2;
    return this;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public MarkerOptions draggable(boolean paramBoolean)
  {
    this.aaR = paramBoolean;
    return this;
  }
  
  public MarkerOptions flat(boolean paramBoolean)
  {
    this.aaS = paramBoolean;
    return this;
  }
  
  public float getAlpha()
  {
    return this.mAlpha;
  }
  
  public float getAnchorU()
  {
    return this.aaG;
  }
  
  public float getAnchorV()
  {
    return this.aaH;
  }
  
  public BitmapDescriptor getIcon()
  {
    return this.aaQ;
  }
  
  public float getInfoWindowAnchorU()
  {
    return this.aaU;
  }
  
  public float getInfoWindowAnchorV()
  {
    return this.aaV;
  }
  
  public LatLng getPosition()
  {
    return this.ZX;
  }
  
  public float getRotation()
  {
    return this.aaT;
  }
  
  public String getSnippet()
  {
    return this.aaP;
  }
  
  public String getTitle()
  {
    return this.HY;
  }
  
  int getVersionCode()
  {
    return this.xM;
  }
  
  public MarkerOptions icon(BitmapDescriptor paramBitmapDescriptor)
  {
    this.aaQ = paramBitmapDescriptor;
    return this;
  }
  
  public MarkerOptions infoWindowAnchor(float paramFloat1, float paramFloat2)
  {
    this.aaU = paramFloat1;
    this.aaV = paramFloat2;
    return this;
  }
  
  public boolean isDraggable()
  {
    return this.aaR;
  }
  
  public boolean isFlat()
  {
    return this.aaS;
  }
  
  public boolean isVisible()
  {
    return this.aay;
  }
  
  IBinder jO()
  {
    if (this.aaQ == null) {
      return null;
    }
    return this.aaQ.jn().asBinder();
  }
  
  public MarkerOptions position(LatLng paramLatLng)
  {
    this.ZX = paramLatLng;
    return this;
  }
  
  public MarkerOptions rotation(float paramFloat)
  {
    this.aaT = paramFloat;
    return this;
  }
  
  public MarkerOptions snippet(String paramString)
  {
    this.aaP = paramString;
    return this;
  }
  
  public MarkerOptions title(String paramString)
  {
    this.HY = paramString;
    return this;
  }
  
  public MarkerOptions visible(boolean paramBoolean)
  {
    this.aay = paramBoolean;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (v.jL())
    {
      f.a(this, paramParcel, paramInt);
      return;
    }
    MarkerOptionsCreator.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/maps/model/MarkerOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */