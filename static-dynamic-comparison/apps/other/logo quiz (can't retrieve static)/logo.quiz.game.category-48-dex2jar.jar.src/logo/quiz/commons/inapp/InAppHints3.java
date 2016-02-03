package logo.quiz.commons.inapp;

import android.content.Context;

public class InAppHints3
  extends InAppProduct
{
  public static final String IAB_HINTS_3 = "hints_3";
  public static final int IAB_HINTS_3_COUNT = 300;
  public static final String IAB_HINTS_3_PRICE_SETTINGS_KEY = "IAB_HINTS_3_PRICE_SETTINGS_KEY";
  
  public InAppHints3(Context paramContext)
  {
    super("hints_3", "IAB_HINTS_3_PRICE_SETTINGS_KEY", paramContext);
  }
  
  public InAppHints3(String paramString1, String paramString2, Context paramContext)
  {
    super(paramString1, paramString2, paramContext);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/logo/quiz/commons/inapp/InAppHints3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */