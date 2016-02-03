package com.everimaging.fotorsdk.engine;

import android.content.Context;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;

public abstract interface c {
    public abstract <T> T a(Class<T> paramClass);

    public abstract Handler e();

    public abstract FragmentActivity g();

    public abstract Context getBaseContext();

    public abstract boolean l();
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/engine/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */