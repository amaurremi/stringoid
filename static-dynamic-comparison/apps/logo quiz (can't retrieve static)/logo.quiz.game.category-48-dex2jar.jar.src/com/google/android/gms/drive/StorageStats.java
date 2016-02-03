package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class StorageStats
  implements SafeParcelable
{
  public static final Parcelable.Creator<StorageStats> CREATOR = new g();
  final int BR;
  final long Nt;
  final long Nu;
  final long Nv;
  final long Nw;
  final int Nx;
  
  StorageStats(int paramInt1, long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt2)
  {
    this.BR = paramInt1;
    this.Nt = paramLong1;
    this.Nu = paramLong2;
    this.Nv = paramLong3;
    this.Nw = paramLong4;
    this.Nx = paramInt2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    g.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/drive/StorageStats.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */