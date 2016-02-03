package com.google.analytics.tracking.android;

import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

abstract interface AnalyticsThread
{
  public abstract void dispatch();
  
  public abstract LinkedBlockingQueue<Runnable> getQueue();
  
  public abstract Thread getThread();
  
  public abstract void requestAppOptOut(Analytics.AppOptOutCallback paramAppOptOutCallback);
  
  public abstract void requestClientId(ClientIdCallback paramClientIdCallback);
  
  public abstract void sendHit(Map<String, String> paramMap);
  
  public abstract void setAppOptOut(boolean paramBoolean);
  
  public static abstract interface ClientIdCallback
  {
    public abstract void reportClientId(String paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/analytics/tracking/android/AnalyticsThread.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */