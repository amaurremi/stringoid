package logo.quiz.commons.utils.hints;

public class HintsServiceFactory
{
  private static HintsService instance;
  
  public static HintsService getInstance()
  {
    if (instance == null) {
      instance = new DefaultHintsService();
    }
    return instance;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/logo/quiz/commons/utils/hints/HintsServiceFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */