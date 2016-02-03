package com.google.android.youtube.player.internal;

import java.lang.reflect.Field;

public final class v<T>
        extends u.a {
    private final T a;

    private v(T paramT) {
        this.a = paramT;
    }

    public static <T> u a(T paramT) {
        return new v(paramT);
    }

    public static <T> T a(u paramu) {
        if ((paramu instanceof v)) {
            return (T) ((v) paramu).a;
        }
        paramu = paramu.asBinder();
        Object localObject = paramu.getClass().getDeclaredFields();
        if (localObject.length == 1) {
            localObject = localObject[0];
            if (!((Field) localObject).isAccessible()) {
                ((Field) localObject).setAccessible(true);
                try {
                    paramu = ((Field) localObject).get(paramu);
                    return paramu;
                } catch (NullPointerException paramu) {
                    throw new IllegalArgumentException("Binder object is null.", paramu);
                } catch (IllegalArgumentException paramu) {
                    throw new IllegalArgumentException("remoteBinder is the wrong class.", paramu);
                } catch (IllegalAccessException paramu) {
                    throw new IllegalArgumentException("Could not access the field in remoteBinder.", paramu);
                }
            }
            throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly one declared *private* field for the wrapped object. Preferably, this is an instance of the ObjectWrapper<T> class.");
        }
        throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly *one* declared private field for the wrapped object.  Preferably, this is an instance of the ObjectWrapper<T> class.");
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/youtube/player/internal/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */