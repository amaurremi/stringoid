package com.google.android.gms.games.snapshot;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.drive.Contents;

public abstract interface Snapshots
{
  public static final int DISPLAY_LIMIT_NONE = -1;
  public static final String EXTRA_SNAPSHOT_METADATA = "com.google.android.gms.games.SNAPSHOT_METADATA";
  public static final String EXTRA_SNAPSHOT_NEW = "com.google.android.gms.games.SNAPSHOT_NEW";
  
  public abstract PendingResult<Snapshots.CommitSnapshotResult> commitAndClose(GoogleApiClient paramGoogleApiClient, Snapshot paramSnapshot, SnapshotMetadataChange paramSnapshotMetadataChange);
  
  public abstract PendingResult<Snapshots.DeleteSnapshotResult> delete(GoogleApiClient paramGoogleApiClient, SnapshotMetadata paramSnapshotMetadata);
  
  public abstract void discardAndClose(GoogleApiClient paramGoogleApiClient, Snapshot paramSnapshot);
  
  public abstract int getMaxCoverImageSize(GoogleApiClient paramGoogleApiClient);
  
  public abstract int getMaxDataSize(GoogleApiClient paramGoogleApiClient);
  
  public abstract Intent getSelectSnapshotIntent(GoogleApiClient paramGoogleApiClient, String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt);
  
  public abstract SnapshotMetadata getSnapshotFromBundle(Bundle paramBundle);
  
  public abstract PendingResult<Snapshots.LoadSnapshotsResult> load(GoogleApiClient paramGoogleApiClient, boolean paramBoolean);
  
  public abstract PendingResult<Snapshots.OpenSnapshotResult> open(GoogleApiClient paramGoogleApiClient, SnapshotMetadata paramSnapshotMetadata);
  
  public abstract PendingResult<Snapshots.OpenSnapshotResult> open(GoogleApiClient paramGoogleApiClient, String paramString, boolean paramBoolean);
  
  public abstract PendingResult<Snapshots.OpenSnapshotResult> resolveConflict(GoogleApiClient paramGoogleApiClient, String paramString, Snapshot paramSnapshot);
  
  public abstract PendingResult<Snapshots.OpenSnapshotResult> resolveConflict(GoogleApiClient paramGoogleApiClient, String paramString1, String paramString2, SnapshotMetadataChange paramSnapshotMetadataChange, Contents paramContents);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/snapshot/Snapshots.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */