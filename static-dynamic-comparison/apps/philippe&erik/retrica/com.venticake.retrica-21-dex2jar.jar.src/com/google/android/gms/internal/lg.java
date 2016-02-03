package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class lg
  implements SafeParcelable
{
  public static final Parcelable.Creator<lg> CREATOR = new lh();
  int[] akd;
  private final int xM;
  
  lg()
  {
    this(1, null);
  }
  
  lg(int paramInt, int[] paramArrayOfInt)
  {
    this.xM = paramInt;
    this.akd = paramArrayOfInt;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getVersionCode()
  {
    return this.xM;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    lh.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/lg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */