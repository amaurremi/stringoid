package com.flurry.sdk;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Map;

public class op {
    protected final ju a;
    protected final mw b;
    protected final kg.a c;
    protected final iq d;
    protected Object e;

    public op(ju paramju, mw parammw) {
        this.a = paramju;
        this.b = parammw;
        this.c = parammw.a(paramju.g());
        this.d = this.a.a();
    }

    protected oi a(String paramString, sh paramsh, jk<Object> paramjk, jz paramjz1, jz paramjz2, mq parammq, boolean paramBoolean) {
        Method localMethod;
        if ((parammq instanceof mp)) {
            localMethod = null;
        }
        Object localObject;
        for (Field localField = ((mp) parammq).e(); ; localField = null) {
            localsh = a(parammq, paramBoolean, paramsh);
            if (paramjz2 == null) {
                break label397;
            }
            localObject = localsh;
            if (localsh == null) {
                localObject = paramsh;
            }
            if (((sh) localObject).g() != null) {
                break;
            }
            throw new IllegalStateException("Problem trying to create BeanPropertyWriter for property '" + paramString + "' (of type " + this.b.a() + "); serialization type " + localObject + " has no content");
            localMethod = ((mr) parammq).e();
        }
        sh localsh = ((sh) localObject).e(paramjz2);
        localsh.g();
        label397:
        for (; ; ) {
            localObject = null;
            paramBoolean = false;
            boolean bool2 = false;
            kg.a locala = this.d.a(parammq, this.c);
            boolean bool1 = bool2;
            paramjz2 = (jz) localObject;
            if (locala != null) {
            }
            switch (1. a[locala.ordinal()])
            {
                default:
                    paramjz2 = (jz) localObject;
                    bool1 = bool2;
                    paramBoolean = bool1;
            }
            for (; ; ) {
                paramsh = new oi(parammq, this.b.i(), paramString, paramsh, paramjk, paramjz1, localsh, localMethod, localField, paramBoolean, paramjz2);
                paramjk = this.d.b(parammq);
                paramString = paramsh;
                if (paramjk != null) {
                    paramString = paramsh;
                    if (paramjk.booleanValue()) {
                        paramString = paramsh.c();
                    }
                }
                return paramString;
                localObject = a(paramString, localMethod, localField);
                if (localObject == null) {
                    paramBoolean = true;
                    paramjz2 = (jz) localObject;
                } else {
                    bool1 = bool2;
                    paramjz2 = (jz) localObject;
                    if (!localObject.getClass().isArray()) {
                        break;
                    }
                    paramjz2 = qz.a(localObject);
                    paramBoolean = false;
                    continue;
                    paramjz2 = b(paramString, paramsh);
                    paramBoolean = true;
                    continue;
                    paramBoolean = true;
                    bool1 = paramBoolean;
                    paramjz2 = (jz) localObject;
                    if (!paramsh.f()) {
                        break;
                    }
                    paramjz2 = a(paramString, paramsh);
                }
            }
        }
    }

    public qv a() {
        return this.b.i();
    }

    protected sh a(mm parammm, boolean paramBoolean, sh paramsh) {
        boolean bool = true;
        Object localObject = this.d.e(parammm);
        Class localClass;
        if (localObject != null) {
            localClass = paramsh.p();
            if (((Class) localObject).isAssignableFrom(localClass)) {
                paramsh = paramsh.h((Class) localObject);
                paramBoolean = true;
            }
        }
        for (; ; ) {
            localObject = ol.b(this.a, parammm, paramsh);
            if (localObject != paramsh) {
                paramsh = (sh) localObject;
                paramBoolean = true;
            }
            for (; ; ) {
                if (!paramBoolean) {
                    parammm = this.d.f(parammm);
                    if (parammm != null) {
                        if (parammm == kg.b.b) {
                            paramBoolean = bool;
                        }
                    }
                }
                for (; ; ) {
                    if (paramBoolean) {
                        return paramsh;
                        if (!localClass.isAssignableFrom((Class) localObject)) {
                            throw new IllegalArgumentException("Illegal concrete-type annotation for method '" + parammm.b() + "': class " + ((Class) localObject).getName() + " not a super-type of (declared) class " + localClass.getName());
                        }
                        paramsh = this.a.a(paramsh, (Class) localObject);
                        break;
                        paramBoolean = false;
                        continue;
                    }
                    return null;
                }
            }
        }
    }

    protected Object a(Exception paramException, String paramString, Object paramObject) {
        while (paramException.getCause() != null) {
            paramException = paramException.getCause();
        }
        if ((paramException instanceof Error)) {
            throw ((Error) paramException);
        }
        if ((paramException instanceof RuntimeException)) {
            throw ((RuntimeException) paramException);
        }
        throw new IllegalArgumentException("Failed to get property '" + paramString + "' of default " + paramObject.getClass().getName() + " instance");
    }

    protected Object a(String paramString, sh paramsh) {
        if (!this.a.a(ju.a.w)) {
            if (paramsh.b()) {
                return new a();
            }
            if (Collection.class.isAssignableFrom(paramsh.p())) {
                return new b();
            }
        }
        return null;
    }

    protected Object a(String paramString, Method paramMethod, Field paramField) {
        Object localObject = b();
        if (paramMethod != null) {
        }
        try {
            return paramMethod.invoke(localObject, new Object[0]);
        } catch (Exception paramMethod) {
        }
        paramMethod = paramField.get(localObject);
        return paramMethod;
        return a(paramMethod, paramString, localObject);
    }

    protected Object b() {
        if (this.e == null) {
            this.e = this.b.a(this.a.a(ju.a.e));
            if (this.e == null) {
                Class localClass = this.b.c().e();
                throw new IllegalArgumentException("Class " + localClass.getName() + " has no default constructor; can not instantiate default bean value to support 'properties=JsonSerialize.Inclusion.NON_DEFAULT' annotation");
            }
        }
        return this.e;
    }

    protected Object b(String paramString, sh paramsh) {
        paramString = paramsh.p();
        if (paramString == String.class) {
            return new d();
        }
        if (paramsh.b()) {
            return new a();
        }
        if (Collection.class.isAssignableFrom(paramString)) {
            return new b();
        }
        if (Map.class.isAssignableFrom(paramString)) {
            return new c();
        }
        return null;
    }

    public static class a {
        public boolean equals(Object paramObject) {
            return (paramObject == null) || (Array.getLength(paramObject) == 0);
        }
    }

    public static class b {
        public boolean equals(Object paramObject) {
            return (paramObject == null) || (((Collection) paramObject).size() == 0);
        }
    }

    public static class c {
        public boolean equals(Object paramObject) {
            return (paramObject == null) || (((Map) paramObject).size() == 0);
        }
    }

    public static class d {
        public boolean equals(Object paramObject) {
            return (paramObject == null) || (((String) paramObject).length() == 0);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/op.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */