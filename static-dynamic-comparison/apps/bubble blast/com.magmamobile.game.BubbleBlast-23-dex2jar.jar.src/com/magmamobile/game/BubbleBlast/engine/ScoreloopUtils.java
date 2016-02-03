package com.magmamobile.game.BubbleBlast.engine;

import android.content.Context;

public class ScoreloopUtils
{
  public static int getScoreloopMode(Enums.enumGameMode paramenumGameMode, int paramInt)
  {
    switch (paramenumGameMode)
    {
    default: 
      return 0;
    case arcade: 
      return paramInt + 999;
    }
    return 2000;
  }
  
  public static String getScoreloopModeAndDifficultyString(Context paramContext, Enums.enumGameMode paramenumGameMode, Enums.enumGameDifficulty paramenumGameDifficulty)
  {
    String str = "";
    switch (paramenumGameMode)
    {
    default: 
      paramenumGameMode = str;
    }
    for (;;)
    {
      switch (paramenumGameDifficulty)
      {
      default: 
        return paramenumGameMode;
        paramenumGameMode = "Puzzle / ";
        continue;
        paramenumGameMode = "Arcade / ";
      }
    }
    return paramenumGameMode + paramContext.getString(2131034139);
    return paramenumGameMode + paramContext.getString(2131034140);
    return paramenumGameMode + paramContext.getString(2131034141);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/BubbleBlast/engine/ScoreloopUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */