package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.b;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.Snapshots.CommitSnapshotResult;

final class i
  extends b
  implements Snapshots.CommitSnapshotResult
{
  private final SnapshotMetadata a;
  
  /* Error */
  i(com.google.android.gms.common.data.DataHolder paramDataHolder)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 12	com/google/android/gms/common/api/b:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
    //   5: new 14	com/google/android/gms/games/snapshot/SnapshotMetadataBuffer
    //   8: dup
    //   9: aload_1
    //   10: invokespecial 15	com/google/android/gms/games/snapshot/SnapshotMetadataBuffer:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
    //   13: astore_1
    //   14: aload_1
    //   15: invokevirtual 19	com/google/android/gms/games/snapshot/SnapshotMetadataBuffer:getCount	()I
    //   18: ifle +24 -> 42
    //   21: aload_0
    //   22: new 21	com/google/android/gms/games/snapshot/SnapshotMetadataEntity
    //   25: dup
    //   26: aload_1
    //   27: iconst_0
    //   28: invokevirtual 25	com/google/android/gms/games/snapshot/SnapshotMetadataBuffer:get	(I)Lcom/google/android/gms/games/snapshot/SnapshotMetadata;
    //   31: invokespecial 28	com/google/android/gms/games/snapshot/SnapshotMetadataEntity:<init>	(Lcom/google/android/gms/games/snapshot/SnapshotMetadata;)V
    //   34: putfield 30	com/google/android/gms/games/internal/i:a	Lcom/google/android/gms/games/snapshot/SnapshotMetadata;
    //   37: aload_1
    //   38: invokevirtual 34	com/google/android/gms/games/snapshot/SnapshotMetadataBuffer:close	()V
    //   41: return
    //   42: aload_0
    //   43: aconst_null
    //   44: putfield 30	com/google/android/gms/games/internal/i:a	Lcom/google/android/gms/games/snapshot/SnapshotMetadata;
    //   47: goto -10 -> 37
    //   50: astore_2
    //   51: aload_1
    //   52: invokevirtual 34	com/google/android/gms/games/snapshot/SnapshotMetadataBuffer:close	()V
    //   55: aload_2
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	this	i
    //   0	57	1	paramDataHolder	com.google.android.gms.common.data.DataHolder
    //   50	6	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   14	37	50	finally
    //   42	47	50	finally
  }
  
  public SnapshotMetadata getSnapshotMetadata()
  {
    return this.a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */