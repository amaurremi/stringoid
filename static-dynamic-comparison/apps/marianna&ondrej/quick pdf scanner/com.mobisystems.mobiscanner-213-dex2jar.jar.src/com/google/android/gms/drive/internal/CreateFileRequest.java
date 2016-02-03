package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.dc;

public class CreateFileRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<CreateFileRequest> CREATOR = new u();
  final int qh;
  final Contents te;
  final MetadataBundle tg;
  final DriveId tj;
  
  CreateFileRequest(int paramInt, DriveId paramDriveId, MetadataBundle paramMetadataBundle, Contents paramContents)
  {
    this.qh = paramInt;
    this.tj = ((DriveId)dc.N(paramDriveId));
    this.tg = ((MetadataBundle)dc.N(paramMetadataBundle));
    this.te = ((Contents)dc.N(paramContents));
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
    u.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/drive/internal/CreateFileRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */