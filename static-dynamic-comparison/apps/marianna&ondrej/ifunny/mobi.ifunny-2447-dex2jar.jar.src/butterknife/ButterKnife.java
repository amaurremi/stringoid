package butterknife;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.util.Log;
import android.util.Property;
import android.view.View;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class ButterKnife {
    static final Map<Class<?>, Method> INJECTORS;
    static final Method NO_OP = null;
    static final Map<Class<?>, Method> RESETTERS;
    private static final String TAG = "ButterKnife";
    private static boolean debug = false;

    static {
        INJECTORS = new LinkedHashMap();
        RESETTERS = new LinkedHashMap();
    }

    private ButterKnife() {
        throw new AssertionError("No instances.");
    }

    @TargetApi(14)
    public static <T extends View, V> void apply(List<T> paramList, Property<? super T, V> paramProperty, V paramV) {
        int i = 0;
        int j = paramList.size();
        while (i < j) {
            paramProperty.set(paramList.get(i), paramV);
            i += 1;
        }
    }

    public static <T extends View> void apply(List<T> paramList, ButterKnife.Action<? super T> paramAction) {
        int j = paramList.size();
        int i = 0;
        while (i < j) {
            paramAction.apply((View) paramList.get(i), i);
            i += 1;
        }
    }

    public static <T extends View, V> void apply(List<T> paramList, ButterKnife.Setter<? super T, V> paramSetter, V paramV) {
        int j = paramList.size();
        int i = 0;
        while (i < j) {
            paramSetter.set((View) paramList.get(i), paramV, i);
            i += 1;
        }
    }

    public static <T extends View> T findById(Activity paramActivity, int paramInt) {
        return paramActivity.findViewById(paramInt);
    }

    public static <T extends View> T findById(View paramView, int paramInt) {
        return paramView.findViewById(paramInt);
    }

    private static Method findInjectorForClass(Class<?> paramClass) {
        Object localObject = (Method) INJECTORS.get(paramClass);
        if (localObject != null) {
            if (debug) {
                Log.d("ButterKnife", "HIT: Cached in injector map.");
            }
            return (Method) localObject;
        }
        localObject = paramClass.getName();
        if ((((String) localObject).startsWith("android.")) || (((String) localObject).startsWith("java."))) {
            if (debug) {
                Log.d("ButterKnife", "MISS: Reached framework class. Abandoning search.");
            }
            return NO_OP;
        }
        try {
            Method localMethod2 = Class.forName((String) localObject + "$$ViewInjector").getMethod("inject", new Class[]{ButterKnife.Finder.class, paramClass, Object.class});
            localObject = localMethod2;
            if (debug) {
                Log.d("ButterKnife", "HIT: Class loaded injection class.");
                localObject = localMethod2;
            }
        } catch (ClassNotFoundException localClassNotFoundException) {
            for (; ; ) {
                if (debug) {
                    Log.d("ButterKnife", "Not found. Trying superclass " + paramClass.getSuperclass().getName());
                }
                Method localMethod1 = findInjectorForClass(paramClass.getSuperclass());
            }
        }
        INJECTORS.put(paramClass, localObject);
        return (Method) localObject;
    }

    private static Method findResettersForClass(Class<?> paramClass) {
        Object localObject = (Method) RESETTERS.get(paramClass);
        if (localObject != null) {
            if (debug) {
                Log.d("ButterKnife", "HIT: Cached in injector map.");
            }
            return (Method) localObject;
        }
        localObject = paramClass.getName();
        if ((((String) localObject).startsWith("android.")) || (((String) localObject).startsWith("java."))) {
            if (debug) {
                Log.d("ButterKnife", "MISS: Reached framework class. Abandoning search.");
            }
            return NO_OP;
        }
        try {
            Method localMethod2 = Class.forName((String) localObject + "$$ViewInjector").getMethod("reset", new Class[]{paramClass});
            localObject = localMethod2;
            if (debug) {
                Log.d("ButterKnife", "HIT: Class loaded injection class.");
                localObject = localMethod2;
            }
        } catch (ClassNotFoundException localClassNotFoundException) {
            for (; ; ) {
                if (debug) {
                    Log.d("ButterKnife", "Not found. Trying superclass " + paramClass.getSuperclass().getName());
                }
                Method localMethod1 = findResettersForClass(paramClass.getSuperclass());
            }
        }
        RESETTERS.put(paramClass, localObject);
        return (Method) localObject;
    }

    public static void inject(Activity paramActivity) {
        inject(paramActivity, paramActivity, ButterKnife.Finder.ACTIVITY);
    }

    public static void inject(Dialog paramDialog) {
        inject(paramDialog, paramDialog, ButterKnife.Finder.DIALOG);
    }

    public static void inject(View paramView) {
        inject(paramView, paramView, ButterKnife.Finder.VIEW);
    }

    public static void inject(Object paramObject, Activity paramActivity) {
        inject(paramObject, paramActivity, ButterKnife.Finder.ACTIVITY);
    }

    public static void inject(Object paramObject, Dialog paramDialog) {
        inject(paramObject, paramDialog, ButterKnife.Finder.DIALOG);
    }

    public static void inject(Object paramObject, View paramView) {
        inject(paramObject, paramView, ButterKnife.Finder.VIEW);
    }

    static void inject(Object paramObject1, Object paramObject2, ButterKnife.Finder paramFinder) {
        Object localObject = paramObject1.getClass();
        try {
            if (debug) {
                Log.d("ButterKnife", "Looking up view injector for " + ((Class) localObject).getName());
            }
            localObject = findInjectorForClass((Class) localObject);
            if (localObject != null) {
                ((Method) localObject).invoke(null, new Object[]{paramFinder, paramObject1, paramObject2});
            }
            return;
        } catch (RuntimeException paramObject1) {
            throw ((Throwable) paramObject1);
        } catch (Exception paramFinder) {
            paramObject2 = paramFinder;
            if ((paramFinder instanceof InvocationTargetException)) {
                paramObject2 = paramFinder.getCause();
            }
            throw new RuntimeException("Unable to inject views for " + paramObject1, (Throwable) paramObject2);
        }
    }

    public static void reset(Object paramObject) {
        Object localObject = paramObject.getClass();
        try {
            if (debug) {
                Log.d("ButterKnife", "Looking up view injector for " + ((Class) localObject).getName());
            }
            localObject = findResettersForClass((Class) localObject);
            if (localObject != null) {
                ((Method) localObject).invoke(null, new Object[]{paramObject});
            }
            return;
        } catch (RuntimeException paramObject) {
            throw ((Throwable) paramObject);
        } catch (Exception localException) {
            localObject = localException;
            if ((localException instanceof InvocationTargetException)) {
                localObject = localException.getCause();
            }
            throw new RuntimeException("Unable to reset views for " + paramObject, (Throwable) localObject);
        }
    }

    public static void setDebug(boolean paramBoolean) {
        debug = paramBoolean;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/butterknife/ButterKnife.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */