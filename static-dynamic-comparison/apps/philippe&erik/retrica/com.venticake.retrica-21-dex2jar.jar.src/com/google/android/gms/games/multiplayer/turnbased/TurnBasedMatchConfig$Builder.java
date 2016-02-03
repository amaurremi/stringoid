package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import com.google.android.gms.internal.hm;
import java.util.ArrayList;

public final class TurnBasedMatchConfig$Builder
{
  int SY = -1;
  Bundle To = null;
  ArrayList<String> Tr = new ArrayList();
  int Tz = 2;
  
  public Builder addInvitedPlayer(String paramString)
  {
    hm.f(paramString);
    this.Tr.add(paramString);
    return this;
  }
  
  public Builder addInvitedPlayers(ArrayList<String> paramArrayList)
  {
    hm.f(paramArrayList);
    this.Tr.addAll(paramArrayList);
    return this;
  }
  
  public TurnBasedMatchConfig build()
  {
    return new TurnBasedMatchConfig(this, null);
  }
  
  public Builder setAutoMatchCriteria(Bundle paramBundle)
  {
    this.To = paramBundle;
    return this;
  }
  
  public Builder setVariant(int paramInt)
  {
    if ((paramInt == -1) || (paramInt > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      hm.b(bool, "Variant must be a positive integer or TurnBasedMatch.MATCH_VARIANT_ANY");
      this.SY = paramInt;
      return this;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/multiplayer/turnbased/TurnBasedMatchConfig$Builder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */