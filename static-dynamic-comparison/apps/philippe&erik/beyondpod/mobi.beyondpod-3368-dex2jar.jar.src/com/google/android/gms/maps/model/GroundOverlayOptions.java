package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.dynamic.b.a;
import com.google.android.gms.internal.eg;
import com.google.android.gms.maps.internal.r;

public final class GroundOverlayOptions
  implements SafeParcelable
{
  public static final GroundOverlayOptionsCreator CREATOR = new GroundOverlayOptionsCreator();
  public static final float NO_DIMENSION = -1.0F;
  private LatLng CA;
  private float CB;
  private float CC;
  private LatLngBounds CD;
  private float CE = 0.0F;
  private float CF = 0.5F;
  private float CG = 0.5F;
  private float Cp;
  private float Cw;
  private boolean Cx = true;
  private BitmapDescriptor Cz;
  private final int kg;
  
  public GroundOverlayOptions()
  {
    this.kg = 1;
  }
  
  GroundOverlayOptions(int paramInt, IBinder paramIBinder, LatLng paramLatLng, float paramFloat1, float paramFloat2, LatLngBounds paramLatLngBounds, float paramFloat3, float paramFloat4, boolean paramBoolean, float paramFloat5, float paramFloat6, float paramFloat7)
  {
    this.kg = paramInt;
    this.Cz = new BitmapDescriptor(b.a.E(paramIBinder));
    this.CA = paramLatLng;
    this.CB = paramFloat1;
    this.CC = paramFloat2;
    this.CD = paramLatLngBounds;
    this.Cp = paramFloat3;
    this.Cw = paramFloat4;
    this.Cx = paramBoolean;
    this.CE = paramFloat5;
    this.CF = paramFloat6;
    this.CG = paramFloat7;
  }
  
  private GroundOverlayOptions a(LatLng paramLatLng, float paramFloat1, float paramFloat2)
  {
    this.CA = paramLatLng;
    this.CB = paramFloat1;
    this.CC = paramFloat2;
    return this;
  }
  
  public GroundOverlayOptions anchor(float paramFloat1, float paramFloat2)
  {
    this.CF = paramFloat1;
    this.CG = paramFloat2;
    return this;
  }
  
  public GroundOverlayOptions bearing(float paramFloat)
  {
    this.Cp = ((paramFloat % 360.0F + 360.0F) % 360.0F);
    return this;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  IBinder eF()
  {
    return this.Cz.el().asBinder();
  }
  
  public float getAnchorU()
  {
    return this.CF;
  }
  
  public float getAnchorV()
  {
    return this.CG;
  }
  
  public float getBearing()
  {
    return this.Cp;
  }
  
  public LatLngBounds getBounds()
  {
    return this.CD;
  }
  
  public float getHeight()
  {
    return this.CC;
  }
  
  public BitmapDescriptor getImage()
  {
    return this.Cz;
  }
  
  public LatLng getLocation()
  {
    return this.CA;
  }
  
  public float getTransparency()
  {
    return this.CE;
  }
  
  int getVersionCode()
  {
    return this.kg;
  }
  
  public float getWidth()
  {
    return this.CB;
  }
  
  public float getZIndex()
  {
    return this.Cw;
  }
  
  public GroundOverlayOptions image(BitmapDescriptor paramBitmapDescriptor)
  {
    this.Cz = paramBitmapDescriptor;
    return this;
  }
  
  public boolean isVisible()
  {
    return this.Cx;
  }
  
  public GroundOverlayOptions position(LatLng paramLatLng, float paramFloat)
  {
    boolean bool2 = true;
    if (this.CD == null)
    {
      bool1 = true;
      eg.a(bool1, "Position has already been set using positionFromBounds");
      if (paramLatLng == null) {
        break label59;
      }
      bool1 = true;
      label24:
      eg.b(bool1, "Location must be specified");
      if (paramFloat < 0.0F) {
        break label64;
      }
    }
    label59:
    label64:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      eg.b(bool1, "Width must be non-negative");
      return a(paramLatLng, paramFloat, -1.0F);
      bool1 = false;
      break;
      bool1 = false;
      break label24;
    }
  }
  
  public GroundOverlayOptions position(LatLng paramLatLng, float paramFloat1, float paramFloat2)
  {
    boolean bool2 = true;
    if (this.CD == null)
    {
      bool1 = true;
      eg.a(bool1, "Position has already been set using positionFromBounds");
      if (paramLatLng == null) {
        break label81;
      }
      bool1 = true;
      label27:
      eg.b(bool1, "Location must be specified");
      if (paramFloat1 < 0.0F) {
        break label87;
      }
      bool1 = true;
      label43:
      eg.b(bool1, "Width must be non-negative");
      if (paramFloat2 < 0.0F) {
        break label93;
      }
    }
    label81:
    label87:
    label93:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      eg.b(bool1, "Height must be non-negative");
      return a(paramLatLng, paramFloat1, paramFloat2);
      bool1 = false;
      break;
      bool1 = false;
      break label27;
      bool1 = false;
      break label43;
    }
  }
  
  public GroundOverlayOptions positionFromBounds(LatLngBounds paramLatLngBounds)
  {
    if (this.CA == null) {}
    for (boolean bool = true;; bool = false)
    {
      eg.a(bool, "Position has already been set using position: " + this.CA);
      this.CD = paramLatLngBounds;
      return this;
    }
  }
  
  public GroundOverlayOptions transparency(float paramFloat)
  {
    if ((paramFloat >= 0.0F) && (paramFloat <= 1.0F)) {}
    for (boolean bool = true;; bool = false)
    {
      eg.b(bool, "Transparency must be in the range [0..1]");
      this.CE = paramFloat;
      return this;
    }
  }
  
  public GroundOverlayOptions visible(boolean paramBoolean)
  {
    this.Cx = paramBoolean;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (r.eD())
    {
      c.a(this, paramParcel, paramInt);
      return;
    }
    GroundOverlayOptionsCreator.a(this, paramParcel, paramInt);
  }
  
  public GroundOverlayOptions zIndex(float paramFloat)
  {
    this.Cw = paramFloat;
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/maps/model/GroundOverlayOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */