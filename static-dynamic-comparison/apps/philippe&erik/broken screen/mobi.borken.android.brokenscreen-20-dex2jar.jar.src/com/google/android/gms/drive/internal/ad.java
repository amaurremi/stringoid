package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.DriveId;

public class ad
  implements Parcelable.Creator<ListParentsRequest>
{
  static void a(ListParentsRequest paramListParentsRequest, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramListParentsRequest.xJ);
    b.a(paramParcel, 2, paramListParentsRequest.Jo, paramInt, false);
    b.G(paramParcel, i);
  }
  
  public ListParentsRequest af(Parcel paramParcel)
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
    return new ListParentsRequest(i, localDriveId);
  }
  
  public ListParentsRequest[] bb(int paramInt)
  {
    return new ListParentsRequest[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/drive/internal/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */