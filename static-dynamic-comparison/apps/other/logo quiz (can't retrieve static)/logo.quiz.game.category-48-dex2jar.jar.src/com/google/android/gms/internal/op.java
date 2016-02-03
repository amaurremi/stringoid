package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class op
  implements Parcelable.Creator<oo>
{
  static void a(oo paramoo, Parcel paramParcel, int paramInt)
  {
    paramInt = b.D(paramParcel);
    b.c(paramParcel, 1, paramoo.getVersionCode());
    b.a(paramParcel, 2, paramoo.atD, false);
    b.a(paramParcel, 3, paramoo.atE, false);
    b.H(paramParcel, paramInt);
  }
  
  public oo dC(Parcel paramParcel)
  {
    String[] arrayOfString = null;
    int j = a.C(paramParcel);
    int i = 0;
    byte[][] arrayOfByte = (byte[][])null;
    while (paramParcel.dataPosition() < j)
    {
      int k = a.B(paramParcel);
      switch (a.aD(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        i = a.g(paramParcel, k);
        break;
      case 2: 
        arrayOfString = a.A(paramParcel, k);
        break;
      case 3: 
        arrayOfByte = a.s(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new oo(i, arrayOfString, arrayOfByte);
  }
  
  public oo[] fC(int paramInt)
  {
    return new oo[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/internal/op.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */