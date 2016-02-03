package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.fitness.data.DataSet;

public class e
  implements Parcelable.Creator<DataInsertRequest>
{
  static void a(DataInsertRequest paramDataInsertRequest, Parcel paramParcel, int paramInt)
  {
    int i = b.D(paramParcel);
    b.a(paramParcel, 1, paramDataInsertRequest.iP(), paramInt, false);
    b.c(paramParcel, 1000, paramDataInsertRequest.getVersionCode());
    b.H(paramParcel, i);
  }
  
  public DataInsertRequest bC(Parcel paramParcel)
  {
    int j = a.C(paramParcel);
    int i = 0;
    DataSet localDataSet = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = a.B(paramParcel);
      switch (a.aD(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        localDataSet = (DataSet)a.a(paramParcel, k, DataSet.CREATOR);
        break;
      case 1000: 
        i = a.g(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new DataInsertRequest(i, localDataSet);
  }
  
  public DataInsertRequest[] cT(int paramInt)
  {
    return new DataInsertRequest[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/fitness/request/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */