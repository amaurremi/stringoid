package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.a.d;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Players.LoadXpStreamResult;
import com.google.android.gms.internal.hm;

final class by
  extends AbstractGamesCallbacks
{
  private final a.d<Players.LoadXpStreamResult> b;
  
  by(a.d<Players.LoadXpStreamResult> paramd)
  {
    Object localObject;
    this.b = ((a.d)hm.b(localObject, "Holder must not be null"));
  }
  
  public void P(DataHolder paramDataHolder)
  {
    this.b.a(new bf(paramDataHolder));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/by.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */