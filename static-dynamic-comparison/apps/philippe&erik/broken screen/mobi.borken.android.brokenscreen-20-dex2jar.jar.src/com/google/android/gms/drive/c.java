package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class c
  implements Parcelable.Creator<DriveId>
{
  static void a(DriveId paramDriveId, Parcel paramParcel, int paramInt)
  {
    paramInt = b.C(paramParcel);
    b.c(paramParcel, 1, paramDriveId.xJ);
    b.a(paramParcel, 2, paramDriveId.HK, false);
    b.a(paramParcel, 3, paramDriveId.HL);
    b.a(paramParcel, 4, paramDriveId.HM);
    b.G(paramParcel, paramInt);
  }
  
  public DriveId N(Parcel paramParcel)
  {
    long l1 = 0L;
    int j = a.B(paramParcel);
    int i = 0;
    String str = null;
    long l2 = 0L;
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
        l2 = a.i(paramParcel, k);
        break;
      case 4: 
        l1 = a.i(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new DriveId(i, str, l2, l1);
  }
  
  public DriveId[] aH(int paramInt)
  {
    return new DriveId[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/drive/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */