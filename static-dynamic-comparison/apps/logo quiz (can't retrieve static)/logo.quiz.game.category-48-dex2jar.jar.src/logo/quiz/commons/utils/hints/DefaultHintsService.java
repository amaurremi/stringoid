package logo.quiz.commons.utils.hints;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

public class DefaultHintsService
  implements HintsService
{
  public int getAvailibleHintsCount(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("allHints", 0);
  }
  
  public void setHints(int paramInt, Context paramContext)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("allHints", paramInt);
    paramContext.commit();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/logo/quiz/commons/utils/hints/DefaultHintsService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */