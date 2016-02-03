package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.d.a;
import com.google.android.gms.maps.internal.v;

public final class GroundOverlayOptions
  implements SafeParcelable
{
  public static final e CREATOR = new e();
  public static final float NO_DIMENSION = -1.0F;
  private final int BR;
  private float ajA;
  private boolean ajB = true;
  private BitmapDescriptor ajD;
  private LatLng ajE;
  private float ajF;
  private float ajG;
  private LatLngBounds ajH;
  private float ajI = 0.0F;
  private float ajJ = 0.5F;
  private float ajK = 0.5F;
  private float ajt;
  
  public GroundOverlayOptions()
  {
    this.BR = 1;
  }
  
  GroundOverlayOptions(int paramInt, IBinder paramIBinder, LatLng paramLatLng, float paramFloat1, float paramFloat2, LatLngBounds paramLatLngBounds, float paramFloat3, float paramFloat4, boolean paramBoolean, float paramFloat5, float paramFloat6, float paramFloat7)
  {
    this.BR = paramInt;
    this.ajD = new BitmapDescriptor(d.a.am(paramIBinder));
    this.ajE = paramLatLng;
    this.ajF = paramFloat1;
    this.ajG = paramFloat2;
    this.ajH = paramLatLngBounds;
    this.ajt = paramFloat3;
    this.ajA = paramFloat4;
    this.ajB = paramBoolean;
    this.ajI = paramFloat5;
    this.ajJ = paramFloat6;
    this.ajK = paramFloat7;
  }
  
  private GroundOverlayOptions a(LatLng paramLatLng, float paramFloat1, float paramFloat2)
  {
    this.ajE = paramLatLng;
    this.ajF = paramFloat1;
    this.ajG = paramFloat2;
    return this;
  }
  
  public GroundOverlayOptions anchor(float paramFloat1, float paramFloat2)
  {
    this.ajJ = paramFloat1;
    this.ajK = paramFloat2;
    return this;
  }
  
  public GroundOverlayOptions bearing(float paramFloat)
  {
    this.ajt = ((paramFloat % 360.0F + 360.0F) % 360.0F);
    return this;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public float getAnchorU()
  {
    return this.ajJ;
  }
  
  public float getAnchorV()
  {
    return this.ajK;
  }
  
  public float getBearing()
  {
    return this.ajt;
  }
  
  public LatLngBounds getBounds()
  {
    return this.ajH;
  }
  
  public float getHeight()
  {
    return this.ajG;
  }
  
  public BitmapDescriptor getImage()
  {
    return this.ajD;
  }
  
  public LatLng getLocation()
  {
    return this.ajE;
  }
  
  public float getTransparency()
  {
    return this.ajI;
  }
  
  int getVersionCode()
  {
    return this.BR;
  }
  
  public float getWidth()
  {
    return this.ajF;
  }
  
  public float getZIndex()
  {
    return this.ajA;
  }
  
  public GroundOverlayOptions image(BitmapDescriptor paramBitmapDescriptor)
  {
    this.ajD = paramBitmapDescriptor;
    return this;
  }
  
  public boolean isVisible()
  {
    return this.ajB;
  }
  
  IBinder mM()
  {
    return this.ajD.mm().asBinder();
  }
  
  public GroundOverlayOptions position(LatLng paramLatLng, float paramFloat)
  {
    boolean bool2 = true;
    if (this.ajH == null)
    {
      bool1 = true;
      n.a(bool1, "Position has already been set using positionFromBounds");
      if (paramLatLng == null) {
        break label59;
      }
      bool1 = true;
      label24:
      n.b(bool1, "Location must be specified");
      if (paramFloat < 0.0F) {
        break label64;
      }
    }
    label59:
    label64:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      n.b(bool1, "Width must be non-negative");
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
    if (this.ajH == null)
    {
      bool1 = true;
      n.a(bool1, "Position has already been set using positionFromBounds");
      if (paramLatLng == null) {
        break label81;
      }
      bool1 = true;
      label27:
      n.b(bool1, "Location must be specified");
      if (paramFloat1 < 0.0F) {
        break label87;
      }
      bool1 = true;
      label43:
      n.b(bool1, "Width must be non-negative");
      if (paramFloat2 < 0.0F) {
        break label93;
      }
    }
    label81:
    label87:
    label93:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      n.b(bool1, "Height must be non-negative");
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
    if (this.ajE == null) {}
    for (boolean bool = true;; bool = false)
    {
      n.a(bool, "Position has already been set using position: " + this.ajE);
      this.ajH = paramLatLngBounds;
      return this;
    }
  }
  
  public GroundOverlayOptions transparency(float paramFloat)
  {
    if ((paramFloat >= 0.0F) && (paramFloat <= 1.0F)) {}
    for (boolean bool = true;; bool = false)
    {
      n.b(bool, "Transparency must be in the range [0..1]");
      this.ajI = paramFloat;
      return this;
    }
  }
  
  public GroundOverlayOptions visible(boolean paramBoolean)
  {
    this.ajB = paramBoolean;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (v.mK())
    {
      f.a(this, paramParcel, paramInt);
      return;
    }
    e.a(this, paramParcel, paramInt);
  }
  
  public GroundOverlayOptions zIndex(float paramFloat)
  {
    this.ajA = paramFloat;
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/maps/model/GroundOverlayOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */