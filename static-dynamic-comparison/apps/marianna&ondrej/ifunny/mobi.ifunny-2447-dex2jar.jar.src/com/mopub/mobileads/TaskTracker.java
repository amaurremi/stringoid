package com.mopub.mobileads;

public class TaskTracker {
    private long mCurrentTaskId = -1L;
    private long mLastCompletedTaskId;

    public long getCurrentTaskId() {
        return this.mCurrentTaskId;
    }

    public boolean isMostCurrentTask(long paramLong) {
        return paramLong >= this.mLastCompletedTaskId;
    }

    public void markTaskCompleted(long paramLong) {
        if (paramLong > this.mLastCompletedTaskId) {
            this.mLastCompletedTaskId = paramLong;
        }
    }

    public void newTaskStarted() {
        this.mCurrentTaskId += 1L;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/TaskTracker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */