package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.b;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadataBuffer;
import com.google.android.gms.games.snapshot.SnapshotMetadataEntity;
import com.google.android.gms.games.snapshot.Snapshots.OpenSnapshotResult;
import com.google.android.gms.internal.gx;

final class bm
  extends b
  implements Snapshots.OpenSnapshotResult
{
  private final Snapshot a;
  private final String b;
  private final Snapshot c;
  private final Contents d;
  
  bm(DataHolder paramDataHolder, Contents paramContents)
  {
    this(paramDataHolder, null, paramContents, null, null);
  }
  
  bm(DataHolder paramDataHolder, String paramString, Contents paramContents1, Contents paramContents2, Contents paramContents3)
  {
    super(paramDataHolder);
    SnapshotMetadataBuffer localSnapshotMetadataBuffer = new SnapshotMetadataBuffer(paramDataHolder);
    for (;;)
    {
      try
      {
        if (localSnapshotMetadataBuffer.getCount() == 0)
        {
          this.a = null;
          this.c = null;
          localSnapshotMetadataBuffer.close();
          this.b = paramString;
          this.d = paramContents3;
          return;
        }
        if (localSnapshotMetadataBuffer.getCount() != 1) {
          break label124;
        }
        if (paramDataHolder.getStatusCode() != 4004)
        {
          gx.A(bool);
          this.a = new SnapshotEntity(new SnapshotMetadataEntity(localSnapshotMetadataBuffer.get(0)), paramContents1);
          this.c = null;
          continue;
        }
        bool = false;
      }
      finally
      {
        localSnapshotMetadataBuffer.close();
      }
      continue;
      label124:
      this.a = new SnapshotEntity(new SnapshotMetadataEntity(localSnapshotMetadataBuffer.get(0)), paramContents1);
      this.c = new SnapshotEntity(new SnapshotMetadataEntity(localSnapshotMetadataBuffer.get(1)), paramContents2);
    }
  }
  
  public String getConflictId()
  {
    return this.b;
  }
  
  public Snapshot getConflictingSnapshot()
  {
    return this.c;
  }
  
  public Contents getResolutionContents()
  {
    return this.d;
  }
  
  public Snapshot getSnapshot()
  {
    return this.a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/bm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */