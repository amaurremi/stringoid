package com.facebook.widget;

import com.facebook.model.GraphObject;

abstract interface GraphObjectCursor<T extends GraphObject> {
    public abstract boolean areMoreObjectsAvailable();

    public abstract void close();

    public abstract int getCount();

    public abstract T getGraphObject();

    public abstract int getPosition();

    public abstract boolean isAfterLast();

    public abstract boolean isBeforeFirst();

    public abstract boolean isClosed();

    public abstract boolean isFirst();

    public abstract boolean isFromCache();

    public abstract boolean isLast();

    public abstract boolean move(int paramInt);

    public abstract boolean moveToFirst();

    public abstract boolean moveToLast();

    public abstract boolean moveToNext();

    public abstract boolean moveToPosition(int paramInt);

    public abstract boolean moveToPrevious();
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/facebook/widget/GraphObjectCursor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */