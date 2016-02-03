package com.google.android.gms.maps;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.CameraPosition;

public final class GoogleMapOptions
  implements SafeParcelable
{
  public static final a CREATOR = new a();
  private final int a;
  private Boolean b;
  private Boolean c;
  private int d = -1;
  private CameraPosition e;
  private Boolean f;
  private Boolean g;
  private Boolean h;
  private Boolean i;
  private Boolean j;
  private Boolean k;
  
  public GoogleMapOptions()
  {
    this.a = 1;
  }
  
  GoogleMapOptions(int paramInt1, byte paramByte1, byte paramByte2, int paramInt2, CameraPosition paramCameraPosition, byte paramByte3, byte paramByte4, byte paramByte5, byte paramByte6, byte paramByte7, byte paramByte8)
  {
    this.a = paramInt1;
    this.b = com.google.android.gms.maps.a.a.a(paramByte1);
    this.c = com.google.android.gms.maps.a.a.a(paramByte2);
    this.d = paramInt2;
    this.e = paramCameraPosition;
    this.f = com.google.android.gms.maps.a.a.a(paramByte3);
    this.g = com.google.android.gms.maps.a.a.a(paramByte4);
    this.h = com.google.android.gms.maps.a.a.a(paramByte5);
    this.i = com.google.android.gms.maps.a.a.a(paramByte6);
    this.j = com.google.android.gms.maps.a.a.a(paramByte7);
    this.k = com.google.android.gms.maps.a.a.a(paramByte8);
  }
  
  int a()
  {
    return this.a;
  }
  
  byte b()
  {
    return com.google.android.gms.maps.a.a.a(this.b);
  }
  
  byte c()
  {
    return com.google.android.gms.maps.a.a.a(this.c);
  }
  
  byte d()
  {
    return com.google.android.gms.maps.a.a.a(this.f);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  byte e()
  {
    return com.google.android.gms.maps.a.a.a(this.g);
  }
  
  byte f()
  {
    return com.google.android.gms.maps.a.a.a(this.h);
  }
  
  byte g()
  {
    return com.google.android.gms.maps.a.a.a(this.i);
  }
  
  byte h()
  {
    return com.google.android.gms.maps.a.a.a(this.j);
  }
  
  byte i()
  {
    return com.google.android.gms.maps.a.a.a(this.k);
  }
  
  public int j()
  {
    return this.d;
  }
  
  public CameraPosition k()
  {
    return this.e;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (com.google.android.gms.maps.a.b.a())
    {
      b.a(this, paramParcel, paramInt);
      return;
    }
    a.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/maps/GoogleMapOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */