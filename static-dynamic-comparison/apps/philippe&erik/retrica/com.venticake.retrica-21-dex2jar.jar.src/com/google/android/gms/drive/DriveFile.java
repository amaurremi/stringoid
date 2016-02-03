package com.google.android.gms.drive;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

public abstract interface DriveFile
  extends DriveResource
{
  public static final int MODE_READ_ONLY = 268435456;
  public static final int MODE_READ_WRITE = 805306368;
  public static final int MODE_WRITE_ONLY = 536870912;
  
  public abstract PendingResult<Status> commitAndCloseContents(GoogleApiClient paramGoogleApiClient, Contents paramContents);
  
  public abstract PendingResult<Status> commitAndCloseContents(GoogleApiClient paramGoogleApiClient, Contents paramContents, MetadataChangeSet paramMetadataChangeSet);
  
  public abstract PendingResult<Status> discardContents(GoogleApiClient paramGoogleApiClient, Contents paramContents);
  
  public abstract PendingResult<DriveApi.ContentsResult> openContents(GoogleApiClient paramGoogleApiClient, int paramInt, DriveFile.DownloadProgressListener paramDownloadProgressListener);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/drive/DriveFile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */