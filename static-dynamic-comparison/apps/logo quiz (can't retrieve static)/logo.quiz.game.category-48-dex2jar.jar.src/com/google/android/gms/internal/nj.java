package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class nj
  implements Parcelable.Creator<nh>
{
  static void a(nh paramnh, Parcel paramParcel, int paramInt)
  {
    paramInt = b.D(paramParcel);
    b.c(paramParcel, 1, paramnh.versionCode);
    b.a(paramParcel, 2, paramnh.akw);
    b.a(paramParcel, 3, paramnh.tag, false);
    b.a(paramParcel, 4, paramnh.akx, false);
    b.a(paramParcel, 5, paramnh.aky, false);
    b.H(paramParcel, paramInt);
  }
  
  public nh cX(Parcel paramParcel)
  {
    Bundle localBundle = null;
    int j = a.C(paramParcel);
    int i = 0;
    long l = 0L;
    byte[] arrayOfByte = null;
    String str = null;
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
        l = a.i(paramParcel, k);
        break;
      case 3: 
        str = a.o(paramParcel, k);
        break;
      case 4: 
        arrayOfByte = a.r(paramParcel, k);
        break;
      case 5: 
        localBundle = a.q(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new nh(i, l, str, arrayOfByte, localBundle);
  }
  
  public nh[] eN(int paramInt)
  {
    return new nh[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/internal/nj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */