package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.a.y;
import com.google.android.gms.maps.model.a.h;
import com.google.android.gms.maps.model.a.h.a;

public final class TileOverlayOptions
  implements SafeParcelable
{
  public static final l VK = new l();
  private h VL;
  private m VM;
  private boolean VN = true;
  private float Vd;
  private boolean Ve = true;
  private final int qh;
  
  public TileOverlayOptions()
  {
    this.qh = 1;
  }
  
  TileOverlayOptions(int paramInt, IBinder paramIBinder, boolean paramBoolean1, float paramFloat, boolean paramBoolean2)
  {
    this.qh = paramInt;
    this.VL = h.a.al(paramIBinder);
    if (this.VL == null) {}
    for (paramIBinder = null;; paramIBinder = new m()
        {
          private final h VO = TileOverlayOptions.b(TileOverlayOptions.this);
        })
    {
      this.VM = paramIBinder;
      this.Ve = paramBoolean1;
      this.Vd = paramFloat;
      this.VN = paramBoolean2;
      return;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean isVisible()
  {
    return this.Ve;
  }
  
  int lX()
  {
    return this.qh;
  }
  
  public float uS()
  {
    return this.Vd;
  }
  
  IBinder vj()
  {
    return this.VL.asBinder();
  }
  
  public boolean vk()
  {
    return this.VN;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (y.uL())
    {
      x.a(this, paramParcel, paramInt);
      return;
    }
    l.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/maps/model/TileOverlayOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */