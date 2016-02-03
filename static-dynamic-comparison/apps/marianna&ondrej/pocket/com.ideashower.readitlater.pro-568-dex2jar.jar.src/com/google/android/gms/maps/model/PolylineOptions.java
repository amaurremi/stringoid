package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.a.b;
import java.util.ArrayList;
import java.util.List;

public final class PolylineOptions
  implements SafeParcelable
{
  public static final i CREATOR = new i();
  private final int a;
  private final List b;
  private float c = 10.0F;
  private int d = -16777216;
  private float e = 0.0F;
  private boolean f = true;
  private boolean g = false;
  
  public PolylineOptions()
  {
    this.a = 1;
    this.b = new ArrayList();
  }
  
  PolylineOptions(int paramInt1, List paramList, float paramFloat1, int paramInt2, float paramFloat2, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.a = paramInt1;
    this.b = paramList;
    this.c = paramFloat1;
    this.d = paramInt2;
    this.e = paramFloat2;
    this.f = paramBoolean1;
    this.g = paramBoolean2;
  }
  
  int a()
  {
    return this.a;
  }
  
  public List b()
  {
    return this.b;
  }
  
  public float c()
  {
    return this.c;
  }
  
  public int d()
  {
    return this.d;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public float e()
  {
    return this.e;
  }
  
  public boolean f()
  {
    return this.f;
  }
  
  public boolean g()
  {
    return this.g;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (b.a())
    {
      u.a(this, paramParcel, paramInt);
      return;
    }
    i.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/maps/model/PolylineOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */