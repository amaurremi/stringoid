package com.google.android.gms.maps;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.util.AttributeSet;
import com.google.android.gms.a.d;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.a.h;
import com.google.android.gms.maps.a.y;
import com.google.android.gms.maps.model.CameraPosition;

public final class GoogleMapOptions
  implements SafeParcelable
{
  public static final b Uo = new b();
  private Boolean Up;
  private Boolean Uq;
  private int Ur = -1;
  private CameraPosition Us;
  private Boolean Ut;
  private Boolean Uu;
  private Boolean Uv;
  private Boolean Uw;
  private Boolean Ux;
  private Boolean Uy;
  private final int qh;
  
  public GoogleMapOptions()
  {
    this.qh = 1;
  }
  
  GoogleMapOptions(int paramInt1, byte paramByte1, byte paramByte2, int paramInt2, CameraPosition paramCameraPosition, byte paramByte3, byte paramByte4, byte paramByte5, byte paramByte6, byte paramByte7, byte paramByte8)
  {
    this.qh = paramInt1;
    this.Up = h.f(paramByte1);
    this.Uq = h.f(paramByte2);
    this.Ur = paramInt2;
    this.Us = paramCameraPosition;
    this.Ut = h.f(paramByte3);
    this.Uu = h.f(paramByte4);
    this.Uv = h.f(paramByte5);
    this.Uw = h.f(paramByte6);
    this.Ux = h.f(paramByte7);
    this.Uy = h.f(paramByte8);
  }
  
  public static GoogleMapOptions a(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (paramAttributeSet == null) {
      return null;
    }
    TypedArray localTypedArray = paramContext.getResources().obtainAttributes(paramAttributeSet, a.d.MapAttrs);
    GoogleMapOptions localGoogleMapOptions = new GoogleMapOptions();
    if (localTypedArray.hasValue(0)) {
      localGoogleMapOptions.dP(localTypedArray.getInt(0, -1));
    }
    if (localTypedArray.hasValue(13)) {
      localGoogleMapOptions.O(localTypedArray.getBoolean(13, false));
    }
    if (localTypedArray.hasValue(12)) {
      localGoogleMapOptions.P(localTypedArray.getBoolean(12, false));
    }
    if (localTypedArray.hasValue(6)) {
      localGoogleMapOptions.R(localTypedArray.getBoolean(6, true));
    }
    if (localTypedArray.hasValue(7)) {
      localGoogleMapOptions.V(localTypedArray.getBoolean(7, true));
    }
    if (localTypedArray.hasValue(8)) {
      localGoogleMapOptions.S(localTypedArray.getBoolean(8, true));
    }
    if (localTypedArray.hasValue(9)) {
      localGoogleMapOptions.U(localTypedArray.getBoolean(9, true));
    }
    if (localTypedArray.hasValue(11)) {
      localGoogleMapOptions.T(localTypedArray.getBoolean(11, true));
    }
    if (localTypedArray.hasValue(10)) {
      localGoogleMapOptions.Q(localTypedArray.getBoolean(10, true));
    }
    localGoogleMapOptions.a(CameraPosition.b(paramContext, paramAttributeSet));
    localTypedArray.recycle();
    return localGoogleMapOptions;
  }
  
  public GoogleMapOptions O(boolean paramBoolean)
  {
    this.Up = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public GoogleMapOptions P(boolean paramBoolean)
  {
    this.Uq = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public GoogleMapOptions Q(boolean paramBoolean)
  {
    this.Ut = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public GoogleMapOptions R(boolean paramBoolean)
  {
    this.Uu = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public GoogleMapOptions S(boolean paramBoolean)
  {
    this.Uv = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public GoogleMapOptions T(boolean paramBoolean)
  {
    this.Uw = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public GoogleMapOptions U(boolean paramBoolean)
  {
    this.Ux = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public GoogleMapOptions V(boolean paramBoolean)
  {
    this.Uy = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public GoogleMapOptions a(CameraPosition paramCameraPosition)
  {
    this.Us = paramCameraPosition;
    return this;
  }
  
  public GoogleMapOptions dP(int paramInt)
  {
    this.Ur = paramInt;
    return this;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  int lX()
  {
    return this.qh;
  }
  
  byte tY()
  {
    return h.c(this.Up);
  }
  
  byte tZ()
  {
    return h.c(this.Uq);
  }
  
  byte ua()
  {
    return h.c(this.Ut);
  }
  
  byte ub()
  {
    return h.c(this.Uu);
  }
  
  byte uc()
  {
    return h.c(this.Uv);
  }
  
  byte ud()
  {
    return h.c(this.Uw);
  }
  
  byte ue()
  {
    return h.c(this.Ux);
  }
  
  byte uf()
  {
    return h.c(this.Uy);
  }
  
  public int ug()
  {
    return this.Ur;
  }
  
  public CameraPosition uh()
  {
    return this.Us;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (y.uL())
    {
      d.a(this, paramParcel, paramInt);
      return;
    }
    b.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/maps/GoogleMapOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */