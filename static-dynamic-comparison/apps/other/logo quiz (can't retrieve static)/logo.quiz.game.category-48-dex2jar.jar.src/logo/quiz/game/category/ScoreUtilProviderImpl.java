package logo.quiz.game.category;

import android.app.Activity;
import android.content.Context;
import java.util.Map;
import logo.quiz.commons.BrandTO;
import logo.quiz.commons.LevelInterface;
import logo.quiz.commons.ScoreUtilProvider;

public class ScoreUtilProviderImpl
  implements ScoreUtilProvider
{
  private static ScoreUtilProvider instance;
  
  public static ScoreUtilProvider getInstance()
  {
    if (instance == null) {
      instance = new ScoreUtilProviderImpl();
    }
    return instance;
  }
  
  public int getAvailibleHintsCount(Activity paramActivity)
  {
    return ScoreUtil.getAvailibleHintsCount(paramActivity);
  }
  
  public BrandTO[] getBrands(Context paramContext)
  {
    return ScoreUtil.getBrands(paramContext);
  }
  
  public BrandTO[] getBrands(Context paramContext, int paramInt)
  {
    return ScoreUtil.getBrands(paramContext, paramInt);
  }
  
  public int getBrandsCount(Context paramContext)
  {
    return ScoreUtil.getBrandsCount(paramContext);
  }
  
  public Map<String, Integer> getCaterogies()
  {
    return null;
  }
  
  public int getCompletedLogosBeforeLevel(Activity paramActivity, int paramInt)
  {
    return ScoreUtil.getCompletedLogosBeforeLevel(paramActivity, paramInt);
  }
  
  public String getGameModeName()
  {
    return "";
  }
  
  public LevelInterface[] getLevelsInfo(Context paramContext)
  {
    return ScoreUtil.getLevelsInfo();
  }
  
  public int getNewLogosCount()
  {
    return ScoreUtil.getNewLogosCount();
  }
  
  public void initLogos(Context paramContext)
  {
    ScoreUtil.initLogos(paramContext);
  }
  
  public void setActiveBrandsLevel(BrandTO[] paramArrayOfBrandTO)
  {
    ScoreUtil.setActiveBrandsLevel(paramArrayOfBrandTO);
  }
  
  public void setNewLogosCount(int paramInt)
  {
    ScoreUtil.setNewLogosCount(paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/logo/quiz/game/category/ScoreUtilProviderImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */