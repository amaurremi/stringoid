package logo.quiz.commons.inapp;

import android.content.Context;

public class InAppHints1
  extends InAppProduct
{
  public static final String IAB_HINTS_1 = "hints_1";
  public static final int IAB_HINTS_1_COUNT = 50;
  public static final String IAB_HINTS_1_PRICE_SETTINGS_KEY = "IAB_HINTS_1_PRICE_SETTINGS_KEY";
  
  public InAppHints1(Context paramContext)
  {
    super("hints_1", "IAB_HINTS_1_PRICE_SETTINGS_KEY", paramContext);
  }
  
  public InAppHints1(String paramString1, String paramString2, Context paramContext)
  {
    super(paramString1, paramString2, paramContext);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/logo/quiz/commons/inapp/InAppHints1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */