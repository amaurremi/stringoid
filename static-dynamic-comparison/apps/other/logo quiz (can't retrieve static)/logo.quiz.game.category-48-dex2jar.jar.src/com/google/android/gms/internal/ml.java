package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class ml
  implements Parcelable.Creator<mk>
{
  static void a(mk parammk, Parcel paramParcel, int paramInt)
  {
    paramInt = b.D(paramParcel);
    b.c(paramParcel, 1, parammk.BR);
    b.a(paramParcel, 2, parammk.mi(), false);
    b.a(paramParcel, 3, parammk.getTag(), false);
    b.H(paramParcel, paramInt);
  }
  
  public mk cA(Parcel paramParcel)
  {
    String str2 = null;
    int j = a.C(paramParcel);
    int i = 0;
    String str1 = null;
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
        str1 = a.o(paramParcel, k);
        break;
      case 3: 
        str2 = a.o(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new mk(i, str1, str2);
  }
  
  public mk[] ep(int paramInt)
  {
    return new mk[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/internal/ml.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */