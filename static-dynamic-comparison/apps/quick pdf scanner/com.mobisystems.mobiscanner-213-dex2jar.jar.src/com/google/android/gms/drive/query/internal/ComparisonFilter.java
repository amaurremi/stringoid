package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.b;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class ComparisonFilter<T>
  implements SafeParcelable, com.google.android.gms.drive.query.a
{
  public static final a up = new a();
  final int qh;
  final Operator uq;
  final MetadataBundle ur;
  final b<T> us;
  
  ComparisonFilter(int paramInt, Operator paramOperator, MetadataBundle paramMetadataBundle)
  {
    this.qh = paramInt;
    this.uq = paramOperator;
    this.ur = paramMetadataBundle;
    this.us = d.b(paramMetadataBundle);
  }
  
  public ComparisonFilter(Operator paramOperator, b<T> paramb, T paramT)
  {
    this(1, paramOperator, MetadataBundle.a(paramb, paramT));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    a.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/drive/query/internal/ComparisonFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */