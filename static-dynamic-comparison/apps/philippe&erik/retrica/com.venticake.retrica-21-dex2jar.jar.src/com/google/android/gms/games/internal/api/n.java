package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.request.GameRequestBuffer;
import com.google.android.gms.games.request.Requests.LoadRequestsResult;

abstract class n
  extends Games.BaseGamesApiMethodImpl<Requests.LoadRequestsResult>
{
  public Requests.LoadRequestsResult a(final Status paramStatus)
  {
    new Requests.LoadRequestsResult()
    {
      public GameRequestBuffer getRequests(int paramAnonymousInt)
      {
        return null;
      }
      
      public Status getStatus()
      {
        return paramStatus;
      }
      
      public void release() {}
    };
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/api/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */