package com.mopub.nativeads;

import java.util.Map;

abstract interface TaskManager$TaskManagerListener<T> {
    public abstract void onFail();

    public abstract void onSuccess(Map<String, T> paramMap);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/nativeads/TaskManager$TaskManagerListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */