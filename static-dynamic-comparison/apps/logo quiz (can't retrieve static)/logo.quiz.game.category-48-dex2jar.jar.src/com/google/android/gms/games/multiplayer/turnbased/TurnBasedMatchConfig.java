package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import com.google.android.gms.common.internal.n;
import java.util.ArrayList;

public final class TurnBasedMatchConfig
{
  private final int abS;
  private final String[] acg;
  private final Bundle ach;
  private final int acs;
  
  private TurnBasedMatchConfig(Builder paramBuilder)
  {
    this.abS = paramBuilder.abS;
    this.acs = paramBuilder.acs;
    this.ach = paramBuilder.ach;
    int i = paramBuilder.ack.size();
    this.acg = ((String[])paramBuilder.ack.toArray(new String[i]));
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
    return this.ach;
  }
  
  public String[] getInvitedPlayerIds()
  {
    return this.acg;
  }
  
  public int getVariant()
  {
    return this.abS;
  }
  
  public int lF()
  {
    return this.acs;
  }
  
  public static final class Builder
  {
    int abS = -1;
    Bundle ach = null;
    ArrayList<String> ack = new ArrayList();
    int acs = 2;
    
    public Builder addInvitedPlayer(String paramString)
    {
      n.i(paramString);
      this.ack.add(paramString);
      return this;
    }
    
    public Builder addInvitedPlayers(ArrayList<String> paramArrayList)
    {
      n.i(paramArrayList);
      this.ack.addAll(paramArrayList);
      return this;
    }
    
    public TurnBasedMatchConfig build()
    {
      return new TurnBasedMatchConfig(this, null);
    }
    
    public Builder setAutoMatchCriteria(Bundle paramBundle)
    {
      this.ach = paramBundle;
      return this;
    }
    
    public Builder setVariant(int paramInt)
    {
      if ((paramInt == -1) || (paramInt > 0)) {}
      for (boolean bool = true;; bool = false)
      {
        n.b(bool, "Variant must be a positive integer or TurnBasedMatch.MATCH_VARIANT_ANY");
        this.abS = paramInt;
        return this;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/games/multiplayer/turnbased/TurnBasedMatchConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */