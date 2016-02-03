package com.google.android.gms.games.multiplayer.turnbased;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.g;

public final class TurnBasedMatchBuffer
  extends g<TurnBasedMatch>
{
  public TurnBasedMatchBuffer(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
  }
  
  protected String gE()
  {
    return "external_match_id";
  }
  
  protected TurnBasedMatch l(int paramInt1, int paramInt2)
  {
    return new TurnBasedMatchRef(this.IC, paramInt1, paramInt2);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/games/multiplayer/turnbased/TurnBasedMatchBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */