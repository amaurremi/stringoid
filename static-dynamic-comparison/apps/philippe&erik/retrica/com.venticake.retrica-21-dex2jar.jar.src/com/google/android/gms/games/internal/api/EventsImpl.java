package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.event.Events;
import com.google.android.gms.games.event.Events.LoadEventsResult;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class EventsImpl
  implements Events
{
  public void increment(GoogleApiClient paramGoogleApiClient, final String paramString, final int paramInt)
  {
    GamesClientImpl localGamesClientImpl = Games.d(paramGoogleApiClient);
    if (localGamesClientImpl.isConnected())
    {
      localGamesClientImpl.l(paramString, paramInt);
      return;
    }
    paramGoogleApiClient.b(new d(paramString)
    {
      public void a(GamesClientImpl paramAnonymousGamesClientImpl)
      {
        paramAnonymousGamesClientImpl.l(paramString, paramInt);
      }
    });
  }
  
  public PendingResult<Events.LoadEventsResult> load(GoogleApiClient paramGoogleApiClient, final boolean paramBoolean)
  {
    paramGoogleApiClient.a(new c(paramBoolean)
    {
      public void a(GamesClientImpl paramAnonymousGamesClientImpl)
      {
        paramAnonymousGamesClientImpl.d(this, paramBoolean);
      }
    });
  }
  
  public PendingResult<Events.LoadEventsResult> loadByIds(GoogleApiClient paramGoogleApiClient, final boolean paramBoolean, final String... paramVarArgs)
  {
    paramGoogleApiClient.a(new c(paramBoolean)
    {
      public void a(GamesClientImpl paramAnonymousGamesClientImpl)
      {
        paramAnonymousGamesClientImpl.a(this, paramBoolean, paramVarArgs);
      }
    });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/api/EventsImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */