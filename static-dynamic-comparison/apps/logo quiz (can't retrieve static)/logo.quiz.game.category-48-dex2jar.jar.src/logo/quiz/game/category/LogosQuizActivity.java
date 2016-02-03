package logo.quiz.game.category;

import logo.quiz.commons.ConstantsProvider;
import logo.quiz.commons.LogoQuizActivityCommons;
import logo.quiz.commons.ScoreUtilProvider;

public class LogosQuizActivity
  extends LogoQuizActivityCommons
{
  ConstantsProvider constants = new Constants();
  ScoreUtilProvider scoreUtilProvider = ScoreUtilProviderImpl.getInstance();
  
  protected ConstantsProvider getConstants()
  {
    return this.constants;
  }
  
  protected ScoreUtilProvider getScoreUtilProvider()
  {
    return this.scoreUtilProvider;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/logo/quiz/game/category/LogosQuizActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */