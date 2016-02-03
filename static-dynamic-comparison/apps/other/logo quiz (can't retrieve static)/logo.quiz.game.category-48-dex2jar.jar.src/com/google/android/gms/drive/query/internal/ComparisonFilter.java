package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class ComparisonFilter<T>
  extends AbstractFilter
{
  public static final a CREATOR = new a();
  final int BR;
  final Operator QC;
  final MetadataBundle QD;
  final MetadataField<T> QE;
  
  ComparisonFilter(int paramInt, Operator paramOperator, MetadataBundle paramMetadataBundle)
  {
    this.BR = paramInt;
    this.QC = paramOperator;
    this.QD = paramMetadataBundle;
    this.QE = e.b(paramMetadataBundle);
  }
  
  public ComparisonFilter(Operator paramOperator, SearchableMetadataField<T> paramSearchableMetadataField, T paramT)
  {
    this(1, paramOperator, MetadataBundle.a(paramSearchableMetadataField, paramT));
  }
  
  public <F> F a(f<F> paramf)
  {
    return (F)paramf.b(this.QC, this.QE, getValue());
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public T getValue()
  {
    return (T)this.QD.a(this.QE);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    a.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/drive/query/internal/ComparisonFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */