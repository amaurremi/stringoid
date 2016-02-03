package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.CancelMatchResult;
import com.google.android.gms.internal.hm;

final class db
  extends AbstractGamesCallbacks
{
  private final a.d<TurnBasedMultiplayer.CancelMatchResult> b;
  
  public db(a.d<TurnBasedMultiplayer.CancelMatchResult> paramd)
  {
    Object localObject;
    this.b = ((a.d)hm.b(localObject, "Holder must not be null"));
  }
  
  public void f(int paramInt, String paramString)
  {
    Status localStatus = new Status(paramInt);
    this.b.a(new g(localStatus, paramString));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/db.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */