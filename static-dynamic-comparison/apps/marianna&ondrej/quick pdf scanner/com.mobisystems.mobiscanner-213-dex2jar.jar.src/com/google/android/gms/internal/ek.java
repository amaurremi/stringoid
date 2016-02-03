package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.games.request.GameRequestEntity;
import java.util.ArrayList;

public class ek
  implements Parcelable.Creator<gz>
{
  static void a(gz paramgz, Parcel paramParcel, int paramInt)
  {
    paramInt = b.k(paramParcel);
    b.b(paramParcel, 1, paramgz.rd(), false);
    b.c(paramParcel, 1000, paramgz.lX());
    b.D(paramParcel, paramInt);
  }
  
  public gz aB(Parcel paramParcel)
  {
    int j = a.j(paramParcel);
    int i = 0;
    ArrayList localArrayList = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = a.i(paramParcel);
      switch (a.br(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        localArrayList = a.c(paramParcel, k, GameRequestEntity.wD);
        break;
      case 1000: 
        i = a.g(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new gz(i, localArrayList);
  }
  
  public gz[] cS(int paramInt)
  {
    return new gz[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/ek.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */