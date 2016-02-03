package com.google.android.gms.maps.internal;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.e;
import com.google.android.gms.internal.fq;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public class u {
    private static c SA;
    private static Context Sz;

    public static c A(Context paramContext)
            throws GooglePlayServicesNotAvailableException {
        fq.f(paramContext);
        if (SA != null) {
            return SA;
        }
        B(paramContext);
        SA = C(paramContext);
        try {
            SA.a(e.h(getRemoteContext(paramContext).getResources()), 4452000);
            return SA;
        } catch (RemoteException paramContext) {
            throw new RuntimeRemoteException(paramContext);
        }
    }

    private static void B(Context paramContext)
            throws GooglePlayServicesNotAvailableException {
        int i = GooglePlayServicesUtil.isGooglePlayServicesAvailable(paramContext);
        switch (i) {
            default:
                throw new GooglePlayServicesNotAvailableException(i);
        }
    }

    private static c C(Context paramContext) {
        if (iz()) {
            Log.i(u.class.getSimpleName(), "Making Creator statically");
            return (c) c(iA());
        }
        Log.i(u.class.getSimpleName(), "Making Creator dynamically");
        return c.a.ab((IBinder) a(getRemoteContext(paramContext).getClassLoader(), "com.google.android.gms.maps.internal.CreatorImpl"));
    }

    private static <T> T a(ClassLoader paramClassLoader, String paramString) {
        try {
            paramClassLoader = c(((ClassLoader) fq.f(paramClassLoader)).loadClass(paramString));
            return paramClassLoader;
        } catch (ClassNotFoundException paramClassLoader) {
            throw new IllegalStateException("Unable to find dynamic class " + paramString);
        }
    }

    private static <T> T c(Class<?> paramClass) {
        try {
            Object localObject = paramClass.newInstance();
            return (T) localObject;
        } catch (InstantiationException localInstantiationException) {
            throw new IllegalStateException("Unable to instantiate the dynamic class " + paramClass.getName());
        } catch (IllegalAccessException localIllegalAccessException) {
            throw new IllegalStateException("Unable to call the default constructor of " + paramClass.getName());
        }
    }

    private static Context getRemoteContext(Context paramContext) {
        if (Sz == null) {
            if (!iz()) {
                break label23;
            }
        }
        label23:
        for (Sz = paramContext.getApplicationContext(); ; Sz = GooglePlayServicesUtil.getRemoteContext(paramContext)) {
            return Sz;
        }
    }

    private static Class<?> iA() {
        try {
            if (Build.VERSION.SDK_INT < 15) {
                return Class.forName("com.google.android.gms.maps.internal.CreatorImplGmm6");
            }
            Class localClass = Class.forName("com.google.android.gms.maps.internal.CreatorImpl");
            return localClass;
        } catch (ClassNotFoundException localClassNotFoundException) {
            throw new RuntimeException(localClassNotFoundException);
        }
    }

    private static boolean iz() {
        return false;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/maps/internal/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */