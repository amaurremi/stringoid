package com.quoord.tapatalkpro.adapter;

import com.quoord.tapatalkpro.bean.EngineResponse;

public abstract interface CallBackInterface {
    public abstract void callBack(EngineResponse paramEngineResponse);

    public abstract boolean isOpCancel();

    public abstract void setOpCancel(boolean paramBoolean);

    public abstract void updateSubclassDialog(int paramInt);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/adapter/CallBackInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */