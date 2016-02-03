package logo.quiz.commons.inapp;

import android.content.Context;

public class InAppHints2
  extends InAppProduct
{
  public static final String IAB_HINTS_2 = "hints_2";
  public static final int IAB_HINTS_2_COUNT = 120;
  public static final String IAB_HINTS_2_PRICE_SETTINGS_KEY = "IAB_HINTS_2_PRICE_SETTINGS_KEY";
  
  public InAppHints2(Context paramContext)
  {
    super("hints_2", "IAB_HINTS_2_PRICE_SETTINGS_KEY", paramContext);
  }
  
  public InAppHints2(String paramString1, String paramString2, Context paramContext)
  {
    super(paramString1, paramString2, paramContext);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/logo/quiz/commons/inapp/InAppHints2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */