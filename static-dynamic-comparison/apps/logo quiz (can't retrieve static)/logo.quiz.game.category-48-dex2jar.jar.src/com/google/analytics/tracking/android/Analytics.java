package com.google.analytics.tracking.android;

public abstract interface Analytics
{
  public abstract boolean debugEnabled();
  
  public abstract Tracker getDefaultTracker();
  
  public abstract Tracker getTracker(String paramString);
  
  public abstract void requestAppOptOut(AppOptOutCallback paramAppOptOutCallback);
  
  public abstract void setAppOptOut(boolean paramBoolean);
  
  public abstract void setDebug(boolean paramBoolean);
  
  public abstract void setDefaultTracker(Tracker paramTracker);
  
  public static abstract interface AppOptOutCallback
  {
    public abstract void reportAppOptOut(boolean paramBoolean);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/analytics/tracking/android/Analytics.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */