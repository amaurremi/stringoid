package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.dynamic.b.a;
import com.google.android.gms.maps.internal.r;

public final class MarkerOptions
  implements SafeParcelable
{
  public static final MarkerOptionsCreator CREATOR = new MarkerOptionsCreator();
  private float CF = 0.5F;
  private float CG = 1.0F;
  private LatLng CM;
  private String CN;
  private BitmapDescriptor CO;
  private boolean CP;
  private boolean CQ = false;
  private float CR = 0.0F;
  private float CS = 0.5F;
  private float CT = 0.0F;
  private boolean Cx = true;
  private final int kg;
  private float mAlpha = 1.0F;
  private String qL;
  
  public MarkerOptions()
  {
    this.kg = 1;
  }
  
  MarkerOptions(int paramInt, LatLng paramLatLng, String paramString1, String paramString2, IBinder paramIBinder, float paramFloat1, float paramFloat2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    this.kg = paramInt;
    this.CM = paramLatLng;
    this.qL = paramString1;
    this.CN = paramString2;
    if (paramIBinder == null) {}
    for (paramLatLng = null;; paramLatLng = new BitmapDescriptor(b.a.E(paramIBinder)))
    {
      this.CO = paramLatLng;
      this.CF = paramFloat1;
      this.CG = paramFloat2;
      this.CP = paramBoolean1;
      this.Cx = paramBoolean2;
      this.CQ = paramBoolean3;
      this.CR = paramFloat3;
      this.CS = paramFloat4;
      this.CT = paramFloat5;
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
    this.CF = paramFloat1;
    this.CG = paramFloat2;
    return this;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public MarkerOptions draggable(boolean paramBoolean)
  {
    this.CP = paramBoolean;
    return this;
  }
  
  IBinder eG()
  {
    if (this.CO == null) {
      return null;
    }
    return this.CO.el().asBinder();
  }
  
  public MarkerOptions flat(boolean paramBoolean)
  {
    this.CQ = paramBoolean;
    return this;
  }
  
  public float getAlpha()
  {
    return this.mAlpha;
  }
  
  public float getAnchorU()
  {
    return this.CF;
  }
  
  public float getAnchorV()
  {
    return this.CG;
  }
  
  public BitmapDescriptor getIcon()
  {
    return this.CO;
  }
  
  public float getInfoWindowAnchorU()
  {
    return this.CS;
  }
  
  public float getInfoWindowAnchorV()
  {
    return this.CT;
  }
  
  public LatLng getPosition()
  {
    return this.CM;
  }
  
  public float getRotation()
  {
    return this.CR;
  }
  
  public String getSnippet()
  {
    return this.CN;
  }
  
  public String getTitle()
  {
    return this.qL;
  }
  
  int getVersionCode()
  {
    return this.kg;
  }
  
  public MarkerOptions icon(BitmapDescriptor paramBitmapDescriptor)
  {
    this.CO = paramBitmapDescriptor;
    return this;
  }
  
  public MarkerOptions infoWindowAnchor(float paramFloat1, float paramFloat2)
  {
    this.CS = paramFloat1;
    this.CT = paramFloat2;
    return this;
  }
  
  public boolean isDraggable()
  {
    return this.CP;
  }
  
  public boolean isFlat()
  {
    return this.CQ;
  }
  
  public boolean isVisible()
  {
    return this.Cx;
  }
  
  public MarkerOptions position(LatLng paramLatLng)
  {
    this.CM = paramLatLng;
    return this;
  }
  
  public MarkerOptions rotation(float paramFloat)
  {
    this.CR = paramFloat;
    return this;
  }
  
  public MarkerOptions snippet(String paramString)
  {
    this.CN = paramString;
    return this;
  }
  
  public MarkerOptions title(String paramString)
  {
    this.qL = paramString;
    return this;
  }
  
  public MarkerOptions visible(boolean paramBoolean)
  {
    this.Cx = paramBoolean;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (r.eD())
    {
      f.a(this, paramParcel, paramInt);
      return;
    }
    MarkerOptionsCreator.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/maps/model/MarkerOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */