package org.b.d.a;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.b.d.ad;
import org.b.d.ag;
import org.b.d.aj;
import org.b.d.al;
import org.b.d.e;
import org.b.d.g;
import org.b.d.m;
import org.b.d.o;
import org.b.d.r;
import org.b.d.w;
import org.b.d.z;

public class b
        extends a {
    private static final Logger b = Logger.getLogger(b.class.getName());

    public b(al paramal) {
        super(paramal);
    }

    private aj a(Type paramType1, Type paramType2, Class paramClass, int paramInt) {
        if (paramInt == 1) {
            if (paramClass == Boolean.TYPE) {
                return e.a();
            }
            if (paramClass == Short.TYPE) {
                return ag.a();
            }
            if (paramClass == Integer.TYPE) {
                return w.a();
            }
            if (paramClass == Long.TYPE) {
                return z.a();
            }
            if (paramClass == Float.TYPE) {
                return r.a();
            }
            if (paramClass == Double.TYPE) {
                return m.a();
            }
            if (paramClass == Byte.TYPE) {
                return g.a();
            }
            return new ad(paramClass, this.a.a(paramType2));
        }
        if (paramInt == 2) {
            return new c(Array.newInstance(paramClass, 0).getClass(), a(paramType1, paramType2, paramClass, paramInt - 1));
        }
        paramType1 = (c) a(paramType1, paramType2, paramClass, paramInt - 1);
        return new c(Array.newInstance(paramType1.a(), 0).getClass(), paramType1);
    }

    public <T> aj<T> a(Class<T> paramClass, o paramo) {
        throw new UnsupportedOperationException(paramClass.getName());
    }

    protected <T> aj<T> a(Class<T> paramClass, f[] paramArrayOff) {
        throw new UnsupportedOperationException(paramClass.getName());
    }

    public <T> aj<T> a(Type paramType) {
        int i = 1;
        Object localObject1;
        Object localObject2;
        if ((paramType instanceof GenericArrayType)) {
            localObject1 = ((GenericArrayType) paramType).getGenericComponentType();
            i = 1;
            while ((localObject1 instanceof GenericArrayType)) {
                localObject1 = ((GenericArrayType) localObject1).getGenericComponentType();
                i += 1;
            }
            if ((localObject1 instanceof ParameterizedType)) {
                localObject2 = (Class) ((ParameterizedType) localObject1).getRawType();
            }
        }
        for (; ; ) {
            return a(paramType, (Type) localObject1, (Class) localObject2, i);
            localObject2 = (Class) localObject1;
            continue;
            localObject1 = ((Class) paramType).getComponentType();
            while (((Class) localObject1).isArray()) {
                localObject1 = ((Class) localObject1).getComponentType();
                i += 1;
            }
            localObject2 = localObject1;
        }
    }

    public <T> aj<T> b(Type paramType) {
        return null;
    }

    public boolean b(Type paramType, boolean paramBoolean) {
        paramType = (Class) paramType;
        paramBoolean = a.b(paramType, false);
        if ((paramBoolean) && (b.isLoggable(Level.FINE))) {
            b.fine("matched type: " + paramType.getName());
        }
        return paramBoolean;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/org/b/d/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */