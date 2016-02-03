package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class aa
  implements Parcelable.Creator<z>
{
  static void a(z paramz, Parcel paramParcel, int paramInt)
  {
    int i = b.D(paramParcel);
    b.a(paramParcel, 1, paramz.jl(), paramInt, false);
    b.c(paramParcel, 1000, paramz.getVersionCode());
    b.H(paramParcel, i);
  }
  
  public z bP(Parcel paramParcel)
  {
    int j = a.C(paramParcel);
    int i = 0;
    PendingIntent localPendingIntent = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = a.B(paramParcel);
      switch (a.aD(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        localPendingIntent = (PendingIntent)a.a(paramParcel, k, PendingIntent.CREATOR);
        break;
      case 1000: 
        i = a.g(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new z(i, localPendingIntent);
  }
  
  public z[] dh(int paramInt)
  {
    return new z[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/fitness/request/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */