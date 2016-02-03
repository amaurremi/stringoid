package com.magmamobile.game.BubbleBlast.utils;

import android.content.Context;
import com.google.android.apps.analytics.GoogleAnalyticsTracker;

public final class GoogleAnalytics
{
  private static String mRoot;
  private static GoogleAnalyticsTracker mTracker;
  
  private static String getPageWithRoot(String paramString)
  {
    if (paramString != null) {
      return mRoot.concat(paramString);
    }
    return mRoot;
  }
  
  public static void start(Context paramContext, String paramString)
  {
    if (mTracker != null) {
      return;
    }
    mRoot = paramString;
    mTracker = GoogleAnalyticsTracker.getInstance();
    mTracker.startNewSession(AppVars.GGAnalytics, paramContext);
    trackAndDispatch(null);
  }
  
  public static void stop()
  {
    if (mTracker == null) {
      return;
    }
    mTracker.stopSession();
  }
  
  public static void track(String paramString)
  {
    if (mTracker == null) {
      return;
    }
    new Thread()
    {
      public void run()
      {
        GoogleAnalytics.mTracker.trackPageView(GoogleAnalytics.getPageWithRoot(GoogleAnalytics.this));
      }
    }.start();
  }
  
  public static void trackAndDispatch(String paramString)
  {
    if (mTracker == null) {
      return;
    }
    new Thread()
    {
      public void run()
      {
        GoogleAnalytics.trackAndDispatchThread(GoogleAnalytics.this);
      }
    }.start();
  }
  
  private static void trackAndDispatchThread(String paramString)
  {
    mTracker.trackPageView(getPageWithRoot(paramString));
    mTracker.dispatch();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/BubbleBlast/utils/GoogleAnalytics.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */