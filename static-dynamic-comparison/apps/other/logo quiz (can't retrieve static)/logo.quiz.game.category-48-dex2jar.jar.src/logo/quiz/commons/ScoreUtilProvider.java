package logo.quiz.commons;

import android.app.Activity;
import android.content.Context;
import java.io.Serializable;
import java.util.Map;

public abstract interface ScoreUtilProvider
  extends Serializable
{
  public abstract int getAvailibleHintsCount(Activity paramActivity);
  
  public abstract BrandTO[] getBrands(Context paramContext);
  
  public abstract BrandTO[] getBrands(Context paramContext, int paramInt);
  
  public abstract int getBrandsCount(Context paramContext);
  
  public abstract Map<String, Integer> getCaterogies();
  
  public abstract int getCompletedLogosBeforeLevel(Activity paramActivity, int paramInt);
  
  public abstract String getGameModeName();
  
  public abstract LevelInterface[] getLevelsInfo(Context paramContext);
  
  public abstract int getNewLogosCount();
  
  public abstract void initLogos(Context paramContext);
  
  public abstract void setActiveBrandsLevel(BrandTO[] paramArrayOfBrandTO);
  
  public abstract void setNewLogosCount(int paramInt);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/logo/quiz/commons/ScoreUtilProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */