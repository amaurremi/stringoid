package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.ExecutionOptions;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class CloseContentsAndUpdateMetadataRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<CloseContentsAndUpdateMetadataRequest> CREATOR = new e();
  final int BR;
  final DriveId NV;
  final MetadataBundle NW;
  final Contents NX;
  final int NY;
  final String Nf;
  final boolean Ng;
  
  CloseContentsAndUpdateMetadataRequest(int paramInt1, DriveId paramDriveId, MetadataBundle paramMetadataBundle, Contents paramContents, boolean paramBoolean, String paramString, int paramInt2)
  {
    this.BR = paramInt1;
    this.NV = paramDriveId;
    this.NW = paramMetadataBundle;
    this.NX = paramContents;
    this.Ng = paramBoolean;
    this.Nf = paramString;
    this.NY = paramInt2;
  }
  
  public CloseContentsAndUpdateMetadataRequest(DriveId paramDriveId, MetadataBundle paramMetadataBundle, Contents paramContents, ExecutionOptions paramExecutionOptions)
  {
    this(1, paramDriveId, paramMetadataBundle, paramContents, paramExecutionOptions.hP(), paramExecutionOptions.hO(), paramExecutionOptions.hQ());
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/drive/internal/CloseContentsAndUpdateMetadataRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */