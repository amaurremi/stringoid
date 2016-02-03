package com.inmobi.commons.internal;

import android.app.Activity;
import android.os.Handler;
import android.os.HandlerThread;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

final class ApplicationFocusManager$b
        implements InvocationHandler {
    private final Handler a = new ApplicationFocusManager.a(ApplicationFocusManager.a().getLooper());

    public void a(Activity paramActivity) {
        this.a.sendEmptyMessageDelayed(1001, 3000L);
    }

    public void b(Activity paramActivity) {
        this.a.removeMessages(1001);
        this.a.sendEmptyMessage(1002);
    }

    public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject) {
        if (paramArrayOfObject != null) {
            try {
                if (paramMethod.getName().equals("onActivityPaused")) {
                    a((Activity) paramArrayOfObject[0]);
                    return null;
                }
                if (paramMethod.getName().equals("onActivityResumed")) {
                    b((Activity) paramArrayOfObject[0]);
                    return null;
                }
            } catch (Exception paramObject) {
                Log.internal("[InMobi]-4.5.1", "Unable to invoke method", (Throwable) paramObject);
            }
        }
        return null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/commons/internal/ApplicationFocusManager$b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */