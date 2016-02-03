package logo.quiz.commons.utils.score;

import android.app.Activity;
import android.content.Context;
import java.io.Serializable;
import logo.quiz.commons.PointsCounter;
import logo.quiz.commons.ScoreUtilProvider;

public abstract interface ScoreService
  extends Serializable
{
  public abstract int getCompletedLogosBeforeLevel(Context paramContext, int paramInt);
  
  public abstract int getCompletedLogosCount(Context paramContext);
  
  public abstract int getCompletedLogosCount(Context paramContext, int paramInt);
  
  public abstract int getCompletedPoints(Context paramContext);
  
  public abstract int getCompletedPoints(Context paramContext, int paramInt);
  
  public abstract int getCompletedPoints(String[] paramArrayOfString, ScoreUtilProvider paramScoreUtilProvider, Context paramContext);
  
  public abstract int getLogosCount(Context paramContext);
  
  public abstract PointsCounter getPointsInfo(Context paramContext);
  
  public abstract PointsCounter getPointsInfo(Context paramContext, int paramInt);
  
  public abstract boolean isComplete(String[] paramArrayOfString, int paramInt);
  
  public abstract void reset();
  
  public abstract void setComplete(int paramInt1, int paramInt2, Activity paramActivity);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/logo/quiz/commons/utils/score/ScoreService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */