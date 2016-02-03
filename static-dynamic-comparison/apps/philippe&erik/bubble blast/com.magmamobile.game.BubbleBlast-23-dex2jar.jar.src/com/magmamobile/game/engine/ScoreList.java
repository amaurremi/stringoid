package com.magmamobile.game.engine;

import java.util.ArrayList;

public final class ScoreList
  extends ArrayList<ScoreItem>
{
  private static final long serialVersionUID = 1L;
  
  public ScoreItem[] toArray()
  {
    ScoreItem[] arrayOfScoreItem = new ScoreItem[size()];
    int i = 0;
    int j = size();
    for (;;)
    {
      if (i >= j) {
        return arrayOfScoreItem;
      }
      arrayOfScoreItem[i] = ((ScoreItem)get(i));
      i += 1;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/ScoreList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */