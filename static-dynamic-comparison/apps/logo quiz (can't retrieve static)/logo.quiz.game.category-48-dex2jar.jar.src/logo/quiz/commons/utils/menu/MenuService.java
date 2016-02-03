package logo.quiz.commons.utils.menu;

import android.app.Activity;
import java.io.Serializable;

public abstract interface MenuService
  extends Serializable
{
  public abstract void refreshScore(Activity paramActivity);
  
  public abstract void switchScore(Activity paramActivity);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/logo/quiz/commons/utils/menu/MenuService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */