package com.facebook.internal;

abstract interface WorkQueue$WorkItem {
    public abstract boolean cancel();

    public abstract boolean isRunning();

    public abstract void moveToFront();
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/internal/WorkQueue$WorkItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */