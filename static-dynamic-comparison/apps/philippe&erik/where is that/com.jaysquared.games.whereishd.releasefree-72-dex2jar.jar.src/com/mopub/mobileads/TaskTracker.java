package com.mopub.mobileads;

public class TaskTracker
{
  private long mCurrentTaskId = -1L;
  private long mLastCompletedTaskId;
  
  public long getCurrentTaskId()
  {
    return this.mCurrentTaskId;
  }
  
  public boolean isMostCurrentTask(long paramLong)
  {
    return paramLong >= this.mLastCompletedTaskId;
  }
  
  public void markTaskCompleted(long paramLong)
  {
    if (paramLong > this.mLastCompletedTaskId) {
      this.mLastCompletedTaskId = paramLong;
    }
  }
  
  public void newTaskStarted()
  {
    this.mCurrentTaskId += 1L;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/mopub/mobileads/TaskTracker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */