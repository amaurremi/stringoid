package com.flurry.sdk;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

@kb
public class pn
        extends pw<Object>
        implements jt {
    protected final Method a;
    protected jk<Object> b;
    protected final is c;
    protected boolean d;

    public pn(Method paramMethod, jk<Object> paramjk, is paramis) {
        super(Object.class);
        this.a = paramMethod;
        this.b = paramjk;
        this.c = paramis;
    }

    public void a(jw paramjw)
            throws jh {
        if ((this.b == null) && ((paramjw.a(ju.a.h)) || (Modifier.isFinal(this.a.getReturnType().getModifiers())))) {
            sh localsh = paramjw.a(this.a.getGenericReturnType());
            this.b = paramjw.a(localsh, false, this.c);
            this.d = a(localsh, this.b);
        }
    }

    public void a(Object paramObject, hf paramhf, jw paramjw)
            throws IOException, he {
        try {
            Object localObject = this.a.invoke(paramObject, new Object[0]);
            if (localObject == null) {
                paramjw.a(paramhf);
                return;
            }
            jk localjk2 = this.b;
            jk localjk1 = localjk2;
            if (localjk2 == null) {
                localjk1 = paramjw.a(localObject.getClass(), true, this.c);
            }
            localjk1.a(localObject, paramhf, paramjw);
            return;
        } catch (IOException paramObject) {
            throw ((Throwable) paramObject);
            while (((paramhf instanceof InvocationTargetException)) && (paramhf.getCause() != null)) {
                paramhf = paramhf.getCause();
            }
            if ((paramhf instanceof Error)) {
                throw ((Error) paramhf);
            }
            throw jh.a(paramhf, paramObject, this.a.getName() + "()");
        } catch (Exception paramhf) {
            for (; ; ) {
            }
        }
    }

    public void a(Object paramObject, hf paramhf, jw paramjw, jz paramjz)
            throws IOException, hk {
        try {
            localObject = this.a.invoke(paramObject, new Object[0]);
            if (localObject == null) {
                paramjw.a(paramhf);
                return;
            }
            jk localjk = this.b;
            if (localjk != null) {
                if (this.d) {
                    paramjz.a(paramObject, paramhf);
                }
                localjk.a(localObject, paramhf, paramjw, paramjz);
                if (!this.d) {
                    return;
                }
                paramjz.d(paramObject, paramhf);
            }
        } catch (IOException paramObject) {
            Object localObject;
            throw ((Throwable) paramObject);
            paramjw.a(localObject.getClass(), true, this.c).a(localObject, paramhf, paramjw);
            return;
        } catch (Exception paramhf) {
            while (((paramhf instanceof InvocationTargetException)) && (paramhf.getCause() != null)) {
                paramhf = paramhf.getCause();
            }
            if ((paramhf instanceof Error)) {
                throw ((Error) paramhf);
            }
            throw jh.a(paramhf, paramObject, this.a.getName() + "()");
        }
    }

    protected boolean a(sh paramsh, jk<?> paramjk) {
        Class localClass = paramsh.p();
        if (paramsh.t()) {
            if ((localClass == Integer.TYPE) || (localClass == Boolean.TYPE) || (localClass == Double.TYPE)) {
                break label59;
            }
        }
        label59:
        while (paramjk.getClass().getAnnotation(kb.class) == null) {
            do {
                return false;
            }
            while ((localClass != String.class) && (localClass != Integer.class) && (localClass != Boolean.class) && (localClass != Double.class));
        }
        return true;
    }

    public String toString() {
        return "(@JsonValue serializer for method " + this.a.getDeclaringClass() + "#" + this.a.getName() + ")";
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/pn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */