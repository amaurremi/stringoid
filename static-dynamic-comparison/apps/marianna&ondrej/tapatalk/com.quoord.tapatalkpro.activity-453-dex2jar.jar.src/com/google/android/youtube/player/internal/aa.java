package com.google.android.youtube.player.internal;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.View;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public final class aa
        extends y {
    private static final Class<?>[] a = {Context.class, AttributeSet.class};
    private final Resources b;
    private final LayoutInflater c;
    private final Resources.Theme d;

    public aa(Activity paramActivity, Resources paramResources, ClassLoader paramClassLoader, int paramInt) {
        super(paramActivity);
        this.b = ((Resources) ac.a(paramResources, "resources cannot be null"));
        paramActivity = ((LayoutInflater) super.getSystemService("layout_inflater")).cloneInContext(this);
        paramActivity.setFactory(new a(paramClassLoader));
        this.c = paramActivity;
        this.d = paramResources.newTheme();
        this.d.applyStyle(paramInt, false);
    }

    public final Context getApplicationContext() {
        return super.getApplicationContext();
    }

    public final Context getBaseContext() {
        return super.getBaseContext();
    }

    public final Resources getResources() {
        return this.b;
    }

    public final Object getSystemService(String paramString) {
        if ("layout_inflater".equals(paramString)) {
            return this.c;
        }
        return super.getSystemService(paramString);
    }

    public final Resources.Theme getTheme() {
        return this.d;
    }

    private static final class a
            implements LayoutInflater.Factory {
        private final ClassLoader a;

        public a(ClassLoader paramClassLoader) {
            this.a = ((ClassLoader) ac.a(paramClassLoader, "remoteClassLoader cannot be null"));
        }

        public final View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet) {
            try {
                paramString = (View) this.a.loadClass(paramString).asSubclass(View.class).getConstructor(aa.a()).newInstance(new Object[]{paramContext, paramAttributeSet});
                return paramString;
            } catch (NoClassDefFoundError paramString) {
                return null;
            } catch (ClassNotFoundException paramString) {
                return null;
            } catch (NoSuchMethodException paramString) {
                return null;
            } catch (IllegalArgumentException paramString) {
                return null;
            } catch (InstantiationException paramString) {
                return null;
            } catch (IllegalAccessException paramString) {
                return null;
            } catch (InvocationTargetException paramString) {
            }
            return null;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/youtube/player/internal/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */