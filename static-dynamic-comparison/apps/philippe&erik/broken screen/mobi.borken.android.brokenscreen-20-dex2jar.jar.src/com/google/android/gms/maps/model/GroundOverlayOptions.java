package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.d.a;
import com.google.android.gms.internal.hn;
import com.google.android.gms.maps.internal.v;

public final class GroundOverlayOptions
  implements SafeParcelable
{
  public static final GroundOverlayOptionsCreator CREATOR = new GroundOverlayOptionsCreator();
  public static final float NO_DIMENSION = -1.0F;
  private float aaA;
  private LatLngBounds aaB;
  private float aaC = 0.0F;
  private float aaD = 0.5F;
  private float aaE = 0.5F;
  private float aan;
  private float aau;
  private boolean aav = true;
  private BitmapDescriptor aax;
  private LatLng aay;
  private float aaz;
  private final int xJ;
  
  public GroundOverlayOptions()
  {
    this.xJ = 1;
  }
  
  GroundOverlayOptions(int paramInt, IBinder paramIBinder, LatLng paramLatLng, float paramFloat1, float paramFloat2, LatLngBounds paramLatLngBounds, float paramFloat3, float paramFloat4, boolean paramBoolean, float paramFloat5, float paramFloat6, float paramFloat7)
  {
    this.xJ = paramInt;
    this.aax = new BitmapDescriptor(d.a.ag(paramIBinder));
    this.aay = paramLatLng;
    this.aaz = paramFloat1;
    this.aaA = paramFloat2;
    this.aaB = paramLatLngBounds;
    this.aan = paramFloat3;
    this.aau = paramFloat4;
    this.aav = paramBoolean;
    this.aaC = paramFloat5;
    this.aaD = paramFloat6;
    this.aaE = paramFloat7;
  }
  
  private GroundOverlayOptions a(LatLng paramLatLng, float paramFloat1, float paramFloat2)
  {
    this.aay = paramLatLng;
    this.aaz = paramFloat1;
    this.aaA = paramFloat2;
    return this;
  }
  
  public GroundOverlayOptions anchor(float paramFloat1, float paramFloat2)
  {
    this.aaD = paramFloat1;
    this.aaE = paramFloat2;
    return this;
  }
  
  public GroundOverlayOptions bearing(float paramFloat)
  {
    this.aan = ((paramFloat % 360.0F + 360.0F) % 360.0F);
    return this;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public float getAnchorU()
  {
    return this.aaD;
  }
  
  public float getAnchorV()
  {
    return this.aaE;
  }
  
  public float getBearing()
  {
    return this.aan;
  }
  
  public LatLngBounds getBounds()
  {
    return this.aaB;
  }
  
  public float getHeight()
  {
    return this.aaA;
  }
  
  public BitmapDescriptor getImage()
  {
    return this.aax;
  }
  
  public LatLng getLocation()
  {
    return this.aay;
  }
  
  public float getTransparency()
  {
    return this.aaC;
  }
  
  int getVersionCode()
  {
    return this.xJ;
  }
  
  public float getWidth()
  {
    return this.aaz;
  }
  
  public float getZIndex()
  {
    return this.aau;
  }
  
  public GroundOverlayOptions image(BitmapDescriptor paramBitmapDescriptor)
  {
    this.aax = paramBitmapDescriptor;
    return this;
  }
  
  public boolean isVisible()
  {
    return this.aav;
  }
  
  IBinder jI()
  {
    return this.aax.ji().asBinder();
  }
  
  public GroundOverlayOptions position(LatLng paramLatLng, float paramFloat)
  {
    boolean bool2 = true;
    if (this.aaB == null)
    {
      bool1 = true;
      hn.a(bool1, "Position has already been set using positionFromBounds");
      if (paramLatLng == null) {
        break label59;
      }
      bool1 = true;
      label24:
      hn.b(bool1, "Location must be specified");
      if (paramFloat < 0.0F) {
        break label64;
      }
    }
    label59:
    label64:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      hn.b(bool1, "Width must be non-negative");
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
    if (this.aaB == null)
    {
      bool1 = true;
      hn.a(bool1, "Position has already been set using positionFromBounds");
      if (paramLatLng == null) {
        break label81;
      }
      bool1 = true;
      label27:
      hn.b(bool1, "Location must be specified");
      if (paramFloat1 < 0.0F) {
        break label87;
      }
      bool1 = true;
      label43:
      hn.b(bool1, "Width must be non-negative");
      if (paramFloat2 < 0.0F) {
        break label93;
      }
    }
    label81:
    label87:
    label93:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      hn.b(bool1, "Height must be non-negative");
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
    if (this.aay == null) {}
    for (boolean bool = true;; bool = false)
    {
      hn.a(bool, "Position has already been set using position: %s", new Object[] { this.aay });
      this.aaB = paramLatLngBounds;
      return this;
    }
  }
  
  public GroundOverlayOptions transparency(float paramFloat)
  {
    if ((paramFloat >= 0.0F) && (paramFloat <= 1.0F)) {}
    for (boolean bool = true;; bool = false)
    {
      hn.b(bool, "Transparency must be in the range [0..1]");
      this.aaC = paramFloat;
      return this;
    }
  }
  
  public GroundOverlayOptions visible(boolean paramBoolean)
  {
    this.aav = paramBoolean;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (v.jG())
    {
      c.a(this, paramParcel, paramInt);
      return;
    }
    GroundOverlayOptionsCreator.a(this, paramParcel, paramInt);
  }
  
  public GroundOverlayOptions zIndex(float paramFloat)
  {
    this.aau = paramFloat;
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/maps/model/GroundOverlayOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */