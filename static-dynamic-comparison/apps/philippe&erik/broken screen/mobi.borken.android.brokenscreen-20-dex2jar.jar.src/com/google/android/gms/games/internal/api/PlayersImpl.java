package com.google.android.gms.games.internal.api;

import android.content.Intent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.games.Players;
import com.google.android.gms.games.Players.LoadOwnerCoverPhotoUrisResult;
import com.google.android.gms.games.Players.LoadPlayersResult;
import com.google.android.gms.games.Players.LoadXpForGameCategoriesResult;
import com.google.android.gms.games.Players.LoadXpForGamesResult;
import com.google.android.gms.games.Players.LoadXpStreamResult;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class PlayersImpl
  implements Players
{
  public Player getCurrentPlayer(GoogleApiClient paramGoogleApiClient)
  {
    return Games.c(paramGoogleApiClient).gW();
  }
  
  public String getCurrentPlayerId(GoogleApiClient paramGoogleApiClient)
  {
    return Games.c(paramGoogleApiClient).gV();
  }
  
  public Intent getPlayerSearchIntent(GoogleApiClient paramGoogleApiClient)
  {
    return Games.c(paramGoogleApiClient).hg();
  }
  
  public PendingResult<Players.LoadPlayersResult> loadConnectedPlayers(GoogleApiClient paramGoogleApiClient, final boolean paramBoolean)
  {
    paramGoogleApiClient.a(new LoadPlayersImpl(paramBoolean)
    {
      protected void a(GamesClientImpl paramAnonymousGamesClientImpl)
      {
        paramAnonymousGamesClientImpl.a(this, paramBoolean);
      }
    });
  }
  
  public PendingResult<Players.LoadPlayersResult> loadInvitablePlayers(GoogleApiClient paramGoogleApiClient, final int paramInt, final boolean paramBoolean)
  {
    paramGoogleApiClient.a(new LoadPlayersImpl(paramInt)
    {
      protected void a(GamesClientImpl paramAnonymousGamesClientImpl)
      {
        paramAnonymousGamesClientImpl.a(this, paramInt, false, paramBoolean);
      }
    });
  }
  
  public PendingResult<Players.LoadPlayersResult> loadMoreInvitablePlayers(GoogleApiClient paramGoogleApiClient, final int paramInt)
  {
    paramGoogleApiClient.a(new LoadPlayersImpl(paramInt)
    {
      protected void a(GamesClientImpl paramAnonymousGamesClientImpl)
      {
        paramAnonymousGamesClientImpl.a(this, paramInt, true, false);
      }
    });
  }
  
  public PendingResult<Players.LoadPlayersResult> loadMoreRecentlyPlayedWithPlayers(GoogleApiClient paramGoogleApiClient, final int paramInt)
  {
    paramGoogleApiClient.a(new LoadPlayersImpl(paramInt)
    {
      protected void a(GamesClientImpl paramAnonymousGamesClientImpl)
      {
        paramAnonymousGamesClientImpl.a(this, "played_with", paramInt, true, false);
      }
    });
  }
  
  public PendingResult<Players.LoadPlayersResult> loadPlayer(GoogleApiClient paramGoogleApiClient, final String paramString)
  {
    paramGoogleApiClient.a(new LoadPlayersImpl(paramString)
    {
      protected void a(GamesClientImpl paramAnonymousGamesClientImpl)
      {
        paramAnonymousGamesClientImpl.a(this, paramString);
      }
    });
  }
  
  public PendingResult<Players.LoadPlayersResult> loadRecentlyPlayedWithPlayers(GoogleApiClient paramGoogleApiClient, final int paramInt, final boolean paramBoolean)
  {
    paramGoogleApiClient.a(new LoadPlayersImpl(paramInt)
    {
      protected void a(GamesClientImpl paramAnonymousGamesClientImpl)
      {
        paramAnonymousGamesClientImpl.a(this, "played_with", paramInt, false, paramBoolean);
      }
    });
  }
  
  private static abstract class LoadOwnerCoverPhotoUrisImpl
    extends Games.BaseGamesApiMethodImpl<Players.LoadOwnerCoverPhotoUrisResult>
  {
    public Players.LoadOwnerCoverPhotoUrisResult O(final Status paramStatus)
    {
      new Players.LoadOwnerCoverPhotoUrisResult()
      {
        public Status getStatus()
        {
          return paramStatus;
        }
      };
    }
  }
  
  private static abstract class LoadPlayersImpl
    extends Games.BaseGamesApiMethodImpl<Players.LoadPlayersResult>
  {
    public Players.LoadPlayersResult P(final Status paramStatus)
    {
      new Players.LoadPlayersResult()
      {
        public PlayerBuffer getPlayers()
        {
          return new PlayerBuffer(DataHolder.af(14));
        }
        
        public Status getStatus()
        {
          return paramStatus;
        }
        
        public void release() {}
      };
    }
  }
  
  private static abstract class LoadXpForGameCategoriesResultImpl
    extends Games.BaseGamesApiMethodImpl<Players.LoadXpForGameCategoriesResult>
  {
    public Players.LoadXpForGameCategoriesResult Q(final Status paramStatus)
    {
      new Players.LoadXpForGameCategoriesResult()
      {
        public Status getStatus()
        {
          return paramStatus;
        }
      };
    }
  }
  
  private static abstract class LoadXpForGameResultImpl
    extends Games.BaseGamesApiMethodImpl<Players.LoadXpForGamesResult>
  {}
  
  private static abstract class LoadXpStreamResultImpl
    extends Games.BaseGamesApiMethodImpl<Players.LoadXpStreamResult>
  {
    public Players.LoadXpStreamResult R(final Status paramStatus)
    {
      new Players.LoadXpStreamResult()
      {
        public Status getStatus()
        {
          return paramStatus;
        }
      };
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/games/internal/api/PlayersImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */