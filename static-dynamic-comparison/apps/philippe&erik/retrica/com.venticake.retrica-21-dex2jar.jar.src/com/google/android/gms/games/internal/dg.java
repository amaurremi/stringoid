package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.a.d;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.UpdateMatchResult;
import com.google.android.gms.internal.hm;

final class dg
  extends AbstractGamesCallbacks
{
  private final a.d<TurnBasedMultiplayer.UpdateMatchResult> b;
  
  public dg(a.d<TurnBasedMultiplayer.UpdateMatchResult> paramd)
  {
    Object localObject;
    this.b = ((a.d)hm.b(localObject, "Holder must not be null"));
  }
  
  public void r(DataHolder paramDataHolder)
  {
    this.b.a(new dj(paramDataHolder));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/dg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */