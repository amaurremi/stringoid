package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;

public class ai
  implements Parcelable.Creator<ah>
{
  static void a(ah paramah, Parcel paramParcel, int paramInt)
  {
    int i = b.D(paramParcel);
    b.a(paramParcel, 1, paramah.getDataType(), paramInt, false);
    b.c(paramParcel, 1000, paramah.getVersionCode());
    b.a(paramParcel, 2, paramah.getDataSource(), paramInt, false);
    b.H(paramParcel, i);
  }
  
  public ah bU(Parcel paramParcel)
  {
    DataSource localDataSource = null;
    int j = a.C(paramParcel);
    int i = 0;
    DataType localDataType = null;
    if (paramParcel.dataPosition() < j)
    {
      int k = a.B(paramParcel);
      switch (a.aD(k))
      {
      default: 
        a.b(paramParcel, k);
      }
      for (;;)
      {
        break;
        localDataType = (DataType)a.a(paramParcel, k, DataType.CREATOR);
        continue;
        i = a.g(paramParcel, k);
        continue;
        localDataSource = (DataSource)a.a(paramParcel, k, DataSource.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new ah(i, localDataType, localDataSource);
  }
  
  public ah[] dm(int paramInt)
  {
    return new ah[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/fitness/request/ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */