package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.hm;

public class CreateFileRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<CreateFileRequest> CREATOR = new j();
  final MetadataBundle IE;
  final Integer IF;
  final DriveId IG;
  final boolean IH;
  final Contents Iw;
  final String Iy;
  final int xM;
  
  CreateFileRequest(int paramInt, DriveId paramDriveId, MetadataBundle paramMetadataBundle, Contents paramContents, Integer paramInteger, boolean paramBoolean, String paramString)
  {
    this.xM = paramInt;
    this.IG = ((DriveId)hm.f(paramDriveId));
    this.IE = ((MetadataBundle)hm.f(paramMetadataBundle));
    if ((paramInteger == null) || (paramInteger.intValue() == 0)) {}
    for (this.Iw = ((Contents)hm.f(paramContents));; this.Iw = null)
    {
      this.IF = paramInteger;
      this.IH = paramBoolean;
      this.Iy = paramString;
      return;
    }
  }
  
  public CreateFileRequest(DriveId paramDriveId, MetadataBundle paramMetadataBundle, Contents paramContents, int paramInt, boolean paramBoolean, String paramString)
  {
    this(2, paramDriveId, paramMetadataBundle, paramContents, Integer.valueOf(paramInt), paramBoolean, paramString);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    j.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/drive/internal/CreateFileRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */