package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class hu
  implements SafeParcelable
{
  public static final hv CREATOR = new hv();
  private final hw GS;
  private final int xJ;
  
  hu(int paramInt, hw paramhw)
  {
    this.xJ = paramInt;
    this.GS = paramhw;
  }
  
  private hu(hw paramhw)
  {
    this.xJ = 1;
    this.GS = paramhw;
  }
  
  public static hu a(hz.b<?, ?> paramb)
  {
    if ((paramb instanceof hw)) {
      return new hu((hw)paramb);
    }
    throw new IllegalArgumentException("Unsupported safe parcelable field converter class.");
  }
  
  public int describeContents()
  {
    hv localhv = CREATOR;
    return 0;
  }
  
  hw fw()
  {
    return this.GS;
  }
  
  public hz.b<?, ?> fx()
  {
    if (this.GS != null) {
      return this.GS;
    }
    throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
  }
  
  int getVersionCode()
  {
    return this.xJ;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    hv localhv = CREATOR;
    hv.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/hu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */