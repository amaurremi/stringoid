package com.bluebird.mobile.tools.activities;

import android.app.Activity;
import com.google.analytics.tracking.android.EasyTracker;

public class GoogleAnalyticsActivityAction
  extends BaseActivityAction
{
  public GoogleAnalyticsActivityAction(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public void onStartAction()
  {
    EasyTracker.getInstance().activityStart(getActivity());
  }
  
  public void onStopAction()
  {
    EasyTracker.getInstance().activityStop(getActivity());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bluebird/mobile/tools/activities/GoogleAnalyticsActivityAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */