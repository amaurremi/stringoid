package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Notifications;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class NotificationsImpl
  implements Notifications
{
  public void clear(GoogleApiClient paramGoogleApiClient, int paramInt)
  {
    Games.c(paramGoogleApiClient).ch(paramInt);
  }
  
  public void clearAll(GoogleApiClient paramGoogleApiClient)
  {
    clear(paramGoogleApiClient, 31);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/api/NotificationsImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */