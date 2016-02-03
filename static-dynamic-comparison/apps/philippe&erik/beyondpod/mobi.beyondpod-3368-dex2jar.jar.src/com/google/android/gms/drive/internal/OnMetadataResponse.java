package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class OnMetadataResponse
  implements SafeParcelable
{
  public static final Parcelable.Creator<OnMetadataResponse> CREATOR = new v();
  final int kg;
  final MetadataBundle qZ;
  
  OnMetadataResponse(int paramInt, MetadataBundle paramMetadataBundle)
  {
    this.kg = paramInt;
    this.qZ = paramMetadataBundle;
  }
  
  public MetadataBundle cU()
  {
    return this.qZ;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    v.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/drive/internal/OnMetadataResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */