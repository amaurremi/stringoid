package com.google.android.gms.drive;

import android.content.IntentSender;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.drive.internal.h;
import com.google.android.gms.drive.internal.r;
import com.google.android.gms.internal.jy;

public class CreateFileActivityBuilder
{
  public static final String EXTRA_RESPONSE_DRIVE_ID = "response_drive_id";
  private final h MS = new h(0);
  private DriveContents MT;
  
  public IntentSender build(GoogleApiClient paramGoogleApiClient)
  {
    n.b(this.MT, "Must provide initial contents to CreateFileActivityBuilder.");
    if ((paramGoogleApiClient.a(Drive.SCOPE_FILE)) || (paramGoogleApiClient.a(Drive.MU))) {}
    for (boolean bool = true;; bool = false)
    {
      n.b(bool, "The apiClient must have suitable scope to create files");
      jy.a(this.MT.getParcelFileDescriptor());
      this.MT.getContents().hJ();
      return this.MS.build(paramGoogleApiClient);
    }
  }
  
  public CreateFileActivityBuilder setActivityStartFolder(DriveId paramDriveId)
  {
    this.MS.a(paramDriveId);
    return this;
  }
  
  public CreateFileActivityBuilder setActivityTitle(String paramString)
  {
    this.MS.bi(paramString);
    return this;
  }
  
  @Deprecated
  public CreateFileActivityBuilder setInitialContents(Contents paramContents)
  {
    return setInitialDriveContents(new r(paramContents));
  }
  
  public CreateFileActivityBuilder setInitialDriveContents(DriveContents paramDriveContents)
  {
    if (paramDriveContents == null) {
      throw new IllegalArgumentException("DriveContents must be provided.");
    }
    if (!(paramDriveContents instanceof r)) {
      throw new IllegalArgumentException("Only DriveContents obtained from the Drive API are accepted.");
    }
    if (paramDriveContents.getDriveId() != null) {
      throw new IllegalArgumentException("Only DriveContents obtained through DriveApi.newDriveContents are accepted for file creation.");
    }
    if (paramDriveContents.getContents().hK()) {
      throw new IllegalArgumentException("DriveContents are already closed.");
    }
    this.MS.bk(paramDriveContents.getContents().getRequestId());
    this.MT = paramDriveContents;
    return this;
  }
  
  public CreateFileActivityBuilder setInitialMetadata(MetadataChangeSet paramMetadataChangeSet)
  {
    this.MS.a(paramMetadataChangeSet);
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/drive/CreateFileActivityBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */