package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class a
  implements Parcelable.Creator<ComparisonFilter>
{
  static void a(ComparisonFilter paramComparisonFilter, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1000, paramComparisonFilter.xJ);
    b.a(paramParcel, 1, paramComparisonFilter.KI, paramInt, false);
    b.a(paramParcel, 2, paramComparisonFilter.KJ, paramInt, false);
    b.G(paramParcel, i);
  }
  
  public ComparisonFilter aF(Parcel paramParcel)
  {
    MetadataBundle localMetadataBundle = null;
    int j = com.google.android.gms.common.internal.safeparcel.a.B(paramParcel);
    int i = 0;
    Operator localOperator = null;
    if (paramParcel.dataPosition() < j)
    {
      int k = com.google.android.gms.common.internal.safeparcel.a.A(paramParcel);
      switch (com.google.android.gms.common.internal.safeparcel.a.ar(k))
      {
      default: 
        com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, k);
      }
      for (;;)
      {
        break;
        i = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, k);
        continue;
        localOperator = (Operator)com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, k, Operator.CREATOR);
        continue;
        localMetadataBundle = (MetadataBundle)com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, k, MetadataBundle.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new ComparisonFilter(i, localOperator, localMetadataBundle);
  }
  
  public ComparisonFilter[] bB(int paramInt)
  {
    return new ComparisonFilter[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/drive/query/internal/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */