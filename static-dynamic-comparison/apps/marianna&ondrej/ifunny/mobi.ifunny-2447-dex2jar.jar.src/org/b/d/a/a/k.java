package org.b.d.a.a;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class k
        extends d {
    boolean h;
    boolean i;
    private Method j;
    private Method k;
    private Class<?> l;

    public k(String paramString, Method paramMethod1, Method paramMethod2) {
        if ((paramString == null) || (paramString.length() == 0)) {
            throw new f(org.a.a.a.a.a.a.a("custom.beans.04"));
        }
        a(paramString);
        d(paramMethod1);
        c(paramMethod2);
    }

    public void a(boolean paramBoolean) {
        this.h = paramBoolean;
    }

    public void b(boolean paramBoolean) {
        this.i = paramBoolean;
    }

    public void c(Method paramMethod) {
        if (paramMethod != null) {
            if (!Modifier.isPublic(paramMethod.getModifiers())) {
                throw new f(org.a.a.a.a.a.a.a("custom.beans.05"));
            }
            Object localObject = paramMethod.getParameterTypes();
            if (localObject.length != 1) {
                throw new f(org.a.a.a.a.a.a.a("custom.beans.06"));
            }
            localObject = localObject[0];
            Class localClass = h();
            if ((localClass != null) && (!localClass.equals(localObject))) {
                throw new f(org.a.a.a.a.a.a.a("custom.beans.07"));
            }
        }
        this.k = paramMethod;
    }

    public void d(Method paramMethod) {
        if (paramMethod != null) {
            if (!Modifier.isPublic(paramMethod.getModifiers())) {
                throw new f(org.a.a.a.a.a.a.a("custom.beans.0A"));
            }
            if (paramMethod.getParameterTypes().length != 0) {
                throw new f(org.a.a.a.a.a.a.a("custom.beans.08"));
            }
            Class localClass1 = paramMethod.getReturnType();
            if (localClass1.equals(Void.TYPE)) {
                throw new f(org.a.a.a.a.a.a.a("custom.beans.33"));
            }
            Class localClass2 = h();
            if ((localClass2 != null) && (!localClass1.equals(localClass2))) {
                throw new f(org.a.a.a.a.a.a.a("custom.beans.09"));
            }
        }
        this.j = paramMethod;
    }

    public boolean equals(Object paramObject) {
        boolean bool = paramObject instanceof k;
        if (bool) {
            paramObject = (k) paramObject;
            int m;
            int n;
            label90:
            int i1;
            label104:
            int i2;
            label118:
            int i3;
            if (((this.j == null) && (((k) paramObject).g() == null)) || ((this.j != null) && (this.j.equals(((k) paramObject).g())))) {
                m = 1;
                if (((this.k != null) || (((k) paramObject).f() != null)) && ((this.k == null) || (!this.k.equals(((k) paramObject).f())))) {
                    break label181;
                }
                n = 1;
                if (h() != ((k) paramObject).h()) {
                    break label186;
                }
                i1 = 1;
                if (i() != ((k) paramObject).i()) {
                    break label192;
                }
                i2 = 1;
                if (k() != ((k) paramObject).k()) {
                    break label198;
                }
                i3 = 1;
                label132:
                if (j() != ((k) paramObject).j()) {
                    break label204;
                }
            }
            label181:
            label186:
            label192:
            label198:
            label204:
            for (int i4 = 1; ; i4 = 0) {
                if ((m == 0) || (n == 0) || (i1 == 0) || (i2 == 0) || (i3 == 0) || (i4 == 0)) {
                    break label210;
                }
                return true;
                m = 0;
                break;
                n = 0;
                break label90;
                i1 = 0;
                break label104;
                i2 = 0;
                break label118;
                i3 = 0;
                break label132;
            }
            label210:
            return false;
        }
        return bool;
    }

    public Method f() {
        return this.k;
    }

    public Method g() {
        return this.j;
    }

    public Class<?> h() {
        Class localClass = null;
        if (this.j != null) {
            localClass = this.j.getReturnType();
        }
        while (this.k == null) {
            return localClass;
        }
        return this.k.getParameterTypes()[0];
    }

    public int hashCode() {
        return org.a.a.a.a.a(this.j) + org.a.a.a.a.a(this.k) + org.a.a.a.a.a(h()) + org.a.a.a.a.a(i()) + org.a.a.a.a.a(k()) + org.a.a.a.a.a(j());
    }

    public Class<?> i() {
        return this.l;
    }

    public boolean j() {
        return this.h;
    }

    public boolean k() {
        return this.i;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/org/b/d/a/a/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */