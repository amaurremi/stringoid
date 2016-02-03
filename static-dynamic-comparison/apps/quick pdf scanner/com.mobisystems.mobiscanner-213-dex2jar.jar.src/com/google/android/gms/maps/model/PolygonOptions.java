package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.a.y;
import java.util.ArrayList;
import java.util.List;

public final class PolygonOptions
  implements SafeParcelable
{
  public static final i VD = new i();
  private final List<LatLng> VE;
  private final List<List<LatLng>> VF;
  private boolean VG = false;
  private float Va = 10.0F;
  private int Vb = -16777216;
  private int Vc = 0;
  private float Vd = 0.0F;
  private boolean Ve = true;
  private final int qh;
  
  public PolygonOptions()
  {
    this.qh = 1;
    this.VE = new ArrayList();
    this.VF = new ArrayList();
  }
  
  PolygonOptions(int paramInt1, List<LatLng> paramList, List paramList1, float paramFloat1, int paramInt2, int paramInt3, float paramFloat2, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.qh = paramInt1;
    this.VE = paramList;
    this.VF = paramList1;
    this.Va = paramFloat1;
    this.Vb = paramInt2;
    this.Vc = paramInt3;
    this.Vd = paramFloat2;
    this.Ve = paramBoolean1;
    this.VG = paramBoolean2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public float getStrokeWidth()
  {
    return this.Va;
  }
  
  public boolean isVisible()
  {
    return this.Ve;
  }
  
  int lX()
  {
    return this.qh;
  }
  
  public int uQ()
  {
    return this.Vb;
  }
  
  public int uR()
  {
    return this.Vc;
  }
  
  public float uS()
  {
    return this.Vd;
  }
  
  List vg()
  {
    return this.VF;
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
      u.a(this, paramParcel, paramInt);
      return;
    }
    i.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/maps/model/PolygonOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */