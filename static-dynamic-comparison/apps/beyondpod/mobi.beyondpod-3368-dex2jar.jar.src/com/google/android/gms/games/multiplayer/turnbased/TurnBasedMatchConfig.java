package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import com.google.android.gms.internal.eg;
import java.util.ArrayList;

public final class TurnBasedMatchConfig
{
  private final String[] wG;
  private final Bundle wH;
  private final int wT;
  private final int wo;
  
  private TurnBasedMatchConfig(Builder paramBuilder)
  {
    this.wo = paramBuilder.wo;
    this.wT = paramBuilder.wT;
    this.wH = paramBuilder.wH;
    int i = paramBuilder.wK.size();
    this.wG = ((String[])paramBuilder.wK.toArray(new String[i]));
  }
  
  public static Builder builder()
  {
    return new Builder(null);
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
    return this.wH;
  }
  
  public String[] getInvitedPlayerIds()
  {
    return this.wG;
  }
  
  public int getMinPlayers()
  {
    return this.wT;
  }
  
  public int getVariant()
  {
    return this.wo;
  }
  
  public static final class Builder
  {
    Bundle wH = null;
    ArrayList<String> wK = new ArrayList();
    int wT = 2;
    int wo = -1;
    
    public Builder addInvitedPlayer(String paramString)
    {
      eg.f(paramString);
      this.wK.add(paramString);
      return this;
    }
    
    public Builder addInvitedPlayers(ArrayList<String> paramArrayList)
    {
      eg.f(paramArrayList);
      this.wK.addAll(paramArrayList);
      return this;
    }
    
    public TurnBasedMatchConfig build()
    {
      return new TurnBasedMatchConfig(this, null);
    }
    
    public Builder setAutoMatchCriteria(Bundle paramBundle)
    {
      this.wH = paramBundle;
      return this;
    }
    
    public Builder setMinPlayers(int paramInt)
    {
      this.wT = paramInt;
      return this;
    }
    
    public Builder setVariant(int paramInt)
    {
      if ((paramInt == -1) || (paramInt > 0)) {}
      for (boolean bool = true;; bool = false)
      {
        eg.b(bool, "Variant must be a positive integer or TurnBasedMatch.MATCH_VARIANT_ANY");
        this.wo = paramInt;
        return this;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/games/multiplayer/turnbased/TurnBasedMatchConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */