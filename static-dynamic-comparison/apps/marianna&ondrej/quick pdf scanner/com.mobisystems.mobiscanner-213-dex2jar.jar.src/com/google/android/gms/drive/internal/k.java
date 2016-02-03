package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.DriveId;

public class k
  implements Parcelable.Creator<RemoveEventListenerRequest>
{
  static void a(RemoveEventListenerRequest paramRemoveEventListenerRequest, Parcel paramParcel, int paramInt)
  {
    int i = b.k(paramParcel);
    b.c(paramParcel, 1, paramRemoveEventListenerRequest.qh);
    b.a(paramParcel, 2, paramRemoveEventListenerRequest.sG, paramInt, false);
    b.c(paramParcel, 3, paramRemoveEventListenerRequest.ta);
    b.D(paramParcel, i);
  }
  
  public RemoveEventListenerRequest[] bH(int paramInt)
  {
    return new RemoveEventListenerRequest[paramInt];
  }
  
  public RemoveEventListenerRequest z(Parcel paramParcel)
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
    return new RemoveEventListenerRequest(j, localDriveId, i);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/drive/internal/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */