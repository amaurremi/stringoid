package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.a.d;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Players.LoadPlayersResult;
import com.google.android.gms.internal.hm;

final class bz
  extends AbstractGamesCallbacks
{
  private final a.d<Players.LoadPlayersResult> b;
  
  bz(a.d<Players.LoadPlayersResult> paramd)
  {
    Object localObject;
    this.b = ((a.d)hm.b(localObject, "Holder must not be null"));
  }
  
  public void g(DataHolder paramDataHolder)
  {
    this.b.a(new ay(paramDataHolder));
  }
  
  public void h(DataHolder paramDataHolder)
  {
    this.b.a(new ay(paramDataHolder));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/bz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */