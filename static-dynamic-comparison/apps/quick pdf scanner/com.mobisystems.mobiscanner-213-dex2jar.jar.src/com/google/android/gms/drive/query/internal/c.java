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
    int i = b.k(paramParcel);
    b.a(paramParcel, 1, paramFilterHolder.ut, paramInt, false);
    b.c(paramParcel, 1000, paramFilterHolder.qh);
    b.a(paramParcel, 2, paramFilterHolder.uu, paramInt, false);
    b.a(paramParcel, 3, paramFilterHolder.uv, paramInt, false);
    b.a(paramParcel, 4, paramFilterHolder.uw, paramInt, false);
    b.a(paramParcel, 5, paramFilterHolder.ux, paramInt, false);
    b.D(paramParcel, i);
  }
  
  public FilterHolder R(Parcel paramParcel)
  {
    InFilter localInFilter = null;
    int j = a.j(paramParcel);
    int i = 0;
    NotFilter localNotFilter = null;
    LogicalFilter localLogicalFilter = null;
    FieldOnlyFilter localFieldOnlyFilter = null;
    ComparisonFilter localComparisonFilter = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = a.i(paramParcel);
      switch (a.br(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        localComparisonFilter = (ComparisonFilter)a.a(paramParcel, k, ComparisonFilter.up);
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
        localInFilter = (InFilter)a.a(paramParcel, k, InFilter.uz);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new FilterHolder(i, localComparisonFilter, localFieldOnlyFilter, localLogicalFilter, localNotFilter, localInFilter);
  }
  
  public FilterHolder[] bZ(int paramInt)
  {
    return new FilterHolder[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/drive/query/internal/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */