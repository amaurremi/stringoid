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
  public static final a CREATOR = new a();
  private final int BR;
  private Boolean aiA;
  private Boolean aiB;
  private Boolean aiC;
  private Boolean aiD;
  private Boolean aiE;
  private Boolean aiv;
  private Boolean aiw;
  private int aix = -1;
  private CameraPosition aiy;
  private Boolean aiz;
  
  public GoogleMapOptions()
  {
    this.BR = 1;
  }
  
  GoogleMapOptions(int paramInt1, byte paramByte1, byte paramByte2, int paramInt2, CameraPosition paramCameraPosition, byte paramByte3, byte paramByte4, byte paramByte5, byte paramByte6, byte paramByte7, byte paramByte8)
  {
    this.BR = paramInt1;
    this.aiv = com.google.android.gms.maps.internal.a.a(paramByte1);
    this.aiw = com.google.android.gms.maps.internal.a.a(paramByte2);
    this.aix = paramInt2;
    this.aiy = paramCameraPosition;
    this.aiz = com.google.android.gms.maps.internal.a.a(paramByte3);
    this.aiA = com.google.android.gms.maps.internal.a.a(paramByte4);
    this.aiB = com.google.android.gms.maps.internal.a.a(paramByte5);
    this.aiC = com.google.android.gms.maps.internal.a.a(paramByte6);
    this.aiD = com.google.android.gms.maps.internal.a.a(paramByte7);
    this.aiE = com.google.android.gms.maps.internal.a.a(paramByte8);
  }
  
  public static GoogleMapOptions createFromAttributes(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (paramAttributeSet == null) {
      return null;
    }
    TypedArray localTypedArray = paramContext.getResources().obtainAttributes(paramAttributeSet, R.styleable.MapAttrs);
    GoogleMapOptions localGoogleMapOptions = new GoogleMapOptions();
    if (localTypedArray.hasValue(R.styleable.MapAttrs_mapType)) {
      localGoogleMapOptions.mapType(localTypedArray.getInt(R.styleable.MapAttrs_mapType, -1));
    }
    if (localTypedArray.hasValue(R.styleable.MapAttrs_zOrderOnTop)) {
      localGoogleMapOptions.zOrderOnTop(localTypedArray.getBoolean(R.styleable.MapAttrs_zOrderOnTop, false));
    }
    if (localTypedArray.hasValue(R.styleable.MapAttrs_useViewLifecycle)) {
      localGoogleMapOptions.useViewLifecycleInFragment(localTypedArray.getBoolean(R.styleable.MapAttrs_useViewLifecycle, false));
    }
    if (localTypedArray.hasValue(R.styleable.MapAttrs_uiCompass)) {
      localGoogleMapOptions.compassEnabled(localTypedArray.getBoolean(R.styleable.MapAttrs_uiCompass, true));
    }
    if (localTypedArray.hasValue(R.styleable.MapAttrs_uiRotateGestures)) {
      localGoogleMapOptions.rotateGesturesEnabled(localTypedArray.getBoolean(R.styleable.MapAttrs_uiRotateGestures, true));
    }
    if (localTypedArray.hasValue(R.styleable.MapAttrs_uiScrollGestures)) {
      localGoogleMapOptions.scrollGesturesEnabled(localTypedArray.getBoolean(R.styleable.MapAttrs_uiScrollGestures, true));
    }
    if (localTypedArray.hasValue(R.styleable.MapAttrs_uiTiltGestures)) {
      localGoogleMapOptions.tiltGesturesEnabled(localTypedArray.getBoolean(R.styleable.MapAttrs_uiTiltGestures, true));
    }
    if (localTypedArray.hasValue(R.styleable.MapAttrs_uiZoomGestures)) {
      localGoogleMapOptions.zoomGesturesEnabled(localTypedArray.getBoolean(R.styleable.MapAttrs_uiZoomGestures, true));
    }
    if (localTypedArray.hasValue(R.styleable.MapAttrs_uiZoomControls)) {
      localGoogleMapOptions.zoomControlsEnabled(localTypedArray.getBoolean(R.styleable.MapAttrs_uiZoomControls, true));
    }
    localGoogleMapOptions.camera(CameraPosition.createFromAttributes(paramContext, paramAttributeSet));
    localTypedArray.recycle();
    return localGoogleMapOptions;
  }
  
  public GoogleMapOptions camera(CameraPosition paramCameraPosition)
  {
    this.aiy = paramCameraPosition;
    return this;
  }
  
  public GoogleMapOptions compassEnabled(boolean paramBoolean)
  {
    this.aiA = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public CameraPosition getCamera()
  {
    return this.aiy;
  }
  
  public Boolean getCompassEnabled()
  {
    return this.aiA;
  }
  
  public int getMapType()
  {
    return this.aix;
  }
  
  public Boolean getRotateGesturesEnabled()
  {
    return this.aiE;
  }
  
  public Boolean getScrollGesturesEnabled()
  {
    return this.aiB;
  }
  
  public Boolean getTiltGesturesEnabled()
  {
    return this.aiD;
  }
  
  public Boolean getUseViewLifecycleInFragment()
  {
    return this.aiw;
  }
  
  int getVersionCode()
  {
    return this.BR;
  }
  
  public Boolean getZOrderOnTop()
  {
    return this.aiv;
  }
  
  public Boolean getZoomControlsEnabled()
  {
    return this.aiz;
  }
  
  public Boolean getZoomGesturesEnabled()
  {
    return this.aiC;
  }
  
  public GoogleMapOptions mapType(int paramInt)
  {
    this.aix = paramInt;
    return this;
  }
  
  byte mp()
  {
    return com.google.android.gms.maps.internal.a.c(this.aiv);
  }
  
  byte mq()
  {
    return com.google.android.gms.maps.internal.a.c(this.aiw);
  }
  
  byte mr()
  {
    return com.google.android.gms.maps.internal.a.c(this.aiz);
  }
  
  byte ms()
  {
    return com.google.android.gms.maps.internal.a.c(this.aiA);
  }
  
  byte mt()
  {
    return com.google.android.gms.maps.internal.a.c(this.aiB);
  }
  
  byte mu()
  {
    return com.google.android.gms.maps.internal.a.c(this.aiC);
  }
  
  byte mv()
  {
    return com.google.android.gms.maps.internal.a.c(this.aiD);
  }
  
  byte mw()
  {
    return com.google.android.gms.maps.internal.a.c(this.aiE);
  }
  
  public GoogleMapOptions rotateGesturesEnabled(boolean paramBoolean)
  {
    this.aiE = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public GoogleMapOptions scrollGesturesEnabled(boolean paramBoolean)
  {
    this.aiB = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public GoogleMapOptions tiltGesturesEnabled(boolean paramBoolean)
  {
    this.aiD = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public GoogleMapOptions useViewLifecycleInFragment(boolean paramBoolean)
  {
    this.aiw = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (v.mK())
    {
      b.a(this, paramParcel, paramInt);
      return;
    }
    a.a(this, paramParcel, paramInt);
  }
  
  public GoogleMapOptions zOrderOnTop(boolean paramBoolean)
  {
    this.aiv = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public GoogleMapOptions zoomControlsEnabled(boolean paramBoolean)
  {
    this.aiz = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public GoogleMapOptions zoomGesturesEnabled(boolean paramBoolean)
  {
    this.aiC = Boolean.valueOf(paramBoolean);
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/maps/GoogleMapOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */