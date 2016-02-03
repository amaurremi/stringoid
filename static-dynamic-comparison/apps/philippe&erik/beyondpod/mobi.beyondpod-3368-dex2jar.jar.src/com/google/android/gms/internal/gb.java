package com.google.android.gms.internal;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.a;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import com.google.android.gms.games.multiplayer.turnbased.LoadMatchesResponse;
import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdateReceivedListener;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.CancelMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.InitiateMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LeaveMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchesResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.UpdateMatchResult;
import java.util.List;

public final class gb
  implements TurnBasedMultiplayer
{
  public PendingResult<TurnBasedMultiplayer.InitiateMatchResult> acceptInvitation(GoogleApiClient paramGoogleApiClient, final String paramString)
  {
    paramGoogleApiClient.b(new b(paramString)
    {
      protected void a(fl paramAnonymousfl)
      {
        paramAnonymousfl.e(this, paramString);
      }
    });
  }
  
  public PendingResult<TurnBasedMultiplayer.CancelMatchResult> cancelMatch(GoogleApiClient paramGoogleApiClient, final String paramString)
  {
    paramGoogleApiClient.b(new a(paramString)
    {
      protected void a(fl paramAnonymousfl)
      {
        paramAnonymousfl.g(this, paramString);
      }
    });
  }
  
  public PendingResult<TurnBasedMultiplayer.InitiateMatchResult> createMatch(GoogleApiClient paramGoogleApiClient, final TurnBasedMatchConfig paramTurnBasedMatchConfig)
  {
    paramGoogleApiClient.b(new b(paramTurnBasedMatchConfig)
    {
      protected void a(fl paramAnonymousfl)
      {
        paramAnonymousfl.a(this, paramTurnBasedMatchConfig);
      }
    });
  }
  
  public void declineInvitation(GoogleApiClient paramGoogleApiClient, String paramString)
  {
    Games.j(paramGoogleApiClient).j(paramString, 1);
  }
  
  public void dismissInvitation(GoogleApiClient paramGoogleApiClient, String paramString)
  {
    Games.j(paramGoogleApiClient).i(paramString, 1);
  }
  
  public void dismissMatch(GoogleApiClient paramGoogleApiClient, String paramString)
  {
    Games.j(paramGoogleApiClient).dismissTurnBasedMatch(paramString);
  }
  
  public PendingResult<TurnBasedMultiplayer.UpdateMatchResult> finishMatch(GoogleApiClient paramGoogleApiClient, String paramString)
  {
    return finishMatch(paramGoogleApiClient, paramString, null, (ParticipantResult[])null);
  }
  
  public PendingResult<TurnBasedMultiplayer.UpdateMatchResult> finishMatch(GoogleApiClient paramGoogleApiClient, String paramString, byte[] paramArrayOfByte, List<ParticipantResult> paramList)
  {
    if (paramList == null) {}
    for (paramList = null;; paramList = (ParticipantResult[])paramList.toArray(new ParticipantResult[paramList.size()])) {
      return finishMatch(paramGoogleApiClient, paramString, paramArrayOfByte, paramList);
    }
  }
  
  public PendingResult<TurnBasedMultiplayer.UpdateMatchResult> finishMatch(GoogleApiClient paramGoogleApiClient, final String paramString, final byte[] paramArrayOfByte, final ParticipantResult... paramVarArgs)
  {
    paramGoogleApiClient.b(new f(paramString)
    {
      protected void a(fl paramAnonymousfl)
      {
        paramAnonymousfl.a(this, paramString, paramArrayOfByte, paramVarArgs);
      }
    });
  }
  
  public Intent getInboxIntent(GoogleApiClient paramGoogleApiClient)
  {
    return Games.j(paramGoogleApiClient).getMatchInboxIntent();
  }
  
  public int getMaxMatchDataSize(GoogleApiClient paramGoogleApiClient)
  {
    return Games.j(paramGoogleApiClient).getMaxTurnBasedMatchDataSize();
  }
  
  public Intent getSelectOpponentsIntent(GoogleApiClient paramGoogleApiClient, int paramInt1, int paramInt2)
  {
    return Games.j(paramGoogleApiClient).getTurnBasedSelectOpponentsIntent(paramInt1, paramInt2, true);
  }
  
  public Intent getSelectOpponentsIntent(GoogleApiClient paramGoogleApiClient, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    return Games.j(paramGoogleApiClient).getTurnBasedSelectOpponentsIntent(paramInt1, paramInt2, paramBoolean);
  }
  
  public PendingResult<TurnBasedMultiplayer.LeaveMatchResult> leaveMatch(GoogleApiClient paramGoogleApiClient, final String paramString)
  {
    paramGoogleApiClient.b(new c(paramString)
    {
      protected void a(fl paramAnonymousfl)
      {
        paramAnonymousfl.f(this, paramString);
      }
    });
  }
  
  public PendingResult<TurnBasedMultiplayer.LeaveMatchResult> leaveMatchDuringTurn(GoogleApiClient paramGoogleApiClient, final String paramString1, final String paramString2)
  {
    paramGoogleApiClient.b(new c(paramString1)
    {
      protected void a(fl paramAnonymousfl)
      {
        paramAnonymousfl.a(this, paramString1, paramString2);
      }
    });
  }
  
  public PendingResult<TurnBasedMultiplayer.LoadMatchResult> loadMatch(GoogleApiClient paramGoogleApiClient, final String paramString)
  {
    paramGoogleApiClient.a(new d(paramString)
    {
      protected void a(fl paramAnonymousfl)
      {
        paramAnonymousfl.h(this, paramString);
      }
    });
  }
  
  public PendingResult<TurnBasedMultiplayer.LoadMatchesResult> loadMatchesByStatus(GoogleApiClient paramGoogleApiClient, final int... paramVarArgs)
  {
    paramGoogleApiClient.a(new e(paramVarArgs)
    {
      protected void a(fl paramAnonymousfl)
      {
        paramAnonymousfl.a(this, paramVarArgs);
      }
    });
  }
  
  public void registerMatchUpdateListener(GoogleApiClient paramGoogleApiClient, OnTurnBasedMatchUpdateReceivedListener paramOnTurnBasedMatchUpdateReceivedListener)
  {
    Games.j(paramGoogleApiClient).registerMatchUpdateListener(paramOnTurnBasedMatchUpdateReceivedListener);
  }
  
  public PendingResult<TurnBasedMultiplayer.InitiateMatchResult> rematch(GoogleApiClient paramGoogleApiClient, final String paramString)
  {
    paramGoogleApiClient.b(new b(paramString)
    {
      protected void a(fl paramAnonymousfl)
      {
        paramAnonymousfl.d(this, paramString);
      }
    });
  }
  
  public PendingResult<TurnBasedMultiplayer.UpdateMatchResult> takeTurn(GoogleApiClient paramGoogleApiClient, String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    return takeTurn(paramGoogleApiClient, paramString1, paramArrayOfByte, paramString2, (ParticipantResult[])null);
  }
  
  public PendingResult<TurnBasedMultiplayer.UpdateMatchResult> takeTurn(GoogleApiClient paramGoogleApiClient, String paramString1, byte[] paramArrayOfByte, String paramString2, List<ParticipantResult> paramList)
  {
    if (paramList == null) {}
    for (paramList = null;; paramList = (ParticipantResult[])paramList.toArray(new ParticipantResult[paramList.size()])) {
      return takeTurn(paramGoogleApiClient, paramString1, paramArrayOfByte, paramString2, paramList);
    }
  }
  
  public PendingResult<TurnBasedMultiplayer.UpdateMatchResult> takeTurn(GoogleApiClient paramGoogleApiClient, final String paramString1, final byte[] paramArrayOfByte, final String paramString2, final ParticipantResult... paramVarArgs)
  {
    paramGoogleApiClient.b(new f(paramString1)
    {
      protected void a(fl paramAnonymousfl)
      {
        paramAnonymousfl.a(this, paramString1, paramArrayOfByte, paramString2, paramVarArgs);
      }
    });
  }
  
  public void unregisterMatchUpdateListener(GoogleApiClient paramGoogleApiClient)
  {
    Games.j(paramGoogleApiClient).unregisterMatchUpdateListener();
  }
  
  private static abstract class a
    extends Games.a<TurnBasedMultiplayer.CancelMatchResult>
  {
    private final String uS;
    
    public a(String paramString)
    {
      this.uS = paramString;
    }
    
    public TurnBasedMultiplayer.CancelMatchResult C(final Status paramStatus)
    {
      new TurnBasedMultiplayer.CancelMatchResult()
      {
        public String getMatchId()
        {
          return gb.a.a(gb.a.this);
        }
        
        public Status getStatus()
        {
          return paramStatus;
        }
      };
    }
  }
  
  private static abstract class b
    extends Games.a<TurnBasedMultiplayer.InitiateMatchResult>
  {
    public TurnBasedMultiplayer.InitiateMatchResult D(final Status paramStatus)
    {
      new TurnBasedMultiplayer.InitiateMatchResult()
      {
        public TurnBasedMatch getMatch()
        {
          return null;
        }
        
        public Status getStatus()
        {
          return paramStatus;
        }
      };
    }
  }
  
  private static abstract class c
    extends Games.a<TurnBasedMultiplayer.LeaveMatchResult>
  {
    public TurnBasedMultiplayer.LeaveMatchResult E(final Status paramStatus)
    {
      new TurnBasedMultiplayer.LeaveMatchResult()
      {
        public TurnBasedMatch getMatch()
        {
          return null;
        }
        
        public Status getStatus()
        {
          return paramStatus;
        }
      };
    }
  }
  
  private static abstract class d
    extends Games.a<TurnBasedMultiplayer.LoadMatchResult>
  {
    public TurnBasedMultiplayer.LoadMatchResult F(final Status paramStatus)
    {
      new TurnBasedMultiplayer.LoadMatchResult()
      {
        public TurnBasedMatch getMatch()
        {
          return null;
        }
        
        public Status getStatus()
        {
          return paramStatus;
        }
      };
    }
  }
  
  private static abstract class e
    extends Games.a<TurnBasedMultiplayer.LoadMatchesResult>
  {
    public TurnBasedMultiplayer.LoadMatchesResult G(final Status paramStatus)
    {
      new TurnBasedMultiplayer.LoadMatchesResult()
      {
        public LoadMatchesResponse getMatches()
        {
          return new LoadMatchesResponse(new Bundle());
        }
        
        public Status getStatus()
        {
          return paramStatus;
        }
        
        public void release() {}
      };
    }
  }
  
  private static abstract class f
    extends Games.a<TurnBasedMultiplayer.UpdateMatchResult>
  {
    public TurnBasedMultiplayer.UpdateMatchResult H(final Status paramStatus)
    {
      new TurnBasedMultiplayer.UpdateMatchResult()
      {
        public TurnBasedMatch getMatch()
        {
          return null;
        }
        
        public Status getStatus()
        {
          return paramStatus;
        }
      };
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/gb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */