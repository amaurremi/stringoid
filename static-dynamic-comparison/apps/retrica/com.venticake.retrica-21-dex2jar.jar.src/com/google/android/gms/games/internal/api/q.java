package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.snapshot.Snapshots.DeleteSnapshotResult;

abstract class q
  extends Games.BaseGamesApiMethodImpl<Snapshots.DeleteSnapshotResult>
{
  public Snapshots.DeleteSnapshotResult a(final Status paramStatus)
  {
    new Snapshots.DeleteSnapshotResult()
    {
      public String getSnapshotId()
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/api/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */