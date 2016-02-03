package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.location.LocationRequest;
import java.util.ArrayList;

public class o
  implements Parcelable.Creator<n>
{
  static void a(n paramn, Parcel paramParcel, int paramInt)
  {
    int i = b.D(paramParcel);
    b.a(paramParcel, 1, paramn.getDataSource(), paramInt, false);
    b.c(paramParcel, 1000, paramn.getVersionCode());
    b.a(paramParcel, 2, paramn.getDataType(), paramInt, false);
    b.a(paramParcel, 3, paramn.jq(), false);
    b.c(paramParcel, 4, paramn.Uq);
    b.c(paramParcel, 5, paramn.Ur);
    b.a(paramParcel, 6, paramn.getSamplingRateMicros());
    b.a(paramParcel, 7, paramn.jn());
    b.a(paramParcel, 8, paramn.jl(), paramInt, false);
    b.a(paramParcel, 9, paramn.jm());
    b.c(paramParcel, 10, paramn.iQ());
    b.c(paramParcel, 11, paramn.jo(), false);
    b.a(paramParcel, 12, paramn.jp());
    b.H(paramParcel, i);
  }
  
  public n bI(Parcel paramParcel)
  {
    int n = a.C(paramParcel);
    int m = 0;
    DataSource localDataSource = null;
    DataType localDataType = null;
    IBinder localIBinder = null;
    int k = 0;
    int j = 0;
    long l4 = 0L;
    long l3 = 0L;
    PendingIntent localPendingIntent = null;
    long l2 = 0L;
    int i = 0;
    ArrayList localArrayList = null;
    long l1 = 0L;
    while (paramParcel.dataPosition() < n)
    {
      int i1 = a.B(paramParcel);
      switch (a.aD(i1))
      {
      default: 
        a.b(paramParcel, i1);
        break;
      case 1: 
        localDataSource = (DataSource)a.a(paramParcel, i1, DataSource.CREATOR);
        break;
      case 1000: 
        m = a.g(paramParcel, i1);
        break;
      case 2: 
        localDataType = (DataType)a.a(paramParcel, i1, DataType.CREATOR);
        break;
      case 3: 
        localIBinder = a.p(paramParcel, i1);
        break;
      case 4: 
        k = a.g(paramParcel, i1);
        break;
      case 5: 
        j = a.g(paramParcel, i1);
        break;
      case 6: 
        l4 = a.i(paramParcel, i1);
        break;
      case 7: 
        l3 = a.i(paramParcel, i1);
        break;
      case 8: 
        localPendingIntent = (PendingIntent)a.a(paramParcel, i1, PendingIntent.CREATOR);
        break;
      case 9: 
        l2 = a.i(paramParcel, i1);
        break;
      case 10: 
        i = a.g(paramParcel, i1);
        break;
      case 11: 
        localArrayList = a.c(paramParcel, i1, LocationRequest.CREATOR);
        break;
      case 12: 
        l1 = a.i(paramParcel, i1);
      }
    }
    if (paramParcel.dataPosition() != n) {
      throw new a.a("Overread allowed size end=" + n, paramParcel);
    }
    return new n(m, localDataSource, localDataType, localIBinder, k, j, l4, l3, localPendingIntent, l2, i, localArrayList, l1);
  }
  
  public n[] cZ(int paramInt)
  {
    return new n[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/fitness/request/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */