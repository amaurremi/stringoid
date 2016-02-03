package logo.quiz.commons.flurry;

import android.content.Context;
import com.flurry.android.FlurryAgent;
import logo.quiz.commons.R.string;

public class Flurry
{
  public static void onEndSession(Context paramContext)
  {
    try
    {
      FlurryAgent.onEndSession(paramContext);
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public static void onEvent(String paramString)
  {
    try
    {
      FlurryAgent.onEvent(paramString);
      return;
    }
    catch (Exception paramString) {}
  }
  
  public static void onStartSession(Context paramContext)
  {
    try
    {
      String str = paramContext.getString(R.string.flurry_key);
      if ((str != null) && (!str.equals(""))) {
        FlurryAgent.onStartSession(paramContext, str);
      }
      return;
    }
    catch (Exception paramContext) {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/logo/quiz/commons/flurry/Flurry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */