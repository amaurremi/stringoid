package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class l
  implements Parcelable.Creator<DriveId>
{
  static void a(DriveId paramDriveId, Parcel paramParcel, int paramInt)
  {
    paramInt = b.k(paramParcel);
    b.c(paramParcel, 1, paramDriveId.qh);
    b.a(paramParcel, 2, paramDriveId.sQ, false);
    b.a(paramParcel, 3, paramDriveId.sR);
    b.a(paramParcel, 4, paramDriveId.sS);
    b.D(paramParcel, paramInt);
  }
  
  public DriveId[] bu(int paramInt)
  {
    return new DriveId[paramInt];
  }
  
  public DriveId m(Parcel paramParcel)
  {
    long l1 = 0L;
    int j = a.j(paramParcel);
    int i = 0;
    String str = null;
    long l2 = 0L;
    while (paramParcel.dataPosition() < j)
    {
      int k = a.i(paramParcel);
      switch (a.br(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        i = a.g(paramParcel, k);
        break;
      case 2: 
        str = a.m(paramParcel, k);
        break;
      case 3: 
        l2 = a.h(paramParcel, k);
        break;
      case 4: 
        l1 = a.h(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new DriveId(i, str, l2, l1);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/drive/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */