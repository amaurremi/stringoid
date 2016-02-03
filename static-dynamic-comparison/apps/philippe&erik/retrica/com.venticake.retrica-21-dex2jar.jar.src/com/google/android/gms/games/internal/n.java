package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.snapshot.Snapshots.DeleteSnapshotResult;

final class n
  implements Snapshots.DeleteSnapshotResult
{
  private final Status a;
  private final String b;
  
  n(int paramInt, String paramString)
  {
    this.a = new Status(paramInt);
    this.b = paramString;
  }
  
  public String getSnapshotId()
  {
    return this.b;
  }
  
  public Status getStatus()
  {
    return this.a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */