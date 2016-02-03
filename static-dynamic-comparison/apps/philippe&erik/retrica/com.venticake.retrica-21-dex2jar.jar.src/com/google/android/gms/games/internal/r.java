package com.google.android.gms.games.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.games.internal.events.EventIncrementCache;

class r
  extends EventIncrementCache
{
  public r(GamesClientImpl paramGamesClientImpl)
  {
    super(paramGamesClientImpl.getContext().getMainLooper(), 1000);
  }
  
  protected void o(String paramString, int paramInt)
  {
    try
    {
      ((IGamesService)this.a.ft()).l(paramString, paramInt);
      return;
    }
    catch (RemoteException paramString)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */