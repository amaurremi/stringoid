package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Notifications;

public final class fy
  implements Notifications
{
  public void clear(GoogleApiClient paramGoogleApiClient, int paramInt)
  {
    Games.j(paramGoogleApiClient).clearNotifications(paramInt);
  }
  
  public void clearAll(GoogleApiClient paramGoogleApiClient)
  {
    clear(paramGoogleApiClient, -1);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/fy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */