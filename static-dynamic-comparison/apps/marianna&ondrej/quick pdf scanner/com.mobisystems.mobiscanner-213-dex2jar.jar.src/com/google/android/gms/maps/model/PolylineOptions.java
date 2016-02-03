package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.a.y;
import java.util.ArrayList;
import java.util.List;

public final class PolylineOptions
  implements SafeParcelable
{
  public static final j VH = new j();
  private final List<LatLng> VE;
  private boolean VG = false;
  private float Vd = 0.0F;
  private boolean Ve = true;
  private float Vi = 10.0F;
  private int qL = -16777216;
  private final int qh;
  
  public PolylineOptions()
  {
    this.qh = 1;
    this.VE = new ArrayList();
  }
  
  PolylineOptions(int paramInt1, List paramList, float paramFloat1, int paramInt2, float paramFloat2, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.qh = paramInt1;
    this.VE = paramList;
    this.Vi = paramFloat1;
    this.qL = paramInt2;
    this.Vd = paramFloat2;
    this.Ve = paramBoolean1;
    this.VG = paramBoolean2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getColor()
  {
    return this.qL;
  }
  
  public float getWidth()
  {
    return this.Vi;
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
  
  public List<LatLng> vh()
  {
    return this.VE;
  }
  
  public boolean vi()
  {
    return this.VG;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (y.uL())
    {
      v.a(this, paramParcel, paramInt);
      return;
    }
    j.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/maps/model/PolylineOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */