package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.constants.TurnBasedMatchTurnStatus;
import com.google.android.gms.games.multiplayer.InvitationBuffer;

public final class LoadMatchesResponse
{
  private final InvitationBuffer aco;
  private final TurnBasedMatchBuffer acp;
  private final TurnBasedMatchBuffer acq;
  private final TurnBasedMatchBuffer acr;
  
  public LoadMatchesResponse(Bundle paramBundle)
  {
    DataHolder localDataHolder = a(paramBundle, 0);
    if (localDataHolder != null)
    {
      this.aco = new InvitationBuffer(localDataHolder);
      localDataHolder = a(paramBundle, 1);
      if (localDataHolder == null) {
        break label101;
      }
      this.acp = new TurnBasedMatchBuffer(localDataHolder);
      label48:
      localDataHolder = a(paramBundle, 2);
      if (localDataHolder == null) {
        break label109;
      }
    }
    label101:
    label109:
    for (this.acq = new TurnBasedMatchBuffer(localDataHolder);; this.acq = null)
    {
      paramBundle = a(paramBundle, 3);
      if (paramBundle == null) {
        break label117;
      }
      this.acr = new TurnBasedMatchBuffer(paramBundle);
      return;
      this.aco = null;
      break;
      this.acp = null;
      break label48;
    }
    label117:
    this.acr = null;
  }
  
  private static DataHolder a(Bundle paramBundle, int paramInt)
  {
    String str = TurnBasedMatchTurnStatus.dH(paramInt);
    if (!paramBundle.containsKey(str)) {
      return null;
    }
    return (DataHolder)paramBundle.getParcelable(str);
  }
  
  public void close()
  {
    if (this.aco != null) {
      this.aco.close();
    }
    if (this.acp != null) {
      this.acp.close();
    }
    if (this.acq != null) {
      this.acq.close();
    }
    if (this.acr != null) {
      this.acr.close();
    }
  }
  
  public TurnBasedMatchBuffer getCompletedMatches()
  {
    return this.acr;
  }
  
  public InvitationBuffer getInvitations()
  {
    return this.aco;
  }
  
  public TurnBasedMatchBuffer getMyTurnMatches()
  {
    return this.acp;
  }
  
  public TurnBasedMatchBuffer getTheirTurnMatches()
  {
    return this.acq;
  }
  
  public boolean hasData()
  {
    if ((this.aco != null) && (this.aco.getCount() > 0)) {}
    while (((this.acp != null) && (this.acp.getCount() > 0)) || ((this.acq != null) && (this.acq.getCount() > 0)) || ((this.acr != null) && (this.acr.getCount() > 0))) {
      return true;
    }
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/games/multiplayer/turnbased/LoadMatchesResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */