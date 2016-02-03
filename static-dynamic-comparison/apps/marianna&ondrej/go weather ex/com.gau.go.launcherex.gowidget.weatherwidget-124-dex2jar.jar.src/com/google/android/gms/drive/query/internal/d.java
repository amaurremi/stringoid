package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class d
  implements Parcelable.Creator<FilterHolder>
{
  static void a(FilterHolder paramFilterHolder, Parcel paramParcel, int paramInt)
  {
    int i = b.p(paramParcel);
    b.a(paramParcel, 1, paramFilterHolder.GK, paramInt, false);
    b.c(paramParcel, 1000, paramFilterHolder.xH);
    b.a(paramParcel, 2, paramFilterHolder.GL, paramInt, false);
    b.a(paramParcel, 3, paramFilterHolder.GM, paramInt, false);
    b.a(paramParcel, 4, paramFilterHolder.GN, paramInt, false);
    b.a(paramParcel, 5, paramFilterHolder.GO, paramInt, false);
    b.a(paramParcel, 6, paramFilterHolder.GP, paramInt, false);
    b.F(paramParcel, i);
  }
  
  public FilterHolder[] aL(int paramInt)
  {
    return new FilterHolder[paramInt];
  }
  
  public FilterHolder ah(Parcel paramParcel)
  {
    MatchAllFilter localMatchAllFilter = null;
    int j = a.o(paramParcel);
    int i = 0;
    InFilter localInFilter = null;
    NotFilter localNotFilter = null;
    LogicalFilter localLogicalFilter = null;
    FieldOnlyFilter localFieldOnlyFilter = null;
    ComparisonFilter localComparisonFilter = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = a.n(paramParcel);
      switch (a.R(k))
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
        break;
      case 6: 
        localMatchAllFilter = (MatchAllFilter)a.a(paramParcel, k, MatchAllFilter.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new FilterHolder(i, localComparisonFilter, localFieldOnlyFilter, localLogicalFilter, localNotFilter, localInFilter, localMatchAllFilter);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/drive/query/internal/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */