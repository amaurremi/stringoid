package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.query.internal.LogicalFilter;

public class d
  implements Parcelable.Creator<Query>
{
  static void a(Query paramQuery, Parcel paramParcel, int paramInt)
  {
    int i = b.k(paramParcel);
    b.c(paramParcel, 1000, paramQuery.qh);
    b.a(paramParcel, 1, paramQuery.ud, paramInt, false);
    b.a(paramParcel, 3, paramQuery.ue, false);
    b.D(paramParcel, i);
  }
  
  public Query O(Parcel paramParcel)
  {
    String str = null;
    int j = a.j(paramParcel);
    int i = 0;
    LogicalFilter localLogicalFilter = null;
    if (paramParcel.dataPosition() < j)
    {
      int k = a.i(paramParcel);
      switch (a.br(k))
      {
      default: 
        a.b(paramParcel, k);
      }
      for (;;)
      {
        break;
        i = a.g(paramParcel, k);
        continue;
        localLogicalFilter = (LogicalFilter)a.a(paramParcel, k, LogicalFilter.CREATOR);
        continue;
        str = a.m(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new Query(i, localLogicalFilter, str);
  }
  
  public Query[] bW(int paramInt)
  {
    return new Query[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/drive/query/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */