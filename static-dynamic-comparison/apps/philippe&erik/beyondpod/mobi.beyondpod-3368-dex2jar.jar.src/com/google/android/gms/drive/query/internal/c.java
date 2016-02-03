package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class c
  implements Parcelable.Creator<FilterHolder>
{
  static void a(FilterHolder paramFilterHolder, Parcel paramParcel, int paramInt)
  {
    int i = b.o(paramParcel);
    b.a(paramParcel, 1, paramFilterHolder.rU, paramInt, false);
    b.c(paramParcel, 1000, paramFilterHolder.kg);
    b.a(paramParcel, 2, paramFilterHolder.rV, paramInt, false);
    b.a(paramParcel, 3, paramFilterHolder.rW, paramInt, false);
    b.a(paramParcel, 4, paramFilterHolder.rX, paramInt, false);
    b.a(paramParcel, 5, paramFilterHolder.rY, paramInt, false);
    b.D(paramParcel, i);
  }
  
  public FilterHolder T(Parcel paramParcel)
  {
    InFilter localInFilter = null;
    int j = a.n(paramParcel);
    int i = 0;
    NotFilter localNotFilter = null;
    LogicalFilter localLogicalFilter = null;
    FieldOnlyFilter localFieldOnlyFilter = null;
    ComparisonFilter localComparisonFilter = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = a.m(paramParcel);
      switch (a.M(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        localComparisonFilter = (ComparisonFilter)a.a(paramParcel, k, ComparisonFilter.CREATOR);
        break;
      case 1000: 
        i = a.g(paramParcel, k);
        break;
      case 2: 
        localFieldOnlyFilter = (FieldOnlyFilter)a.a(paramParcel, k, FieldOnlyFilter.CREATOR);
        break;
      case 3: 
        localLogicalFilter = (LogicalFilter)a.a(paramParcel, k, LogicalFilter.CREATOR);
        break;
      case 4: 
        localNotFilter = (NotFilter)a.a(paramParcel, k, NotFilter.CREATOR);
        break;
      case 5: 
        localInFilter = (InFilter)a.a(paramParcel, k, InFilter.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new FilterHolder(i, localComparisonFilter, localFieldOnlyFilter, localLogicalFilter, localNotFilter, localInFilter);
  }
  
  public FilterHolder[] at(int paramInt)
  {
    return new FilterHolder[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/drive/query/internal/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */