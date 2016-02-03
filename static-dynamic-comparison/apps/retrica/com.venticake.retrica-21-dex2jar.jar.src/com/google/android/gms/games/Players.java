package com.google.android.gms.games;

import android.content.Intent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;

public abstract interface Players
{
  public static final String EXTRA_PLAYER_SEARCH_RESULTS = "player_search_results";
  
  public abstract Player getCurrentPlayer(GoogleApiClient paramGoogleApiClient);
  
  public abstract String getCurrentPlayerId(GoogleApiClient paramGoogleApiClient);
  
  public abstract Intent getPlayerSearchIntent(GoogleApiClient paramGoogleApiClient);
  
  public abstract PendingResult<Players.LoadPlayersResult> loadConnectedPlayers(GoogleApiClient paramGoogleApiClient, boolean paramBoolean);
  
  public abstract PendingResult<Players.LoadPlayersResult> loadInvitablePlayers(GoogleApiClient paramGoogleApiClient, int paramInt, boolean paramBoolean);
  
  public abstract PendingResult<Players.LoadPlayersResult> loadMoreInvitablePlayers(GoogleApiClient paramGoogleApiClient, int paramInt);
  
  public abstract PendingResult<Players.LoadPlayersResult> loadMoreRecentlyPlayedWithPlayers(GoogleApiClient paramGoogleApiClient, int paramInt);
  
  public abstract PendingResult<Players.LoadPlayersResult> loadPlayer(GoogleApiClient paramGoogleApiClient, String paramString);
  
  public abstract PendingResult<Players.LoadPlayersResult> loadRecentlyPlayedWithPlayers(GoogleApiClient paramGoogleApiClient, int paramInt, boolean paramBoolean);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/Players.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */