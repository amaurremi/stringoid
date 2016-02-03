package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.d.a;
import com.google.android.gms.internal.hm;
import com.google.android.gms.maps.internal.v;

public final class GroundOverlayOptions
  implements SafeParcelable
{
  public static final GroundOverlayOptionsCreator CREATOR = new GroundOverlayOptionsCreator();
  public static final float NO_DIMENSION = -1.0F;
  private BitmapDescriptor aaA;
  private LatLng aaB;
  private float aaC;
  private float aaD;
  private LatLngBounds aaE;
  private float aaF = 0.0F;
  private float aaG = 0.5F;
  private float aaH = 0.5F;
  private float aaq;
  private float aax;
  private boolean aay = true;
  private final int xM;
  
  public GroundOverlayOptions()
  {
    this.xM = 1;
  }
  
  GroundOverlayOptions(int paramInt, IBinder paramIBinder, LatLng paramLatLng, float paramFloat1, float paramFloat2, LatLngBounds paramLatLngBounds, float paramFloat3, float paramFloat4, boolean paramBoolean, float paramFloat5, float paramFloat6, float paramFloat7)
  {
    this.xM = paramInt;
    this.aaA = new BitmapDescriptor(d.a.ag(paramIBinder));
    this.aaB = paramLatLng;
    this.aaC = paramFloat1;
    this.aaD = paramFloat2;
    this.aaE = paramLatLngBounds;
    this.aaq = paramFloat3;
    this.aax = paramFloat4;
    this.aay = paramBoolean;
    this.aaF = paramFloat5;
    this.aaG = paramFloat6;
    this.aaH = paramFloat7;
  }
  
  private GroundOverlayOptions a(LatLng paramLatLng, float paramFloat1, float paramFloat2)
  {
    this.aaB = paramLatLng;
    this.aaC = paramFloat1;
    this.aaD = paramFloat2;
    return this;
  }
  
  public GroundOverlayOptions anchor(float paramFloat1, float paramFloat2)
  {
    this.aaG = paramFloat1;
    this.aaH = paramFloat2;
    return this;
  }
  
  public GroundOverlayOptions bearing(float paramFloat)
  {
    this.aaq = ((paramFloat % 360.0F + 360.0F) % 360.0F);
    return this;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public float getAnchorU()
  {
    return this.aaG;
  }
  
  public float getAnchorV()
  {
    return this.aaH;
  }
  
  public float getBearing()
  {
    return this.aaq;
  }
  
  public LatLngBounds getBounds()
  {
    return this.aaE;
  }
  
  public float getHeight()
  {
    return this.aaD;
  }
  
  public BitmapDescriptor getImage()
  {
    return this.aaA;
  }
  
  public LatLng getLocation()
  {
    return this.aaB;
  }
  
  public float getTransparency()
  {
    return this.aaF;
  }
  
  int getVersionCode()
  {
    return this.xM;
  }
  
  public float getWidth()
  {
    return this.aaC;
  }
  
  public float getZIndex()
  {
    return this.aax;
  }
  
  public GroundOverlayOptions image(BitmapDescriptor paramBitmapDescriptor)
  {
    this.aaA = paramBitmapDescriptor;
    return this;
  }
  
  public boolean isVisible()
  {
    return this.aay;
  }
  
  IBinder jN()
  {
    return this.aaA.jn().asBinder();
  }
  
  public GroundOverlayOptions position(LatLng paramLatLng, float paramFloat)
  {
    boolean bool2 = true;
    if (this.aaE == null)
    {
      bool1 = true;
      hm.a(bool1, "Position has already been set using positionFromBounds");
      if (paramLatLng == null) {
        break label59;
      }
      bool1 = true;
      label24:
      hm.b(bool1, "Location must be specified");
      if (paramFloat < 0.0F) {
        break label64;
      }
    }
    label59:
    label64:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      hm.b(bool1, "Width must be non-negative");
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
    if (this.aaE == null)
    {
      bool1 = true;
      hm.a(bool1, "Position has already been set using positionFromBounds");
      if (paramLatLng == null) {
        break label81;
      }
      bool1 = true;
      label27:
      hm.b(bool1, "Location must be specified");
      if (paramFloat1 < 0.0F) {
        break label87;
      }
      bool1 = true;
      label43:
      hm.b(bool1, "Width must be non-negative");
      if (paramFloat2 < 0.0F) {
        break label93;
      }
    }
    label81:
    label87:
    label93:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      hm.b(bool1, "Height must be non-negative");
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
    if (this.aaB == null) {}
    for (boolean bool = true;; bool = false)
    {
      hm.a(bool, "Position has already been set using position: %s", new Object[] { this.aaB });
      this.aaE = paramLatLngBounds;
      return this;
    }
  }
  
  public GroundOverlayOptions transparency(float paramFloat)
  {
    if ((paramFloat >= 0.0F) && (paramFloat <= 1.0F)) {}
    for (boolean bool = true;; bool = false)
    {
      hm.b(bool, "Transparency must be in the range [0..1]");
      this.aaF = paramFloat;
      return this;
    }
  }
  
  public GroundOverlayOptions visible(boolean paramBoolean)
  {
    this.aay = paramBoolean;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (v.jL())
    {
      c.a(this, paramParcel, paramInt);
      return;
    }
    GroundOverlayOptionsCreator.a(this, paramParcel, paramInt);
  }
  
  public GroundOverlayOptions zIndex(float paramFloat)
  {
    this.aax = paramFloat;
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/maps/model/GroundOverlayOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */