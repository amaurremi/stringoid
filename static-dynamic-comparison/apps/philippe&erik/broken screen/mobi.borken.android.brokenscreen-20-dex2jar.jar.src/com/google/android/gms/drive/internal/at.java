package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.query.Query;

public class at
  implements Parcelable.Creator<QueryRequest>
{
  static void a(QueryRequest paramQueryRequest, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramQueryRequest.xJ);
    b.a(paramParcel, 2, paramQueryRequest.JB, paramInt, false);
    b.G(paramParcel, i);
  }
  
  public QueryRequest au(Parcel paramParcel)
  {
    int j = a.B(paramParcel);
    int i = 0;
    Query localQuery = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = a.A(paramParcel);
      switch (a.ar(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        i = a.g(paramParcel, k);
        break;
      case 2: 
        localQuery = (Query)a.a(paramParcel, k, Query.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new QueryRequest(i, localQuery);
  }
  
  public QueryRequest[] bq(int paramInt)
  {
    return new QueryRequest[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/drive/internal/at.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */