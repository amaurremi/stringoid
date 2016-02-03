package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.d.a;
import com.google.android.gms.internal.fq;
import com.google.android.gms.maps.internal.v;

public final class GroundOverlayOptions
  implements SafeParcelable
{
  public static final GroundOverlayOptionsCreator CREATOR = new GroundOverlayOptionsCreator();
  public static final float NO_DIMENSION = -1.0F;
  private float SG;
  private float SN;
  private boolean SO = true;
  private BitmapDescriptor SQ;
  private LatLng SR;
  private float SS;
  private float ST;
  private LatLngBounds SU;
  private float SV = 0.0F;
  private float SW = 0.5F;
  private float SX = 0.5F;
  private final int xH;
  
  public GroundOverlayOptions()
  {
    this.xH = 1;
  }
  
  GroundOverlayOptions(int paramInt, IBinder paramIBinder, LatLng paramLatLng, float paramFloat1, float paramFloat2, LatLngBounds paramLatLngBounds, float paramFloat3, float paramFloat4, boolean paramBoolean, float paramFloat5, float paramFloat6, float paramFloat7)
  {
    this.xH = paramInt;
    this.SQ = new BitmapDescriptor(d.a.K(paramIBinder));
    this.SR = paramLatLng;
    this.SS = paramFloat1;
    this.ST = paramFloat2;
    this.SU = paramLatLngBounds;
    this.SG = paramFloat3;
    this.SN = paramFloat4;
    this.SO = paramBoolean;
    this.SV = paramFloat5;
    this.SW = paramFloat6;
    this.SX = paramFloat7;
  }
  
  private GroundOverlayOptions a(LatLng paramLatLng, float paramFloat1, float paramFloat2)
  {
    this.SR = paramLatLng;
    this.SS = paramFloat1;
    this.ST = paramFloat2;
    return this;
  }
  
  public GroundOverlayOptions anchor(float paramFloat1, float paramFloat2)
  {
    this.SW = paramFloat1;
    this.SX = paramFloat2;
    return this;
  }
  
  public GroundOverlayOptions bearing(float paramFloat)
  {
    this.SG = ((paramFloat % 360.0F + 360.0F) % 360.0F);
    return this;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public float getAnchorU()
  {
    return this.SW;
  }
  
  public float getAnchorV()
  {
    return this.SX;
  }
  
  public float getBearing()
  {
    return this.SG;
  }
  
  public LatLngBounds getBounds()
  {
    return this.SU;
  }
  
  public float getHeight()
  {
    return this.ST;
  }
  
  public BitmapDescriptor getImage()
  {
    return this.SQ;
  }
  
  public LatLng getLocation()
  {
    return this.SR;
  }
  
  public float getTransparency()
  {
    return this.SV;
  }
  
  int getVersionCode()
  {
    return this.xH;
  }
  
  public float getWidth()
  {
    return this.SS;
  }
  
  public float getZIndex()
  {
    return this.SN;
  }
  
  IBinder iD()
  {
    return this.SQ.id().asBinder();
  }
  
  public GroundOverlayOptions image(BitmapDescriptor paramBitmapDescriptor)
  {
    this.SQ = paramBitmapDescriptor;
    return this;
  }
  
  public boolean isVisible()
  {
    return this.SO;
  }
  
  public GroundOverlayOptions position(LatLng paramLatLng, float paramFloat)
  {
    boolean bool2 = true;
    if (this.SU == null)
    {
      bool1 = true;
      fq.a(bool1, "Position has already been set using positionFromBounds");
      if (paramLatLng == null) {
        break label59;
      }
      bool1 = true;
      label24:
      fq.b(bool1, "Location must be specified");
      if (paramFloat < 0.0F) {
        break label64;
      }
    }
    label59:
    label64:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      fq.b(bool1, "Width must be non-negative");
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
    if (this.SU == null)
    {
      bool1 = true;
      fq.a(bool1, "Position has already been set using positionFromBounds");
      if (paramLatLng == null) {
        break label81;
      }
      bool1 = true;
      label27:
      fq.b(bool1, "Location must be specified");
      if (paramFloat1 < 0.0F) {
        break label87;
      }
      bool1 = true;
      label43:
      fq.b(bool1, "Width must be non-negative");
      if (paramFloat2 < 0.0F) {
        break label93;
      }
    }
    label81:
    label87:
    label93:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      fq.b(bool1, "Height must be non-negative");
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
    if (this.SR == null) {}
    for (boolean bool = true;; bool = false)
    {
      fq.a(bool, "Position has already been set using position: " + this.SR);
      this.SU = paramLatLngBounds;
      return this;
    }
  }
  
  public GroundOverlayOptions transparency(float paramFloat)
  {
    if ((paramFloat >= 0.0F) && (paramFloat <= 1.0F)) {}
    for (boolean bool = true;; bool = false)
    {
      fq.b(bool, "Transparency must be in the range [0..1]");
      this.SV = paramFloat;
      return this;
    }
  }
  
  public GroundOverlayOptions visible(boolean paramBoolean)
  {
    this.SO = paramBoolean;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (v.iB())
    {
      c.a(this, paramParcel, paramInt);
      return;
    }
    GroundOverlayOptionsCreator.a(this, paramParcel, paramInt);
  }
  
  public GroundOverlayOptions zIndex(float paramFloat)
  {
    this.SN = paramFloat;
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/maps/model/GroundOverlayOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */