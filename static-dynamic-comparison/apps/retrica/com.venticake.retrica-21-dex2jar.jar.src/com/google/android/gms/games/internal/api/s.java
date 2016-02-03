package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.Snapshots.OpenSnapshotResult;

abstract class s
  extends Games.BaseGamesApiMethodImpl<Snapshots.OpenSnapshotResult>
{
  public Snapshots.OpenSnapshotResult a(final Status paramStatus)
  {
    new Snapshots.OpenSnapshotResult()
    {
      public String getConflictId()
      {
        return null;
      }
      
      public Snapshot getConflictingSnapshot()
      {
        return null;
      }
      
      public Contents getResolutionContents()
      {
        return null;
      }
      
      public Snapshot getSnapshot()
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/api/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */