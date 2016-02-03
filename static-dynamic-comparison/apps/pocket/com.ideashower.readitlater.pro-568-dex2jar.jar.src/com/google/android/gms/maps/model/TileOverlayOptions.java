package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.a.a;

public final class TileOverlayOptions
  implements SafeParcelable
{
  public static final k CREATOR = new k();
  private final int a;
  private a b;
  private l c;
  private boolean d = true;
  private float e;
  
  public TileOverlayOptions()
  {
    this.a = 1;
  }
  
  TileOverlayOptions(int paramInt, IBinder paramIBinder, boolean paramBoolean, float paramFloat)
  {
    this.a = paramInt;
    this.b = com.google.android.gms.maps.model.a.b.a(paramIBinder);
    if (this.b == null) {}
    for (paramIBinder = null;; paramIBinder = new l()
        {
          private final a c = TileOverlayOptions.a(TileOverlayOptions.this);
        })
    {
      this.c = paramIBinder;
      this.d = paramBoolean;
      this.e = paramFloat;
      return;
    }
  }
  
  int a()
  {
    return this.a;
  }
  
  IBinder b()
  {
    return this.b.asBinder();
  }
  
  public float c()
  {
    return this.e;
  }
  
  public boolean d()
  {
    return this.d;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (com.google.android.gms.maps.a.b.a())
    {
      w.a(this, paramParcel, paramInt);
      return;
    }
    k.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/maps/model/TileOverlayOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */