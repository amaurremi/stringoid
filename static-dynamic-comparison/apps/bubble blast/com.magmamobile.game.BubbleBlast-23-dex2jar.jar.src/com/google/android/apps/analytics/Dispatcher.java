package com.google.android.apps.analytics;

abstract interface Dispatcher
{
  public abstract void dispatchHits(Hit[] paramArrayOfHit);
  
  public abstract void init(Callbacks paramCallbacks);
  
  public abstract boolean isDryRun();
  
  public abstract void setDryRun(boolean paramBoolean);
  
  public abstract void stop();
  
  public static abstract interface Callbacks
  {
    public abstract void dispatchFinished();
    
    public abstract void hitDispatched(long paramLong);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/google/android/apps/analytics/Dispatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */