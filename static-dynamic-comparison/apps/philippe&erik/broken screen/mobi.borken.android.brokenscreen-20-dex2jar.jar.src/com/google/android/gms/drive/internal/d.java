package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.ArrayList;

public class d
  implements Parcelable.Creator<CheckResourceIdsExistRequest>
{
  static void a(CheckResourceIdsExistRequest paramCheckResourceIdsExistRequest, Parcel paramParcel, int paramInt)
  {
    paramInt = b.C(paramParcel);
    b.c(paramParcel, 1, paramCheckResourceIdsExistRequest.getVersionCode());
    b.a(paramParcel, 2, paramCheckResourceIdsExistRequest.gj(), false);
    b.G(paramParcel, paramInt);
  }
  
  public CheckResourceIdsExistRequest T(Parcel paramParcel)
  {
    int j = a.B(paramParcel);
    int i = 0;
    ArrayList localArrayList = null;
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
        localArrayList = a.B(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new CheckResourceIdsExistRequest(i, localArrayList);
  }
  
  public CheckResourceIdsExistRequest[] aO(int paramInt)
  {
    return new CheckResourceIdsExistRequest[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/drive/internal/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */