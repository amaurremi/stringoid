package com.tapstream.sdk;

public class ActivityEventSource {
    protected ActivityListener listener = null;

    public void setListener(ActivityListener paramActivityListener) {
        this.listener = paramActivityListener;
    }

    public static abstract interface ActivityListener {
        public abstract void onOpen();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/tapstream/sdk/ActivityEventSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */