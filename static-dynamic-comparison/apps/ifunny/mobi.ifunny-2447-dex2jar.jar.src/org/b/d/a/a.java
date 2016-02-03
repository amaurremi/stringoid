package org.b.d.a;

import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.b.a.b;
import org.b.a.c;
import org.b.a.d;
import org.b.a.g;
import org.b.a.h;
import org.b.a.i;
import org.b.a.j;
import org.b.d.aj;
import org.b.d.al;
import org.b.d.p;
import org.b.d.q;

public abstract class a
        implements o {
    protected al a;

    protected a(al paramal) {
        this.a = paramal;
    }

    private int a(Field paramField, int paramInt) {
        paramField = (c) paramField.getAnnotation(c.class);
        if (paramField == null) {
            return paramInt + 1;
        }
        return paramField.a();
    }

    private q a(Field paramField, q paramq) {
        int i = paramField.getModifiers();
        q localq;
        if ((Modifier.isStatic(i)) || (Modifier.isFinal(i)) || (Modifier.isTransient(i))) {
            localq = q.a;
        }
        do {
            return localq;
            if (a(paramField, b.class)) {
                return q.a;
            }
            if (a(paramField, i.class)) {
                return q.b;
            }
            if (a(paramField, h.class)) {
                return q.c;
            }
            localq = paramq;
        } while (paramq != q.d);
        if (paramField.getType().isPrimitive()) {
            return q.c;
        }
        return q.b;
    }

    public static boolean a(Class<?> paramClass, Class<? extends Annotation> paramClass1) {
        return paramClass.getAnnotation(paramClass1) != null;
    }

    public static boolean a(Class<?> paramClass, boolean paramBoolean) {
        boolean bool1 = true;
        boolean bool2 = false;
        if (paramBoolean) {
            if (!a(paramClass, d.class)) {
                paramBoolean = bool2;
                if (!a(paramClass, org.b.a.f.class)) {
                }
            } else {
                paramBoolean = true;
            }
            return paramBoolean;
        }
        if ((!paramClass.isEnum()) && (!paramClass.isInterface())) {
        }
        for (paramBoolean = bool1; ; paramBoolean = false) {
            return paramBoolean;
        }
    }

    public static boolean a(AccessibleObject paramAccessibleObject, Class<? extends Annotation> paramClass) {
        return paramAccessibleObject.getAnnotation(paramClass) != null;
    }

    public static boolean a(Type paramType, boolean paramBoolean) {
        boolean bool = false;
        Class localClass = (Class) paramType;
        if (paramBoolean) {
            return (a((Class) paramType, org.b.a.a.class)) || (a((Class) paramType, org.b.a.e.class));
        }
        if (localClass.isEnum()) {
            paramBoolean = bool;
            if (localClass.isInterface()) {
            }
        } else {
            paramBoolean = true;
        }
        return paramBoolean;
    }

    public static boolean b(Class<?> paramClass, boolean paramBoolean) {
        if ((paramClass instanceof GenericArrayType)) {
            return true;
        }
        return paramClass.isArray();
    }

    private f[] b(Class<?> paramClass, org.b.d.o paramo) {
        paramo = paramo.a();
        f[] arrayOff = new f[paramo.size()];
        int i = 0;
        if (i < paramo.size()) {
            p localp = (p) paramo.get(i);
            if (localp.c()) {
            }
            for (; ; ) {
                try {
                    arrayOff[i] = new e(paramClass.getDeclaredField(localp.a()), localp.b());
                    i += 1;
                } catch (SecurityException paramClass) {
                    throw new n(paramClass);
                } catch (NoSuchFieldException paramClass) {
                    throw new n(paramClass);
                }
                arrayOff[i] = new e();
            }
        }
        return arrayOff;
    }

    public static boolean c(Class<?> paramClass, boolean paramBoolean) {
        if (paramBoolean) {
            return (a(paramClass, j.class)) || (a(paramClass, g.class));
        }
        return paramClass.isEnum();
    }

    private Field[] c(Class<?> paramClass) {
        ArrayList localArrayList = new ArrayList();
        int i = 0;
        Field[] arrayOfField;
        while (paramClass != Object.class) {
            arrayOfField = paramClass.getDeclaredFields();
            i += arrayOfField.length;
            localArrayList.add(arrayOfField);
            paramClass = paramClass.getSuperclass();
        }
        paramClass = new Field[i];
        i = localArrayList.size() - 1;
        int j = 0;
        while (i >= 0) {
            arrayOfField = (Field[]) localArrayList.get(i);
            System.arraycopy(arrayOfField, 0, paramClass, j, arrayOfField.length);
            j += arrayOfField.length;
            i -= 1;
        }
        return paramClass;
    }

    public <T> aj<T> a(Class<T> paramClass, org.b.d.o paramo) {
        a(paramClass);
        return a(paramClass, b(paramClass, paramo));
    }

    protected abstract <T> aj<T> a(Class<T> paramClass, f[] paramArrayOff);

    public <T> aj<T> a(Type paramType) {
        paramType = (Class) paramType;
        a(paramType);
        return a(paramType, a(paramType, b(paramType)));
    }

    protected void a(Class<?> paramClass) {
        if (Modifier.isAbstract(paramClass.getModifiers())) {
            throw new n("Cannot build template for abstract class: " + paramClass.getName());
        }
        if (paramClass.isInterface()) {
            throw new n("Cannot build template for interface: " + paramClass.getName());
        }
        if (paramClass.isArray()) {
            throw new n("Cannot build template for array class: " + paramClass.getName());
        }
        if (paramClass.isPrimitive()) {
            throw new n("Cannot build template of primitive type: " + paramClass.getName());
        }
    }

    protected f[] a(Class<?> paramClass, q paramq) {
        Object localObject = c(paramClass);
        paramClass = new ArrayList();
        int j = -1;
        int n = localObject.length;
        int i = 0;
        if (i < n) {
            Field localField = localObject[i];
            q localq = a(localField, paramq);
            int k;
            if (localq == q.a) {
                k = j;
            }
            for (; ; ) {
                i += 1;
                j = k;
                break;
                int m = a(localField, j);
                if ((paramClass.size() > m) && (paramClass.get(m) != null)) {
                    throw new n("duplicated index: " + m);
                }
                if (m < 0) {
                    throw new n("invalid index: " + m);
                }
                while (paramClass.size() <= m) {
                    paramClass.add(null);
                }
                paramClass.set(m, new e(localField, localq));
                k = j;
                if (j < m) {
                    k = m;
                }
            }
        }
        paramq = new f[j + 1];
        i = 0;
        if (i < paramClass.size()) {
            localObject = (f) paramClass.get(i);
            if (localObject == null) {
                paramq[i] = new e();
            }
            for (; ; ) {
                i += 1;
                break;
                paramq[i] = localObject;
            }
        }
        return paramq;
    }

    public <T> aj<T> b(Type paramType) {
        return null;
    }

    protected q b(Class<?> paramClass) {
        d locald = (d) paramClass.getAnnotation(d.class);
        if (locald == null) {
            return q.d;
        }
        if ((org.b.a.f) paramClass.getAnnotation(org.b.a.f.class) == null) {
            return q.d;
        }
        return locald.a();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/org/b/d/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */