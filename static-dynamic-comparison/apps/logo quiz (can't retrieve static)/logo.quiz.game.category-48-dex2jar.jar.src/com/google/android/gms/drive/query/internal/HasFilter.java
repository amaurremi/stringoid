package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class HasFilter<T>
  extends AbstractFilter
{
  public static final g CREATOR = new g();
  final int BR;
  final MetadataBundle QD;
  final MetadataField<T> QE;
  
  HasFilter(int paramInt, MetadataBundle paramMetadataBundle)
  {
    this.BR = paramInt;
    this.QD = paramMetadataBundle;
    this.QE = e.b(paramMetadataBundle);
  }
  
  public <F> F a(f<F> paramf)
  {
    return (F)paramf.d(this.QE, getValue());
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
    g.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/drive/query/internal/HasFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */