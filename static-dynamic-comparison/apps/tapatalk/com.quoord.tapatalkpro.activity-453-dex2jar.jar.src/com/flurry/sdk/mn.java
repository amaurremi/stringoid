package com.flurry.sdk;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class mn
        extends mm {
    private static final mv[] l = new mv[0];
    protected final Class<?> a;
    protected final List<Class<?>> b;
    protected final iq c;
    protected final iu.a d;
    protected final Class<?> e;
    protected mv f;
    protected mo g;
    protected List<mo> h;
    protected List<mr> i;
    protected ms j;
    protected List<mp> k;

    private mn(Class<?> paramClass, List<Class<?>> paramList, iq paramiq, iu.a parama, mv parammv) {
        this.a = paramClass;
        this.b = paramList;
        this.c = paramiq;
        this.d = parama;
        if (this.d == null) {
        }
        for (paramClass = null; ; paramClass = this.d.a(this.a)) {
            this.e = paramClass;
            this.f = parammv;
            return;
        }
    }

    public static mn a(Class<?> paramClass, iq paramiq, iu.a parama) {
        paramClass = new mn(paramClass, qy.a(paramClass, null), paramiq, parama, null);
        paramClass.m();
        return paramClass;
    }

    private mv[] a(int paramInt) {
        Object localObject;
        if (paramInt == 0) {
            localObject = l;
            return (mv[]) localObject;
        }
        mv[] arrayOfmv = new mv[paramInt];
        int m = 0;
        for (; ; ) {
            localObject = arrayOfmv;
            if (m >= paramInt) {
                break;
            }
            arrayOfmv[m] = o();
            m += 1;
        }
    }

    public static mn b(Class<?> paramClass, iq paramiq, iu.a parama) {
        paramClass = new mn(paramClass, Collections.emptyList(), paramiq, parama, null);
        paramClass.m();
        return paramClass;
    }

    private boolean b(Field paramField) {
        if (paramField.isSynthetic()) {
        }
        int m;
        do {
            return false;
            m = paramField.getModifiers();
        } while ((Modifier.isStatic(m)) || (Modifier.isTransient(m)));
        return true;
    }

    private mv o() {
        return new mv();
    }

    protected mo a(Constructor<?> paramConstructor, boolean paramBoolean) {
        if (this.c == null) {
            return new mo(paramConstructor, o(), a(paramConstructor.getParameterTypes().length));
        }
        if (paramBoolean) {
            return new mo(paramConstructor, a(paramConstructor.getDeclaredAnnotations()), null);
        }
        Object localObject2 = paramConstructor.getParameterAnnotations();
        int m = paramConstructor.getParameterTypes().length;
        Object localObject1;
        Object localObject3;
        if (m != localObject2.length) {
            localObject1 = paramConstructor.getDeclaringClass();
            if ((((Class) localObject1).isEnum()) && (m == localObject2.length + 2)) {
                localObject1 = new Annotation[localObject2.length + 2][];
                System.arraycopy(localObject2, 0, localObject1, 2, localObject2.length);
                localObject3 = a((Annotation[][]) localObject1);
                localObject2 = localObject1;
                localObject1 = localObject3;
            }
        }
        for (; ; ) {
            localObject3 = localObject1;
            if (localObject1 == null) {
                throw new IllegalStateException("Internal error: constructor for " + paramConstructor.getDeclaringClass().getName() + " has mismatch: " + m + " parameters; " + localObject2.length + " sets of annotations");
                if ((((Class) localObject1).isMemberClass()) && (m == localObject2.length + 1)) {
                    localObject3 = new Annotation[localObject2.length + 1][];
                    System.arraycopy(localObject2, 0, localObject3, 1, localObject2.length);
                    localObject1 = a((Annotation[][]) localObject3);
                    localObject2 = localObject3;
                    continue;
                    localObject3 = a((Annotation[][]) localObject2);
                }
            } else {
                return new mo(paramConstructor, a(paramConstructor.getDeclaredAnnotations()), (mv[]) localObject3);
            }
            localObject1 = null;
        }
    }

    protected mp a(Field paramField) {
        if (this.c == null) {
            return new mp(paramField, o());
        }
        return new mp(paramField, a(paramField.getDeclaredAnnotations()));
    }

    public mr a(String paramString, Class<?>[] paramArrayOfClass) {
        return this.j.a(paramString, paramArrayOfClass);
    }

    protected mr a(Method paramMethod) {
        if (this.c == null) {
            return new mr(paramMethod, o(), null);
        }
        return new mr(paramMethod, a(paramMethod.getDeclaredAnnotations()), null);
    }

    protected mv a(Annotation[] paramArrayOfAnnotation) {
        mv localmv = new mv();
        if (paramArrayOfAnnotation != null) {
            int n = paramArrayOfAnnotation.length;
            int m = 0;
            while (m < n) {
                Annotation localAnnotation = paramArrayOfAnnotation[m];
                if (this.c.a(localAnnotation)) {
                    localmv.b(localAnnotation);
                }
                m += 1;
            }
        }
        return localmv;
    }

    public <A extends Annotation> A a(Class<A> paramClass) {
        if (this.f == null) {
            return null;
        }
        return this.f.a(paramClass);
    }

    protected void a(mv parammv, Class<?> paramClass) {
        if (this.d != null) {
            a(parammv, paramClass, this.d.a(paramClass));
        }
    }

    protected void a(mv parammv, Class<?> paramClass1, Class<?> paramClass2) {
        if (paramClass2 == null) {
            return;
        }
        Annotation[] arrayOfAnnotation = paramClass2.getDeclaredAnnotations();
        int n = arrayOfAnnotation.length;
        int m = 0;
        while (m < n) {
            Annotation localAnnotation = arrayOfAnnotation[m];
            if (this.c.a(localAnnotation)) {
                parammv.a(localAnnotation);
            }
            m += 1;
        }
        paramClass1 = qy.a(paramClass2, paramClass1).iterator();
        while (paramClass1.hasNext()) {
            paramClass2 = ((Class) paramClass1.next()).getDeclaredAnnotations();
            n = paramClass2.length;
            m = 0;
            while (m < n) {
                arrayOfAnnotation = paramClass2[m];
                if (this.c.a(arrayOfAnnotation)) {
                    parammv.a(arrayOfAnnotation);
                }
                m += 1;
            }
        }
    }

    public void a(na paramna) {
        this.j = new ms();
        Object localObject2 = new ms();
        a(this.a, paramna, this.j, this.e, (ms) localObject2);
        Iterator localIterator = this.b.iterator();
        Object localObject1;
        if (localIterator.hasNext()) {
            Class localClass = (Class) localIterator.next();
            if (this.d == null) {
            }
            for (localObject1 = null; ; localObject1 = this.d.a(localClass)) {
                a(localClass, paramna, this.j, (Class) localObject1, (ms) localObject2);
                break;
            }
        }
        if (this.d != null) {
            localObject1 = this.d.a(Object.class);
            if (localObject1 != null) {
                a(paramna, this.j, (Class) localObject1, (ms) localObject2);
            }
        }
        if ((this.c != null) && (!((ms) localObject2).a())) {
            paramna = ((ms) localObject2).iterator();
            while (paramna.hasNext()) {
                localObject1 = (mr) paramna.next();
                try {
                    localObject2 = Object.class.getDeclaredMethod(((mr) localObject1).b(), ((mr) localObject1).m());
                    if (localObject2 != null) {
                        localObject2 = a((Method) localObject2);
                        a(((mr) localObject1).e(), (mr) localObject2, false);
                        this.j.a((mr) localObject2);
                    }
                } catch (Exception localException) {
                }
            }
        }
    }

    protected void a(na paramna, ms paramms1, Class<?> paramClass, ms paramms2) {
        paramClass = paramClass.getDeclaredMethods();
        int n = paramClass.length;
        int m = 0;
        if (m < n) {
            Method localMethod = paramClass[m];
            if (!a(localMethod, paramna)) {
            }
            for (; ; ) {
                m += 1;
                break;
                mr localmr = paramms1.b(localMethod);
                if (localmr != null) {
                    a(localMethod, localmr);
                } else {
                    paramms2.a(a(localMethod));
                }
            }
        }
    }

    protected void a(Class<?> paramClass1, na paramna, ms paramms1, Class<?> paramClass2, ms paramms2) {
        if (paramClass2 != null) {
            a(paramna, paramms1, paramClass2, paramms2);
        }
        if (paramClass1 == null) {
            return;
        }
        paramClass1 = paramClass1.getDeclaredMethods();
        int n = paramClass1.length;
        int m = 0;
        label32:
        if (m < n) {
            paramClass2 = paramClass1[m];
            if (a(paramClass2, paramna)) {
                break label64;
            }
        }
        for (; ; ) {
            m += 1;
            break label32;
            break;
            label64:
            mr localmr = paramms1.b(paramClass2);
            if (localmr == null) {
                localmr = a(paramClass2);
                paramms1.a(localmr);
                paramClass2 = paramms2.a(paramClass2);
                if (paramClass2 != null) {
                    a(paramClass2.e(), localmr, false);
                }
            } else {
                a(paramClass2, localmr);
                if ((localmr.h().isInterface()) && (!paramClass2.getDeclaringClass().isInterface())) {
                    paramms1.a(localmr.a(paramClass2));
                }
            }
        }
    }

    protected void a(Class<?> paramClass, Map<String, mp> paramMap) {
        paramClass = paramClass.getDeclaredFields();
        int i1 = paramClass.length;
        int m = 0;
        if (m < i1) {
            Object localObject = paramClass[m];
            if (!b((Field) localObject)) {
            }
            for (; ; ) {
                m += 1;
                break;
                mp localmp = (mp) paramMap.get(((Field) localObject).getName());
                if (localmp != null) {
                    localObject = ((Field) localObject).getDeclaredAnnotations();
                    int i2 = localObject.length;
                    int n = 0;
                    while (n < i2) {
                        Annotation localAnnotation = localObject[n];
                        if (this.c.a(localAnnotation)) {
                            localmp.a(localAnnotation);
                        }
                        n += 1;
                    }
                }
            }
        }
    }

    protected void a(Constructor<?> paramConstructor, mo parammo, boolean paramBoolean) {
        Annotation[] arrayOfAnnotation = paramConstructor.getDeclaredAnnotations();
        int n = arrayOfAnnotation.length;
        int m = 0;
        while (m < n) {
            Annotation localAnnotation = arrayOfAnnotation[m];
            if (this.c.a(localAnnotation)) {
                parammo.a(localAnnotation);
            }
            m += 1;
        }
        if (paramBoolean) {
            paramConstructor = paramConstructor.getParameterAnnotations();
            int i1 = paramConstructor.length;
            m = 0;
            while (m < i1) {
                arrayOfAnnotation = paramConstructor[m];
                int i2 = arrayOfAnnotation.length;
                n = 0;
                while (n < i2) {
                    parammo.a(m, arrayOfAnnotation[n]);
                    n += 1;
                }
                m += 1;
            }
        }
    }

    protected void a(Method paramMethod, mr parammr) {
        paramMethod = paramMethod.getDeclaredAnnotations();
        int n = paramMethod.length;
        int m = 0;
        while (m < n) {
            Annotation localAnnotation = paramMethod[m];
            if (this.c.a(localAnnotation)) {
                parammr.b(localAnnotation);
            }
            m += 1;
        }
    }

    protected void a(Method paramMethod, mr parammr, boolean paramBoolean) {
        Annotation[] arrayOfAnnotation = paramMethod.getDeclaredAnnotations();
        int n = arrayOfAnnotation.length;
        int m = 0;
        while (m < n) {
            Annotation localAnnotation = arrayOfAnnotation[m];
            if (this.c.a(localAnnotation)) {
                parammr.a(localAnnotation);
            }
            m += 1;
        }
        if (paramBoolean) {
            paramMethod = paramMethod.getParameterAnnotations();
            int i1 = paramMethod.length;
            m = 0;
            while (m < i1) {
                arrayOfAnnotation = paramMethod[m];
                int i2 = arrayOfAnnotation.length;
                n = 0;
                while (n < i2) {
                    parammr.a(m, arrayOfAnnotation[n]);
                    n += 1;
                }
                m += 1;
            }
        }
    }

    protected void a(Map<String, mp> paramMap, Class<?> paramClass) {
        Object localObject = paramClass.getSuperclass();
        if (localObject != null) {
            a(paramMap, (Class) localObject);
            localObject = paramClass.getDeclaredFields();
            int n = localObject.length;
            int m = 0;
            if (m < n) {
                Field localField = localObject[m];
                if (!b(localField)) {
                }
                for (; ; ) {
                    m += 1;
                    break;
                    paramMap.put(localField.getName(), a(localField));
                }
            }
            if (this.d != null) {
                paramClass = this.d.a(paramClass);
                if (paramClass != null) {
                    a(paramClass, paramMap);
                }
            }
        }
    }

    public void a(boolean paramBoolean) {
        this.h = null;
        Object localObject = this.a.getDeclaredConstructors();
        int n = localObject.length;
        int m = 0;
        Constructor localConstructor;
        if (m < n) {
            localConstructor = localObject[m];
            if (localConstructor.getParameterTypes().length == 0) {
                this.g = a(localConstructor, true);
            }
            for (; ; ) {
                m += 1;
                break;
                if (paramBoolean) {
                    if (this.h == null) {
                        this.h = new ArrayList(Math.max(10, localObject.length));
                    }
                    this.h.add(a(localConstructor, false));
                }
            }
        }
        if ((this.e != null) && ((this.g != null) || (this.h != null))) {
            c(this.e);
        }
        if (this.c != null) {
            if ((this.g != null) && (this.c.a(this.g))) {
                this.g = null;
            }
            if (this.h != null) {
                m = this.h.size();
            }
        }
        for (; ; ) {
            m -= 1;
            if (m >= 0) {
                if (this.c.a((mo) this.h.get(m))) {
                    this.h.remove(m);
                }
            } else {
                this.i = null;
                if (paramBoolean) {
                    localObject = this.a.getDeclaredMethods();
                    n = localObject.length;
                    m = 0;
                    if (m < n) {
                        localConstructor = localObject[m];
                        if (!Modifier.isStatic(localConstructor.getModifiers())) {
                        }
                        for (; ; ) {
                            m += 1;
                            break;
                            if (localConstructor.getParameterTypes().length >= 1) {
                                if (this.i == null) {
                                    this.i = new ArrayList(8);
                                }
                                this.i.add(b(localConstructor));
                            }
                        }
                    }
                    if ((this.e != null) && (this.i != null)) {
                        d(this.e);
                    }
                    if ((this.c != null) && (this.i != null)) {
                        m = this.i.size();
                    }
                }
                for (; ; ) {
                    m -= 1;
                    if (m >= 0) {
                        if (this.c.a((mr) this.i.get(m))) {
                            this.i.remove(m);
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    }

    protected boolean a(Method paramMethod, na paramna) {
        if ((paramna != null) && (!paramna.a(paramMethod))) {
        }
        while ((paramMethod.isSynthetic()) || (paramMethod.isBridge())) {
            return false;
        }
        return true;
    }

    protected mv[] a(Annotation[][] paramArrayOfAnnotation) {
        int n = paramArrayOfAnnotation.length;
        mv[] arrayOfmv = new mv[n];
        int m = 0;
        while (m < n) {
            arrayOfmv[m] = a(paramArrayOfAnnotation[m]);
            m += 1;
        }
        return arrayOfmv;
    }

    protected mr b(Method paramMethod) {
        if (this.c == null) {
            return new mr(paramMethod, o(), a(paramMethod.getParameterTypes().length));
        }
        return new mr(paramMethod, a(paramMethod.getDeclaredAnnotations()), a(paramMethod.getParameterAnnotations()));
    }

    public String b() {
        return this.a.getName();
    }

    public Type c() {
        return this.a;
    }

    protected void c(Class<?> paramClass) {
        int m;
        int n;
        label24:
        Constructor localConstructor;
        Object localObject;
        if (this.h == null) {
            m = 0;
            Constructor[] arrayOfConstructor = paramClass.getDeclaredConstructors();
            int i2 = arrayOfConstructor.length;
            n = 0;
            paramClass = null;
            if (n >= i2) {
                break label220;
            }
            localConstructor = arrayOfConstructor[n];
            if (localConstructor.getParameterTypes().length != 0) {
                break label92;
            }
            localObject = paramClass;
            if (this.g != null) {
                a(localConstructor, this.g, false);
                localObject = paramClass;
            }
        }
        for (; ; ) {
            n += 1;
            paramClass = (Class<?>) localObject;
            break label24;
            m = this.h.size();
            break;
            label92:
            if (paramClass == null) {
                localObject = new mz[m];
                i1 = 0;
                for (; ; ) {
                    paramClass = (Class<?>) localObject;
                    if (i1 >= m) {
                        break;
                    }
                    localObject[i1] = new mz(((mo) this.h.get(i1)).e());
                    i1 += 1;
                }
            }
            localObject = new mz(localConstructor);
            int i1 = 0;
            for (; ; ) {
                if (i1 < m) {
                    if (!((mz) localObject).equals(paramClass[i1])) {
                        i1 += 1;
                    } else {
                        a(localConstructor, (mo) this.h.get(i1), true);
                        localObject = paramClass;
                        break;
                        label220:
                        return;
                    }
                }
            }
            localObject = paramClass;
        }
    }

    public Class<?> d() {
        return this.a;
    }

    protected void d(Class<?> paramClass) {
        Object localObject = null;
        int i1 = this.i.size();
        Method[] arrayOfMethod = paramClass.getDeclaredMethods();
        int i2 = arrayOfMethod.length;
        int m = 0;
        paramClass = (Class<?>) localObject;
        Method localMethod;
        if (m < i2) {
            localMethod = arrayOfMethod[m];
            if (!Modifier.isStatic(localMethod.getModifiers())) {
                localObject = paramClass;
            }
        }
        for (; ; ) {
            m += 1;
            paramClass = (Class<?>) localObject;
            break;
            localObject = paramClass;
            if (localMethod.getParameterTypes().length != 0) {
                if (paramClass == null) {
                    localObject = new mz[i1];
                    n = 0;
                    for (; ; ) {
                        paramClass = (Class<?>) localObject;
                        if (n >= i1) {
                            break;
                        }
                        localObject[n] = new mz(((mr) this.i.get(n)).e());
                        n += 1;
                    }
                }
                localObject = new mz(localMethod);
                int n = 0;
                for (; ; ) {
                    if (n < i1) {
                        if (!((mz) localObject).equals(paramClass[n])) {
                            n += 1;
                        } else {
                            a(localMethod, (mr) this.i.get(n), true);
                            localObject = paramClass;
                            break;
                            return;
                        }
                    }
                }
                localObject = paramClass;
            }
        }
    }

    public Class<?> e() {
        return this.a;
    }

    public qv f() {
        return this.f;
    }

    public boolean g() {
        return this.f.a() > 0;
    }

    public mo h() {
        return this.g;
    }

    public List<mo> i() {
        if (this.h == null) {
            return Collections.emptyList();
        }
        return this.h;
    }

    public List<mr> j() {
        if (this.i == null) {
            return Collections.emptyList();
        }
        return this.i;
    }

    public Iterable<mr> k() {
        return this.j;
    }

    public Iterable<mp> l() {
        if (this.k == null) {
            return Collections.emptyList();
        }
        return this.k;
    }

    public void m() {
        this.f = new mv();
        if (this.c == null) {
            return;
        }
        if (this.e != null) {
            a(this.f, this.a, this.e);
        }
        Object localObject1 = this.a.getDeclaredAnnotations();
        int n = localObject1.length;
        int m = 0;
        Object localObject2;
        while (m < n) {
            localObject2 = localObject1[m];
            if (this.c.a((Annotation) localObject2)) {
                this.f.a((Annotation) localObject2);
            }
            m += 1;
        }
        localObject1 = this.b.iterator();
        while (((Iterator) localObject1).hasNext()) {
            localObject2 = (Class) ((Iterator) localObject1).next();
            a(this.f, (Class) localObject2);
            localObject2 = ((Class) localObject2).getDeclaredAnnotations();
            n = localObject2.length;
            m = 0;
            while (m < n) {
                Annotation localAnnotation = localObject2[m];
                if (this.c.a(localAnnotation)) {
                    this.f.a(localAnnotation);
                }
                m += 1;
            }
        }
        a(this.f, Object.class);
    }

    public void n() {
        LinkedHashMap localLinkedHashMap = new LinkedHashMap();
        a(localLinkedHashMap, this.a);
        if (localLinkedHashMap.isEmpty()) {
            this.k = Collections.emptyList();
            return;
        }
        this.k = new ArrayList(localLinkedHashMap.size());
        this.k.addAll(localLinkedHashMap.values());
    }

    public String toString() {
        return "[AnnotedClass " + this.a.getName() + "]";
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/mn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */