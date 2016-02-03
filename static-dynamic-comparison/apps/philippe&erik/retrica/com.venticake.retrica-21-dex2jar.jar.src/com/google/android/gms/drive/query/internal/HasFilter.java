package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.query.Filter;

public class HasFilter<T>
  implements SafeParcelable, Filter
{
  public static final f CREATOR = new f();
  final MetadataBundle KM;
  final MetadataField<T> KN;
  final int xM;
  
  HasFilter(int paramInt, MetadataBundle paramMetadataBundle)
  {
    this.xM = paramInt;
    this.KM = paramMetadataBundle;
    this.KN = e.a(paramMetadataBundle);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    f.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/drive/query/internal/HasFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */