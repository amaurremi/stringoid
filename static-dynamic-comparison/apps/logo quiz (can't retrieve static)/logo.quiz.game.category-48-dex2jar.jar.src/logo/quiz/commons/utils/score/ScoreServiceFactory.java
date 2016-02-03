package logo.quiz.commons.utils.score;

import logo.quiz.commons.ScoreUtilProvider;

public class ScoreServiceFactory
{
  private static ScoreService instance;
  
  public static ScoreService getInstance(ScoreUtilProvider paramScoreUtilProvider)
  {
    if (instance == null) {
      instance = new DefaultScoreService(paramScoreUtilProvider);
    }
    return instance;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/logo/quiz/commons/utils/score/ScoreServiceFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */