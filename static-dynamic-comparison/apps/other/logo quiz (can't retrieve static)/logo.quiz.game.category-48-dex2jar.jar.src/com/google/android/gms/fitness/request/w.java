package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.fitness.data.Session;

public class w
  implements Parcelable.Creator<v>
{
  static void a(v paramv, Parcel paramParcel, int paramInt)
  {
    int i = b.D(paramParcel);
    b.a(paramParcel, 1, paramv.getSession(), paramInt, false);
    b.c(paramParcel, 1000, paramv.getVersionCode());
    b.H(paramParcel, i);
  }
  
  public v bN(Parcel paramParcel)
  {
    int j = a.C(paramParcel);
    int i = 0;
    Session localSession = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = a.B(paramParcel);
      switch (a.aD(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        localSession = (Session)a.a(paramParcel, k, Session.CREATOR);
        break;
      case 1000: 
        i = a.g(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new v(i, localSession);
  }
  
  public v[] df(int paramInt)
  {
    return new v[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/fitness/request/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */