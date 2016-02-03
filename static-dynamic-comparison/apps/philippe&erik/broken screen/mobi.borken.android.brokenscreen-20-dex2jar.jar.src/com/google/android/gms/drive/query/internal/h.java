package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.ArrayList;

public class h
  implements Parcelable.Creator<LogicalFilter>
{
  static void a(LogicalFilter paramLogicalFilter, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1000, paramLogicalFilter.xJ);
    b.a(paramParcel, 1, paramLogicalFilter.KI, paramInt, false);
    b.b(paramParcel, 2, paramLogicalFilter.KV, false);
    b.G(paramParcel, i);
  }
  
  public LogicalFilter aL(Parcel paramParcel)
  {
    ArrayList localArrayList = null;
    int j = a.B(paramParcel);
    int i = 0;
    Operator localOperator = null;
    if (paramParcel.dataPosition() < j)
    {
      int k = a.A(paramParcel);
      switch (a.ar(k))
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
  
  public LogicalFilter[] bH(int paramInt)
  {
    return new LogicalFilter[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/drive/query/internal/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */