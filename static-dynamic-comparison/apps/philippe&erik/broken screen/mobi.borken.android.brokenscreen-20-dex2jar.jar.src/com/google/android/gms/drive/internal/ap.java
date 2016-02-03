package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.StorageStats;

public class ap
  implements Parcelable.Creator<OnStorageStatsResponse>
{
  static void a(OnStorageStatsResponse paramOnStorageStatsResponse, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramOnStorageStatsResponse.xJ);
    b.a(paramParcel, 2, paramOnStorageStatsResponse.JA, paramInt, false);
    b.G(paramParcel, i);
  }
  
  public OnStorageStatsResponse aq(Parcel paramParcel)
  {
    int j = a.B(paramParcel);
    int i = 0;
    StorageStats localStorageStats = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = a.A(paramParcel);
      switch (a.ar(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        i = a.g(paramParcel, k);
        break;
      case 2: 
        localStorageStats = (StorageStats)a.a(paramParcel, k, StorageStats.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new OnStorageStatsResponse(i, localStorageStats);
  }
  
  public OnStorageStatsResponse[] bm(int paramInt)
  {
    return new OnStorageStatsResponse[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/drive/internal/ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */