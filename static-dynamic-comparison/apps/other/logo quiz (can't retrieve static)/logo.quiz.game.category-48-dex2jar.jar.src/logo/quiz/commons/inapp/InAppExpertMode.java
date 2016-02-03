package logo.quiz.commons.inapp;

import android.content.Context;

public class InAppExpertMode
  extends InAppProduct
{
  public static final String IAB_EXPERT_MODE = "expert_mode_purchased";
  public static final String IAB_EXPERT_MODE_PRICE_SETTINGS_KEY = "IAB_EXPERT_MODE_PRICE_SETTINGS_KEY";
  
  public InAppExpertMode(Context paramContext)
  {
    super("expert_mode_purchased", "IAB_EXPERT_MODE_PRICE_SETTINGS_KEY", paramContext);
  }
  
  public InAppExpertMode(String paramString1, String paramString2, Context paramContext)
  {
    super(paramString1, paramString2, paramContext);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/logo/quiz/commons/inapp/InAppExpertMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */