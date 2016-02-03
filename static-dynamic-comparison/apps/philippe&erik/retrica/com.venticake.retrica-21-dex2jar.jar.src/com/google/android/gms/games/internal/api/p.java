package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.Snapshots.CommitSnapshotResult;

abstract class p
  extends Games.BaseGamesApiMethodImpl<Snapshots.CommitSnapshotResult>
{
  public Snapshots.CommitSnapshotResult a(final Status paramStatus)
  {
    new Snapshots.CommitSnapshotResult()
    {
      public SnapshotMetadata getSnapshotMetadata()
      {
        return null;
      }
      
      public Status getStatus()
      {
        return paramStatus;
      }
    };
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/api/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */