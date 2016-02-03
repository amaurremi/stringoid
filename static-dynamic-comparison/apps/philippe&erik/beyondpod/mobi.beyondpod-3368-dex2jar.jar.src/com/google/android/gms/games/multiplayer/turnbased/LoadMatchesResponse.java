package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.multiplayer.InvitationBuffer;
import com.google.android.gms.internal.gf;

public final class LoadMatchesResponse
{
  private final InvitationBuffer wO;
  private final TurnBasedMatchBuffer wP;
  private final TurnBasedMatchBuffer wQ;
  private final TurnBasedMatchBuffer wR;
  
  public LoadMatchesResponse(Bundle paramBundle)
  {
    DataHolder localDataHolder = a(paramBundle, 0);
    if (localDataHolder != null)
    {
      this.wO = new InvitationBuffer(localDataHolder);
      localDataHolder = a(paramBundle, 1);
      if (localDataHolder == null) {
        break label101;
      }
      this.wP = new TurnBasedMatchBuffer(localDataHolder);
      label48:
      localDataHolder = a(paramBundle, 2);
      if (localDataHolder == null) {
        break label109;
      }
    }
    label101:
    label109:
    for (this.wQ = new TurnBasedMatchBuffer(localDataHolder);; this.wQ = null)
    {
      paramBundle = a(paramBundle, 3);
      if (paramBundle == null) {
        break label117;
      }
      this.wR = new TurnBasedMatchBuffer(paramBundle);
      return;
      this.wO = null;
      break;
      this.wP = null;
      break label48;
    }
    label117:
    this.wR = null;
  }
  
  private static DataHolder a(Bundle paramBundle, int paramInt)
  {
    String str = gf.aG(paramInt);
    if (!paramBundle.containsKey(str)) {
      return null;
    }
    return (DataHolder)paramBundle.getParcelable(str);
  }
  
  public void close()
  {
    if (this.wO != null) {
      this.wO.close();
    }
    if (this.wP != null) {
      this.wP.close();
    }
    if (this.wQ != null) {
      this.wQ.close();
    }
    if (this.wR != null) {
      this.wR.close();
    }
  }
  
  public TurnBasedMatchBuffer getCompletedMatches()
  {
    return this.wR;
  }
  
  public InvitationBuffer getInvitations()
  {
    return this.wO;
  }
  
  public TurnBasedMatchBuffer getMyTurnMatches()
  {
    return this.wP;
  }
  
  public TurnBasedMatchBuffer getTheirTurnMatches()
  {
    return this.wQ;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/games/multiplayer/turnbased/LoadMatchesResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */