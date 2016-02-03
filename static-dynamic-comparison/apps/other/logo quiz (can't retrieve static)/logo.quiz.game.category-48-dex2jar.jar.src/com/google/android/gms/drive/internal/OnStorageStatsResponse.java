package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.StorageStats;

public class OnStorageStatsResponse
  implements SafeParcelable
{
  public static final Parcelable.Creator<OnStorageStatsResponse> CREATOR = new as();
  final int BR;
  StorageStats Po;
  
  OnStorageStatsResponse(int paramInt, StorageStats paramStorageStats)
  {
    this.BR = paramInt;
    this.Po = paramStorageStats;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    as.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/drive/internal/OnStorageStatsResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */