package com.google.android.gms.b;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.ag;

public abstract class e<T> {
    private final String a;
    private T b;

    protected e(String paramString) {
        this.a = paramString;
    }

    protected final T a(Context paramContext) {
        if (this.b == null) {
            ag.a(paramContext);
            paramContext = GooglePlayServicesUtil.getRemoteContext(paramContext);
            if (paramContext == null) {
                throw new f("Could not get remote context.");
            }
            paramContext = paramContext.getClassLoader();
        }
        try {
            this.b = a((IBinder) paramContext.loadClass(this.a).newInstance());
            return (T) this.b;
        } catch (ClassNotFoundException paramContext) {
            throw new f("Could not load creator class.", paramContext);
        } catch (InstantiationException paramContext) {
            throw new f("Could not instantiate creator.", paramContext);
        } catch (IllegalAccessException paramContext) {
            throw new f("Could not access creator.", paramContext);
        }
    }

    protected abstract T a(IBinder paramIBinder);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/b/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */