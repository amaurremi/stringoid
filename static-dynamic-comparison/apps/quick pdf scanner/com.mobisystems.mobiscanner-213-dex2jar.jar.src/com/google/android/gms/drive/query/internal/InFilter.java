package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import java.util.Collections;

public class InFilter<T>
  implements SafeParcelable, com.google.android.gms.drive.query.a
{
  public static final e uz = new e();
  final int qh;
  private final com.google.android.gms.drive.metadata.a<T> uA;
  final MetadataBundle ur;
  
  InFilter(int paramInt, MetadataBundle paramMetadataBundle)
  {
    this.qh = paramInt;
    this.ur = paramMetadataBundle;
    this.uA = ((com.google.android.gms.drive.metadata.a)d.b(paramMetadataBundle));
  }
  
  public InFilter(com.google.android.gms.drive.metadata.a<T> parama, T paramT)
  {
    this(1, MetadataBundle.a(parama, Collections.singleton(paramT)));
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/drive/query/internal/InFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */