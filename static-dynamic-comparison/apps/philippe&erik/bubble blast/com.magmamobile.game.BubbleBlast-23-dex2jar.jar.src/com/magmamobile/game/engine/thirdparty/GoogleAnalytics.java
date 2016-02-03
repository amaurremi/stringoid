package com.magmamobile.game.engine.thirdparty;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.android.apps.analytics.GoogleAnalyticsTracker;
import com.magmamobile.game.engine.AppParameters;
import com.magmamobile.game.engine.Game;
import com.magmamobile.game.engine.TextUtils;

public final class GoogleAnalytics
{
  private static boolean displayLog = false;
  private static boolean mEnabled;
  private static String mRoot;
  private static GoogleAnalyticsTracker mTracker;
  
  private static final String getAppVersion(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName;
      return paramContext;
    }
    catch (Exception paramContext) {}
    return "?";
  }
  
  private static final String getPageWithRoot(String paramString)
  {
    if (paramString != null) {
      return mRoot.concat(paramString);
    }
    return mRoot;
  }
  
  public static final void setCustomVar(int paramInt1, final String paramString1, final String paramString2, final int paramInt2)
  {
    new Thread()
    {
      public void run()
      {
        try
        {
          GoogleAnalytics.mTracker.setCustomVar(this.val$index, paramString1, paramString2, paramInt2);
          return;
        }
        catch (Exception localException) {}
      }
    }.start();
  }
  
  public static final void start(Context paramContext)
  {
    if (mTracker != null) {}
    for (;;)
    {
      return;
      displayLog = Game.getParameters().ANALYTICS_LOGS_ENABLED;
      try
      {
        mEnabled = Game.getParameters().ANALYTICS_ENABLED;
        mRoot = "/".concat(getAppVersion(paramContext)).concat("/");
        if (mEnabled)
        {
          mTracker = GoogleAnalyticsTracker.getInstance();
          mTracker.startNewSession(Game.getParameters().ANALYTICS_CHANNEL, paramContext);
        }
        if (displayLog)
        {
          Log.d("GA", "start");
          return;
        }
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
      }
    }
  }
  
  public static final void startAndDispatch(Context paramContext, String paramString)
  {
    start(paramContext);
    trackAndDispatch(paramString);
  }
  
  public static final void stop()
  {
    if (displayLog) {
      Log.d("GA", "stop");
    }
  }
  
  public static final void track(String paramString)
  {
    if ((mTracker == null) || (!mEnabled)) {
      return;
    }
    new Thread()
    {
      public void run()
      {
        try
        {
          GoogleAnalytics.mTracker.trackPageView(GoogleAnalytics.getPageWithRoot(GoogleAnalytics.this));
          return;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    }.start();
  }
  
  public static final void trackAndDispatch(String paramString)
  {
    if (!mEnabled) {}
    for (;;)
    {
      return;
      if (mTracker == null)
      {
        startAndDispatch(Game.getContext(), paramString);
        return;
      }
      try
      {
        new Thread()
        {
          public void run()
          {
            try
            {
              GoogleAnalytics.mTracker.trackPageView(GoogleAnalytics.getPageWithRoot(GoogleAnalytics.this));
              GoogleAnalytics.mTracker.dispatch();
              return;
            }
            catch (Exception localException)
            {
              localException.printStackTrace();
            }
          }
        }.start();
        if (displayLog)
        {
          Log.d("GA", paramString);
          return;
        }
      }
      catch (OutOfMemoryError paramString)
      {
        paramString.printStackTrace();
        return;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public static final void trackPackAndLevel(int paramInt1, int paramInt2)
  {
    trackAndDispatch("Pack" + TextUtils.int2String000(paramInt1) + "/Level" + TextUtils.int2String000(paramInt2));
  }
  
  public static final void trackPackAndLevelFinishedStar(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    trackAndDispatch("Finished/Pack" + TextUtils.int2String000(paramInt1) + "/Level" + TextUtils.int2String000(paramInt2) + "/Score/" + paramInt3 + "/Stars/" + paramInt4);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/thirdparty/GoogleAnalytics.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */