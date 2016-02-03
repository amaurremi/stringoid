package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.a.d;
import com.google.android.gms.games.snapshot.Snapshots.DeleteSnapshotResult;
import com.google.android.gms.internal.hm;

final class cw
  extends AbstractGamesCallbacks
{
  private final a.d<Snapshots.DeleteSnapshotResult> b;
  
  public cw(a.d<Snapshots.DeleteSnapshotResult> paramd)
  {
    Object localObject;
    this.b = ((a.d)hm.b(localObject, "Holder must not be null"));
  }
  
  public void g(int paramInt, String paramString)
  {
    this.b.a(new n(paramInt, paramString));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/cw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */