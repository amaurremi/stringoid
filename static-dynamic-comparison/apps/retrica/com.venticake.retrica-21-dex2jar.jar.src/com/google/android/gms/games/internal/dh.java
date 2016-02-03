package com.google.android.gms.games.internal;

import android.os.Bundle;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchesResult;
import com.google.android.gms.internal.hm;

final class dh
  extends AbstractGamesCallbacks
{
  private final a.d<TurnBasedMultiplayer.LoadMatchesResult> b;
  
  public dh(a.d<TurnBasedMultiplayer.LoadMatchesResult> paramd)
  {
    Object localObject;
    this.b = ((a.d)hm.b(localObject, "Holder must not be null"));
  }
  
  public void b(int paramInt, Bundle paramBundle)
  {
    paramBundle.setClassLoader(getClass().getClassLoader());
    Status localStatus = new Status(paramInt);
    this.b.a(new av(localStatus, paramBundle));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/dh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */