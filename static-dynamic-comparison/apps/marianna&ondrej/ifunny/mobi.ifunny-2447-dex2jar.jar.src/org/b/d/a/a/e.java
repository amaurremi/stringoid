package org.b.d.a.a;

import java.lang.reflect.Method;

public class e
        extends k {
    private Class<?> j;
    private Method k;
    private Method l;

    public e(String paramString, Method paramMethod1, Method paramMethod2, Method paramMethod3, Method paramMethod4) {
        super(paramString, paramMethod1, paramMethod2);
        if (paramMethod3 != null) {
            e(paramMethod3);
            a(paramMethod4, true);
        }
        while (!l()) {
            throw new f(org.a.a.a.a.a.a.a("custom.beans.57"));
            a(paramMethod4, true);
            e(paramMethod3);
        }
    }

    private void a(Method paramMethod, boolean paramBoolean) {
        if (paramMethod == null) {
            if (this.k == null) {
                if (h() != null) {
                    throw new f(org.a.a.a.a.a.a.a("custom.beans.5E"));
                }
                this.j = null;
            }
            this.l = null;
            return;
        }
        Object localObject = paramMethod.getParameterTypes();
        if (localObject.length != 2) {
            throw new f(org.a.a.a.a.a.a.a("custom.beans.5F"));
        }
        if (localObject[0] != Integer.TYPE) {
            throw new f(org.a.a.a.a.a.a.a("custom.beans.60"));
        }
        localObject = localObject[1];
        if ((paramBoolean) && (this.k == null)) {
            this.j = ((Class) localObject);
        }
        while (this.j == localObject) {
            this.l = paramMethod;
            return;
        }
        throw new f(org.a.a.a.a.a.a.a("custom.beans.61"));
    }

    private void e(Method paramMethod) {
        if (paramMethod == null) {
            if (this.l == null) {
                if (h() != null) {
                    throw new f(org.a.a.a.a.a.a.a("custom.beans.5A"));
                }
                this.j = null;
            }
            this.k = null;
            return;
        }
        if ((paramMethod.getParameterTypes().length != 1) || (paramMethod.getParameterTypes()[0] != Integer.TYPE)) {
            throw new f(org.a.a.a.a.a.a.a("custom.beans.5B"));
        }
        Class localClass = paramMethod.getReturnType();
        if (localClass == Void.TYPE) {
            throw new f(org.a.a.a.a.a.a.a("custom.beans.5B"));
        }
        if ((this.l != null) && (paramMethod.getReturnType() != this.l.getParameterTypes()[1])) {
            throw new f(org.a.a.a.a.a.a.a("custom.beans.5A"));
        }
        if (this.k == null) {
            this.j = localClass;
        }
        while (this.j == localClass) {
            this.k = paramMethod;
            return;
        }
        throw new f(org.a.a.a.a.a.a.a("custom.beans.5A"));
    }

    private boolean l() {
        boolean bool2 = false;
        Class localClass = h();
        boolean bool1;
        if (localClass == null) {
            bool1 = true;
        }
        do {
            do {
                return bool1;
                localClass = localClass.getComponentType();
                bool1 = bool2;
            } while (localClass == null);
            bool1 = bool2;
        } while (this.j == null);
        return localClass.getName().equals(this.j.getName());
    }

    public Method a() {
        return this.l;
    }

    public void a(Method paramMethod) {
        e(paramMethod);
    }

    public void b(Method paramMethod) {
        a(paramMethod, false);
    }

    public Method d() {
        return this.k;
    }

    public Class<?> e() {
        return this.j;
    }

    public boolean equals(Object paramObject) {
        if (!(paramObject instanceof e)) {
        }
        label36:
        label50:
        do {
            do {
                do {
                    do {
                        return false;
                        paramObject = (e) paramObject;
                    } while (!super.equals(paramObject));
                    if (this.j != null) {
                        break;
                    }
                } while (((e) paramObject).j != null);
                if (this.k != null) {
                    break label83;
                }
            } while (((e) paramObject).k != null);
            if (this.l != null) {
                break label100;
            }
        } while (((e) paramObject).l != null);
        for (; ; ) {
            return true;
            if (!this.j.equals(((e) paramObject).j)) {
                break;
            }
            break label36;
            label83:
            if (!this.k.equals(((e) paramObject).k)) {
                break;
            }
            break label50;
            label100:
            if (!this.l.equals(((e) paramObject).l)) {
                break;
            }
        }
    }

    public int hashCode() {
        return super.hashCode() + org.a.a.a.a.a(this.j) + org.a.a.a.a.a(this.k) + org.a.a.a.a.a(this.l);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/org/b/d/a/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */