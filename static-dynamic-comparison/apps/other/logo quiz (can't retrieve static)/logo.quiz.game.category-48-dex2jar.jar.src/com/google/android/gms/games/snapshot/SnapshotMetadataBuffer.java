package com.google.android.gms.games.snapshot;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;

public final class SnapshotMetadataBuffer
  extends DataBuffer<SnapshotMetadata>
{
  public SnapshotMetadataBuffer(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
  }
  
  public SnapshotMetadata get(int paramInt)
  {
    return new SnapshotMetadataRef(this.IC, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/games/snapshot/SnapshotMetadataBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */