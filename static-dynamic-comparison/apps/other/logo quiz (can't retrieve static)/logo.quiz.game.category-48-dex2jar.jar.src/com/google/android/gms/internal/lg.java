package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.fitness.data.DataType;
import java.util.ArrayList;

public class lg
  implements Parcelable.Creator<lf>
{
  static void a(lf paramlf, Parcel paramParcel, int paramInt)
  {
    paramInt = b.D(paramParcel);
    b.c(paramParcel, 1, paramlf.getDataTypes(), false);
    b.c(paramParcel, 1000, paramlf.getVersionCode());
    b.H(paramParcel, paramInt);
  }
  
  public lf by(Parcel paramParcel)
  {
    int j = a.C(paramParcel);
    int i = 0;
    ArrayList localArrayList = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = a.B(paramParcel);
      switch (a.aD(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        localArrayList = a.c(paramParcel, k, DataType.CREATOR);
        break;
      case 1000: 
        i = a.g(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new lf(i, localArrayList);
  }
  
  public lf[] cP(int paramInt)
  {
    return new lf[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/internal/lg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */