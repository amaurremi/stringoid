package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.constants.TurnBasedMatchTurnStatus;
import com.google.android.gms.games.multiplayer.InvitationBuffer;

public final class LoadMatchesResponse
{
  private final InvitationBuffer Ts;
  private final TurnBasedMatchBuffer Tt;
  private final TurnBasedMatchBuffer Tu;
  private final TurnBasedMatchBuffer Tv;
  
  public LoadMatchesResponse(Bundle paramBundle)
  {
    DataHolder localDataHolder = a(paramBundle, 0);
    if (localDataHolder != null)
    {
      this.Ts = new InvitationBuffer(localDataHolder);
      localDataHolder = a(paramBundle, 1);
      if (localDataHolder == null) {
        break label101;
      }
      this.Tt = new TurnBasedMatchBuffer(localDataHolder);
      label48:
      localDataHolder = a(paramBundle, 2);
      if (localDataHolder == null) {
        break label109;
      }
    }
    label101:
    label109:
    for (this.Tu = new TurnBasedMatchBuffer(localDataHolder);; this.Tu = null)
    {
      paramBundle = a(paramBundle, 3);
      if (paramBundle == null) {
        break label117;
      }
      this.Tv = new TurnBasedMatchBuffer(paramBundle);
      return;
      this.Ts = null;
      break;
      this.Tt = null;
      break label48;
    }
    label117:
    this.Tv = null;
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
    if (this.Ts != null) {
      this.Ts.close();
    }
    if (this.Tt != null) {
      this.Tt.close();
    }
    if (this.Tu != null) {
      this.Tu.close();
    }
    if (this.Tv != null) {
      this.Tv.close();
    }
  }
  
  public TurnBasedMatchBuffer getCompletedMatches()
  {
    return this.Tv;
  }
  
  public InvitationBuffer getInvitations()
  {
    return this.Ts;
  }
  
  public TurnBasedMatchBuffer getMyTurnMatches()
  {
    return this.Tt;
  }
  
  public TurnBasedMatchBuffer getTheirTurnMatches()
  {
    return this.Tu;
  }
  
  public boolean hasData()
  {
    if ((this.Ts != null) && (this.Ts.getCount() > 0)) {}
    while (((this.Tt != null) && (this.Tt.getCount() > 0)) || ((this.Tu != null) && (this.Tu.getCount() > 0)) || ((this.Tv != null) && (this.Tv.getCount() > 0))) {
      return true;
    }
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/games/multiplayer/turnbased/LoadMatchesResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */