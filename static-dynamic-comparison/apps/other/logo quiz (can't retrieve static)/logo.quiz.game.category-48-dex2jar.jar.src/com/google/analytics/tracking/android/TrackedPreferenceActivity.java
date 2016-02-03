package com.google.analytics.tracking.android;

import android.preference.PreferenceActivity;

public class TrackedPreferenceActivity
  extends PreferenceActivity
{
  protected void onStart()
  {
    super.onStart();
    EasyTracker.getInstance().activityStart(this);
  }
  
  protected void onStop()
  {
    super.onStop();
    EasyTracker.getInstance().activityStop(this);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/analytics/tracking/android/TrackedPreferenceActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */