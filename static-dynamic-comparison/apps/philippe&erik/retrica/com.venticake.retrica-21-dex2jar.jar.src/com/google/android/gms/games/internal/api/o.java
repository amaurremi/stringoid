package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.request.Requests.UpdateRequestsResult;
import java.util.Set;

abstract class o
  extends Games.BaseGamesApiMethodImpl<Requests.UpdateRequestsResult>
{
  public Requests.UpdateRequestsResult a(final Status paramStatus)
  {
    new Requests.UpdateRequestsResult()
    {
      public Set<String> getRequestIds()
      {
        return null;
      }
      
      public int getRequestOutcome(String paramAnonymousString)
      {
        throw new IllegalArgumentException("Unknown request ID " + paramAnonymousString);
      }
      
      public Status getStatus()
      {
        return paramStatus;
      }
      
      public void release() {}
    };
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/api/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */