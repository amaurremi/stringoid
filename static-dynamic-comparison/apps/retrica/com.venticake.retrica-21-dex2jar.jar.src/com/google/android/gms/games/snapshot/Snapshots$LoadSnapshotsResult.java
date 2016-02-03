package com.google.android.gms.games.snapshot;

import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;

public abstract interface Snapshots$LoadSnapshotsResult
  extends Releasable, Result
{
  public abstract SnapshotMetadataBuffer getSnapshots();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/snapshot/Snapshots$LoadSnapshotsResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */