package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import com.google.android.gms.internal.hn;
import java.util.ArrayList;

public final class TurnBasedMatchConfig
{
  private final int SV;
  private final String[] Tk;
  private final Bundle Tl;
  private final int Tw;
  
  private TurnBasedMatchConfig(Builder paramBuilder)
  {
    this.SV = paramBuilder.SV;
    this.Tw = paramBuilder.Tw;
    this.Tl = paramBuilder.Tl;
    int i = paramBuilder.To.size();
    this.Tk = ((String[])paramBuilder.To.toArray(new String[i]));
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
    return this.Tl;
  }
  
  public String[] getInvitedPlayerIds()
  {
    return this.Tk;
  }
  
  public int getVariant()
  {
    return this.SV;
  }
  
  public int iC()
  {
    return this.Tw;
  }
  
  public static final class Builder
  {
    int SV = -1;
    Bundle Tl = null;
    ArrayList<String> To = new ArrayList();
    int Tw = 2;
    
    public Builder addInvitedPlayer(String paramString)
    {
      hn.f(paramString);
      this.To.add(paramString);
      return this;
    }
    
    public Builder addInvitedPlayers(ArrayList<String> paramArrayList)
    {
      hn.f(paramArrayList);
      this.To.addAll(paramArrayList);
      return this;
    }
    
    public TurnBasedMatchConfig build()
    {
      return new TurnBasedMatchConfig(this, null);
    }
    
    public Builder setAutoMatchCriteria(Bundle paramBundle)
    {
      this.Tl = paramBundle;
      return this;
    }
    
    public Builder setVariant(int paramInt)
    {
      if ((paramInt == -1) || (paramInt > 0)) {}
      for (boolean bool = true;; bool = false)
      {
        hn.b(bool, "Variant must be a positive integer or TurnBasedMatch.MATCH_VARIANT_ANY");
        this.SV = paramInt;
        return this;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/games/multiplayer/turnbased/TurnBasedMatchConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */