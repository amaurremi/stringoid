package com.google.android.gms.games.multiplayer.turnbased;

import android.content.Intent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import java.util.List;

public abstract interface TurnBasedMultiplayer
{
  public abstract PendingResult<TurnBasedMultiplayer.InitiateMatchResult> acceptInvitation(GoogleApiClient paramGoogleApiClient, String paramString);
  
  public abstract PendingResult<TurnBasedMultiplayer.CancelMatchResult> cancelMatch(GoogleApiClient paramGoogleApiClient, String paramString);
  
  public abstract PendingResult<TurnBasedMultiplayer.InitiateMatchResult> createMatch(GoogleApiClient paramGoogleApiClient, TurnBasedMatchConfig paramTurnBasedMatchConfig);
  
  public abstract void declineInvitation(GoogleApiClient paramGoogleApiClient, String paramString);
  
  public abstract void dismissInvitation(GoogleApiClient paramGoogleApiClient, String paramString);
  
  public abstract void dismissMatch(GoogleApiClient paramGoogleApiClient, String paramString);
  
  public abstract PendingResult<TurnBasedMultiplayer.UpdateMatchResult> finishMatch(GoogleApiClient paramGoogleApiClient, String paramString);
  
  public abstract PendingResult<TurnBasedMultiplayer.UpdateMatchResult> finishMatch(GoogleApiClient paramGoogleApiClient, String paramString, byte[] paramArrayOfByte, List<ParticipantResult> paramList);
  
  public abstract PendingResult<TurnBasedMultiplayer.UpdateMatchResult> finishMatch(GoogleApiClient paramGoogleApiClient, String paramString, byte[] paramArrayOfByte, ParticipantResult... paramVarArgs);
  
  public abstract Intent getInboxIntent(GoogleApiClient paramGoogleApiClient);
  
  public abstract int getMaxMatchDataSize(GoogleApiClient paramGoogleApiClient);
  
  public abstract Intent getSelectOpponentsIntent(GoogleApiClient paramGoogleApiClient, int paramInt1, int paramInt2);
  
  public abstract Intent getSelectOpponentsIntent(GoogleApiClient paramGoogleApiClient, int paramInt1, int paramInt2, boolean paramBoolean);
  
  public abstract PendingResult<TurnBasedMultiplayer.LeaveMatchResult> leaveMatch(GoogleApiClient paramGoogleApiClient, String paramString);
  
  public abstract PendingResult<TurnBasedMultiplayer.LeaveMatchResult> leaveMatchDuringTurn(GoogleApiClient paramGoogleApiClient, String paramString1, String paramString2);
  
  public abstract PendingResult<TurnBasedMultiplayer.LoadMatchResult> loadMatch(GoogleApiClient paramGoogleApiClient, String paramString);
  
  public abstract PendingResult<TurnBasedMultiplayer.LoadMatchesResult> loadMatchesByStatus(GoogleApiClient paramGoogleApiClient, int paramInt, int[] paramArrayOfInt);
  
  public abstract PendingResult<TurnBasedMultiplayer.LoadMatchesResult> loadMatchesByStatus(GoogleApiClient paramGoogleApiClient, int[] paramArrayOfInt);
  
  public abstract void registerMatchUpdateListener(GoogleApiClient paramGoogleApiClient, OnTurnBasedMatchUpdateReceivedListener paramOnTurnBasedMatchUpdateReceivedListener);
  
  public abstract PendingResult<TurnBasedMultiplayer.InitiateMatchResult> rematch(GoogleApiClient paramGoogleApiClient, String paramString);
  
  public abstract PendingResult<TurnBasedMultiplayer.UpdateMatchResult> takeTurn(GoogleApiClient paramGoogleApiClient, String paramString1, byte[] paramArrayOfByte, String paramString2);
  
  public abstract PendingResult<TurnBasedMultiplayer.UpdateMatchResult> takeTurn(GoogleApiClient paramGoogleApiClient, String paramString1, byte[] paramArrayOfByte, String paramString2, List<ParticipantResult> paramList);
  
  public abstract PendingResult<TurnBasedMultiplayer.UpdateMatchResult> takeTurn(GoogleApiClient paramGoogleApiClient, String paramString1, byte[] paramArrayOfByte, String paramString2, ParticipantResult... paramVarArgs);
  
  public abstract void unregisterMatchUpdateListener(GoogleApiClient paramGoogleApiClient);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/multiplayer/turnbased/TurnBasedMultiplayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */