package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.a.b;
import java.util.ArrayList;
import java.util.List;

public final class PolygonOptions
  implements SafeParcelable
{
  public static final h CREATOR = new h();
  private final int a;
  private final List b;
  private final List c;
  private float d = 10.0F;
  private int e = -16777216;
  private int f = 0;
  private float g = 0.0F;
  private boolean h = true;
  private boolean i = false;
  
  public PolygonOptions()
  {
    this.a = 1;
    this.b = new ArrayList();
    this.c = new ArrayList();
  }
  
  PolygonOptions(int paramInt1, List paramList1, List paramList2, float paramFloat1, int paramInt2, int paramInt3, float paramFloat2, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.a = paramInt1;
    this.b = paramList1;
    this.c = paramList2;
    this.d = paramFloat1;
    this.e = paramInt2;
    this.f = paramInt3;
    this.g = paramFloat2;
    this.h = paramBoolean1;
    this.i = paramBoolean2;
  }
  
  int a()
  {
    return this.a;
  }
  
  List b()
  {
    return this.c;
  }
  
  public List c()
  {
    return this.b;
  }
  
  public float d()
  {
    return this.d;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int e()
  {
    return this.e;
  }
  
  public int f()
  {
    return this.f;
  }
  
  public float g()
  {
    return this.g;
  }
  
  public boolean h()
  {
    return this.h;
  }
  
  public boolean i()
  {
    return this.i;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (b.a())
    {
      t.a(this, paramParcel, paramInt);
      return;
    }
    h.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/maps/model/PolygonOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */