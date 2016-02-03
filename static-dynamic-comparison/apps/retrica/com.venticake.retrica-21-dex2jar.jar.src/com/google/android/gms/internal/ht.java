package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ht
  implements SafeParcelable
{
  public static final hu CREATOR = new hu();
  private final hv GV;
  private final int xM;
  
  ht(int paramInt, hv paramhv)
  {
    this.xM = paramInt;
    this.GV = paramhv;
  }
  
  private ht(hv paramhv)
  {
    this.xM = 1;
    this.GV = paramhv;
  }
  
  public static ht a(hy.b<?, ?> paramb)
  {
    if ((paramb instanceof hv)) {
      return new ht((hv)paramb);
    }
    throw new IllegalArgumentException("Unsupported safe parcelable field converter class.");
  }
  
  public int describeContents()
  {
    hu localhu = CREATOR;
    return 0;
  }
  
  hv fB()
  {
    return this.GV;
  }
  
  public hy.b<?, ?> fC()
  {
    if (this.GV != null) {
      return this.GV;
    }
    throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
  }
  
  int getVersionCode()
  {
    return this.xM;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    hu localhu = CREATOR;
    hu.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/ht.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */