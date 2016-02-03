package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class StorageStats
  implements SafeParcelable
{
  public static final Parcelable.Creator<StorageStats> CREATOR = new e();
  final long Ib;
  final long Ic;
  final long Id;
  final long Ie;
  final int If;
  final int xM;
  
  StorageStats(int paramInt1, long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt2)
  {
    this.xM = paramInt1;
    this.Ib = paramLong1;
    this.Ic = paramLong2;
    this.Id = paramLong3;
    this.Ie = paramLong4;
    this.If = paramInt2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    e.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/drive/StorageStats.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */