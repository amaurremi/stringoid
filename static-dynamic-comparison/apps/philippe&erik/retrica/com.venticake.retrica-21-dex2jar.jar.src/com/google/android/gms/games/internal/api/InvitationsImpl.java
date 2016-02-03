package com.google.android.gms.games.internal.api;

import android.content.Intent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.multiplayer.Invitations;
import com.google.android.gms.games.multiplayer.Invitations.LoadInvitationsResult;
import com.google.android.gms.games.multiplayer.OnInvitationReceivedListener;

public final class InvitationsImpl
  implements Invitations
{
  public Intent getInvitationInboxIntent(GoogleApiClient paramGoogleApiClient)
  {
    return Games.c(paramGoogleApiClient).hg();
  }
  
  public PendingResult<Invitations.LoadInvitationsResult> loadInvitations(GoogleApiClient paramGoogleApiClient)
  {
    return loadInvitations(paramGoogleApiClient, 0);
  }
  
  public PendingResult<Invitations.LoadInvitationsResult> loadInvitations(GoogleApiClient paramGoogleApiClient, final int paramInt)
  {
    paramGoogleApiClient.a(new f(paramInt)
    {
      protected void a(GamesClientImpl paramAnonymousGamesClientImpl)
      {
        paramAnonymousGamesClientImpl.c(this, paramInt);
      }
    });
  }
  
  public void registerInvitationListener(GoogleApiClient paramGoogleApiClient, OnInvitationReceivedListener paramOnInvitationReceivedListener)
  {
    Games.c(paramGoogleApiClient).a(paramOnInvitationReceivedListener);
  }
  
  public void unregisterInvitationListener(GoogleApiClient paramGoogleApiClient)
  {
    Games.c(paramGoogleApiClient).hh();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/api/InvitationsImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */