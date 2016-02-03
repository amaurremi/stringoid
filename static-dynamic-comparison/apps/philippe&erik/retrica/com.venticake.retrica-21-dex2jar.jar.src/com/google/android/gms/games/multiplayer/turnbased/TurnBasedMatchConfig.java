package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import java.util.ArrayList;

public final class TurnBasedMatchConfig
{
  private final int SY;
  private final String[] Tn;
  private final Bundle To;
  private final int Tz;
  
  private TurnBasedMatchConfig(TurnBasedMatchConfig.Builder paramBuilder)
  {
    this.SY = paramBuilder.SY;
    this.Tz = paramBuilder.Tz;
    this.To = paramBuilder.To;
    int i = paramBuilder.Tr.size();
    this.Tn = ((String[])paramBuilder.Tr.toArray(new String[i]));
  }
  
  public static TurnBasedMatchConfig.Builder builder()
  {
    return new TurnBasedMatchConfig.Builder(null);
  }
  
  public static Bundle createAutoMatchCriteria(int paramInt1, int paramInt2, long paramLong)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("min_automatch_players", paramInt1);
    localBundle.putInt("max_automatch_players", paramInt2);
    localBundle.putLong("exclusive_bit_mask", paramLong);
    return localBundle;
  }
  
  public Bundle getAutoMatchCriteria()
  {
    return this.To;
  }
  
  public String[] getInvitedPlayerIds()
  {
    return this.Tn;
  }
  
  public int getVariant()
  {
    return this.SY;
  }
  
  public int iH()
  {
    return this.Tz;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/multiplayer/turnbased/TurnBasedMatchConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */