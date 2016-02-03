package com.inmobi.commons.internal;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.HandlerThread;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ApplicationFocusManager {
    protected static final int MSG_PAUSED = 1001;
    protected static final int MSG_RESUMED = 1002;
    private static List<ApplicationFocusManager.FocusChangedListener> a = new ArrayList();
    private static Object b;
    private static HandlerThread c = null;
    private static Application d;

    public static void addFocusChangedListener(ApplicationFocusManager.FocusChangedListener paramFocusChangedListener) {
        if (Build.VERSION.SDK_INT < 14) {
        }
        do {
            return;
            a.add(paramFocusChangedListener);
        } while (a.size() != 1);
        b();
    }

    @TargetApi(14)
    private static void b() {
        for (; ; ) {
            int i;
            try {
                c = new HandlerThread("InMobiAFM");
                c.start();
                Object localObject3 = Application.class.getDeclaredClasses();
                Object localObject1 = null;
                int j = localObject3.length;
                i = 0;
                Object localObject2;
                if (i < j) {
                    localObject2 = localObject3[i];
                    if (((Class) localObject2).getSimpleName().equalsIgnoreCase("ActivityLifecycleCallbacks")) {
                        localObject1 = localObject2;
                    }
                } else {
                    localObject2 = ((Class) localObject1).getClassLoader();
                    localObject3 = new ApplicationFocusManager.b();
                    localObject2 = Proxy.newProxyInstance((ClassLoader) localObject2, new Class[]{localObject1}, (InvocationHandler) localObject3);
                    if (localObject2 != null) {
                        Application.class.getMethod("registerActivityLifecycleCallbacks", new Class[]{localObject1}).invoke(d, new Object[]{localObject2});
                    }
                    return;
                }
            } catch (Exception localException) {
                localException.printStackTrace();
                Log.internal("[InMobi]-4.5.1", "Cannot register activity lifecycle callbacks", localException);
                return;
            }
            i += 1;
        }
    }

    private static void b(Boolean paramBoolean) {
        Iterator localIterator = a.iterator();
        while (localIterator.hasNext()) {
            ((ApplicationFocusManager.FocusChangedListener) localIterator.next()).onFocusChanged(paramBoolean.booleanValue());
        }
    }

    @TargetApi(14)
    private static void c() {
        try {
            if (b != null) {
                Application.class.getMethod("unregisterActivityLifecycleCallbacks", (Class[]) null).invoke(d, (Object[]) b);
            }
            c.stop();
            c = null;
            return;
        } catch (Exception localException) {
            localException.printStackTrace();
            Log.internal("[InMobi]-4.5.1", "Exception unregister app lifecycle callback", localException);
        }
    }

    @SuppressLint({"NewApi"})
    public static void init(Context paramContext) {
        if ((Build.VERSION.SDK_INT >= 14) && (d == null)) {
            if ((paramContext instanceof Activity)) {
                d = ((Activity) paramContext).getApplication();
            }
        } else {
            return;
        }
        d = (Application) paramContext.getApplicationContext();
    }

    public static void removeFocusChangedListener(ApplicationFocusManager.FocusChangedListener paramFocusChangedListener) {
        if (Build.VERSION.SDK_INT < 14) {
        }
        do {
            return;
            a.remove(paramFocusChangedListener);
        } while (a.size() != 0);
        c();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/commons/internal/ApplicationFocusManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */