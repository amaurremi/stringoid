package android.support.v4.preference;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;
import android.util.Log;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class PreferenceManagerCompat {
    private static final String TAG = PreferenceManagerCompat.class.getSimpleName();

    static void dispatchActivityDestroy(PreferenceManager paramPreferenceManager) {
        try {
            Method localMethod = PreferenceManager.class.getDeclaredMethod("dispatchActivityDestroy", new Class[0]);
            localMethod.setAccessible(true);
            localMethod.invoke(paramPreferenceManager, new Object[0]);
            return;
        } catch (Exception paramPreferenceManager) {
            Log.w(TAG, "Couldn't call PreferenceManager.dispatchActivityDestroy by reflection", paramPreferenceManager);
        }
    }

    static void dispatchActivityResult(PreferenceManager paramPreferenceManager, int paramInt1, int paramInt2, Intent paramIntent) {
        try {
            Method localMethod = PreferenceManager.class.getDeclaredMethod("dispatchActivityResult", new Class[]{Integer.TYPE, Integer.TYPE, Intent.class});
            localMethod.setAccessible(true);
            localMethod.invoke(paramPreferenceManager, new Object[]{Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramIntent});
            return;
        } catch (Exception paramPreferenceManager) {
            Log.w(TAG, "Couldn't call PreferenceManager.dispatchActivityResult by reflection", paramPreferenceManager);
        }
    }

    static void dispatchActivityStop(PreferenceManager paramPreferenceManager) {
        try {
            Method localMethod = PreferenceManager.class.getDeclaredMethod("dispatchActivityStop", new Class[0]);
            localMethod.setAccessible(true);
            localMethod.invoke(paramPreferenceManager, new Object[0]);
            return;
        } catch (Exception paramPreferenceManager) {
            Log.w(TAG, "Couldn't call PreferenceManager.dispatchActivityStop by reflection", paramPreferenceManager);
        }
    }

    static PreferenceScreen getPreferenceScreen(PreferenceManager paramPreferenceManager) {
        try {
            Method localMethod = PreferenceManager.class.getDeclaredMethod("getPreferenceScreen", new Class[0]);
            localMethod.setAccessible(true);
            paramPreferenceManager = (PreferenceScreen) localMethod.invoke(paramPreferenceManager, new Object[0]);
            return paramPreferenceManager;
        } catch (Exception paramPreferenceManager) {
            Log.w(TAG, "Couldn't call PreferenceManager.getPreferenceScreen by reflection", paramPreferenceManager);
        }
        return null;
    }

    static PreferenceScreen inflateFromIntent(PreferenceManager paramPreferenceManager, Intent paramIntent, PreferenceScreen paramPreferenceScreen) {
        try {
            Method localMethod = PreferenceManager.class.getDeclaredMethod("inflateFromIntent", new Class[]{Intent.class, PreferenceScreen.class});
            localMethod.setAccessible(true);
            paramPreferenceManager = (PreferenceScreen) localMethod.invoke(paramPreferenceManager, new Object[]{paramIntent, paramPreferenceScreen});
            return paramPreferenceManager;
        } catch (Exception paramPreferenceManager) {
            Log.w(TAG, "Couldn't call PreferenceManager.inflateFromIntent by reflection", paramPreferenceManager);
        }
        return null;
    }

    static PreferenceScreen inflateFromResource(PreferenceManager paramPreferenceManager, Activity paramActivity, int paramInt, PreferenceScreen paramPreferenceScreen) {
        try {
            Method localMethod = PreferenceManager.class.getDeclaredMethod("inflateFromResource", new Class[]{Context.class, Integer.TYPE, PreferenceScreen.class});
            localMethod.setAccessible(true);
            paramPreferenceManager = (PreferenceScreen) localMethod.invoke(paramPreferenceManager, new Object[]{paramActivity, Integer.valueOf(paramInt), paramPreferenceScreen});
            return paramPreferenceManager;
        } catch (Exception paramPreferenceManager) {
            Log.w(TAG, "Couldn't call PreferenceManager.inflateFromResource by reflection", paramPreferenceManager);
        }
        return null;
    }

    static PreferenceManager newInstance(Activity paramActivity, int paramInt) {
        try {
            Constructor localConstructor = PreferenceManager.class.getDeclaredConstructor(new Class[]{Activity.class, Integer.TYPE});
            localConstructor.setAccessible(true);
            paramActivity = (PreferenceManager) localConstructor.newInstance(new Object[]{paramActivity, Integer.valueOf(paramInt)});
            return paramActivity;
        } catch (Exception paramActivity) {
            Log.w(TAG, "Couldn't call constructor PreferenceManager by reflection", paramActivity);
        }
        return null;
    }

    static void setFragment(PreferenceManager paramPreferenceManager, PreferenceFragment paramPreferenceFragment) {
    }

    static void setOnPreferenceTreeClickListener(PreferenceManager paramPreferenceManager, OnPreferenceTreeClickListener paramOnPreferenceTreeClickListener) {
        try {
            Field localField = PreferenceManager.class.getDeclaredField("mOnPreferenceTreeClickListener");
            localField.setAccessible(true);
            if (paramOnPreferenceTreeClickListener != null) {
                ClassLoader localClassLoader = localField.getType().getClassLoader();
                Class localClass = localField.getType();
                paramOnPreferenceTreeClickListener = new InvocationHandler() {
                    public Object invoke(Object paramAnonymousObject, Method paramAnonymousMethod, Object[] paramAnonymousArrayOfObject) {
                        if (paramAnonymousMethod.getName().equals("onPreferenceTreeClick")) {
                            return Boolean.valueOf(this.val$listener.onPreferenceTreeClick((PreferenceScreen) paramAnonymousArrayOfObject[0], (Preference) paramAnonymousArrayOfObject[1]));
                        }
                        return null;
                    }
                };
                localField.set(paramPreferenceManager, Proxy.newProxyInstance(localClassLoader, new Class[]{localClass}, paramOnPreferenceTreeClickListener));
                return;
            }
            localField.set(paramPreferenceManager, null);
            return;
        } catch (Exception paramPreferenceManager) {
            Log.w(TAG, "Couldn't set PreferenceManager.mOnPreferenceTreeClickListener by reflection", paramPreferenceManager);
        }
    }

    static boolean setPreferences(PreferenceManager paramPreferenceManager, PreferenceScreen paramPreferenceScreen) {
        try {
            Method localMethod = PreferenceManager.class.getDeclaredMethod("setPreferences", new Class[]{PreferenceScreen.class});
            localMethod.setAccessible(true);
            boolean bool = ((Boolean) localMethod.invoke(paramPreferenceManager, new Object[]{paramPreferenceScreen})).booleanValue();
            return bool;
        } catch (Exception paramPreferenceManager) {
            Log.w(TAG, "Couldn't call PreferenceManager.setPreferences by reflection", paramPreferenceManager);
        }
        return false;
    }

    static abstract interface OnPreferenceTreeClickListener {
        public abstract boolean onPreferenceTreeClick(PreferenceScreen paramPreferenceScreen, Preference paramPreference);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/android/support/v4/preference/PreferenceManagerCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */