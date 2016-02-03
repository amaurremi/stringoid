package com.google.android.gms.tagmanager;

import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;

public abstract interface ContainerHolder
        extends Releasable, Result {
    public abstract Container getContainer();

    public abstract void refresh();

    public abstract void setContainerAvailableListener(ContainerAvailableListener paramContainerAvailableListener);

    public static abstract interface ContainerAvailableListener {
        public abstract void onContainerAvailable(ContainerHolder paramContainerHolder, String paramString);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/tagmanager/ContainerHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */