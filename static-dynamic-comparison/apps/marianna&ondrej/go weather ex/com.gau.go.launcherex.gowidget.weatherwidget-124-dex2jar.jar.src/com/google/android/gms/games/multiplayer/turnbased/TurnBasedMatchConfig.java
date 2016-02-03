package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import com.google.android.gms.internal.fq;
import java.util.ArrayList;

public final class TurnBasedMatchConfig
{
  private final String[] MN;
  private final Bundle MO;
  private final int MZ;
  private final int My;
  
  private TurnBasedMatchConfig(Builder paramBuilder)
  {
    this.My = paramBuilder.My;
    this.MZ = paramBuilder.MZ;
    this.MO = paramBuilder.MO;
    int i = paramBuilder.MR.size();
    this.MN = ((String[])paramBuilder.MR.toArray(new String[i]));
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
    return this.MO;
  }
  
  public String[] getInvitedPlayerIds()
  {
    return this.MN;
  }
  
  public int getMinPlayers()
  {
    return this.MZ;
  }
  
  public int getVariant()
  {
    return this.My;
  }
  
  public static final class Builder
  {
    Bundle MO = null;
    ArrayList<String> MR = new ArrayList();
    int MZ = 2;
    int My = -1;
    
    public Builder addInvitedPlayer(String paramString)
    {
      fq.f(paramString);
      this.MR.add(paramString);
      return this;
    }
    
    public Builder addInvitedPlayers(ArrayList<String> paramArrayList)
    {
      fq.f(paramArrayList);
      this.MR.addAll(paramArrayList);
      return this;
    }
    
    public TurnBasedMatchConfig build()
    {
      return new TurnBasedMatchConfig(this, null);
    }
    
    public Builder setAutoMatchCriteria(Bundle paramBundle)
    {
      this.MO = paramBundle;
      return this;
    }
    
    public Builder setMinPlayers(int paramInt)
    {
      this.MZ = paramInt;
      return this;
    }
    
    public Builder setVariant(int paramInt)
    {
      if ((paramInt == -1) || (paramInt > 0)) {}
      for (boolean bool = true;; bool = false)
      {
        fq.b(bool, "Variant must be a positive integer or TurnBasedMatch.MATCH_VARIANT_ANY");
        this.My = paramInt;
        return this;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/games/multiplayer/turnbased/TurnBasedMatchConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */