package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class al
  implements Parcelable.Creator<OnListParentsResponse>
{
  static void a(OnListParentsResponse paramOnListParentsResponse, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramOnListParentsResponse.xM);
    b.a(paramParcel, 2, paramOnListParentsResponse.JB, paramInt, false);
    b.G(paramParcel, i);
  }
  
  public OnListParentsResponse am(Parcel paramParcel)
  {
    int j = a.B(paramParcel);
    int i = 0;
    DataHolder localDataHolder = null;
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
        localDataHolder = (DataHolder)a.a(paramParcel, k, DataHolder.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new OnListParentsResponse(i, localDataHolder);
  }
  
  public OnListParentsResponse[] bi(int paramInt)
  {
    return new OnListParentsResponse[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/drive/internal/al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */