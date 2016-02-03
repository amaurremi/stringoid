package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.DriveId;

public class t
  implements Parcelable.Creator<OnDriveIdResponse>
{
  static void a(OnDriveIdResponse paramOnDriveIdResponse, Parcel paramParcel, int paramInt)
  {
    int i = b.o(paramParcel);
    b.c(paramParcel, 1, paramOnDriveIdResponse.kg);
    b.a(paramParcel, 2, paramOnDriveIdResponse.rr, paramInt, false);
    b.D(paramParcel, i);
  }
  
  public OnDriveIdResponse I(Parcel paramParcel)
  {
    int j = a.n(paramParcel);
    int i = 0;
    DriveId localDriveId = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = a.m(paramParcel);
      switch (a.M(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        i = a.g(paramParcel, k);
        break;
      case 2: 
        localDriveId = (DriveId)a.a(paramParcel, k, DriveId.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new OnDriveIdResponse(i, localDriveId);
  }
  
  public OnDriveIdResponse[] ai(int paramInt)
  {
    return new OnDriveIdResponse[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/drive/internal/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */