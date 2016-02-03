package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class jr
  implements SafeParcelable
{
  public static final Parcelable.Creator<jr> CREATOR = new gc();
  long SM;
  long SN;
  private final int qh;
  
  jr()
  {
    this.qh = 1;
  }
  
  jr(int paramInt, long paramLong1, long paramLong2)
  {
    this.qh = paramInt;
    this.SM = paramLong1;
    this.SN = paramLong2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int lX()
  {
    return this.qh;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    gc.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/jr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */