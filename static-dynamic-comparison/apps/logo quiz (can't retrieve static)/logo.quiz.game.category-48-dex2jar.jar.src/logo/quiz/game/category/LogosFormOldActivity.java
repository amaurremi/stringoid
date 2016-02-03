package logo.quiz.game.category;

import android.app.Activity;
import android.os.Bundle;
import logo.quiz.commons.ConstantsProvider;
import logo.quiz.commons.FormOldActivityCommons;
import logo.quiz.commons.ScoreUtilProvider;

public class LogosFormOldActivity
  extends FormOldActivityCommons
{
  ConstantsProvider constants = new Constants();
  
  protected int getAvailibleHintsCount(Activity paramActivity)
  {
    return ScoreUtil.getAvailibleHintsCount(this);
  }
  
  protected ConstantsProvider getConstants()
  {
    return this.constants;
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/logo/quiz/game/category/LogosFormOldActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */