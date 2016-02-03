package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class ad
  implements Parcelable.Creator<OnListEntriesResponse>
{
  static void a(OnListEntriesResponse paramOnListEntriesResponse, Parcel paramParcel, int paramInt)
  {
    int i = b.p(paramParcel);
    b.c(paramParcel, 1, paramOnListEntriesResponse.xH);
    b.a(paramParcel, 2, paramOnListEntriesResponse.FJ, paramInt, false);
    b.a(paramParcel, 3, paramOnListEntriesResponse.Fg);
    b.F(paramParcel, i);
  }
  
  public OnListEntriesResponse R(Parcel paramParcel)
  {
    boolean bool = false;
    int j = a.o(paramParcel);
    DataHolder localDataHolder = null;
    int i = 0;
    if (paramParcel.dataPosition() < j)
    {
      int k = a.n(paramParcel);
      switch (a.R(k))
      {
      default: 
        a.b(paramParcel, k);
      }
      for (;;)
      {
        break;
        i = a.g(paramParcel, k);
        continue;
        localDataHolder = (DataHolder)a.a(paramParcel, k, DataHolder.CREATOR);
        continue;
        bool = a.c(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new OnListEntriesResponse(i, localDataHolder, bool);
  }
  
  public OnListEntriesResponse[] av(int paramInt)
  {
    return new OnListEntriesResponse[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/drive/internal/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */