package com.google.android.gms.drive;

import android.content.IntentSender;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.query.Query;

public abstract interface DriveApi
{
  public abstract PendingResult<Status> discardContents(GoogleApiClient paramGoogleApiClient, Contents paramContents);
  
  public abstract PendingResult<DriveIdResult> fetchDriveId(GoogleApiClient paramGoogleApiClient, String paramString);
  
  public abstract DriveFile getFile(GoogleApiClient paramGoogleApiClient, DriveId paramDriveId);
  
  public abstract DriveFolder getFolder(GoogleApiClient paramGoogleApiClient, DriveId paramDriveId);
  
  public abstract DriveFolder getRootFolder(GoogleApiClient paramGoogleApiClient);
  
  public abstract PendingResult<ContentsResult> newContents(GoogleApiClient paramGoogleApiClient);
  
  public abstract CreateFileActivityBuilder newCreateFileActivityBuilder();
  
  public abstract OpenFileActivityBuilder newOpenFileActivityBuilder();
  
  public abstract PendingResult<MetadataBufferResult> query(GoogleApiClient paramGoogleApiClient, Query paramQuery);
  
  public abstract PendingResult<Status> requestSync(GoogleApiClient paramGoogleApiClient);
  
  public static abstract interface ContentsResult
    extends Result
  {
    public abstract Contents getContents();
  }
  
  public static abstract interface DriveIdResult
    extends Result
  {
    public abstract DriveId getDriveId();
  }
  
  public static abstract interface IntentSenderResult
    extends Result
  {
    public abstract IntentSender getIntentSender();
  }
  
  public static abstract interface MetadataBufferResult
    extends Result
  {
    public abstract MetadataBuffer getMetadataBuffer();
  }
  
  public static abstract interface OnSyncFinishCallback
  {
    public abstract void onSyncFinish(Status paramStatus);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/drive/DriveApi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */