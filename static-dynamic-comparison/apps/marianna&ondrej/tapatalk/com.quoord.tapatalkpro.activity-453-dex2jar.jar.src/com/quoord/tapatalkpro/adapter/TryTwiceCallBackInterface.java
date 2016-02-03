package com.quoord.tapatalkpro.adapter;

public abstract interface TryTwiceCallBackInterface
        extends CallBackInterface {
    public abstract boolean getSaxCall();

    public abstract boolean getTryTwice();

    public abstract void setSaxCall(boolean paramBoolean);

    public abstract void setTryTwice(boolean paramBoolean);

    public abstract void tryFailed(String paramString);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/adapter/TryTwiceCallBackInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */