package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.DriveId;

public class ax
  implements Parcelable.Creator<TrashResourceRequest>
{
  static void a(TrashResourceRequest paramTrashResourceRequest, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramTrashResourceRequest.xM);
    b.a(paramParcel, 2, paramTrashResourceRequest.Iu, paramInt, false);
    b.G(paramParcel, i);
  }
  
  public TrashResourceRequest ax(Parcel paramParcel)
  {
    int j = a.B(paramParcel);
    int i = 0;
    DriveId localDriveId = null;
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
        localDriveId = (DriveId)a.a(paramParcel, k, DriveId.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new TrashResourceRequest(i, localDriveId);
  }
  
  public TrashResourceRequest[] bt(int paramInt)
  {
    return new TrashResourceRequest[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/drive/internal/ax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */