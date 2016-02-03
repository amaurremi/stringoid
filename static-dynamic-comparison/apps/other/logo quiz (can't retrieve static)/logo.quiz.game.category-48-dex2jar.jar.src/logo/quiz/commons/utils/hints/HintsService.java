package logo.quiz.commons.utils.hints;

import android.content.Context;

public abstract interface HintsService
{
  public abstract int getAvailibleHintsCount(Context paramContext);
  
  public abstract void setHints(int paramInt, Context paramContext);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/logo/quiz/commons/utils/hints/HintsService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */