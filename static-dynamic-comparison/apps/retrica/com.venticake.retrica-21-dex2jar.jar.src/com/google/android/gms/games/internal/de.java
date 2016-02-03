package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.a.d;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchResult;
import com.google.android.gms.internal.hm;

final class de
  extends AbstractGamesCallbacks
{
  private final a.d<TurnBasedMultiplayer.LoadMatchResult> b;
  
  public de(a.d<TurnBasedMultiplayer.LoadMatchResult> paramd)
  {
    Object localObject;
    this.b = ((a.d)hm.b(localObject, "Holder must not be null"));
  }
  
  public void p(DataHolder paramDataHolder)
  {
    this.b.a(new au(paramDataHolder));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/de.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */