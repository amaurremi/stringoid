package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class CreateFileIntentSenderRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<CreateFileIntentSenderRequest> CREATOR = new i();
  final String HV;
  final DriveId HX;
  final MetadataBundle IA;
  final Integer IB;
  final int qX;
  final int xJ;
  
  CreateFileIntentSenderRequest(int paramInt1, MetadataBundle paramMetadataBundle, int paramInt2, String paramString, DriveId paramDriveId, Integer paramInteger)
  {
    this.xJ = paramInt1;
    this.IA = paramMetadataBundle;
    this.qX = paramInt2;
    this.HV = paramString;
    this.HX = paramDriveId;
    this.IB = paramInteger;
  }
  
  public CreateFileIntentSenderRequest(MetadataBundle paramMetadataBundle, int paramInt1, String paramString, DriveId paramDriveId, int paramInt2)
  {
    this(1, paramMetadataBundle, paramInt1, paramString, paramDriveId, Integer.valueOf(paramInt2));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    i.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/drive/internal/CreateFileIntentSenderRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */