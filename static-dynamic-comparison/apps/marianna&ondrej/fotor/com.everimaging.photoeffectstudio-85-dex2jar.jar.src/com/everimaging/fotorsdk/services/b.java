package com.everimaging.fotorsdk.services;

import android.content.Context;
import com.everimaging.fotorsdk.log.FotorLoggerFactory;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.LoggerType;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.c;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public class b {
    private static final String a = b.class.getSimpleName();
    private static final FotorLoggerFactory.c b = FotorLoggerFactory.a(a, FotorLoggerFactory.LoggerType.CONSOLE);
    private static b c;
    private static boolean d;
    private HashMap<String, Class<BaseService>> e;
    private HashMap<String, BaseService> f;
    private Context g;

    private BaseService a(String paramString, Context paramContext)
            throws IllegalAccessException, InstantiationException {

        if (this.e.containsKey(paramString)) {
            paramString = (Class) this.e.get(paramString);
        }
        try {
            paramString = (BaseService) paramString.getConstructor(new Class[]{Context.class}).newInstance(new Object[]{paramContext});
            return paramString;
        } catch (SecurityException paramString) {
            paramString.printStackTrace();
            return null;
        } catch (NoSuchMethodException paramString) {
            for (; ; ) {
                paramString.printStackTrace();
            }
        } catch (IllegalArgumentException paramString) {
            for (; ; ) {
                paramString.printStackTrace();
            }
        } catch (InvocationTargetException paramString) {
            for (; ; ) {
                paramString.printStackTrace();
            }
        }
    }

    public static b a() {
        if (c == null) {
            c = new b();
        }
        return c;
    }

    private static void b() {
        if (!d) {
            throw new IllegalStateException("You must initial service manager first.");
        }
    }

    public void a(Context paramContext) {
        if (!d) {
            d = true;
            this.g = paramContext;
            this.e = new HashMap();
            this.f = new HashMap();
            a(ThreadPoolService.class);
            a(PluginService.class);
            paramContext = (PluginService) b(PluginService.class);
            if (paramContext != null) {
                paramContext.a(null, null, null);
            }
        }
    }

    public void a(BaseService paramBaseService) {
        b();
        this.f.put(paramBaseService.getClass().getName(), paramBaseService);
    }

    public void a(Class<?> paramClass) {
        b();
        this.e.put(paramClass.getName(), paramClass);
    }

    public BaseService b(Class<? extends BaseService> paramClass) {
        b();
        paramClass = paramClass.getName();
        Object localObject;
        if (this.f.containsKey(paramClass)) {
            localObject = (BaseService) this.f.get(paramClass);
        }
        for (; ; ) {
            return (BaseService) localObject;
            try {
                paramClass = a(paramClass, this.g);
                localObject = paramClass;
                if (paramClass == null) {
                    continue;
                }
                a(paramClass);
                return paramClass;
            } catch (IllegalAccessException paramClass) {
                for (; ; ) {
                    paramClass.printStackTrace();
                    paramClass = null;
                }
            } catch (InstantiationException paramClass) {
                for (; ; ) {
                    paramClass.printStackTrace();
                    paramClass = null;
                }
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/services/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */