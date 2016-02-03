package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.a.d;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.snapshot.Snapshots.OpenSnapshotResult;
import com.google.android.gms.internal.hm;

final class cx
  extends AbstractGamesCallbacks
{
  private final a.d<Snapshots.OpenSnapshotResult> b;
  
  public cx(a.d<Snapshots.OpenSnapshotResult> paramd)
  {
    Object localObject;
    this.b = ((a.d)hm.b(localObject, "Holder must not be null"));
  }
  
  public void a(DataHolder paramDataHolder, Contents paramContents)
  {
    this.b.a(new bm(paramDataHolder, paramContents));
  }
  
  public void a(DataHolder paramDataHolder, String paramString, Contents paramContents1, Contents paramContents2, Contents paramContents3)
  {
    this.b.a(new bm(paramDataHolder, paramString, paramContents1, paramContents2, paramContents3));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/cx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */