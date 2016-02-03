package magmamobile.lib;

import android.content.Context;
import android.util.Log;
import com.google.android.apps.analytics.GoogleAnalyticsTracker;

public final class Analytics
{
  private static boolean _debug = false;
  private static GoogleAnalyticsTracker _tracker = null;
  
  private static final void Log(String paramString)
  {
    Log.d("-= Analytics =-", paramString);
  }
  
  public static final boolean endSession()
  {
    try
    {
      if (_debug) {
        Log("endSession");
      }
      if (_tracker != null)
      {
        _tracker.stopSession();
        _tracker = null;
      }
      return true;
    }
    catch (Exception localException)
    {
      if (_debug) {
        localException.printStackTrace();
      }
    }
    return false;
  }
  
  public static final String getVersion()
  {
    return "1.5.1";
  }
  
  public static final boolean isDebug()
  {
    return _debug;
  }
  
  public static final void setDebug(boolean paramBoolean)
  {
    _debug = paramBoolean;
  }
  
  public static final Object startSession(Context paramContext, String paramString)
  {
    try
    {
      if (_debug) {
        Log("startSession " + paramString);
      }
      if (_tracker == null)
      {
        _tracker = GoogleAnalyticsTracker.getInstance();
        _tracker.startNewSession(paramString, paramContext);
      }
      paramContext = _tracker;
      return paramContext;
    }
    catch (Exception paramContext)
    {
      if (_debug) {
        paramContext.printStackTrace();
      }
    }
    return null;
  }
  
  public static final boolean track(String paramString)
  {
    try
    {
      if (_debug) {
        Log("track " + paramString);
      }
      if (_tracker != null) {
        _tracker.trackPageView(paramString);
      }
      return true;
    }
    catch (Exception paramString)
    {
      if (_debug) {
        paramString.printStackTrace();
      }
    }
    return false;
  }
  
  public static final boolean trackAndDispatch(String paramString)
  {
    try
    {
      if (_debug) {
        Log("trackAndDispatch " + paramString);
      }
      if (_tracker != null)
      {
        _tracker.trackPageView(paramString);
        _tracker.dispatch();
      }
      return true;
    }
    catch (Exception paramString)
    {
      if (_debug) {
        paramString.printStackTrace();
      }
    }
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/magmamobile/lib/Analytics.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */