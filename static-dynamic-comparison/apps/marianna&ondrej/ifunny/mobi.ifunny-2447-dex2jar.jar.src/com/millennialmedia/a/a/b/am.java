package com.millennialmedia.a.a.b;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public abstract class am {
    public static am a() {
        try {
            Object localObject1 = Class.forName("sun.misc.Unsafe");
            Object localObject4 = ((Class) localObject1).getDeclaredField("theUnsafe");
            ((Field) localObject4).setAccessible(true);
            localObject4 = ((Field) localObject4).get(null);
            localObject1 = new an(((Class) localObject1).getMethod("allocateInstance", new Class[]{Class.class}), localObject4);
            return (am) localObject1;
        } catch (Exception localException1) {
            try {
                Object localObject2 = ObjectInputStream.class.getDeclaredMethod("newInstance", new Class[]{Class.class, Class.class});
                ((Method) localObject2).setAccessible(true);
                localObject2 = new ao((Method) localObject2);
                return (am) localObject2;
            } catch (Exception localException2) {
                try {
                    Object localObject3 = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", new Class[]{Class.class});
                    ((Method) localObject3).setAccessible(true);
                    int i = ((Integer) ((Method) localObject3).invoke(null, new Object[]{Object.class})).intValue();
                    localObject3 = ObjectStreamClass.class.getDeclaredMethod("newInstance", new Class[]{Class.class, Integer.TYPE});
                    ((Method) localObject3).setAccessible(true);
                    localObject3 = new ap((Method) localObject3, i);
                    return (am) localObject3;
                } catch (Exception localException3) {
                }
            }
        }
        return new aq();
    }

    public abstract <T> T a(Class<T> paramClass);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/a/a/b/am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */