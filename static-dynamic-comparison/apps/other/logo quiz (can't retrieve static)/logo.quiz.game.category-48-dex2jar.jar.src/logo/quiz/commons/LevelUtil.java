package logo.quiz.commons;

import android.content.Context;

public class LevelUtil
{
  private static int activeLevel = 1;
  
  public static int getActiveLevel()
  {
    return activeLevel;
  }
  
  public static void setActiveLevel(Context paramContext, int paramInt)
  {
    activeLevel = paramInt;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/logo/quiz/commons/LevelUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */