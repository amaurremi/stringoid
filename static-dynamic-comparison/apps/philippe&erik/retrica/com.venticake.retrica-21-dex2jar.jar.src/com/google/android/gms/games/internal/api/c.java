package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.event.EventBuffer;
import com.google.android.gms.games.event.Events.LoadEventsResult;

abstract class c
  extends Games.BaseGamesApiMethodImpl<Events.LoadEventsResult>
{
  public Events.LoadEventsResult a(final Status paramStatus)
  {
    new Events.LoadEventsResult()
    {
      public EventBuffer getEvents()
      {
        return new EventBuffer(DataHolder.af(14));
      }
      
      public Status getStatus()
      {
        return paramStatus;
      }
      
      public void release() {}
    };
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/api/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */