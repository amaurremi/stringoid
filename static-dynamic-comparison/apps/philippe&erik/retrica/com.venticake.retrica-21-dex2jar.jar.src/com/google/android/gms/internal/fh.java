package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class fh
  implements Parcelable.Creator<fg>
{
  static void a(fg paramfg, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.a(paramParcel, 1, paramfg.xN, paramInt, false);
    b.c(paramParcel, 1000, paramfg.xM);
    b.a(paramParcel, 2, paramfg.xO, false);
    b.a(paramParcel, 3, paramfg.xP);
    b.G(paramParcel, i);
  }
  
  public fg[] D(int paramInt)
  {
    return new fg[paramInt];
  }
  
  public fg l(Parcel paramParcel)
  {
    Object localObject2 = null;
    boolean bool = false;
    int j = a.B(paramParcel);
    Object localObject1 = null;
    int i = 0;
    if (paramParcel.dataPosition() < j)
    {
      int k = a.A(paramParcel);
      Object localObject3;
      switch (a.ar(k))
      {
      default: 
        a.b(paramParcel, k);
        localObject3 = localObject2;
        localObject2 = localObject1;
        localObject1 = localObject3;
      }
      for (;;)
      {
        localObject3 = localObject2;
        localObject2 = localObject1;
        localObject1 = localObject3;
        break;
        localObject3 = (fk[])a.b(paramParcel, k, fk.CREATOR);
        localObject1 = localObject2;
        localObject2 = localObject3;
        continue;
        i = a.g(paramParcel, k);
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
        continue;
        localObject3 = a.o(paramParcel, k);
        localObject2 = localObject1;
        localObject1 = localObject3;
        continue;
        bool = a.c(paramParcel, k);
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new fg(i, (fk[])localObject1, (String)localObject2, bool);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/fh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */