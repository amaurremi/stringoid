package com.google.android.gms.games.internal.api;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange.Builder;
import com.google.android.gms.games.snapshot.Snapshots;
import com.google.android.gms.games.snapshot.Snapshots.CommitSnapshotResult;
import com.google.android.gms.games.snapshot.Snapshots.DeleteSnapshotResult;
import com.google.android.gms.games.snapshot.Snapshots.LoadSnapshotsResult;
import com.google.android.gms.games.snapshot.Snapshots.OpenSnapshotResult;

public final class SnapshotsImpl
  implements Snapshots
{
  public PendingResult<Snapshots.CommitSnapshotResult> commitAndClose(GoogleApiClient paramGoogleApiClient, final Snapshot paramSnapshot, final SnapshotMetadataChange paramSnapshotMetadataChange)
  {
    paramGoogleApiClient.b(new p(paramSnapshot)
    {
      protected void a(GamesClientImpl paramAnonymousGamesClientImpl)
      {
        paramAnonymousGamesClientImpl.a(this, paramSnapshot, paramSnapshotMetadataChange);
      }
    });
  }
  
  public PendingResult<Snapshots.DeleteSnapshotResult> delete(GoogleApiClient paramGoogleApiClient, final SnapshotMetadata paramSnapshotMetadata)
  {
    paramGoogleApiClient.b(new q(paramSnapshotMetadata)
    {
      protected void a(GamesClientImpl paramAnonymousGamesClientImpl)
      {
        paramAnonymousGamesClientImpl.j(this, paramSnapshotMetadata.getSnapshotId());
      }
    });
  }
  
  public void discardAndClose(GoogleApiClient paramGoogleApiClient, Snapshot paramSnapshot)
  {
    Games.c(paramGoogleApiClient).a(paramSnapshot);
  }
  
  public int getMaxCoverImageSize(GoogleApiClient paramGoogleApiClient)
  {
    return Games.c(paramGoogleApiClient).hu();
  }
  
  public int getMaxDataSize(GoogleApiClient paramGoogleApiClient)
  {
    return Games.c(paramGoogleApiClient).ht();
  }
  
  public Intent getSelectSnapshotIntent(GoogleApiClient paramGoogleApiClient, String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    return Games.c(paramGoogleApiClient).a(paramString, paramBoolean1, paramBoolean2, paramInt);
  }
  
  public SnapshotMetadata getSnapshotFromBundle(Bundle paramBundle)
  {
    if ((paramBundle == null) || (!paramBundle.containsKey("com.google.android.gms.games.SNAPSHOT_METADATA"))) {
      return null;
    }
    return (SnapshotMetadata)paramBundle.getParcelable("com.google.android.gms.games.SNAPSHOT_METADATA");
  }
  
  public PendingResult<Snapshots.LoadSnapshotsResult> load(GoogleApiClient paramGoogleApiClient, final boolean paramBoolean)
  {
    paramGoogleApiClient.a(new r(paramBoolean)
    {
      protected void a(GamesClientImpl paramAnonymousGamesClientImpl)
      {
        paramAnonymousGamesClientImpl.e(this, paramBoolean);
      }
    });
  }
  
  public PendingResult<Snapshots.OpenSnapshotResult> open(GoogleApiClient paramGoogleApiClient, SnapshotMetadata paramSnapshotMetadata)
  {
    return open(paramGoogleApiClient, paramSnapshotMetadata.getUniqueName(), false);
  }
  
  public PendingResult<Snapshots.OpenSnapshotResult> open(GoogleApiClient paramGoogleApiClient, final String paramString, final boolean paramBoolean)
  {
    paramGoogleApiClient.b(new s(paramString)
    {
      protected void a(GamesClientImpl paramAnonymousGamesClientImpl)
      {
        paramAnonymousGamesClientImpl.b(this, paramString, paramBoolean);
      }
    });
  }
  
  public PendingResult<Snapshots.OpenSnapshotResult> resolveConflict(GoogleApiClient paramGoogleApiClient, String paramString, Snapshot paramSnapshot)
  {
    SnapshotMetadata localSnapshotMetadata = paramSnapshot.getMetadata();
    SnapshotMetadataChange localSnapshotMetadataChange = new SnapshotMetadataChange.Builder().fromMetadata(localSnapshotMetadata).build();
    return resolveConflict(paramGoogleApiClient, paramString, localSnapshotMetadata.getSnapshotId(), localSnapshotMetadataChange, paramSnapshot.getContents());
  }
  
  public PendingResult<Snapshots.OpenSnapshotResult> resolveConflict(GoogleApiClient paramGoogleApiClient, final String paramString1, final String paramString2, final SnapshotMetadataChange paramSnapshotMetadataChange, final Contents paramContents)
  {
    paramGoogleApiClient.b(new s(paramString1)
    {
      protected void a(GamesClientImpl paramAnonymousGamesClientImpl)
      {
        paramAnonymousGamesClientImpl.a(this, paramString1, paramString2, paramSnapshotMetadataChange, paramContents);
      }
    });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/api/SnapshotsImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */