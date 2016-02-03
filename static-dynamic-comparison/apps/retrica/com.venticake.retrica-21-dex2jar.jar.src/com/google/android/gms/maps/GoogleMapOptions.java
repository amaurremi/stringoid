package com.google.android.gms.maps;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.util.AttributeSet;
import com.google.android.gms.R.styleable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.v;
import com.google.android.gms.maps.model.CameraPosition;

public final class GoogleMapOptions
  implements SafeParcelable
{
  public static final GoogleMapOptionsCreator CREATOR = new GoogleMapOptionsCreator();
  private Boolean ZA;
  private Boolean ZB;
  private Boolean Zs;
  private Boolean Zt;
  private int Zu = -1;
  private CameraPosition Zv;
  private Boolean Zw;
  private Boolean Zx;
  private Boolean Zy;
  private Boolean Zz;
  private final int xM;
  
  public GoogleMapOptions()
  {
    this.xM = 1;
  }
  
  GoogleMapOptions(int paramInt1, byte paramByte1, byte paramByte2, int paramInt2, CameraPosition paramCameraPosition, byte paramByte3, byte paramByte4, byte paramByte5, byte paramByte6, byte paramByte7, byte paramByte8)
  {
    this.xM = paramInt1;
    this.Zs = com.google.android.gms.maps.internal.a.a(paramByte1);
    this.Zt = com.google.android.gms.maps.internal.a.a(paramByte2);
    this.Zu = paramInt2;
    this.Zv = paramCameraPosition;
    this.Zw = com.google.android.gms.maps.internal.a.a(paramByte3);
    this.Zx = com.google.android.gms.maps.internal.a.a(paramByte4);
    this.Zy = com.google.android.gms.maps.internal.a.a(paramByte5);
    this.Zz = com.google.android.gms.maps.internal.a.a(paramByte6);
    this.ZA = com.google.android.gms.maps.internal.a.a(paramByte7);
    this.ZB = com.google.android.gms.maps.internal.a.a(paramByte8);
  }
  
  public static GoogleMapOptions createFromAttributes(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (paramAttributeSet == null) {
      return null;
    }
    TypedArray localTypedArray = paramContext.getResources().obtainAttributes(paramAttributeSet, R.styleable.MapAttrs);
    GoogleMapOptions localGoogleMapOptions = new GoogleMapOptions();
    if (localTypedArray.hasValue(0)) {
      localGoogleMapOptions.mapType(localTypedArray.getInt(0, -1));
    }
    if (localTypedArray.hasValue(13)) {
      localGoogleMapOptions.zOrderOnTop(localTypedArray.getBoolean(13, false));
    }
    if (localTypedArray.hasValue(12)) {
      localGoogleMapOptions.useViewLifecycleInFragment(localTypedArray.getBoolean(12, false));
    }
    if (localTypedArray.hasValue(6)) {
      localGoogleMapOptions.compassEnabled(localTypedArray.getBoolean(6, true));
    }
    if (localTypedArray.hasValue(7)) {
      localGoogleMapOptions.rotateGesturesEnabled(localTypedArray.getBoolean(7, true));
    }
    if (localTypedArray.hasValue(8)) {
      localGoogleMapOptions.scrollGesturesEnabled(localTypedArray.getBoolean(8, true));
    }
    if (localTypedArray.hasValue(9)) {
      localGoogleMapOptions.tiltGesturesEnabled(localTypedArray.getBoolean(9, true));
    }
    if (localTypedArray.hasValue(11)) {
      localGoogleMapOptions.zoomGesturesEnabled(localTypedArray.getBoolean(11, true));
    }
    if (localTypedArray.hasValue(10)) {
      localGoogleMapOptions.zoomControlsEnabled(localTypedArray.getBoolean(10, true));
    }
    localGoogleMapOptions.camera(CameraPosition.createFromAttributes(paramContext, paramAttributeSet));
    localTypedArray.recycle();
    return localGoogleMapOptions;
  }
  
  public GoogleMapOptions camera(CameraPosition paramCameraPosition)
  {
    this.Zv = paramCameraPosition;
    return this;
  }
  
  public GoogleMapOptions compassEnabled(boolean paramBoolean)
  {
    this.Zx = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public CameraPosition getCamera()
  {
    return this.Zv;
  }
  
  public Boolean getCompassEnabled()
  {
    return this.Zx;
  }
  
  public int getMapType()
  {
    return this.Zu;
  }
  
  public Boolean getRotateGesturesEnabled()
  {
    return this.ZB;
  }
  
  public Boolean getScrollGesturesEnabled()
  {
    return this.Zy;
  }
  
  public Boolean getTiltGesturesEnabled()
  {
    return this.ZA;
  }
  
  public Boolean getUseViewLifecycleInFragment()
  {
    return this.Zt;
  }
  
  int getVersionCode()
  {
    return this.xM;
  }
  
  public Boolean getZOrderOnTop()
  {
    return this.Zs;
  }
  
  public Boolean getZoomControlsEnabled()
  {
    return this.Zw;
  }
  
  public Boolean getZoomGesturesEnabled()
  {
    return this.Zz;
  }
  
  byte jq()
  {
    return com.google.android.gms.maps.internal.a.c(this.Zs);
  }
  
  byte jr()
  {
    return com.google.android.gms.maps.internal.a.c(this.Zt);
  }
  
  byte js()
  {
    return com.google.android.gms.maps.internal.a.c(this.Zw);
  }
  
  byte jt()
  {
    return com.google.android.gms.maps.internal.a.c(this.Zx);
  }
  
  byte ju()
  {
    return com.google.android.gms.maps.internal.a.c(this.Zy);
  }
  
  byte jv()
  {
    return com.google.android.gms.maps.internal.a.c(this.Zz);
  }
  
  byte jw()
  {
    return com.google.android.gms.maps.internal.a.c(this.ZA);
  }
  
  byte jx()
  {
    return com.google.android.gms.maps.internal.a.c(this.ZB);
  }
  
  public GoogleMapOptions mapType(int paramInt)
  {
    this.Zu = paramInt;
    return this;
  }
  
  public GoogleMapOptions rotateGesturesEnabled(boolean paramBoolean)
  {
    this.ZB = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public GoogleMapOptions scrollGesturesEnabled(boolean paramBoolean)
  {
    this.Zy = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public GoogleMapOptions tiltGesturesEnabled(boolean paramBoolean)
  {
    this.ZA = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public GoogleMapOptions useViewLifecycleInFragment(boolean paramBoolean)
  {
    this.Zt = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (v.jL())
    {
      a.a(this, paramParcel, paramInt);
      return;
    }
    GoogleMapOptionsCreator.a(this, paramParcel, paramInt);
  }
  
  public GoogleMapOptions zOrderOnTop(boolean paramBoolean)
  {
    this.Zs = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public GoogleMapOptions zoomControlsEnabled(boolean paramBoolean)
  {
    this.Zw = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public GoogleMapOptions zoomGesturesEnabled(boolean paramBoolean)
  {
    this.Zz = Boolean.valueOf(paramBoolean);
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/maps/GoogleMapOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */