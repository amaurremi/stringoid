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
  private String HV;
  private LatLng ZU;
  private float aaD = 0.5F;
  private float aaE = 1.0F;
  private String aaM;
  private BitmapDescriptor aaN;
  private boolean aaO;
  private boolean aaP = false;
  private float aaQ = 0.0F;
  private float aaR = 0.5F;
  private float aaS = 0.0F;
  private boolean aav = true;
  private float mAlpha = 1.0F;
  private final int xJ;
  
  public MarkerOptions()
  {
    this.xJ = 1;
  }
  
  MarkerOptions(int paramInt, LatLng paramLatLng, String paramString1, String paramString2, IBinder paramIBinder, float paramFloat1, float paramFloat2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    this.xJ = paramInt;
    this.ZU = paramLatLng;
    this.HV = paramString1;
    this.aaM = paramString2;
    if (paramIBinder == null) {}
    for (paramLatLng = null;; paramLatLng = new BitmapDescriptor(d.a.ag(paramIBinder)))
    {
      this.aaN = paramLatLng;
      this.aaD = paramFloat1;
      this.aaE = paramFloat2;
      this.aaO = paramBoolean1;
      this.aav = paramBoolean2;
      this.aaP = paramBoolean3;
      this.aaQ = paramFloat3;
      this.aaR = paramFloat4;
      this.aaS = paramFloat5;
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
    this.aaD = paramFloat1;
    this.aaE = paramFloat2;
    return this;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public MarkerOptions draggable(boolean paramBoolean)
  {
    this.aaO = paramBoolean;
    return this;
  }
  
  public MarkerOptions flat(boolean paramBoolean)
  {
    this.aaP = paramBoolean;
    return this;
  }
  
  public float getAlpha()
  {
    return this.mAlpha;
  }
  
  public float getAnchorU()
  {
    return this.aaD;
  }
  
  public float getAnchorV()
  {
    return this.aaE;
  }
  
  public BitmapDescriptor getIcon()
  {
    return this.aaN;
  }
  
  public float getInfoWindowAnchorU()
  {
    return this.aaR;
  }
  
  public float getInfoWindowAnchorV()
  {
    return this.aaS;
  }
  
  public LatLng getPosition()
  {
    return this.ZU;
  }
  
  public float getRotation()
  {
    return this.aaQ;
  }
  
  public String getSnippet()
  {
    return this.aaM;
  }
  
  public String getTitle()
  {
    return this.HV;
  }
  
  int getVersionCode()
  {
    return this.xJ;
  }
  
  public MarkerOptions icon(BitmapDescriptor paramBitmapDescriptor)
  {
    this.aaN = paramBitmapDescriptor;
    return this;
  }
  
  public MarkerOptions infoWindowAnchor(float paramFloat1, float paramFloat2)
  {
    this.aaR = paramFloat1;
    this.aaS = paramFloat2;
    return this;
  }
  
  public boolean isDraggable()
  {
    return this.aaO;
  }
  
  public boolean isFlat()
  {
    return this.aaP;
  }
  
  public boolean isVisible()
  {
    return this.aav;
  }
  
  IBinder jJ()
  {
    if (this.aaN == null) {
      return null;
    }
    return this.aaN.ji().asBinder();
  }
  
  public MarkerOptions position(LatLng paramLatLng)
  {
    this.ZU = paramLatLng;
    return this;
  }
  
  public MarkerOptions rotation(float paramFloat)
  {
    this.aaQ = paramFloat;
    return this;
  }
  
  public MarkerOptions snippet(String paramString)
  {
    this.aaM = paramString;
    return this;
  }
  
  public MarkerOptions title(String paramString)
  {
    this.HV = paramString;
    return this;
  }
  
  public MarkerOptions visible(boolean paramBoolean)
  {
    this.aav = paramBoolean;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (v.jG())
    {
      f.a(this, paramParcel, paramInt);
      return;
    }
    MarkerOptionsCreator.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/maps/model/MarkerOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */