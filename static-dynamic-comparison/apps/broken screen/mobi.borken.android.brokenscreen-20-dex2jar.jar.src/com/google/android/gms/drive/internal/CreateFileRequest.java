package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.hn;

public class CreateFileRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<CreateFileRequest> CREATOR = new j();
  final MetadataBundle IA;
  final Integer IB;
  final DriveId IC;
  final boolean IE;
  final Contents It;
  final String Iv;
  final int xJ;
  
  CreateFileRequest(int paramInt, DriveId paramDriveId, MetadataBundle paramMetadataBundle, Contents paramContents, Integer paramInteger, boolean paramBoolean, String paramString)
  {
    this.xJ = paramInt;
    this.IC = ((DriveId)hn.f(paramDriveId));
    this.IA = ((MetadataBundle)hn.f(paramMetadataBundle));
    if ((paramInteger == null) || (paramInteger.intValue() == 0)) {}
    for (this.It = ((Contents)hn.f(paramContents));; this.It = null)
    {
      this.IB = paramInteger;
      this.IE = paramBoolean;
      this.Iv = paramString;
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/drive/internal/CreateFileRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */