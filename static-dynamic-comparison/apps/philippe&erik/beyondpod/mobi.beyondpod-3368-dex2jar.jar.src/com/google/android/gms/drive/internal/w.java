package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.DriveId;

public class w
  implements Parcelable.Creator<OpenContentsRequest>
{
  static void a(OpenContentsRequest paramOpenContentsRequest, Parcel paramParcel, int paramInt)
  {
    int i = b.o(paramParcel);
    b.c(paramParcel, 1, paramOpenContentsRequest.kg);
    b.a(paramParcel, 2, paramOpenContentsRequest.rr, paramInt, false);
    b.c(paramParcel, 3, paramOpenContentsRequest.qF);
    b.D(paramParcel, i);
  }
  
  public OpenContentsRequest L(Parcel paramParcel)
  {
    int i = 0;
    int k = a.n(paramParcel);
    DriveId localDriveId = null;
    int j = 0;
    if (paramParcel.dataPosition() < k)
    {
      int m = a.m(paramParcel);
      switch (a.M(m))
      {
      default: 
        a.b(paramParcel, m);
      }
      for (;;)
      {
        break;
        j = a.g(paramParcel, m);
        continue;
        localDriveId = (DriveId)a.a(paramParcel, m, DriveId.CREATOR);
        continue;
        i = a.g(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new a.a("Overread allowed size end=" + k, paramParcel);
    }
    return new OpenContentsRequest(j, localDriveId, i);
  }
  
  public OpenContentsRequest[] al(int paramInt)
  {
    return new OpenContentsRequest[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/drive/internal/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */