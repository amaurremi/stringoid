package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class OnMetadataResponse
  implements SafeParcelable
{
  public static final Parcelable.Creator<OnMetadataResponse> CREATOR = new g();
  final int qh;
  final MetadataBundle tg;
  
  OnMetadataResponse(int paramInt, MetadataBundle paramMetadataBundle)
  {
    this.qh = paramInt;
    this.tg = paramMetadataBundle;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public MetadataBundle nk()
  {
    return this.tg;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    g.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/drive/internal/OnMetadataResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */