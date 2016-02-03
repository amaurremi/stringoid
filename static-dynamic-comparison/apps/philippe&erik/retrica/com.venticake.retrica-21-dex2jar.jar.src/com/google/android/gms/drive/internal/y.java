package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class y
  implements Parcelable.Creator<GetDriveIdFromUniqueIdentifierRequest>
{
  static void a(GetDriveIdFromUniqueIdentifierRequest paramGetDriveIdFromUniqueIdentifierRequest, Parcel paramParcel, int paramInt)
  {
    paramInt = b.C(paramParcel);
    b.c(paramParcel, 1, paramGetDriveIdFromUniqueIdentifierRequest.xM);
    b.a(paramParcel, 2, paramGetDriveIdFromUniqueIdentifierRequest.Jp, false);
    b.a(paramParcel, 3, paramGetDriveIdFromUniqueIdentifierRequest.Jq);
    b.G(paramParcel, paramInt);
  }
  
  public GetDriveIdFromUniqueIdentifierRequest[] aZ(int paramInt)
  {
    return new GetDriveIdFromUniqueIdentifierRequest[paramInt];
  }
  
  public GetDriveIdFromUniqueIdentifierRequest ad(Parcel paramParcel)
  {
    boolean bool = false;
    int j = a.B(paramParcel);
    String str = null;
    int i = 0;
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
        str = a.o(paramParcel, k);
        break;
      case 3: 
        bool = a.c(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new GetDriveIdFromUniqueIdentifierRequest(i, str, bool);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/drive/internal/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */