package com.google.android.gms.internal;

import android.content.Intent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.a;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.games.Players;
import com.google.android.gms.games.Players.LoadPlayersResult;

public final class fz
  implements Players
{
  public Player getCurrentPlayer(GoogleApiClient paramGoogleApiClient)
  {
    return Games.j(paramGoogleApiClient).getCurrentPlayer();
  }
  
  public String getCurrentPlayerId(GoogleApiClient paramGoogleApiClient)
  {
    return Games.j(paramGoogleApiClient).getCurrentPlayerId();
  }
  
  public Intent getPlayerSearchIntent(GoogleApiClient paramGoogleApiClient)
  {
    return Games.j(paramGoogleApiClient).getPlayerSearchIntent();
  }
  
  public PendingResult<Players.LoadPlayersResult> loadInvitablePlayers(GoogleApiClient paramGoogleApiClient, final int paramInt, final boolean paramBoolean)
  {
    paramGoogleApiClient.a(new a(paramInt)
    {
      protected void a(fl paramAnonymousfl)
      {
        paramAnonymousfl.a(this, paramInt, false, paramBoolean);
      }
    });
  }
  
  public PendingResult<Players.LoadPlayersResult> loadMoreInvitablePlayers(GoogleApiClient paramGoogleApiClient, final int paramInt)
  {
    paramGoogleApiClient.a(new a(paramInt)
    {
      protected void a(fl paramAnonymousfl)
      {
        paramAnonymousfl.a(this, paramInt, true, false);
      }
    });
  }
  
  public PendingResult<Players.LoadPlayersResult> loadMoreRecentlyPlayedWithPlayers(GoogleApiClient paramGoogleApiClient, final int paramInt)
  {
    paramGoogleApiClient.a(new a(paramInt)
    {
      protected void a(fl paramAnonymousfl)
      {
        paramAnonymousfl.a(this, "playedWith", paramInt, true, false);
      }
    });
  }
  
  public PendingResult<Players.LoadPlayersResult> loadPlayer(GoogleApiClient paramGoogleApiClient, final String paramString)
  {
    paramGoogleApiClient.a(new a(paramString)
    {
      protected void a(fl paramAnonymousfl)
      {
        paramAnonymousfl.a(this, paramString);
      }
    });
  }
  
  public PendingResult<Players.LoadPlayersResult> loadRecentlyPlayedWithPlayers(GoogleApiClient paramGoogleApiClient, final int paramInt, final boolean paramBoolean)
  {
    paramGoogleApiClient.a(new a(paramInt)
    {
      protected void a(fl paramAnonymousfl)
      {
        paramAnonymousfl.a(this, "playedWith", paramInt, false, paramBoolean);
      }
    });
  }
  
  private static abstract class a
    extends Games.a<Players.LoadPlayersResult>
  {
    public Players.LoadPlayersResult B(final Status paramStatus)
    {
      new Players.LoadPlayersResult()
      {
        public PlayerBuffer getPlayers()
        {
          return new PlayerBuffer(DataHolder.empty(14));
        }
        
        public Status getStatus()
        {
          return paramStatus;
        }
        
        public void release() {}
      };
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/fz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */