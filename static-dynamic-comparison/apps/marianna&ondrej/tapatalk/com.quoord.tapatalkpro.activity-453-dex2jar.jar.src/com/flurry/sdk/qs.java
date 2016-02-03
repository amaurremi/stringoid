package com.flurry.sdk;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class qs {
    @Deprecated
    public static final qs a = new qs();
    private static final sh[] f = new sh[0];
    protected final qt[] b = null;
    protected final qu c = new qu(this);
    protected qm d;
    protected qm e;

    public static qs a() {
        return a;
    }

    public static sh a(String paramString)
            throws IllegalArgumentException {
        return a.b(paramString);
    }

    public static sh b() {
        return a().c();
    }

    private sh b(Class<?> paramClass) {
        sh[] arrayOfsh = a(paramClass, Map.class);
        if (arrayOfsh == null) {
            return qo.a(paramClass, c(), c());
        }
        if (arrayOfsh.length != 2) {
            throw new IllegalArgumentException("Strange Map type " + paramClass.getName() + ": can not determine type parameters");
        }
        return qo.a(paramClass, arrayOfsh[0], arrayOfsh[1]);
    }

    private sh c(Class<?> paramClass) {
        sh[] arrayOfsh = a(paramClass, Collection.class);
        if (arrayOfsh == null) {
            return ql.a(paramClass, c());
        }
        if (arrayOfsh.length != 1) {
            throw new IllegalArgumentException("Strange Collection type " + paramClass.getName() + ": can not determine type parameters");
        }
        return ql.a(paramClass, arrayOfsh[0]);
    }

    protected qm a(qm paramqm) {
        try {
            if (this.d == null) {
                localqm = paramqm.a();
                a(localqm, Map.class);
                this.d = localqm.b();
            }
            qm localqm = this.d.a();
            paramqm.a(localqm);
            localqm.b(paramqm);
            return paramqm;
        } finally {
        }
    }

    protected qm a(qm paramqm, Class<?> paramClass) {
        Object localObject = paramqm.e();
        Type[] arrayOfType = ((Class) localObject).getGenericInterfaces();
        if (arrayOfType != null) {
            int j = arrayOfType.length;
            int i = 0;
            while (i < j) {
                qm localqm = b(arrayOfType[i], paramClass);
                if (localqm != null) {
                    localqm.b(paramqm);
                    paramqm.a(localqm);
                    return paramqm;
                }
                i += 1;
            }
        }
        localObject = ((Class) localObject).getGenericSuperclass();
        if (localObject != null) {
            paramClass = b((Type) localObject, paramClass);
            if (paramClass != null) {
                paramClass.b(paramqm);
                paramqm.a(paramClass);
                return paramqm;
            }
        }
        return null;
    }

    protected qm a(Type paramType, Class<?> paramClass) {
        paramType = new qm(paramType);
        Object localObject = paramType.e();
        if (localObject == paramClass) {
            return paramType;
        }
        localObject = ((Class) localObject).getGenericSuperclass();
        if (localObject != null) {
            paramClass = a((Type) localObject, paramClass);
            if (paramClass != null) {
                paramClass.b(paramType);
                paramType.a(paramClass);
                return paramType;
            }
        }
        return null;
    }

    public qo a(Class<? extends Map> paramClass, Class<?> paramClass1, Class<?> paramClass2) {
        return qo.a(paramClass, a(paramClass1), a(paramClass2));
    }

    public sh a(sh paramsh, Class<?> paramClass) {
        if (((paramsh instanceof qp)) && ((paramClass.isArray()) || (Map.class.isAssignableFrom(paramClass)) || (Collection.class.isAssignableFrom(paramClass)))) {
            if (!paramsh.p().isAssignableFrom(paramClass)) {
                throw new IllegalArgumentException("Class " + paramClass.getClass().getName() + " not subtype of " + paramsh);
            }
            Object localObject1 = a(paramClass, new qr(this, paramsh.p()));
            Object localObject2 = paramsh.n();
            paramClass = (Class<?>) localObject1;
            if (localObject2 != null) {
                paramClass = ((sh) localObject1).d(localObject2);
            }
            localObject1 = paramsh.o();
            paramsh = paramClass;
            if (localObject1 != null) {
                paramsh = paramClass.f(localObject1);
            }
            return paramsh;
        }
        return paramsh.f(paramClass);
    }

    public sh a(Class<?> paramClass) {
        return new qp(paramClass);
    }

    protected sh a(Class<?> paramClass, qr paramqr) {
        if (paramClass.isArray()) {
            return qi.a(b(paramClass.getComponentType(), null), null, null);
        }
        if (paramClass.isEnum()) {
            return new qp(paramClass);
        }
        if (Map.class.isAssignableFrom(paramClass)) {
            return b(paramClass);
        }
        if (Collection.class.isAssignableFrom(paramClass)) {
            return c(paramClass);
        }
        return new qp(paramClass);
    }

    protected sh a(Class<?> paramClass, List<sh> paramList) {
        if (paramClass.isArray()) {
            return qi.a(b(paramClass.getComponentType(), null), null, null);
        }
        if (paramClass.isEnum()) {
            return new qp(paramClass);
        }
        if (Map.class.isAssignableFrom(paramClass)) {
            if (paramList.size() > 0) {
                sh localsh = (sh) paramList.get(0);
                if (paramList.size() >= 2) {
                }
                for (paramList = (sh) paramList.get(1); ; paramList = c()) {
                    return qo.a(paramClass, localsh, paramList);
                }
            }
            return b(paramClass);
        }
        if (Collection.class.isAssignableFrom(paramClass)) {
            if (paramList.size() >= 1) {
                return ql.a(paramClass, (sh) paramList.get(0));
            }
            return c(paramClass);
        }
        if (paramList.size() == 0) {
            return new qp(paramClass);
        }
        return a(paramClass, (sh[]) paramList.toArray(new sh[paramList.size()]));
    }

    public sh a(Class<?> paramClass, sh[] paramArrayOfsh) {
        TypeVariable[] arrayOfTypeVariable = paramClass.getTypeParameters();
        if (arrayOfTypeVariable.length != paramArrayOfsh.length) {
            throw new IllegalArgumentException("Parameter type mismatch for " + paramClass.getName() + ": expected " + arrayOfTypeVariable.length + " parameters, was given " + paramArrayOfsh.length);
        }
        String[] arrayOfString = new String[arrayOfTypeVariable.length];
        int i = 0;
        int j = arrayOfTypeVariable.length;
        while (i < j) {
            arrayOfString[i] = arrayOfTypeVariable[i].getName();
            i += 1;
        }
        return new qp(paramClass, arrayOfString, paramArrayOfsh, null, null);
    }

    protected sh a(GenericArrayType paramGenericArrayType, qr paramqr) {
        return qi.a(b(paramGenericArrayType.getGenericComponentType(), paramqr), null, null);
    }

    protected sh a(ParameterizedType paramParameterizedType, qr paramqr) {
        Class localClass = (Class) paramParameterizedType.getRawType();
        Type[] arrayOfType = paramParameterizedType.getActualTypeArguments();
        if (arrayOfType == null) {
        }
        for (int i = 0; i == 0; i = arrayOfType.length) {
            paramParameterizedType = f;
            if (!Map.class.isAssignableFrom(localClass)) {
                break label174;
            }
            paramParameterizedType = b(a(localClass, paramParameterizedType), Map.class);
            if (paramParameterizedType.length == 2) {
                break label162;
            }
            throw new IllegalArgumentException("Could not find 2 type parameters for Map class " + localClass.getName() + " (found " + paramParameterizedType.length + ")");
        }
        sh[] arrayOfsh = new sh[i];
        int j = 0;
        for (; ; ) {
            paramParameterizedType = arrayOfsh;
            if (j >= i) {
                break;
            }
            arrayOfsh[j] = b(arrayOfType[j], paramqr);
            j += 1;
        }
        label162:
        return qo.a(localClass, paramParameterizedType[0], paramParameterizedType[1]);
        label174:
        if (Collection.class.isAssignableFrom(localClass)) {
            paramParameterizedType = b(a(localClass, paramParameterizedType), Collection.class);
            if (paramParameterizedType.length != 1) {
                throw new IllegalArgumentException("Could not find 1 type parameter for Collection class " + localClass.getName() + " (found " + paramParameterizedType.length + ")");
            }
            return ql.a(localClass, paramParameterizedType[0]);
        }
        if (i == 0) {
            return new qp(localClass);
        }
        return a(localClass, paramParameterizedType);
    }

    public sh a(Type paramType) {
        return b(paramType, null);
    }

    public sh a(Type paramType, qr paramqr) {
        return b(paramType, paramqr);
    }

    protected sh a(TypeVariable<?> paramTypeVariable, qr paramqr) {
        Object localObject;
        if (paramqr == null) {
            localObject = c();
        }
        String str;
        sh localsh;
        do {
            return (sh) localObject;
            str = paramTypeVariable.getName();
            localsh = paramqr.a(str);
            localObject = localsh;
        } while (localsh != null);
        paramTypeVariable = paramTypeVariable.getBounds();
        paramqr.b(str);
        return b(paramTypeVariable[0], paramqr);
    }

    protected sh a(WildcardType paramWildcardType, qr paramqr) {
        return b(paramWildcardType.getUpperBounds()[0], paramqr);
    }

    public sh[] a(Class<?> paramClass1, Class<?> paramClass2) {
        return a(paramClass1, paramClass2, new qr(this, paramClass1));
    }

    public sh[] a(Class<?> paramClass1, Class<?> paramClass2, qr paramqr) {
        Object localObject2 = c(paramClass1, paramClass2);
        Object localObject1 = localObject2;
        if (localObject2 == null) {
            throw new IllegalArgumentException("Class " + paramClass1.getName() + " is not a subtype of " + paramClass2.getName());
        }
        for (; ; ) {
            paramqr = paramClass1;
            if (((qm) localObject1).b() == null) {
                break;
            }
            localObject1 = ((qm) localObject1).b();
            localObject2 = ((qm) localObject1).e();
            paramClass1 = new qr(this, (Class) localObject2);
            if (((qm) localObject1).c()) {
                paramClass2 = ((qm) localObject1).d().getActualTypeArguments();
                localObject2 = ((Class) localObject2).getTypeParameters();
                int j = paramClass2.length;
                int i = 0;
                while (i < j) {
                    paramClass1.a(localObject2[i].getName(), a.b(paramClass2[i], paramqr));
                    i += 1;
                }
            }
        }
        if (!((qm) localObject1).c()) {
            return null;
        }
        return paramqr.b();
    }

    public ql b(Class<? extends Collection> paramClass, Class<?> paramClass1) {
        return ql.a(paramClass, a(paramClass1));
    }

    protected qm b(qm paramqm) {
        try {
            if (this.e == null) {
                localqm = paramqm.a();
                a(localqm, List.class);
                this.e = localqm.b();
            }
            qm localqm = this.e.a();
            paramqm.a(localqm);
            localqm.b(paramqm);
            return paramqm;
        } finally {
        }
    }

    protected qm b(Type paramType, Class<?> paramClass) {
        qm localqm = new qm(paramType);
        Class localClass = localqm.e();
        if (localClass == paramClass) {
            return new qm(paramType);
        }
        if ((localClass == HashMap.class) && (paramClass == Map.class)) {
            return a(localqm);
        }
        if ((localClass == ArrayList.class) && (paramClass == List.class)) {
            return b(localqm);
        }
        return a(localqm, paramClass);
    }

    public sh b(String paramString)
            throws IllegalArgumentException {
        return this.c.a(paramString);
    }

    public sh b(Type paramType, qr paramqr) {
        Object localObject2;
        Object localObject1;
        if ((paramType instanceof Class)) {
            localObject2 = (Class) paramType;
            localObject1 = paramqr;
            if (paramqr == null) {
                localObject1 = new qr(this, (Class) localObject2);
            }
            localObject2 = a((Class) localObject2, (qr) localObject1);
            paramqr = (qr) localObject1;
            localObject1 = localObject2;
        }
        for (; ; ) {
            localObject2 = localObject1;
            if (this.b == null) {
                break label231;
            }
            localObject2 = localObject1;
            if (((sh) localObject1).f()) {
                break label231;
            }
            qt[] arrayOfqt = this.b;
            int j = arrayOfqt.length;
            int i = 0;
            for (; ; ) {
                localObject2 = localObject1;
                if (i >= j) {
                    break;
                }
                localObject1 = arrayOfqt[i].a((sh) localObject1, paramType, paramqr, this);
                i += 1;
            }
            if ((paramType instanceof ParameterizedType)) {
                localObject1 = a((ParameterizedType) paramType, paramqr);
            } else if ((paramType instanceof GenericArrayType)) {
                localObject1 = a((GenericArrayType) paramType, paramqr);
            } else if ((paramType instanceof TypeVariable)) {
                localObject1 = a((TypeVariable) paramType, paramqr);
            } else {
                if (!(paramType instanceof WildcardType)) {
                    break;
                }
                localObject1 = a((WildcardType) paramType, paramqr);
            }
        }
        throw new IllegalArgumentException("Unrecognized Type: " + paramType.toString());
        label231:
        return (sh) localObject2;
    }

    public sh[] b(sh paramsh, Class<?> paramClass) {
        Object localObject = paramsh.p();
        if (localObject == paramClass) {
            int j = paramsh.h();
            if (j == 0) {
                paramClass = null;
                return paramClass;
            }
            localObject = new sh[j];
            int i = 0;
            for (; ; ) {
                paramClass = (Class<?>) localObject;
                if (i >= j) {
                    break;
                }
                localObject[i] = paramsh.b(i);
                i += 1;
            }
        }
        return a((Class) localObject, paramClass, new qr(this, paramsh));
    }

    protected qm c(Class<?> paramClass1, Class<?> paramClass2) {
        if (paramClass2.isInterface()) {
            return b(paramClass1, paramClass2);
        }
        return a(paramClass1, paramClass2);
    }

    protected sh c() {
        return new qp(Object.class);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/qs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */