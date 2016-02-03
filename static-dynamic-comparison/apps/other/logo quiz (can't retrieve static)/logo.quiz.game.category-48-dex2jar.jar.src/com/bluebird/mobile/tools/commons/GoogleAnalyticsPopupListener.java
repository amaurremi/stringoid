package com.bluebird.mobile.tools.commons;

import android.util.Log;
import com.google.analytics.tracking.android.EasyTracker;
import com.google.analytics.tracking.android.Tracker;

public class GoogleAnalyticsPopupListener
  implements PopupListener
{
  private String category;
  private String label;
  
  public GoogleAnalyticsPopupListener(String paramString1, String paramString2)
  {
    this.category = paramString1;
    this.label = paramString2;
  }
  
  private Tracker getTracker()
  {
    try
    {
      Tracker localTracker = EasyTracker.getTracker();
      return localTracker;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      Log.e("A-TOOLS", "Tracker Not Initialized!", localIllegalStateException);
    }
    return null;
  }
  
  public void onClick()
  {
    Tracker localTracker = getTracker();
    if (localTracker != null) {
      localTracker.trackEvent(this.category, "open", this.label, null);
    }
  }
  
  public void onDismiss()
  {
    Tracker localTracker = getTracker();
    if (localTracker != null) {
      localTracker.trackEvent(this.category, "dismiss", this.label, null);
    }
  }
  
  public void onShowEnd() {}
  
  public void onShowStart()
  {
    Tracker localTracker = getTracker();
    if (localTracker != null) {
      localTracker.trackEvent(this.category, "show", this.label, null);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bluebird/mobile/tools/commons/GoogleAnalyticsPopupListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */