package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.CustomPropertyKey;

public class m
  implements Parcelable.Creator<DeleteCustomPropertyRequest>
{
  static void a(DeleteCustomPropertyRequest paramDeleteCustomPropertyRequest, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramDeleteCustomPropertyRequest.xJ);
    b.a(paramParcel, 2, paramDeleteCustomPropertyRequest.Hw, paramInt, false);
    b.a(paramParcel, 3, paramDeleteCustomPropertyRequest.IG, paramInt, false);
    b.G(paramParcel, i);
  }
  
  public DeleteCustomPropertyRequest[] aW(int paramInt)
  {
    return new DeleteCustomPropertyRequest[paramInt];
  }
  
  public DeleteCustomPropertyRequest aa(Parcel paramParcel)
  {
    CustomPropertyKey localCustomPropertyKey = null;
    int j = a.B(paramParcel);
    int i = 0;
    DriveId localDriveId = null;
    if (paramParcel.dataPosition() < j)
    {
      int k = a.A(paramParcel);
      switch (a.ar(k))
      {
      default: 
        a.b(paramParcel, k);
      }
      for (;;)
      {
        break;
        i = a.g(paramParcel, k);
        continue;
        localDriveId = (DriveId)a.a(paramParcel, k, DriveId.CREATOR);
        continue;
        localCustomPropertyKey = (CustomPropertyKey)a.a(paramParcel, k, CustomPropertyKey.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new DeleteCustomPropertyRequest(i, localDriveId, localCustomPropertyKey);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/drive/internal/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */