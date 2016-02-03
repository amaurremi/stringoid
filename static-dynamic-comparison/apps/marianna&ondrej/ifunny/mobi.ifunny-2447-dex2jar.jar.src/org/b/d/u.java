package org.b.d;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class u
        implements v {
    Constructor<? extends aj> a;

    public u(al paramal, Class<? extends aj> paramClass) {
        try {
            this.a = paramClass.getConstructor(new Class[]{aj.class, aj.class});
            this.a.newInstance(new Object[]{new b(paramal), new b(paramal)});
            return;
        } catch (NoSuchMethodException paramal) {
            throw new IllegalArgumentException(paramal);
        } catch (InvocationTargetException paramal) {
            throw new IllegalArgumentException(paramal);
        } catch (IllegalAccessException paramal) {
            throw new IllegalArgumentException(paramal);
        } catch (InstantiationException paramal) {
            throw new IllegalArgumentException(paramal);
        }
    }

    public aj a(aj[] paramArrayOfaj) {
        try {
            paramArrayOfaj = (aj) this.a.newInstance((Object[]) paramArrayOfaj);
            return paramArrayOfaj;
        } catch (InvocationTargetException paramArrayOfaj) {
            throw new IllegalArgumentException(paramArrayOfaj);
        } catch (IllegalAccessException paramArrayOfaj) {
            throw new IllegalArgumentException(paramArrayOfaj);
        } catch (InstantiationException paramArrayOfaj) {
            throw new IllegalArgumentException(paramArrayOfaj);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/org/b/d/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */