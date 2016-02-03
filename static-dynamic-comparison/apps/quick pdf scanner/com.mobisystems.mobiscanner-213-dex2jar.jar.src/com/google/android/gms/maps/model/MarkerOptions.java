package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.c;
import com.google.android.gms.dynamic.c.a;
import com.google.android.gms.maps.a.y;

public final class MarkerOptions
  implements SafeParcelable
{
  public static final h Vu = new h();
  private float VA = 0.0F;
  private float VB = 0.5F;
  private float VC = 0.0F;
  private boolean Ve = true;
  private float Vm = 0.5F;
  private float Vn = 1.0F;
  private LatLng Vv;
  private String Vw;
  private a Vx;
  private boolean Vy;
  private boolean Vz = false;
  private float mAlpha = 1.0F;
  private final int qh;
  private String th;
  
  public MarkerOptions()
  {
    this.qh = 1;
  }
  
  MarkerOptions(int paramInt, LatLng paramLatLng, String paramString1, String paramString2, IBinder paramIBinder, float paramFloat1, float paramFloat2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    this.qh = paramInt;
    this.Vv = paramLatLng;
    this.th = paramString1;
    this.Vw = paramString2;
    if (paramIBinder == null) {}
    for (paramLatLng = null;; paramLatLng = new a(c.a.h(paramIBinder)))
    {
      this.Vx = paramLatLng;
      this.Vm = paramFloat1;
      this.Vn = paramFloat2;
      this.Vy = paramBoolean1;
      this.Ve = paramBoolean2;
      this.Vz = paramBoolean3;
      this.VA = paramFloat3;
      this.VB = paramFloat4;
      this.VC = paramFloat5;
      this.mAlpha = paramFloat6;
      return;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public float getAlpha()
  {
    return this.mAlpha;
  }
  
  public float getRotation()
  {
    return this.VA;
  }
  
  public String getTitle()
  {
    return this.th;
  }
  
  public boolean isVisible()
  {
    return this.Ve;
  }
  
  int lX()
  {
    return this.qh;
  }
  
  public float uX()
  {
    return this.Vm;
  }
  
  public float uY()
  {
    return this.Vn;
  }
  
  IBinder uZ()
  {
    if (this.Vx == null) {
      return null;
    }
    return this.Vx.uM().asBinder();
  }
  
  public LatLng va()
  {
    return this.Vv;
  }
  
  public String vb()
  {
    return this.Vw;
  }
  
  public boolean vc()
  {
    return this.Vy;
  }
  
  public boolean vd()
  {
    return this.Vz;
  }
  
  public float ve()
  {
    return this.VB;
  }
  
  public float vf()
  {
    return this.VC;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (y.uL())
    {
      t.a(this, paramParcel, paramInt);
      return;
    }
    h.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/maps/model/MarkerOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */