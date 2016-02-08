package logo.quiz.game.category;

import android.os.Bundle;
import logo.quiz.commons.ConstantsProvider;
import logo.quiz.commons.ScoreUtilProvider;
import logo.quiz.commons.StatisticsActivityCommons;

public class StatisticsActivity
  extends StatisticsActivityCommons
{
  protected ConstantsProvider getConstants()
  {
    return new Constants();
  }
  
  protected ScoreUtilProvider getScoreUtilProvider()
  {
    return ScoreUtilProviderImpl.getInstance();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/logo/quiz/game/category/StatisticsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */