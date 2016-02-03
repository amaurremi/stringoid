package com.tapstream.sdk;

abstract interface Delegate {
    public abstract int getDelay();

    public abstract boolean isRetryAllowed();

    public abstract void setDelay(int paramInt);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/tapstream/sdk/Delegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */