package logo.quiz.commons.utils.score;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import java.io.Serializable;
import logo.quiz.commons.BrandTO;
import logo.quiz.commons.LevelInterface;
import logo.quiz.commons.PointsCounter;
import logo.quiz.commons.ScoreUtilProvider;

public class DefaultScoreService
  implements ScoreService, Serializable
{
  public static final String COMPLETE_LOGOS_KEY = "COMPLETE_LOGOS";
  private static PointsCounter allPointsCounter;
  static final long serialVersionUID = 2349103814146222884L;
  private PointsCounter pointsCounter;
  protected ScoreUtilProvider scoreUtilProvider;
  
  public DefaultScoreService(ScoreUtilProvider paramScoreUtilProvider)
  {
    this.scoreUtilProvider = paramScoreUtilProvider;
  }
  
  public static PointsCounter getAllPointsCounter()
  {
    return allPointsCounter;
  }
  
  private String[] getCompleteLogos(SharedPreferences paramSharedPreferences, Context paramContext)
  {
    this.scoreUtilProvider.getBrandsCount(paramContext);
    if (paramSharedPreferences.getString(getCompleteLogosKey(), null) == null) {
      this.scoreUtilProvider.initLogos(paramContext);
    }
    return paramSharedPreferences.getString(getCompleteLogosKey(), "0,0").split(",");
  }
  
  public static int getCompletedLogosCount(String[] paramArrayOfString)
  {
    int j = 0;
    int m = paramArrayOfString.length;
    int i = 0;
    while (i < m)
    {
      int k = j;
      if (paramArrayOfString[i].trim().equals("1")) {
        k = j + 1;
      }
      i += 1;
      j = k;
    }
    return j;
  }
  
  public static void resetAllPointsCounter()
  {
    allPointsCounter = null;
  }
  
  public static void setAllPointsCounter(PointsCounter paramPointsCounter)
  {
    allPointsCounter = paramPointsCounter;
  }
  
  public static void setCompletedLogos(String paramString1, String paramString2, Context paramContext)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putString(paramString2, paramString1);
    paramContext.commit();
  }
  
  protected String getCompleteLogosKey()
  {
    return "COMPLETE_LOGOS";
  }
  
  public int getCompletedLogosBeforeLevel(Context paramContext, int paramInt)
  {
    String[] arrayOfString = getCompleteLogos(PreferenceManager.getDefaultSharedPreferences(paramContext), paramContext);
    int j = 0;
    paramContext = this.scoreUtilProvider.getLevelsInfo(paramContext.getApplicationContext());
    int i = 0;
    while (i < paramContext[(paramInt - 2)].getTo())
    {
      int k = j;
      if (arrayOfString[i].trim().equals("1")) {
        k = j + 1;
      }
      i += 1;
      j = k;
    }
    return j;
  }
  
  public int getCompletedLogosCount(Context paramContext)
  {
    return getPointsInfo(paramContext).getCompletedLogosCount();
  }
  
  public int getCompletedLogosCount(Context paramContext, int paramInt)
  {
    String[] arrayOfString = getCompleteLogos(PreferenceManager.getDefaultSharedPreferences(paramContext), paramContext);
    int j = 0;
    paramContext = this.scoreUtilProvider.getLevelsInfo(paramContext.getApplicationContext());
    int i = paramContext[(paramInt - 1)].getFrom();
    while (i < paramContext[(paramInt - 1)].getTo())
    {
      int k = j;
      if (arrayOfString[i].trim().equals("1")) {
        k = j + 1;
      }
      i += 1;
      j = k;
    }
    return j;
  }
  
  public int getCompletedPoints(Context paramContext)
  {
    return getPointsInfo(paramContext).getCompletedPoints();
  }
  
  public int getCompletedPoints(Context paramContext, int paramInt)
  {
    String[] arrayOfString = getCompleteLogos(PreferenceManager.getDefaultSharedPreferences(paramContext), paramContext);
    int j = 0;
    LevelInterface[] arrayOfLevelInterface = this.scoreUtilProvider.getLevelsInfo(paramContext);
    int i = arrayOfLevelInterface[(paramInt - 1)].getFrom();
    while (i < arrayOfLevelInterface[(paramInt - 1)].getTo())
    {
      int k = j;
      if (arrayOfString[i].trim().equals("1")) {
        k = j + this.scoreUtilProvider.getBrands(paramContext)[i].getLevel(paramContext);
      }
      i += 1;
      j = k;
    }
    return j;
  }
  
  public int getCompletedPoints(String[] paramArrayOfString, ScoreUtilProvider paramScoreUtilProvider, Context paramContext)
  {
    int k = 0;
    int j = 0;
    int n = paramArrayOfString.length;
    int i = 0;
    while (i < n)
    {
      int m = k;
      if (paramArrayOfString[i].trim().equals("1")) {
        m = k + paramScoreUtilProvider.getBrands(paramContext)[j].getLevel(paramContext);
      }
      j += 1;
      i += 1;
      k = m;
    }
    return k;
  }
  
  public int getLogosCount(Context paramContext)
  {
    return this.scoreUtilProvider.getBrandsCount(paramContext);
  }
  
  public PointsCounter getPointsInfo(Context paramContext)
  {
    if (this.pointsCounter == null)
    {
      this.pointsCounter = new PointsCounter();
      String[] arrayOfString = getCompleteLogos(PreferenceManager.getDefaultSharedPreferences(paramContext), paramContext);
      BrandTO[] arrayOfBrandTO = this.scoreUtilProvider.getBrands(paramContext);
      int j = arrayOfBrandTO.length;
      int i = 0;
      while (i < j)
      {
        BrandTO localBrandTO = arrayOfBrandTO[i];
        if ((arrayOfString[localBrandTO.getBrandPosition()] != null) && (arrayOfString[localBrandTO.getBrandPosition()].trim().equals("1")))
        {
          this.pointsCounter.increasePoints(localBrandTO.getLevel(paramContext.getApplicationContext()));
          this.pointsCounter.increaseCompleteLogosCount(1);
        }
        this.pointsCounter.increaseAllPoints(localBrandTO.getLevel(paramContext.getApplicationContext()));
        i += 1;
      }
      this.pointsCounter.setAllLogosCount(this.scoreUtilProvider.getBrandsCount(paramContext));
    }
    return this.pointsCounter;
  }
  
  public PointsCounter getPointsInfo(Context paramContext, int paramInt)
  {
    PointsCounter localPointsCounter = new PointsCounter();
    String[] arrayOfString = getCompleteLogos(PreferenceManager.getDefaultSharedPreferences(paramContext), paramContext);
    BrandTO[] arrayOfBrandTO = this.scoreUtilProvider.getBrands(paramContext, paramInt);
    int i = arrayOfBrandTO.length;
    paramInt = 0;
    while (paramInt < i)
    {
      BrandTO localBrandTO = arrayOfBrandTO[paramInt];
      if ((arrayOfString[localBrandTO.getBrandPosition()] != null) && (arrayOfString[localBrandTO.getBrandPosition()].trim().equals("1")))
      {
        localPointsCounter.increasePoints(localBrandTO.getLevel(paramContext.getApplicationContext()));
        localPointsCounter.increaseCompleteLogosCount(1);
      }
      if (this.pointsCounter == null) {
        localPointsCounter.increaseAllPoints(localBrandTO.getLevel(paramContext.getApplicationContext()));
      }
      paramInt += 1;
    }
    if (this.pointsCounter == null)
    {
      localPointsCounter.setAllLogosCount(this.scoreUtilProvider.getBrandsCount(paramContext));
      return localPointsCounter;
    }
    localPointsCounter.setAllPoints(this.pointsCounter.getAllPoints());
    localPointsCounter.setAllLogosCount(this.pointsCounter.getAllLogosCount());
    return localPointsCounter;
  }
  
  public boolean isComplete(String[] paramArrayOfString, int paramInt)
  {
    boolean bool = false;
    if (paramInt < paramArrayOfString.length)
    {
      if (paramArrayOfString[paramInt].trim().equals("1")) {
        bool = true;
      }
    }
    else {
      return bool;
    }
    return false;
  }
  
  public void reset()
  {
    this.pointsCounter = null;
    resetAllPointsCounter();
  }
  
  public void setComplete(int paramInt1, int paramInt2, Activity paramActivity)
  {
    if (this.pointsCounter != null)
    {
      this.pointsCounter.increaseCompleteLogosCount(1);
      this.pointsCounter.increasePoints(paramInt2);
    }
    if (allPointsCounter != null)
    {
      allPointsCounter.increaseCompleteLogosCount(1);
      allPointsCounter.increasePoints(paramInt2);
    }
    Object localObject = PreferenceManager.getDefaultSharedPreferences(paramActivity);
    paramActivity = getCompleteLogos((SharedPreferences)localObject, paramActivity);
    paramActivity[paramInt1] = "1";
    StringBuilder localStringBuilder = new StringBuilder();
    paramInt2 = paramActivity.length;
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      localStringBuilder.append(paramActivity[paramInt1]);
      localStringBuilder.append(",");
      paramInt1 += 1;
    }
    paramActivity = localStringBuilder.toString();
    paramActivity = paramActivity.substring(0, paramActivity.length() - 1);
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putString(getCompleteLogosKey(), paramActivity);
    ((SharedPreferences.Editor)localObject).commit();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/logo/quiz/commons/utils/score/DefaultScoreService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */