package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.snapshot.SnapshotMetadataBuffer;
import com.google.android.gms.games.snapshot.Snapshots.LoadSnapshotsResult;

abstract class r
  extends Games.BaseGamesApiMethodImpl<Snapshots.LoadSnapshotsResult>
{
  public Snapshots.LoadSnapshotsResult a(final Status paramStatus)
  {
    new Snapshots.LoadSnapshotsResult()
    {
      public SnapshotMetadataBuffer getSnapshots()
      {
        return new SnapshotMetadataBuffer(DataHolder.af(14));
      }
      
      public Status getStatus()
      {
        return paramStatus;
      }
      
      public void release() {}
    };
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/api/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */