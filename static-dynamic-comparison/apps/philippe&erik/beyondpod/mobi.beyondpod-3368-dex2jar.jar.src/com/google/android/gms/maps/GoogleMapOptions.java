package com.google.android.gms.maps;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.util.AttributeSet;
import com.google.android.gms.R.styleable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.r;
import com.google.android.gms.maps.model.CameraPosition;

public final class GoogleMapOptions
  implements SafeParcelable
{
  public static final GoogleMapOptionsCreator CREATOR = new GoogleMapOptionsCreator();
  private Boolean BJ;
  private Boolean BK;
  private int BL = -1;
  private CameraPosition BM;
  private Boolean BN;
  private Boolean BO;
  private Boolean BP;
  private Boolean BQ;
  private Boolean BR;
  private Boolean BS;
  private final int kg;
  
  public GoogleMapOptions()
  {
    this.kg = 1;
  }
  
  GoogleMapOptions(int paramInt1, byte paramByte1, byte paramByte2, int paramInt2, CameraPosition paramCameraPosition, byte paramByte3, byte paramByte4, byte paramByte5, byte paramByte6, byte paramByte7, byte paramByte8)
  {
    this.kg = paramInt1;
    this.BJ = com.google.android.gms.maps.internal.a.a(paramByte1);
    this.BK = com.google.android.gms.maps.internal.a.a(paramByte2);
    this.BL = paramInt2;
    this.BM = paramCameraPosition;
    this.BN = com.google.android.gms.maps.internal.a.a(paramByte3);
    this.BO = com.google.android.gms.maps.internal.a.a(paramByte4);
    this.BP = com.google.android.gms.maps.internal.a.a(paramByte5);
    this.BQ = com.google.android.gms.maps.internal.a.a(paramByte6);
    this.BR = com.google.android.gms.maps.internal.a.a(paramByte7);
    this.BS = com.google.android.gms.maps.internal.a.a(paramByte8);
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
    this.BM = paramCameraPosition;
    return this;
  }
  
  public GoogleMapOptions compassEnabled(boolean paramBoolean)
  {
    this.BO = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  byte eo()
  {
    return com.google.android.gms.maps.internal.a.c(this.BJ);
  }
  
  byte ep()
  {
    return com.google.android.gms.maps.internal.a.c(this.BK);
  }
  
  byte eq()
  {
    return com.google.android.gms.maps.internal.a.c(this.BN);
  }
  
  byte er()
  {
    return com.google.android.gms.maps.internal.a.c(this.BO);
  }
  
  byte es()
  {
    return com.google.android.gms.maps.internal.a.c(this.BP);
  }
  
  byte et()
  {
    return com.google.android.gms.maps.internal.a.c(this.BQ);
  }
  
  byte eu()
  {
    return com.google.android.gms.maps.internal.a.c(this.BR);
  }
  
  byte ev()
  {
    return com.google.android.gms.maps.internal.a.c(this.BS);
  }
  
  public CameraPosition getCamera()
  {
    return this.BM;
  }
  
  public Boolean getCompassEnabled()
  {
    return this.BO;
  }
  
  public int getMapType()
  {
    return this.BL;
  }
  
  public Boolean getRotateGesturesEnabled()
  {
    return this.BS;
  }
  
  public Boolean getScrollGesturesEnabled()
  {
    return this.BP;
  }
  
  public Boolean getTiltGesturesEnabled()
  {
    return this.BR;
  }
  
  public Boolean getUseViewLifecycleInFragment()
  {
    return this.BK;
  }
  
  int getVersionCode()
  {
    return this.kg;
  }
  
  public Boolean getZOrderOnTop()
  {
    return this.BJ;
  }
  
  public Boolean getZoomControlsEnabled()
  {
    return this.BN;
  }
  
  public Boolean getZoomGesturesEnabled()
  {
    return this.BQ;
  }
  
  public GoogleMapOptions mapType(int paramInt)
  {
    this.BL = paramInt;
    return this;
  }
  
  public GoogleMapOptions rotateGesturesEnabled(boolean paramBoolean)
  {
    this.BS = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public GoogleMapOptions scrollGesturesEnabled(boolean paramBoolean)
  {
    this.BP = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public GoogleMapOptions tiltGesturesEnabled(boolean paramBoolean)
  {
    this.BR = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public GoogleMapOptions useViewLifecycleInFragment(boolean paramBoolean)
  {
    this.BK = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (r.eD())
    {
      a.a(this, paramParcel, paramInt);
      return;
    }
    GoogleMapOptionsCreator.a(this, paramParcel, paramInt);
  }
  
  public GoogleMapOptions zOrderOnTop(boolean paramBoolean)
  {
    this.BJ = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public GoogleMapOptions zoomControlsEnabled(boolean paramBoolean)
  {
    this.BN = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public GoogleMapOptions zoomGesturesEnabled(boolean paramBoolean)
  {
    this.BQ = Boolean.valueOf(paramBoolean);
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/maps/GoogleMapOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */