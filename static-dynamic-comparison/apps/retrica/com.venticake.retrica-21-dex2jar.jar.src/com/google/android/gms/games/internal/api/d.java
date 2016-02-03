package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;

abstract class d
  extends Games.BaseGamesApiMethodImpl<Result>
{
  public Result c(final Status paramStatus)
  {
    new Result()
    {
      public Status getStatus()
      {
        return paramStatus;
      }
    };
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/api/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */