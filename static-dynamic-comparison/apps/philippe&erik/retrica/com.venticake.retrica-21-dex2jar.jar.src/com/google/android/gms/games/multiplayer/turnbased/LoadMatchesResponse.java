package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.constants.TurnBasedMatchTurnStatus;
import com.google.android.gms.games.multiplayer.InvitationBuffer;

public final class LoadMatchesResponse
{
  private final InvitationBuffer Tv;
  private final TurnBasedMatchBuffer Tw;
  private final TurnBasedMatchBuffer Tx;
  private final TurnBasedMatchBuffer Ty;
  
  public LoadMatchesResponse(Bundle paramBundle)
  {
    DataHolder localDataHolder = a(paramBundle, 0);
    if (localDataHolder != null)
    {
      this.Tv = new InvitationBuffer(localDataHolder);
      localDataHolder = a(paramBundle, 1);
      if (localDataHolder == null) {
        break label101;
      }
      this.Tw = new TurnBasedMatchBuffer(localDataHolder);
      label48:
      localDataHolder = a(paramBundle, 2);
      if (localDataHolder == null) {
        break label109;
      }
    }
    label101:
    label109:
    for (this.Tx = new TurnBasedMatchBuffer(localDataHolder);; this.Tx = null)
    {
      paramBundle = a(paramBundle, 3);
      if (paramBundle == null) {
        break label117;
      }
      this.Ty = new TurnBasedMatchBuffer(paramBundle);
      return;
      this.Tv = null;
      break;
      this.Tw = null;
      break label48;
    }
    label117:
    this.Ty = null;
  }
  
  private static DataHolder a(Bundle paramBundle, int paramInt)
  {
    String str = TurnBasedMatchTurnStatus.cm(paramInt);
    if (!paramBundle.containsKey(str)) {
      return null;
    }
    return (DataHolder)paramBundle.getParcelable(str);
  }
  
  public void close()
  {
    if (this.Tv != null) {
      this.Tv.close();
    }
    if (this.Tw != null) {
      this.Tw.close();
    }
    if (this.Tx != null) {
      this.Tx.close();
    }
    if (this.Ty != null) {
      this.Ty.close();
    }
  }
  
  public TurnBasedMatchBuffer getCompletedMatches()
  {
    return this.Ty;
  }
  
  public InvitationBuffer getInvitations()
  {
    return this.Tv;
  }
  
  public TurnBasedMatchBuffer getMyTurnMatches()
  {
    return this.Tw;
  }
  
  public TurnBasedMatchBuffer getTheirTurnMatches()
  {
    return this.Tx;
  }
  
  public boolean hasData()
  {
    if ((this.Tv != null) && (this.Tv.getCount() > 0)) {}
    while (((this.Tw != null) && (this.Tw.getCount() > 0)) || ((this.Tx != null) && (this.Tx.getCount() > 0)) || ((this.Ty != null) && (this.Ty.getCount() > 0))) {
      return true;
    }
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/multiplayer/turnbased/LoadMatchesResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */