package com.flurry.sdk;

import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public final class mv
        implements qv {
    protected HashMap<Class<? extends Annotation>, Annotation> a;

    public mv() {
    }

    private mv(HashMap<Class<? extends Annotation>, Annotation> paramHashMap) {
        this.a = paramHashMap;
    }

    public static mv a(mv parammv1, mv parammv2) {
        if ((parammv1 == null) || (parammv1.a == null) || (parammv1.a.isEmpty())) {
            localObject = parammv2;
        }
        do {
            do {
                do {
                    return (mv) localObject;
                    localObject = parammv1;
                } while (parammv2 == null);
                localObject = parammv1;
            } while (parammv2.a == null);
            localObject = parammv1;
        } while (parammv2.a.isEmpty());
        Object localObject = new HashMap();
        parammv2 = parammv2.a.values().iterator();
        while (parammv2.hasNext()) {
            Annotation localAnnotation = (Annotation) parammv2.next();
            ((HashMap) localObject).put(localAnnotation.annotationType(), localAnnotation);
        }
        parammv1 = parammv1.a.values().iterator();
        while (parammv1.hasNext()) {
            parammv2 = (Annotation) parammv1.next();
            ((HashMap) localObject).put(parammv2.annotationType(), parammv2);
        }
        return new mv((HashMap) localObject);
    }

    public int a() {
        if (this.a == null) {
            return 0;
        }
        return this.a.size();
    }

    public <A extends Annotation> A a(Class<A> paramClass) {
        if (this.a == null) {
            return null;
        }
        return (Annotation) this.a.get(paramClass);
    }

    public void a(Annotation paramAnnotation) {
        if ((this.a == null) || (!this.a.containsKey(paramAnnotation.annotationType()))) {
            c(paramAnnotation);
        }
    }

    public void b(Annotation paramAnnotation) {
        c(paramAnnotation);
    }

    protected final void c(Annotation paramAnnotation) {
        if (this.a == null) {
            this.a = new HashMap();
        }
        this.a.put(paramAnnotation.annotationType(), paramAnnotation);
    }

    public String toString() {
        if (this.a == null) {
            return "[null]";
        }
        return this.a.toString();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/mv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */