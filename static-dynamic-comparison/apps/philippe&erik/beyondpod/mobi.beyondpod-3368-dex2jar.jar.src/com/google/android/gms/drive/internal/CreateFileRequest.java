package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.eg;

public class CreateFileRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<CreateFileRequest> CREATOR = new e();
  final int kg;
  final Contents qX;
  final MetadataBundle qZ;
  final DriveId ra;
  
  CreateFileRequest(int paramInt, DriveId paramDriveId, MetadataBundle paramMetadataBundle, Contents paramContents)
  {
    this.kg = paramInt;
    this.ra = ((DriveId)eg.f(paramDriveId));
    this.qZ = ((MetadataBundle)eg.f(paramMetadataBundle));
    this.qX = ((Contents)eg.f(paramContents));
  }
  
  public CreateFileRequest(DriveId paramDriveId, MetadataBundle paramMetadataBundle, Contents paramContents)
  {
    this(1, paramDriveId, paramMetadataBundle, paramContents);
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/drive/internal/CreateFileRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */