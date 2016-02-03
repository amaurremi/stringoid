package com.inmobi.commons.analytics.iat.impl;

import com.inmobi.commons.analytics.iat.impl.config.AdTrackerConfigParams;
import com.inmobi.commons.analytics.iat.impl.config.AdTrackerEventType;
import com.inmobi.commons.analytics.iat.impl.config.AdTrackerGoalRetryParams;
import com.inmobi.commons.analytics.iat.impl.config.AdTrackerInitializer;
import com.inmobi.commons.analytics.iat.impl.net.AdTrackerNetworkInterface;
import com.inmobi.commons.internal.FileOperations;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import java.util.Iterator;
import java.util.Vector;

public class GoalList
  extends Vector<Goal>
{
  public static GoalList getLoggedGoals()
  {
    GoalList localGoalList1 = null;
    if (FileOperations.isFileExist(InternalSDKUtil.getContext(), "eventlog")) {
      localGoalList1 = (GoalList)FileOperations.readFromFile(InternalSDKUtil.getContext(), "eventlog");
    }
    GoalList localGoalList2 = localGoalList1;
    if (localGoalList1 == null) {
      localGoalList2 = new GoalList();
    }
    return localGoalList2;
  }
  
  public boolean addGoal(String paramString, int paramInt1, long paramLong, int paramInt2, boolean paramBoolean)
  {
    AdTrackerNetworkInterface.setSynced(false);
    if ((paramString == null) || ("".equals(paramString.trim())))
    {
      Log.debug("[InMobi]-[AdTracker]-4.1.1", "GoalName is null");
      return false;
    }
    if ((paramInt1 < 1) || (paramLong < 0L))
    {
      Log.internal("[InMobi]-[AdTracker]-4.1.1", "GoalCount cant be 0 or RetryTime cannot be negative");
      return false;
    }
    for (;;)
    {
      try
      {
        Iterator localIterator = iterator();
        if (localIterator.hasNext())
        {
          Goal localGoal = (Goal)localIterator.next();
          if (!localGoal.getGoalName().equals(paramString)) {
            continue;
          }
          if (!"download".equals(paramString)) {
            localGoal.setGoalCount(localGoal.getGoalCount() + paramInt1);
          }
          localGoal.setRetryCount(paramInt2);
          localGoal.setRetryTime(paramLong);
          localGoal.setDuplicateGoal(paramBoolean);
          i = 1;
          if (i == 0) {
            add(new Goal(paramString, paramInt1, paramLong, paramInt2, paramBoolean));
          }
          return true;
        }
      }
      catch (Exception paramString)
      {
        return false;
      }
      int i = 0;
    }
  }
  
  public Goal getGoal(String paramString)
  {
    if ((paramString == null) || ("".equals(paramString.trim())))
    {
      Log.debug("[InMobi]-[AdTracker]-4.1.1", "GoalName is null");
      return null;
    }
    try
    {
      Iterator localIterator = iterator();
      while (localIterator.hasNext())
      {
        Goal localGoal = (Goal)localIterator.next();
        boolean bool = localGoal.getGoalName().equals(paramString);
        if (bool) {
          return localGoal;
        }
      }
    }
    catch (Exception paramString)
    {
      return null;
    }
    return null;
  }
  
  public boolean increaseRetryTime(String paramString, int paramInt, boolean paramBoolean)
  {
    if (paramString != null) {}
    for (;;)
    {
      int j;
      try
      {
        if ("".equals(paramString.trim()))
        {
          Log.internal("[InMobi]-[AdTracker]-4.1.1", "GoalName cannot be null");
          return false;
        }
        Goal localGoal = getGoal(paramString);
        j = AdTrackerInitializer.getConfigParams().getRetryParams().getMaxWaitTime();
        int i = AdTrackerInitializer.getConfigParams().getRetryParams().getMaxRetry();
        if (localGoal != null)
        {
          l1 = localGoal.getRetryTime();
          int k = localGoal.getRetryCount();
          if (l1 >= j) {
            break label175;
          }
          long l2 = l1 * 2L + 30000L;
          l1 = l2;
          if (l2 > j) {
            l1 = j;
          }
          removeGoal(paramString, paramInt);
          j = k + 1;
          if (j < i) {
            addGoal(paramString, paramInt, l1, j, paramBoolean);
          } else {
            AdTrackerUtils.reportMetric(AdTrackerEventType.GOAL_DUMPED, localGoal, 0, 0L, 0, null);
          }
        }
      }
      catch (Exception paramString)
      {
        Log.internal("[InMobi]-[AdTracker]-4.1.1", "Cant increase retry time", paramString);
      }
      return false;
      return true;
      label175:
      long l1 = j;
    }
  }
  
  public boolean removeGoal(String paramString, int paramInt)
  {
    AdTrackerNetworkInterface.setSynced(false);
    if ((paramString == null) || ("".equals(paramString.trim())))
    {
      Log.debug("[InMobi]-[AdTracker]-4.1.1", "GoalName is null");
      return false;
    }
    if (paramInt < 1)
    {
      Log.internal("[InMobi]-[AdTracker]-4.1.1", "GoalCount cannot be 0 or negative");
      return false;
    }
    Iterator localIterator = iterator();
    Goal localGoal;
    while (localIterator.hasNext())
    {
      localGoal = (Goal)localIterator.next();
      if (localGoal.getGoalName().equals(paramString))
      {
        paramInt = localGoal.getGoalCount() - paramInt;
        if (!paramString.equals("download")) {
          break label106;
        }
        remove(localGoal);
      }
    }
    for (;;)
    {
      return true;
      label106:
      if (paramInt <= 0) {
        remove(localGoal);
      } else {
        localGoal.setGoalCount(paramInt);
      }
    }
  }
  
  public void saveGoals()
  {
    FileOperations.saveToFile(InternalSDKUtil.getContext(), "eventlog", this);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/commons/analytics/iat/impl/GoalList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */