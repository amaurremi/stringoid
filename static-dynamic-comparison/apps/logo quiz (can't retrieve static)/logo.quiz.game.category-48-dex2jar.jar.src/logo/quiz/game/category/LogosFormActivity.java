package logo.quiz.game.category;

import android.app.Activity;
import android.os.Bundle;
import logo.quiz.commons.ConstantsProvider;
import logo.quiz.commons.FormActivityCommons;
import logo.quiz.commons.ScoreUtilProvider;

public class LogosFormActivity
  extends FormActivityCommons
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
  
  protected String getTapJoyPayPerActionCode()
  {
    return "cee84ce5-630f-4e26-ac2f-4ec2cd660b53";
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/logo/quiz/game/category/LogosFormActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */