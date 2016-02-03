package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.query.internal.LogicalFilter;

public class a
  implements Parcelable.Creator<Query>
{
  static void a(Query paramQuery, Parcel paramParcel, int paramInt)
  {
    int i = b.o(paramParcel);
    b.c(paramParcel, 1000, paramQuery.kg);
    b.a(paramParcel, 1, paramQuery.rO, paramInt, false);
    b.a(paramParcel, 3, paramQuery.rP, false);
    b.D(paramParcel, i);
  }
  
  public Query Q(Parcel paramParcel)
  {
    String str = null;
    int j = com.google.android.gms.common.internal.safeparcel.a.n(paramParcel);
    int i = 0;
    LogicalFilter localLogicalFilter = null;
    if (paramParcel.dataPosition() < j)
    {
      int k = com.google.android.gms.common.internal.safeparcel.a.m(paramParcel);
      switch (com.google.android.gms.common.internal.safeparcel.a.M(k))
      {
      default: 
        com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, k);
      }
      for (;;)
      {
        break;
        i = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, k);
        continue;
        localLogicalFilter = (LogicalFilter)com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, k, LogicalFilter.CREATOR);
        continue;
        str = com.google.android.gms.common.internal.safeparcel.a.m(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new Query(i, localLogicalFilter, str);
  }
  
  public Query[] aq(int paramInt)
  {
    return new Query[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/drive/query/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */