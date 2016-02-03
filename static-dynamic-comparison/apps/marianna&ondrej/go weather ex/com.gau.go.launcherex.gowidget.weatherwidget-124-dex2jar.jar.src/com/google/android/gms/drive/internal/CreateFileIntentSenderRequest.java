package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class CreateFileIntentSenderRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<CreateFileIntentSenderRequest> CREATOR = new g();
  final String EB;
  final DriveId EC;
  final MetadataBundle EZ;
  final int Eu;
  final int xH;
  
  CreateFileIntentSenderRequest(int paramInt1, MetadataBundle paramMetadataBundle, int paramInt2, String paramString, DriveId paramDriveId)
  {
    this.xH = paramInt1;
    this.EZ = paramMetadataBundle;
    this.Eu = paramInt2;
    this.EB = paramString;
    this.EC = paramDriveId;
  }
  
  public CreateFileIntentSenderRequest(MetadataBundle paramMetadataBundle, int paramInt, String paramString, DriveId paramDriveId)
  {
    this(1, paramMetadataBundle, paramInt, paramString, paramDriveId);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    g.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/drive/internal/CreateFileIntentSenderRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */