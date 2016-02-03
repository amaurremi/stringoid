package com.tapstream.sdk;

public abstract interface Api {
    public abstract void fireEvent(Event paramEvent);

    public abstract void fireHit(Hit paramHit, Hit.CompletionHandler paramCompletionHandler);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/tapstream/sdk/Api.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */