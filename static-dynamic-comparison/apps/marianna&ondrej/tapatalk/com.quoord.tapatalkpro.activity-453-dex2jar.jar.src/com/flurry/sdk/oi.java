package com.flurry.sdk;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.HashMap;

public class oi
        implements is {
    protected final mq a;
    protected final qv b;
    protected final sh c;
    protected final Method d;
    protected final Field e;
    protected HashMap<Object, Object> f;
    protected final im g;
    protected final sh h;
    protected final jk<Object> i;
    protected ov j;
    protected final boolean k;
    protected final Object l;
    protected Class<?>[] m;
    protected jz n;
    protected sh o;

    public oi(mq parammq, qv paramqv, im paramim, sh paramsh1, jk<Object> paramjk, jz paramjz, sh paramsh2, Method paramMethod, Field paramField, boolean paramBoolean, Object paramObject) {
        this.a = parammq;
        this.b = paramqv;
        this.g = paramim;
        this.c = paramsh1;
        this.i = paramjk;
        if (paramjk == null) {
        }
        for (parammq = ov.a(); ; parammq = null) {
            this.j = parammq;
            this.n = paramjz;
            this.h = paramsh2;
            this.d = paramMethod;
            this.e = paramField;
            this.k = paramBoolean;
            this.l = paramObject;
            return;
        }
    }

    public oi(mq parammq, qv paramqv, String paramString, sh paramsh1, jk<Object> paramjk, jz paramjz, sh paramsh2, Method paramMethod, Field paramField, boolean paramBoolean, Object paramObject) {
        this(parammq, paramqv, new im(paramString), paramsh1, paramjk, paramjz, paramsh2, paramMethod, paramField, paramBoolean, paramObject);
    }

    protected oi(oi paramoi) {
        this(paramoi, paramoi.i);
    }

    protected oi(oi paramoi, jk<Object> paramjk) {
        this.i = paramjk;
        this.a = paramoi.a;
        this.b = paramoi.b;
        this.c = paramoi.c;
        this.d = paramoi.d;
        this.e = paramoi.e;
        if (paramoi.f != null) {
            this.f = new HashMap(paramoi.f);
        }
        this.g = paramoi.g;
        this.h = paramoi.h;
        this.j = paramoi.j;
        this.k = paramoi.k;
        this.l = paramoi.l;
        this.m = paramoi.m;
        this.n = paramoi.n;
        this.o = paramoi.o;
    }

    protected jk<Object> a(ov paramov, Class<?> paramClass, jw paramjw)
            throws jh {
        if (this.o != null) {
        }
        for (paramClass = paramov.a(paramjw.a(this.o, paramClass), paramjw, this); ; paramClass = paramov.a(paramClass, paramjw, this)) {
            if (paramov != paramClass.b) {
                this.j = paramClass.b;
            }
            return paramClass.a;
        }
    }

    public oi a(jk<Object> paramjk) {
        if (getClass() != oi.class) {
            throw new IllegalStateException("BeanPropertyWriter sub-class does not override 'withSerializer()'; needs to!");
        }
        return new oi(this, paramjk);
    }

    public sh a() {
        return this.c;
    }

    public final Object a(Object paramObject)
            throws Exception {
        if (this.d != null) {
            return this.d.invoke(paramObject, new Object[0]);
        }
        return this.e.get(paramObject);
    }

    public void a(sh paramsh) {
        this.o = paramsh;
    }

    public void a(Object paramObject, hf paramhf, jw paramjw)
            throws Exception {
        Object localObject = a(paramObject);
        if (localObject == null) {
            if (!this.k) {
                paramhf.a(this.g);
                paramjw.a(paramhf);
            }
        }
        do {
            return;
            if (localObject == paramObject) {
                b(paramObject);
            }
        } while ((this.l != null) && (this.l.equals(localObject)));
        jk localjk = this.i;
        paramObject = localjk;
        if (localjk == null) {
            Class localClass = localObject.getClass();
            ov localov = this.j;
            localjk = localov.a(localClass);
            paramObject = localjk;
            if (localjk == null) {
                paramObject = a(localov, localClass, paramjw);
            }
        }
        paramhf.a(this.g);
        if (this.n == null) {
            ((jk) paramObject).a(localObject, paramhf, paramjw);
            return;
        }
        ((jk) paramObject).a(localObject, paramhf, paramjw, this.n);
    }

    public void a(Class<?>[] paramArrayOfClass) {
        this.m = paramArrayOfClass;
    }

    public mq b() {
        return this.a;
    }

    protected void b(Object paramObject)
            throws jh {
        throw new jh("Direct self-reference leading to cycle");
    }

    public oi c() {
        return new oz(this);
    }

    public String d() {
        return this.g.a();
    }

    public boolean e() {
        return this.i != null;
    }

    public sh f() {
        return this.h;
    }

    public Type g() {
        if (this.d != null) {
            return this.d.getGenericReturnType();
        }
        return this.e.getGenericType();
    }

    public Class<?>[] h() {
        return this.m;
    }

    public String toString() {
        StringBuilder localStringBuilder = new StringBuilder(40);
        localStringBuilder.append("property '").append(d()).append("' (");
        if (this.d != null) {
            localStringBuilder.append("via method ").append(this.d.getDeclaringClass().getName()).append("#").append(this.d.getName());
            if (this.i != null) {
                break label135;
            }
            localStringBuilder.append(", no static serializer");
        }
        for (; ; ) {
            localStringBuilder.append(')');
            return localStringBuilder.toString();
            localStringBuilder.append("field \"").append(this.e.getDeclaringClass().getName()).append("#").append(this.e.getName());
            break;
            label135:
            localStringBuilder.append(", static serializer of type " + this.i.getClass().getName());
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/oi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */