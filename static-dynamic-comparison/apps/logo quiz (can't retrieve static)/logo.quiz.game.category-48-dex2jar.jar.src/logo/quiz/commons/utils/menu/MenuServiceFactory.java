package logo.quiz.commons.utils.menu;

import logo.quiz.commons.ScoreUtilProvider;

public class MenuServiceFactory
{
  private static MenuService instance;
  
  public static MenuService getInstance(ScoreUtilProvider paramScoreUtilProvider)
  {
    if (instance == null) {
      instance = new DefaultMenuService(paramScoreUtilProvider);
    }
    return instance;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/logo/quiz/commons/utils/menu/MenuServiceFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */