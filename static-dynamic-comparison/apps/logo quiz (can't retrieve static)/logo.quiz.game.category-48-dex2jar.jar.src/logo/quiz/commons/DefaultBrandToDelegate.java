package logo.quiz.commons;

import android.content.Context;
import java.io.Serializable;

public class DefaultBrandToDelegate
  implements BrandToDelegate, Serializable
{
  private static final long serialVersionUID = 3L;
  
  public int getLevel(BrandTO paramBrandTO, Context paramContext)
  {
    return paramBrandTO.level;
  }
  
  public int getLevelStars(BrandTO paramBrandTO, Context paramContext)
  {
    return paramBrandTO.level;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/logo/quiz/commons/DefaultBrandToDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */