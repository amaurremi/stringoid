package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.query.Filter;

public class FieldOnlyFilter
  implements SafeParcelable, Filter
{
  public static final Parcelable.Creator<FieldOnlyFilter> CREATOR = new b();
  final int kg;
  final MetadataBundle rS;
  private final MetadataField<?> rT;
  
  FieldOnlyFilter(int paramInt, MetadataBundle paramMetadataBundle)
  {
    this.kg = paramInt;
    this.rS = paramMetadataBundle;
    this.rT = d.b(paramMetadataBundle);
  }
  
  public FieldOnlyFilter(MetadataField<?> paramMetadataField)
  {
    this(1, MetadataBundle.a(paramMetadataField, null));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    b.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/drive/query/internal/FieldOnlyFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */