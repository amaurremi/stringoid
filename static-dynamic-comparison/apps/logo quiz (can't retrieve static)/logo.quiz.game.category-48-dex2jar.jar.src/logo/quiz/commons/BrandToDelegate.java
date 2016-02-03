package logo.quiz.commons;

import android.content.Context;

public abstract interface BrandToDelegate
{
  public abstract int getLevel(BrandTO paramBrandTO, Context paramContext);
  
  public abstract int getLevelStars(BrandTO paramBrandTO, Context paramContext);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/logo/quiz/commons/BrandToDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */