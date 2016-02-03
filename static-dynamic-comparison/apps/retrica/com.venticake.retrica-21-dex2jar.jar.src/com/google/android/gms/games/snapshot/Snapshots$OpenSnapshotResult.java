package com.google.android.gms.games.snapshot;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.drive.Contents;

public abstract interface Snapshots$OpenSnapshotResult
  extends Result
{
  public abstract String getConflictId();
  
  public abstract Snapshot getConflictingSnapshot();
  
  public abstract Contents getResolutionContents();
  
  public abstract Snapshot getSnapshot();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/snapshot/Snapshots$OpenSnapshotResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */