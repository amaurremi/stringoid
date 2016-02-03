package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.ArrayList;

public class f
  implements Parcelable.Creator<LogicalFilter>
{
  static void a(LogicalFilter paramLogicalFilter, Parcel paramParcel, int paramInt)
  {
    int i = b.o(paramParcel);
    b.c(paramParcel, 1000, paramLogicalFilter.kg);
    b.a(paramParcel, 1, paramLogicalFilter.rR, paramInt, false);
    b.b(paramParcel, 2, paramLogicalFilter.sb, false);
    b.D(paramParcel, i);
  }
  
  public LogicalFilter V(Parcel paramParcel)
  {
    ArrayList localArrayList = null;
    int j = a.n(paramParcel);
    int i = 0;
    Operator localOperator = null;
    if (paramParcel.dataPosition() < j)
    {
      int k = a.m(paramParcel);
      switch (a.M(k))
      {
      default: 
        a.b(paramParcel, k);
      }
      for (;;)
      {
        break;
        i = a.g(paramParcel, k);
        continue;
        localOperator = (Operator)a.a(paramParcel, k, Operator.CREATOR);
        continue;
        localArrayList = a.c(paramParcel, k, FilterHolder.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new LogicalFilter(i, localOperator, localArrayList);
  }
  
  public LogicalFilter[] av(int paramInt)
  {
    return new LogicalFilter[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/drive/query/internal/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */