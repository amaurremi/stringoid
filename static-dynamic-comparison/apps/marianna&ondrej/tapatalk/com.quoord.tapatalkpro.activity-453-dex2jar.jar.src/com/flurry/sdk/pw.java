package com.flurry.sdk;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public abstract class pw<T>
        extends jk<T> {
    protected final Class<T> k;

    protected pw(sh paramsh) {
        this.k = paramsh.p();
    }

    protected pw(Class<T> paramClass) {
        this.k = paramClass;
    }

    protected pw(Class<?> paramClass, boolean paramBoolean) {
        this.k = paramClass;
    }

    public void a(jw paramjw, Throwable paramThrowable, Object paramObject, int paramInt)
            throws IOException {
        while (((paramThrowable instanceof InvocationTargetException)) && (paramThrowable.getCause() != null)) {
            paramThrowable = paramThrowable.getCause();
        }
        if ((paramThrowable instanceof Error)) {
            throw ((Error) paramThrowable);
        }
        if ((paramjw == null) || (paramjw.a(ju.a.n))) {
        }
        for (int i = 1; (paramThrowable instanceof IOException); i = 0) {
            if ((i != 0) && ((paramThrowable instanceof jh))) {
                break label98;
            }
            throw ((IOException) paramThrowable);
        }
        if ((i == 0) && ((paramThrowable instanceof RuntimeException))) {
            throw ((RuntimeException) paramThrowable);
        }
        label98:
        throw jh.a(paramThrowable, paramObject, paramInt);
    }

    public void a(jw paramjw, Throwable paramThrowable, Object paramObject, String paramString)
            throws IOException {
        while (((paramThrowable instanceof InvocationTargetException)) && (paramThrowable.getCause() != null)) {
            paramThrowable = paramThrowable.getCause();
        }
        if ((paramThrowable instanceof Error)) {
            throw ((Error) paramThrowable);
        }
        if ((paramjw == null) || (paramjw.a(ju.a.n))) {
        }
        for (int i = 1; (paramThrowable instanceof IOException); i = 0) {
            if ((i != 0) && ((paramThrowable instanceof jh))) {
                break label98;
            }
            throw ((IOException) paramThrowable);
        }
        if ((i == 0) && ((paramThrowable instanceof RuntimeException))) {
            throw ((RuntimeException) paramThrowable);
        }
        label98:
        throw jh.a(paramThrowable, paramObject, paramString);
    }

    public abstract void a(T paramT, hf paramhf, jw paramjw)
            throws IOException, he;

    protected boolean a(jk<?> paramjk) {
        return (paramjk != null) && (paramjk.getClass().getAnnotation(kb.class) != null);
    }

    public final Class<T> c() {
        return this.k;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/pw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */