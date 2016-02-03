package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.fitness.data.DataSource;

public class li
  implements Parcelable.Creator<lh>
{
  static void a(lh paramlh, Parcel paramParcel, int paramInt)
  {
    int i = b.D(paramParcel);
    b.a(paramParcel, 1, paramlh.getDataSource(), paramInt, false);
    b.c(paramParcel, 1000, paramlh.getVersionCode());
    b.H(paramParcel, i);
  }
  
  public lh bz(Parcel paramParcel)
  {
    int j = a.C(paramParcel);
    int i = 0;
    DataSource localDataSource = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = a.B(paramParcel);
      switch (a.aD(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        localDataSource = (DataSource)a.a(paramParcel, k, DataSource.CREATOR);
        break;
      case 1000: 
        i = a.g(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new lh(i, localDataSource);
  }
  
  public lh[] cQ(int paramInt)
  {
    return new lh[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/internal/li.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */