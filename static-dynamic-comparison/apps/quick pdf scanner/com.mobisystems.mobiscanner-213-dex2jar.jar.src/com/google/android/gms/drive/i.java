package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class i
  implements Parcelable.Creator<Contents>
{
  static void a(Contents paramContents, Parcel paramParcel, int paramInt)
  {
    int i = b.k(paramParcel);
    b.c(paramParcel, 1, paramContents.qh);
    b.a(paramParcel, 2, paramContents.sq, paramInt, false);
    b.c(paramParcel, 3, paramContents.sF);
    b.c(paramParcel, 4, paramContents.CR);
    b.a(paramParcel, 5, paramContents.sG, paramInt, false);
    b.D(paramParcel, i);
  }
  
  public Contents[] bt(int paramInt)
  {
    return new Contents[paramInt];
  }
  
  public Contents l(Parcel paramParcel)
  {
    DriveId localDriveId = null;
    int i = 0;
    int m = a.j(paramParcel);
    int j = 0;
    ParcelFileDescriptor localParcelFileDescriptor = null;
    int k = 0;
    while (paramParcel.dataPosition() < m)
    {
      int n = a.i(paramParcel);
      switch (a.br(n))
      {
      default: 
        a.b(paramParcel, n);
        break;
      case 1: 
        k = a.g(paramParcel, n);
        break;
      case 2: 
        localParcelFileDescriptor = (ParcelFileDescriptor)a.a(paramParcel, n, ParcelFileDescriptor.CREATOR);
        break;
      case 3: 
        j = a.g(paramParcel, n);
        break;
      case 4: 
        i = a.g(paramParcel, n);
        break;
      case 5: 
        localDriveId = (DriveId)a.a(paramParcel, n, DriveId.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new a.a("Overread allowed size end=" + m, paramParcel);
    }
    return new Contents(k, localParcelFileDescriptor, j, i, localDriveId);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/drive/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */