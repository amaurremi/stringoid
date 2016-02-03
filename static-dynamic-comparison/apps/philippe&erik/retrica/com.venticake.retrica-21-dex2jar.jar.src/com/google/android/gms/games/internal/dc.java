package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.a.d;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.InitiateMatchResult;
import com.google.android.gms.internal.hm;

final class dc
  extends AbstractGamesCallbacks
{
  private final a.d<TurnBasedMultiplayer.InitiateMatchResult> b;
  
  public dc(a.d<TurnBasedMultiplayer.InitiateMatchResult> paramd)
  {
    Object localObject;
    this.b = ((a.d)hm.b(localObject, "Holder must not be null"));
  }
  
  public void q(DataHolder paramDataHolder)
  {
    this.b.a(new ab(paramDataHolder));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/dc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */