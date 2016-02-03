package com.google.android.gms.drive;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;

public abstract interface DriveResource
{
  public abstract DriveId getDriveId();
  
  public abstract PendingResult<MetadataResult> getMetadata(GoogleApiClient paramGoogleApiClient);
  
  public abstract PendingResult<MetadataResult> updateMetadata(GoogleApiClient paramGoogleApiClient, MetadataChangeSet paramMetadataChangeSet);
  
  public static abstract interface MetadataResult
    extends Result
  {
    public abstract Metadata getMetadata();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/drive/DriveResource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */