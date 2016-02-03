package org.b.d.a;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.b.a.c;
import org.b.d.a.a.g;
import org.b.d.al;
import org.b.d.q;

public class h
        extends j {
    private static Logger b = Logger.getLogger(h.class.getName());

    public h(al paramal) {
        super(paramal, null);
    }

    private int a(org.b.d.a.a.k paramk) {
        int i = b(paramk.g());
        if (i >= 0) {
            return i;
        }
        return b(paramk.f());
    }

    private q a(Method paramMethod) {
        if (a(paramMethod, org.b.a.b.class)) {
            return q.a;
        }
        if (a(paramMethod, org.b.a.i.class)) {
            return q.b;
        }
        if (a(paramMethod, org.b.a.h.class)) {
            return q.c;
        }
        return q.d;
    }

    private q a(d paramd, q paramq) {
        q localq = a(paramd.a().g());
        if (localq != q.d) {
            paramq = localq;
        }
        do {
            return paramq;
            paramd = a(paramd.a().f());
        } while (paramd == q.d);
        return paramd;
    }

    private int b(Method paramMethod) {
        paramMethod = (c) paramMethod.getAnnotation(c.class);
        if (paramMethod == null) {
            return -1;
        }
        return paramMethod.a();
    }

    private boolean b(org.b.d.a.a.k paramk) {
        if (paramk == null) {
        }
        Method localMethod;
        do {
            return true;
            localMethod = paramk.g();
            paramk = paramk.f();
        }
        while ((localMethod == null) || (paramk == null) || (!Modifier.isPublic(localMethod.getModifiers())) || (!Modifier.isPublic(paramk.getModifiers())) || (a(localMethod, org.b.a.b.class)) || (a(paramk, org.b.a.b.class)));
        return false;
    }

    public f[] a(Class<?> paramClass, q paramq) {
        int m = 0;
        org.b.d.a.a.k localk;
        try {
            localObject = g.a(paramClass);
            paramClass = ((org.b.d.a.a.b) localObject).a();
            localObject = new ArrayList();
            i = 0;
            while (i < paramClass.length) {
                localk = paramClass[i];
                if (!b(localk)) {
                    ((ArrayList) localObject).add(localk);
                }
                i += 1;
            }
            paramClass = new org.b.d.a.a.k[((ArrayList) localObject).size()];
        } catch (org.b.d.a.a.f paramq) {
            throw new n("Class must be java beans class:" + paramClass.getName());
        }
        ((ArrayList) localObject).toArray(paramClass);
        Object localObject = new d[paramClass.length];
        int i = 0;
        while (i < paramClass.length) {
            localk = paramClass[i];
            j = a(localk);
            if (j >= 0) {
                if (localObject[j] != null) {
                    throw new n("duplicated index: " + j);
                }
                if (j >= localObject.length) {
                    throw new n("invalid index: " + j);
                }
                localObject[j] = new d(localk);
                paramClass[j] = null;
            }
            i += 1;
        }
        int j = 0;
        int k;
        for (i = 0; ; i = k) {
            k = m;
            if (j >= paramClass.length) {
                break;
            }
            localk = paramClass[j];
            k = i;
            if (localk != null) {
                while (localObject[i] != null) {
                    i += 1;
                }
                localObject[i] = new d(localk);
                k = i;
            }
            j += 1;
        }
        while (k < localObject.length) {
            paramClass = localObject[k];
            paramClass.a(a(paramClass, paramq));
            k += 1;
        }
        return (f[]) localObject;
    }

    protected m[] a(f[] paramArrayOff) {
        m[] arrayOfm = new m[paramArrayOff.length];
        int i = 0;
        if (i < paramArrayOff.length) {
            f localf = paramArrayOff[i];
            if (localf.c().isPrimitive()) {
                arrayOfm[i] = new i(localf);
            }
            for (; ; ) {
                i += 1;
                break;
                arrayOfm[i] = new k(localf, this.a.a(localf.d()));
            }
        }
        return arrayOfm;
    }

    public boolean b(Type paramType, boolean paramBoolean) {
        paramType = (Class) paramType;
        paramBoolean = a(paramType, paramBoolean);
        if ((paramBoolean) && (b.isLoggable(Level.FINE))) {
            b.fine("matched type: " + paramType.getName());
        }
        return paramBoolean;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/org/b/d/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */