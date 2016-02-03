package com.getjar.sdk.utilities;

import android.app.Activity;
import com.getjar.sdk.logging.Area;
import com.getjar.sdk.logging.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GlobalActivityRegistrar
{
  private static volatile GlobalActivityRegistrar _Instance = null;
  private static Object _InstanceLock = new Object();
  private List<Activity> _activitySet = new ArrayList();
  
  public static GlobalActivityRegistrar getInstance()
  {
    if (_Instance == null) {}
    synchronized (_InstanceLock)
    {
      if (_Instance == null) {
        _Instance = new GlobalActivityRegistrar();
      }
      return _Instance;
    }
  }
  
  public void finishAllActivities()
  {
    Iterator localIterator = this._activitySet.iterator();
    while (localIterator.hasNext())
    {
      Activity localActivity = (Activity)localIterator.next();
      try
      {
        localActivity.finish();
        Logger.v(Area.UI.value(), "GlobalActivityRegistrar: finishAllActivities() finished '%1$s'", new Object[] { localActivity.getClass().getSimpleName() });
      }
      catch (Exception localException)
      {
        Logger.w(Area.UI.value(), "GlobalActivityRegistrar: activity.finish() failed [%1$s]", new Object[] { localException.getMessage() });
      }
    }
    this._activitySet.clear();
    Logger.v(Area.UI.value(), "GlobalActivityRegistrar: finishAllActivities() registrar cleared", new Object[0]);
  }
  
  public void registerActivity(Activity paramActivity)
  {
    try
    {
      this._activitySet.add(paramActivity);
      Logger.v(Area.UI.value(), "GlobalActivityRegistrar: registerActivity() registered '%1$s'", new Object[] { paramActivity.getClass().getSimpleName() });
      return;
    }
    catch (Exception paramActivity)
    {
      Logger.w(Area.UI.value(), "GlobalActivityRegistrar: add() failed [%1$s]", new Object[] { paramActivity.getMessage() });
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/utilities/GlobalActivityRegistrar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */