package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.DriveId;

public class h
  implements Parcelable.Creator<OpenContentsRequest>
{
  static void a(OpenContentsRequest paramOpenContentsRequest, Parcel paramParcel, int paramInt)
  {
    int i = b.k(paramParcel);
    b.c(paramParcel, 1, paramOpenContentsRequest.qh);
    b.a(paramParcel, 2, paramOpenContentsRequest.tc, paramInt, false);
    b.c(paramParcel, 3, paramOpenContentsRequest.CR);
    b.D(paramParcel, i);
  }
  
  public OpenContentsRequest[] bE(int paramInt)
  {
    return new OpenContentsRequest[paramInt];
  }
  
  public OpenContentsRequest w(Parcel paramParcel)
  {
    int i = 0;
    int k = a.j(paramParcel);
    DriveId localDriveId = null;
    int j = 0;
    if (paramParcel.dataPosition() < k)
    {
      int m = a.i(paramParcel);
      switch (a.br(m))
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
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/drive/internal/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */