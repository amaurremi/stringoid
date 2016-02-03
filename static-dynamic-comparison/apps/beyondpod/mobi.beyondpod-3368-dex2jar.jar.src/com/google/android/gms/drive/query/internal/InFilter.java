package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.CollectionMetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.query.Filter;
import java.util.Collections;

public class InFilter<T>
  implements SafeParcelable, Filter
{
  public static final e CREATOR = new e();
  final int kg;
  final MetadataBundle rS;
  private final CollectionMetadataField<T> sa;
  
  InFilter(int paramInt, MetadataBundle paramMetadataBundle)
  {
    this.kg = paramInt;
    this.rS = paramMetadataBundle;
    this.sa = ((CollectionMetadataField)d.b(paramMetadataBundle));
  }
  
  public InFilter(CollectionMetadataField<T> paramCollectionMetadataField, T paramT)
  {
    this(1, MetadataBundle.a(paramCollectionMetadataField, Collections.singleton(paramT)));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    e.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/drive/query/internal/InFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */